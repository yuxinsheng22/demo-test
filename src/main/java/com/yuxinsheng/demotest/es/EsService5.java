package com.yuxinsheng.demotest.es;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.joda.time.DateTime;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class EsService5 {

    public static void main(String[] args) {
//        createIndex();

//        EsTest test1 = new EsTest("1001", "小明", 20, "小明 is alb bce ak", new Date().getTime());
//        EsTest test2 = new EsTest("1002", "小张", 21, "小张 id  ds sadk asda acd", new DateTime().minusDays(1).toDate().getTime());
//        EsTest test3 = new EsTest("1003", "小花", 22, "小花 dak adka akds ada as", new DateTime().minusDays(2).toDate().getTime());
//        EsTest test4 = new EsTest("1004", "王小", 23, "王小 ajd adja adaiwa adjas sad ads", new DateTime().minusDays(4).toDate().getTime());
//        EsTest test5 = new EsTest("1005", "花千骨", 24, "花千骨 als als aldkod adjma sad kal", new DateTime().minusDays(12).toDate().getTime());
//        EsTest test6 = new EsTest("1006", "王麻子", 25, "王麻子 l asld a sdkios asdm dac", new DateTime().minusDays(13).toDate().getTime());
//        EsTest test7 = new EsTest("1007", "麻雀", 26, "麻雀 akdld adklo adoa dala ad", new DateTime().minusDays(5).toDate().getTime());
//        List<EsTest> list = Lists.newArrayList(test1, test2, test3, test4, test5, test6, test7);
//        insertBatch(list);

        searchIndex();


    }

    private static RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(new HttpHost("172.16.25.155", 9200, "http")));

    private final static String test_index = "test_index";
    private final static String test_type = "test_type";

    public static void createIndex() {
        CreateIndexRequest index = new CreateIndexRequest(test_index);//创建索引
        //创建的每个索引都可以有与之关联的特定设置。
//        index.settings(Settings.builder()
//                .put("index.number_of_shards", 10)
//        );
        String source = "{\n" +
                "\t\"test_type\":{\n" +
                "\t\t\"properties\":{\n" +
                "\t\t\t\"userId\":{\"type\":\"text\"},\n" +
                "\t\t\t\"userName\":{\"type\":\"keyword\"},\n" +
                "\t\t\t\"userAge\":{\"type\":\"integer\"},\n" +
                "\t\t\t\"userDesc\":{\"type\":\"text\"},\n" +
                "\t\t\t\"createTime\":{\"type\":\"long\"}\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";

        index.mapping(test_type,//类型定义
                source,//类型映射，需要的是一个JSON字符串
                XContentType.JSON
        );
        try {
            esClient.indices().create(index, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void insertBatch(List<EsTest> tests) {
        BulkRequest bulkRequest = new BulkRequest();
        List<IndexRequest> requests = toIndexRequest(tests);
        for (IndexRequest indexRequest : requests) {
            bulkRequest.add(indexRequest);
        }
        try {
            esClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    private static List<IndexRequest> toIndexRequest(List<EsTest> tests) {
        Gson gson = new Gson();
        List<IndexRequest> requests = Lists.newArrayList();
        tests.forEach(t -> {
            IndexRequest indexRequest = new IndexRequest(test_index, test_type);
            indexRequest.source(gson.toJson(t), XContentType.JSON);
            requests.add(indexRequest);
        });
        return requests;
    }

    public static void searchIndex() {

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.from(0);
        sourceBuilder.size(2);

        sourceBuilder.sort(new FieldSortBuilder("userAge").order(SortOrder.DESC));


        sourceBuilder.fetchSource(new String[]{"userId", "userName", "userAge", "userDes", "createTime"}, null);
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();


        //查询字段设置
//        List<String> userNames = Lists.newArrayList("小明", "小张");
//        boolQueryBuilder.must(QueryBuilders.termsQuery("userName", userNames));

//        List<String> userIds = Lists.newArrayList("1001", "1002");
//        boolQueryBuilder.must(QueryBuilders.termsQuery("userId", userIds));


        //范围查询
//        boolQueryBuilder.must(
//                QueryBuilders.rangeQuery("userAge").from(21).to(24)
//        );

        sourceBuilder.query(boolQueryBuilder);
        //构建searchRequest
        SearchRequest request = new SearchRequest(test_index);//设置index
        request.types(test_type);
        //查询条件
        request.source(sourceBuilder);
        SearchResponse response;
        try {
            //查询
            response = esClient.search(request, RequestOptions.DEFAULT);
            SearchHits hits = response.getHits();

            List<EsTest> list = Lists.newArrayList();
            Gson gson = new Gson();
            for (SearchHit hit : hits) {
                Map<String, Object> source = hit.getSourceAsMap();
                source.put("_id", hit.getId());
                list.add(gson.fromJson(gson.toJson(source), EsTest.class));
            }
            System.out.println("totalPage===="+Math.ceil((double) hits.getTotalHits()/2));
            System.out.println(gson.toJson(list));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

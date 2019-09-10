package com.yuxinsheng.demotest.es;


import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpHost;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class ESUserAllService {

    private static RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(new HttpHost("172.16.25.155", 9200, "http")));

    /***********************************************索引本身操作(增删)********************************************/
    /**
     * 创建index
     */
    public static void createIndex() {
        CreateIndexRequest index = new CreateIndexRequest("user_index");//创建索引
        //创建的每个索引都可以有与之关联的特定设置。
        index.settings(Settings.builder()
                .put("index.number_of_shards", 10)
        );
        index.mapping("user_type",//类型定义
                "{\n" +
                        "  \"user_type\": {\n" +
                        "    \"properties\": {\n" +
                        "      \"user_id\": {\n" +
                        "        \"type\": \"long\"\n" +
                        "      },\n" +
                        "      \"user_name\": {\n" +
                        "        \"type\": \"text\"\n" +
                        "      },\n" +
                        "      \"user_age\": {\n" +
                        "        \"type\": \"integer\"\n" +
                        "      }\n" +
                        "    }\n" +
                        "  }\n" +
                        "}",//类型映射，需要的是一个JSON字符串
                XContentType.JSON
        );
        try {
            CreateIndexResponse createIndexResponse = esClient.indices().create(index, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 删除索引
     */
    public static void deleteIndex() {
        DeleteIndexRequest request = new DeleteIndexRequest(".kibana_1");//指定要删除的索引名称
        try {
            AcknowledgedResponse response = esClient.indices().delete(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 判断索引是否存在
     *
     * @param index 索引名称
     * @return
     */
    public static boolean isIndexExists(String index) {
        GetIndexRequest request = new GetIndexRequest();
        request.indices(index);
        request.local(false);
        request.humanReadable(true);
        boolean exists = false;
        try {
            exists = esClient.indices().exists(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return exists;
    }

    /********************************************索引数据操作(增删改查)*************************************************/

    /**
     * 查询index
     */
    public static void searchIndex() {

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//        sourceBuilder.from(1);
//        sourceBuilder.size(3);

        //查询字段设置
        sourceBuilder.fetchSource(new String[]{"user_id", "user_name", "user_age"}, null);

        //查询条件设置
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("user_name", "王二");
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        //单条件查询
        boolQueryBuilder.must(matchQueryBuilder);
        boolQueryBuilder.must().add(new MatchQueryBuilder("", ""));

//        MatchPhraseQueryBuilder matchPhraseQueryBuilder = QueryBuilders.matchPhraseQuery("user_name","张三");
        //多条件查询
//        boolQueryBuilder.should(QueryBuilders.matchPhraseQuery("user_name", "张三"));
//        boolQueryBuilder.should(QueryBuilders.matchPhraseQuery("user_name", "李四"));
//        boolQueryBuilder.should(QueryBuilders.matchPhraseQuery("user_age","20"));
//        boolQueryBuilder.mustNot(QueryBuilders.matchPhraseQuery("user_age", "18"));

        //范围查询
//        RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("user_age");
//        rangeQueryBuilder.gte(18);
//        rangeQueryBuilder.lte(20);
//        boolQueryBuilder.should(rangeQueryBuilder);

        //分词查询
//        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery(fieldKey,fieldValue).analyzer("ik_smart");

        //模糊查询
//        WildcardQueryBuilder wildcardQueryBuilder = QueryBuilders.wildcardQuery("user_name", "王");
//
//
//        boolQueryBuilder.must(wildcardQueryBuilder);

        sourceBuilder.query(boolQueryBuilder);


        //排序设置
//        sourceBuilder.sort(new ScoreSortBuilder().order(SortOrder.DESC));
        sourceBuilder.sort(new FieldSortBuilder("user_age").order(SortOrder.DESC));

        //构建searchRequest
        SearchRequest request = new SearchRequest("user_index");//设置index
        //查询条件
        request.source(sourceBuilder);
        //设置type
        request.types("user_type");
        SearchResponse response;
        try {
            //查询
            response = esClient.search(request, RequestOptions.DEFAULT);
            SearchHits hits = response.getHits();
            List<ESUser> users = Lists.newArrayList();
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss:SSS")
                    .create();
            for (SearchHit hit : hits) {
                Map source = hit.getSourceAsMap();
                ESUser user = gson.fromJson(gson.toJson(source), ESUser.class);
                user.set_id(hit.getId());
                users.add(user);
            }
            System.out.println(new Gson().toJson(users));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * getRequest方式查询
     */
    public static void getRequest() {
        GetRequest getRequest = new GetRequest("index_test", "type_test", "V_51vGsBbCHfXOwY96fH");
        try {
            GetResponse response = esClient.get(getRequest, RequestOptions.DEFAULT);
            Map<String, Object> map = response.getSource();
            System.out.println(new Gson().toJson(map));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * insert index
     */
    public static void insertIndex() {
        try {
            XContentBuilder builder = XContentFactory.jsonBuilder();
            builder.startObject();
            {
                builder.field("user_id", 1006);
                builder.field("user_name", "吃三明治");
                builder.field("user_age", 24);
            }
            builder.endObject();
            IndexRequest indexRequest = new IndexRequest("user_index", "user_type")
                    .source(builder);

            indexRequest.opType(DocWriteRequest.OpType.CREATE);//DocWriteRequest.OpType方式
            IndexResponse indexResponse = esClient.index(indexRequest, RequestOptions.DEFAULT);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 批量插入数据
     */
    public static void insertBatchIndex() {
        BulkRequest bulkRequest = new BulkRequest();
        List<IndexRequest> requests = generateRequests();
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

    private static List<IndexRequest> generateRequests() {
        List<IndexRequest> requests = Lists.newArrayList();
//        requests.add(generateDomainRequest(1000L, "张三", 18));
//        requests.add(generateDomainRequest(1001L, "李四", 19));
//        requests.add(generateDomainRequest(1002L, "王二", 20));
//        requests.add(generateDomainRequest(1003L, "麻子", 21));
//        requests.add(generateDomainRequest(1004L, "陈五", 22));
//        requests.add(generateDomainRequest(1004L, "马六", 22));
//        requests.add(generateDomainRequest(1004L, "马 化 腾", 35));
//        requests.add(generateDomainRequest(1007L, "Lama Sla", 28));
        requests.add(generateDomainRequest(1008L, "Lama Sla Ala", 29));
        requests.add(generateDomainRequest(1009L, "Dld Lama Sla Ala", 29));
        return requests;
    }

    private static IndexRequest generateDomainRequest(Long userId, String userName, Integer userAge) {
        IndexRequest indexRequest = new IndexRequest("user_index", "user_type");
        ESUser user = new ESUser(userId, userName, userAge);
        String source = new Gson().toJson(user);
        indexRequest.source(source, XContentType.JSON);
        return indexRequest;
    }

    /**
     * 根据id删除数据
     */
    public static void deleteRecord() {
        //删
        DeleteRequest deleteRequest = new DeleteRequest("user_index", "user_type", "Yv7owGsBbCHfXOwYR6cD");
        try {
            esClient.delete(deleteRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
//        createIndex();
//        deleteIndex();
//        searchIndex();
//        insertIndex();

        insertBatchIndex();



    }

}

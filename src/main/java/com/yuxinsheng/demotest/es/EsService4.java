package com.yuxinsheng.demotest.es;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.BucketOrder;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.collapse.CollapseBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class EsService4 {

    private static RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(new HttpHost("172.16.25.155", 9200, "http")));

    private static String USER_INDEX = "user_index";
    private static String USER_TYPE = "user_type";


    public static void searchIndex() {

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();


        sourceBuilder.fetchSource(new String[]{"user_name", "user_age"}, null);
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();


        //查询字段设置
        List<String> userNames = Lists.newArrayList("张三", "李四");
        boolQueryBuilder.must(QueryBuilders.termsQuery("user_name", userNames));


        //范围查询
        boolQueryBuilder.must(
                QueryBuilders.rangeQuery("user_age").from(19).to(21)
        );

        sourceBuilder.query(boolQueryBuilder);
        //构建searchRequest
        SearchRequest request = new SearchRequest("user_index");//设置index
        request.types("user_type");
        //查询条件
        request.source(sourceBuilder);
        SearchResponse response;
        try {
            //查询
            response = esClient.search(request, RequestOptions.DEFAULT);
            SearchHits hits = response.getHits();

            List<Map<String, Object>> list = Lists.newArrayList();
            for (SearchHit hit : hits) {
                Map source = hit.getSourceAsMap();
                list.add(source);
            }
            System.out.println(new Gson().toJson(list));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void updateDoc(String id, String fieldName, Object fieldValue) {
        UpdateRequest updateRequest = new UpdateRequest(USER_INDEX, USER_TYPE, id);
        Map<String, Object> map = Maps.newHashMap();
        map.put(fieldName, fieldValue);
        updateRequest.doc(map);
        try {
            esClient.update(updateRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static List groupBySearch() {
        List list = Lists.newArrayList();
        //聚合
        TermsAggregationBuilder aggregationBuilder = AggregationBuilders.terms("userAge").field("user_age");


//        CollapseBuilder.INNER_HITS_FIELD.withDeprecation("user_age");
//        ValueCountAggregationBuilder countAggregationBuilder = AggregationBuilders.count("count").field("user_age");

//        aggregationBuilder.subAggregation(countAggregationBuilder);

        SearchRequest searchRequest = new SearchRequest("user_index");
        searchRequest.types("user_type");

//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//
//        boolQueryBuilder.must(QueryBuilders.matchAllQuery());//查询所有 此处为匹配所有文档

        //elasticsearch 里默认的IK分词器是会将每一个中文都进行了分词的切割，所以你直接想查一整个词  加上.keyword
//        boolQueryBuilder.must(QueryBuilders.matchPhraseQuery("logType.keyword", logType));


        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();// 1.创建并设置SearchSourceBuilder对象
//        sourceBuilder.sort("user_age", SortOrder.DESC);
        sourceBuilder.sort(SortBuilders.fieldSort("user_id").order(SortOrder.DESC));
        sourceBuilder.size(0);

//        sourceBuilder.from(0);
//        // 查询结果终止处
//        sourceBuilder.size(3);

//        sourceBuilder.query(boolQueryBuilder);
        sourceBuilder.aggregation(aggregationBuilder);//聚合查询
        searchRequest.source(sourceBuilder);
        List sources = Lists.newArrayList();

        try {
            SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits hits = searchResponse.getHits();
            for (SearchHit hit : hits) {
                Map source = hit.getSourceAsMap();
                sources.add(source);
            }


            Aggregations aggregations = searchResponse.getAggregations();
            Aggregation tags = aggregations.asMap().get("userAge");

//            Aggregation tags1 = aggregations.asMap().get("count");
//            ClusterStatsNodes.Counts counts = (ClusterStatsNodes.Counts) tags1;
//            Map map = counts.getRoles();
//            System.out.println(map);

            Terms teamSum = (Terms) tags;
            List<? extends Terms.Bucket> buckets = teamSum.getBuckets();
            for (Terms.Bucket bucket : buckets) {
                list.add(bucket.getKeyAsString());
            }
            System.out.println(new Gson().toJson(list));
            System.out.println(new Gson().toJson(sources));
        } catch (IOException e) {

        }
        return list;
    }

    public static void main(String[] args) throws IOException {
//        searchIndex();
//        String id = "Xf7owGsBbCHfXOwYR6cD";
//        String fieldName = "user_age";
//        Integer fieldValue = 70;
//
//        updateDoc(id, fieldName, fieldValue);

        groupBySearch();
    }


}

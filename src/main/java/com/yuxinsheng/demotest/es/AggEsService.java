package com.yuxinsheng.demotest.es;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.document.DocumentField;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.metrics.cardinality.CardinalityAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.collapse.CollapseBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AggEsService {

    private static RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(new HttpHost("172.16.25.155", 9200, "http")));
    private static final String index = "user_index";
    private static final String type = "user_type";
    //fields
    private static final String userId = "user_id";
    private static final String userName = "user_name";
    private static final String userAge = "user_age";


    public static void aggSearch() throws IOException {
        SearchRequest searchRequest = new SearchRequest(index);
        searchRequest.types(type);

        // 1.创建并设置SearchSourceBuilder对象
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.sort(userId, SortOrder.DESC);
        sourceBuilder.from(0);
        sourceBuilder.size(5);

        //设置查询条件
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        List<String> names = Lists.newArrayList("张三三", "麻子");
//        boolQueryBuilder.must(QueryBuilders.matchQuery(userName, "赵六"));
        boolQueryBuilder.must(QueryBuilders.rangeQuery(userAge).from(20).to(21));

        //添加查询条件
        sourceBuilder.query(boolQueryBuilder);


        //折叠字段,group by
        CardinalityAggregationBuilder aggregationBuilder = AggregationBuilders.cardinality("userAge").field(userAge);
        sourceBuilder.aggregation(aggregationBuilder);

        //取字段
        CollapseBuilder collapse = new CollapseBuilder(userAge);
        sourceBuilder.collapse(collapse);

        //设置request
        searchRequest.source(sourceBuilder);

        //开始查询
        SearchResponse response = esClient.search(searchRequest, RequestOptions.DEFAULT);
        Aggregations aggregations = response.getAggregations();
        Map<String, Aggregation> asMap = aggregations.asMap();
        Aggregation aggregation = asMap.get("userAge");
        String json = new Gson().toJson(aggregation);
        Map<String, Object> map = (Map<String, Object>) JSONObject.parse(json);
        Integer totalRecords = (Integer) map.get("cardinalityValue");
        System.out.println("检索条目:" + totalRecords);

        SearchHits hits = response.getHits();
        hits.forEach(hit -> {
            Map<String, DocumentField> docMap = hit.getFields();
            DocumentField fields = docMap.get(userAge);
            Integer age = fields.getValue();
            System.out.println("检索字段值:" + age);
        });
    }


    public static void main(String[] args) {
        try {
            aggSearch();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

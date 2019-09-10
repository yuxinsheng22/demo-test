package com.yuxinsheng.demotest.es;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class EsProdAppDetailService {

    private static RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(new HttpHost("23.91.96.182", 9200, "http")));

    private static final String index = "app_detail_index";
    private static final String type = "app_detail_type";
    private static final String appName = "appName";

    private static void existQuery(String appNameLike) {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.size(20);

        //查询字段设置
        sourceBuilder.fetchSource(appName, null);

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

        //单条件查询
//        boolQueryBuilder.must(QueryBuilders.existsQuery(appNameLike));
//        boolQueryBuilder.must(QueryBuilders.prefixQuery(appName, appNameLike));
        boolQueryBuilder.must(QueryBuilders.wildcardQuery(appName, String.format("*%s*", appNameLike)).boost(0.99F));
        boolQueryBuilder.adjustPureNegative();


        sourceBuilder.query(boolQueryBuilder);


        //构建searchRequest
        SearchRequest request = new SearchRequest(index);//设置index
        //查询条件
        request.source(sourceBuilder);
        //设置type
        request.types(type);

        SearchResponse response;
        try {
            //查询
            response = esClient.search(request, RequestOptions.DEFAULT);
            SearchHits hits = response.getHits();
            List<String> list = Lists.newArrayList();
            for (SearchHit hit : hits) {
                Map source = hit.getSourceAsMap();
                String appName = (String) source.get("appName");
                list.add(appName);
            }
            System.out.println(new Gson().toJson(list));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        String appNameLike = "Sandwich";
        existQuery(appNameLike);
    }
}

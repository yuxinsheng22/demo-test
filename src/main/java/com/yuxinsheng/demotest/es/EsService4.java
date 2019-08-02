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
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class EsService4 {
    public static void main(String[] args) {
        searchIndex();

    }

    private static RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(new HttpHost("172.16.25.155", 9200, "http")));


    public static void searchIndex() {

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();


        sourceBuilder.fetchSource(new String[]{"user_id", "user_name", "user_age"}, null);
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();


        //查询字段设置
        List<String> userNames = Lists.newArrayList("张三","李四");
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


}

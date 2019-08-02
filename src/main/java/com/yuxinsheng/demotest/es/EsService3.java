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
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.WildcardQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class EsService3 {

    private static RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(new HttpHost("172.16.25.155", 9200, "http")));

    public static void searchIndex() {

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();


        //查询字段设置
        sourceBuilder.fetchSource(new String[]{"appName", "ownerName", "storeUrlId", "appDetail", "countryCodeId"}, null);

//        //查询条件设置
//        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("user_name", "王二");
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//        //单条件查询
//        boolQueryBuilder.must(matchQueryBuilder);
//        boolQueryBuilder.must().add(new MatchQueryBuilder("", ""));

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
//        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("appDetail", "Join").analyzer("ik_smart");

        //模糊查询
        WildcardQueryBuilder wildcardQueryBuilder = QueryBuilders.wildcardQuery("appDetail", "Join");


//        boolQueryBuilder.must(wildcardQueryBuilder);

        boolQueryBuilder.must(QueryBuilders.fuzzyQuery("appDetail","Join"));
        boolQueryBuilder.must(QueryBuilders.fuzzyQuery("ownerName","madhouse"));
        sourceBuilder.query(boolQueryBuilder);


        //排序设置
//        sourceBuilder.sort(new ScoreSortBuilder().order(SortOrder.DESC));
//        sourceBuilder.sort(new FieldSortBuilder("user_age").order(SortOrder.DESC));

        //构建searchRequest
        SearchRequest request = new SearchRequest("app_detail_index");//设置index
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

    public static void main(String[] args) {
        searchIndex();

    }
}

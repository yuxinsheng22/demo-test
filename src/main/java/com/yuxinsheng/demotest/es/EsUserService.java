package com.yuxinsheng.demotest.es;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class EsUserService {
    private static RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(new HttpHost("172.16.25.155", 9200, "http")));

    private static final String INDEX = "user_index";
    private static final String TYPE = "user_type";

    public static void createKeyWordIndex() {
        CreateIndexRequest index = new CreateIndexRequest(INDEX);//创建索引

        //创建的每个索引都可以有与之关联的特定设置。
        index.settings(Settings.builder()
                .put("index.number_of_shards", 10)
                .put("normalizer","es_normalizer")
        );



        index.mapping("user_type",//类型定义
                "{\n" +
                        "  \"user_type\": {\n" +
                        "    \"properties\": {\n" +
                        "      \"user_id\": {\n" +
                        "        \"type\": \"long\"\n" +
                        "      },\n" +
                        "      \"user_name\": {\n" +
                        "        \"type\": \"keyword\"\n" +
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

    public static void searchIndex(String name) {

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        //查询字段设置
        sourceBuilder.fetchSource(new String[]{"user_id", "user_name", "user_age"}, null);

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

        //单条件查询
        boolQueryBuilder.must(QueryBuilders.matchQuery("user_name", name));

//        QueryStringQueryBuilder queryStringQueryBuilder = QueryBuilders.queryStringQuery(name);
//        queryStringQueryBuilder.analyzer("user_name");

//        boolQueryBuilder.must(new QueryStringQueryBuilder(name).field("user_name").defaultOperator(Operator.AND));

//        boolQueryBuilder.must(QueryBuilders.wildcardQuery("user_name",String.format("*%s*", name)));

//        boolQueryBuilder.must(QueryBuilders.termQuery("user_name", name));


        sourceBuilder.query(boolQueryBuilder);


        //构建searchRequest
        SearchRequest request = new SearchRequest(INDEX);//设置index
        //查询条件
        request.source(sourceBuilder);
        //设置type
        request.types(TYPE);

        SearchResponse response;
        try {
            //查询
            response = esClient.search(request, RequestOptions.DEFAULT);
            SearchHits hits = response.getHits();
            List<ESUser> users = Lists.newArrayList();
            Gson gson = new Gson();
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


    public static void main(String[] args) {
//        createKeyWordIndex();
        String name = "Lama Sla";
        searchIndex(name);
    }

}

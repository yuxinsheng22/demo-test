package com.yuxinsheng.demotest.es;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import org.apache.http.HttpHost;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;
import java.util.List;

public class EsAppDetailService {

    private static RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(new HttpHost("172.16.25.155", 9200, "http")));


    public static void main(String[] args) {
        insertIndex();
    }


    /**
     * insert index
     */
    public static void insertIndex() {
        try {
            XContentBuilder builder = XContentFactory.jsonBuilder();
            builder.startObject();
            {
                builder.field("appName", "test app laoyutou");
                builder.field("ownerName", "madhouse游戏");
                builder.field("storeUrlId", 544);

                builder.field("iconId", 34);
                builder.field("appDetail", "madhouse游戏测试中");
                builder.field("countryCodeId", 229);

                builder.field("version", "4.3");
                builder.field("starRating", 5.0);
                builder.field("fileSizeByte", 1234567);
                builder.field("online", 1);
            }
            builder.endObject();
            IndexRequest indexRequest = new IndexRequest("app_detail_index", "app_detail_type")
                    .source(builder);

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
        requests.add(generateDomainRequest(1000L, "张三", 18));
        requests.add(generateDomainRequest(1001L, "李四", 19));
        requests.add(generateDomainRequest(1002L, "王二", 20));
        requests.add(generateDomainRequest(1003L, "麻子", 21));
        requests.add(generateDomainRequest(1004L, "陈五", 22));
        requests.add(generateDomainRequest(1005L, "赵六", 23));
        return requests;
    }

    private static IndexRequest generateDomainRequest(Long userId, String userName, Integer userAge) {
        IndexRequest indexRequest = new IndexRequest("user_index", "user_type");
        ESUser user = new ESUser(userId, userName, userAge);
        String source = new Gson().toJson(user);
        indexRequest.source(source, XContentType.JSON);
        return indexRequest;
    }
}

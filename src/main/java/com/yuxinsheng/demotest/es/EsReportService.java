package com.yuxinsheng.demotest.es;

import com.google.common.collect.Lists;
import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;
import java.util.List;

public class EsReportService {
    private static RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(new HttpHost("172.16.30.220", 9200, "http")));

    private static final String index = "adsinfo_report_index";
    private static final String type = "adsinfo_report_type";

    public static void deleteRecord(String index, String type, String id) {
        DeleteRequest deleteRequest = new DeleteRequest(index, type, id);
        try {
            esClient.delete(deleteRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        List<String> ids = Lists.newArrayList("0hfDlGwBwr3oPbUr14ld","0xfDlGwBwr3oPbUr14ld","uxfDlGwBwr3oPbUreIkv","vRfDlGwBwr3oPbUrgoke","zhfDlGwBwr3oPbUry4kt","zxfDlGwBwr3oPbUry4kt");
        ids.forEach(id->deleteRecord(index,type,id));
    }
}

package com.yuxinsheng.demotest.test3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;

public class ReadGzipFileService {
    public static void main(String[] args) throws IOException {
        StringBuilder json = new StringBuilder();
        String url = "https://ton.twimg.com/advertiser-api-async-analytics/GLfAXLie-lCvD7cnzCyw_wTw3eXKYKZp8AEvsTcUw8fzHvRmAOYlFkvkw1W6MVqhLiSfHsJG4JRw_ZBeSOydalh9gK7O-Ys94_VHQAg25FlhluRslMNwFS62KicrHwI0.json.gz";
        URL urlObject = new URL(url);
        URLConnection uc = urlObject.openConnection();
        uc.setRequestProperty("Accept-Encoding", "gzip");
        final BufferedReader reader = new BufferedReader(new InputStreamReader(new GZIPInputStream(uc.getInputStream()), "utf-8"));
        String inputLine = reader.readLine();
        while (inputLine != null) {
            json.append(inputLine);
            inputLine = reader.readLine();
        }
        System.out.println(json.toString());
    }
}

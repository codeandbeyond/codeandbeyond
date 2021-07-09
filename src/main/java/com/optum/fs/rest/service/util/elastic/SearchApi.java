package com.optum.fs.rest.service.util.elastic;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHit;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SearchApi {

    public static final String LOCALHOST = "localhost";
    public static final int PORT = 9200;
    public static final String HTTP = "http";
    public static final int PORT1 = 9201;

    public void resultListResponse(SearchRequest searchRequest){
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(LOCALHOST, PORT, HTTP),
                        new HttpHost(LOCALHOST, PORT1, HTTP)));
        System.out.println(searchRequest.toString());
        try {
            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
            for (SearchHit searchHit : searchResponse.getHits()) {
                Map<String, Object> results = searchHit.getSource();
                for (String key : results.keySet()) {
                    Object value = results.get(key);
                    if (value != null && value instanceof HashMap) {
                        for(Object mapKey:  ((HashMap) value).keySet()){
                            System.out.println(" "+mapKey.toString() +" is "+((HashMap) value).get(mapKey.toString()));
                        }

                    } else {
                        System.out.println("Patient " + key + " is " + value.toString());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

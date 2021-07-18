package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

import java.util.HashMap;
import java.util.Map;

public class TinyUrl {
    Map<String,String> index = new HashMap<>();
    Map<String,String> reverseIndex = new HashMap<>();
    String BASE_HOST = "http://tinyurl.com/";
    String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String encode(String url){
        if(reverseIndex.containsKey(url)) return BASE_HOST+reverseIndex.get(url);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<6;i++){
            int r = (int)(Math.random()*charSet.length());
            sb.append(charSet.charAt(r));
        }
        String key = sb.toString();
        index.put(key,url);
        reverseIndex.put(url,key);
        return BASE_HOST+key;
    }
    public String decode(String shortUrl) {
        return index.get(shortUrl.replace(BASE_HOST,""));
    }

    public static void main(String[] args) {
        TinyUrl tinyUrl = new TinyUrl();
        String key = tinyUrl.encode("www.facebook.com");
        System.out.println(key);
        System.out.println(tinyUrl.encode("www.facebook.com"));
        System.out.println(tinyUrl.decode(key));
    }
}

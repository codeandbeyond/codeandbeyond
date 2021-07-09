package com.optum.fs.rest.service.util.twilio.company.preparation;

import java.util.ArrayList;
import java.util.List;

public class MessageLessThan160 {
    public static List<String> segments(String message) {
        return getSplits(message);
    }
    public static List<String> getSplits(String message){
        List<String> result = new ArrayList<>();
        if (message.length() < 160) {
            result.add(message);
            return result;
        }

        int maxlen = 154;
        int s = 0, e = s + maxlen;
        while (e < message.length()) {
            if (message.charAt(e) != ' ') {
                while (e >= s && message.charAt(e) != ' ' && message.charAt(e + 1) != ' ') {
                    e--;
                }
            }
            result.add(message.substring(s, e+ 1));
            s = e + 1;
            e = s + maxlen;
        }
        result.add(message.substring(s, message.length()));

        for (int i = 0; i < result.size(); i++) {
            result.set(i, result.get(i)+"(" + (i + 1) + "/" + (result.size()) + ")");
        }
        return result;
    }
}

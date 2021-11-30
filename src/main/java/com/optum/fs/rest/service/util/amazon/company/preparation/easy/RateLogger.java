package com.optum.fs.rest.service.util.amazon.company.preparation.easy;

import java.util.HashMap;
import java.util.Map;

public class RateLogger {
    Map<String,Integer> map = new HashMap<>();

    public static void main(String[] args) {
        RateLogger rateLogger = new RateLogger();
        System.out.println(rateLogger.shouldPrintMessage(1,"foo"));
        System.out.println(rateLogger.shouldPrintMessage(2,"foo"));
        System.out.println(rateLogger.shouldPrintMessage(3,"bar"));
        System.out.println(rateLogger.shouldPrintMessage(9,"foo"));




    }

    public RateLogger() {

    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(timestamp < map.getOrDefault(message,0)){
            return false;
        }
        map.put(message,timestamp+10);
        return true;

    }
}

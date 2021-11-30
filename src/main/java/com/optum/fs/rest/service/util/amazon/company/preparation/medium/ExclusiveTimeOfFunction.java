package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class ExclusiveTimeOfFunction {
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<Log> stack = new ArrayDeque<>();
        int[] result = new int[n];
        for (String content : logs) {
            Log log = new Log(content);
            if (log.isStart) {
                stack.push(log);
            } else {
                Log top = stack.pop();
                result[top.id] += (log.time - top.time + 1);
                if (!stack.isEmpty()) {
                    result[stack.peek().id] -= (log.time - top.time + 1);
                }
            }
        }

        return result;
    }

    public static class Log {
        public int id;
        public boolean isStart;
        public int time;

        public Log(String content) {
            String[] strs = content.split(":");
            id = Integer.valueOf(strs[0]);
            isStart = strs[1].equals("start");
            time = Integer.valueOf(strs[2]);
        }
    }

    public static void main(String[] args) {
        int n = 2;
        String[] logs = {"0:start:0","0:start:2","0:end:5","1:start:7","1:end:7","0:end:8"};
        ExclusiveTimeOfFunction exclusiveTimeOfFunction = new ExclusiveTimeOfFunction();
        exclusiveTimeOfFunction.exclusiveTime(n, Arrays.asList(logs));
    }
}

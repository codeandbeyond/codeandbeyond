package com.optum.fs.rest.service.util.amazon.company.preparation.easy;

import java.util.Arrays;
import java.util.Comparator;

public class ReOrderDataLogFiles {
    public static void main(String[] args) {
        ReOrderDataLogFiles reOrderDataLogFiles = new ReOrderDataLogFiles();
        String[] str = new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        reOrderDataLogFiles.reorderLogFiles(str);
    }
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s2.split(" ", 2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            if(!isDigit1 && !isDigit2) {
                // both letter-logs.
                int comp = split1[1].compareTo(split2[1]);
                if (comp == 0) return split1[0].compareTo(split2[0]);
                else return comp;
            } else if (isDigit1 && isDigit2) {
                // both digit-logs. So keep them in original order
                return 0;
            } else if (isDigit1 && !isDigit2) {
                // first is digit, second is letter. bring letter to forward.
                return 1;
            } else {
                //first is letter, second is digit. keep them in this order.
                return -1;
            }
        });
        return logs;
    }
}

package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

import java.util.*;

public class UniqueEmailAddress {
    public int numUniqueEmails(String[] emails) {
      Set<String> unique = new HashSet<>();
        for(String email:emails){
            String[] parts = email.split("@");
            String[] local = parts[0].split("\\+");
            String uniqueMail  = local[0].replace(".","")+"@"+parts[1];
            unique.add(uniqueMail);

        }
    return unique.size();
    }

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        UniqueEmailAddress uniqueEmailAddress = new UniqueEmailAddress();
        System.out.println(uniqueEmailAddress.numUniqueEmails(emails));
    }
}

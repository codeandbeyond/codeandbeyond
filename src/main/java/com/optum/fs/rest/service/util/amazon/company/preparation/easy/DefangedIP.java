package com.optum.fs.rest.service.util.amazon.company.preparation.easy;

public class DefangedIP {
    public static void main(String[] args) {
        DefangedIP defangedIP = new DefangedIP();
        System.out.println(defangedIP.defangIPaddr("255.100.50.0"));
    }

    public String defangIPaddr(String address) {
        return address != null ? address.replace(".", "[.]") : null;
    }
}

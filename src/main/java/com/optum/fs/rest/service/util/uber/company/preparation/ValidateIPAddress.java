package com.optum.fs.rest.service.util.uber.company.preparation;

public class ValidateIPAddress {
    public String validIPAddress(String IP) {
        if (IP.chars().filter(ch -> ch == '.').count() == 3) {
            return validateIpv4(IP);
        } else if (IP.chars().filter(ch -> ch == ':').count() == 7) {
            return validateIpv6(IP);
        } else {
            return "Neither";
        }
    }

    private String validateIpv4(String ip) {
        String[] nums = ip.split("\\.", -1);
        for (String x : nums) {
            if (x.length() == 0 || x.length() > 3) return "Neither";
            if (x.charAt(0) == '0' && x.length() != 1) return "Neither";
            for (char c : x.toCharArray()) {
                if (!Character.isDigit(c)) return "Neither";
            }
            if (Integer.parseInt(x) > 255) return "Neither";
        }
        return "IPv4";

    }

    private String validateIpv6(String ip) {
        String hex = "0123456789ABCDEFabcdef";
        String[] nums = ip.split(":",-1);
        for (String x : nums) {
            if (x.length() == 0 || x.length() > 4) return "Neither";

            for (char c : x.toCharArray()) {
                if (hex.indexOf(c) == -1) return "Neither";
            }
        }
        return "IPv6";
    }

    public static void main(String[] args) {
        String ip4 = "01.01.01.01";
        String ip6 = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        ValidateIPAddress validateIPAddress = new ValidateIPAddress();
        validateIPAddress.validIPAddress(ip4);
        validateIPAddress.validIPAddress(ip6);
    }
}

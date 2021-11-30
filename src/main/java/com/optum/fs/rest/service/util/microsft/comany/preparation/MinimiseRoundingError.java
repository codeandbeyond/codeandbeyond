package com.optum.fs.rest.service.util.microsft.comany.preparation;

import java.util.ArrayList;
import java.util.List;

public class MinimiseRoundingError {
    public String minimizeError(String[] prices, int target) {
        List<Double> diff = new ArrayList<>(); // diff to next integer, e.g.["0.700","2.800","4.900"] => [0.3, 0.2, 0.1]
        for (String p : prices) {
            double price = Double.valueOf(p);
            target -= (int) price;
            if (target < 0) return "-1";
            double decimal = price - (int)price;
            if (decimal != 0 && decimal != 1) {
                diff.add(1 - decimal);
            }
        }
        if (target > diff.size()) return "-1";
        // need to pick (# of target) greater integer, and pick (diff.size()-target) smaller integer
        diff.sort((d1, d2) -> d1.compareTo(d2));
        double res = 0;
        for (int i = 0; i < diff.size(); i++) {
            if (i < target) {
                res += diff.get(i);
            } else {
                res += 1 - diff.get(i);
            }
        }
        return String.format("%.3f", res);
    }

    public static void main(String[] args) {
        String[]prices = {"1.500","2.500","3.500"};
        int target = 9;
        MinimiseRoundingError minimiseRoundingError = new MinimiseRoundingError();
        minimiseRoundingError.minimizeError(prices,target);
    }
}

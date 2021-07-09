package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;


import java.util.ArrayList;
import java.util.List;

class Interval {
    int buy;
    int sell;
}

public class    StockBuySellProfit {
    public static void main(String[] args) {
        StockBuySellProfit stock = new StockBuySellProfit();

        // stock prices on consecutive days
        int price[] = {100, 180, 260, 310, 40, 535, 695};
        int n = price.length;

        // fucntion call
        stock.stockBuySell(price, n);
        stock.stockBuySellDifferent(price,n);
    }

    private void stockBuySell(int[] price, int n) {
        int i = 0;
        int count = 0;
        int maxProfit =0;
        if (n == 1)
            return;
        ArrayList<Interval> sol = new ArrayList<Interval>();
        while (i < n) {
            Interval e = new Interval();
            while (i < n - 1 && price[i] >= price[i + 1]) {
                i++;
            }
            if (i == n - 1) {
                break;
            }
            e.buy = i++;
            while (i < n && price[i] >= price[i - 1]) {
                i++;
            }
            e.sell = i - 1;
            sol.add(e);
            count++;
            maxProfit+=(price[e.sell]-price[e.buy]);
        }
        if (count == 0) {
            System.out.println(" no possible solution");
        } else {
            for (Interval e : sol) {
                System.out.println(" Buy at : " + (e.buy+1) + " Sell at : " + (e.sell+1));

            }
            System.out.println(" MaxProfit :::::"+maxProfit);
        }
    }

    private void stockBuySellDifferent(int[] prices, int n) {
        List<Interval> intervals = new ArrayList<>();

        int i = 0;
        int buy;
        int sell;
        int maxprofit = 0;
        while (i < prices.length - 1) {
            Interval interval= new Interval();
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            buy = prices[i];
            interval.buy = i+1;
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            sell = prices[i];
            interval.sell = i+1;
            maxprofit += sell - buy;
            intervals.add(interval);
        }
        System.out.println("MaxProfit::" + maxprofit);
        for(Interval interval:intervals){
            System.out.print(" Buy "+interval.buy+" Sell "+interval.sell);
            System.out.println("");

        }    }
}
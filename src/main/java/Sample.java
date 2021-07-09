public class Sample {
    public static void main(String[] args) {
        Sample sample = new Sample();
        int[] arr = {1,45,23,2,100,1,149};
        System.out.println(sample.maxProfit(arr));
    }

    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 0;
        int minPrice = prices[0];
        int maxProfit = prices[1]-prices[0];

        //O(n)
        for(int i=1;i<prices.length;i++){
            if(prices[i]<minPrice){
                minPrice = prices[i];
                buy = i;
            }
            if(prices[i]-minPrice >maxProfit){
                maxProfit = prices[i]-minPrice;
                sell = i;
            }
        }
        System.out.println("buy "+buy +" sell "+sell);
        return maxProfit;
    }
}

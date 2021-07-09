import java.util.LinkedHashMap;
import java.util.Map;

public class NumbersTowords {
    static String[] lessThan20 = {"Zero", "One", "Two", "Three", "four", "five", "six", "seven", "eight", "nine", "ten"};
    static String[] Tens = {"", "Ten", "Twenty", "Thirty", "forty", "fifty", "sixty", "seventy", "eithty", "Ninety"};
    static String[] Thousands = {"", "Thousand", "Lakhs", "Crores"};
    static Map<Integer, String> numberWordsMap = new LinkedHashMap<>();

    public static void main(String[] args) {
        int num = 1207005000;
        NumbersTowords numbersTowords = new NumbersTowords();
      //  initializeMap();

        System.out.println(numbersTowords.numberTowOrds(num));
    }

    private  String numberTowOrds(int num) {
        initializeUSMap();
        if (num == 0) return lessThan20[0];
        String words = "";
        for (Integer key : numberWordsMap.keySet()) {
            if (num / key != 0) {
                words += convert(num / key) + " " + numberWordsMap.get(key) + " ";
            }
            num = num % key;
        }
        words += convert(num);
        return words.trim();

    }

    public  String convert(int num) {
        if (num == 0) return "";
        else if (num < 20) {
            return lessThan20[num] + " ";
        } else if (num < 100) {
            return Tens[num / 10] + " " + convert(num % 10);
        } else {
            return lessThan20[num / 100] + " Hundred " + convert(num % 100);
        }

    }

    private  void initializeMap() {
        numberWordsMap.put(10000000, "Crores");
        numberWordsMap.put(100000, "Lakhs");
        numberWordsMap.put(1000, "Thousand");
    }
    private static void initializeUSMap() {
        numberWordsMap.put(1000000000, "Billion");
        numberWordsMap.put(1000000, "Million");
        numberWordsMap.put(1000, "Thousand");
    }
}


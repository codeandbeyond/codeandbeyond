import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Student {
    int key;
    String name;
    static String field;
    public Student(String name, int i) {
        this.key = i;
        this.name = name;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLeapYear(int year) {
        System.out.printf("field"+field);
        boolean leap;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    leap = true;
                } else {
                    leap = false;
                }
            } else {
                leap = true;
            }
        } else {
            leap = false;
        }
        return leap == true ? true : false;
    }

    public static void main(String[] args) throws ParseException {
        Student student = new Student("January", 1);
        List list = new ArrayList();
        list.add("hello");
        list.add(2);
        System.out.println(list.get(0) instanceof Object);
        System.out.println(list.get(1) instanceof Integer);
//        String string = "{{}}";
//        valiDateString(string);
//        valiDateString("{}");
//        stringToJson("{\"optum\":\"fds\",\"operator\":\"AND\",\"sub\":{\"optum1\":\"fds1\",\"operator\":\"OR\",\"sub\":{\"optum2\":\"fds2\",\"operator\":\"AND\",\n" +
//                "\t\"sub\":{\"optum3\":\"fds3\",\"operator\":\"OR\",\"optum5\":\"fds5\" }}}} ");

        DateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
        Date formattedDate = originalFormat.parse("19611015");
        java.sql.Date sqlDate = new java.sql.Date(formattedDate.getTime());
        System.out.println(sqlDate);


        System.out.println(student.isLeapYear(1924));
    }

    private static void valiDateString(String string) {
        int startCurlyBrace = string.indexOf("{{");
        int endCurlyBrace = string.indexOf("}}");
        if (string.charAt(startCurlyBrace + 1) == '{' && string.charAt(endCurlyBrace + 1) == '}' && (endCurlyBrace - startCurlyBrace + 1) >= 0) {
            System.out.println("is in valid needs to be removed");
        } else {
            System.out.println("Valid");
        }
    }

    private static void stringToJson(String string) {

        try {
            JSONObject jsonObject = new JSONObject(string);
            Iterator<String> keys = jsonObject.keys();

            while(keys.hasNext()) {
                String key = keys.next();
                if (jsonObject.get(key) instanceof JSONObject) {
                   stringToJson(jsonObject.get(key).toString());
                }
            }
        } catch (JSONException err) {

        }
    }
}

package com.optum.fs.rest.service.util.problems;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListExample {
static	String day="WEDNESDAY";
static Integer campaignId;
	public static void main(String[] args) {
	     int x=10;
	     int y=x++;
        System.out.println("x  : "+x+" y: "+y);
		List<Map> list = new ArrayList<Map>();
		Map m=new HashMap();
		Map m1=new HashMap();
		Map m2=new HashMap();
		BigDecimal bd= new BigDecimal(1);
		Integer i=bd.intValueExact();
		m.put("campaignId",1);
		m.put("shopNo",7055);
		m.put("shopName","Willamson");
		m1.put("campaignId",1);
		m1.put("shopNo",7467);
		m1.put("shopName","EasyFlowers");
		m1.get("shopNo");
		m2.put("campaignId",2);
		m2.put("shopNo",7422);
		m2.put("shopName","FNP");
		m1.get("shopNo");
		list.add(m);
		list.add(m1);
		list.add(m2);
	for (int index=0;index<list.size();index++){
		Map shopMap=list.get(index);
		if((Integer)shopMap.get("shopNo")==7422){
		list.remove(index);
		}
System.out.println(" List is "+list);
	}
System.out.println(factorial(4));
System.out.println(day.substring(0, 3));
	}

	public static synchronized int factorial(int num) {
		return num == 0 ? 1 : num*factorial(num - 1);
	}
}

package com.optum.fs.rest.service.util.problems;

public class RodCutting {
	static int  p[]={0,1,5,8,9,10};
	static int revenue[]= new int [p.length];
	static int rodLength=5;
	public static void main(String[] args) {
		System.out.println(" I don't know what i am printing probvably Maximum Revenue "+revenueViaRecursion(p, rodLength));
	}
	public static int revenueViaRecursion(int p[],int rodLength){

		int q=0;
		if(revenue[rodLength]>0){
			return revenue[rodLength];
		}
		for(int i=1;i<=rodLength;i++){
			q=Math.max(q, p[i]+revenueViaRecursion(p, rodLength-i));
			revenue[rodLength]=q;
		}
		return revenue[rodLength];
	}
}

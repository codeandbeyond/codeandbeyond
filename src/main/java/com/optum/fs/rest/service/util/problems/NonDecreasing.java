package com.optum.fs.rest.service.util.problems;

public class NonDecreasing {
public static void main(String[] args) {
	System.out.println(" is the number Increasing "+isNonDecreasing(243));
}
public static boolean isNonDecreasing(int number){
	int x=number;
	boolean isflag=false;
	while(x>0){
		int digit1=x%10;
		x=x/10;
		int digit2=x%10;
		if(digit1>=digit2){
			isflag=true;
			x=x/10;
		}else{
			isflag=false;
			break;
		}
		
	}
	
	return isflag;
}
}

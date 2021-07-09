package com.optum.fs.rest.service.util.problems;

public class sample {
	static sample sa;
	public sample(int r){
		
	}
	public sample(){
		
	}
	private static sample givemeObject(){
		return new sample();
		
	}
	public static void display(){
		System.out.println("Hello!");
	}
public static void main(String[] args) {
	int digits[]=new int[10];
	sa=givemeObject();
	sample.display();
	int number=5;
	int newNum,tmpNum,result;
	while(number!=0){
	if(number > 0 && number < 10)
    {
        newNum = number / 10;
        tmpNum = newNum * 10;
        result = number - tmpNum;
        System.out.println("digits " + digits[result+1]);
        number = newNum;
    }
	}
	
}
}

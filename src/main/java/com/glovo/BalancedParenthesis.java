package com.glovo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedParenthesis {
    public boolean validParenthesis(String expression){
        if(expression == null) return  false;
        if(expression.length()%2!=0) return false;
        if( expression.length() == 0) return true;

        Stack<Character> stack = new Stack();
        Map<Character,Character> map = new HashMap<>();
        map.put('{','}');
        map.put('(',')');
        map.put('[',']');

        for(int i=0;i<expression.length();i++){
            char ch = expression.charAt(i);
            if(ch == '{' || ch == '(' || ch == '['){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char expect = stack.pop();
                char has = map.get(expect);

                if(ch!=has){
                    return false;
                }
            }
        }
        return stack.isEmpty()?true:false;
    }

    public static void main(String[] args) {
        BalancedParenthesis balancedParenthesis = new BalancedParenthesis();

        System.out.println(" (((((((((()))))))))) is Balanced ? ="+balancedParenthesis.validParenthesis("(((((((((())))))))))"));

    }
}


//1. "()" -> true
//        2. "()[]{}" -> true
//        3. "(]" -> false
//        4. ")(" -> false
//        5. "([)]" -> false
//        6. "{[]}" -> true
//        7. ")" -> false
//        8. "([]" -> false
//        9. "{" -> false
//        10. "([)])" -> false
//        11. "(((((((((())))))))))" -> true
//        12. "" -> true

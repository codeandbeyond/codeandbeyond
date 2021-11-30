package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

import java.util.Stack;

public class BrowserHistory {

    Stack<String> future ;
    Stack<String> history = new Stack();
    public BrowserHistory(String homepage) {
        history.push(homepage);
        future = new Stack();
    }

    public void visit(String url) {
        history.push(url);
        future = new Stack();

    }

    public String back(int steps) {
        while(steps > 0 && history.size() >1){
            future.push(history.peek());
            history.pop();
            steps--;
        }
        return history.peek();
    }

    public String forward(int steps) {
        while(steps > 0 && future.size() >0){
            history.push(future.peek());
            future.pop();
            steps--;
        }
        return history.peek();

    }
}

package com.optum.fs.rest.service.util;

import com.optum.fs.rest.service.util.problems.SequentialSerachST;

public class SeparateChainingHash<Key,Value> {
    private static final int CAPACITY=4;
    private int n;//number of key value pairs
    private int m;//hash table size;
    private SequentialSerachST<Key,Value> st[];
    public SeparateChainingHash(){
        this (CAPACITY);
    }
    public SeparateChainingHash(int m){
    this.m=m;
    st = (SequentialSerachST<Key,Value>[]) new SequentialSerachST[m];
    for(int i=0;i<m;i++){
        st[i]=new SequentialSerachST<Key, Value>();
    }
    }
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public Value get(Key key){
        if(key==null)
            return null;
        int i= hash(key);
        return st[i].get(key);
    }
    public void put(Key key,Value value){
        if(key==null)
            return ;

        if(value==null){
            delete(key);
            return;
        }
        int i=hash(key);
        if(!st[i].contains(key)){
            n++;
            st[i].put(key,value);
        }
    }
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");

        int i = hash(key);
        if (st[i].contains(key)) n--;
        st[i].delete(key);

    }
}

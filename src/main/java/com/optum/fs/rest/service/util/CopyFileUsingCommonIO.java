package com.optum.fs.rest.service.util;

import java.io.File;
import java.io.IOException;

public class CopyFileUsingCommonIO {

    public static void main(String[] args) throws IOException {
        File directory = new File("\\Uhc00502\\data\\UHT_TRMCB\\Incoming\\");
        String[] list = directory.list();
        for(String name:list){
            System.out.println(name);
        }
    }
}
package com.optum.fs.rest.service.util.microsft.comany.preparation;

public class ExcelTitleToNum {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        int n = columnTitle.length();
        for(int i=0;i<n;i++){
            result = result*26;
            result+=(columnTitle.charAt(i)-'A'+1);
        }
        return result;
    }

    public static void main(String[] args) {
        ExcelTitleToNum excelTitleToNum = new ExcelTitleToNum();
        excelTitleToNum.titleToNumber("ZY");
    }
}

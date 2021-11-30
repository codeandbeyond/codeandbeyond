package com.optum.fs.rest.service.util.microsft.comany.preparation;

import java.util.ArrayList;
import java.util.List;

public class RemoveCommentsFromProgramme {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean mode = false;
        for (String s : source) {
            for (int i = 0; i < s.length(); i++) {
                if (mode) {
                    if (s.charAt(i) == '*' && i < s.length() - 1 && s.charAt(i + 1) == '/') {
                        mode = false;
                        i++;        //skip '/' on next iteration of i
                    }
                } else {
                    if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '/') {
                        break;      //ignore remaining characters on line s
                    } else if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '*') {
                        mode = true;
                        i++;           //skip '*' on next iteration of i
                    } else sb.append(s.charAt(i));     //not a comment
                }
            }
            if (!mode && sb.length() > 0) {
                res.add(sb.toString());
                sb = new StringBuilder();   //reset for next line of source code
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] sources = {"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
        RemoveCommentsFromProgramme removeCommentsFromProgramme = new RemoveCommentsFromProgramme();
        removeCommentsFromProgramme.removeComments(sources);
    }
}

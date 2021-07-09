package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

public class SmallestWindow {
    static final int no_of_chars = 256;
    public static void main(String[] args) {
        String str = "this is a test string";
        String pat = "tist";

        System.out.print("Smallest window is :\n " +
                findSubString(str, pat));
    }
    static String findSubString(String str, String pat)
    {
        int len1 = str.length();
        int len2 = pat.length();

                // check if string's length is less than pattern's
        // length. If yes then no such window can exist
        if (len1 < len2)
        {
            System.out.println("No such window exists");
            return "";
        }

        int pat_count[] = new int[no_of_chars];
        int str_count[] = new int[no_of_chars];

        // store occurrence ofs characters of pattern
        for (int i = 0; i < len2; i++)
            pat_count[pat.charAt(i)]++;

        int start = 0, start_index = -1, min_len = Integer.MAX_VALUE;

        // start traversing the string
        int count = 0; // count of characters
        for (int j = 0; j < len1 ; j++)
        {
            // count occurrence of characters of string
            str_count[str.charAt(j)]++;

            // If string's char matches with pattern's char
            // then increment count
            if (pat_count[str.charAt(j)] != 0 &&
                    str_count[str.charAt(j)] <= pat_count[str.charAt(j)] )
                count++;

            // if all the characters are matched
            if (count == len2)
            {
                // Try to minimize the window i.e., check if
                // any character is occurring more no. of times
                // than its occurrence in pattern, if yes
                // then remove it from starting and also remove
                // the useless characters.
                while ( str_count[str.charAt(start)] > pat_count[str.charAt(start)]
                        || pat_count[str.charAt(start)] == 0)
                {

                    if (str_count[str.charAt(start)] > pat_count[str.charAt(start)])
                        str_count[str.charAt(start)]--;
                    start++;
                }

                // update window size
                int len_window = j - start + 1;
                if (min_len > len_window)
                {
                    min_len = len_window;
                    start_index = start;
                }
            }
        }

        // If no window found
        if (start_index == -1)
        {
            System.out.println("No such window exists");
            return "";
        }

        // Return substring starting from start_index
        // and length min_len
        return str.substring(start_index, start_index + min_len);
    }
}

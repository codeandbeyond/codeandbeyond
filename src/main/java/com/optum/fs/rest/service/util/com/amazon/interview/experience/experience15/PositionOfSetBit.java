package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

public class PositionOfSetBit {
    public static void main(String[] args) {
        int n = 16;
        System.out.println(" Position of the only set bit " + positionOfSetBit(n));
        int a = 10;
        int b = 20;
        System.out.println(" Number of Set Bits are "+countOfsetBits(a^b));
    }

    private static int countOfsetBits(int n) {
        int count=0;
        while(n!=0){
            if((n&1)>0)
                count++;
            n=n>>1;
        }
        return count;
    }

    private static int positionOfSetBit(int n) {
        int pos = 1;
        int i = 1;
        if (!powerOfTwo(n)) {
            return -1;
        }
        while ((i & n) == 0) {
            i = 1 << i;
           ++pos;
        }


        return pos+1;
    }

    private static boolean powerOfTwo(int n) {
        if (n > 0 && (n & (n - 1)) == 0) {
            return true;
        }
        return false;
    }
}

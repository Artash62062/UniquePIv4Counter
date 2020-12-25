package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NormalFilesCountClalculator {
    public static long largeFileLinesCount (String largeFile) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(largeFile));
            String line = br.readLine();
            long counter=0;
            while(line!=null) {
                line= br.readLine();
                counter++;
            }return counter;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static int optimalArrayCount(long linesCount) {
        int temp = (int)(linesCount+1000)/1000000 +1;
        if(temp == 1)
            return 2;
        int countOfPow =0;
        while(Math.pow(2,countOfPow)<temp){
            countOfPow++;
        }
        return(int)Math.pow(2,countOfPow);
    }
}

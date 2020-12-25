package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FindUniqueLinesInSortedFile {
    public static long findUniqueLines(String filePath,long lineCount) throws IOException {
        int counter = 0;
        FileReader finalFileReader = new FileReader(filePath);
        BufferedReader br1= new BufferedReader(finalFileReader);
        String line1 = br1.readLine();
        String line2 = br1.readLine();
        String line3 = br1.readLine();
        String line4="";
        for(int i=0;i<lineCount;i++) {
            if(line1==null||line2==null) {break;}
            if (line3 == null&& !line1.equals(line2) && !line2.equals(line4)){
                counter++;
                break;
            }
            if(line3!=null&&!line2.equals(line1) && !line2.equals(line3)) {
                counter++;
            }
            line1=line2;
            line2=line3;
            line4=line3;
            line3=br1.readLine();
        }
        return counter;
    }
}

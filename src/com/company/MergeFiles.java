package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class MergeFiles {

    public static void mergeFiles( String file1,String file2,String file3) {
        try{
            System.out.println(file1 + "Merging" + file2);
            FileReader fileReader1 = new FileReader(file1);
            FileReader fileReader2= new FileReader(file2);
            FileWriter writer = new FileWriter(file3);
            BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
            BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
            String line1 = bufferedReader1.readLine();
            String line2 = bufferedReader2.readLine();
            while (line1 != null || line2 != null) {
                if (line1 == null || (line2 != null && line1.compareTo(line2) > 0)) {
                    writer.write(line2 + "\r\n");
                    line2 = bufferedReader2.readLine();
                } else {
                    writer.write(line1 + "\r\n");
                    line1 = bufferedReader1.readLine();
                }
            }
            System.out.println(file1 + "Done Merging" + file2);
            new File(file1).delete();
            new File(file2).delete();
            writer.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}

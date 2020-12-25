package com.company;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class Main {
    public static final String LargeFilePath = "/home/artash/Desktop/TestFiles/TestFile";  //Write Here Your File Path
    public static final String TempFilesPath = "/home/artash/Desktop/SortingFolder/";      //Write here folder Where Temp Files Should be put and then deleted
    public static void main(String[] args) {
        try {
            long lineCount = NormalFilesCountClalculator.largeFileLinesCount(LargeFilePath);
            long FilesCount = NormalFilesCountClalculator.optimalArrayCount(lineCount);
            String [] arr = new String [(int)(lineCount/FilesCount)];
            BufferedReader br = new BufferedReader(new FileReader(LargeFilePath));
            String line = br.readLine();
            for (int i=0;i<FilesCount;i++) {
                for(int j=1;j<=arr.length;j++) {
                    arr[j-1] = line;
                    line = br.readLine();
                }
                Arrays.sort(arr);
                FileWriter fileWriter = new FileWriter(TempFilesPath+i);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                for(int j=0;j< arr.length;j++){
                    bufferedWriter.write(arr[j]);
                    bufferedWriter.newLine();
                }
                bufferedWriter.flush();
            }
            int treeHeight =(int)(Math.log(FilesCount)/Math.log(2));
            String lastFilePath="";
            for(int i=0;i<treeHeight;i++) {

                for(int j=0,itr =0;j<FilesCount;j+=2,itr++) {
                    int offset = i*100;
                    String tempFile1 = TempFilesPath +(j + offset);
                    String tempFile2 = TempFilesPath + ((j + 1) + offset);
                    String opFile = TempFilesPath + (itr + ((i + 1) * 100));
                    lastFilePath = opFile;
                    MergeFiles.mergeFiles(tempFile1,tempFile2,opFile);
                }
                FilesCount/=2;
            }
           long counter = FindUniqueLinesInSortedFile.findUniqueLines(lastFilePath,lineCount);
           System.out.println(counter);
            
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

package com.atguigu.datastructure.sparsearray;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class SparseArray {

    public static void main(String[] args) throws Exception{
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        System.out.println("原始的二位数组");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if(chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }
        System.out.println("原始数组中非零值："+sum);
        int sparseArr[][] = new int[sum+1][3];
        sparseArr[0][0] = chessArr1.length;
        sparseArr[0][1] = chessArr1[0].length;
        sparseArr[0][2] = sum;

        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if(chessArr1[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        System.out.println("-----------");
        System.out.println("生成的稀疏数组");
        for (int[] ints : sparseArr) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }
        //将稀疏数组写入到map.data文件中
        BufferedWriter bw = new BufferedWriter(new FileWriter("G:\\JAVA\\ADS\\day00_test\\src\\com\\atguigu\\sparsearray\\map.data"));
        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < sparseArr[i].length; j++) {
                bw.write(sparseArr[i][j]+"\t");
            }
            bw.write("\r\n");
        }
        bw.close();

        //根据稀疏数组恢复原始数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("恢复后的数据：");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }

    @Test
    public void readFile() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("G:\\JAVA\\ADS\\day00_test\\src\\com\\atguigu\\sparsearray\\map.data"));
        int row = 0;
        String line;

        while((line = br.readLine()) != null){
            row += 1;
        }
        int sparseArr[][] = new int[row][3];
        int len=0;
        BufferedReader br1 = new BufferedReader(new FileReader("G:\\JAVA\\ADS\\day00_test\\src\\com\\atguigu\\sparsearray\\map.data"));
        while((line = br1.readLine()) != null){
            String[] temp = line.split("\t");
            for(int j=0;j<temp.length;j++){
                sparseArr[len][j] = Integer.parseInt(temp[j]);
            }
            len++;
        }
        System.out.println("生成的稀疏数组");
        for (int[] ints : sparseArr) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }
        br.close();


    }
}

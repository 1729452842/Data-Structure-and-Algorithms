package com.atguigu.recursion;

import java.util.Arrays;

public class MiGong {

    public static void main(String[] args) {
        int[][] map = new int[8][7];
        //使用1表示墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for (int i = 0; i < 8; i++){
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;

        System.out.println("地图情况：");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }

        /*
        int[][] map1 = map;
        setWay1(map1,1,1);
        System.out.println("小球的路线：");
        for (int i = 0; i < map1.length; i++) {
            for (int j = 0; j < map1[i].length; j++) {
                System.out.print(map1[i][j] + "\t");
            }
            System.out.println();
        }

        int[][] map2 = map;
        setWay2(map2,1,1);
        System.out.println("小球的路线：");
        for (int i = 0; i < map2.length; i++) {
            for (int j = 0; j < map2[i].length; j++) {
                System.out.print(map2[i][j] + "\t");
            }
            System.out.println();
        }

        int[][] map3 = map;
        setWay3(map,1,1);
        System.out.println("小球的路线：");
        for (int i = 0; i < map3.length; i++) {
            for (int j = 0; j < map3[i].length; j++) {
                System.out.print(map3[i][j] + "\t");
            }
            System.out.println();
        }
        */
        int[][] map4 = map;
        setWay4(map4,1,1);
        System.out.println("小球的路线：");
        for (int i = 0; i < map4.length; i++) {
            for (int j = 0; j < map4[i].length; j++) {
                System.out.print(map4[i][j] + "\t");
            }
            System.out.println();
        }

    }


    public static boolean setWay1(int[][] map, int i, int j){
        for (int x = 0; x < map.length; i++) {
            for (int y = 0; y < map[i].length; j++) {
                System.out.print(map[i][j] + "\t");
        }
        System.out.println();
    }

        if(map[6][5] == 2){
            return true;
        }else {
            if(map[i][j] == 0){
                map[i][j] = 2;
                //向下
                if(setWay1(map,i+1,j)){
                    return true;
                    //向右
                }else if(setWay1(map,i,j+1)){
                    return true;
                    //向上
                }else if(setWay1(map, i -1, j)){
                    return true;
                    //向做
                }else if(setWay1(map,i,j-1)){
                    return true;
                }else{
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }

    public static boolean setWay2(int[][] map, int i, int j){
        if(map[6][5] == 2){
            return true;
        }else {
            if(map[i][j] == 0){
                map[i][j] = 2;
                //向下
                if(setWay2(map,i-1,j)){
                    return true;
                    //向右
                }else if(setWay2(map,i,j+1)){
                    return true;
                    //向上
                }else if(setWay2(map, i +1, j)){
                    return true;
                    //向做
                }else if(setWay2(map,i,j-1)){
                    return true;
                }else{
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }

    public static boolean setWay3(int[][] map, int i, int j){
        if(map[6][5] == 2){
            return true;
        }else {
            if(map[i][j] == 0){
                map[i][j] = 2;
                //向下
                if(setWay3(map,i,j+1)){
                    return true;
                    //向右
                }else if(setWay3(map,i+1,j)){
                    return true;
                    //向上
                }else if(setWay3(map, i -1, j)){
                    return true;
                    //向做
                }else if(setWay3(map,i,j-1)){
                    return true;
                }else{
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }

    public static boolean setWay4(int[][] map, int i, int j){
        int num = 0;
        num++;
        System.out.println("第"+num+ "次");
        for (int x = 0; x < map.length; i++) {
            for (int y = 0; y < map[x].length; j++) {
                System.out.print(map[x][y] + "\t");
            }
            System.out.println();
        }
        if(map[6][5] == 2){
            return true;
        }else {
            if(map[i][j] == 0){
                map[i][j] = 2;
                //向下
                if(setWay4(map,i,j-1)){
                    return true;
                    //向右
                }else if(setWay4(map,i+1,j)){
                    return true;
                    //向上
                }else if(setWay4(map, i -1, j)){
                    return true;
                    //向做
                }else if(setWay4(map,i,j+1)){
                    return true;
                }else{
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}

package com.yavel;

public class Main {




    public static void main(String[] args) {
        int array[];
        System.out.println("hello world");
	    System.out.println("test number 1");
	    System.out.println("goodbye");
        int cols =11;
        int rows =21;
        int[][] multTable = new int [rows][cols];
        for(int r = 0; r < rows; r++)
        {
            for(int c = 0; c< cols; c++)
            {
                multTable[r][c] = r*c;
                System.out.println(multTable[r][c]);
               // if(multTable[r][c] %10 == 7 || multTable[r][c]/10 == 7)
               // {
                //    System.out.println("xx\t");
               // }
               // else
                  //  System.out.print(multTable[r][c] + "\t");
            }
        }

    }
}

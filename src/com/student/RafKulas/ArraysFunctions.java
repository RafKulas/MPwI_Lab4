package com.student.RafKulas;

import java.util.Random;
import java.util.Scanner;

public class ArraysFunctions {
    static public double round(double what, int precision) {
        if (precision < 0){
            throw new IllegalArgumentException();
        }
        long factor = (long) Math.pow(10, precision);
        what *= factor;
        long tmp = Math.round(what);
        what = (double)tmp/factor;
        return what;
    }

    static public void fillRandomArray(double bound, int height, int width, double[][] arr) {
        Random random = new Random();
        double left = 1.0;
        for(int i = 0; i<height; i++) {
            for(int j=0; j<width; j++) {
                if(i==height-1 && j==width-1) {
                    arr[i][j] = round(left, 2);
                    break;
                }
                arr[i][j] = round((Math.min(random.nextDouble()*left, bound)), 2);
                left -= arr[i][j];
            }
        }
    }

    static public double[][] generateArray() {
        Scanner in = new Scanner(System.in);
        System.out.println("Firstly set amount of rows and columns.\n" +
                "Warning: entering wrong parameters results in an attempt to create an array again.");
        try {
            System.out.println("Rows:");
            int rows = in.nextInt();
            System.out.println("Columns:");
            int cols = in.nextInt();
            double[][] customProbability = new double[rows][cols];

            System.out.println("Do you want to fill array by yourself?\n" +
                    "1. Yes, let me do it!(We won't check the correctness of data)\n" +
                    "2. Nah, I'm too lazy...(Default option)");
            try {
                int decision = in.nextInt();
                if(decision == 1) {
                    System.out.println("Let's begin...");
                    for(int i = 0; i < rows; i++){
                        for(int j = 0; j < cols; j++) {
                            System.out.printf("\nYour arr at %d row and %d col:", i, j);
                            customProbability[i][j] = in.nextDouble();
                        }
                    }
                }
                else {
                    fillRandomArray(0.3, rows, cols, customProbability);
                }
            }
            catch (Exception e) {
                in.next();
                fillRandomArray(0.3, rows, cols, customProbability);
            }
            return customProbability;
        }
        catch (Exception e) {
            in.next();
            return generateArray();
        }
    }

    static public void printArray(double[][] arr) {
        int height = arr.length;
        int width = arr[0].length;
        for (double[] doubles : arr) {
            System.out.print("[");
            for (int j = 0; j < width; j++) {
                System.out.printf("%.3f ", doubles[j]);
            }
            System.out.println("\b]");
        }
    }

    static void printArray(int[][] arr) {
        int height = arr.length;
        int width = arr[0].length;
        for (int[] ints : arr) {
            System.out.print("[");
            for (int j = 0; j < width; j++) {
                System.out.printf("%5d ", ints[j]);
            }
            System.out.println("\b]");
        }
    }
}

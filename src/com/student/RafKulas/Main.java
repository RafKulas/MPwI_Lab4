package com.student.RafKulas;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static void setArray(double[][] arr) {

    }

    public static void main(String[] args) {
        double[][] basicProbability = {
                {0,   0,    0.1, 0.1},
                {0.2, 0,    0,   0.2},
                {0,   0,    0.3, 0},
                {0,   0.05, 0,   0.05}
        };
        Scanner in = new Scanner(System.in);

        PairGenerator pg = new PairGenerator(basicProbability);

        pg.generate();



    }
}

package com.student.RafKulas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double[][] basicProbability = {
                {0,    0,     0.1,  0.1 },
                {0.2,  0,     0,    0.2 },
                {0,    0,     0.3,  0   },
                {0,    0.05,  0,    0.05}
        };

        PairGenerator pg;
        Scanner in = new Scanner(System.in);
        System.out.println("What array you want to use?\n" +
                "1. Custom\n" +
                "2. Default");
        try {
            int decision = in.nextInt();
            if(decision == 1) {
                pg = new PairGenerator(ArraysFunctions.generateArray());
            }
            else {
                pg = new PairGenerator(basicProbability);
            }
        }
        catch (Exception e) {
            System.out.println("Something went wrong, choosing default one");
            pg = new PairGenerator(basicProbability);
        }

        pg.generate();
    }
}

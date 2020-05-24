package com.student.RafKulas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PairGenerator implements Generator<Pair<Integer, Integer>> {
    private final List<Pair<Integer, Integer>> output;
    private static final int count = 100_000;
    private final double[][] probArr;
    private final double[][] firstArr;
    private final int[][] countProbability;
    private final int width;
    private final int height;

    public PairGenerator(double[][] probArr) {
        firstArr = Arrays.stream(probArr).map(double[]::clone).toArray(double[][]::new);
        rescale(probArr);
        this.probArr = probArr;
        width = probArr[0].length;
        height = probArr.length;
        output = new ArrayList<>();
        countProbability = new int[height][width];
        for(int index = 0; index<height; index++) {
            Arrays.fill(countProbability[index], 0);
        }
    }

    @Override
    public void printGenerated() {
        System.out.printf(" %5s %5s\n", "X", "Y");
        System.out.println("-----------------");
        for(Pair<Integer, Integer> p:output) {
            System.out.printf(" %5d %5d\n", p.getX_val(), p.getY_val());
        }
    }

    public PairGenerator printResult() {
        System.out.println("\nYour initial array:");
        ArraysFunctions.printArray(firstArr);
        System.out.println("\nWas rescaled to:");
        ArraysFunctions.printArray(probArr);
        System.out.printf("\nAnd by %d tries we get:\n", count);
        ArraysFunctions.printArray(countProbability);
        double[][] resCP = new double[height][width];
        for(int i=0; i<height; i++) {
            for(int j=0; j< width; j++) {
                resCP[i][j] = (double)countProbability[i][j]/count;
            }
        }
        System.out.println("\nWhich rescaled to '%' gives:");
        ArraysFunctions.printArray(resCP);
        return this;
    }

    @Override
    public PairGenerator generate() {
        for(int i =0; i<count; i++) {
            nextGenerated();
        }
        return this;
    }

    @Override
    public Pair<Integer, Integer> nextGenerated() {
        Random rand = new Random();
        double chance = 0.0;
        double check = rand.nextDouble();
        int x = rand.nextInt(height)+1;
        for(int index = 1; index<=width; index++) {
            chance+=probArr[x-1][index-1];
            if(check<chance) {
                Pair<Integer, Integer> d = new Pair<>(x, index);
                countProbability[x-1][index-1]++;
                output.add(d);
                return d;
            }
        }
        return new Pair<>(0,0);
    }

    private void rescale(double[][] arr) {
        for(int row = 0; row<arr.length; row++) {
            double sum = 0.0;
            for(int index = 0; index<arr[row].length; index++) {
                sum+=arr[row][index];
            }
            for(int index = 0; index<arr[row].length; index++) {
                arr[row][index]=arr[row][index]/sum;
            }
        }
    }
}

package org.kou.ml.util;

import java.util.Random;

/**
 * Created by kou on 2014/12/12.
 */
public class RandomVectorGenerator {

    private static final Random RANDOM = new Random();
    private static final double BOUND = 800;

    public static void main(String[] args) {

        int numVectors = Integer.parseInt(args[0]);
        int numClusters = Integer.parseInt(args[1]);
        double limitVariances = Double.parseDouble(args[2]);
        int dimension = 2;
//        if (args.length > 3) {
//            dimension = Integer.parseInt(args[3]);
//        }
        double[][] vectors = new double[numVectors][dimension];
        double[][] centers = new double[numClusters][dimension];
        double[][] maxVariances = new double[numClusters][dimension];
        double[] randomRadian = new double[numClusters];
        double[] randomRadianDelta = new double[numClusters];

        for (int i = 0; i < centers.length; i++) {
            for (int j = 0; j < centers[i].length; j++) {
                centers[i][j] = RANDOM.nextDouble() * BOUND;
            }
        }

        for (int i = 0; i < numClusters; i++) {
            for (int j = 0; j < dimension; j++) {
                maxVariances[i][j] = RANDOM.nextDouble() * limitVariances;
            }
        }


        for (int i = 0; i < numClusters; i++) {
            randomRadian[i] = RANDOM.nextDouble() * Math.PI * 2;
            randomRadianDelta[i] = RANDOM.nextDouble() * Math.PI / 4;
        }

        for (int i = 0; i < numVectors; i++) {
            int clusterIndex = RANDOM.nextInt(numClusters);
            double delta = RANDOM.nextGaussian() * randomRadianDelta[clusterIndex];
            double radian = randomRadian[clusterIndex] + delta;
            double length = RANDOM.nextGaussian() * maxVariances[clusterIndex][0];
//            double randomRadian = RANDOM.nextDouble() * Math.PI * 2;
            double x = length * Math.cos(radian) +
                    length * Math.sin(radian);
            double y = length * -Math.sin(radian) +
                    length * Math.cos(radian);

            vectors[i][0] = centers[clusterIndex][0] + x;
            vectors[i][1] = centers[clusterIndex][1] + y;
        }

        for (int i = 0; i < numVectors; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print(vectors[i][j]);
                if (j < dimension - 1) {
                    System.out.print(",");
                } else {
                    System.out.println();
                }
            }
        }
    }
}

package org.kou.ml.plot.viewer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kou on 2014/12/14.
 */
public class CsvClusterReader implements ClusterReader {

    @Override
    public List<double[]> readClusterVector(File file) throws IOException {

        List<double[]> list = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String vectors = null;
            while ((vectors = reader.readLine()) != null) {
                double[] dvector = new double[4];
                String[] vector = vectors.split(",");
                for (int i = 0; i < vector.length; i++) {
                    dvector[i] = Double.parseDouble(vector[i]);
                }
                list.add(dvector);
            }
        }

        return list;
    }
}

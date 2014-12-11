package org.kou.ml.plot.viewer;

import org.jfree.data.xy.XYSeries;

import java.io.*;

/**
 * Created by kou on 2014/12/12.
 */
public class CsvVectorReader implements VectorReader {
    @Override
    public XYSeries readVector(File file) throws IOException {
        try (
          BufferedReader reader =
            new BufferedReader(
              new InputStreamReader(
                new FileInputStream(file)))) {
            XYSeries series = new XYSeries("Data");

            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] xy = line.split(",");
                double x = Double.parseDouble(xy[0]);
                double y = Double.parseDouble(xy[1]);
                series.add(x, y);
            }

            return series;
        }
    }
}

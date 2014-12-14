package org.kou.ml.plot.viewer;

import org.jfree.data.xy.XYSeries;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by kou on 2014/12/12.
 */
public class ScatterPlotViewer {

    public static void main(String[] args) throws IOException {

        File vectorFile = new File(args[0]);
        File clusterFile = null;
        List<double[]> clusters = null;

        if (args.length > 1) {
            clusterFile = new File(args[1]);

            ClusterReader clusterReader = new CsvClusterReader();
            clusters = clusterReader.readClusterVector(clusterFile);
        }

        VectorReader reader = new CsvVectorReader();
        XYSeries series = reader.readVector(vectorFile);
        View view = new SwingView();
        view.display(series, clusters);
    }
}

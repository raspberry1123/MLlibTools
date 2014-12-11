package org.kou.ml.plot.viewer;

import org.jfree.data.xy.XYSeries;

import java.io.File;
import java.io.IOException;

/**
 * Created by kou on 2014/12/12.
 */
public class ScatterPlotViewer {

    public static void main(String[] args) throws IOException {

        VectorReader reader = new CsvVectorReader();
        XYSeries series = reader.readVector(new File(args[0]));
        View view = new SwingView();
        view.display(series);
    }
}

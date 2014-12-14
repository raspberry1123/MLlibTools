package org.kou.ml.plot.viewer;

import org.jfree.data.xy.XYSeries;

import java.util.List;

/**
 * Created by kou on 2014/12/12.
 */
public interface View {
    public void display(XYSeries series, List<double[]> clusters);
}

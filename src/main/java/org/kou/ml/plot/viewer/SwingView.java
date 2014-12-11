package org.kou.ml.plot.viewer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kou on 2014/12/12.
 */
public class SwingView implements View {

    @Override
    public void display(XYSeries series) {

        XYSeriesCollection collection = new XYSeriesCollection();
        collection.addSeries(series);
        JFreeChart chart =
                ChartFactory.createScatterPlot(
                        null, "X", "Y",collection, PlotOrientation.VERTICAL,
                        false, false, false);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Scatter Plot");
        Dimension windowSize = new Dimension(800, 800);
        frame.setSize(windowSize);
        Container container = frame.getContentPane();
        container.setSize(windowSize);
        ChartPanel chartPanel = new ChartPanel(chart);
        container.add(chartPanel);
        frame.setVisible(true);
    }
}

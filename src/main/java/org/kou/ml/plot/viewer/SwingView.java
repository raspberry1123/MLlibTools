package org.kou.ml.plot.viewer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYShapeAnnotation;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.List;


/**
 * Created by kou on 2014/12/12.
 */
public class SwingView implements View {

    @Override
    public void display(XYSeries series, List<double[]> clusters) {

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
        JPanel clusterPanel = new JPanel();
        clusterPanel.setOpaque(true);
        clusterPanel.setSize(windowSize);
        frame.setVisible(true);
        if (clusters != null) {
            drawClusterCircle(chartPanel, clusters);
        }
    }

    private void drawClusterCircle(ChartPanel chartPanel, List<double[]> clusters) {

        for(double[] cluster :  clusters) {
            double centerX = cluster[0];
            double centerY = cluster[1];
            double radius = cluster[2];

            System.out.println((centerX - radius) + "," + (centerY - radius) + "," + 2 * radius + "," + 2 * radius);

            XYPlot plot = (XYPlot)chartPanel.getChart().getPlot();
            plot.addAnnotation(new XYShapeAnnotation(
                    new Ellipse2D.Double(
                            (int)Math.round(centerX - radius),
                            (int)Math.round(centerY - radius),
                            (int)Math.round(2 * radius),
                            (int)Math.round(2 * radius)),
                    new BasicStroke(3.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 10.0f), Color.GREEN));
        }
    }
}

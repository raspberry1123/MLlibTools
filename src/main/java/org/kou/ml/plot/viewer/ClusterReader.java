package org.kou.ml.plot.viewer;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by kou on 2014/12/14.
 */
public interface ClusterReader {

    public List<double[]> readClusterVector(File file) throws IOException;

}

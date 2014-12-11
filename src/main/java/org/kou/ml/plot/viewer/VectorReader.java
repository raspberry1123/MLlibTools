package org.kou.ml.plot.viewer;

import org.jfree.data.xy.XYSeries;
import java.io.File;
import java.io.IOException;

/**
 * Created by kou on 2014/12/12.
 */
public interface VectorReader {
    public XYSeries readVector(File file) throws IOException;
}

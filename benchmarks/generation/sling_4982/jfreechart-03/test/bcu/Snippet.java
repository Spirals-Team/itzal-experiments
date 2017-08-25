package bcu;

import java.awt.Button;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import junit.framework.TestCase;

import org.jfree.chart.plot.FastScatterPlot;

public class Snippet extends TestCase {

	public void test(){
			float[][] data = { { 1.0f, 2.0f }, { 3.0f, 4.0f } };
			FastScatterPlot thePlot = new FastScatterPlot(data, null, null);
			Button aButton = new Button();
			Graphics2D theGraphics = (Graphics2D) (aButton.getGraphics());
			thePlot.draw(theGraphics, new Rectangle2D.Float(),
					new Point2D.Float(), null, null);
	}
}

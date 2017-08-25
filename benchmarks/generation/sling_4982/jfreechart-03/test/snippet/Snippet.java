package snippet;

import java.awt.Button;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;
import org.jfree.chart.plot.FastScatterPlot;
import java.awt.Graphics2D;
import java.util.Calendar;

public class Snippet {

	public static void main(String[] args) {
		Calendar timer = Calendar.getInstance();
		try {
			float[][] data = { { 1.0f, 2.0f }, { 3.0f, 4.0f } };
			FastScatterPlot thePlot = new FastScatterPlot(data, null, null);
			Button aButton = new Button();
			Graphics2D theGraphics = (Graphics2D) (aButton.getGraphics());
			thePlot.draw(theGraphics, new Rectangle2D.Float(),
					new Point2D.Float(), null, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(Calendar.getInstance().getTimeInMillis()
				- timer.getTimeInMillis());

	}
}

package mlAlg;

import javax.swing.SwingUtilities;

public class MlAlgorithm {

	public static void main(String[] args) {
		int width = 1400;
		int height = 900;
		Data data = new Data();

		double covariance = (data.getxSum() * data.getySum()) - data.getLength() * data.getXYSum();
		double variance = (data.getxSum() * data.getxSum()) - data.getLength() * data.getXSquaredSum();
		double m = covariance / variance;
		double c = (data.getySum() / data.getLength()) - m * (data.getxSum() / data.getLength());

		System.out.println("Line is: Y = " + m + " X + " + c);
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new myFrame("Pixel Canvas", data.getRandom2Darray(75, width, height), width, height);
			}
		});
	}

}

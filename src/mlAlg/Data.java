package mlAlg;

public class Data {

	private int[] x = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	private int[] y = { 1, 3, 2, 5, 7, 8, 8, 9, 10, 12 };
	private double length = x.length;
	private double xSum = 0;
	private double ySum = 0;
	private double x2Sum = 0;
	private double y2Sum = 0;
	private double xySum = 0;
	private int[][] data2D;

	public double getLength() {
		return length;
	}
	
	public int[][] getRandom2Darray(int size, int width, int height) {
		int[][] rnd = new int[size][2];
		for (int i = 0; i < rnd.length; i++) {
			rnd[i][0] = (int) Math.abs((Math.random() * width) -1);
			rnd[i][1] = (int) Math.abs((Math.random() * height ) -1);
			
		}
		return rnd;
	}

	public double getxSum() {
		return xSum;
	}

	public double getySum() {
		return ySum;
	}

	public double getXSquaredSum() {
		return x2Sum;
	}

	public double getYSquaredSum() {
		return y2Sum;
	}

	public double getXYSum() {
		return xySum;
	}
	public int[][] get2DArray(){
		return data2D;
	}

	public Data() {
		data2D = new int[x.length][2];
		for (int i = 0; i < length; i++) {
			xSum += x[i];
			ySum += y[i];
			x2Sum += x[i] * x[i];
			y2Sum += y[i] * y[i];
			xySum += x[i] * y[i];
			data2D[i][0] = x[i];
			data2D[i][1] = y[i];
		}
	}
}

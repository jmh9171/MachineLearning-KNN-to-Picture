package mlAlg;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;

public class myCanvas extends Canvas {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int[][] points;
	private int width;
	private int height;

	public myCanvas(int[][] points, int width, int height) {

		setSize(width, height);
		this.points = points;
		this.width = width;
		this.height = height;
		
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		kNNalg(g2d, 0);
		g2d.dispose();
	}

	private void kNNalg(Graphics2D g2d, int n) {

		List<Color> gradient = new ArrayList<Color>();
		float colorCount = 300;
		for (float i = 0; i < 1; i += 1 / colorCount) {

			gradient.add(new Color(0, i, i, 1f));
		}
		int[] point2 = new int[2];
		// g2d.scale(5, 5);
		// for every x in canvas
		for (int x = 0; x < width; x++) {
			// for every y in canvas
			for (int y = 0; y < height; y++) {
				// point1 represents those points
				int[] point1 = { x, y };
				// array of distances from the array of points to every point in the canvas
				List<Integer> distances = new ArrayList<Integer>();
				// for every point in points array
				for (int i = 0; i < points.length; i++) {

					point2[0] = points[i][0];
					point2[1] = points[i][1];

					distances.add(distance(point1, point2));

				}

				Collections.sort(distances);
				int noise = distances.get(n);
				if (noise >= gradient.size()) {
					g2d.setColor(Color.white);
				} else {
					g2d.setPaint(gradient.get(noise % gradient.size()));
				}

				g2d.drawLine(x, y, x, y);

			}
		}

	}

	private int distance(int[] point1, int[] point2) {
		return (int) Math.sqrt(
				(point2[1] - point1[1]) * (point2[1] - point1[1]) + (point2[0] - point1[0]) * (point2[0] - point1[0]));
	}

	public void toJPG() throws IOException {
		BufferedImage bImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = bImage.createGraphics();
		kNNalg(g2d, 1 );
		g2d.dispose();
		File file = new File("Image.jpg");
		ImageIO.write(bImage, "jpg", file);
	}

}

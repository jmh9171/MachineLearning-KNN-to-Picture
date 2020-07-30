package mlAlg;

import java.awt.Canvas;

import javax.swing.JFrame;

public class myFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Canvas canvas;

	public myFrame(String title, int[][] points, int width, int height) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);
		this.setLocation(500, 150);
		canvas = new myCanvas(points,width,height);
		this.add(canvas);
		setVisible(true);
		
	}
}

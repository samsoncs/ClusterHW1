package tasks;

import api.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 * This is an implementation of the Task interface solving the Mandelbrot Set
 * Problem
 * 
 * @author Simen Aakhus, Anders Kristiansen, Eivind Kristoffersen and Samson Svendsen
 *
 */

public class TaskMandelbrotSet extends JFrame implements Task<Integer[][]> {

	private double cornerReal;
	private double cornerIm;
	private double length;
	private int n;
	private int iterationLim;

	/**
	 * Constructor that initializes the variables
	 * 
	 * @param cornerReal
	 *            real part of the coordinate of the lower left corner in the
	 *            complex plane
	 * @param cornerIm
	 *            imaginary part of the coordinate of the lower left corner in
	 *            the complex plane
	 * @param length
	 *            represents the edge length of a square in the complex plane
	 * @param n
	 *            complex plane is divided into n x n pixels
	 * @param iterationLim
	 *            defining which regions that are part of the Mandelbrot set
	 */
	public TaskMandelbrotSet(double cornerReal, double cornerIm, double length,
			int n, int iterationLim) {
		this.cornerReal = cornerReal;
		this.cornerIm = cornerIm;
		this.length = length;
		this.n = n;
		this.iterationLim = iterationLim;
	}

	@Override
	/**
	 * this method determines what complex numbers are part of the Mandelbrot Set
	 * @return returns the 2D Integer array containing the complex numbers in the Mandelbrot set
	 */
	public Integer[][] execute() {
		int n = getN();
		Integer[][] counts = new Integer[n][n];
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				double x = 0;
				double y = 0;
				double c_re = (col - n / 2.0) * getLength() / n;
				double c_im = (row - n / 2.0) * getLength() / n;
				int iterationCount = 0;
				while (x * x + y * y <= 4 && iterationCount < getIterationLim()) {
					double x_kplus1 = x * x - y * y + c_re;
					y = 2 * x * y + c_im;
					x = x_kplus1;
					iterationCount++;
				}
				counts[col][row] = iterationCount;
			}
		}
		return counts;
	}

	public double getCornerReal() {
		return cornerReal;
	}

	public double getCornerIm() {
		return cornerIm;
	}

	public double getLength() {
		return length;
	}

	public int getN() {
		return n;
	}

	public int getIterationLim() {
		return iterationLim;
	}

}
package tasks;

import api.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;

public class TaskMandelbrotSet extends JFrame implements Task<Integer[][]> {

    private double cornerReal;
    private double cornerIm;
    private double length;
    private int n;
    private int iterationLim;

    public TaskMandelbrotSet(double cornerReal, double cornerIm, double length, int n, int iterationLim) {
        this.cornerReal = cornerReal;
        this.cornerIm = cornerIm;
        this.length = length;
        this.n = n;
        this.iterationLim = iterationLim;
    }

    @Override
	public Integer[][] execute() {
        int n = getN();
        Integer[][] counts = new Integer[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                double x = 0;
                double y = 0;
                double c_re = (col - n/2.0)*getLength()/n;
                double c_im = (row - n/2.0)*getLength()/n;
                int iterationCount = 0;
                while (x*x + y*y <= 4 && iterationCount < getIterationLim()) {
                    double x_kplus1 = x*x - y*y + c_re;
                    y = 2*x*y + c_im;
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

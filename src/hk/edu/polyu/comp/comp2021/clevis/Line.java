package hk.edu.polyu.comp.comp2021.clevis;

import java.awt.Graphics;



public class Line extends Shape {

    static double EPS = 0.05;

    private double x1;
    private double y1;
    private double x2;
    private double y2;

    public Line(double x1, double y1, double x2, double y2)
    {
        this.x1 = x1; this.y1 = y1;
        this.x2 = x2; this.y2 = y2;
    }

    @Override
    public void draw(Graphics g) {
        g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
    }


}

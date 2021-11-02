package hk.edu.polyu.comp.comp2021.clevis;

import java.awt.Graphics;

public class Circle extends Shape {
    private double x;
    private double y;
    private double radius;

    public Circle(double x, double y, double radius)
    {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    @Override
    public void draw(Graphics g) {
        g.drawOval((int)(x-radius), (int)(y-radius), (int)radius*2, (int)radius*2);
    }
    @Override
    public boolean contains_point(double x,double y){
        return 0.05<=Math.sqrt((x-this.x)*(x-this.x)+(y-this.y)*(y-this.y));
    }
}

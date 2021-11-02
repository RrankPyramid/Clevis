package hk.edu.polyu.comp.comp2021.clevis;

import java.awt.Graphics;

public class Circle extends Shape {
    private int x;
    private int y;
    private int radius;

    public Circle(int x, int y, int radius)
    {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    @Override
    public void draw(Graphics g) {
        g.drawOval(x, y, radius*2, radius*2);
    }
}

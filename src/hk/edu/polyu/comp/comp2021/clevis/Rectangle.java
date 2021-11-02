package hk.edu.polyu.comp.comp2021.clevis;


import java.awt.*;

public class Rectangle extends Shape {
    private int x;
    private int y;
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectangle(int x, int y, int l) {
        this.x = x;
        this.y = y;
        this.width = l;
        this.height = l;
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect(x, y, width, height);
    }

}
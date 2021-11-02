package hk.edu.polyu.comp.comp2021.clevis;


import java.awt.*;

public class Rectangle extends Shape {
    private double x;
    private double y;
    private double width;
    private double height;

    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectangle(double x, double y, double l) {
        this.x = x;
        this.y = y;
        this.width = l;
        this.height = l;
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect((int)x, (int)y, (int)width, (int)height);
    }

    @Override
    public boolean containsPoint(double x, double y){
        return false;
    }

}
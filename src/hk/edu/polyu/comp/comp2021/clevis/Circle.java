package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.util.*;


import java.awt.Graphics;
import java.util.ArrayList;

public class Circle extends Shape {
    private Vertex center;
    private double radius;

    public Circle(Vertex center, double radius,int z) {
        this.center = center;
        this.radius = radius;
        this.zOrder = z;
    }


    @Override
    public void draw(Graphics g) {
        g.drawOval((int)(center.x-radius), (int)(center.y-radius), (int)radius*2, (int)radius*2);
    }

    @Override
    public boolean containPoint(Vertex p){
        return GraphConstant.EPS <= Math.abs(center.distanceTo(p)-radius);
    }

    @Override
    public void move(double dx, double dy) {
        center=center.add(new Vector(dx,dy));
    }

    @Override
    public Vertex getTopLeft(){
        return new Vertex(center.x-radius, center.y-radius);
    }


    @Override
    public Vertex getBottomRight(){
        return new Vertex(center.x+radius, center.y+radius);
    }

    @Override
    public String[] getInfo(String name){
        ArrayList<String> result = new ArrayList<>();
        result.add(name+"is a circle");
        result.add("Center : "+String.format("%.2f", center.x)+" "+String.format("%.2f", center.y));
        result.add("Radius : "+String.format("%.2f", radius));
        return (String[])result.toArray();
    }
    @Override
    public boolean intersect(Shape other){
        if(other instanceof Circle){
            Circle otherCircle = (Circle)other;
            return this.center.distanceTo(otherCircle.center)<=this.radius+otherCircle.radius;
        }
        if(other instanceof Line){
            Line otherLine = (Line)other;
            if(otherLine.x.distanceTo(center)<radius && otherLine.y.distanceTo(center)<radius)return false;
            else if(!(otherLine.x.distanceTo(center)<radius) && otherLine.y.distanceTo(center)<radius)return true;
            else if((otherLine.x.distanceTo(center)<radius) && !(otherLine.y.distanceTo(center)<radius))return true;
            else{ return otherLine.distanceTo(center)<=radius; }
        }
        if(other instanceof Square){
            return other.intersect(this);
        }
        if(other instanceof Group){
            other.intersect(this);
        }
        return false;
    }
}

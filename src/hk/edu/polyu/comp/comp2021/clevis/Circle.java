package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.util.*;


import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 */
public class Circle extends Shape {
    private Vertex center;
    private double radius;

    /**
     * @param center The centre of this circle
     * @param radius The radius of this circle
     * @param z The order the shapes have been added
     */
    public Circle(Vertex center, double radius,int z) {
        this.setCenter(center);
        this.setRadius(radius);
        this.setzOrder(z);
    }

    /**
     * @return The center of this circle
     */
    public Vertex getCenter() {
        return center;
    }

    /**
     * @param center The center of this circle
     */
    public void setCenter(Vertex center) {
        this.center = center;
    }

    /**
     * @return The radius of this circle
     */
    public double getRadius() {
        return radius;
    }

    /**
     * @param radius distance from the edge of the circle to the centre of the circle
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw(Graphics g) {
        g.drawOval((int)(getCenter().getX() - getRadius()), (int)(getCenter().getY() - getRadius()), (int) getRadius() *2, (int) getRadius() *2);
    }

    @Override
    public boolean containPoint(Vertex p){
        return GraphConstant.EPS >= Math.abs(getCenter().distanceTo(p)- getRadius());
    }

    @Override
    public void move(double dx, double dy) {
        setCenter(getCenter().add(new Vector(dx,dy)));
    }

    @Override
    public Vertex getTopLeft(){
        return new Vertex(getCenter().getX() - getRadius(), getCenter().getY() - getRadius());
    }


    @Override
    public Vertex getBottomRight(){
        return new Vertex(getCenter().getX() + getRadius(), getCenter().getY() + getRadius());
    }

    @Override
    public boolean intersect(Group other) {
        return other.intersect(this);
    }

    @Override
    public boolean intersect(Rectangle other) { return other.intersect(this); }

    @Override
    public boolean intersect(Circle otherCircle) {
        return this.getCenter().distanceTo(otherCircle.getCenter()) <= this.getRadius() + otherCircle.getRadius();
    }

    @Override
    public boolean intersect(Line otherLine){
            if(otherLine.getX().distanceTo(getCenter())< getRadius() && otherLine.getY().distanceTo(getCenter())< getRadius())return false;
            else if(!(otherLine.getX().distanceTo(getCenter())< getRadius()) && otherLine.getY().distanceTo(getCenter())< getRadius())return true;
            else if((otherLine.getX().distanceTo(getCenter())< getRadius()) && !(otherLine.getY().distanceTo(getCenter())< getRadius()))return true;
            else{ return otherLine.distanceTo(getCenter())<= getRadius(); }
    }

    @Override
    public ArrayList<String> getInfo(String name){
        ArrayList<String> result = new ArrayList<>();
        result.add(name+"is a circle");
        result.add("Center : "+String.format("%.2f", getCenter().getX())+" "+String.format("%.2f", getCenter().getY()));
        result.add("Radius : "+String.format("%.2f", getRadius()));
        return result;
    }
}

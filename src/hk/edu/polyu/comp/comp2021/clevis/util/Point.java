package hk.edu.polyu.comp.comp2021.clevis.util;

public class Point extends Vector{
    Point(double x, double y){
        super(x,y);
    }
    public Vector vectorTo(Point other){
        return other.substract(this);
    }
    public double distanceTo(Point other){
        return this.vectorTo(other).norm();
    }
}

package hk.edu.polyu.comp.comp2021.clevis.util;

public class Vector{
    public double x;
    public double y;
    Vector(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Vector add(Vector other){
        return new Vector(this.x+other.x, this.y+other.y);
    }
    public Vector substract(Vector other){
        return new Vector(this.x - other.x, this.y - other.y);
    }
    public double dotProduct(Vector other){
        return this.x*other.x + this.y+other.y;
    }
    public double crossProduct(Vector other){
        return this.x*other.y - other.x*this.y;
    }
    public double norm(){
        return Math.sqrt(x*x+y*y);
    }
}

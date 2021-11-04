package hk.edu.polyu.comp.comp2021.clevis.util;

public class Vertex extends Vector{
    public Vertex(double x, double y){
        super(x,y);
    }
    public Vector vectorTo(Vertex other){
        return other.substract(this);
    }
    public double distanceTo(Vertex other){
        return this.vectorTo(other).norm();
    }

    @Override
    public Vertex add(Vector other) {
        return (Vertex) super.add(other);
    }

    @Override
    public Vertex substract(Vector other) {
        return (Vertex)super.substract(other);
    }

    public static void main(String[] args) {
        Vertex a=new Vertex(3,4);
        Vector b = new Vector( 100,100);
        Vertex c = a.add(b);
        System.out.println(c.x+""+c.y);
    }
}

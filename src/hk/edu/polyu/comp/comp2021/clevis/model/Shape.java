package hk.edu.polyu.comp.comp2021.clevis.model;

import hk.edu.polyu.comp.comp2021.clevis.model.util.BinaryPair;
import hk.edu.polyu.comp.comp2021.clevis.model.util.Vertex;

import java.awt.*;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 *
 */
public abstract class Shape {

    private int groupCounter = 0;
    private int zOrder;
    private String name;
    private ArrayList<BinaryPair<Integer,Shape>> HistoryStatus = new ArrayList<>();

    /**
     * @param g Draw the Graphic
     */
    public abstract void draw(Graphics g);

    /**
     * @param name name of Shape
     * @return the imformation of the shape
     */
    public abstract ArrayList<String> getInfo(String name);

    public abstract void backtrace(int time);

    /**
     * @param p One point to check
     * @return Whether this shape contains this point
     */
    public abstract boolean containPoint(Vertex p);

    /**
     * @param dx Distance to move laterally
     * @param dy Distance travelled vertically
     */
    public abstract void move(double dx, double dy);

    /**
     * @return Return the Top-Left point of the Shape
     */
    public abstract Vertex getTopLeft();

    /**
     * @return Return the Bottom-Right point of the Shape
     */
    public abstract Vertex getBottomRight();

    /**
     * @param other Another shape
     *
     * use the reflection to get the method of the subclass
     *
     * @return Whether these two shapes are intersected
     */
    public boolean intersect(Shape other){
        Class<?> c = this.getClass();
        try {
            Method m = c.getMethod("intersect", other.getClass());
            return (boolean) m.invoke(this,other);
        }catch (Exception error){System.out.println("Oops...incorrect command, please try again");}
        return false;
    }


    /**
     * @return Returns how many groups the shape is contained by
     */
    public int getGroupCounter() {
        return groupCounter;
    }

    /**
     * @param groupCounter how many groups the shape is contained by
     */
    public void setGroupCounter(int groupCounter) {
        this.groupCounter = groupCounter;
    }

    /**
     * @return Returns the order the shapes have been added
     */
    public int getzOrder() {
        return zOrder;
    }

//    public boolean intersectCircle(Circle){}

    /**
     * @param zOrder The order the shapes have been added
     */
    public void setzOrder(int zOrder) {
        this.zOrder = zOrder;
    }

    public abstract void updateHistory(int x);

    public ArrayList<BinaryPair<Integer, Shape>> getHistoryStatus() {
        return HistoryStatus;
    }

    public void setHistoryStatus(ArrayList<BinaryPair<Integer, Shape>> historyStatus) {
        HistoryStatus = historyStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package hk.edu.polyu.comp.comp2021.clevis.model;

import hk.edu.polyu.comp.comp2021.clevis.model.util.Vertex;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import static hk.edu.polyu.comp.comp2021.clevis.model.util.GraphConstant.INF;

/**
 *
 */
public class Group extends Shape {
    private HashMap<String, Shape> list;

    /**
     * @param z The order the shapes have been added
     */
    public Group(int z) {
        setList(new HashMap<>());
        this.setzOrder(z);
    }

    /**
     * @param name The name of the shape
     * @param s    The Shape need to be add into group
     */
    public void add_Shape(String name, Shape s) {
        getList().put(name, s);
        s.setGroupCounter(s.getGroupCounter() + 1);
    }

    /**
     * @return the names of the Shape by decreasing Z-order
     */
    public String[] getName() {
        int max = Integer.MIN_VALUE;
        String[] shapes = getList().keySet().toArray(new String[getList().keySet().size()]);
        int temp = -1;
        for (int a = 0; a < shapes.length - 1; a++) {
            for (int x = a + 1; x < shapes.length; x++) {
                if (getList().get(shapes[x]).getzOrder() > max) {
                    temp = x;
                    max = getList().get(shapes[temp]).getzOrder();
                }
            }
            String x = shapes[temp];
            shapes[temp] = shapes[a];
            shapes[a] = x;
        }
        return shapes;
    }

    /**
     * @param countTab the number of indents required
     */
    public void printInfo(int countTab) {
        String[] toPrint = this.getName();
        for (String s : toPrint) {
            for (int x = 0; x < countTab; x++) {
                System.out.print("    ");
            }
            System.out.print(s);
            System.out.print("\n");
            if (getList().get(s) instanceof Group) {
                ((Group) getList().get(s)).printInfo(countTab + 1);
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        for (Shape s : this.getList().values()) {
            s.draw(g);
        }
    }

    @Override
    public boolean containPoint(Vertex p) {
        for (Shape s : getList().values()) {
            if (s.containPoint(p)) return true;
        }
        return false;
    }

    @Override
    public void move(double dx, double dy) {
        for (Shape s : getList().values()) {
            s.move(dx, dy);
        }
    }

    @Override
    public Vertex getTopLeft() {
        double min_x = INF;
        double min_y = INF;
        for (Shape s : getList().values()) {
            min_x = Math.min(min_x, s.getTopLeft().getX());
            min_y = Math.min(min_y, s.getTopLeft().getY());
        }
        return new Vertex(min_x, min_y);
    }

    @Override
    public Vertex getBottomRight() {
        double max_x = -INF;
        double max_y = -INF;
        for (Shape s : getList().values()) {
            max_x = Math.max(max_x, s.getBottomRight().getX());
            max_y = Math.max(max_y, s.getBottomRight().getY());
        }
        return new Vertex(max_x, max_y);
    }

    @Override
    public boolean intersect(Circle other) {
        for (Shape s : getList().values()) {
            if (s.intersect(other)) return true;
        }
        return false;
    }

    @Override
    public boolean intersect(Line other) {
        for (Shape s : getList().values()) {
            if (s.intersect(other)) return true;
        }
        return false;
    }

    @Override
    public boolean intersect(Rectangle other) {
        for (Shape s : getList().values()) {
            if (s.intersect(other)) return true;
        }
        return false;
    }

    @Override
    public boolean intersect(Group other) {
        for (Shape s : getList().values()) {
            if (s.intersect(other)) return true;
        }
        return false;
    }


    @Override
    public ArrayList<String> getInfo(String name) {
        ArrayList<String> result = new ArrayList<>();
        result.add(name + " is a group");
        result.add("Shape included : " + getList().keySet());
        return result;
    }

    /**
     * A HashMap stores the name and Shape
     * @return the hash map comtains name and shape
     */
    public HashMap<String, Shape> getList() {
        return list;
    }

    /**
     * @param list update the hashmap
     */
    public void setList(HashMap<String, Shape> list) {
        this.list = list;
    }
}

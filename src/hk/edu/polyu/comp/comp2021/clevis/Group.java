package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.util.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import static hk.edu.polyu.comp.comp2021.clevis.util.GraphConstant.INF;

public class Group extends Shape{
    protected HashMap<String,Shape> list;
    public Group(int z){
        list = new HashMap<>();
        this.zOrder = z;
    }
    public void add_Shape(String name,Shape s){
        list.put(name,s);
        s.groupCounter += 1;
    }

    public String[] getName(){
        int max = Integer.MIN_VALUE;
        String[] shapes = (String[])list.keySet().toArray();
        int temp=-1;
        for(int a = 0 ; a<shapes.length-1 ; a++){
            for(int x = a+1 ; x< shapes.length ; x++){
                if(list.get(shapes[x]).zOrder>max){
                    temp=x;
                    max = list.get(shapes[temp]).zOrder;
                }
            }
            String x = shapes[temp];
            shapes[temp]=shapes[a];
            shapes[a]=x;
        }
        return shapes;
    }

    public void printInfo(int countTab){
        String[] toPrint = this.getName();
        for(String s : toPrint){
            for(int x = 0 ; x<countTab ;x++){
                System.out.print("    ");
            }
            System.out.print(s);
            System.out.print("\n");
            if(list.get(s) instanceof Group){
                ((Group) list.get(s)).printInfo(countTab+1);
            }
        }
    }

    @Override
    public void draw(Graphics g){
        for (Shape s : this.list.values()){
            s.draw(g);
        }
    }

    @Override
    public boolean containPoint(Vertex p){
        for(Shape s : list.values()){
            if(s.containPoint(p))return true;
        }
        return false;
    }

    @Override
    public void move(double dx, double dy) {
        for(Shape s : list.values()){
            s.move(dx,dy);
        }
    }

    @Override
    public Vertex getTopLeft(){
        double min_x = INF;
        double min_y = INF;
        for (Shape s : list.values()){
            min_x = Math.min(min_x, s.getTopLeft().x);
            min_y = Math.min(min_y, s.getTopLeft().y);
        }
        return new Vertex(min_x, min_y);
    }

    @Override
    public Vertex getBottomRight() {
        double max_x = -INF;
        double max_y = -INF;
        for (Shape s : list.values()){
            max_x = Math.max(max_x, s.getBottomRight().x);
            max_y = Math.max(max_y, s.getBottomRight().y);
        }
        return new Vertex(max_x, max_y);
    }

    @Override
    public String[] getInfo(String name){
        ArrayList<String> result = new ArrayList<>();
        result.add(name+"is a group");
        result.add("Shape included : "+list.keySet());
        return (String[])result.toArray();
    }

}

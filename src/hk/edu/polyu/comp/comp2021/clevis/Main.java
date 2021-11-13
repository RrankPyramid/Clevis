package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.util.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    HashMap<String,Shape> Name_Shape = new HashMap<>();
    int z = 0;

    public void createRectangle(String name,double x,double y,double w,double h){
        Name_Shape.put(name,new Rectangle(new Vertex(x,y),new Vector(w,h),z));
        z++;
    }

    public void createLine(String name,double x1,double y1,double x2,double y2){
        Name_Shape.put(name , new Line(new Vertex(x1,y1),new Vertex(x2,y2),z));
        z++;
    }

    public void createCircle(String name,double x,double y,double r){
        Name_Shape.put(name, new Circle(new Vertex(x,y),r,z));
        z++;
    }

    public void createGroup(String name , ArrayList<String> shapeArrayList){
        Group group = new Group(z);
        z++;
        for(String s : shapeArrayList){
            Shape shape = Name_Shape.get(s);
            if(shape == null)
                throw new IllegalArgumentException();
            group.add_Shape(s,shape);
            Name_Shape.remove(s);
        }
        Name_Shape.put(name,group);
    }

    public void unGroup(String name){
        Shape shape = Name_Shape.get(name);
        if(! (shape instanceof Group))
            throw new IllegalArgumentException();
        Name_Shape.remove(name);
        Group group = (Group)shape;
        Name_Shape.putAll(group.list);
        for (Shape a : group.list.values()){
            a.groupCounter -= 1;
        }
    }
    public void pickAndMove(double x,double y,double dx,double dy){
        Shape temp = null;
        Vertex p = new Vertex(x,y);
        for(Shape s : Name_Shape.values()){
            if(s.containPoint(p)){
                if(temp==null)temp = s;
                else if(temp.zOrder<s.zOrder)temp=s;
            }
        }
        if(temp != null)temp.move(dx,dy);
    }

    public void delete(String name){
        Name_Shape.remove(name);
    }



}

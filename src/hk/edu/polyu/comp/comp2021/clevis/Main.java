package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.util.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    HashMap<String,Shape> Name_Shape = new HashMap<>();

    public void createRectangle(String name,double x,double y,double w,double h){
        Name_Shape.put(name,new Rectangle(new Vertex(x,y),new Vector(w,h)));
    }

    public void createLine(String name,double x1,double y1,double x2,double y2){
        Name_Shape.put(name , new Line(new Vertex(x1,y1),new Vertex(x2,y2)));
    }

    public void createCircle(String name,double x,double y,double r){
        Name_Shape.put(name, new Circle(new Vertex(x,y),r));
    }

    public void createGroup(String name , ArrayList<String> shapeArrayList){
        Group group = new Group();
        for(String s : shapeArrayList){
            group.add_Shape(s,Name_Shape.get(s));
            /*
            可以放个抓异常的，或者说在解析指令的时候就判一下所有的name是不是合法
             */
            Name_Shape.remove(s);
        }
        Name_Shape.put(name,group);
    }

    public void unGroup(String name){
        Group group = (Group)Name_Shape.get(name);
        Name_Shape.remove(name);
        Name_Shape.putAll(group.list);
        for (Shape a : group.list.values()){
            a.GroupCounter -= 1;
        }
    }

    public void delete(String name){
        Name_Shape.remove(name);
    }



}

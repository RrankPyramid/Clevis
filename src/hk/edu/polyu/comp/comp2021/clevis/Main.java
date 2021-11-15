package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.util.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    HashMap<String,Shape> Name_Shape;
    int z;
    public Main(){
        Name_Shape = new HashMap<>();
        z = 0;
    }


    public void createRectangle(String name,double x,double y,double w,double h){
        Name_Shape.put(name,new Rectangle(new Vertex(x,y),new Vector(w,h),z));
        z++;
    }

    public void createSquare(String name,double x,double y,double l){
        Name_Shape.put(name,new Square(new Vertex(x,y),new Vector(l,l),z));
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

    public void createGroup(String name , ArrayList<String>list){
        Group group = new Group(z);
        z++;
        for(String s : list){
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

    public void listAll(){
        String[] nameList = Name_Shape.keySet().toArray(new String[0]);
        int max = Integer.MIN_VALUE;
        int temp=-1;
        for(int a = 0 ; a<nameList.length-1 ; a++){
            for(int x = a+1 ; x< nameList.length ; x++){
                if(Name_Shape.get(nameList[x]).zOrder>max){
                    temp=x;
                    max = Name_Shape.get(nameList[temp]).zOrder;
                }
            }
            String x = nameList[temp];
            nameList[temp]=nameList[a];
            nameList[a]=x;
        }
        for (String s : nameList) {
            System.out.println(s);
            if (Name_Shape.get(s) instanceof Group) {
                ((Group) Name_Shape.get(s)).printInfo(1);
            }
        }

    }

    public boolean getCommand(){
        Scanner in = new Scanner(System.in);
        String command = in.nextLine();
        ArrayList<String> list = new ArrayList<>(Arrays.asList(command.split("\\s+")));
        String func = list.remove(0);
        switch (func) {
            case "rectangle": {
                String n = list.remove(0);
                double x = Double.parseDouble(list.remove(0));
                double y = Double.parseDouble(list.remove(0));
                double w = Double.parseDouble(list.remove(0));
                double h = Double.parseDouble(list.remove(0));
                createRectangle(n, x, y, w, h);
                System.out.println("Create successfully !");
                return true;
            }
            case "line": {
                String n = list.remove(0);
                double x1 = Double.parseDouble(list.remove(0));
                double y1 = Double.parseDouble(list.remove(0));
                double x2 = Double.parseDouble(list.remove(0));
                double y2 = Double.parseDouble(list.remove(0));
                createLine(n, x1, y1, x2, y2);
                System.out.println("Create successfully !");
                return true;
            }
            case "circle": {
                String n = list.remove(0);
                double x = Double.parseDouble(list.remove(0));
                double y = Double.parseDouble(list.remove(0));
                double r = Double.parseDouble(list.remove(0));
                createCircle(n, x, y, r);
                System.out.println("Create successfully !");
                return true;
            }
            case "square": {
                String n = list.remove(0);
                double x = Double.parseDouble(list.remove(0));
                double y = Double.parseDouble(list.remove(0));
                double l = Double.parseDouble(list.remove(0));
                createSquare(n,x,y,l);
                System.out.println("Create successfully !");
                return true;
            }
            case "group": {
                String n = list.remove(0);
                String[] ShapeArr = n.split("\\s+");
                ArrayList<String> groupList = new ArrayList<>(Arrays.asList(ShapeArr));
                String name = groupList.remove(0);
                createGroup(name, list);
                System.out.println("Create successfully !");
                return true;
            }
            case "ungroup": {
                String n = list.remove(0);
                unGroup(n);
                return true;
            }
            case "delete": {
                String n = list.remove(0);
                delete(n);
                return true;
            }
            case "boundingbox": {
                String n = list.remove(0);
                Vertex top_left = Name_Shape.get(n).getTopLeft();
                Vertex bottom_right = Name_Shape.get(n).getBottomRight();
                System.out.println(top_left.x+" "+top_left.y+" "+ (bottom_right.x - top_left.x)+" "+ (bottom_right.y-top_left.y));
                return true;
            }
            case "move": {
                String n = list.remove(0);
                double dx = Double.parseDouble(list.remove(0));
                double dy = Double.parseDouble(list.remove(0));
                Name_Shape.get(n).move(dx,dy);
                return true;
            }
            case "pick-and-move": {
                double x = Double.parseDouble(list.remove(0));
                double y = Double.parseDouble(list.remove(0));
                double dx = Double.parseDouble(list.remove(0));
                double dy = Double.parseDouble(list.remove(0));
                pickAndMove(x,y,dx,dy);
                return true;
            }
            case "list": {
                String n = list.remove(0);
                String[] out = Name_Shape.get(n).getInfo(n);
                System.out.println("========");
                for(String s : out){
                    System.out.println(s);
                }
                System.out.println("========");
                return true;
            }
            case "listAll": {
                listAll();
                return true;
            }
            case "intersect": {
                String n1 = list.remove(0);
                String n2 = list.remove(0);
                System.out.println( Name_Shape.get(n1).intersect(Name_Shape.get(n2)) );
            }
            case "quit": {
                return false;
            }

        }
        System.out.println("Oops...unknown command, please try again");
        return true;

    }

    public void start() {
        while(this.getCommand()){
            Picture pic = new Picture(700,700);
            for(Shape s : Name_Shape.values()){
                pic.add(s);
            }
            pic.draw();
        }

    }

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }



}

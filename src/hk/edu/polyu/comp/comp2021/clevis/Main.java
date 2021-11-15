package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.util.*;
import hk.edu.polyu.comp.comp2021.clevis.util.Vector;
import static hk.edu.polyu.comp.comp2021.clevis.util.GraphConstant.*;
import java.lang.reflect.Method;
import java.util.*;

/**
 *  The main operating modules
 */
public class Main {
    private HashMap<String,Shape> Name_Shape;
    private int z;

    /**
     * Constructor
     * Initialize the parameters
     */
    public Main(){
        setName_Shape(new HashMap<>());
        setZ(0);
    }

    /**
     * @param name  Name of the shape to be checked
     * @return Returns whether the name is already occupied
     */
    public boolean alreadyExist (String name){
        return getName_Shape().containsKey(name);
    }

    /**
     * @param name Problems with which shape is running
     */
    public void existErr(String name){
        System.out.println("Already have a shape named \""+name+"\"");
    }

    /**
     *
     */
    public void createSuccess(){
        System.out.println("Create successfully !");
    }


    /**
     * @param name Name of the rectangle
     * @param x The horizontal coordinate of the top left corner
     * @param y The vertical coordinate of the top left corner
     * @param w The Width of the rectangle
     * @param h The height of the rectangle
     */
    public void createRectangle(String name,double x,double y,double w,double h){
        if(alreadyExist(name)){existErr(name);return;}
        getName_Shape().put(name,new Rectangle(new Vertex(x,y),new Vector(w,h), getZ()));
        setZ(getZ() + 1);
        createSuccess();
    }

    /**
     * @param name Name of the rectangle
     * @param x The horizontal coordinate of the top left corner
     * @param y The vertical coordinate of the top left corner
     * @param l The side length of the rectangle
     */
    public void createSquare(String name,double x,double y,double l){
        if(alreadyExist(name)){existErr(name);return;}
        getName_Shape().put(name,new Square(new Vertex(x,y),new Vector(l,l), getZ()));
        setZ(getZ() + 1);
        createSuccess();
    }

    /**
     * @param name Name of the line
     * @param x1 The horizontal coordinate of the start node
     * @param y1 The vertical coordinate of the start node
     * @param x2 The horizontal coordinate of the end node
     * @param y2 The vertical coordinate of the end node
     */
    public void createLine(String name,double x1,double y1,double x2,double y2){
        if(alreadyExist(name)){existErr(name);return;}
        getName_Shape().put(name , new Line(new Vertex(x1,y1),new Vertex(x2,y2), getZ()));
        setZ(getZ() + 1);
        createSuccess();
    }

    /**
     * @param name Name of the Circle
     * @param x The horizontal coordinate of the center
     * @param y The vertical coordinate of the center
     * @param r The radius of the Circle
     */
    public void createCircle(String name,double x,double y,double r){
        if(alreadyExist(name)){existErr(name);return;}
        getName_Shape().put(name, new Circle(new Vertex(x,y),r, getZ()));
        setZ(getZ() + 1);
        createSuccess();
    }

    /**
     * @param name Name of the group
     * @param list List of Shape need to be add in to group
     */
    public void createGroup(String name , ArrayList<String>list){
        if(alreadyExist(name)){existErr(name);return;}
        Group group = new Group(getZ());
        setZ(getZ() + 1);
        for(String s : list){
            Shape shape = getName_Shape().get(s);
            if(shape == null)
                throw new IllegalArgumentException();
            group.add_Shape(s,shape);
            getName_Shape().remove(s);
        }
        getName_Shape().put(name,group);
        createSuccess();
    }

    /**
     * @param name Name of the Group you want to ungroup
     */
    public void unGroup(String name){
        if(!alreadyExist(name)){System.out.println("Cannot find group"+name);return;}
        Shape shape = getName_Shape().get(name);
        if(! (shape instanceof Group)){
            System.out.println(name + " is not a group");
        }else{
            getName_Shape().remove(name);
            Group group = (Group)shape;
            getName_Shape().putAll(group.getList());
            for (Shape a : group.getList().values()){
                a.setGroupCounter(a.getGroupCounter() - 1);
            }
        }
    }

    /**
     * @param x The horizontal coordinate of the node you need to pick
     * @param y The vertical coordinate of the node you need to pick
     * @param dx Distance travelled horizontally
     * @param dy Distance travelled vertically
     */
    public void pickAndMove(double x,double y,double dx,double dy){
        Shape temp = null;
        Vertex p = new Vertex(x,y);
        for(Shape s : getName_Shape().values()){
            if(s.containPoint(p)){
                if(temp==null)temp = s;
                else if(temp.getzOrder() < s.getzOrder())temp=s;
            }
        }
        if(temp != null){
            temp.move(dx,dy);
            System.out.println("Already moved");
        }else{System.out.println("Cannot find a shape contains that point"); }
    }

    /**
     * @param name The name of shape you want to delete
     */
    public void delete(String name){
        getName_Shape().remove(name);
        System.out.println("Already delete.");
    }

    /**
     * List all the shape in decreasing Z order
     */
    public void listAll(){
        String[] nameList = getName_Shape().keySet().toArray(new String[0]);
        int max = Integer.MIN_VALUE;
        int temp=-1;
        for(int a = 0 ; a<nameList.length-1 ; a++){
            for(int x = a+1 ; x< nameList.length ; x++){
                if(getName_Shape().get(nameList[x]).getzOrder() >max){
                    temp=x;
                    max = getName_Shape().get(nameList[temp]).getzOrder();
                }
            }
            String x = nameList[temp];
            nameList[temp]=nameList[a];
            nameList[a]=x;
        }
        for (String s : nameList) {
            System.out.println(s);
            if (getName_Shape().get(s) instanceof Group) {
                ((Group) getName_Shape().get(s)).printInfo(1);
            }
        }
    }

    /**
     * Output the error massage
     */
    public void err(){
        System.out.println("Oops...incorrect command, please try again");
    }

    /**
     * @return whether to continue
     *
     * Get the user input and parse its parameters
     * Execute the corresponding function according to the command content
     */
    public boolean getCommand() {
        Scanner in = new Scanner(System.in);
        String command = in.nextLine();
        ArrayList<String> list = new ArrayList<>(Arrays.asList(command.split("\\s+")));
        String func = list.remove(0);
        int size = list.size();
        switch (func) {
            case "rectangle": {
                if(size!=5){
                    err();
                    break;
                }
                String n = list.remove(0);
                double x = Double.parseDouble(list.remove(0));
                double y = Double.parseDouble(list.remove(0));
                double w = Double.parseDouble(list.remove(0));
                double h = Double.parseDouble(list.remove(0));
                createRectangle(n, x, y, w, h);
                break;
            }


            case "line": {
                if(size!=5){
                    err();
                    break;
                }
                String n = list.remove(0);
                double x1 = Double.parseDouble(list.remove(0));
                double y1 = Double.parseDouble(list.remove(0));
                double x2 = Double.parseDouble(list.remove(0));
                double y2 = Double.parseDouble(list.remove(0));
                createLine(n, x1, y1, x2, y2);
                break;
            }
            case "circle": {
                if(size!=4){
                    err();
                    break;
                }
                String n = list.remove(0);
                double x = Double.parseDouble(list.remove(0));
                double y = Double.parseDouble(list.remove(0));
                double r = Double.parseDouble(list.remove(0));
                createCircle(n, x, y, r);
                break;
            }
            case "square": {
                if(size!=4){
                    err();
                    break;
                }
                String n = list.remove(0);
                double x = Double.parseDouble(list.remove(0));
                double y = Double.parseDouble(list.remove(0));
                double l = Double.parseDouble(list.remove(0));
                createSquare(n,x,y,l);
                break;
            }
            case "group": {
                if(size<=1){
                    err();
                    break;
                }
                String n = list.remove(0);
                createGroup(n,list);
                break;
            }
            case "ungroup": {
                if(size!=1){
                    err();
                    break;
                }
                String n = list.remove(0);
                unGroup(n);
                break;
            }
            case "delete": {
                if(size!=1){
                    err();
                    break;
                }
                String n = list.remove(0);
                delete(n);
                break;
            }
            case "boundingbox": {
                if(size!=1){
                    err();
                    break;
                }
                String n = list.remove(0);
                Vertex top_left = getName_Shape().get(n).getTopLeft();
                Vertex bottom_right = getName_Shape().get(n).getBottomRight();
                System.out.println(top_left.getX() +" "+ top_left.getY() +" "+ (bottom_right.getX() - top_left.getX())+" "+ (bottom_right.getY() - top_left.getY()));
                break;
            }
            case "move": {
                if(size!=3){
                    err();
                    break;
                }
                String n = list.remove(0);
                double dx = Double.parseDouble(list.remove(0));
                double dy = Double.parseDouble(list.remove(0));
                getName_Shape().get(n).move(dx,dy);
                break;
            }
            case "pick-and-move": {
                if(size!=4){
                    err();
                    break;
                }
                double x = Double.parseDouble(list.remove(0));
                double y = Double.parseDouble(list.remove(0));
                double dx = Double.parseDouble(list.remove(0));
                double dy = Double.parseDouble(list.remove(0));
                pickAndMove(x,y,dx,dy);
                break;
            }
            case "list": {
                if(size!=1){
                    err();
                    break;
                }
                String n = list.remove(0);
                ArrayList<String> out = getName_Shape().get(n).getInfo(n);
                System.out.println("========");
                for(String s : out){
                    System.out.println(s);
                }
                System.out.println("========");
                break;
            }
            case "listAll": {
                if(size!=0){
                    err();
                    break;
                }
                listAll();
                break;
            }
            case "intersect": {
                if(size!=2){
                    err();
                    break;
                }
                String n1 = list.remove(0);
                String n2 = list.remove(0);

                Shape s1 =getName_Shape().get(n1);
                Shape s2 =getName_Shape().get(n2);

                Class<?> c = s1.getClass();
                try{
                    Method m = c.getMethod("intersect",s2.getClass());
                    boolean result = (boolean)m.invoke(s1,s2);
                    System.out.println(result);
                }catch(Exception ignored) {err();}


                break;
            }
            case "quit": {
                return false;
            }
            default:{
                System.out.println("Oops...unknown command, please try again");
            }
        }

        return true;

    }

    /**
     * Launch the application
     */
    public void start() {
        Picture pic = new Picture(WIDTH,HEIGHT);
        while(this.getCommand()){
            pic.removeAllShape();
            pic.repaint();
            for(Shape s : getName_Shape().values()){
                pic.add(s);
            }
            pic.draw();
        }

    }

    /**
     * @param args Default parameters
     */
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }


    /**
     * @return The Name_Shape (Hashmap, contains name and corresponding shape )
     */
    public HashMap<String, Shape> getName_Shape() {
        return Name_Shape;
    }

    /**
     * @param name_Shape update the HashMap
     */
    public void setName_Shape(HashMap<String, Shape> name_Shape) {
        Name_Shape = name_Shape;
    }

    /**
     * @return return the z_Order
     */
    public int getZ() {
        return z;
    }

    /**
     * @param z  the Z_order
     */
    public void setZ(int z) {
        this.z = z;
    }
}
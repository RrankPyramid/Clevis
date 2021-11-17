package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.model.*;
import hk.edu.polyu.comp.comp2021.clevis.model.Line;
import hk.edu.polyu.comp.comp2021.clevis.model.util.Vector;
import hk.edu.polyu.comp.comp2021.clevis.model.util.Vertex;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import static hk.edu.polyu.comp.comp2021.clevis.model.util.GraphConstant.HEIGHT;
import static hk.edu.polyu.comp.comp2021.clevis.model.util.GraphConstant.WIDTH;

/**
 * The main operating modules
 */
public class Main {
    private HashMap<String, Shape> Name_Shape;
    private int z;

    /**
     * Constructor
     * Initialize the parameters
     */
    public Main() {
        setName_Shape(new HashMap<>());
        setZ(0);
    }

    /**
     * @param commands The list of command that successfully executed
     * @param fileName The name of the txt file which will be used to store the record
     */
    public static void writeInTxt(@NotNull ArrayList<String> commands, String fileName) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
            for (String s : commands) {
                out.write(s);
                out.write("\n");
            }
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param commands The list of command that successfully executed
     * @param fileName The name of the html file which will be used to store the record
     */

    public static void writeInHtml(@NotNull ArrayList<String> commands, String fileName) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
            int index = 1;
            out.write("<table border = \"1\">");
            for (String s : commands) {
                out.write("<tr>\n");
                out.write("<td>");
                out.write(Integer.toString(index));
                out.write("</td>\n");
                out.write("<td>");
                out.write(s);
                out.write("</td>\n");
                out.write("</tr>\n");
                index += 1;
            }
            out.write("</table>");
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args Default parameters
     */
    public static void main(String[] args) {
        Main app = new Main();
        ArrayList<String> commands = app.start();
        writeInHtml(commands, "log.html");
        writeInTxt(commands, "log.txt");
    }

    /**
     * @param name Name of the shape to be checked
     * @return Returns whether the name is already occupied
     */
    public boolean isExist(String name) {
        return getName_Shape().containsKey(name);
    }

    /**
     * @param name the name need check
     * @return whether this shape is in a group
     */
    public boolean isGrouped(String name) {
        return getName_Shape().get(name).getGroupCounter() != 0;
    }

    /**
     * @param name The shape that cannot reach
     */
    public void unreachable(String name) {
        System.out.println("Sorry, " + name + " is grouped");
    }

    /**
     * @param name Problems with which shape is running
     */
    public void notExistErr(String name) {
        System.out.println("\"" + name + "\" does not exist");
    }

    /**
     * @param name Problems with which shape is running
     */
    public void existErr(String name) {
        System.out.println("Already have a shape named \"" + name + "\"");
    }

    /**
     * Output the success message
     */
    public void createSuccess() {
        System.out.println("Create successfully !");
    }

    /**
     * @param name Name of the rectangle
     * @param x    The horizontal coordinate of the top left corner
     * @param y    The vertical coordinate of the top left corner
     * @param w    The Width of the rectangle
     * @param h    The height of the rectangle
     */
    public void createRectangle(String name, double x, double y, double w, double h) {
        if (isExist(name)) {
            existErr(name);
            return;
        }
        getName_Shape().put(name, new Rectangle(new Vertex(x, y), new Vector(w, h), getZ()));
        setZ(getZ() + 1);
        createSuccess();
    }

    /**
     * @param name Name of the rectangle
     * @param x    The horizontal coordinate of the top left corner
     * @param y    The vertical coordinate of the top left corner
     * @param l    The side length of the rectangle
     */
    public void createSquare(String name, double x, double y, double l) {
        if (isExist(name)) {
            existErr(name);
            return;
        }
        getName_Shape().put(name, new Square(new Vertex(x, y), new Vector(l, l), getZ()));
        setZ(getZ() + 1);
        createSuccess();
    }

    /**
     * @param name Name of the line
     * @param x1   The horizontal coordinate of the start node
     * @param y1   The vertical coordinate of the start node
     * @param x2   The horizontal coordinate of the end node
     * @param y2   The vertical coordinate of the end node
     */
    public void createLine(String name, double x1, double y1, double x2, double y2) {
        if (isExist(name)) {
            existErr(name);
            return;
        }
        getName_Shape().put(name, new Line(new Vertex(x1, y1), new Vertex(x2, y2), getZ()));
        setZ(getZ() + 1);
        createSuccess();
    }

    /**
     * @param name Name of the Circle
     * @param x    The horizontal coordinate of the center
     * @param y    The vertical coordinate of the center
     * @param r    The radius of the Circle
     */
    public void createCircle(String name, double x, double y, double r) {
        if (isExist(name)) {
            existErr(name);
            return;
        }
        getName_Shape().put(name, new Circle(new Vertex(x, y), r, getZ()));
        setZ(getZ() + 1);
        createSuccess();
    }

    /**
     * @param name Name of the group
     * @param list List of Shape need to be add in to group
     */
    public void createGroup(String name, ArrayList<String> list) {
        if (isExist(name)) {
            existErr(name);
            return;
        }
        Group group = new Group(getZ());
        setZ(getZ() + 1);
        for (String s : list) {
            Shape shape = getName_Shape().get(s);
            if (shape == null) {
                notExistErr(s);
                return;
            }
            group.add_Shape(s, shape);
        }
        getName_Shape().put(name, group);
        createSuccess();
    }

    /**
     * @param name Name of the Group you want to ungroup
     */
    public void unGroup(String name) {
        if (isGrouped(name)) {
            unreachable(name);
            return;
        }
        Shape shape = getName_Shape().get(name);
        if (!(shape instanceof Group)) {
            System.out.println(name + " is not a group");
        } else {
            getName_Shape().remove(name);
            Group group = (Group) shape;
            for (Shape a : group.getList().values()) {
                a.setGroupCounter(a.getGroupCounter() - 1);
            }
            System.out.println("Ungroup successfully");
        }
    }

    /**
     * @param x  The horizontal coordinate of the node you need to pick
     * @param y  The vertical coordinate of the node you need to pick
     * @param dx Distance travelled horizontally
     * @param dy Distance travelled vertically
     */
    public void pickAndMove(double x, double y, double dx, double dy) {
        Shape temp = null;
        Vertex p = new Vertex(x, y);
        for (Shape s : getName_Shape().values()) {
            if (s.getGroupCounter() != 0) continue;
            if (s.containPoint(p)) {
                if (temp == null) temp = s;
                else if (temp.getzOrder() < s.getzOrder()) temp = s;
            }
        }

        if (temp != null) {
            temp.move(dx, dy);
            System.out.println("Already moved");
        } else {
            System.out.println("Cannot find a shape contains that point");
        }
    }

    /**
     * @param name The name of shape you want to delete
     */
    public void delete(String name) {
        if (!isExist(name)) {
            notExistErr(name);
            return;
        }
        if (isGrouped(name)) {
            unreachable(name);
            return;
        }

        if(getName_Shape().get(name) instanceof Group){
            for(String s : ((Group) getName_Shape().get(name)).getList().keySet()){
                getName_Shape().remove(s);
            }
        }
        getName_Shape().remove(name);
        System.out.println("Already delete.");
    }

    /**
     * List all the shape in decreasing Z order
     */
    public void listAll() {
        String[] nameList = getName_Shape().keySet().toArray(new String[0]);

        int temp = -1;
        for (int a = 0; a < nameList.length - 1; a++) {
            int max = Integer.MIN_VALUE;
            for (int x = a + 1; x < nameList.length; x++) {
                if (getName_Shape().get(nameList[x]).getzOrder() > max) {
                    temp = x;
                    max = getName_Shape().get(nameList[temp]).getzOrder();
                }
            }
            String x = nameList[temp];
            nameList[temp] = nameList[a];
            nameList[a] = x;
        }
        System.out.println("========");
        for (int x = 0; x < nameList.length; x++) {
            System.out.println(nameList[x]);
            if (getName_Shape().get(nameList[x]) instanceof Group) {
                ((Group) getName_Shape().get(nameList[x])).printInfo(1);
            }
        }
        System.out.println("========");
    }

    /**
     * Output the error massage
     */
    public void err() {
        System.out.println("Oops...incorrect command, please try again");
    }

    /**
     * @param command The command that user enter
     * @return whether to continue
     * <p>
     * Get the user input and parse its parameters
     * Execute the corresponding function according to the command content
     * <p>
     * Determine how many parameters should be read and what function should be used subsequently
     * by judging the first parameter
     */
    public boolean getCommand(String command) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(command.split("\\s+")));
        String func = list.remove(0);
        int size = list.size();
        switch (func) {
            case "rectangle": {
                if (size != 5) {
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
                if (size != 5) {
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
                if (size != 4) {
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
                if (size != 4) {
                    err();
                    break;
                }
                String n = list.remove(0);
                double x = Double.parseDouble(list.remove(0));
                double y = Double.parseDouble(list.remove(0));
                double l = Double.parseDouble(list.remove(0));
                createSquare(n, x, y, l);
                break;
            }
            case "group": {
                if (size <= 1) {
                    err();
                    break;
                }
                String n = list.remove(0);
                createGroup(n, list);
                break;
            }
            case "ungroup": {
                if (size != 1) {
                    err();
                    break;
                }
                String n = list.remove(0);
                if (!isExist(n)) {
                    notExistErr(n);
                    return true;
                }
                unGroup(n);
                break;
            }
            case "delete": {
                if (size != 1) {
                    err();
                    break;
                }
                String n = list.remove(0);
                if (!isExist(n)) {
                    notExistErr(n);
                    return true;
                }
                delete(n);
                break;
            }
            case "boundingbox": {
                if (size != 1) {
                    err();
                    break;
                }
                String n = list.remove(0);
                if (!isExist(n)) {
                    notExistErr(n);
                    return true;
                }
                if (isGrouped(n)) {
                    unreachable(n);
                    return true;
                }
                Vertex top_left = getName_Shape().get(n).getTopLeft();
                Vertex bottom_right = getName_Shape().get(n).getBottomRight();
                System.out.println(top_left.getX() + " " + top_left.getY() + " " + (bottom_right.getX() - top_left.getX()) + " " + (bottom_right.getY() - top_left.getY()));
                break;
            }
            case "move": {
                if (size != 3) {
                    err();
                    break;
                }
                String n = list.remove(0);
                if (!isExist(n)) {
                    notExistErr(n);
                    return true;
                }
                if (isGrouped(n)) {
                    unreachable(n);
                    return true;
                }
                double dx = Double.parseDouble(list.remove(0));
                double dy = Double.parseDouble(list.remove(0));
                getName_Shape().get(n).move(dx, dy);
                System.out.println("Move successfully!");
                break;
            }
            case "pick-and-move": {
                if (size != 4) {
                    err();
                    break;
                }
                double x = Double.parseDouble(list.remove(0));
                double y = Double.parseDouble(list.remove(0));
                double dx = Double.parseDouble(list.remove(0));
                double dy = Double.parseDouble(list.remove(0));
                pickAndMove(x, y, dx, dy);
                break;
            }
            case "list": {
                if (size != 1) {
                    err();
                    break;
                }
                String n = list.remove(0);
                if (!isExist(n)) {
                    notExistErr(n);
                    return true;
                }
                if (isGrouped(n)) {
                    unreachable(n);
                    return true;
                }
                ArrayList<String> out = getName_Shape().get(n).getInfo(n);
                System.out.println("========");
                for (String s : out) {
                    System.out.println(s);
                }
                System.out.println("========");
                break;
            }
            case "listAll": {
                if (size != 0) {
                    err();
                    break;
                }
                listAll();
                break;
            }
            case "intersect": {
                if (size != 2) {
                    err();
                    break;
                }

                String n1 = list.remove(0);
                String n2 = list.remove(0);
                if (!isExist(n1)) {
                    notExistErr(n1);
                    return true;
                }
                if (!isExist(n2)) {
                    notExistErr(n2);
                    return true;
                }
                Shape s1 = getName_Shape().get(n1);
                Shape s2 = getName_Shape().get(n2);

                Class<?> c = s1.getClass();
                try {
                    Method m = c.getMethod("intersect", s2.getClass());
                    boolean result = (boolean) m.invoke(s1, s2);
                    System.out.println(result);
                } catch (Exception ignored) {
                    err();
                }


                break;
            }
            case "quit": {
                return false;
            }
            default: {
                System.out.println("Oops...unknown command, please try again");
            }
        }

        return true;

    }

    /**
     * Launch the application
     *
     * @return return the list of command that successfully executed
     */
    public ArrayList<String> start() {
        Picture pic = new Picture(WIDTH, HEIGHT);
        ArrayList<String> commandRecord = new ArrayList<>();
        ArrayList<String> undo_Record = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String command = in.nextLine();
        while (true) {

            if(! this.getCommand(command))break;
            commandRecord.add(command);
            pic.removeAllShape();
            pic.repaint();
            for (Shape s : getName_Shape().values()) {
                pic.add(s);
            }
            pic.draw();
            command = in.nextLine();
        }
        pic.dispose();
        return commandRecord;
    }

//    /**
//     * @param command
//     * @param commandRecord
//     * @param undoCommand
//     * @return
//     */
//    public boolean undo_redo(String command,ArrayList<String> commandRecord,ArrayList<String> undoCommand){
//        ArrayList<String> list = new ArrayList<>(Arrays.asList(command.split("\\s+")));
//        String func = list.remove(0);
//        switch (func){
//            case "undo": {
//
//            }
//        }
//    }
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
     * @param z the Z_order
     */
    public void setZ(int z) {
        this.z = z;
    }
}
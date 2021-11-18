package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.model.Group;
import hk.edu.polyu.comp.comp2021.clevis.model.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Application Launcher
 */
public class Application {

    /**
     * Width of right side
     */
    public static final int WIDTH = 250;
    /**
     * Number of back button
     */
    public static final int NUM_OF_BACK = 12;
    /**
     * number of confirm buttom
     */
    public static final int NUM_OF_COMFIRM = 12;
    /**
     * the location of frame
     */
    public static final int FRAME_X = 300;
    /**
     * the location of frame
     */
    public static final int FRAME_Y = 200;
    /**
     * the width of frame
     */
    public static final int FRAME_WIDTH1 = 800;
    /**
     * the height of frame
     */
    public static final int FRAME_HEIGHT = 800;

    /**
     * Run the application
     */
    public Application() {
    }

    /**
     * @param args Parameters entered at launch
     */
    public static void main(String[] args) {

        Main run = Main.getInstance();
        String file_html = args[0];
        String file_txt = args[1];

        JFrame frame = new JFrame("Clevis");
        JPanel jp = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Shape s : run.getName_Shape().values()) {
                    s.draw(g);
                }
            }
        };


        ArrayList<JPanel> panellist = new ArrayList<>();
        JPanel allPanel = new JPanel(new CardLayout());

        CardLayout cardLayout = (CardLayout) (allPanel.getLayout());
        cardLayout.show(allPanel, "card1");

        jp.setBackground(Color.white);

        JPanel controler = new JPanel();
        allPanel.setPreferredSize(new Dimension(WIDTH, 0));

        JButton rectangleButton = new JButton("Rectangle");
        JButton circleButton = new JButton("Circle");
        JButton squareButton = new JButton("Square");
        JButton lineButton = new JButton("Line");
        JButton group = new JButton("Group");
        JButton ungroup = new JButton("Ungroup");
        JButton pick_and_move = new JButton("Pick and Move");
        JButton list = new JButton("List");
        JButton intersect = new JButton("Intersect");
        JButton move = new JButton("Move");
        JButton bounding = new JButton("BoundingBox");
        JButton delete = new JButton("Delete");
        JButton undo = new JButton("Undo");
        JButton redo = new JButton("Redo");
        JButton listAll = new JButton("List All");
        JButton[] back = new JButton[NUM_OF_BACK];
        for (int x = 0; x < NUM_OF_BACK; x++) {
            back[x] = new JButton("Back");
            back[x].addActionListener(e -> cardLayout.show(allPanel, "control"));
        }
        JButton[] confirm = new JButton[NUM_OF_COMFIRM];
        for (int x = 0; x < NUM_OF_COMFIRM; x++) {
            confirm[x] = new JButton("Confirm");
        }


        controler.add(rectangleButton);
        controler.add(circleButton);
        controler.add(lineButton);
        controler.add(squareButton);
        controler.add(group);
        controler.add(ungroup);
        controler.add(pick_and_move);
        controler.add(list);
        controler.add(intersect);
        controler.add(move);
        controler.add(bounding);
        controler.add(delete);
        controler.add(listAll);
        controler.add(undo);
        controler.add(redo);


        controler.setLayout(new GridLayout(6, 6, 5, 5));

        JPanel rectangleJP = new JPanel();
        rectangleJP.setLayout(new FlowLayout(FlowLayout.LEFT));
//        rectangleJP.setLayout(new GridLayout(null,1,20,20));
        JLabel recName = new JLabel("Name :");
        JLabel recX = new JLabel("X    :");
        JLabel recY = new JLabel("   Y    :");
        JLabel recW = new JLabel("W    :");
        JLabel recH = new JLabel("   H    :");
        JTextField getrectangleName = new JTextField(5);
        JTextField getrectangleX = new JTextField(5);
        JTextField getrectangleY = new JTextField(5);
        JTextField getrectangleW = new JTextField(5);
        JTextField getrectangleH = new JTextField(5);
        rectangleJP.add(recName);
        rectangleJP.add(getrectangleName);
        rectangleJP.add(recX);
        rectangleJP.add(getrectangleX);
        rectangleJP.add(recY);
        rectangleJP.add(getrectangleY);
        rectangleJP.add(recW);
        rectangleJP.add(getrectangleW);
        rectangleJP.add(recH);
        rectangleJP.add(getrectangleH);
        rectangleJP.add(confirm[0]);
        confirm[0].addActionListener(e -> {
            String recCmd = "rectangle " + getrectangleName.getText() + " " + getrectangleX.getText() + " " + getrectangleY.getText() + " " + getrectangleW.getText() + " " + getrectangleH.getText();
            run.getCommand(recCmd);
            getrectangleName.setText("");
            getrectangleX.setText("");
            getrectangleY.setText("");
            getrectangleW.setText("");
            getrectangleH.setText("");
            cardLayout.show(allPanel, "control");
            frame.repaint();
        });
        panellist.add(rectangleJP);


        JPanel circleJP = new JPanel();
        circleJP.setLayout(new FlowLayout(FlowLayout.LEFT));
        JTextField getcircleName = new JTextField(5);
        JTextField getcircleX = new JTextField(5);
        JTextField getcircleY = new JTextField(5);
        JTextField getcircleR = new JTextField(5);
        circleJP.add(new JLabel("Name :"));
        circleJP.add(getcircleName);
        circleJP.add(new JLabel("X    :"));
        circleJP.add(getcircleX);
        circleJP.add(new JLabel("   Y    :"));
        circleJP.add(getcircleY);
        circleJP.add(new JLabel("R    :"));
        circleJP.add(getcircleR);
        circleJP.add(confirm[1]);
        confirm[1].addActionListener(e -> {
            String cirCmd = "circle " + getcircleName.getText() + " " + getcircleX.getText() + " " + getcircleY.getText() + " " + getcircleR.getText();
            run.getCommand(cirCmd);
            getcircleName.setText("");
            getcircleX.setText("");
            getcircleY.setText("");
            getcircleR.setText("");
            cardLayout.show(allPanel, "control");
            frame.repaint();
        });
        panellist.add(circleJP);

        JPanel lineJP = new JPanel();
        lineJP.setLayout(new FlowLayout(FlowLayout.LEFT));
        JTextField getlineName = new JTextField(5);
        JTextField getlineX1 = new JTextField(5);
        JTextField getlineY1 = new JTextField(5);
        JTextField getlineX2 = new JTextField(5);
        JTextField getlineY2 = new JTextField(5);
        lineJP.add(new JLabel("Name :"));
        lineJP.add(getlineName);
        lineJP.add(new JLabel("X1    :"));
        lineJP.add(getlineX1);
        lineJP.add(new JLabel("  Y1    :"));
        lineJP.add(getlineY1);
        lineJP.add(new JLabel("X2    :"));
        lineJP.add(getlineX2);
        lineJP.add(new JLabel("  Y2    :"));
        lineJP.add(getlineY2);
        lineJP.add(confirm[2]);
        confirm[2].addActionListener(e -> {
            String lineCmd = "line " + getlineName.getText() + " " + getlineX1.getText() + " " + getlineY1.getText() + " " + getlineX2.getText() + " " + getlineY2.getText();
            run.getCommand(lineCmd);
            getlineName.setText("");
            getlineX1.setText("");
            getlineX2.setText("");
            getlineY1.setText("");
            getlineY2.setText("");
            cardLayout.show(allPanel, "control");
            frame.repaint();
        });
        panellist.add(lineJP);

        JPanel groupJP = new JPanel();
        groupJP.setLayout(new FlowLayout(FlowLayout.LEFT));
        JTextField getgroupName = new JTextField(5);
        JTextField getlist = new JTextField(5);
        groupJP.add(new JLabel("Name:"));
        groupJP.add(getgroupName);
        groupJP.add(new JLabel("Shapes need be grouped :"));
        groupJP.add(getlist);
        groupJP.add(confirm[NUM_OF_COMFIRM-1]);
        confirm[NUM_OF_COMFIRM-1].addActionListener(e -> {
            run.getCommand("group " + getgroupName.getText() + " " + getlist.getText());
            getgroupName.setText("");
            getlist.setText("");
            cardLayout.show(allPanel, "control");
        });
        panellist.add(groupJP);

        JPanel ungroupJP = new JPanel();
        JComboBox allGroups = new JComboBox();
        allGroups.addItem("--please choose--");
        ArrayList<Group> groupArrayList = run.groupArrayList();
        for (Group value : groupArrayList) {
            allGroups.addItem(value.getShapeName());
        }
        ungroupJP.add(new JLabel("Group :"));
        ungroupJP.add(allGroups);
        ungroupJP.add(confirm[3]);
        confirm[3].addActionListener(e -> {
            run.getCommand("ungroup " + allGroups.getSelectedItem());
            allGroups.setSelectedIndex(0);
            cardLayout.show(allPanel, "control");
        });
        panellist.add(ungroupJP);

        JPanel squareJP = new JPanel();
        JTextField getsquareName = new JTextField(5);
        JTextField getsquareX = new JTextField(5);
        JTextField getsquareY = new JTextField(5);
        JTextField getsquareL = new JTextField(5);
        squareJP.setLayout(new FlowLayout(FlowLayout.LEFT));
        squareJP.add(new JLabel("Name :"));
        squareJP.add(getsquareName);
        squareJP.add(new JLabel("   X   :"));
        squareJP.add(getsquareX);
        squareJP.add(new JLabel("   Y :"));
        squareJP.add(getsquareY);
        squareJP.add(new JLabel("Lenght :"));
        squareJP.add(getsquareL);
        squareJP.add(confirm[4]);
        confirm[4].addActionListener(e -> {
            run.getCommand("square " + getsquareName.getText() + " " + getsquareX.getText() + " " + getsquareY.getText() + " " + getsquareL.getText());
            getsquareName.setText("");
            getsquareX.setText("");
            getsquareY.setText("");
            getsquareL.setText("");
            cardLayout.show(allPanel, "control");
            frame.repaint();

        });
        panellist.add(squareJP);

        JPanel pickAndMoveJP = new JPanel();
        JTextField getpickX = new JTextField(4);
        JTextField getpickY = new JTextField(4);
        JTextField getPickMoveX = new JTextField(4);
        JTextField getPickMoveY = new JTextField(4);
        pickAndMoveJP.setLayout(new FlowLayout(FlowLayout.LEFT));
        pickAndMoveJP.add(new JLabel("Pick(x):"));
        pickAndMoveJP.add(getpickX);
        pickAndMoveJP.add(new JLabel("Pick(y):"));
        pickAndMoveJP.add(getpickY);
        pickAndMoveJP.add(new JLabel("Move(x):"));
        pickAndMoveJP.add(getPickMoveX);
        pickAndMoveJP.add(new JLabel("Move(y):"));
        pickAndMoveJP.add(getPickMoveY);
        pickAndMoveJP.add(confirm[5]);
        confirm[5].addActionListener(e -> {
            run.getCommand("pick-and-move " + getpickX.getText() + " " + getpickY.getText() + " " + getPickMoveX.getText() + " " + getPickMoveY.getText());

            getpickX.setText("");
            getpickY.setText("");
            getPickMoveX.setText("");
            getPickMoveY.setText("");
            cardLayout.show(allPanel, "control");
            frame.repaint();

        });
        panellist.add(pickAndMoveJP);


        JPanel listJP = new JPanel();
        JComboBox allShapes = new JComboBox();
        allShapes.addItem("--please choose--");
        String[] StrArray = run.getName_Shape().keySet().toArray(new String[0]);
        for (String s : StrArray) {
            allShapes.addItem(s);
        }
        listJP.setLayout(new FlowLayout(FlowLayout.LEFT));
        listJP.add(new JLabel("Shapes :"));
        listJP.add(allShapes);
        listJP.add(confirm[6]);
        confirm[6].addActionListener(e -> {
            String x = (String) allShapes.getSelectedItem();
            run.getCommand("list " + x);
            ArrayList<String> out = run.getName_Shape().get(x).getInfo(x);
            StringBuilder ans = new StringBuilder();
            for (String s : out) {
                ans.append(s);
                ans.append("\n");
            }
            JOptionPane.showMessageDialog(null, ans.toString(), x, JOptionPane.INFORMATION_MESSAGE);
            cardLayout.show(allPanel, "control");
        });
        panellist.add(listJP);


        JPanel intersectJP = new JPanel();
        JComboBox intersect_1 = new JComboBox();
        JComboBox intersect_2 = new JComboBox();
        intersect_1.addItem("--please choose--");
        intersect_2.addItem("--please choose--");
        for (String s : run.getName_Shape().keySet()) {
            intersect_1.addItem(s);
            intersect_2.addItem(s);
        }
        intersectJP.add(new JLabel("Shape 1 :"));
        intersectJP.add(intersect_1);
        intersectJP.add(new JLabel("Shape 2 :"));
        intersectJP.add(intersect_2);
        intersectJP.add(confirm[7]);
        confirm[7].addActionListener(e -> {
            String intersect_a, intersect_b;
            intersect_a = (String) intersect_1.getSelectedItem();
            intersect_b = (String) intersect_2.getSelectedItem();
            run.getCommand("intersect " + intersect_a + " " + intersect_b);
            String intersectOrNot = "";
            intersectOrNot += (intersect_a + " and " + intersect_b + " is intersect ?\n" + run.getName_Shape().get(intersect_a).intersect(run.getName_Shape().get(intersect_b)));
            JOptionPane.showMessageDialog(null, intersectOrNot, "Result", JOptionPane.INFORMATION_MESSAGE);
            cardLayout.show(allPanel, "control");
        });
        panellist.add(intersectJP);

        JPanel moveJP = new JPanel();
        JComboBox moveCmb = new JComboBox();
        JTextField getMoveX = new JTextField(5);
        JTextField getMoveY = new JTextField(5);
        moveJP.add(new JLabel("Shape :"));
        moveJP.add(moveCmb);
        moveJP.add(new JLabel("Move(x) :"));
        moveJP.add(getMoveX);
        moveJP.add(new JLabel("Move(y) :"));
        moveJP.add(getMoveY);
        moveJP.add(confirm[8]);
        confirm[8].addActionListener(e -> {
            run.getCommand("move " + moveCmb.getSelectedItem() + " " + getMoveX.getText() + " " + getMoveY.getText());
            frame.repaint();
            getMoveX.setText("");
            getMoveY.setText("");
            cardLayout.show(allPanel, "control");
        });
        panellist.add(moveJP);

        JPanel boundingBoxJP = new JPanel();
        JComboBox boundingBox = new JComboBox();
        boundingBoxJP.add(new JLabel("Shape :"));
        boundingBoxJP.add(boundingBox);
        boundingBoxJP.add(confirm[9]);
        confirm[9].addActionListener(e -> {
            Shape asked = run.getName_Shape().get((String) boundingBox.getSelectedItem());
            run.getCommand("boundingbox " + boundingBox.getSelectedItem());
            String boundingBoxResult = "";
            boundingBoxResult += "Top Left corner: (" + String.format("%.2f", asked.getTopLeft().getX()) + ", " + String.format("%.2f", asked.getTopLeft().getY()) + "\n";
            boundingBoxResult += "Width :" + String.format("%.2f", asked.getBottomRight().getX() - asked.getTopLeft().getX()) + "\nHeight :" + String.format("%.2f", asked.getBottomRight().getY() - asked.getTopLeft().getY());
            JOptionPane.showMessageDialog(null, boundingBoxResult, "BoundingBox", JOptionPane.INFORMATION_MESSAGE);
            cardLayout.show(allPanel, "control");
        });
        panellist.add(boundingBoxJP);


        JPanel deleteJP = new JPanel();
        JComboBox deleteCmb = new JComboBox();
        deleteJP.add(new JLabel("Shape :"));
        deleteJP.add(deleteCmb);
        deleteJP.add(confirm[10]);
        confirm[10].addActionListener(e -> {
            run.getCommand("delete " + deleteCmb.getSelectedItem());
            cardLayout.show(allPanel, "control");
            frame.repaint();
        });
        panellist.add(deleteJP);

        for (int x = 0; x < NUM_OF_BACK; x++) {
            panellist.get(x).add(back[x]);
        }

        allPanel.add(rectangleJP, "rectangle");
        allPanel.add(squareJP, "square");
        allPanel.add(circleJP, "circle");
        allPanel.add(lineJP, "line");
        allPanel.add(groupJP, "group");
        allPanel.add(ungroupJP, "ungroup");
        allPanel.add(pickAndMoveJP, "pickAndMove");
        allPanel.add(listJP, "list");
        allPanel.add(intersectJP, "intersect");
        allPanel.add(moveJP, "move");
        allPanel.add(boundingBoxJP, "boundingbox");
        allPanel.add(deleteJP, "delete");
        allPanel.add(controler, "control");


        cardLayout.show(allPanel, "control");


        rectangleButton.addActionListener(e -> cardLayout.show(allPanel, "rectangle"));

        circleButton.addActionListener(e -> cardLayout.show(allPanel, "circle"));

        squareButton.addActionListener(e -> cardLayout.show(allPanel, "square"));
        lineButton.addActionListener(e -> cardLayout.show(allPanel, "line"));
        group.addActionListener(e -> cardLayout.show(allPanel, "group"));
        ungroup.addActionListener(e -> {
            allGroups.addItem("--please choose--");
            allGroups.removeAllItems();
            for (Group group1 : run.groupArrayList()) {
                allGroups.addItem(group1.getShapeName());
            }
            cardLayout.show(allPanel, "ungroup");

        });
        pick_and_move.addActionListener(e -> cardLayout.show(allPanel, "pickAndMove"));
        list.addActionListener(e -> {
            allShapes.removeAllItems();
            allShapes.addItem("--please choose--");
            for (String s : run.getName_Shape().keySet()) {
                allShapes.addItem(s);
            }
            cardLayout.show(allPanel, "list");
        });
        move.addActionListener(e -> {
            moveCmb.removeAllItems();
            moveCmb.addItem("--please choose--");
            for (String s : run.getName_Shape().keySet()) {
                moveCmb.addItem(s);
            }
            cardLayout.show(allPanel, "move");
        });

        bounding.addActionListener(e -> {
            boundingBox.removeAllItems();
            boundingBox.addItem("--please choose--");
            for (String s : run.getName_Shape().keySet()) {
                boundingBox.addItem(s);
            }
            cardLayout.show(allPanel, "boundingbox");
        });

        delete.addActionListener(e -> {
            deleteCmb.removeAllItems();
            deleteCmb.addItem("--please choose--");
            for (String s : run.getName_Shape().keySet()) {
                deleteCmb.addItem(s);
            }
            cardLayout.show(allPanel, "delete");
        });

        intersect.addActionListener(e -> {
            intersect_1.removeAllItems();
            intersect_2.removeAllItems();
            intersect_1.addItem("--please choose--");
            intersect_2.addItem("--please choose--");
            for (String s : run.getName_Shape().keySet()) {
                intersect_1.addItem(s);
                intersect_2.addItem(s);
            }
            cardLayout.show(allPanel, "intersect");
        });
        undo.addActionListener(e -> {
            try {
                run.undo();
            } catch (RuntimeException error) {
                JOptionPane.showMessageDialog(null, "Undo fail, there is no option yet", "Undo Fail", JOptionPane.INFORMATION_MESSAGE);
            }
            frame.repaint();
        });
        redo.addActionListener(e -> {
            try {
                run.redo();
            } catch (RuntimeException error) {
                JOptionPane.showMessageDialog(null, "Redo fail, already latest.", "Redo Fail", JOptionPane.INFORMATION_MESSAGE);
            }
            frame.repaint();
        });
        listAll.addActionListener(e -> {
            ArrayList<String> listAllShape = run.listAll();
            StringBuilder a = new StringBuilder();
            for (String s : listAllShape) {
                a.append(s);
            }
            JOptionPane.showMessageDialog(null, a.toString(), "List All", JOptionPane.INFORMATION_MESSAGE);
            frame.repaint();
        });


        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                run.output(run.getCmdRecord(), file_txt, file_html);
            }
        });


        frame.add(jp);
        frame.add(allPanel, BorderLayout.EAST);
        frame.setBounds(FRAME_X, FRAME_Y, FRAME_WIDTH1, FRAME_HEIGHT);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Scanner in = new Scanner(System.in);
        String cmd;
        while (true) {
            cmd = in.nextLine();
            if (!run.getCommand(cmd)) break;
            frame.repaint();
        }
        run.output(run.getCmdRecord(), file_txt, file_html);
        frame.dispose();

    }
}


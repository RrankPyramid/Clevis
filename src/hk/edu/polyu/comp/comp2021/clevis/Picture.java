package hk.edu.polyu.comp.comp2021.clevis;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 */
public class Picture extends JFrame {
    private final int width;
    private final int height;

    private final ArrayList<Shape> listShape = new ArrayList<>();

    /**
     * @param width  Maximum width of the whole picture
     * @param height Maximum height of the whole figure
     */
    public Picture(int width, int height) {
        add(new ShapesPanel());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.width = width;
        this.height = height;
    }

    /**
     * @param s The shape that need to be drawn
     */
    public void add(Shape s) {
        listShape.add(s);
    }

    /**
     * @param s The shape that need to be remove
     */
    public void remove(Shape s) {
        listShape.remove(s);
    }

    /**
     * remove all the Shapes
     */
    public void removeAllShape() {
        listShape.clear();
    }

    /**
     * Draw the picture
     */
    public void draw() {
        setLocationRelativeTo(null);
        setSize(width, height);
        setVisible(true);
    }

    private class ShapesPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Shape s : listShape) {
                s.draw(g);
            }
        }

    }
}
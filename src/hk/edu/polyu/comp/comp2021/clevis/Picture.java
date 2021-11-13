package hk.edu.polyu.comp.comp2021.clevis;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Picture extends JFrame {
    private final int width;
    private final int height;

    private final ArrayList<Shape> listShape = new ArrayList<>();

    private class ShapesPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for ( Shape s : listShape )
            {
                s.draw(g);
            }
        }

    }

    public void add(Shape s)
    {
        listShape.add(s);
    }

    public void remove(Shape s) { listShape.remove(s); }

    public Picture(int width, int height)
    {
        add(new ShapesPanel());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.width = width;
        this.height = height;
    }

    public void draw()
    {
        setLocationRelativeTo(null);
        setSize(width, height);
        setVisible(true);
    }
}
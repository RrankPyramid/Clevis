package hk.edu.polyu.comp.comp2021.clevis;

import javax.swing.*;
import java.awt.*;

/**
 * Application Launcher
 */
public class Application {


    private JFrame frame;

    /**
     * @param args Parameters entered at launch
     */
    public static void main(String[] args) {
        // Initialize and utilize the system
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    Application window = new Application();
                    SwingUtilities.updateComponentTreeUI(window.getFrame());
                    window.getFrame().setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }


    /**
     * @return frame
     */
    public JFrame getFrame() {
        return frame;
    }

    private void Initialize(){
        frame = new JFrame();
        frame.setBounds(100, 100, 1500, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel InnerWrapper = new JPanel();
        FlowLayout fl_InnerWrapper = (FlowLayout) InnerWrapper.getLayout();
        fl_InnerWrapper.setVgap(0);
        fl_InnerWrapper.setHgap(0);
        fl_InnerWrapper.setAlignment(FlowLayout.LEFT);
        InnerWrapper.setBounds(0, 0, 10, 10);


    }

}

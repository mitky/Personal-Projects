/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalyearproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import jdk.javadoc.internal.tool.Main;

/**
 *
 * @author mmiit
 */
public class tryPanel extends javax.swing.JPanel {

    /**
     * Creates new form tryPanel
     */
    public void paint(Graphics g) {

        URL url = Main.class.getResource("/castle.jpg");
        URL ur2 = Main.class.getResource("/newWarrior5.png");
        URL url3 = Main.class.getResource("/mage7.png");

        Image image = new ImageIcon(url).getImage();
        Image warrior = new ImageIcon(ur2).getImage();
        Image mage = new ImageIcon(url3).getImage();

        Graphics2D g2 = (Graphics2D) g;
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int) screenSize.getHeight();
        int width = (int) screenSize.getWidth();
        
        g.drawImage(image, 0, 0, width, height, null);
        
        //g.drawImage(image, 0, 0, 1920, 1080, null);

        g.drawImage(warrior, 180, 180, 460, 572, null);
         g.drawImage(mage, 1180, 180, 460, 572, null);

        ImageIcon i1 = new ImageIcon(ur2);
        ImageIcon i2 = new ImageIcon(url3);

        

        g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        g.setColor(Color.red);

        g.drawString("Warrior", 370, 115);
        g.drawString("Mage", 1430, 115);

    }

    public tryPanel() {
        initComponents();

    }

    public static void main(String[] args) {
        boolean warriorSelected = false;
        boolean mageSelected = false;

        tryPanel a = new tryPanel();
        JFrame frame = new JFrame("Class selection");
        JToggleButton warrior = new JToggleButton("Choose");
        JToggleButton mage = new JToggleButton("Choose");
        JButton button = new JButton("Continue");
        JLabel enterName = new JLabel("Enter Name");
        JTextField name = new JTextField();

        warrior.setBounds(295, 780, 225, 45);
        mage.setBounds(1320, 780, 225, 45);
        button.setBounds(894, 666, 162, 39);
        enterName.setBounds(905, 450, 162, 39);
        enterName.setSize(300, 300);
        enterName.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        enterName.setForeground(Color.red);
        name.setBounds(893, 625, 162, 29);

        warrior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (warrior.isSelected()) {
                    mage.setSelected(false);
                    User.characterClass = "warrior";
                }
            }
        });

        mage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mage.isSelected()) {
                    warrior.setSelected(false);
                    User.characterClass = "mage";
                }
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String characterClass = "";
                boolean nameSelected = false;
                boolean classSelected = false;

                if (warrior.isSelected()) {
                    User.characterClass = "warrior";
                    characterClass = "warrior";
                    classSelected = true;
                } else if (mage.isSelected()) {
                    User.characterClass = "mage";
                    characterClass = "mage";
                    classSelected = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Please select class");
                }

                if (name.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter Name");
                } else {
                    nameSelected = true;
                    User.name = name.getText();
                }

                User user = new User(name.getText(), characterClass);

                if (nameSelected && classSelected) {
                    Prison prison = new Prison();
                    prison.setVisible(true);
                    prison.pack();
                    prison.setLocationRelativeTo(null);
                    prison.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    prison.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    //prison.setSize(1950,1050);
                    frame.dispose();

                    JOptionPane.showMessageDialog(null, "To see more information about the stats and skill click on them, to move forward click the dice");
                    JOptionPane.showMessageDialog(null, "There is a riot going on in the prison and you have found yourself free. Make your way trough and find the exit to escape. Good luck!");
                }
            }
        });

        frame.add(mage);
        frame.add(warrior);
        frame.add(button);
        frame.add(enterName);
        frame.add(name);
        frame.add(a, BorderLayout.CENTER);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(1950,1050);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1361, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 664, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

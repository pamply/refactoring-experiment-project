/*
 * Decompiled with CFR 0_122.
 */
package view;

import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.LayoutManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestImg
extends JFrame {
    private JLabel jLabel1;

    public TestImg() {
        this.initComponents();
        ImageIcon img = new ImageIcon("Koala.jpg");
        ImageIcon imN = new ImageIcon(img.getImage().getScaledInstance(100, 100, 1));
        this.jLabel1.setIcon(imN);
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.setDefaultCloseOperation(3);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(64, 64, 64).addComponent(this.jLabel1, -2, 112, -2).addContainerGap(224, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(48, 48, 48).addComponent(this.jLabel1, -2, 94, -2).addContainerGap(158, 32767)));
        this.pack();
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (!"Nimbus".equals(info.getName())) continue;
                UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(TestImg.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(TestImg.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            Logger.getLogger(TestImg.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TestImg.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                new TestImg().setVisible(true);
            }
        });
    }

}


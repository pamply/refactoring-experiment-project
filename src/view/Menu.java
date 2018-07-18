/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jdesktop.layout.GroupLayout
 *  org.jdesktop.layout.GroupLayout$Group
 *  org.jdesktop.layout.GroupLayout$ParallelGroup
 *  org.jdesktop.layout.GroupLayout$SequentialGroup
 */
package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import org.jdesktop.layout.GroupLayout;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import view.ConfiguracionExperimento;
import view.ConfiguracionExperimentoImage;
import view.ConfiguracionImages;
import view.ConfiguracionWords;
import view.Experimento;
import view.ExperimentoImage;

public class Menu
extends JFrame {
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JPanel jPanel1;
    private JSeparator jSeparator1;

    public Menu() {
        this.initComponents();
    }

    private void initComponents() {
        this.jSeparator1 = new JSeparator();
        this.jPanel1 = new JPanel();
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        this.jButton3 = new JButton();
        this.jButton4 = new JButton();
        this.jButton5 = new JButton();
        this.jButton6 = new JButton();
        this.setDefaultCloseOperation(3);
        this.addKeyListener(new KeyAdapter(){

            @Override
            public void keyTyped(KeyEvent evt) {
                Menu.this.formKeyTyped(evt);
            }

            @Override
            public void keyPressed(KeyEvent evt) {
                Menu.this.formKeyPressed(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.jPanel1.setLayout(new AbsoluteLayout());
        this.jButton1.setText("Configurar par\u00e1metros (Im\u00e1genes)");
        this.jButton1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Menu.this.jButton1ActionPerformed(evt);
            }
        });
        this.jButton1.addKeyListener(new KeyAdapter(){

            @Override
            public void keyPressed(KeyEvent evt) {
                Menu.this.jButton1KeyPressed(evt);
            }
        });
        this.jPanel1.add((Component)this.jButton1, new AbsoluteConstraints(230, 180, 230, 80));
        this.jButton2.setText("Configurar par\u00e1metros");
        this.jButton2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Menu.this.jButton2ActionPerformed(evt);
            }
        });
        this.jPanel1.add((Component)this.jButton2, new AbsoluteConstraints(20, 180, 160, 80));
        this.jButton3.setText("Configurar palabras");
        this.jButton3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Menu.this.jButton3ActionPerformed(evt);
            }
        });
        this.jPanel1.add((Component)this.jButton3, new AbsoluteConstraints(20, 100, 160, 70));
        this.jButton4.setText("Inciar Experimento (im\u00e1genes)");
        this.jButton4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Menu.this.jButton4ActionPerformed(evt);
            }
        });
        this.jButton4.addKeyListener(new KeyAdapter(){

            @Override
            public void keyPressed(KeyEvent evt) {
                Menu.this.jButton4KeyPressed(evt);
            }
        });
        this.jPanel1.add((Component)this.jButton4, new AbsoluteConstraints(230, 20, 230, 70));
        this.jButton5.setText("Iniciar Experimento");
        this.jButton5.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Menu.this.jButton5ActionPerformed(evt);
            }
        });
        this.jButton5.addKeyListener(new KeyAdapter(){

            @Override
            public void keyPressed(KeyEvent evt) {
                Menu.this.jButton5KeyPressed(evt);
            }
        });
        this.jPanel1.add((Component)this.jButton5, new AbsoluteConstraints(20, 20, 160, 70));
        this.jButton6.setText("Configurar im\u00e1genes");
        this.jButton6.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Menu.this.jButton6ActionPerformed(evt);
            }
        });
        this.jButton6.addKeyListener(new KeyAdapter(){

            @Override
            public void keyPressed(KeyEvent evt) {
                Menu.this.jButton6KeyPressed(evt);
            }
        });
        this.jPanel1.add((Component)this.jButton6, new AbsoluteConstraints(230, 100, 230, 70));
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout((LayoutManager)layout);
        layout.setHorizontalGroup((GroupLayout.Group)layout.createParallelGroup(1).add((GroupLayout.Group)layout.createSequentialGroup().add(17, 17, 17).add((Component)this.jPanel1, -2, 480, -2).addContainerGap(17, 32767)));
        layout.setVerticalGroup((GroupLayout.Group)layout.createParallelGroup(1).add((GroupLayout.Group)layout.createSequentialGroup().add(17, 17, 17).add((Component)this.jPanel1, -2, 285, -2).addContainerGap(18, 32767)));
        this.pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        this.dispose();
        new ConfiguracionExperimentoImage().setVisible(true);
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        this.dispose();
        new ConfiguracionExperimento().setVisible(true);
    }

    private void jButton3ActionPerformed(ActionEvent evt) {
        this.dispose();
        new ConfiguracionWords().setVisible(true);
    }

    private void formKeyPressed(KeyEvent evt) {
    }

    private void formKeyTyped(KeyEvent evt) {
    }

    private void jButton1KeyPressed(KeyEvent evt) {
    }

    private void jButton4ActionPerformed(ActionEvent evt) {
        try {
            new ExperimentoImage().setVisible(true);
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }

    private void jButton4KeyPressed(KeyEvent evt) {
    }

    private void jButton5ActionPerformed(ActionEvent evt) {
        try {
            new Experimento().setVisible(true);
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }

    private void jButton5KeyPressed(KeyEvent evt) {
    }

    private void jButton6ActionPerformed(ActionEvent evt) {
        new ConfiguracionImages().setVisible(true);
        this.dispose();
    }

    private void jButton6KeyPressed(KeyEvent evt) {
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
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

}


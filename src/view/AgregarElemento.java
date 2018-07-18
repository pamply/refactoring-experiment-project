/*
 * Decompiled with CFR 0_122.
 */
package view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import utilities.ManageWords;

public class AgregarElemento
extends JFrame {
    private ButtonGroup buttonGroup1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JMenu jMenu1;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JPanel jPanel1;
    private JTextField jTextField1;
    private JTextField jTextField2;

    public AgregarElemento() {
        this.initComponents();
        this.desactivarImagen();
    }

    public void desactivarImagen() {
        this.jLabel1.setVisible(true);
        this.jLabel2.setVisible(true);
        this.jTextField1.setVisible(true);
        this.jTextField2.setVisible(true);
    }

    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.jTextField1 = new JTextField();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jTextField2 = new JTextField();
        this.jMenuBar1 = new JMenuBar();
        this.jMenu1 = new JMenu();
        this.jMenuItem1 = new JMenuItem();
        this.jMenuItem2 = new JMenuItem();
        this.setDefaultCloseOperation(3);
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel1.setLayout(new AbsoluteLayout());
        this.jTextField1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                AgregarElemento.this.jTextField1ActionPerformed(evt);
            }
        });
        this.jPanel1.add((Component)this.jTextField1, new AbsoluteConstraints(10, 30, 180, -1));
        this.jLabel1.setFont(new Font("Tahoma", 1, 11));
        this.jLabel1.setText("Palabra");
        this.jPanel1.add((Component)this.jLabel1, new AbsoluteConstraints(10, 10, -1, -1));
        this.jLabel2.setFont(new Font("Tahoma", 1, 11));
        this.jLabel2.setText("Palabra");
        this.jPanel1.add((Component)this.jLabel2, new AbsoluteConstraints(20, 80, -1, -1));
        this.jPanel1.add((Component)this.jTextField2, new AbsoluteConstraints(20, 110, 170, -1));
        this.jMenu1.setText("Opciones");
        this.jMenuItem1.setText("Cancelar");
        this.jMenuItem1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                AgregarElemento.this.jMenuItem1ActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jMenuItem1);
        this.jMenuItem2.setText("Guardar");
        this.jMenuItem2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                AgregarElemento.this.jMenuItem2ActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jMenuItem2);
        this.jMenuBar1.add(this.jMenu1);
        this.setJMenuBar(this.jMenuBar1);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, 243, -2).addContainerGap(21, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.jPanel1, -2, 171, -2).addContainerGap(18, 32767)));
        this.pack();
    }

    private void jTextField1ActionPerformed(ActionEvent evt) {
    }

    private void jMenuItem1ActionPerformed(ActionEvent evt) {
        this.dispose();
        new ConfiguracionWords().setVisible(true);
    }

    private void jMenuItem2ActionPerformed(ActionEvent evt) {
        try {
            if (ConfiguracionWords.isTest) {
                ManageWords manage = new ManageWords();
                manage.addPairWordsTest(this.jTextField1.getText(), this.jTextField2.getText());
                JOptionPane.showMessageDialog(this, "Palabra agregada");
                this.dispose();
                new ConfiguracionWords().setVisible(true);
            } else {
                ManageWords manage = new ManageWords();
                manage.addPairWords(this.jTextField1.getText(), this.jTextField2.getText());
                JOptionPane.showMessageDialog(this, "Palabra agregada");
                this.dispose();
                new ConfiguracionWords().setVisible(true);
            }
        }
        catch (Exception ex) {
            System.out.println("Falla");
        }
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
            Logger.getLogger(AgregarElemento.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(AgregarElemento.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            Logger.getLogger(AgregarElemento.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(AgregarElemento.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                new AgregarElemento().setVisible(true);
            }
        });
    }

}


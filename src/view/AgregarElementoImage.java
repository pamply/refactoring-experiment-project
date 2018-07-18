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

import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import org.jdesktop.layout.GroupLayout;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import utilities.ImageCreator;
import utilities.ManageWords;
import view.ConfiguracionImages;

public class AgregarElementoImage
extends JFrame {
    private String currentPath = null;
    private String folder = "../";
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JMenu jMenu1;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JPanel jPanel1;
    private JPanel jPanel2;

    public AgregarElementoImage() {
        this.initComponents();
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jPanel2 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jMenuBar1 = new JMenuBar();
        this.jMenu1 = new JMenu();
        this.jMenuItem1 = new JMenuItem();
        this.jMenuItem2 = new JMenuItem();
        this.setDefaultCloseOperation(3);
        this.getContentPane().setLayout(new AbsoluteLayout());
        this.jPanel1.setLayout(new AbsoluteLayout());
        this.getContentPane().add((Component)this.jPanel1, new AbsoluteConstraints(6, 58, 330, -1));
        this.jPanel2.setBorder(BorderFactory.createEtchedBorder(0));
        this.jLabel1.setFont(new Font("Lucida Grande", 1, 13));
        this.jLabel1.setText("Imagen");
        this.jLabel2.setFont(new Font("Lucida Grande", 1, 13));
        this.jLabel2.setText("Imagen");
        this.jButton1.setText("Cargar");
        this.jButton1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                AgregarElementoImage.this.jButton1ActionPerformed(evt);
            }
        });
        this.jButton2.setText("Cargar");
        this.jButton2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                AgregarElementoImage.this.jButton2ActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout((Container)this.jPanel2);
        this.jPanel2.setLayout((LayoutManager)jPanel2Layout);
        jPanel2Layout.setHorizontalGroup((GroupLayout.Group)jPanel2Layout.createParallelGroup(1).add((GroupLayout.Group)jPanel2Layout.createSequentialGroup().add((GroupLayout.Group)jPanel2Layout.createParallelGroup(1).add((GroupLayout.Group)jPanel2Layout.createSequentialGroup().add(18, 18, 18).add((Component)this.jLabel1)).add((GroupLayout.Group)jPanel2Layout.createSequentialGroup().addContainerGap().add((GroupLayout.Group)jPanel2Layout.createParallelGroup(1).add((Component)this.jButton1, -2, 108, -2).add((GroupLayout.Group)jPanel2Layout.createSequentialGroup().add(6, 6, 6).add((GroupLayout.Group)jPanel2Layout.createParallelGroup(1).add((Component)this.jLabel2).add((Component)this.jLabel3))))).add((Component)this.jButton2, -2, 113, -2).add((GroupLayout.Group)jPanel2Layout.createSequentialGroup().addContainerGap().add((Component)this.jLabel4))).addContainerGap(282, 32767)));
        jPanel2Layout.setVerticalGroup((GroupLayout.Group)jPanel2Layout.createParallelGroup(1).add((GroupLayout.Group)jPanel2Layout.createSequentialGroup().add(20, 20, 20).add((Component)this.jLabel1).addPreferredGap(0).add((Component)this.jButton1).addPreferredGap(0).add((Component)this.jLabel3).add(40, 40, 40).add((Component)this.jLabel2).addPreferredGap(0).add((Component)this.jButton2).addPreferredGap(0).add((Component)this.jLabel4).addContainerGap(32, 32767)));
        this.getContentPane().add((Component)this.jPanel2, new AbsoluteConstraints(10, 10, 400, 210));
        this.jMenu1.setText("Opciones");
        this.jMenuItem1.setText("Cancelar");
        this.jMenuItem1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                AgregarElementoImage.this.jMenuItem1ActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jMenuItem1);
        this.jMenuItem2.setText("Guardar");
        this.jMenuItem2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                AgregarElementoImage.this.jMenuItem2ActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jMenuItem2);
        this.jMenuBar1.add(this.jMenu1);
        this.setJMenuBar(this.jMenuBar1);
        this.pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        this.saveImage();
        this.jLabel3.setText(this.currentPath);
        try {
            BufferedImage imageBuffer = ImageIO.read(new File(this.currentPath));
            ImageCreator.save(imageBuffer, "jpg", this.folder + this.getCanonicalName(this.currentPath));
        }
        catch (IOException ex) {
            Logger.getLogger(AgregarElementoImage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        this.saveImage();
        this.jLabel4.setText(this.currentPath);
        try {
            BufferedImage imageBuffer = ImageIO.read(new File(this.currentPath));
            ImageCreator.save(imageBuffer, "jpg", this.folder + this.getCanonicalName(this.currentPath));
        }
        catch (IOException ex) {
            Logger.getLogger(AgregarElementoImage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String getCanonicalName(String nameImage) {
        String[] names = nameImage.split("\\\\");
        return names[names.length - 1].split("\\.")[0];
    }

    private void jMenuItem1ActionPerformed(ActionEvent evt) {
        this.dispose();
        new ConfiguracionImages().setVisible(true);
    }

    private void jMenuItem2ActionPerformed(ActionEvent evt) {
        try {
            if (ConfiguracionImages.isTest) {
                ManageWords manage = new ManageWords();
                manage.addPairImagesTest(this.folder + this.getCanonicalName(this.jLabel3.getText()) + ".jpg", this.folder + this.getCanonicalName(this.jLabel4.getText()) + ".jpg");
                JOptionPane.showMessageDialog(this, "Imagen agregada");
                this.dispose();
                new ConfiguracionImages().setVisible(true);
            } else {
                ManageWords manage = new ManageWords();
                manage.addPairImages(this.folder + this.getCanonicalName(this.jLabel3.getText()) + ".jpg", this.folder + this.getCanonicalName(this.jLabel4.getText()) + ".jpg");
                JOptionPane.showMessageDialog(this, "Imagen agregada");
                this.dispose();
                new ConfiguracionImages().setVisible(true);
            }
        }
        catch (Exception ex) {
            System.out.println("Falla");
        }
    }

    private void saveImage() {
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showOpenDialog(this);
        File file = fileChooser.getSelectedFile();
        if (file.getPath() != null) {
            this.currentPath = file.getPath();
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
            Logger.getLogger(AgregarElementoImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(AgregarElementoImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            Logger.getLogger(AgregarElementoImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(AgregarElementoImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                new AgregarElementoImage().setVisible(true);
            }
        });
    }

}


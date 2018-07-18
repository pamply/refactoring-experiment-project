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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.jdesktop.layout.GroupLayout;
import utilities.ManageWords;
import view.AgregarElemento;
import view.ConfiguracionExperimento;
import view.ConfiguracionExperimentoImage;
import view.ConfiguracionImages;
import view.Experimento;
import view.ExperimentoImage;

public class ConfiguracionWords
extends JFrame {
    public static boolean isTest = false;
    private static final int EXPERIMENTO_ELEMENTO = 0;
    private static final int EXPERIMENTO_KEY = 1;
    private static final int TEST_ELEMENTO = 2;
    private static final int TEST_KEY = 3;
    private int listSelected = -1;
    private ManageWords manage = new ManageWords();
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JList jList1;
    private JList jList2;
    private JList jList3;
    private JList jList4;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JMenuItem jMenuItem3;
    private JMenuItem jMenuItem4;
    private JMenuItem jMenuItem5;
    private JMenuItem jMenuItem6;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;

    public ConfiguracionWords() {
        this.initComponents();
        this.initList();
    }

    public void initList() {
        int i;
        DefaultListModel<String> modelo = new DefaultListModel<String>();
        DefaultListModel<String> modelo2 = new DefaultListModel<String>();
        DefaultListModel<String> modelo3 = new DefaultListModel<String>();
        DefaultListModel<String> modelo4 = new DefaultListModel<String>();
        Vector<String> elementsImage = ManageWords.elementsTest;
        Vector<String> keysImage = ManageWords.keysTest;
        Vector<String> elementsImage2 = ManageWords.elementsExp;
        Vector<String> keysImage2 = ManageWords.keysExp;
        for (i = 0; i < ManageWords.elementsTest.size(); ++i) {
            modelo.addElement(elementsImage.get(i));
            modelo2.addElement(keysImage.get(i));
        }
        for (i = 0; i < ManageWords.elementsExp.size(); ++i) {
            modelo3.addElement(elementsImage2.get(i));
            modelo4.addElement(keysImage2.get(i));
        }
        this.jList1.setModel(modelo);
        this.jList2.setModel(modelo2);
        this.jList3.setModel(modelo3);
        this.jList4.setModel(modelo4);
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jScrollPane2 = new JScrollPane();
        this.jList2 = new JList();
        this.jScrollPane1 = new JScrollPane();
        this.jList1 = new JList();
        this.jLabel2 = new JLabel();
        this.jLabel1 = new JLabel();
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        this.jButton3 = new JButton();
        this.jLabel3 = new JLabel();
        this.jPanel2 = new JPanel();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.jScrollPane3 = new JScrollPane();
        this.jList3 = new JList();
        this.jScrollPane4 = new JScrollPane();
        this.jList4 = new JList();
        this.jButton4 = new JButton();
        this.jButton5 = new JButton();
        this.jButton6 = new JButton();
        this.jMenuBar1 = new JMenuBar();
        this.jMenu1 = new JMenu();
        this.jMenuItem1 = new JMenuItem();
        this.jMenuItem2 = new JMenuItem();
        this.jMenuItem3 = new JMenuItem();
        this.jMenu2 = new JMenu();
        this.jMenuItem4 = new JMenuItem();
        this.jMenuItem5 = new JMenuItem();
        this.jMenuItem6 = new JMenuItem();
        this.setDefaultCloseOperation(3);
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.jList2.addListSelectionListener(new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent evt) {
                ConfiguracionWords.this.jList2ValueChanged(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.jList2);
        this.jList1.addListSelectionListener(new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent evt) {
                ConfiguracionWords.this.jList1ValueChanged(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.jList1);
        this.jLabel2.setFont(new Font("Tahoma", 1, 11));
        this.jLabel2.setText("Objetivo");
        this.jLabel1.setFont(new Font("Tahoma", 1, 11));
        this.jLabel1.setText("Elemento");
        this.jButton1.setFont(new Font("Tahoma", 1, 11));
        this.jButton1.setText("Agregar");
        this.jButton1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ConfiguracionWords.this.jButton1ActionPerformed(evt);
            }
        });
        this.jButton2.setFont(new Font("Tahoma", 1, 11));
        this.jButton2.setText("Editar");
        this.jButton2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ConfiguracionWords.this.jButton2ActionPerformed(evt);
            }
        });
        this.jButton3.setFont(new Font("Tahoma", 1, 11));
        this.jButton3.setText("Eliminar");
        this.jButton3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ConfiguracionWords.this.jButton3ActionPerformed(evt);
            }
        });
        this.jLabel3.setFont(new Font("Calibri", 0, 14));
        this.jLabel3.setText("Ensayo de pr\u00e1tica");
        GroupLayout jPanel1Layout = new GroupLayout((Container)this.jPanel1);
        this.jPanel1.setLayout((LayoutManager)jPanel1Layout);
        jPanel1Layout.setHorizontalGroup((GroupLayout.Group)jPanel1Layout.createParallelGroup(1).add((GroupLayout.Group)jPanel1Layout.createSequentialGroup().add((GroupLayout.Group)jPanel1Layout.createParallelGroup(1).add((GroupLayout.Group)jPanel1Layout.createSequentialGroup().add(84, 84, 84).add((GroupLayout.Group)jPanel1Layout.createParallelGroup(2, false).add(1, (Component)this.jButton2, -1, -1, 32767).add(1, (Component)this.jButton3, -1, -1, 32767).add((Component)this.jButton1, -2, 87, -2))).add((GroupLayout.Group)jPanel1Layout.createSequentialGroup().addContainerGap().add((GroupLayout.Group)jPanel1Layout.createParallelGroup(1).add((GroupLayout.Group)jPanel1Layout.createSequentialGroup().add((Component)this.jLabel3).add(0, 0, 32767)).add((GroupLayout.Group)jPanel1Layout.createSequentialGroup().add((GroupLayout.Group)jPanel1Layout.createParallelGroup(1, false).add((GroupLayout.Group)jPanel1Layout.createSequentialGroup().add((Component)this.jLabel1).add(74, 74, 74)).add((GroupLayout.Group)jPanel1Layout.createSequentialGroup().add((Component)this.jScrollPane1, -2, 0, 32767).add(7, 7, 7))).add(6, 6, 6).add((GroupLayout.Group)jPanel1Layout.createParallelGroup(1).add((Component)this.jScrollPane2, -2, 0, 32767).add((GroupLayout.Group)jPanel1Layout.createSequentialGroup().add((Component)this.jLabel2).add(0, 96, 32767))))))).addContainerGap()));
        jPanel1Layout.setVerticalGroup((GroupLayout.Group)jPanel1Layout.createParallelGroup(1).add((GroupLayout.Group)jPanel1Layout.createSequentialGroup().add(8, 8, 8).add((Component)this.jLabel3, -2, 27, -2).addPreferredGap(0).add((GroupLayout.Group)jPanel1Layout.createParallelGroup(3).add((Component)this.jLabel1).add((Component)this.jLabel2)).addPreferredGap(0).add((GroupLayout.Group)jPanel1Layout.createParallelGroup(1, false).add((Component)this.jScrollPane2, -1, 225, 32767).add((Component)this.jScrollPane1)).addPreferredGap(0, -1, 32767).add((Component)this.jButton1, -2, 35, -2).addPreferredGap(0).add((Component)this.jButton2, -2, 35, -2).addPreferredGap(0).add((Component)this.jButton3, -2, 34, -2).addContainerGap()));
        this.jPanel2.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel4.setFont(new Font("Calibri", 0, 14));
        this.jLabel4.setText("Elementos experimentales");
        this.jLabel5.setFont(new Font("Tahoma", 1, 11));
        this.jLabel5.setText("Elemento");
        this.jLabel6.setFont(new Font("Tahoma", 1, 11));
        this.jLabel6.setText("Objetivo");
        this.jList3.addListSelectionListener(new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent evt) {
                ConfiguracionWords.this.jList3ValueChanged(evt);
            }
        });
        this.jScrollPane3.setViewportView(this.jList3);
        this.jList4.addListSelectionListener(new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent evt) {
                ConfiguracionWords.this.jList4ValueChanged(evt);
            }
        });
        this.jScrollPane4.setViewportView(this.jList4);
        this.jButton4.setFont(new Font("Tahoma", 1, 11));
        this.jButton4.setText("Agregar");
        this.jButton4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ConfiguracionWords.this.jButton4ActionPerformed(evt);
            }
        });
        this.jButton5.setFont(new Font("Tahoma", 1, 11));
        this.jButton5.setText("Editar");
        this.jButton5.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ConfiguracionWords.this.jButton5ActionPerformed(evt);
            }
        });
        this.jButton6.setFont(new Font("Tahoma", 1, 11));
        this.jButton6.setText("Eliminar");
        this.jButton6.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ConfiguracionWords.this.jButton6ActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout((Container)this.jPanel2);
        this.jPanel2.setLayout((LayoutManager)jPanel2Layout);
        jPanel2Layout.setHorizontalGroup((GroupLayout.Group)jPanel2Layout.createParallelGroup(1).add((GroupLayout.Group)jPanel2Layout.createSequentialGroup().add(95, 95, 95).add((GroupLayout.Group)jPanel2Layout.createParallelGroup(2, false).add(1, (Component)this.jButton5, -1, -1, 32767).add(1, (Component)this.jButton4, -1, 105, 32767).add((Component)this.jButton6, -1, -1, 32767)).add(104, 104, 104)).add(2, (GroupLayout.Group)jPanel2Layout.createSequentialGroup().addContainerGap(12, 32767).add((GroupLayout.Group)jPanel2Layout.createParallelGroup(1).add((Component)this.jLabel4).add((GroupLayout.Group)jPanel2Layout.createSequentialGroup().add((GroupLayout.Group)jPanel2Layout.createParallelGroup(1).add((Component)this.jScrollPane3, -2, 135, -2).add((Component)this.jLabel5)).add(18, 18, 18).add((GroupLayout.Group)jPanel2Layout.createParallelGroup(1).add((Component)this.jScrollPane4, -2, 133, -2).add((Component)this.jLabel6)))).addContainerGap()));
        jPanel2Layout.setVerticalGroup((GroupLayout.Group)jPanel2Layout.createParallelGroup(1).add((GroupLayout.Group)jPanel2Layout.createSequentialGroup().addContainerGap().add((Component)this.jLabel4, -2, 26, -2).addPreferredGap(0).add((GroupLayout.Group)jPanel2Layout.createParallelGroup(3).add((Component)this.jLabel5).add((Component)this.jLabel6)).addPreferredGap(0).add((GroupLayout.Group)jPanel2Layout.createParallelGroup(1, false).add((Component)this.jScrollPane4, -1, 228, 32767).add((Component)this.jScrollPane3)).add(16, 16, 16).add((Component)this.jButton4, -2, 35, -2).addPreferredGap(0).add((Component)this.jButton5, -2, 35, -2).addPreferredGap(0).add((Component)this.jButton6, -2, 36, -2).addContainerGap(-1, 32767)));
        this.jMenu1.setText("Palabras");
        this.jMenuItem1.setText("Iniciar");
        this.jMenuItem1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ConfiguracionWords.this.jMenuItem1ActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jMenuItem1);
        this.jMenuItem2.setText("Configuraci\u00f3n");
        this.jMenuItem2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ConfiguracionWords.this.jMenuItem2ActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jMenuItem2);
        this.jMenuItem3.setText("Par\u00e1metros");
        this.jMenuItem3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ConfiguracionWords.this.jMenuItem3ActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jMenuItem3);
        this.jMenuBar1.add(this.jMenu1);
        this.jMenu2.setText("Im\u00e1genes");
        this.jMenuItem4.setText("Iniciar");
        this.jMenuItem4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ConfiguracionWords.this.jMenuItem4ActionPerformed(evt);
            }
        });
        this.jMenu2.add(this.jMenuItem4);
        this.jMenuItem5.setText("Configuraci\u00f3n");
        this.jMenuItem5.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ConfiguracionWords.this.jMenuItem5ActionPerformed(evt);
            }
        });
        this.jMenu2.add(this.jMenuItem5);
        this.jMenuItem6.setText("Par\u00e1metros");
        this.jMenuItem6.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ConfiguracionWords.this.jMenuItem6ActionPerformed(evt);
            }
        });
        this.jMenu2.add(this.jMenuItem6);
        this.jMenuBar1.add(this.jMenu2);
        this.setJMenuBar(this.jMenuBar1);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout((LayoutManager)layout);
        layout.setHorizontalGroup((GroupLayout.Group)layout.createParallelGroup(1).add((GroupLayout.Group)layout.createSequentialGroup().addContainerGap().add((Component)this.jPanel1, -2, -1, -2).addPreferredGap(1).add((Component)this.jPanel2, -2, -1, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup((GroupLayout.Group)layout.createParallelGroup(1).add((GroupLayout.Group)layout.createSequentialGroup().addContainerGap().add((GroupLayout.Group)layout.createParallelGroup(1, false).add((Component)this.jPanel1, -1, -1, 32767).add((Component)this.jPanel2, -1, -1, 32767)).addContainerGap(16, 32767)));
        this.pack();
    }

    private void jList2ValueChanged(ListSelectionEvent evt) {
        this.listSelected = 3;
    }

    private void jList1ValueChanged(ListSelectionEvent evt) {
        this.listSelected = 2;
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        isTest = true;
        new AgregarElemento().setVisible(true);
        this.dispose();
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        try {
            this.editarValor();
        }
        catch (IOException ex) {
            Logger.getLogger(ConfiguracionWords.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jButton3ActionPerformed(ActionEvent evt) {
        try {
            this.eliminar();
        }
        catch (IOException ex) {
            Logger.getLogger(ConfiguracionWords.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarValor() throws IOException {
        switch (this.listSelected) {
            case 0: {
                String exp = JOptionPane.showInputDialog("Modifica el valor", (Object)ManageWords.elementsExp.get(this.jList3.getSelectedIndex()));
                ManageWords.elementsExp.set(this.jList3.getSelectedIndex(), exp);
                this.manage.updateWords(ManageWords.elementsExp, ManageWords.keysExp);
                break;
            }
            case 1: {
                String key = JOptionPane.showInputDialog("Modifica el valor", (Object)ManageWords.keysExp.get(this.jList4.getSelectedIndex()));
                ManageWords.keysExp.set(this.jList4.getSelectedIndex(), key);
                this.manage.updateWords(ManageWords.elementsExp, ManageWords.keysExp);
                break;
            }
            case 2: {
                String exp2 = JOptionPane.showInputDialog("Modifica el valor", (Object)ManageWords.elementsTest.get(this.jList1.getSelectedIndex()));
                ManageWords.elementsTest.set(this.jList1.getSelectedIndex(), exp2);
                this.manage.updateWordsTest(ManageWords.elementsTest, ManageWords.keysTest);
                break;
            }
            case 3: {
                String key2 = JOptionPane.showInputDialog("Modifica el valor", (Object)ManageWords.keysTest.get(this.jList2.getSelectedIndex()));
                ManageWords.keysTest.set(this.jList2.getSelectedIndex(), key2);
                this.manage.updateWordsTest(ManageWords.elementsTest, ManageWords.keysTest);
            }
        }
        this.initList();
    }

    private void jList3ValueChanged(ListSelectionEvent evt) {
        this.listSelected = 0;
    }

    private void jList4ValueChanged(ListSelectionEvent evt) {
        this.listSelected = 1;
    }

    private void jButton4ActionPerformed(ActionEvent evt) {
        isTest = false;
        this.dispose();
        new AgregarElemento().setVisible(true);
    }

    private void jButton5ActionPerformed(ActionEvent evt) {
        try {
            this.editarValor();
        }
        catch (IOException ex) {
            Logger.getLogger(ConfiguracionWords.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jButton6ActionPerformed(ActionEvent evt) {
        try {
            this.eliminar();
        }
        catch (IOException ex) {
            Logger.getLogger(ConfiguracionWords.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jMenuItem4ActionPerformed(ActionEvent evt) {
        this.dispose();
        try {
            new ExperimentoImage().setVisible(true);
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(ConfiguracionWords.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(ConfiguracionWords.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jMenuItem5ActionPerformed(ActionEvent evt) {
        new ConfiguracionImages().setVisible(true);
        this.dispose();
    }

    private void jMenuItem1ActionPerformed(ActionEvent evt) {
        this.dispose();
        try {
            new Experimento().setVisible(true);
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(ConfiguracionWords.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(ConfiguracionWords.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jMenuItem2ActionPerformed(ActionEvent evt) {
    }

    private void jMenuItem3ActionPerformed(ActionEvent evt) {
        this.dispose();
        new ConfiguracionExperimento().setVisible(true);
    }

    private void jMenuItem6ActionPerformed(ActionEvent evt) {
        this.dispose();
        new ConfiguracionExperimentoImage().setVisible(true);
    }

    public void eliminar() throws IOException {
        switch (this.listSelected) {
            case 0: {
                int option = JOptionPane.showConfirmDialog(this, "Se eliminar\u00e1 la pareja. \u00bfDesea eliminar de todos modos?");
                if (option != 0) break;
                this.manage.removeWord(this.jList3.getSelectedIndex());
                this.manage.updateWords(ManageWords.elementsExp, ManageWords.keysExp);
                break;
            }
            case 1: {
                int option2 = JOptionPane.showConfirmDialog(this, "Se eliminar\u00e1 la pareja. \u00bfDesea eliminar de todos modos?");
                if (option2 != 0) break;
                this.manage.removeWord(this.jList4.getSelectedIndex());
                this.manage.updateWords(ManageWords.elementsExp, ManageWords.keysExp);
                break;
            }
            case 2: {
                int option3 = JOptionPane.showConfirmDialog(this, "Se eliminar\u00e1 la pareja. \u00bfDesea eliminar de todos modos?");
                if (option3 != 0) break;
                this.manage.removeWordTest(this.jList1.getSelectedIndex());
                this.manage.updateWordsTest(ManageWords.elementsTest, ManageWords.keysTest);
                break;
            }
            case 3: {
                int option4 = JOptionPane.showConfirmDialog(this, "Se eliminar\u00e1 la pareja. \u00bfDesea eliminar de todos modos?");
                if (option4 != 0) break;
                this.manage.removeWordTest(this.jList2.getSelectedIndex());
                this.manage.updateWordsTest(ManageWords.elementsTest, ManageWords.keysTest);
            }
        }
        this.initList();
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
            Logger.getLogger(ConfiguracionWords.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(ConfiguracionWords.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            Logger.getLogger(ConfiguracionWords.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ConfiguracionWords.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                new ConfiguracionWords().setVisible(true);
            }
        });
    }

}


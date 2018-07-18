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
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import org.jdesktop.layout.GroupLayout;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import utilities.Configuracion;
import utilities.ManageWords;
import view.ConfiguracionExperimentoImage;
import view.ConfiguracionImages;
import view.ConfiguracionWords;
import view.Experimento;
import view.ExperimentoImage;
import constants.ExperimentType;

public class ConfiguracionExperimento
extends JFrame {
    public static Configuracion config = null;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private ButtonGroup buttonGroup3;
    private JButton jButton1;
    private JComboBox jComboBox1;
    private JComboBox jComboBox2;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
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
    private JPanel jPanel3;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JRadioButton jRadioButton3;
    private JRadioButton jRadioButton4;
    private JRadioButton jRadioButton5;
    private JRadioButton jRadioButton6;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;
    private JTextField jTextField6;

    public ConfiguracionExperimento() {
        config = new Configuracion(ExperimentType.WORD);
        this.initComponents();
        this.initCombos();
        this.initViewData();
    }

    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.buttonGroup2 = new ButtonGroup();
        this.buttonGroup3 = new ButtonGroup();
        this.jLabel4 = new JLabel();
        this.jPanel1 = new JPanel();
        this.jLabel3 = new JLabel();
        this.jLabel8 = new JLabel();
        this.jComboBox2 = new JComboBox();
        this.jLabel9 = new JLabel();
        this.jLabel7 = new JLabel();
        this.jTextField3 = new JTextField();
        this.jTextField4 = new JTextField();
        this.jRadioButton5 = new JRadioButton();
        this.jRadioButton6 = new JRadioButton();
        this.jPanel2 = new JPanel();
        this.jLabel6 = new JLabel();
        this.jRadioButton1 = new JRadioButton();
        this.jRadioButton2 = new JRadioButton();
        this.jLabel5 = new JLabel();
        this.jComboBox1 = new JComboBox();
        this.jLabel2 = new JLabel();
        this.jTextField1 = new JTextField();
        this.jLabel10 = new JLabel();
        this.jTextField2 = new JTextField();
        this.jRadioButton4 = new JRadioButton();
        this.jRadioButton3 = new JRadioButton();
        this.jPanel3 = new JPanel();
        this.jButton1 = new JButton();
        this.jLabel1 = new JLabel();
        this.jLabel11 = new JLabel();
        this.jTextField5 = new JTextField();
        this.jTextField6 = new JTextField();
        this.jMenuBar1 = new JMenuBar();
        this.jMenu1 = new JMenu();
        this.jMenuItem1 = new JMenuItem();
        this.jMenuItem2 = new JMenuItem();
        this.jMenuItem3 = new JMenuItem();
        this.jMenu2 = new JMenu();
        this.jMenuItem4 = new JMenuItem();
        this.jMenuItem5 = new JMenuItem();
        this.jMenuItem6 = new JMenuItem();
        this.jLabel4.setText("jLabel4");
        this.setDefaultCloseOperation(3);
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel1.setLayout(new AbsoluteLayout());
        this.jLabel3.setText("N\u00famero de ejercicios");
        this.jPanel1.add((Component)this.jLabel3, new AbsoluteConstraints(10, 130, -1, -1));
        this.jLabel8.setFont(new Font("Lucida Grande", 1, 13));
        this.jLabel8.setText("Experimento");
        this.jPanel1.add((Component)this.jLabel8, new AbsoluteConstraints(80, 10, -1, -1));
        this.jComboBox2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ConfiguracionExperimento.this.jComboBox2ActionPerformed(evt);
            }
        });
        this.jPanel1.add((Component)this.jComboBox2, new AbsoluteConstraints(150, 120, -1, 30));
        this.jLabel9.setText("ISI");
        this.jPanel1.add((Component)this.jLabel9, new AbsoluteConstraints(10, 80, -1, -1));
        this.jLabel7.setText("SOA");
        this.jPanel1.add((Component)this.jLabel7, new AbsoluteConstraints(10, 50, -1, 20));
        this.jPanel1.add((Component)this.jTextField3, new AbsoluteConstraints(90, 40, 71, -1));
        this.jPanel1.add((Component)this.jTextField4, new AbsoluteConstraints(90, 70, 71, -1));
        this.buttonGroup2.add(this.jRadioButton5);
        this.jRadioButton5.setSelected(true);
        this.jRadioButton5.setText("Aleatorio");
        this.jRadioButton5.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ConfiguracionExperimento.this.jRadioButton5ActionPerformed(evt);
            }
        });
        this.jPanel1.add((Component)this.jRadioButton5, new AbsoluteConstraints(10, 160, -1, -1));
        this.buttonGroup2.add(this.jRadioButton6);
        this.jRadioButton6.setText("Secuencial");
        this.jRadioButton6.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ConfiguracionExperimento.this.jRadioButton6ActionPerformed(evt);
            }
        });
        this.jPanel1.add((Component)this.jRadioButton6, new AbsoluteConstraints(110, 160, -1, -1));
        this.jPanel2.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel2.setLayout(new AbsoluteLayout());
        this.jLabel6.setFont(new Font("Lucida Grande", 1, 13));
        this.jLabel6.setText("Ensayos de pr\u00e1tica");
        this.jPanel2.add((Component)this.jLabel6, new AbsoluteConstraints(84, 8, -1, -1));
        this.buttonGroup1.add(this.jRadioButton1);
        this.jRadioButton1.setSelected(true);
        this.jRadioButton1.setText("Activar");
        this.jRadioButton1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ConfiguracionExperimento.this.jRadioButton1ActionPerformed(evt);
            }
        });
        this.jPanel2.add((Component)this.jRadioButton1, new AbsoluteConstraints(23, 42, -1, -1));
        this.buttonGroup1.add(this.jRadioButton2);
        this.jRadioButton2.setText("Desactivar");
        this.jRadioButton2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ConfiguracionExperimento.this.jRadioButton2ActionPerformed(evt);
            }
        });
        this.jPanel2.add((Component)this.jRadioButton2, new AbsoluteConstraints(105, 42, -1, -1));
        this.jLabel5.setText("N\u00famero de ejercicios");
        this.jPanel2.add((Component)this.jLabel5, new AbsoluteConstraints(23, 142, -1, 20));
        this.jComboBox1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ConfiguracionExperimento.this.jComboBox1ActionPerformed(evt);
            }
        });
        this.jPanel2.add((Component)this.jComboBox1, new AbsoluteConstraints(168, 140, -1, -1));
        this.jLabel2.setText("SOA");
        this.jPanel2.add((Component)this.jLabel2, new AbsoluteConstraints(23, 70, -1, 20));
        this.jPanel2.add((Component)this.jTextField1, new AbsoluteConstraints(105, 66, 71, -1));
        this.jLabel10.setText("ISI");
        this.jPanel2.add((Component)this.jLabel10, new AbsoluteConstraints(23, 106, -1, -1));
        this.jPanel2.add((Component)this.jTextField2, new AbsoluteConstraints(105, 100, 71, -1));
        this.buttonGroup3.add(this.jRadioButton4);
        this.jRadioButton4.setSelected(true);
        this.jRadioButton4.setText("Aleatorio");
        this.jRadioButton4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ConfiguracionExperimento.this.jRadioButton4ActionPerformed(evt);
            }
        });
        this.jPanel2.add((Component)this.jRadioButton4, new AbsoluteConstraints(20, 170, -1, -1));
        this.buttonGroup3.add(this.jRadioButton3);
        this.jRadioButton3.setText("Secuencial");
        this.jRadioButton3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ConfiguracionExperimento.this.jRadioButton3ActionPerformed(evt);
            }
        });
        this.jPanel2.add((Component)this.jRadioButton3, new AbsoluteConstraints(130, 170, -1, -1));
        this.jPanel3.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel3.setLayout(new AbsoluteLayout());
        this.jButton1.setText("Guardar");
        this.jButton1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ConfiguracionExperimento.this.jButton1ActionPerformed(evt);
            }
        });
        this.jPanel3.add((Component)this.jButton1, new AbsoluteConstraints(340, 30, 100, 40));
        this.jLabel1.setText("Responsable");
        this.jPanel3.add((Component)this.jLabel1, new AbsoluteConstraints(41, 17, -1, -1));
        this.jLabel11.setText("Sujeto experimental");
        this.jPanel3.add((Component)this.jLabel11, new AbsoluteConstraints(41, 63, -1, -1));
        this.jTextField5.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ConfiguracionExperimento.this.jTextField5ActionPerformed(evt);
            }
        });
        this.jPanel3.add((Component)this.jTextField5, new AbsoluteConstraints(172, 11, 120, -1));
        this.jPanel3.add((Component)this.jTextField6, new AbsoluteConstraints(172, 57, 120, -1));
        this.jMenu1.setText("Palabras");
        this.jMenuItem1.setText("Iniciar");
        this.jMenuItem1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ConfiguracionExperimento.this.jMenuItem1ActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jMenuItem1);
        this.jMenuItem2.setText("Configuraci\u00f3n");
        this.jMenuItem2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ConfiguracionExperimento.this.jMenuItem2ActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jMenuItem2);
        this.jMenuItem3.setText("Par\u00e1metros");
        this.jMenuItem3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ConfiguracionExperimento.this.jMenuItem3ActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jMenuItem3);
        this.jMenuBar1.add(this.jMenu1);
        this.jMenu2.setText("Im\u00e1genes");
        this.jMenuItem4.setText("Iniciar");
        this.jMenuItem4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ConfiguracionExperimento.this.jMenuItem4ActionPerformed(evt);
            }
        });
        this.jMenu2.add(this.jMenuItem4);
        this.jMenuItem5.setText("Configuraci\u00f3n");
        this.jMenuItem5.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ConfiguracionExperimento.this.jMenuItem5ActionPerformed(evt);
            }
        });
        this.jMenu2.add(this.jMenuItem5);
        this.jMenuItem6.setText("Par\u00e1metros");
        this.jMenuItem6.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ConfiguracionExperimento.this.jMenuItem6ActionPerformed(evt);
            }
        });
        this.jMenu2.add(this.jMenuItem6);
        this.jMenuBar1.add(this.jMenu2);
        this.setJMenuBar(this.jMenuBar1);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout((LayoutManager)layout);
        layout.setHorizontalGroup((GroupLayout.Group)layout.createParallelGroup(1).add((GroupLayout.Group)layout.createSequentialGroup().add(16, 16, 16).add((GroupLayout.Group)layout.createParallelGroup(2, false).add((Component)this.jPanel3, -2, 574, -2).add(1, (GroupLayout.Group)layout.createSequentialGroup().add((Component)this.jPanel2, -2, 281, -2).addPreferredGap(1).add((Component)this.jPanel1, -1, -1, 32767))).add(0, 17, 32767)));
        layout.setVerticalGroup((GroupLayout.Group)layout.createParallelGroup(1).add((GroupLayout.Group)layout.createSequentialGroup().addContainerGap().add((GroupLayout.Group)layout.createParallelGroup(1, false).add((Component)this.jPanel2, -1, 203, 32767).add((Component)this.jPanel1, -1, -1, 32767)).addPreferredGap(0).add((Component)this.jPanel3, -2, 106, -2).addContainerGap(-1, 32767)));
        this.pack();
    }

    private void initCombos() {
        int i;
        for (i = 1; i <= ManageWords.elementsExp.size(); ++i) {
            this.jComboBox2.addItem(i);
        }
        for (i = 1; i <= ManageWords.elementsTest.size(); ++i) {
            this.jComboBox1.addItem(i);
        }
    }

    public void initViewData() {
        if (config.isHasPrueba()) {
            this.jRadioButton1.setSelected(true);
        } else {
            this.jRadioButton2.setSelected(true);
        }
        
        
        if (config.isIsAleatorioExperimento() == true) {
            this.jRadioButton5.setSelected(true);
        } else {
            this.jRadioButton6.setSelected(true) ;
        }
        
        if (config.isIsAleatorioPrueba() == true) {
            this.jRadioButton4.setSelected(true);
        } else {
            this.jRadioButton3.setSelected(true);
        }
        System.out.println(config.getNumPruebas());
        this.jTextField3.setText(String.valueOf(config.getSoaExperimento()));
        this.jTextField4.setText(String.valueOf(config.getIsiExperimento()));
        this.jComboBox2.setSelectedIndex(config.getNumExperimento() - 1);
        this.jTextField1.setText(String.valueOf(config.getSoaPrueba()));
        this.jTextField2.setText(String.valueOf(config.getIsiPrueba()));
        this.jComboBox1.setSelectedIndex(config.getNumPruebas() - 1);
        this.jTextField5.setText(config.getNombreExperimentador());
        this.jTextField6.setText(config.getSujetoExperimental());
    }

    private void jRadioButton1ActionPerformed(ActionEvent evt) {
    }

    private void jRadioButton2ActionPerformed(ActionEvent evt) {
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        
        boolean hasPrueba = this.jRadioButton1.isSelected();
        boolean isSecuencialExperimento = this.jRadioButton5.isSelected();
        boolean isSecuencialPrueba = this.jRadioButton4.isSelected();
        
        config.setHasPrueba(hasPrueba);
        config.setSoaExperimento(Integer.parseInt(this.jTextField3.getText()));
        config.setIsiExperimento(Integer.parseInt(this.jTextField4.getText()));
        config.setSoaPrueba(Integer.parseInt(this.jTextField1.getText()));
        config.setIsiPrueba(Integer.parseInt(this.jTextField2.getText()));
        config.setNumExperimento(Integer.parseInt(this.jComboBox2.getSelectedItem().toString()));
        config.setNumPruebas(Integer.parseInt(this.jComboBox1.getSelectedItem().toString()));
        config.setIsAleatorioExperimento(isSecuencialExperimento);
        config.setIsAleatorioPrueba(isSecuencialPrueba);
        config.setNombreExperimentador(this.jTextField5.getText());
        config.setSujetoExperimental(this.jTextField6.getText());
        
        if(config.save()) {
            JOptionPane.showMessageDialog(null, "Configuraci\u00f3n guardada con \u00e9xito");
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar");
        }
        
    }

    private void jTextField5ActionPerformed(ActionEvent evt) {
    }

    private void jComboBox2ActionPerformed(ActionEvent evt) {
    }

    private void jComboBox1ActionPerformed(ActionEvent evt) {
    }

    private void jRadioButton3ActionPerformed(ActionEvent evt) {
    }

    private void jRadioButton4ActionPerformed(ActionEvent evt) {
    }

    private void jRadioButton5ActionPerformed(ActionEvent evt) {
    }

    private void jRadioButton6ActionPerformed(ActionEvent evt) {
    }

    private void jMenuItem1ActionPerformed(ActionEvent evt) {
        this.dispose();
        try {
            new Experimento().setVisible(true);
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(ConfiguracionExperimento.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(ConfiguracionExperimento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jMenuItem6ActionPerformed(ActionEvent evt) {
        this.dispose();
        new ConfiguracionExperimentoImage().setVisible(true);
    }

    private void jMenuItem2ActionPerformed(ActionEvent evt) {
        this.dispose();
        new ConfiguracionWords().setVisible(true);
    }

    private void jMenuItem5ActionPerformed(ActionEvent evt) {
        new ConfiguracionImages().setVisible(true);
        this.dispose();
    }

    private void jMenuItem3ActionPerformed(ActionEvent evt) {
    }

    private void jMenuItem4ActionPerformed(ActionEvent evt) {
        this.dispose();
        try {
            new ExperimentoImage().setVisible(true);
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(ConfiguracionExperimento.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(ConfiguracionExperimento.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ConfiguracionExperimento.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(ConfiguracionExperimento.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            Logger.getLogger(ConfiguracionExperimento.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ConfiguracionExperimento.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                new ConfiguracionExperimento().setVisible(true);
            }
        });
    }

}


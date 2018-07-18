/*
 * Decompiled with CFR 0_122.
 */
package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import utilities.Init;
import utilities.ManageWords;

public class MainView
extends JFrame {
    private ManageWords manage;
    private JLabel jLabel1;
    private JProgressBar jProgressBar1;

    public MainView() throws FileNotFoundException, IOException {
        Init init = new Init();
        this.initComponents();
        this.initTimer();
        this.manage = new ManageWords();
        this.manage.initWords();
        this.manage.initWordsTest();
        this.manage.initImages();
        this.manage.initImagesTest();
        this.manage.initConfigurationParameter();
        this.manage.initConfigurationParameterImage();
    }
    
    private void load() throws FileNotFoundException, IOException {
        Properties p = new Properties();
        InputStream input = null;
        input = new FileInputStream("config.properties");
        p.load(input);
        System.out.println(p.getProperty("data"));
        System.out.println(p.getProperty("data2"));
        input.close();
    }
    
    private void save() throws FileNotFoundException, IOException {
        Properties p = new Properties();
        OutputStream output = null;
        output = new FileOutputStream("config.properties");
        p.setProperty("data", "value");
        p.setProperty("data2", "value2");
        p.store(output, null);
        output.close();
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jProgressBar1 = new JProgressBar();
        this.setDefaultCloseOperation(3);
        this.jLabel1.setFont(new Font("Lucida Grande", 1, 48));
        this.jLabel1.setText("Facilitaci\u00f3n Sem\u00e1ntica");
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(73, 73, 73).addComponent(this.jLabel1)).addGroup(layout.createSequentialGroup().addGap(22, 22, 22).addComponent(this.jProgressBar1, -2, 647, -2))).addContainerGap(35, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(24, 24, 24).addComponent(this.jLabel1, -2, 128, -2).addGap(48, 48, 48).addComponent(this.jProgressBar1, -2, -1, -2).addContainerGap(87, 32767)));
        this.pack();
    }

    public void initTimer() {
        this.jProgressBar1.setMinimum(0);
        this.jProgressBar1.setMaximum(2000);
        TimerTask timerTask2 = new TimerTask(){

            @Override
            public void run() {
                MainView.this.jProgressBar1.setValue(MainView.this.jProgressBar1.getValue() + 1);
            }
        };
        TimerTask timerTask = new TimerTask(){

            @Override
            public void run() {
                this.cancel();
                MainView.this.dispose();
                new Menu().setVisible(true);
            }
        };
        Timer timer = new Timer();
        Timer timer2 = new Timer();
        timer.scheduleAtFixedRate(timerTask, 2000, 10);
        timer2.scheduleAtFixedRate(timerTask2, 0, 1);
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
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                try {
                    new MainView().setVisible(true);
                }
                catch (FileNotFoundException ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch (IOException ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}


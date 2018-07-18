/*
 * Decompiled with CFR 0_122.
 */
package view;

import constants.ExperimentType;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import servicio.ServicioExcel;
import utilities.Configuracion;
import utilities.ManageWords;
import utilities.RandomWord;
import utilities.Resultado;
import view.Menu;

public class ExperimentoImage
extends JFrame {
    ManageWords manage = new ManageWords();
    private int contTest = 0;
    private int contExp = 0;
    private long timeInit;
    private int width = 300;
    private int height = 300;
    private long timeFinish;
    private String currentWord;
    private String currentKey;
    private boolean isActive = true;
    private RandomWord random = new RandomWord();
    private Vector<Resultado> answers = new Vector();
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JMenu jMenu1;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private Configuracion configImage = null;

    public ExperimentoImage() throws FileNotFoundException, IOException {
        this.initComponents();
        this.jLabel3.setVisible(false);
    }

    public void initTest() {
        this.currentWord = this.manage.getNextWordTest();
        this.jLabel1.setText(this.currentWord);
        TimerTask timerTask = new TimerTask(){

            @Override
            public void run() {
                ExperimentoImage.this.jLabel1.setText("");
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, configImage.getSoaPrueba() - configImage.getIsiPrueba(), (long)configImage.getIsiPrueba());
    }

    public void init() {
        configImage = new Configuracion(ExperimentType.IMAGE);
        if (configImage.isHasPrueba()) {
            if (this.contTest < configImage.getNumPruebas()) {
                this.timerTest();
            } else if (this.contTest == configImage.getNumPruebas()) {
                this.jLabel3.setVisible(true);
                this.jLabel1.setVisible(false);
                this.jLabel2.setVisible(false);
                this.isActive = false;
            } else if (this.contExp < configImage.getNumExperimento()) {
                this.timerExperimento();
            } else {
                this.finishPrueba();
            }
        } else if (this.contExp < configImage.getNumExperimento()) {
            this.timerExperimento();
        } else {
            this.finishPrueba();
        }
    }

    public void timerTest() {
        ImageIcon img;
        ImageIcon imN;
        int index = 0;
        if (configImage.isIsAleatorioPrueba()) {
            index = this.random.getNextIndexImgTest();
            this.currentWord = ManageWords.imagesTest.get(index);
            System.out.println(this.currentWord);
            img = new ImageIcon(this.currentWord);
            imN = new ImageIcon(img.getImage().getScaledInstance(this.width, this.height, 1));
            this.jLabel1.setIcon(imN);
        } else {
            this.currentWord = this.manage.getNextImageTest();
            System.out.println(this.currentWord);
            img = new ImageIcon(this.currentWord);
            imN = new ImageIcon(img.getImage().getScaledInstance(this.width, this.height, 1));
            this.jLabel1.setIcon(imN);
        }
        final int indexKey = index;
        TimerTask timerTask = new TimerTask(){

            @Override
            public void run() {
                ExperimentoImage.this.jLabel1.setIcon(null);
                this.cancel();
            }
        };
        TimerTask timerTask2 = new TimerTask(){

            @Override
            public void run() {
                if (configImage.isIsAleatorioPrueba()) {
                    ExperimentoImage.this.currentKey = ManageWords.imagesObjTest.get(indexKey);
                    System.out.println(ExperimentoImage.this.currentKey);
                    ImageIcon img = new ImageIcon(ExperimentoImage.this.currentKey);
                    ImageIcon imN = new ImageIcon(img.getImage().getScaledInstance(ExperimentoImage.this.width, ExperimentoImage.this.height, 1));
                    ExperimentoImage.this.jLabel1.setIcon(imN);
                } else {
                    ExperimentoImage.this.currentKey = ExperimentoImage.this.manage.getNextImageObjTest();
                    System.out.println(ExperimentoImage.this.currentKey);
                    ImageIcon img = new ImageIcon(ExperimentoImage.this.currentKey);
                    ImageIcon imN = new ImageIcon(img.getImage().getScaledInstance(ExperimentoImage.this.width, ExperimentoImage.this.height, 1));
                    ExperimentoImage.this.jLabel1.setIcon(imN);
                }
                ExperimentoImage.this.timeInit = System.currentTimeMillis();
                this.cancel();
            }
        };
        Timer timer2 = new Timer();
        timer2.scheduleAtFixedRate(timerTask2, configImage.getSoaPrueba(), (long)configImage.getSoaPrueba());
        ++this.contTest;
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, configImage.getSoaPrueba() - configImage.getIsiPrueba(), (long)configImage.getSoaPrueba());
    }

    public void timerExperimento() {
        ImageIcon img;
        ImageIcon imN;
        int index = 0;
        if (configImage.isIsAleatorioExperimento()) {
            index = this.random.getNextIndexImg();
            this.currentWord = ManageWords.images.get(index);
            img = new ImageIcon(this.currentWord);
            System.out.println(this.currentWord);
            imN = new ImageIcon(img.getImage().getScaledInstance(this.width, this.height, 1));
            this.jLabel1.setIcon(imN);
        } else {
            this.currentWord = this.manage.getNextImage();
            img = new ImageIcon(this.currentWord);
            System.out.println(this.currentWord);
            imN = new ImageIcon(img.getImage().getScaledInstance(this.width, this.height, 1));
            this.jLabel1.setIcon(imN);
        }
        final int indexKey = index;
        TimerTask timerTask = new TimerTask(){

            @Override
            public void run() {
                ExperimentoImage.this.jLabel1.setIcon(null);
                this.cancel();
            }
        };
        Timer timer = new Timer();
        ++this.contExp;
        TimerTask timerTask2 = new TimerTask(){

            @Override
            public void run() {
                if (configImage.isIsAleatorioExperimento()) {
                    ExperimentoImage.this.currentKey = ManageWords.imagesObj.get(indexKey);
                    System.out.println(ExperimentoImage.this.currentKey);
                    ImageIcon img = new ImageIcon(ExperimentoImage.this.currentKey);
                    ImageIcon imN = new ImageIcon(img.getImage().getScaledInstance(ExperimentoImage.this.width, ExperimentoImage.this.height, 1));
                    ExperimentoImage.this.jLabel1.setIcon(imN);
                } else {
                    ExperimentoImage.this.currentKey = ExperimentoImage.this.manage.getNextImageObj();
                    System.out.println(ExperimentoImage.this.currentKey);
                    ImageIcon img = new ImageIcon(ExperimentoImage.this.currentKey);
                    ImageIcon imN = new ImageIcon(img.getImage().getScaledInstance(ExperimentoImage.this.width, ExperimentoImage.this.height, 1));
                    ExperimentoImage.this.jLabel1.setIcon(imN);
                }
                ExperimentoImage.this.timeInit = System.currentTimeMillis();
                this.cancel();
            }
        };
        Timer timer2 = new Timer();
        timer2.scheduleAtFixedRate(timerTask2, configImage.getSoaExperimento(), (long)configImage.getSoaPrueba());
        timer.scheduleAtFixedRate(timerTask, configImage.getSoaExperimento() - configImage.getIsiExperimento(), (long)configImage.getSoaExperimento());
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jPanel2 = new JPanel();
        this.jPanel3 = new JPanel();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel1 = new JLabel();
        this.jMenuBar1 = new JMenuBar();
        this.jMenu1 = new JMenu();
        this.jMenuItem1 = new JMenuItem();
        this.jMenuItem2 = new JMenuItem();
        this.setDefaultCloseOperation(3);
        this.addKeyListener(new KeyAdapter(){

            @Override
            public void keyTyped(KeyEvent evt) {
                ExperimentoImage.this.formKeyTyped(evt);
            }

            @Override
            public void keyPressed(KeyEvent evt) {
                ExperimentoImage.this.formKeyPressed(evt);
            }
        });
        this.getContentPane().setLayout(new AbsoluteLayout());
        this.getContentPane().add((Component)this.jPanel1, new AbsoluteConstraints(0, 0, -1, -1));
        this.getContentPane().add((Component)this.jPanel2, new AbsoluteConstraints(0, 0, -1, -1));
        this.jPanel3.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel3.setLayout(new AbsoluteLayout());
        this.jLabel2 = new JLabel(new ImageIcon(this.getClass().getResource("/punto.png")));
        this.jPanel3.add((Component)this.jLabel2, new AbsoluteConstraints(320, 180, 200, 200));
        this.jLabel3.setFont(new Font("Lucida Grande", 1, 18));
        this.jLabel3.setText("Los ejercicios de prueba han terminado, \u00bfDesea comenzar el experimento?");
        this.jPanel3.add((Component)this.jLabel3, new AbsoluteConstraints(70, 30, 720, 110));
        this.jLabel1.setFont(new Font("Lucida Grande", 1, 30));
        this.jPanel3.add((Component)this.jLabel1, new AbsoluteConstraints(290, 130, 419, 350));
        this.getContentPane().add((Component)this.jPanel3, new AbsoluteConstraints(30, 20, 850, 590));
        this.jMenu1.setText("Opciones");
        this.jMenuItem1.setText("Atr\u00e1s");
        this.jMenuItem1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ExperimentoImage.this.jMenuItem1ActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jMenuItem1);
        this.jMenuItem2.setText("Reiniciar");
        this.jMenuItem2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ExperimentoImage.this.jMenuItem2ActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jMenuItem2);
        this.jMenuBar1.add(this.jMenu1);
        this.setJMenuBar(this.jMenuBar1);
        this.pack();
    }

    private void formKeyPressed(KeyEvent evt) {
    }

    private void formKeyTyped(KeyEvent evt) {
        if (this.isActive) {
            if (String.valueOf(evt.getKeyChar()).compareTo(" ") == 0) {
                this.actionSpace();
                this.isActive = false;
            }
        } else if (String.valueOf(evt.getKeyChar()).toLowerCase().compareTo("m") == 0) {
            this.pressYes();
            this.isActive = true;
        } else if (String.valueOf(evt.getKeyChar()).toLowerCase().compareTo("z") == 0) {
            this.pressNo();
            this.isActive = true;
        }
        if (String.valueOf(evt.getKeyChar()).toLowerCase().compareTo("y") == 0) {
            this.pressSiguiente();
            this.isActive = true;
        }
    }

    private void jMenuItem1ActionPerformed(ActionEvent evt) {
        new Menu().setVisible(true);
        this.dispose();
    }

    private void jMenuItem2ActionPerformed(ActionEvent evt) {
        try {
            new ExperimentoImage().setVisible(true);
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(ExperimentoImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(ExperimentoImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }

    public void pressSiguiente() {
        if (this.contTest == configImage.getNumPruebas()) {
            ++this.contTest;
            this.jLabel3.setVisible(false);
            this.jLabel2.setVisible(true);
        }
    }

    public void pressYes() {
        if (this.contTest != configImage.getNumPruebas()) {
            this.timeFinish = System.currentTimeMillis();
            long timeTotal = this.timeFinish - this.timeInit;
            Resultado resultado = new Resultado();
            resultado.setWord(this.currentWord);
            resultado.setKeyWord(this.currentKey);
            resultado.setResponse(true);
            resultado.setTime(timeTotal);
            if (configImage.isHasPrueba()) {
                if (this.contTest >= configImage.getNumPruebas()) {
                    resultado.setIsTest(false);
                } else {
                    resultado.setIsTest(true);
                }
            } else {
                resultado.setIsTest(false);
            }
            this.answers.add(resultado);
            this.jLabel1.setVisible(false);
            this.jLabel2.setVisible(true);
        } else {
            this.timeFinish = System.currentTimeMillis();
            long timeTotal = this.timeFinish - this.timeInit;
            Resultado resultado = new Resultado();
            resultado.setWord(this.currentWord);
            resultado.setKeyWord(this.currentKey);
            resultado.setResponse(true);
            resultado.setTime(timeTotal);
            resultado.setIsTest(true);
            this.answers.add(resultado);
            this.jLabel3.setVisible(true);
            this.jLabel1.setVisible(false);
            this.jLabel2.setVisible(false);
            this.isActive = false;
        }
    }

    public void pressNo() {
        if (this.contTest != configImage.getNumPruebas()) {
            this.timeFinish = System.currentTimeMillis();
            long timeTotal = this.timeFinish - this.timeInit;
            Resultado resultado = new Resultado();
            resultado.setWord(this.currentWord);
            resultado.setKeyWord(this.currentKey);
            resultado.setResponse(false);
            resultado.setTime(timeTotal);
            if (configImage.isHasPrueba()) {
                if (this.contTest >= configImage.getNumPruebas()) {
                    resultado.setIsTest(false);
                } else {
                    resultado.setIsTest(true);
                }
            } else {
                resultado.setIsTest(false);
            }
            this.answers.add(resultado);
            this.jLabel1.setVisible(false);
            this.jLabel2.setVisible(true);
        } else {
            this.timeFinish = System.currentTimeMillis();
            long timeTotal = this.timeFinish - this.timeInit;
            Resultado resultado = new Resultado();
            resultado.setWord(this.currentWord);
            resultado.setKeyWord(this.currentKey);
            resultado.setResponse(false);
            resultado.setTime(timeTotal);
            resultado.setIsTest(true);
            this.answers.add(resultado);
            this.jLabel3.setVisible(true);
            this.jLabel1.setVisible(false);
            this.jLabel2.setVisible(false);
            this.isActive = false;
        }
    }

    public void actionSpace() {
        this.jLabel1.setVisible(true);
        this.jLabel2.setVisible(false);
        this.init();
    }

    private void finishPrueba() {
        this.jLabel1.setIcon(null);
        String path = "";
        int opcion = JOptionPane.showConfirmDialog(null, "\u00bfDesea guardar los resultados?", null, 1, 1);
        if (opcion == 0) {
            path = this.getPathByFileChooser();
        }
        for (int i = 0; i < this.answers.size(); ++i) {
            System.out.println(this.answers.get(i).getKeyWord());
            System.out.println(this.answers.get(i).getWord());
            System.out.println(this.answers.get(i).getTime());
            System.out.println(this.answers.get(i).isResponse());
            System.out.println(this.answers.get(i).isIsTest());
        }
        try {
            ServicioExcel serv = new ServicioExcel();
            serv.generateExcel(configImage, this.answers, path);
        }
        catch (Exception ex) {
            this.dispose();
            new Menu().setVisible(true);
        }
        this.dispose();
        new Menu().setVisible(true);
    }

    private String getPathByFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showOpenDialog(this);
        File file = fileChooser.getSelectedFile();
        String path = file.getPath();
        return path + ".xls";
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
            Logger.getLogger(ExperimentoImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(ExperimentoImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            Logger.getLogger(ExperimentoImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ExperimentoImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                try {
                    new ExperimentoImage().setVisible(true);
                }
                catch (FileNotFoundException ex) {
                    Logger.getLogger(ExperimentoImage.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch (IOException ex) {
                    Logger.getLogger(ExperimentoImage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}


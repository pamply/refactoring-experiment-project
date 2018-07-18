/*
 * Decompiled with CFR 0_122.
 */
package view;

import constants.ExperimentType;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
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

public class Experimento
extends JFrame {
    ManageWords manage = new ManageWords();
    private int contTest = 0;
    private int contExp = 0;
    private long timeInit;
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
    private Configuracion config = null;

    public Experimento() throws FileNotFoundException, IOException {
        this.initComponents();
        this.jLabel3.setVisible(false);
    }

    public void initTest() {
        this.currentWord = this.manage.getNextWordTest();
        this.jLabel1.setText(this.currentWord);
        TimerTask timerTask = new TimerTask(){

            @Override
            public void run() {
                Experimento.this.jLabel1.setText("");
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, config.getSoaPrueba() - config.getIsiPrueba(), (long)config.getIsiPrueba());
    }

    public void init() {
        config = new Configuracion(ExperimentType.WORD);
        if (config.isHasPrueba()) {
            if (this.contTest < config.getNumPruebas()) {
                this.timerTest();
            } else if (this.contTest == config.getNumPruebas()) {
                this.jLabel3.setVisible(true);
                this.jLabel1.setVisible(false);
                this.jLabel2.setVisible(false);
                this.isActive = false;
            } else if (this.contExp < config.getNumExperimento()) {
                this.timerExperimento();
            } else {
                this.finishPrueba();
            }
        } else if (this.contExp < config.getNumExperimento()) {
            this.timerExperimento();
        } else {
            this.finishPrueba();
        }
    }

    public void timerTest() {
        int index = 0;
        if (config.isIsAleatorioPrueba()) {
            index = this.random.getNextIndexTest();
            this.currentWord = ManageWords.elementsTest.get(index);
            this.jLabel1.setText(this.currentWord);
        } else {
            this.currentWord = this.manage.getNextWordTest();
            this.jLabel1.setText(this.currentWord);
        }
        final int indexKey = index;
        TimerTask timerTask = new TimerTask(){

            @Override
            public void run() {
                Experimento.this.jLabel1.setText("");
                this.cancel();
            }
        };
        TimerTask timerTask2 = new TimerTask(){

            @Override
            public void run() {
                if (config.isIsAleatorioPrueba()) {
                    Experimento.this.currentKey = ManageWords.keysTest.get(indexKey);
                    Experimento.this.jLabel1.setText(ManageWords.keysTest.get(indexKey));
                } else {
                    Experimento.this.currentKey = Experimento.this.manage.getNextWordTestPair();
                    Experimento.this.jLabel1.setText(Experimento.this.currentKey);
                }
                Experimento.this.timeInit = System.currentTimeMillis();
                this.cancel();
            }
        };
        Timer timer2 = new Timer();
        timer2.scheduleAtFixedRate(timerTask2, config.getSoaPrueba(), (long)config.getSoaPrueba());
        ++this.contTest;
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, config.getSoaPrueba() - config.getIsiPrueba(), (long)config.getSoaPrueba());
    }

    public void timerExperimento() {
        int index = 0;
        if (config.isIsAleatorioExperimento()) {
            index = this.random.getNextIndex();
            this.currentWord = ManageWords.elementsExp.get(index);
            this.jLabel1.setText(this.currentWord);
        } else {
            this.currentWord = this.manage.getNextWord();
            this.jLabel1.setText(this.currentWord);
        }
        final int indexKey = index;
        TimerTask timerTask = new TimerTask(){

            @Override
            public void run() {
                Experimento.this.jLabel1.setText("");
                this.cancel();
            }
        };
        Timer timer = new Timer();
        ++this.contExp;
        TimerTask timerTask2 = new TimerTask(){

            @Override
            public void run() {
                if (config.isIsAleatorioExperimento()) {
                    Experimento.this.currentKey = ManageWords.keysExp.get(indexKey);
                    Experimento.this.jLabel1.setText(Experimento.this.currentKey);
                } else {
                    Experimento.this.currentKey = Experimento.this.manage.getNextWordPair();
                    Experimento.this.jLabel1.setText(Experimento.this.currentKey);
                }
                Experimento.this.timeInit = System.currentTimeMillis();
                this.cancel();
            }
        };
        Timer timer2 = new Timer();
        timer2.scheduleAtFixedRate(timerTask2, config.getSoaExperimento(), (long)config.getSoaPrueba());
        timer.scheduleAtFixedRate(timerTask, config.getSoaExperimento() - config.getIsiExperimento(), (long)config.getSoaExperimento());
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
                Experimento.this.formKeyTyped(evt);
            }

            @Override
            public void keyPressed(KeyEvent evt) {
                Experimento.this.formKeyPressed(evt);
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
        this.jPanel3.add((Component)this.jLabel1, new AbsoluteConstraints(300, 250, 419, 87));
        this.getContentPane().add((Component)this.jPanel3, new AbsoluteConstraints(30, 20, 850, 590));
        this.jMenu1.setText("Opciones");
        this.jMenuItem1.setText("Atr\u00e1s");
        this.jMenuItem1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Experimento.this.jMenuItem1ActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jMenuItem1);
        this.jMenuItem2.setText("Reiniciar");
        this.jMenuItem2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Experimento.this.jMenuItem2ActionPerformed(evt);
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
        } else if (String.valueOf(evt.getKeyChar()).toLowerCase().compareTo("z") == 0) {
            this.pressYes();
            this.isActive = true;
        } else if (String.valueOf(evt.getKeyChar()).toLowerCase().compareTo("m") == 0) {
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
            new Experimento().setVisible(true);
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(Experimento.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(Experimento.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }

    public void pressSiguiente() {
        if (this.contTest == config.getNumPruebas()) {
            ++this.contTest;
            this.jLabel3.setVisible(false);
            this.jLabel2.setVisible(true);
        }
    }

    public void pressYes() {
        if (this.contTest != config.getNumPruebas()) {
            this.timeFinish = System.currentTimeMillis();
            long timeTotal = this.timeFinish - this.timeInit;
            Resultado resultado = new Resultado();
            resultado.setWord(this.currentWord);
            resultado.setKeyWord(this.currentKey);
            resultado.setResponse(true);
            resultado.setTime(timeTotal);
            if (config.isHasPrueba()) {
                if (this.contTest >= config.getNumPruebas()) {
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
        if (this.contTest != config.getNumPruebas()) {
            this.timeFinish = System.currentTimeMillis();
            long timeTotal = this.timeFinish - this.timeInit;
            Resultado resultado = new Resultado();
            resultado.setWord(this.currentWord);
            resultado.setKeyWord(this.currentKey);
            resultado.setResponse(false);
            resultado.setTime(timeTotal);
            if (config.isHasPrueba()) {
                if (this.contTest >= config.getNumPruebas()) {
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
        this.jLabel1.setText("");
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
            serv.generateExcel(config, this.answers, path);
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
            Logger.getLogger(Experimento.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(Experimento.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            Logger.getLogger(Experimento.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Experimento.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                try {
                    new Experimento().setVisible(true);
                }
                catch (FileNotFoundException ex) {
                    Logger.getLogger(Experimento.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch (IOException ex) {
                    Logger.getLogger(Experimento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}


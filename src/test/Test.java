package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Hashtable;
import utilities.ManageWords;
import utilities.Palabras;

/**
 * 
 * @author manuelpamplona
 */
public class Test {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        ManageWords manage = new ManageWords();
        manage.initWords();
        manage.initWordsTest();
        for (int i = 0; i < Palabras.paresExperimento.size(); ++i) {
            System.out.println(manage.getNextWord());
        }
    }
}


/*
 * Decompiled with CFR 0_122.
 */
package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * 
 * @author manuelpamplona
 */
public class ManageFile {
    
    public Vector<String> getPalabras() throws FileNotFoundException, IOException {
        Vector<String> palabras = new Vector<String>();
        File file = new File("Util/palabra.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String palabra = "";
        while ((palabra = br.readLine()) != null) {
            palabras.add(palabra);
        }
        br.close();
        return palabras;
    }

    public Vector<String> getObjetivos() throws FileNotFoundException, IOException {
        Vector<String> objetivos = new Vector<String>();
        File file = new File("Util/objetivo.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String objetivo = "";
        while ((objetivo = br.readLine()) != null) {
            objetivos.add(objetivo);
        }
        fr.close();
        br.close();
        return objetivos;
    }

    public Vector<String> getPalabrasTest() throws FileNotFoundException, IOException {
        Vector<String> palabras = new Vector<String>();
        File file = new File("Util/palabra_test.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String palabra = "";
        while ((palabra = br.readLine()) != null) {
            palabras.add(palabra);
        }
        fr.close();
        br.close();
        return palabras;
    }

    public Vector<String> getObjetivosTest() throws FileNotFoundException, IOException {
        Vector<String> objetivos = new Vector<String>();
        File file = new File("Util/objetivo_test.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String objetivo = "";
        while ((objetivo = br.readLine()) != null) {
            objetivos.add(objetivo);
        }
        fr.close();
        br.close();
        return objetivos;
    }

    public Vector<String> getImages() throws FileNotFoundException, IOException {
        Vector<String> palabras = new Vector<String>();
        File file = new File("Util/images.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String palabra = "";
        while ((palabra = br.readLine()) != null) {
            palabras.add(palabra);
        }
        br.close();
        return palabras;
    }

    public Vector<String> getImagesObjective() throws FileNotFoundException, IOException {
        Vector<String> palabras = new Vector<String>();
        File file = new File("Util/images_objetivo.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String palabra = "";
        while ((palabra = br.readLine()) != null) {
            palabras.add(palabra);
        }
        br.close();
        return palabras;
    }

    public Vector<String> getImagesTest() throws FileNotFoundException, IOException {
        Vector<String> palabras = new Vector<String>();
        File file = new File("Util/images_test.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String palabra = "";
        while ((palabra = br.readLine()) != null) {
            palabras.add(palabra);
        }
        br.close();
        return palabras;
    }

    public Vector<String> getImagesObjectiveTest() throws FileNotFoundException, IOException {
        Vector<String> palabras = new Vector<String>();
        File file = new File("Util/images_objetivo_test.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String palabra = "";
        while ((palabra = br.readLine()) != null) {
            palabras.add(palabra);
        }
        br.close();
        return palabras;
    }

    private String getPalabrasToInsert() throws FileNotFoundException, IOException {
        String words = "";
        Vector<String> vectorWords = this.getPalabras();
        for (int i = 0; i < vectorWords.size(); ++i) {
            words = words + vectorWords.get(i) + "\n";
            System.out.println(words);
        }
        return words;
    }

    private String getObjetivosToInsert() throws FileNotFoundException, IOException {
        String words = "";
        Vector<String> vectorWords = this.getObjetivos();
        for (int i = 0; i < vectorWords.size(); ++i) {
            words = words + vectorWords.get(i) + "\n";
        }
        return words;
    }

    private String getPalabrasTestToInsert() throws FileNotFoundException, IOException {
        String wordsTest = "";
        Vector<String> vectorWordsTest = this.getPalabrasTest();
        for (int i = 0; i < vectorWordsTest.size(); ++i) {
            wordsTest = wordsTest + vectorWordsTest.get(i) + "\n";
        }
        return wordsTest;
    }

    private String getObjetivosTestToInsert() throws FileNotFoundException, IOException {
        String wordsTest = "";
        Vector<String> vectorWordsTest = this.getObjetivosTest();
        for (int i = 0; i < vectorWordsTest.size(); ++i) {
            wordsTest = wordsTest + vectorWordsTest.get(i) + "\n";
        }
        return wordsTest;
    }

    public void insertWords(String palabra, String objetivo) throws IOException {
        Vector<String> palabras = this.getPalabras();
        File file = new File("Util/palabra.txt");
        FileWriter fr = new FileWriter(file);
        PrintWriter pr = new PrintWriter(fr);
        for (int i = 0; i < palabras.size(); ++i) {
            pr.println(palabras.get(i));
        }
        pr.println(palabra);
        pr.close();
        fr.close();
        Vector<String> objetivos = this.getObjetivos();
        File file2 = new File("Util/objetivo.txt");
        FileWriter fr2 = new FileWriter(file2);
        PrintWriter pr2 = new PrintWriter(fr2);
        for (int i = 0; i < objetivos.size(); ++i) {
            pr2.println(objetivos.get(i));
        }
        pr2.println(objetivo);
        pr2.close();
        fr2.close();
    }

    public void insertImages(String image, String imageObjetivo) throws FileNotFoundException, IOException {
        Vector<String> images = this.getImages();
        File file = new File("Util/images.txt");
        FileWriter fr = new FileWriter(file);
        PrintWriter pr = new PrintWriter(fr);
        for (int i = 0; i < images.size(); ++i) {
            pr.println(images.get(i));
        }
        pr.println(image);
        pr.close();
        fr.close();
        Vector<String> objetivos = this.getImagesObjective();
        File file2 = new File("Util/images_objetivo.txt");
        FileWriter fr2 = new FileWriter(file2);
        PrintWriter pr2 = new PrintWriter(fr2);
        for (int i = 0; i < objetivos.size(); ++i) {
            pr2.println(objetivos.get(i));
        }
        pr2.println(imageObjetivo);
        pr2.close();
        fr2.close();
    }

    public void insertImagesTest(String image, String imageObjetivo) throws FileNotFoundException, IOException {
        Vector<String> images = this.getImagesTest();
        File file = new File("Util/images_test.txt");
        FileWriter fr = new FileWriter(file);
        PrintWriter pr = new PrintWriter(fr);
        for (int i = 0; i < images.size(); ++i) {
            pr.println(images.get(i));
        }
        pr.println(image);
        pr.close();
        fr.close();
        Vector<String> objetivos = this.getImagesObjectiveTest();
        File file2 = new File("Util/images_objetivo_test.txt");
        FileWriter fr2 = new FileWriter(file2);
        PrintWriter pr2 = new PrintWriter(fr2);
        for (int i = 0; i < objetivos.size(); ++i) {
            pr2.println(objetivos.get(i));
        }
        pr2.println(imageObjetivo);
        pr2.close();
        fr2.close();
    }

    public void insertWordsTest(String palabra, String objetivo) throws IOException {
        Vector<String> palabras = this.getPalabrasTest();
        File file = new File("Util/palabra_test.txt");
        FileWriter fr = new FileWriter(file);
        PrintWriter pr = new PrintWriter(fr);
        for (int i = 0; i < palabras.size(); ++i) {
            pr.println(palabras.get(i));
        }
        pr.println(palabra);
        pr.close();
        fr.close();
        Vector<String> objetivos = this.getObjetivosTest();
        File file2 = new File("Util/objetivo_test.txt");
        FileWriter fr2 = new FileWriter(file2);
        PrintWriter pr2 = new PrintWriter(fr2);
        for (int i = 0; i < objetivos.size(); ++i) {
            pr2.println(objetivos.get(i));
        }
        pr2.println(objetivo);
        pr2.close();
        fr2.close();
    }

    public void updateWords(Vector<String> palabras, Vector<String> objetivos) throws IOException {
        File file = new File("Util/palabra.txt");
        FileWriter fr = new FileWriter(file);
        PrintWriter pr = new PrintWriter(fr);
        for (int i = 0; i < palabras.size(); ++i) {
            pr.println(palabras.get(i));
        }
        pr.close();
        fr.close();
        File file2 = new File("Util/objetivo.txt");
        FileWriter fr2 = new FileWriter(file2);
        PrintWriter pr2 = new PrintWriter(fr2);
        for (int i = 0; i < objetivos.size(); ++i) {
            pr2.println(objetivos.get(i));
        }
        pr2.close();
        fr2.close();
    }

    public void updateImages(Vector<String> images, Vector<String> imagesObj) throws IOException {
        File file = new File("Util/images.txt");
        FileWriter fr = new FileWriter(file);
        PrintWriter pr = new PrintWriter(fr);
        for (int i = 0; i < images.size(); ++i) {
            pr.println(images.get(i));
        }
        pr.close();
        fr.close();
        File file2 = new File("Util/images_objetivo.txt");
        FileWriter fr2 = new FileWriter(file2);
        PrintWriter pr2 = new PrintWriter(fr2);
        for (int i = 0; i < imagesObj.size(); ++i) {
            pr2.println(imagesObj.get(i));
        }
        pr2.close();
        fr2.close();
    }

    public void updateWordsTest(Vector<String> palabras, Vector<String> objetivos) throws IOException {
        File file = new File("Util/palabra_test.txt");
        FileWriter fr = new FileWriter(file);
        PrintWriter pr = new PrintWriter(fr);
        for (int i = 0; i < palabras.size(); ++i) {
            pr.println(palabras.get(i));
        }
        pr.close();
        fr.close();
        File file2 = new File("Util/objetivo_test.txt");
        FileWriter fr2 = new FileWriter(file2);
        PrintWriter pr2 = new PrintWriter(fr2);
        for (int i = 0; i < objetivos.size(); ++i) {
            pr2.println(objetivos.get(i));
        }
        pr2.close();
        fr2.close();
    }

    public void updateImagesTest(Vector<String> images, Vector<String> imagesObj) throws IOException {
        File file = new File("Util/images_test.txt");
        FileWriter fr = new FileWriter(file);
        PrintWriter pr = new PrintWriter(fr);
        for (int i = 0; i < images.size(); ++i) {
            pr.println(images.get(i));
        }
        pr.close();
        fr.close();
        File file2 = new File("Util/images_objetivo_test.txt");
        FileWriter fr2 = new FileWriter(file2);
        PrintWriter pr2 = new PrintWriter(fr2);
        for (int i = 0; i < imagesObj.size(); ++i) {
            pr2.println(imagesObj.get(i));
        }
        pr2.close();
        fr2.close();
    }
}


/*
 * Decompiled with CFR 0_122.
 */
package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Vector;

/**
 * 
 * @author manuelpamplona
 */
public class ManageWords {
    private int contElementTest = -1;
    public static Vector<String> elementsTest = new Vector();
    private int contKeysTest = -1;
    public static Vector<String> keysTest = new Vector();
    private int contElementsExp = -1;
    public static Vector<String> elementsExp = new Vector();
    private int contKeysExp = -1;
    public static Vector<String> keysExp = new Vector();
    private int contImage = -1;
    public static Vector<String> images = new Vector();
    private int contImageObj = -1;
    public static Vector<String> imagesObj = new Vector();
    private int contImageTest = -1;
    public static Vector<String> imagesTest = new Vector();
    private int contImageObjTest = -1;
    public static Vector<String> imagesObjTest = new Vector();
    public static Properties configurationParamter = new Properties();
    public static Properties configurationParamterImage = new Properties();
    
    public void initConfigurationParameter() throws FileNotFoundException, IOException {
        File file = new File("configuration-parameter.properties");
        if(file.exists()) {
            InputStream input = new FileInputStream(file);
            configurationParamter.load(input);
            input.close();
        } else {
            OutputStream output = new FileOutputStream(file);
            configurationParamter.setProperty("practica", "true");
            configurationParamter.setProperty("soa-practica", "200");
            configurationParamter.setProperty("isi-practica", "100");
            configurationParamter.setProperty("ejercicios-practica", "3");
            configurationParamter.setProperty("aleatorio-practica", "true");
            configurationParamter.setProperty("soa", "200");
            configurationParamter.setProperty("isi", "100");
            configurationParamter.setProperty("ejercicios", "3");
            configurationParamter.setProperty("aleatorio", "true");
            configurationParamter.setProperty("responsable", "Experimentador");
            configurationParamter.setProperty("sujeto-experimental", "Sujeto de prueba");
            configurationParamter.store(output, null);
            output.close();
        }
    }
    
    public void initConfigurationParameterImage() throws FileNotFoundException, IOException {
        File file = new File("configuration-parameter-test.properties");
        if(file.exists()) {
            InputStream input = new FileInputStream(file);
            configurationParamterImage.load(input);
            input.close();
        } else {
            OutputStream output = new FileOutputStream(file);
            configurationParamterImage.setProperty("practica", "true");
            configurationParamterImage.setProperty("soa-practica", "200");
            configurationParamterImage.setProperty("isi-practica", "100");
            configurationParamterImage.setProperty("ejercicios-practica", "3");
            configurationParamterImage.setProperty("aleatorio-practica", "true");
            configurationParamterImage.setProperty("soa", "200");
            configurationParamterImage.setProperty("isi", "100");
            configurationParamterImage.setProperty("ejercicios", "3");
            configurationParamterImage.setProperty("aleatorio", "true");
            configurationParamterImage.setProperty("responsable", "Experimentador");
            configurationParamterImage.setProperty("sujeto-experimental", "Sujeto de prueba");
            configurationParamterImage.store(output, null);
            output.close();
        }
    }

    public void initWords() throws FileNotFoundException, IOException {
        ManageFile read = new ManageFile();
        Vector<String> palabras = read.getPalabras();
        Vector<String> objetivos = read.getObjetivos();
        for (int i = 0; i < palabras.size(); ++i) {
            Palabras.paresExperimento.put(palabras.get(i).toString(), objetivos.get(i).toString());
            elementsExp.add(palabras.get(i).toString());
            keysExp.add(objetivos.get(i).toString());
        }
    }

    public void initImages() throws FileNotFoundException, IOException {
        ManageFile read = new ManageFile();
        Vector<String> imagenes = read.getImages();
        Vector<String> objetivos = read.getImagesObjective();
        for (int i = 0; i < imagenes.size(); ++i) {
            images.add(imagenes.get(i).toString());
            imagesObj.add(objetivos.get(i).toString());
        }
    }

    public void initImagesTest() throws FileNotFoundException, IOException {
        ManageFile read = new ManageFile();
        Vector<String> imagenes = read.getImagesTest();
        Vector<String> objetivos = read.getImagesObjectiveTest();
        for (int i = 0; i < imagenes.size(); ++i) {
            imagesTest.add(imagenes.get(i).toString());
            imagesObjTest.add(objetivos.get(i).toString());
        }
    }

    public void removeWord(int position) {
        Vector<String> newVector = new Vector<String>();
        Vector<String> newVector2 = new Vector<String>();
        for (int i = 0; i < elementsExp.size(); ++i) {
            if (i == position) continue;
            newVector.add(elementsExp.get(i));
            newVector2.add(keysExp.get(i));
        }
        elementsExp = newVector;
        keysExp = newVector2;
    }

    public void removeWordTest(int position) {
        Vector<String> newVector = new Vector<String>();
        Vector<String> newVector2 = new Vector<String>();
        for (int i = 0; i < elementsTest.size(); ++i) {
            if (i == position) continue;
            newVector.add(elementsTest.get(i));
            newVector2.add(keysTest.get(i));
        }
        elementsTest = newVector;
        keysTest = newVector2;
    }

    public void removeImage(int position) {
        Vector<String> newVector = new Vector<String>();
        Vector<String> newVector2 = new Vector<String>();
        for (int i = 0; i < images.size(); ++i) {
            if (i == position) continue;
            newVector.add(images.get(i));
            newVector2.add(imagesObj.get(i));
        }
        images = newVector;
        imagesObj = newVector2;
    }

    public void removeImageTest(int position) {
        Vector<String> newVector = new Vector<String>();
        Vector<String> newVector2 = new Vector<String>();
        for (int i = 0; i < imagesTest.size(); ++i) {
            if (i == position) continue;
            newVector.add(imagesTest.get(i));
            newVector2.add(imagesObjTest.get(i));
        }
        imagesTest = newVector;
        imagesObjTest = newVector2;
    }

    public void initWordsTest() throws FileNotFoundException, IOException {
        ManageFile read = new ManageFile();
        Vector<String> palabras = read.getPalabrasTest();
        Vector<String> objetivos = read.getObjetivosTest();
        for (int i = 0; i < palabras.size(); ++i) {
            Palabras.paresPrueba.put(palabras.get(i).toString(), objetivos.get(i).toString());
            elementsTest.add(palabras.get(i).toString());
            keysTest.add(objetivos.get(i).toString());
        }
    }

    public void addPairWords(String palabra, String objetivo) throws IOException {
        ManageFile write = new ManageFile();
        write.insertWords(palabra, objetivo);
        Palabras.paresExperimento.put(palabra, objetivo);
        elementsExp.add(palabra);
        keysExp.add(objetivo);
    }

    public void addPairWordsTest(String palabra, String objetivo) throws IOException {
        ManageFile write = new ManageFile();
        write.insertWordsTest(palabra, objetivo);
        Palabras.paresPrueba.put(palabra, objetivo);
        elementsTest.add(palabra);
        keysTest.add(objetivo);
    }

    public void addPairImages(String img, String imgObj) throws IOException {
        ManageFile write = new ManageFile();
        write.insertImages(img, imgObj);
        images.add(img);
        imagesObj.add(imgObj);
    }

    public void addPairImagesTest(String img, String imgObj) throws IOException {
        ManageFile write = new ManageFile();
        write.insertImagesTest(img, imgObj);
        
        imagesTest.add(img);
        imagesObjTest.add(imgObj);
    }

    public void updateWords(Vector<String> el, Vector<String> ky) throws IOException {
        ManageFile update = new ManageFile();
        update.updateWords(el, ky);
    }

    public void updateWordsTest(Vector<String> el, Vector<String> ky) throws IOException {
        ManageFile update = new ManageFile();
        update.updateWordsTest(el, ky);
    }

    public void updateImages(Vector<String> el, Vector<String> ky) throws IOException {
        ManageFile update = new ManageFile();
        update.updateImages(el, ky);
    }

    public void updateImagesTest(Vector<String> el, Vector<String> ky) throws IOException {
        ManageFile update = new ManageFile();
        update.updateImagesTest(el, ky);
    }

    public String getNextWord() {
        ++this.contElementsExp;
        return elementsExp.get(this.contElementsExp);
    }

    public String getNextWordPair() {
        ++this.contKeysExp;
        return keysExp.get(this.contKeysExp);
    }

    public String getNextWordTest() {
        ++this.contElementTest;
        return elementsTest.get(this.contElementTest);
    }

    public String getNextWordTestPair() {
        ++this.contKeysTest;
        return keysTest.get(this.contKeysTest);
    }

    public String getNextImage() {
        ++this.contImage;
        return images.get(this.contImage);
    }

    public String getNextImageObj() {
        ++this.contImageObj;
        return imagesObj.get(this.contImageObj);
    }

    public String getNextImageTest() {
        ++this.contImageTest;
        return imagesTest.get(this.contImageTest);
    }

    public String getNextImageObjTest() {
        ++this.contImageObjTest;
        return imagesObjTest.get(this.contImageObjTest);
    }
}


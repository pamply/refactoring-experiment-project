/*
 * Decompiled with CFR 0_122.
 */
package utilities;

import java.util.Random;
import java.util.Vector;

/**
 * 
 * @author manuelpamplona
 */
public class RandomWord {
    private Vector<Integer> index = new Vector();
    private Vector<Integer> indexTest = new Vector();
    private Random random = new Random();

    public int getNextIndex() {
        boolean isNewNumber = false;
        int tipo = 0;
        while (!isNewNumber) {
            isNewNumber = true;
            tipo = this.random.nextInt(ManageWords.elementsExp.size());
            for (int i = 0; i < this.index.size(); ++i) {
                if (tipo != this.index.get(i)) continue;
                isNewNumber = false;
            }
        }
        this.index.add(tipo);
        return tipo;
    }

    public int getNextIndexTest() {
        boolean isNewNumber = false;
        int tipo = 0;
        while (!isNewNumber) {
            isNewNumber = true;
            System.out.println("Size : " + ManageWords.elementsTest.size());
            tipo = this.random.nextInt(ManageWords.elementsTest.size());
            for (int i = 0; i < this.indexTest.size(); ++i) {
                if (tipo != this.indexTest.get(i)) continue;
                isNewNumber = false;
            }
        }
        System.out.println(tipo);
        this.indexTest.add(tipo);
        return tipo;
    }

    public int getNextIndexImg() {
        boolean isNewNumber = false;
        int tipo = 0;
        while (!isNewNumber) {
            isNewNumber = true;
            tipo = this.random.nextInt(ManageWords.images.size());
            for (int i = 0; i < this.index.size(); ++i) {
                if (tipo != this.index.get(i)) continue;
                isNewNumber = false;
            }
        }
        this.index.add(tipo);
        return tipo;
    }

    public int getNextIndexImgTest() {
        boolean isNewNumber = false;
        int tipo = 0;
        while (!isNewNumber) {
            isNewNumber = true;
            System.out.println("Size : " + ManageWords.imagesTest.size());
            tipo = this.random.nextInt(ManageWords.imagesTest.size());
            for (int i = 0; i < this.indexTest.size(); ++i) {
                if (tipo != this.indexTest.get(i)) continue;
                isNewNumber = false;
            }
        }
        System.out.println(tipo);
        this.indexTest.add(tipo);
        return tipo;
    }
}


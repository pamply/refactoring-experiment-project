/*
 * Decompiled with CFR 0_122.
 */
package utilities;

import java.io.File;

/**
 * 
 * @author manuelpamplona
 */
public class Init {
    private String[] files = new String[]{"Util/images_objetivo_test.txt", "Util/images_objetivo.txt", "Util/images_test.txt", "Util/images.txt", "Util/objetivo_test.txt", "Util/objetivo.txt", "Util/palabra_test.txt", "Util/palabra.txt"};
    public static final String DIRECTORY = "Util";
    public static final String IMG_OBJ_TEST = "Util/images_objetivo_test.txt";
    public static final String IMG_OBJ = "Util/images_objetivo.txt";
    public static final String IMG_TEST = "Util/images_test.txt";
    public static final String IMG = "Util/images.txt";
    public static final String OBJ_TEST = "Util/objetivo_test.txt";
    public static final String OBJ = "Util/objetivo.txt";
    public static final String WORD_TEST = "Util/palabra_test.txt";
    public static final String WORD = "Util/palabra.txt";

    public Init() {
        this.createFile("Util", true);
        for (String file : this.files) {
            this.createFile(file, false);
        }
    }

    private void createFile(String fileName, boolean isDirectory) {
        File file = new File(fileName);
        try {
            if (!file.exists()) {
                if (isDirectory) {
                    file.mkdir();
                } else {
                    file.createNewFile();
                }
                System.out.println("Creado");
            } else {
                System.out.println("No Creado");
            }
        }
        catch (Exception ex) {
            System.out.println("No Creado");
        }
    }
}


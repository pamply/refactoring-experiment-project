/*
 * Decompiled with CFR 0_122.
 */
package utilities;

import constants.ExperimentType;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * 
 * @author manuelpamplona
 */
public class Configuracion {
    
    private boolean hasPrueba = true;
    private int numPruebas = Palabras.paresPrueba.size();
    private int numExperimento = Palabras.paresExperimento.size();
    private boolean isAleatorioExperimento = true;
    private boolean isAleatorioPrueba = true;
    private int soaPrueba = 200;
    private int isiPrueba = 100;
    private int soaExperimento = 200;
    private int isiExperimento = 100;
    private int numObjPrueba;
    private int numObjEnsayo;
    private String nombreExperimentador = "Experimentador";
    private String sujetoExperimental = "Sujeto de prueba";
    private static final String CONFIGURATION_IMAGES_PATH = "Util/configuracion_imagenes.properties";
    private static final String CONFIGURATION_WORDS_PATH = "Util/configuration_palabras.properties";
    private ExperimentType experimentType = null;
    
    public Configuracion(ExperimentType experimentType) {
        this.experimentType = experimentType;
        Properties prop = new Properties();
        InputStream input = null;
        try {
            if (experimentType.compareTo(ExperimentType.IMAGE) == 0) {
                input = new FileInputStream(CONFIGURATION_IMAGES_PATH);
            } else {
                input = new FileInputStream(CONFIGURATION_WORDS_PATH);
            }
            prop.load(input);
            this.load(prop);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void load(Properties p) {
        hasPrueba = Boolean.parseBoolean(p.getProperty("activar_practica"));
        
        if (experimentType.compareTo(ExperimentType.IMAGE) == 0) {
            numPruebas = (Integer.valueOf(p.getProperty("numero_ejercicios_practica")) > ManageWords.imagesTest.size() ? ManageWords.imagesTest.size() : Integer.valueOf(p.getProperty("numero_ejercicios_practica")) );
            numExperimento = (Integer.valueOf(p.getProperty("numero_ejercicios_experimento")) > ManageWords.images.size() ? ManageWords.images.size() : Integer.valueOf(p.getProperty("numero_ejercicios_experimento")) );
        } else {
            numPruebas = (Integer.valueOf(p.getProperty("numero_ejercicios_practica")) > Palabras.paresPrueba.size() ? Palabras.paresPrueba.size() : Integer.valueOf(p.getProperty("numero_ejercicios_practica")) );
            numExperimento = (Integer.valueOf(p.getProperty("numero_ejercicios_experimento")) > Palabras.paresExperimento.size() ? Palabras.paresExperimento.size() : Integer.valueOf(p.getProperty("numero_ejercicios_experimento")) );
        }
        
        isAleatorioExperimento = Boolean.parseBoolean(p.getProperty("aleatorio_experimento"));
        
        isAleatorioPrueba = Boolean.parseBoolean(p.getProperty("aleatorio_practica"));
        soaPrueba = Integer.valueOf(p.getProperty("soa_practica"));
        isiPrueba = Integer.valueOf(p.getProperty("isi_practica"));
        soaExperimento = Integer.valueOf(p.getProperty("soa_experimento"));
        
        isiExperimento = Integer.valueOf(p.getProperty("isi_experimento"));
        nombreExperimentador = p.getProperty("responsable");
        sujetoExperimental = p.getProperty("sujeto_experimental");
    }
    
    public boolean save() {
        Properties prop = new Properties();
	OutputStream output = null;
        
        try {
            if (this.experimentType.compareTo(ExperimentType.IMAGE) == 0) {
                output = new FileOutputStream(CONFIGURATION_IMAGES_PATH);
            } else {
                output = new FileOutputStream(CONFIGURATION_WORDS_PATH);
            }
            prop.setProperty("activar_practica", String.valueOf(hasPrueba));
            prop.setProperty("numero_ejercicios_practica", String.valueOf(numPruebas));
            prop.setProperty("numero_ejercicios_experimento", String.valueOf(numExperimento));
            prop.setProperty("aleatorio_experimento", String.valueOf(isAleatorioExperimento));
            
            prop.setProperty("aleatorio_practica", String.valueOf(isAleatorioPrueba));
            prop.setProperty("soa_practica", String.valueOf(soaPrueba));
            prop.setProperty("isi_practica", String.valueOf(isiPrueba));
            prop.setProperty("soa_experimento", String.valueOf(soaExperimento));
            
            prop.setProperty("isi_experimento", String.valueOf(isiExperimento));
            prop.setProperty("responsable", String.valueOf(nombreExperimentador));
            prop.setProperty("sujeto_experimental", String.valueOf(sujetoExperimental));
            
            prop.store(output, null);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
            return false;
        } catch (IOException io) {
            io.printStackTrace();
            return false;
        } finally {
            if (output != null) {
                try {
                    output.close();
                    return true;
		} catch (IOException e) {
                    e.printStackTrace();
                    return false;
		}
            }

	}
        return true;
    }
   
    public boolean isHasPrueba() {
        return this.hasPrueba;
    }

    public void setHasPrueba(boolean hasPrueba) {
        this.hasPrueba = hasPrueba;
    }

    public int getNumPruebas() {
        return this.numPruebas;
    }

    public void setNumPruebas(int numPruebas) {
        this.numPruebas = numPruebas;
    }

    public int getNumExperimento() {
        return this.numExperimento;
    }

    public void setNumExperimento(int numExperimento) {
        this.numExperimento = numExperimento;
    }

    public boolean isIsAleatorioExperimento() {
        return this.isAleatorioExperimento;
    }

    public void setIsAleatorioExperimento(boolean isAleatorioExperimento) {
        this.isAleatorioExperimento = isAleatorioExperimento;
    }

    public boolean isIsAleatorioPrueba() {
        return this.isAleatorioPrueba;
    }

    public void setIsAleatorioPrueba(boolean isAleatorioPrueba) {
        this.isAleatorioPrueba = isAleatorioPrueba;
    }

    public int getSoaPrueba() {
        return this.soaPrueba;
    }

    public void setSoaPrueba(int soaPrueba) {
        this.soaPrueba = soaPrueba;
    }

    public int getNumObjPrueba() {
        return this.numObjPrueba;
    }

    public void setNumObjPrueba(int numObjPrueba) {
        this.numObjPrueba = numObjPrueba;
    }

    public int getNumObjEnsayo() {
        return this.numObjEnsayo;
    }

    public void setNumObjEnsayo(int numObjEnsayo) {
        this.numObjEnsayo = numObjEnsayo;
    }

    public int getIsiPrueba() {
        return this.isiPrueba;
    }

    public void setIsiPrueba(int isiPrueba) {
        this.isiPrueba = isiPrueba;
    }

    public String getNombreExperimentador() {
        return this.nombreExperimentador;
    }

    public void setNombreExperimentador(String nombreExperimentador) {
        this.nombreExperimentador = nombreExperimentador;
    }

    public String getSujetoExperimental() {
        return this.sujetoExperimental;
    }

    public void setSujetoExperimental(String sujetoExperimental) {
        this.sujetoExperimental = sujetoExperimental;
    }

    public int getSoaExperimento() {
        return this.soaExperimento;
    }

    public void setSoaExperimento(int soaExperimento) {
        this.soaExperimento = soaExperimento;
    }

    public int getIsiExperimento() {
        return this.isiExperimento;
    }

    public void setIsiExperimento(int isiExperimento) {
        this.isiExperimento = isiExperimento;
    }
}


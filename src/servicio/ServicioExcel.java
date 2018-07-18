/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  jxl.CellView
 *  jxl.Workbook
 *  jxl.WorkbookSettings
 *  jxl.format.CellFormat
 *  jxl.format.UnderlineStyle
 *  jxl.write.Label
 *  jxl.write.Number
 *  jxl.write.WritableCell
 *  jxl.write.WritableCellFormat
 *  jxl.write.WritableFont
 *  jxl.write.WritableFont$BoldStyle
 *  jxl.write.WritableFont$FontName
 *  jxl.write.WritableSheet
 *  jxl.write.WritableWorkbook
 *  jxl.write.WriteException
 *  jxl.write.biff.RowsExceededException
 */
package servicio;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Vector;
import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.CellFormat;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import utilities.Configuracion;
import utilities.Resultado;

/**
 * 
 * @author manuelpamplona
 */
public class ServicioExcel {
    private WritableCellFormat timesBoldUnderline;
    private WritableCellFormat timesSubTitle;
    private WritableCellFormat times;
    private String inputFile;
    private int positionX;
    private int positionY;
    private int contadorCorrectas;
    private Configuracion configuracion;
    private Vector<Resultado> resultados = new Vector();
    private Vector<Resultado> tests = new Vector();
    private Vector<Resultado> experimentos = new Vector();
    private Resultado[] resultado;

    public void setOutputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public void write() throws IOException, WriteException {
        File file = new File(this.inputFile);
        WorkbookSettings wbSettings = new WorkbookSettings();
        wbSettings.setLocale(new Locale("en", "EN"));
        WritableWorkbook workbook = Workbook.createWorkbook((File)file, (WorkbookSettings)wbSettings);
        workbook.createSheet("Resultados", 0);
        WritableSheet excelSheet = workbook.getSheet(0);
        this.createLabel(excelSheet);
        this.createContent(excelSheet);
        workbook.write();
        workbook.close();
    }

    private void createLabel(WritableSheet sheet) throws WriteException {
        int i;
        WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
        this.times = new WritableCellFormat(times10pt);
        this.times.setWrap(true);
        WritableFont times11ptBoldUnderline = new WritableFont(WritableFont.TIMES, 11, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE);
        this.timesSubTitle = new WritableCellFormat(times11ptBoldUnderline);
        WritableFont times12ptBoldUnderline = new WritableFont(WritableFont.TIMES, 12, WritableFont.BOLD, false, UnderlineStyle.SINGLE);
        this.timesBoldUnderline = new WritableCellFormat(times12ptBoldUnderline);
        this.timesBoldUnderline.setWrap(true);
        CellView cv = new CellView();
        cv.setFormat((CellFormat)this.times);
        cv.setFormat((CellFormat)this.timesBoldUnderline);
        cv.setAutosize(true);
        this.addCaption(sheet, 0, 0, "Configuraci\u00f3n del experimento");
        this.addSubtitle(sheet, 0, 1, "N\u00famero de pruebas");
        this.addSubtitle(sheet, 0, 2, "SOA Prueba");
        this.addSubtitle(sheet, 0, 3, "ISI Prueba");
        this.addSubtitle(sheet, 0, 4, "Realiz\u00f3 prueba");
        this.addSubtitle(sheet, 0, 5, "\u00bfLa prueba es aleatoria?");
        this.addSubtitle(sheet, 0, 6, "N\u00famero de experimentos");
        this.addSubtitle(sheet, 0, 7, "SOA Experimento");
        this.addSubtitle(sheet, 0, 8, "ISI Experimento");
        this.addSubtitle(sheet, 0, 9, "\u00bfEl experimento es aleatorio?");
        this.addSubtitle(sheet, 0, 10, "Nombre del experimentador");
        this.addSubtitle(sheet, 0, 11, "Nombre del sujeto experimental");
        this.addCaption(sheet, 0, 13, "Resultados");
        for (i = 0; i < this.tests.size(); ++i) {
            this.addSubtitle(sheet, 0, 15 + i, "Prueba " + (i + 1));
        }
        this.addSubtitle(sheet, 1, 14, "Respuesta");
        this.addSubtitle(sheet, 2, 14, "Tiempo de respuesta");
        this.addSubtitle(sheet, 3, 14, "Est\u00edmulo");
        this.addSubtitle(sheet, 4, 14, "Objetivo");
    }

    private void createTitleExperiments(WritableSheet sheet, int index) throws WriteException {
        for (int i = 0; i < this.experimentos.size(); ++i) {
            this.addSubtitle(sheet, 0, index + i + 1, "Experimento" + (i + 1));
        }
        this.addSubtitle(sheet, 1, index, "Respuesta");
        this.addSubtitle(sheet, 2, index, "Tiempo de respuesta");
        this.addSubtitle(sheet, 3, index, "Est\u00edmulo");
        this.addSubtitle(sheet, 4, index, "Objetivo");
    }
    
    private void createVectors() {
        for (int i = 0; i < this.resultados.size(); ++i) {
            if (this.resultados.get(i).isIsTest()) {
                this.tests.add(this.resultados.get(i));
                continue;
            }
            this.experimentos.add(this.resultados.get(i));
        }
    }

    private void createContent(WritableSheet sheet) throws WriteException, RowsExceededException {
        int i;
        this.addNumber(sheet, 1, 1, this.configuracion.getNumPruebas());
        this.addNumber(sheet, 1, 2, this.configuracion.getSoaPrueba());
        this.addNumber(sheet, 1, 3, this.configuracion.getIsiPrueba());
        if (this.configuracion.isHasPrueba()) {
            this.addLabel(sheet, 1, 4, "Si");
        } else {
            this.addLabel(sheet, 1, 4, "No");
        }
        if (this.configuracion.isIsAleatorioPrueba()) {
            this.addLabel(sheet, 1, 5, "Si");
        } else {
            this.addLabel(sheet, 1, 5, "No");
        }
        this.addNumber(sheet, 1, 6, this.configuracion.getNumExperimento());
        this.addNumber(sheet, 1, 7, this.configuracion.getSoaExperimento());
        this.addNumber(sheet, 1, 8, this.configuracion.getIsiExperimento());
        if (this.configuracion.isIsAleatorioExperimento()) {
            this.addLabel(sheet, 1, 9, "Si");
        } else {
            this.addLabel(sheet, 1, 9, "No");
        }
        this.addLabel(sheet, 1, 10, this.configuracion.getNombreExperimentador());
        this.addLabel(sheet, 1, 11, this.configuracion.getSujetoExperimental());
        
        int lastRow = 15;
        for (i = 0; i < this.tests.size(); ++i) {
            if (this.tests.get(i).isResponse()) {
                this.addLabel(sheet, 1, 15 + i, "Si");
            } else {
                this.addLabel(sheet, 1, 15 + i, "No");
            }
            this.addLabel(sheet, 2, 15 + i, "" + this.tests.get(i).getTime() + "");
            this.addLabel(sheet, 3, 15 + i, this.tests.get(i).getWord());
            this.addLabel(sheet, 4, 15 + i, this.tests.get(i).getKeyWord());
            
            lastRow += 1;
        }
        
        this.createTitleExperiments(sheet, lastRow + 2);
        
        lastRow += 3;
        
        for (i = 0; i < this.experimentos.size(); ++i) {
            if (this.experimentos.get(i).isResponse()) {
                this.addLabel(sheet, 1, lastRow + i, "Si");
            } else {
                this.addLabel(sheet, 1, lastRow + i, "No");
            }
            this.addLabel(sheet, 2, lastRow + i, "" + this.experimentos.get(i).getTime() + "");
            this.addLabel(sheet, 3, lastRow + i, this.experimentos.get(i).getWord());
            this.addLabel(sheet, 4, lastRow + i, this.experimentos.get(i).getKeyWord());
        }
    }

    private void addCaption(WritableSheet sheet, int column, int row, String s) throws RowsExceededException, WriteException {
        Label label = new Label(column, row, s, (CellFormat)this.timesBoldUnderline);
        sheet.addCell((WritableCell)label);
    }

    private void addSubtitle(WritableSheet sheet, int column, int row, String string) throws WriteException, RowsExceededException {
        Label label = new Label(column, row, string, (CellFormat)this.timesSubTitle);
        sheet.addCell((WritableCell)label);
    }

    private void addNumber(WritableSheet sheet, int column, int row, Integer integer) throws WriteException, RowsExceededException {
        Number number = new Number(column, row, integer.intValue(), (CellFormat)this.times){};
        sheet.addCell((WritableCell)number);
    }

    private void addLabel(WritableSheet sheet, int column, int row, String s) throws WriteException, RowsExceededException {
        Label label = new Label(column, row, s, (CellFormat)this.times);
        sheet.addCell((WritableCell)label);
    }

    public void generateExcel(Configuracion config, Vector<Resultado> results, String path) throws IOException, WriteException {
        this.configuracion = config;
        this.resultados = results;
        this.createVectors();
        this.setOutputFile(path);
        this.write();
    }

    public static void main(String[] args) throws WriteException, IOException {
        ServicioExcel test = new ServicioExcel();
        test.setOutputFile("C:/temp/lars.xls");
        test.write();
        System.out.println("Please check the result file under c:/temp/lars.xls ");
    }

}


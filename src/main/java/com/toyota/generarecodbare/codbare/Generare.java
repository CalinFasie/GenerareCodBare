package com.toyota.generarecodbare.codbare;

import com.toyota.generarecodbare.gui.MainForm;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

import java.io.File;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class Generare {
    public static String adresa1;
    public static void generate() throws IOException {
//        String text = "12345678901234567890";
//        File file = new File("path/to/destination/file");
//        File file = new File("coduri_bara.png");

        String fileName = MainForm.text.replaceAll("[^a-zA-Z0-9\\s]","");
 //       File file = new File(MainForm.text + ".png");
        File file = new File(fileName + ".png");
        System.out.println("in generare: " + MainForm.text);
        if (MainForm.text == null) {
            JOptionPane.showMessageDialog(null, "Informare", "Codul nu trebuie sa fie null", 1);
        } else {
            try {
                Barcode barcode = BarcodeFactory.createCode128(MainForm.text);
                barcode.setBarHeight(100);
//            barcode.setBarWidth(1);
//            barcode.setSize(100,50);
                barcode.setResolution(200);
                BarcodeImageHandler.savePNG(barcode, file);
//            BarcodeImageHandler.saveJPEG(barcode, file);
            } catch (OutputException e) {
                throw new RuntimeException(e);
            } catch (BarcodeException e) {
                throw new RuntimeException(e);
            }
        }
//        try {
////            new MainForm().jLabel2.setVisible(true);
////            new MainForm().jLabel2.setIcon(new javax.swing.ImageIcon("D:\\Workspace\\GenerareCodBare\\coduri_bara.png")); // NOI18N
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        File workingDirectory = new File(System.getProperty("user.dir").toString() + "\\coduri_bara.png");
        File workingDirectory = new File(System.getProperty("user.dir").toString() + "\\" + file);
 //       String adresa1 = workingDirectory.toString();
         adresa1 = workingDirectory.toString();
        adresa1 = adresa1.replace("\\", "\\\\");
        final ImageIcon icon = new ImageIcon(adresa1);
        JOptionPane.showMessageDialog(null, "", MainForm.denumire, JOptionPane.INFORMATION_MESSAGE, icon);
//        JOptionPane.showMessageDialog(null, "Informare", "Eticheta a fost generata", 1);

    }
}

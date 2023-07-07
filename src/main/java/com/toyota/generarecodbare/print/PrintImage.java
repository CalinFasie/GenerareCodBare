package com.toyota.generarecodbare.print;

import com.toyota.generarecodbare.codbare.Generare;
import com.toyota.generarecodbare.gui.MainForm;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.swing.*;
import java.io.FileInputStream;

import static com.toyota.generarecodbare.codbare.Generare.adresa1;

public class PrintImage {
;
    public static void print() throws Exception {
        Generare.generate();
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        pras.add(new Copies(1));
        PrintService pss[] = PrintServiceLookup.lookupPrintServices(DocFlavor.INPUT_STREAM.GIF, pras);
        if (pss.length == 0)
            throw new RuntimeException("No printer services available.");
        PrintService ps = pss[0];
        System.out.println("Printing to " + ps);
        DocPrintJob job = ps.createPrintJob();
//        FileInputStream fin = new FileInputStream("YOurImageFileName.PNG");
 //       FileInputStream fin = new FileInputStream("123457.PNG");
//        FileInputStream fin = new FileInputStream(adresa1);

        final ImageIcon icon = new ImageIcon(adresa1);
//        JOptionPane.showMessageDialog(null, "", "Eticheta a fost generata", JOptionPane.INFORMATION_MESSAGE, icon);
        JOptionPane.showMessageDialog(null, "", "test", JOptionPane.INFORMATION_MESSAGE, icon);

        FileInputStream fin = new FileInputStream("D:\\Workspace\\GenerareCodBare\\coduri_bara.png");
        Doc doc = new SimpleDoc(fin, DocFlavor.INPUT_STREAM.GIF, null);
        job.print(doc, pras);
        fin.close();
    }
}
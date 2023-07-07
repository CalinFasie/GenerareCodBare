package com.toyota.generarecodbare.zpl;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.comm.DriverPrinterConnection;
import com.zebra.sdk.printer.ZebraPrinter;
import com.zebra.sdk.printer.ZebraPrinterFactory;
import com.zebra.sdk.printer.ZebraPrinterLanguageUnknownException;

public class ZebraPrinting {
    public static void print(String middle) {

        Connection connectionZpl = null;

        try {
            connectionZpl = new DriverPrinterConnection("ZDesigner GK420t");
            connectionZpl.open();

            ZebraPrinter printer = ZebraPrinterFactory.getInstance(connectionZpl);

            // Code to print barcode using ZPL script
//           String zplCommand = "^XA^FO20,20^A0N,30,30^FDHello, Zebra!^FS^XZ";
//            String zplCommand = "^XA^FO100,50^BY2^BCN,100,Y,N,N^FD123456^FS^XZ";   //4    ok mic
//            String zplCommand = "^XA^FO50,50^BY3^BCN,100,Y,N,N^FD123456^FS^XZ";   //7       ok mare
            String inceput="^XA^FO50,50^BY1^BCN,100,Y,N,N^FD";
            String coada = "^FS^XZ";
            String zplCommand = inceput + middle + coada;
            System.out.println("In zpl " + zplCommand);

            printer.sendCommand(zplCommand);
        } catch (ConnectionException | ZebraPrinterLanguageUnknownException e) {
            e.printStackTrace();
        } finally {
            if (connectionZpl != null) {
                try {
                    connectionZpl.close();
                } catch (ConnectionException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

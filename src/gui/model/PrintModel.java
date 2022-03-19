package gui.model;

import javafx.scene.control.Alert;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;
import java.io.FileInputStream;
import java.io.IOException;

public class PrintModel {

    private static PrintModel single_instance = null;
    public boolean printJobWasSuccessful;
    private Alert alert;

    private PrintModel(){
        alert = new Alert(Alert.AlertType.NONE);
    }

    public static PrintModel getInstance()
    {
        if (single_instance == null)
            single_instance = new PrintModel();

        return single_instance;
    }

    public void print(PrintService printService, FileInputStream fileInputStream) throws IOException {
        printJobWasSuccessful=false;
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        pras.add(new Copies(1));

        DocPrintJob job = printService.createPrintJob();
        Doc doc = new SimpleDoc(fileInputStream, DocFlavor.INPUT_STREAM.GIF, null);

        job.addPrintJobListener(new PrintJobAdapter() {
            public void printDataTransferCompleted(PrintJobEvent event){
                printJobWasSuccessful=true;
            }
            public void printJobNoMoreEvents(PrintJobEvent event){
                if (printJobWasSuccessful){
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setTitle("Printing Complete");
                    alert.setContentText("The print request for the ticket was sent to the chosen printer.");
                    alert.showAndWait();
                }
            }
        });

        try {
            job.print(doc, pras);
        } catch (PrintException pe){
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Printing Failed");
            alert.setContentText("The print request failed.\nCheck that you've chosen the right printer.");
            alert.showAndWait();
        } finally {
            fileInputStream.close();
        }
    }
}

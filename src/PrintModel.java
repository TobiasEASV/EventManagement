import javax.print.*;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.PrinterName;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;
import java.io.FileInputStream;
import java.io.IOException;

public class PrintModel {

    private static  PrintModel single_instance = null;

    private PrintModel(){

    }

    public static PrintModel getInstance()
    {
        if (single_instance == null)
            single_instance = new PrintModel();

        return single_instance;
    }

    public  void oldPrinter(PrintService printService, FileInputStream fileInputStream) throws PrintException, IOException {


        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        pras.add(new Copies(1));


        System.out.println("Printing to " + printService);

        DocPrintJob job = printService.createPrintJob();

        Doc doc = new SimpleDoc(fileInputStream, DocFlavor.INPUT_STREAM.GIF, null);


        job.addPrintJobListener(new PrintJobAdapter() {
            public void printDataTransferCompleted(PrintJobEvent event){
                System.out.println("data transfer complete");
            }
            public void printJobNoMoreEvents(PrintJobEvent event){
                System.out.println("received no more events");
            }
        });


        job.print(doc, pras);
        fileInputStream.close();


    }
}

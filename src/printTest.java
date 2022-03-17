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

public class printTest {

    public static void main(String[] args) throws PrintException, IOException {

        //Get print services
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
        System.out.println("Number of print services: " + printServices.length);

        for (PrintService printer : printServices)
            System.out.println("Printer: " + printer.getName());

        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        pras.add(new Copies(1));


        PrintService pss[] = PrintServiceLookup.lookupPrintServices(DocFlavor.INPUT_STREAM.GIF, pras);
        if (pss.length == 0)
            throw new RuntimeException("No printer services available.");
        PrintService ps = pss[pss.length-1];

        System.out.println("Printing to " + ps);

        DocPrintJob job = ps.createPrintJob();
        FileInputStream fin = new FileInputStream("src/gui/images/Icons/ticket_2_icon.png");
        Doc doc = new SimpleDoc(fin, DocFlavor.INPUT_STREAM.GIF, null);


        job.addPrintJobListener(new PrintJobAdapter() {
            public void printDataTransferCompleted(PrintJobEvent event){
                System.out.println("data transfer complete");
            }
            public void printJobNoMoreEvents(PrintJobEvent event){
                System.out.println("received no more events");
            }
        });


        job.print(doc, pras);
        fin.close();


    }
}

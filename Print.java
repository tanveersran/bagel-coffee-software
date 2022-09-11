/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafx_project;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javafx.embed.swing.SwingFXUtils;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Parent;

import javafx.scene.image.WritableImage;
import javax.imageio.ImageIO;

/**
 * Class to print the receipts. It can either print the receipt or save it as a
 * png file.
 *
 * @author Tanveer
 */
public class Print {

    /**
     * This method gets the Parent as a parameter which is used to get the fxml file.
     * It then calls a PrinterJob to print the fxml file on the printer page.
     * @param root fxml file.
     */
    public static void print(Parent root) {
        Printer printer = Printer.getDefaultPrinter();
        PageLayout pageLayout = printer.createPageLayout(Paper.A4,
                PageOrientation.PORTRAIT, Printer.MarginType.HARDWARE_MINIMUM);
        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null && job.showPrintDialog(root.getScene().getWindow())) {
            boolean success = job.printPage(pageLayout, root);
            if (success) {
                job.endJob();
            }
        }
    }

    /**
     * This method saves the fxml file obtained from the parameters to a file named
     * receipt(receiptNo).png. 
     * @param root
     * @throws IOException 
     */
    public static void save(Parent root) throws IOException {
        String fileName = "receipt"+Receipt.getReceiptCount()+".png";
        WritableImage snapshot = root.getScene().snapshot(null);
        File file = new File(fileName); // set file name according to receipt number
        if (file.exists())
        {
            file = new File("0"+fileName); // set this file if a file exists already
        }
        RenderedImage renderedImage = SwingFXUtils.fromFXImage(snapshot, null);
        ImageIO.write(renderedImage,"png",file);
    }

}

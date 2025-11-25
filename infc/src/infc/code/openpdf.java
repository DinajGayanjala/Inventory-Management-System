
package commen;

import infc.code.inventoryutils;
import java.awt.Desktop;
import java.io.File;

public class openpdf {

    public static void openById(String orderid) {
        try {
            String pdfPath = inventoryutils.billpath + orderid + ".pdf";
            File file = new File(pdfPath);

            if (file.exists()) {
                Desktop.getDesktop().open(file);  
            } else {
                System.out.println("PDF not found: " + pdfPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
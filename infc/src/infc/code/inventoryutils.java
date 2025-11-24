
package infc.code;

import java.io.File;


public class inventoryutils {

    // Set your PDF folder path here (make sure to use double backslash for Windows)
    public static String billpath = "C:\\Users\\User\\Documents\\Bills\\";

    // Make sure folder exists
    public static void createFolderIfNotExists() {
        File folder = new File(billpath);
        if (!folder.exists()) {
            folder.mkdirs(); // create the folder and any parent directories
        }
    }
}
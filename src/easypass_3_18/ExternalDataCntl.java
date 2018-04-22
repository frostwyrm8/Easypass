/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easypass_3_18;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author N9864
 */
public class ExternalDataCntl {

    private final String Detail_FILE_NAME = "Detaillist.TSV";

    public ExternalDataCntl() {
        System.out.println("Test");
        if (confirmImport()) {
            getDetailList();
        }
    }

    public void getDetailList() {
        File externalDataFile = new File(Detail_FILE_NAME);

        try {
            Scanner in = new Scanner(externalDataFile);
            int count = 0;
            ArrayList<Pass> tempDetailList = SerializedDataCntl.getSerializedDataCntl().getSerializedDataCollection().getPassList().getPassList();
            while (in.hasNextLine()) {
                String tempStr = in.nextLine();
                Detail tempDetail = new Detail(tempStr);
                tempDetailList.add(tempDetail);
                System.out.println(tempDetail.getAccount());
                count++;
            }
            System.out.println("Count: " + count);
            SerializedDataCntl.getSerializedDataCntl().writeSerializedDataCollection();
            SerializedDataCntl.getSerializedDataCntl().readSerializedDataCollection();

        } catch (FileNotFoundException fne) {

            String message = fne.getMessage();
            System.out.println(message);

        }

    }

    public boolean confirmImport() {
        boolean importConfirmed = false;
        String message = "Confirm to import Details?";
        String title = "Import Details";
        int result = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            importConfirmed = true;
        }
        return importConfirmed;
    }

}

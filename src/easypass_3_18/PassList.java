/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easypass_3_18;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author N9864
 */
public class PassList implements Serializable {

    ArrayList<Pass> listOfPass = null;

    public PassList() {
        if (listOfPass == null) {
            buildTestPassList();
        }

    }

    public void buildTestPassList() {
        listOfPass = new ArrayList<Pass>();
        for (int i = 0; i < 3; i++) {
            String account = ("email" + i);
            String kind = "secret";
            String note = "important";
            Pass tempDetail = new Detail(account, kind, note);
            listOfPass.add(tempDetail);
        }
    }

    public ArrayList<Pass> getPassList() {
        if (listOfPass == null) {
            buildTestPassList();
        }
        return listOfPass;
    }

    public int getListSize() {
        return listOfPass.size();
    }
}

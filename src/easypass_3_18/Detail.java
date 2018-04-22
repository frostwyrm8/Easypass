/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easypass_3_18;

/**
 *
 * @author N9864
 */
public class Detail extends Pass {

    public Detail() {
        System.out.println("Called: Detail()");
    }

    public Detail(String importDetailString) {
        super(importDetailString);
        String delimiter = "\\t";
        String[] tempDetailArray = importDetailString.split(delimiter);
    }

    public Detail(String newAccount, String newKind, String newNote) {
        super(newAccount, newKind, newNote);
    }

    public String toString() {
        String DetailString = super.toString();
        return DetailString;
    }

    public boolean equals(Object theObject) {
        Detail Detail2Compare = (Detail) theObject;
        if (this.toString().equals(Detail2Compare.toString())) {
            return true;
        } else {
            return false;
        }
    }

    public int compareTo(Object otherObject) {
        Detail tempDetail = (Detail) otherObject;
        int result = this.toString().compareTo(tempDetail.toString());
        return result;
    }

}

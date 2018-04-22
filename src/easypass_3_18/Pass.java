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
import java.io.Serializable;

public class Pass implements Serializable, Comparable {

    private String account = "";
    private String kind = "";
    private String note = "";

    public Pass() {
        System.out.println("Called: Pass()");
    }

    public Pass(String importPassString) {
        String delimiter = "\\t";
        String[] tempPassArray = importPassString.split(delimiter);

        this.account = tempPassArray[0];
        this.kind = tempPassArray[1];
        this.note = tempPassArray[2];

    }

    public Pass(String account, String kind, String note) {
        this.account = account;
        this.kind = kind;
        this.note = note;
    }

    public String getAccount() {
        return account;
    }

    public String getKind() {
        return kind;
    }

    public String getNote() {
        return note;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String toString() {
        String passString = this.account + " " + this.kind + " " + this.note;
        return passString;
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

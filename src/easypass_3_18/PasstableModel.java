/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easypass_3_18;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author N9864
 */
public class PasstableModel extends AbstractTableModel {

    private String[] columnNames = {"Account", "Kind", "Note"};
    private ArrayList<Pass> Passlist;

    public PasstableModel(ArrayList<Pass> newPassList) {
        Passlist = newPassList;
    }

    @Override
    public int getRowCount() {
        return Passlist.size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch (col) {
            case 0:
                return (Object) Passlist.get(row).getAccount();
            case 1:
                return (Object) Passlist.get(row).getKind();
            case 2:
                return (Object) Passlist.get(row).getNote();
            default:
                return null;
        }

    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

}

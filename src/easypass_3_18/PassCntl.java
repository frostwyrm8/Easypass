/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easypass_3_18;

import javax.swing.JOptionPane;

/**
 *
 * @author N9864
 */
public class PassCntl {

    private static final int STARTING_INDEX_OF_DISPLAY = 0;
    PassList thePassList;
    PassDetailUI thePassUI;
    PasstableModel thePasstableModel;
    PasstableUI thePassListUI;
    private PassDetailUI thePassDetailUI;
    private int selectedRow;
    private PasstableUI thePasstableUI;
    private NavigationCntl theNavigationCntl;
    String password = "";
    PassHashMap theKeyMap;
    String output = "";

    public PassCntl(NavigationCntl parentNavigationCntl) {
        theNavigationCntl = parentNavigationCntl;
        thePassList = SerializedDataCntl.getSerializedDataCntl().getSerializedDataCollection().getPassList();
        thePasstableModel = new PasstableModel(thePassList.getPassList());

        thePasstableUI = new PasstableUI(this);
        thePasstableUI.setVisible(true);
        thePasstableUI.setLocationRelativeTo(null);
        theKeyMap = new PassHashMap();

        thePasstableModel = new PasstableModel(thePassList.getPassList());
    }

    public void buildKeyMap(String account, String pass) {
        if (confirmSave()) {

            theKeyMap.getPassHashMap().put(account, pass);
        }

        System.out.println(theKeyMap);
    }

    public String getCurrentPassword(String account) {
        if (theKeyMap.getPassHashMap().containsKey(account)) {
            output = theKeyMap.getPassHashMap().get(account);
        } else {
            output = "";
        }
        return output;

    }

    public boolean confirmSave() {
        boolean saveConfirmed = false;
        String message = "Confirm to save this password for the account?";
        String title = "Save Details";
        int result = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            saveConfirmed = true;
        }
        return saveConfirmed;
    }

    public PasstableModel getPasstableModel() {
        return thePasstableModel;
    }

    public Pass getPass(int index) {
        return thePassList.getPassList().get(index);
    }

    public PassList getcurrentList() {
        return thePassList;
    }

    public void createPass(Pass newPass) {
        thePassList.getPassList().add(newPass);
    }

    public void deletePass(int index) {
        if (thePassList.getPassList().size() > 0) {
            thePassList.getPassList().remove(index);
            SerializedDataCntl.getSerializedDataCntl().writeSerializedDataCollection();

        } else {
            JOptionPane.showMessageDialog(null, "You cannot delete the all items!");
        }

        System.out.println(index);
    }

    public void savePass(int index, Pass newPass) {

        thePassList.getPassList().set(index, newPass);
        SerializedDataCntl.getSerializedDataCntl().writeSerializedDataCollection();

    }

    public int getListSize() {
        return thePassList.getPassList().size();
    }

    public void getPassDetailUI(int selectedRow) {
        thePassDetailUI = new PassDetailUI(this, selectedRow);
        thePassDetailUI.setVisible(true);
        thePassDetailUI.setLocationRelativeTo(null);

    }

    public void createPassDetailUI() {
        thePassDetailUI = new PassDetailUI(this, 0);
        thePassDetailUI.setVisible(true);
        thePassDetailUI.setLocationRelativeTo(null);
        SerializedDataCntl.getSerializedDataCntl().writeSerializedDataCollection();

    }

    public void requestNavigationCntl() {
        theNavigationCntl.getNavigationCntl();

    }

    public String encryptString(String input) {
        String str, Newstr = " ";
        try {
            for (int i = 0; i < input.length(); i++) {
                char ch = Character.toLowerCase(input.charAt(i));
                switch (ch) {
                    case 'a':
                        Newstr = Newstr + "{";
                        break;
                    case 'b':
                        Newstr = Newstr + "}";
                        break;
                    case 'c':
                        Newstr = Newstr + "#";
                        break;
                    case 'd':
                        Newstr = Newstr + "~";
                        break;
                    case 'e':
                        Newstr = Newstr + "+";
                        break;
                    case 'f':
                        Newstr = Newstr + "-";
                        break;
                    case 'g':
                        Newstr = Newstr + "*";
                        break;
                    case 'h':
                        Newstr = Newstr + "@";
                        break;
                    case 'i':
                        Newstr = Newstr + "/";
                        break;
                    case 'j':
                        Newstr = Newstr + "\\";
                        break;
                    case 'k':
                        Newstr = Newstr + "?";
                        break;
                    case 'l':
                        Newstr = Newstr + "$";
                        break;
                    case 'm':
                        Newstr = Newstr + "!";
                        break;
                    case 'n':
                        Newstr = Newstr + "^";
                        break;
                    case 'o':
                        Newstr = Newstr + "(";
                        break;
                    case 'p':
                        Newstr = Newstr + ")";
                        break;
                    case 'q':
                        Newstr = Newstr + "<";
                        break;
                    case 'r':
                        Newstr = Newstr + ">";
                        break;
                    case 's':
                        Newstr = Newstr + "=";
                        break;
                    case 't':
                        Newstr = Newstr + ";";
                        break;
                    case 'u':
                        Newstr = Newstr + ",";
                        break;
                    case 'v':
                        Newstr = Newstr + "_";
                        break;
                    case 'w':
                        Newstr = Newstr + "[";
                        break;
                    case 'x':
                        Newstr = Newstr + "]";
                        break;
                    case 'y':
                        Newstr = Newstr + ":";
                        break;
                    case 'z':
                        Newstr = Newstr + "\"";
                        break;
                    case ' ':
                        Newstr = Newstr + " ";
                        break;
                    case '.':
                        Newstr = Newstr + '3';
                        break;
                    case ',':
                        Newstr = Newstr + "1";
                        break;
                    case '(':
                        Newstr = Newstr + '4';
                        break;
                    case '\"':
                        Newstr = Newstr + '5';
                        break;
                    case ')':
                        Newstr = Newstr + "7";
                        break;
                    case '?':
                        Newstr = Newstr + "2";
                        break;
                    case '!':
                        Newstr = Newstr + "8";
                        break;
                    case '-':
                        Newstr = Newstr + "6";
                        break;
                    case '%':
                        Newstr = Newstr + "9";
                        break;
                    case '1':
                        Newstr = Newstr + "r";
                        break;
                    case '2':
                        Newstr = Newstr + "k";
                        break;
                    case '3':
                        Newstr = Newstr + "b";
                        break;
                    case '4':
                        Newstr = Newstr + "e";
                        break;
                    case '5':
                        Newstr = Newstr + "q";
                        break;
                    case '6':
                        Newstr = Newstr + "h";
                        break;
                    case '7':
                        Newstr = Newstr + "u";
                        break;
                    case '8':
                        Newstr = Newstr + "y";
                        break;
                    case '9':
                        Newstr = Newstr + "w";
                        break;
                    case '0':
                        Newstr = Newstr + "z";
                        break;
                    default:
                        Newstr = Newstr + "0";
                        break;
                }
            }
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }
        return Newstr;
    }

}

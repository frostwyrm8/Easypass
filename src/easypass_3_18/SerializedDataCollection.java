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

public class SerializedDataCollection implements Serializable {

    UserList theUserList;
    PassList thePassList;

    public SerializedDataCollection() {

        if (theUserList == null) {
            theUserList = new UserList();
        }
        if (thePassList == null) {
            thePassList = new PassList();
        }
    }

    public UserList getUserList() {
        return theUserList;
    }

    public PassList getPassList() {
        return thePassList;
    }

    public void setUserList(UserList newUserList) {
        theUserList = newUserList;
    }

    public void setPassList(PassList newPassList) {
        thePassList = newPassList;
    }
}

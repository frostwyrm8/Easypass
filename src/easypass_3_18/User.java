/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easypass_3_18;

import java.io.Serializable;

/**
 *
 * @author N9864
 */
public class User implements Serializable {

    private String username = null;
    private char[] password = null;
    private char[] privatekey = null;

    public User(String newUsername, char[] newPassword, char[] newPrivatekey) {
        username = newUsername;
        password = newPassword;
        privatekey = newPrivatekey;
    }

    public String getUsername() {
        return username;
    }

    public char[] getPassword() {
        return password;
    }

    public char[] getPrivatekey() {
        return privatekey;
    }

}

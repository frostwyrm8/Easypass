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
public class UserList implements Serializable {

    ArrayList<User> ListOfUser;
    private static final long serialVersionUID = -2443788180477356461L;
    User inputUser;

    public UserList() {
        if (ListOfUser == null) {
            buildTestUserList();
        }
    }

    public ArrayList<User> getListOfUser() {
        if (ListOfUser == null) {
            buildTestUserList();
        }
        return ListOfUser;
    }

    public void buildTestUserList() {
        ListOfUser = new ArrayList();
        for (int i = 0; i < 100; i++) {
            String username = ("test" + i);
            char[] password = {'t', 'e', 's', 't'};
            char[] privatekey = {'1', 'A', '1', 'B'};
            User newUser = new User(username, password, privatekey);

            ListOfUser.add(newUser);
        }
    }

    public void addUser(User input) {
        inputUser = input;
        ListOfUser.add(inputUser);

    }

    public boolean authenticate(String usernameToCheck, char[] passwordToCheck, char[] privatekeyToCheck) {
        boolean authenticated = false;
        boolean nameMatch = false;
        boolean passwordMatch = false;
        boolean privatekeyMatch = false;
        for (int i = 0; i < ListOfUser.size(); i++) {
            System.out.println(ListOfUser.get(i).getUsername());
            nameMatch = usernameToCheck.equals(ListOfUser.get(i).getUsername());
            passwordMatch = String.valueOf(passwordToCheck).equals(String.valueOf(ListOfUser.get(i).getPassword()));
            privatekeyMatch = String.valueOf(privatekeyToCheck).equals(String.valueOf(ListOfUser.get(i).getPrivatekey()));
            if (nameMatch && passwordMatch & privatekeyMatch) {
                authenticated = true;
                break;
            }

        }
        return authenticated;
    }

    public void printallusers() {
        for (int i = 0; i < ListOfUser.size(); i++) {
            System.out.println(ListOfUser.get(i).getUsername());
        }
    }
}

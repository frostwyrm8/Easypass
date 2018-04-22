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
public class LoginCntl {

    private UserList theUserList;
    private LoginUI theLoginUI;
    private SignupUI theSignupUI;
    private NavigationCntl theNavigationCntl;
    private UserCntl theUserCntl;

    public LoginCntl() {
        theUserList = SerializedDataCntl.getSerializedDataCntl().getSerializedDataCollection().getUserList();
        theLoginUI = new LoginUI(this);
        theLoginUI.setLocationRelativeTo(null);
        theLoginUI.setVisible(true);
    }

    public UserList getUserList() {
        return SerializedDataCntl.getSerializedDataCntl().getSerializedDataCollection().getUserList();
    }

    public void requestNavigationCntl() {
        theLoginUI.setVisible(false);
        theNavigationCntl = new NavigationCntl();
    }

    public void requestLoginUI() {
        theSignupUI.setVisible(false);
        theLoginUI.setVisible(true);
    }

    public void requestSignupUI() {
        theSignupUI = new SignupUI(this);
        theSignupUI.setLocationRelativeTo(null);
        theSignupUI.setVisible(true);
    }

    public boolean requestAuthenticate(String usernameToCheck, char[] passwordToCheck, char[] privatekeyToCheck) {
        boolean authenticated = theUserList.authenticate(usernameToCheck, passwordToCheck, privatekeyToCheck);
        return authenticated;
    }

}

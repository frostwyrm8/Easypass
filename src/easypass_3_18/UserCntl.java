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
public class UserCntl {

    UserList theUserList;
    LoginCntl theLoginCntl;

    public UserCntl(LoginCntl parentLoginCntl) {
        theUserList = SerializedDataCntl.getSerializedDataCntl().getSerializedDataCollection().getUserList();

    }

    public void deleteUser(int index) {
        theUserList.getListOfUser().remove(index);
        SerializedDataCntl.getSerializedDataCntl().writeSerializedDataCollection();

    }

    public void saveUser(int index, User newUser) {
        theUserList.getListOfUser().set(index, newUser);
        SerializedDataCntl.getSerializedDataCntl().writeSerializedDataCollection();
    }

    public void createUser(User newUser) {
        theUserList.getListOfUser().add(newUser);
        SerializedDataCntl.getSerializedDataCntl().writeSerializedDataCollection();

    }

}

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
public class NavigationCntl {

    private MainMenuUI theMainMenuUI = null;
    private PassCntl thePassCntl = null;

    public NavigationCntl() {
        theMainMenuUI = new MainMenuUI(this);
        theMainMenuUI.setLocationRelativeTo(null);
        theMainMenuUI.setVisible(true);
    }

    public void getPassCntl() {
        theMainMenuUI.setVisible(false);
        thePassCntl = new PassCntl(this);
    }

    public void getNavigationCntl() {
        if (theMainMenuUI == null) {
            theMainMenuUI = new MainMenuUI(this);
            theMainMenuUI.setLocationRelativeTo(null);
            theMainMenuUI.setVisible(true);
        } else {
            theMainMenuUI.setVisible(true);
        }
    }

    public void imoprtData() {
        ExternalDataCntl theExternalDataCntl = new ExternalDataCntl();
    }

}

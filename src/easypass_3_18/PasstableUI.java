/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easypass_3_18;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author N9864
 */
public class PasstableUI extends JFrame {

    private JPanel tablePanel;
    private JPanel buttonPanel;
    private final PassCntl passCntl;
    private JTable passTable;
    private JButton doneButton;
    private JButton detailsButton;
    private JButton newButton;
    private JButton backButton;
    private JScrollPane tableScroller;
    private int selectedRow = 0;

    public PasstableUI(PassCntl newPassCntl) {
        this.passCntl = newPassCntl;
        PassDetailUI thePassDetailUI = new PassDetailUI(newPassCntl, selectedRow);
        initComponents();
    }

    public void initComponents() {
        tablePanel = new JPanel();
        buttonPanel = new JPanel(new GridLayout(1, 4));
        passTable = new JTable(passCntl.getPasstableModel());
        passTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        passTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        passTable.getColumnModel().getColumn(2).setPreferredWidth(50);
        passTable.getColumnModel().getColumn(2).setPreferredWidth(50);

        doneButton = new JButton("Done");
        detailsButton = new JButton("Show Details");
        detailsButton.addActionListener(new DetailsButtonListener());
        doneButton.addActionListener(new DoneButtonListener());

        newButton = new JButton("Create");
        newButton.addActionListener(new NewButtonListener());

        backButton = new JButton("Back");
        backButton.addActionListener(new BackButtonListener());

        buttonPanel.add(newButton);
        buttonPanel.add(detailsButton);
        buttonPanel.add(doneButton);
        buttonPanel.add(backButton);
        tableScroller = new JScrollPane(passTable);
        passTable.setFillsViewportHeight(true);
        tableScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tableScroller.setPreferredSize(new Dimension(350, 300));
        tablePanel.add(tableScroller);
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setContentPane(new JPanel(new BorderLayout()));
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        this.getContentPane().add(tablePanel, BorderLayout.CENTER);
    }

    private static class DoneButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private class NewButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {

            PasstableUI.this.passCntl.createPassDetailUI();
        }
    }

    private class DetailsButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            int selectedTableRow = passTable.getSelectedRow();
            int selectedModelRow = passTable.convertRowIndexToModel(selectedTableRow);
            PasstableUI.this.passCntl.getPassDetailUI(selectedModelRow);
        }
    }

    private class BackButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            PasstableUI.this.setVisible(false);
            passCntl.requestNavigationCntl();

        }
    }

}

package com.leojr.iodemo.ui.panel;


import com.leojr.iodemo.ui.frame.CountWordFrame;
import com.leojr.iodemo.ui.frame.ListFileFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContainerPanel extends AbsBasePanel{

    private static final String BTN_COUNT_WORD = "Count Word";
    private static final String BTN_CONTACTS_MANAGER = "Contacts Manager";
    private static final String BTN_LIST_FILE = "List File";
    private static final String BTN_SEARCH_FILE_IN_FOLDER = "Search File";
    private static final int BTN_WIDTH = 150;
    private static final int BTN_HEIGHT = 20;

    private JButton btnCountWord;
    private JButton btnContactsManager;
    private JButton btnListFile;
    private JButton btnSearchFileInFolder;

    public ContainerPanel(){
        initComps();
        addComps();
        setActionListener();
    }

    @Override
    protected void initComps() {
        FlowLayout layout = new FlowLayout();
        layout.setHgap(20);
        layout.setVgap(20);
        setLayout(layout);

        btnCountWord = new JButton(BTN_COUNT_WORD);
        btnCountWord.setPreferredSize(new Dimension(BTN_WIDTH,BTN_HEIGHT));

        btnContactsManager = new JButton(BTN_CONTACTS_MANAGER);
        btnContactsManager.setPreferredSize(new Dimension(BTN_WIDTH,BTN_HEIGHT));

        btnListFile = new JButton(BTN_LIST_FILE);
        btnListFile.setPreferredSize(new Dimension(BTN_WIDTH,BTN_HEIGHT));

        btnSearchFileInFolder = new JButton(BTN_SEARCH_FILE_IN_FOLDER);
        btnSearchFileInFolder.setPreferredSize(new Dimension(BTN_WIDTH,BTN_HEIGHT));

    }

    @Override
    protected void addComps(){
        add(btnCountWord);
        add(btnContactsManager);
        add(btnListFile);
        add(btnSearchFileInFolder);
    }

    @Override
    protected void setActionListener(){
        btnCountWord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        CountWordFrame countWordFrame = new CountWordFrame();
                        countWordFrame.setVisible(true);
                    }
                });
            }
        });

        btnListFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        ListFileFrame listFileFrame = new ListFileFrame();
                        listFileFrame.setVisible(true);
                    }
                });
            }
        });
    }
}

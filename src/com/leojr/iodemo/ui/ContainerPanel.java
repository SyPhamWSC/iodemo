package com.leojr.iodemo.ui;


import javax.swing.*;
import java.awt.*;

public class ContainerPanel extends JPanel{

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
    }

    private void initComps() {
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

    private void addComps(){
        add(btnCountWord);
        add(btnContactsManager);
        add(btnListFile);
        add(btnSearchFileInFolder);
    }
}

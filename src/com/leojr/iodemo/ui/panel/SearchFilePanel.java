package com.leojr.iodemo.ui.panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SearchFilePanel extends AbsBasePanel{

    private static final String TEXT_CONTENT = "Insert Directory";
    private static final String TEXT_INSERT_FILE_NAME= "Insert File Name";
    private static final String BTN_SEARCH = "Search File";

    private static final int HEIGHT_COMPONENT = 20;
    private static final int WIDTH_TEXT_FIELD = 300;
    private static final int WIDTH_BTN = 150;

    private JLabel labelInsertDirectory;
    private TextField tfInsertDirectory;
    private TextField tfInsertFileName;
    private JLabel labelInsertFileName;

    private JButton btnSearchFile;
    private JLabel labelResult;

    public SearchFilePanel(){
        initComps();
        addComps();
        setActionListener();
    }

    @Override
    protected void initComps() {
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setVgap(20);
        flowLayout.setHgap(10);
        setLayout(flowLayout);

        labelInsertDirectory = new JLabel();
        labelInsertDirectory.setPreferredSize(new Dimension(WIDTH_TEXT_FIELD,HEIGHT_COMPONENT));
        labelInsertDirectory.setText(TEXT_CONTENT);

        labelInsertFileName = new JLabel();
        labelInsertFileName.setPreferredSize(new Dimension(WIDTH_TEXT_FIELD,HEIGHT_COMPONENT));
        labelInsertFileName.setText(TEXT_INSERT_FILE_NAME);

        labelResult = new JLabel();
        labelResult.setPreferredSize(new Dimension(WIDTH_TEXT_FIELD,HEIGHT_COMPONENT*2));

        tfInsertDirectory = new TextField();
        tfInsertDirectory.setPreferredSize(new Dimension(WIDTH_TEXT_FIELD,HEIGHT_COMPONENT));

        tfInsertFileName = new TextField();
        tfInsertFileName.setPreferredSize(new Dimension(WIDTH_TEXT_FIELD,HEIGHT_COMPONENT));

        btnSearchFile = new JButton(BTN_SEARCH);
        btnSearchFile.setPreferredSize(new Dimension(WIDTH_BTN,HEIGHT_COMPONENT));

    }

    @Override
    protected void addComps() {
        add(labelInsertDirectory);
        add(tfInsertDirectory);
        add(labelInsertFileName);
        add(tfInsertFileName);
        add(btnSearchFile);
        add(labelResult);
    }

    @Override
    protected void setActionListener() {
        btnSearchFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelResult.setText("");
                File folder = new File(tfInsertDirectory.getText());
                searchFile(folder,tfInsertFileName.getText());
                if(labelResult.getText().equals("")){
                    labelResult.setText("File isn't in Folder");
                }
            }
        });
    }

    private void searchFile(File file,String fileName){
        File[] listOfFile = file.listFiles();
        for (int i = 0; i < listOfFile.length; i++) {
            if(listOfFile[i].isFile()){
                if(listOfFile[i].getName().equals(fileName)){
                   labelResult.setText("File is in Directory " + file.getPath());
                }
            }
        }
        for (int i = 0; i < listOfFile.length; i++) {
            if (!listOfFile[i].isFile()) {
                searchFile(listOfFile[i], fileName);
            }
        }
    }
}

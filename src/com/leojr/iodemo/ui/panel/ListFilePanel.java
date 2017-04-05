package com.leojr.iodemo.ui.panel;

import com.leojr.iodemo.common.CommonVls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ListFilePanel extends AbsBasePanel {

    private static final String TEXT_CONTENT = "Insert Directory";
    private static final String BTN_LIST_FILE = "List File";

    private JLabel taContent;
    private TextField tfInsertDirectory;
    private JButton btnListFile;

    public ListFilePanel(){
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

        taContent = new JLabel();
        taContent.setPreferredSize(new Dimension(300,20));
        taContent.setText(TEXT_CONTENT);

        tfInsertDirectory = new TextField();
        tfInsertDirectory.setPreferredSize(new Dimension(300,20));

        btnListFile = new JButton(BTN_LIST_FILE);
        btnListFile.setPreferredSize(new Dimension(150,20));
    }

    @Override
    protected void addComps() {
        add(taContent);
        add(tfInsertDirectory);
        add(btnListFile);
    }

    @Override
    protected void setActionListener() {
        btnListFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File folder = new File(tfInsertDirectory.getText());
                String list = "";
                list = listFile(folder,list);
                System.out.print(list);
                String[] temp = list.split("-");
                try {
                    OutputStream out = new FileOutputStream(tfInsertDirectory.getText() +"/listFile.txt");
                    try {
                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out,"UTF-8"));
                        try {
                            for (int i = 0; i < temp.length; i++) {
                                writer.write(temp[i]);
                                writer.newLine();
                            }
                            writer.close();
                            JOptionPane.showMessageDialog(null, "List file to listFile.txt in " + tfInsertDirectory.getText().toString(),null,JOptionPane.INFORMATION_MESSAGE);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    } catch (UnsupportedEncodingException e1) {
                        e1.printStackTrace();
                    }
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }


    //todo; List all file in folder and subfolder
    private String listFile(File file, String list){
        File[] listOfFile = file.listFiles();
        list = list + "Name of File in folder " + file.getName() + " :-";
        for (int i = 0; i < listOfFile.length; i++) {
            if(listOfFile[i].isFile()){
                list = list + listOfFile[i].getName() + "-";
            }
        }
        for (int i = 0; i < listOfFile.length; i++) {
            if (!listOfFile[i].isFile()){
                list = list + listFile(listOfFile[i],list);
            }
        }

        return list;
    }
}

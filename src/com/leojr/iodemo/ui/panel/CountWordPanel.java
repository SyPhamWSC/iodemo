package com.leojr.iodemo.ui.panel;

import com.leojr.iodemo.common.CommonVls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class CountWordPanel extends AbsBasePanel{

    private static final int TF_PATH_FILE_WIDTH = 250;
    private static final int BTN_WIDTH = 100;
    private static final int BTN_HEIGHT = 20;
    private static final String BTN_WIRTE_FILE = "Write File";
    private static final String BTN_CHOOSE_FILE = "Select file";

    private JTextField tfResourePath;
    private String filePath;
    private JFileChooser fileChooser;
    private JButton btnChooseFile;
    private JButton btnWirteFile;
    private File fileSelected;
    private String resultReadFile;


    public CountWordPanel(){
        initComps();
        addComps();
        setActionListener();

    }


    @Override
    protected void initComps() {
        setPreferredSize(new Dimension(CommonVls.COUNT_WORD_WIDTH,CommonVls.COUNT_WORD_HEIGHT));
        FlowLayout layout = new FlowLayout();
        layout.setHgap(10);
        layout.setVgap(20);
        setLayout(layout);

        tfResourePath = new JTextField();
        tfResourePath.setPreferredSize(new Dimension(TF_PATH_FILE_WIDTH,BTN_HEIGHT));

        fileChooser = new JFileChooser();

        btnChooseFile = new JButton(BTN_CHOOSE_FILE);
        btnChooseFile.setPreferredSize(new Dimension(BTN_WIDTH,BTN_HEIGHT));

        btnWirteFile = new JButton(BTN_WIRTE_FILE);

    }

    @Override
    protected void addComps() {
        add(tfResourePath);
        add(btnChooseFile);
        add(btnWirteFile);
    }

    @Override
    protected void setActionListener() {
        btnChooseFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = fileChooser.showOpenDialog(null);
                if(result == JFileChooser.APPROVE_OPTION){
                    fileSelected = fileChooser.getSelectedFile();
                    filePath = fileSelected.getPath();
                    tfResourePath.setText(filePath);
                }
            }
        });

        btnWirteFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    resultReadFile = CommonVls.getInstance().readFile(fileSelected);
                    resultReadFile = resultReadFile.replaceAll(",","");
                    resultReadFile = resultReadFile.replaceAll(":","");
                    resultReadFile = resultReadFile.replaceAll("\\.","");
                    resultReadFile = resultReadFile.replaceAll("\\?","");
                    resultReadFile = resultReadFile.replaceAll("-","");
                    resultReadFile = resultReadFile.replaceAll(";","");
                    resultReadFile = resultReadFile.replaceAll("!","");
                    resultReadFile.trim();

                    String [] arr = resultReadFile.split("\\s+");
                    Map<String,Integer> map = new TreeMap<String,Integer>();
                    for(String key : arr){
                        key = key.toLowerCase();
                        if(map.containsKey(key)){
                            map.put(key,map.get(key)+1);
                        }else if(key.equals("")||key.equals(" ")){

                        }else {
                            map.put(key,1);
                        }
                    }

                    //todo: Wirte word with the number of occurrence in the file, sorted by word
                    OutputStream out1 = new FileOutputStream(fileSelected.getParent()+"/result_One.txt");
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out1,"UTF-8"));
                    for(Map.Entry<String,Integer> entry: map.entrySet()){
                        writer.write(entry.getKey() + ": " + entry.getValue().toString());
                        writer.newLine();
                        System.out.println( entry.getKey()+ ": " +entry.getValue());
                    }

                    //todo: Wirte word with the number of occurrence in the file, sorted by number of occurrence
                    OutputStream out2 = new FileOutputStream(fileSelected.getParent()+"/result_Two.txt");
                    writer = new BufferedWriter(new OutputStreamWriter(out2,"UTF-8"));
                    Iterator iterator = entriesSortedByValues(map).iterator();
                    while (iterator.hasNext()) {
                        // Get element
                        Object element = iterator.next();
                        writer.write(element.toString());
                        writer.newLine();
                    }
                    writer.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }


            }
        });
    }

    //todo: Sorted Map<K,V> by values
    SortedSet<Map.Entry<String,Integer>> entriesSortedByValues(Map<String,Integer> map) {
        SortedSet<Map.Entry<String,Integer>> sortedEntries = new TreeSet<Map.Entry<String,Integer>>(
                new Comparator<Map.Entry<String,Integer>>() {

                    @Override public int compare(Map.Entry<String,Integer> e1, Map.Entry<String,Integer> e2) {
                        int res = e1.getValue().compareTo(e2.getValue());
                        return res != 0 ? res : 1;
                    }
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }

}

package com.leojr.iodemo.ui.frame;

import com.leojr.iodemo.common.CommonVls;
import com.leojr.iodemo.ui.panel.ListFilePanel;
import com.leojr.iodemo.ui.panel.SearchFilePanel;

import javax.swing.*;
import java.awt.*;

public class SearchFileFrame extends JFrame{

    private static final String SEARCH_FILE_IN_FOLDER = "Search file in folder";

    public SearchFileFrame(){
        setTitle(SEARCH_FILE_IN_FOLDER);
        setPreferredSize(new Dimension(CommonVls.SEARCH_FILE_WIDTH, CommonVls.SEARCH_FILE_HEIGHT));
        setResizable(false);
        setLocationRelativeTo(null);

        add(new SearchFilePanel());
        pack();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}

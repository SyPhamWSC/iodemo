package com.leojr.iodemo.ui.frame;


import com.leojr.iodemo.common.CommonVls;
import com.leojr.iodemo.ui.panel.ListFilePanel;

import javax.swing.*;
import java.awt.*;

public class ListFileFrame extends JFrame{

    private static final String LIST_WORD_FRAME_NAME = "List file in folder";

    public ListFileFrame(){
        setTitle(LIST_WORD_FRAME_NAME);
        setPreferredSize(new Dimension(CommonVls.LIST_FILE_WIDTH, CommonVls.LIST_FLIE_HEIGHT));
        setResizable(false);
        setLocationRelativeTo(null);

        add(new ListFilePanel());
        pack();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}

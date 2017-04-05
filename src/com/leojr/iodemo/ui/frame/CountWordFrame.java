package com.leojr.iodemo.ui.frame;

import com.leojr.iodemo.common.CommonVls;
import com.leojr.iodemo.ui.panel.CountWordPanel;

import javax.swing.*;
import java.awt.*;

public class CountWordFrame extends JFrame{
    private static final String COUNT_WORD_FRAME_NAME = "Count Word";


    public CountWordFrame(){
        setTitle(COUNT_WORD_FRAME_NAME);
        setPreferredSize(new Dimension(CommonVls.COUNT_WORD_WIDTH,CommonVls.COUNT_WORD_HEIGHT));
        setResizable(false);
        setLocationRelativeTo(null);

        add(new CountWordPanel());
        pack();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}

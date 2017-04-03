package com.leojr.iodemo.ui;

import com.leojr.iodemo.common.CommonVls;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame{
    public GUI(String nameApp){
        setTitle(nameApp);
        setPreferredSize(new Dimension(CommonVls.WIDTH_GUI, CommonVls.HEIGHT_GUI));
        setResizable(false);
        setLocationRelativeTo(null);

        ContainerPanel containerPanel = new ContainerPanel();
        add(containerPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

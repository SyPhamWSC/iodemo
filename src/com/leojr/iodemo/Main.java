package com.leojr.iodemo;

import com.leojr.iodemo.common.CommonVls;
import com.leojr.iodemo.ui.GUI;

import javax.swing.*;

public class Main {
    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI gui = new GUI(CommonVls.APP_NAME);
                gui.setVisible(true);
            }
        });

    }
}

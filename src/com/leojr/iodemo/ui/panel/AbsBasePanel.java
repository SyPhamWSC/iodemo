package com.leojr.iodemo.ui.panel;

import javax.swing.*;

public abstract class AbsBasePanel extends JPanel {
    protected abstract void initComps();
    protected abstract void addComps();
    protected abstract void setActionListener();
}

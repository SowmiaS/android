
package com.ss.drawermenu.models;

import java.util.ArrayList;
import java.util.List;

public class DrawerMenuModel {

    private List<Drawerheader> drawerheader = new ArrayList<Drawerheader>();

    /**
     * 
     * @return
     *     The drawerheader
     */
    public List<Drawerheader> getDrawerheader() {
        return drawerheader;
    }

    /**
     * 
     * @param drawerheader
     *     The drawerheader
     */
    public void setDrawerheader(List<Drawerheader> drawerheader) {
        this.drawerheader = drawerheader;
    }

}

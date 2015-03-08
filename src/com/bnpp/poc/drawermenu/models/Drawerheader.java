
package com.bnpp.poc.drawermenu.models;

import java.util.ArrayList;
import java.util.List;

public class Drawerheader {

    private String headertitle;
    private List<Drawerchild> drawerchild = new ArrayList<Drawerchild>();

    /**
     * 
     * @return
     *     The headertitle
     */
    public String getHeadertitle() {
        return headertitle;
    }

    /**
     * 
     * @param headertitle
     *     The headertitle
     */
    public void setHeadertitle(String headertitle) {
        this.headertitle = headertitle;
    }

    /**
     * 
     * @return
     *     The drawerchild
     */
    public List<Drawerchild> getDrawerchild() {
        return drawerchild;
    }

    /**
     * 
     * @param drawerchild
     *     The drawerchild
     */
    public void setDrawerchild(List<Drawerchild> drawerchild) {
        this.drawerchild = drawerchild;
    }

}

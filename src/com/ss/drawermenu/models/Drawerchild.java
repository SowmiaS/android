
package com.ss.drawermenu.models;

import com.google.gson.annotations.Expose;

public class Drawerchild {

    @Expose
    private String childtitle;
    @Expose
    private String fragmentname;
    @Expose
    private String url;

    /**
     * 
     * @return
     *     The childtitle
     */
    public String getChildtitle() {
        return childtitle;
    }

    /**
     * 
     * @param childtitle
     *     The childtitle
     */
    public void setChildtitle(String childtitle) {
        this.childtitle = childtitle;
    }

    /**
     * 
     * @return
     *     The fragmentname
     */
    public String getFragmentname() {
        return fragmentname;
    }

    /**
     * 
     * @param fragmentname
     *     The fragmentname
     */
    public void setFragmentname(String fragmentname) {
        this.fragmentname = fragmentname;
    }

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

}

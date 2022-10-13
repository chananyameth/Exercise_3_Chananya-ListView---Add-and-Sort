package com.amitaymolko.examplelistview;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by amitaymolko on 12/20/15.
 */
public class MyItem implements Comparable<MyItem>, Serializable{
    private int iconId;
    private String text;

    public MyItem(int iconId, String text) {
        this.iconId = iconId;
        this.text = text;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int compareTo(MyItem another) {
        return this.text.compareTo(another.getText());
    }
}

package com.igding.basedialog.beandialog;

import android.view.Gravity;


/**
 * <pre>
 *     author : handler
 *     e-mail : dingchao314@gmail.com
 *     time   : 2018/08/20
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class BaseDialogBean {

    /**
     * 竖屏宽度
     */
    float portrait_W = (float) 0.9;
    /**
     * 竖屏高度
     */
    float portrait_H = (float) 0.2;

    /**
     * 竖屏宽度
     */
    float landscape_W = (float) 0.9;

    /**
     * 横屏高度
     */
    float landscape_H = (float) 0.5;

    /**
     * 从某个方向弹出
     */
    int gravity = Gravity.CENTER;
    /**
     * tag
     */
    String tag = "base";

    public int getGravity() {
        return gravity;
    }

    public BaseDialogBean setGravity(int gravity) {
        if (gravity == 0) {
            return this;
        }
        this.gravity = gravity;
        return this;
    }

    public float getPortrait_W() {
        return portrait_W;
    }

    public BaseDialogBean setPortrait_W(float portrait_W) {
        if (portrait_W == 0) {
            return this;
        }
        this.portrait_W = portrait_W;
        return this;
    }

    public float getPortrait_H() {
        return portrait_H;
    }

    public BaseDialogBean setPortrait_H(float portrait_H) {
        if (portrait_H == 0) {
            return this;
        }
        this.portrait_H = portrait_H;
        return this;
    }

    public BaseDialogBean setTag(String tag) {
        if (null == tag || "".equals(tag)) {
            return this;
        }
        this.tag = tag;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public float getLandscape_W() {
        return landscape_W;
    }

    public BaseDialogBean setLandscape_W(float landscape_W) {
        if (landscape_W == 0) {
            return this;
        }
        this.landscape_W = landscape_W;
        return this;
    }

    public float getLandscape_H() {
        return landscape_H;
    }

    public BaseDialogBean setLandscape_H(float landscape_H) {
        if (landscape_H == 0) {
            return this;
        }
        this.landscape_H = landscape_H;
        return this;
    }
}

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
     * 宽
     */
    float w = (float) 0.9;
    /**
     * 高
     */
    float h = (float) 0.2;
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

    public float getW() {
        return w;
    }

    public BaseDialogBean setW(float w) {
        if (w == 0) {
            return this;
        }
        this.w = w;
        return this;
    }

    public float getH() {
        return h;
    }

    public BaseDialogBean setH(float h) {
        if (h == 0) {
            return this;
        }
        this.h = h;
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
}

package com.igding.basedialog.basedialog;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.igding.basedialog.beandialog.BaseDialogBean;

/**
 * <pre>
 *     author : handler
 *     e-mail : dingchao314@gmail.com
 *     time   : 2018/08/20
 *              基础dialog
 *     version: 1.0
 * </pre>
 */
public abstract class BaseDialog extends DialogFragment implements DialogInterface.OnKeyListener {

    private static final String TAG = BaseDialog.class.getSimpleName();

    private String tag;

    /**
     * 如果dialog设置外部不可点击的话，按返回键是无法返回的
     */
    private boolean isBack = true;

    public static final BaseDialog newInstance(Class aClass, BaseDialogBean baseDialogBean) {
        BaseDialog dialogFragment = null;
        Bundle args = new Bundle();

        if (baseDialogBean == null) {
            new Throwable("bean为空").printStackTrace();
        }

        String tag = baseDialogBean.getTag();
        Log.i(TAG, "baseDialog中tag的值: " + tag);
//        if (tag == "base") {
//            new Throwable("tag不能为空").printStackTrace();
//        }
        args.putParcelable(tag, (Parcelable) baseDialogBean);
        try {
            dialogFragment = (BaseDialog) aClass.newInstance();
            dialogFragment.tag = tag;
            dialogFragment.setArguments(args);

        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return dialogFragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        getDialog().setOnKeyListener(this);
        initStyle();
    }

    /**
     * 初始化dialog的基础样式
     */
    private void initStyle() {
        if (getArguments() == null) {
            return;
        }

        BaseDialogBean baseDialogBean = getArguments().getParcelable(getTag());

        if (baseDialogBean == null) {
            return;
        }

        float h = baseDialogBean.getH();
        float w = baseDialogBean.getW();
        int gravity = baseDialogBean.getGravity();
        Window window = getDialog().getWindow();
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        DisplayMetrics dm = new DisplayMetrics();
        if (getActivity() == null) {
            return;
        }
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        attributes.width = (int) (dm.widthPixels * w);
        attributes.height = (int) (dm.heightPixels * h);
        attributes.gravity = gravity;
        window.setAttributes(attributes);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        //在4.0的华为里面，会有标题栏，8.0的华为没有
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View inflate = inflater.inflate(getLayoutId(), container, false);
        Bundle arguments = getArguments();
        Parcelable parcelable = arguments.getParcelable(getTag());
        initView(inflate, parcelable);
        return inflate;
    }

    public BaseDialog setIsBack(boolean isBack) {
        this.isBack = isBack;
        return this;
    }

    @Override
    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && isBack) {
            getDialog().dismiss();
            return true;
        }
        return false;
    }

    /**
     * 初始化操作
     *
     * @param inflate    填充的布局
     * @param parcelable 存储的对象
     */
    protected abstract void initView(View inflate, Parcelable parcelable);

    /**
     * @return 代表需要填充进去的布局
     */
    public abstract int getLayoutId();

    public void show(FragmentManager manager) {
        super.show(manager, tag);
    }

}

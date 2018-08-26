package com.chebei.getsms;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.igding.basedialog.basedialog.BaseDialog;

import dialog.DialogConstant;
import dialog.LoginDialog;
import dialog.PositionDialog;
import dialog.ShareDialog;
import dialogbean.LoginDialogBean;
import dialogbean.PositionDialogBean;
import dialogbean.ShareDialogBean;

/**
 * <pre>
 *     author : handler
 *     e-mail : dingchao314@gmail.com
 *     time   : 2018/08/15
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener, LoginDialog.LoginDialogImpl, PositionDialog.PositionInter, ShareDialog.ShareDialogImpl {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mBtnDialog = findViewById(R.id.btn_basedialog);
        Button mBtnLogin = findViewById(R.id.btn_login);
        Button mBtnUpdate = findViewById(R.id.btn_share);
        mBtnDialog.setOnClickListener(this);
        mBtnLogin.setOnClickListener(this);
        mBtnUpdate.setOnClickListener(this);
    }

    /**
     * baseDialog的确定
     *
     * @param positionDialogBean
     */
    @Override
    public void positiveOnclick(PositionDialogBean positionDialogBean) {
        Toast.makeText(this, "确定", 1).show();
    }

    /**
     * baseDialog的返回
     *
     * @param positionDialogBean
     */
    @Override
    public void negativeOnclick(PositionDialogBean positionDialogBean) {
        Toast.makeText(this, "取消", 1).show();
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_basedialog:
                PositionDialogBean positionDialogBean = new PositionDialogBean.Builder()
                        .position("北京")
                        .positiveButton("是").negativeButton("否")
                        .tag(DialogConstant.POSITION)
                        .build();

                ((PositionDialog) PositionDialog.newInstance(PositionDialog.class, positionDialogBean))
                        .setPositionInter(this)
                        .show(getFragmentManager());
                break;
            case R.id.btn_login:
                LoginDialogBean loginDialogBean = new LoginDialogBean.Builder()
                        .sure("确定")
                        .cancel("取消")
                        .w((float) 0.9)
                        .h((float) 0.3)
                        .tag(DialogConstant.LOGIN)
                        .build();

                LoginDialog loginDialog = (LoginDialog) LoginDialog.newInstance(LoginDialog.class, loginDialogBean);
                loginDialog.setLoginDialogImpl(this);
                loginDialog.show(getFragmentManager());
                break;

            case R.id.btn_share:
                ShareDialogBean shareDialogBean = new ShareDialogBean.Builder()
                        .h((float) 0.2)
                        .w(1)
                        .tag(DialogConstant.Share)
                        .gravity(Gravity.BOTTOM)
                        .build();

                BaseDialog shareDialog = ShareDialog.newInstance(ShareDialog.class, shareDialogBean)
                        .setIsBack(true);
                shareDialog.setStyle(DialogFragment.STYLE_NORMAL, R.style.bottom_dialog);
                shareDialog.setCancelable(false);
                ((ShareDialog) shareDialog).setShareDialogImpl(this);
                shareDialog.show(getFragmentManager());
                break;
        }
    }

    @Override
    public void sure(String account, String passWord) {
        Toast.makeText(this, account + passWord, 1).show();
    }

    @Override
    public void cance() {
        Toast.makeText(this, "取消", 1).show();
    }

    @Override
    public void shareQQ() {
        Toast.makeText(this, "跳转QQ", 1).show();
    }

    @Override
    public void shareWechat() {
        Toast.makeText(this, "跳转微信", 1).show();
    }
}

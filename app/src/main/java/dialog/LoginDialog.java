package dialog;

import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ding.basedialog.R;
import com.igding.basedialog.basedialog.BaseDialog;

import dialogbean.LoginDialogBean;

/**
 * <pre>
 *     author : handler
 *     e-mail : dingchao314@gmail.com
 *     time   : 2018/08/26
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class LoginDialog extends BaseDialog {
    /**
     * 初始化操作
     *
     * @param inflate    填充的布局
     * @param parcelable 存储的对象
     */
    @Override
    protected void initView(View inflate, Parcelable parcelable) {
        LoginDialogBean loginDialogBean = (LoginDialogBean) parcelable;
        Button mBtnSure = inflate.findViewById(R.id.btn_sure);
        Button mBtnCancel = inflate.findViewById(R.id.btn_cancel);

        mBtnSure.setText(loginDialogBean.getSure());
        mBtnCancel.setText(loginDialogBean.getCancel());

        EditText mEtAccount = inflate.findViewById(R.id.et_account);
        EditText mEtPassWord = inflate.findViewById(R.id.et_password);

        final String account = mEtAccount.getText().toString();
        final String passWord = mEtPassWord.getText().toString();

        mBtnSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginDialogImpl.sure(account, passWord);
                //也有可能有正则判断什么的，根据自己业务调整即可，
                if (ViewTool.isEmpty(account)) {
                    return;
                }

                if (ViewTool.isEmpty(passWord)) {
                    return;
                }
                getDialog().dismiss();
            }
        });

        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
                mLoginDialogImpl.cance();
            }
        });
    }

    /**
     * @return 代表需要填充进去的布局
     */
    @Override
    public int getLayoutId() {
        return R.layout.dialog_login;
    }

    LoginDialogImpl mLoginDialogImpl;

    public void setLoginDialogImpl(LoginDialogImpl mLoginDialogImpl) {
        this.mLoginDialogImpl = mLoginDialogImpl;
    }

    public interface LoginDialogImpl {
        void sure(String account, String passWord);

        void cance();
    }
}

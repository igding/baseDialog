package dialog;

import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

import com.chebei.getsms.R;
import com.igding.basedialog.basedialog.BaseDialog;

/**
 * <pre>
 *     author : handler
 *     e-mail : dingchao314@gmail.com
 *     time   : 2018/08/26
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class ShareDialog extends BaseDialog {

    /**
     * 初始化操作
     *
     * @param inflate    填充的布局
     * @param parcelable 存储的对象
     */
    @Override
    protected void initView(View inflate, Parcelable parcelable) {
        TextView mTvQQ = inflate.findViewById(R.id.tv_qq);
        TextView mTvWechat = inflate.findViewById(R.id.tv_wechat);
        mTvQQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareDialogImpl.shareQQ();
                getDialog().dismiss();
            }
        });

        mTvWechat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareDialogImpl.shareWechat();
                getDialog().dismiss();
            }
        });
    }

    ShareDialogImpl shareDialogImpl;

    public void setShareDialogImpl(ShareDialogImpl shareDialogImpl) {
        this.shareDialogImpl = shareDialogImpl;
    }

    public interface ShareDialogImpl {

        void shareQQ();

        void shareWechat();
    }

    /**
     * @return 代表需要填充进去的布局
     */
    @Override
    public int getLayoutId() {
        return R.layout.dialog_share;
    }
}

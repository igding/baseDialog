package dialog;

import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

import com.chebei.getsms.R;
import com.igding.basedialog.basedialog.BaseDialog;

import dialogbean.PositionDialogBean;


/**
 * <pre>
 *     author : handler
 *     e-mail : dingchao314@gmail.com
 *     time   : 2018/08/22
 *     desc   : 选择当前城市的弹窗
 *     version: 1.0
 * </pre>
 */
public class PositionDialog extends BaseDialog {
    /**
     * 初始化操作
     *
     * @param inflate    填充的布局
     * @param parcelable 存储的对象
     */
    @Override
    protected void initView(View inflate, final Parcelable parcelable) {
        TextView mTvTitle = inflate.findViewById(R.id.tv_title);
        TextView mTvOk = inflate.findViewById(R.id.tv_ok);
        TextView mTvCancel = inflate.findViewById(R.id.tv_cancel);
        ((PositionDialogBean) parcelable).getId();
        mTvTitle.setText(((PositionDialogBean) parcelable).getChangePosition());
        mTvOk.setText(((PositionDialogBean) parcelable).getPositiveButton());
        mTvCancel.setText(((PositionDialogBean) parcelable).getNegativeButton());

        mTvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                positionInter.positiveOnclick((PositionDialogBean) parcelable);
                getDialog().dismiss();
            }
        });
        mTvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                positionInter.negativeOnclick((PositionDialogBean) parcelable);
                getDialog().dismiss();
            }
        });
    }

    /**
     * @return 代表需要填充进去的布局
     */
    @Override
    public int getLayoutId() {
        return R.layout.dialog_position;
    }

    private PositionInter positionInter;

    public PositionDialog setPositionInter(PositionInter positionInter) {
        this.positionInter = positionInter;
        return this;
    }

    /**
     * 定义接口，传你想要的数据
     */
    public interface PositionInter {
        void positiveOnclick(PositionDialogBean positionDialogBean);

        void negativeOnclick(PositionDialogBean positionDialogBean);
    }
}

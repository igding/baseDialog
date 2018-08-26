package dialogbean;

import android.os.Parcel;
import android.os.Parcelable;

import com.igding.basedialog.beandialog.BaseDialogBean;


/**
 * <pre>
 *     author : handler
 *     e-mail : dingchao314@gmail.com
 *     time   : 2018/08/26
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class ShareDialogBean extends BaseDialogBean implements Parcelable {

    String type;

    private ShareDialogBean(Builder builder) {
        setW(builder.w);
        type = builder.type;
        setH(builder.h);
        setGravity(builder.gravity);
        setTag(builder.tag);
    }

    public String getType() {
        return type;
    }


    protected ShareDialogBean(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ShareDialogBean> CREATOR = new Creator<ShareDialogBean>() {
        @Override
        public ShareDialogBean createFromParcel(Parcel in) {
            return new ShareDialogBean(in);
        }

        @Override
        public ShareDialogBean[] newArray(int size) {
            return new ShareDialogBean[size];
        }
    };

    public static final class Builder {
        private float w;
        private String type;
        private float h;
        private int gravity;
        private String tag;

        public Builder() {
        }

        public Builder w(float val) {
            w = val;
            return this;
        }

        public Builder type(String val) {
            type = val;
            return this;
        }

        public Builder h(float val) {
            h = val;
            return this;
        }

        public Builder gravity(int val) {
            gravity = val;
            return this;
        }

        public Builder tag(String val) {
            tag = val;
            return this;
        }

        public ShareDialogBean build() {
            return new ShareDialogBean(this);
        }
    }
}

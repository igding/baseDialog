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

    protected ShareDialogBean(Parcel in) {
        type = in.readString();
    }

    private ShareDialogBean(Builder builder) {
        setPortrait_W(builder.portrait_W);
        setPortrait_H(builder.portrait_H);
        type = builder.type;
        setLandscape_W(builder.landscape_W);
        setLandscape_H(builder.landscape_H);
        setGravity(builder.gravity);
        setTag(builder.tag);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
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
        private float portrait_W;
        private float portrait_H;
        private String type;
        private float landscape_W;
        private float landscape_H;
        private int gravity;
        private String tag;

        public Builder() {
        }

        public Builder portrait_W(float val) {
            portrait_W = val;
            return this;
        }

        public Builder portrait_H(float val) {
            portrait_H = val;
            return this;
        }

        public Builder type(String val) {
            type = val;
            return this;
        }

        public Builder landscape_W(float val) {
            landscape_W = val;
            return this;
        }

        public Builder landscape_H(float val) {
            landscape_H = val;
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

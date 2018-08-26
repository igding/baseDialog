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
public class LoginDialogBean extends BaseDialogBean implements Parcelable {
    String sure;
    String cancel;

    protected LoginDialogBean(Parcel in) {
        sure = in.readString();
        cancel = in.readString();
    }

    public static final Creator<LoginDialogBean> CREATOR = new Creator<LoginDialogBean>() {
        @Override
        public LoginDialogBean createFromParcel(Parcel in) {
            return new LoginDialogBean(in);
        }

        @Override
        public LoginDialogBean[] newArray(int size) {
            return new LoginDialogBean[size];
        }
    };

    public String getSure() {
        return sure;
    }

    public String getCancel() {
        return cancel;
    }

    private LoginDialogBean(Builder builder) {
        sure = builder.sure;
        cancel = builder.cancel;
        setW(builder.w);
        setH(builder.h);
        setGravity(builder.gravity);
        setTag(builder.tag);
    }

    /**
     * Describe the kinds of special objects contained in this Parcelable
     * instance's marshaled representation. For example, if the object will
     * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
     * the return value of this method must include the
     * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
     *
     * @return a bitmask indicating the set of special object types marshaled
     * by this Parcelable object instance.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sure);
        dest.writeString(cancel);
    }

    public static final class Builder {
        private String sure;
        private String cancel;
        private float w;
        private float h;
        private int gravity;
        private String tag;

        public Builder() {
        }

        public Builder sure(String val) {
            sure = val;
            return this;
        }

        public Builder cancel(String val) {
            cancel = val;
            return this;
        }

        public Builder w(float val) {
            w = val;
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

        public LoginDialogBean build() {
            return new LoginDialogBean(this);
        }
    }
}

package dialogbean;

import android.os.Parcel;
import android.os.Parcelable;

import com.igding.basedialog.beandialog.BaseDialogBean;

/**
 * <pre>
 *     author : handler
 *     e-mail : dingchao314@gmail.com
 *     time   : 2018/08/22
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class PositionDialogBean extends BaseDialogBean implements Parcelable {

    String position;
    int id;
    String positiveButton;
    String negativeButton;

    private PositionDialogBean(Builder builder) {
        position = builder.position;
        setW(builder.w);
        id = builder.id;
        setH(builder.h);
        positiveButton = builder.positiveButton;
        setGravity(builder.gravity);
        negativeButton = builder.negativeButton;
        setTag(builder.tag);
    }

    protected PositionDialogBean(Parcel in) {
        position = in.readString();
        id = in.readInt();
        positiveButton = in.readString();
        negativeButton = in.readString();
    }

    public static final Creator<PositionDialogBean> CREATOR = new Creator<PositionDialogBean>() {
        @Override
        public PositionDialogBean createFromParcel(Parcel in) {
            return new PositionDialogBean(in);
        }

        @Override
        public PositionDialogBean[] newArray(int size) {
            return new PositionDialogBean[size];
        }
    };

    public String getPosition() {
        return position;
    }

    public String getChangePosition() {
        return getPosition() + "是你当前的城市吗?";
    }

    public int getId() {
        return id;
    }

    public String getPositiveButton() {
        return positiveButton;
    }

    public String getNegativeButton() {
        return negativeButton;
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
        dest.writeString(position);
        dest.writeInt(id);
        dest.writeString(positiveButton);
        dest.writeString(negativeButton);
    }

    public static final class Builder {
        private String position;
        private float w;
        private int id;
        private float h;
        private String positiveButton;
        private int gravity;
        private String negativeButton;
        private String tag;

        public Builder() {
        }

        public Builder position(String val) {
            position = val;
            return this;
        }

        public Builder w(float val) {
            w = val;
            return this;
        }

        public Builder id(int val) {
            id = val;
            return this;
        }

        public Builder h(float val) {
            h = val;
            return this;
        }

        public Builder positiveButton(String val) {
            positiveButton = val;
            return this;
        }

        public Builder gravity(int val) {
            gravity = val;
            return this;
        }

        public Builder negativeButton(String val) {
            negativeButton = val;
            return this;
        }

        public Builder tag(String val) {
            tag = val;
            return this;
        }

        public PositionDialogBean build() {
            return new PositionDialogBean(this);
        }
    }
}

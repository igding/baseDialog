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

    protected PositionDialogBean(Parcel in) {
        position = in.readString();
        id = in.readInt();
        positiveButton = in.readString();
        negativeButton = in.readString();
    }

    private PositionDialogBean(Builder builder) {
        setPortrait_W(builder.portrait_W);
        setPortrait_H(builder.portrait_H);
        position = builder.position;
        id = builder.id;
        positiveButton = builder.positiveButton;
        setLandscape_W(builder.landscape_W);
        negativeButton = builder.negativeButton;
        setLandscape_H(builder.landscape_H);
        setGravity(builder.gravity);
        setTag(builder.tag);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(position);
        dest.writeInt(id);
        dest.writeString(positiveButton);
        dest.writeString(negativeButton);
    }

    public String getChangePosition() {
        return getPosition() + "是你现在的城市吗?";
    }

    @Override
    public int describeContents() {
        return 0;
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

    public static final class Builder {
        private float portrait_W;
        private float portrait_H;
        private String position;
        private int id;
        private String positiveButton;
        private float landscape_W;
        private String negativeButton;
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

        public Builder position(String val) {
            position = val;
            return this;
        }

        public Builder id(int val) {
            id = val;
            return this;
        }

        public Builder positiveButton(String val) {
            positiveButton = val;
            return this;
        }

        public Builder landscape_W(float val) {
            landscape_W = val;
            return this;
        }

        public Builder negativeButton(String val) {
            negativeButton = val;
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

        public PositionDialogBean build() {
            return new PositionDialogBean(this);
        }
    }

    public String getPosition() {
        return position;
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
}

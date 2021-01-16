package com.apakhun.arabicverbstestssecond.model.verbs;

import android.os.Parcel;

import com.apakhun.arabicverbstestssecond.App;
import com.apakhun.arabicverbstestssecond.R;
import com.apakhun.arabicverbstestssecond.model.Verb;

public class Touch extends Verb {

    public Touch() {
    }

    public Touch(Parcel parcel) {
        super(parcel);
    }

    @Override
    protected String[] getStringArray() {
        return App.getRes().getStringArray(R.array.touch);
    }

    @Override
    public int pictureResourceId() {
        return R.mipmap.touch;
    }

    @Override
    public String getDescription() {
        return getDescription(R.string.description_touch);
    }

    @Override
    public String soundDirName() {
        return "touch";
    }

    @Override
    public int getGroup(){
        return 1;
    }
}

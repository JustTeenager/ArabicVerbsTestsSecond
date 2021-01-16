package com.apakhun.arabicverbstestssecond.model.verbs;

import android.os.Parcel;

import com.apakhun.arabicverbstestssecond.App;
import com.apakhun.arabicverbstestssecond.R;
import com.apakhun.arabicverbstestssecond.model.Verb;

public class Surround extends Verb {

    public Surround() {
    }

    public Surround(Parcel parcel) {
        super(parcel);
    }

    @Override
    protected String[] getStringArray() {
        return App.getRes().getStringArray(R.array.surround);
    }

    @Override
    public int pictureResourceId() {
        return R.mipmap.surround;
    }

    @Override
    public String getDescription() {
        return getDescription(R.string.description_surround);
    }

    @Override
    public String soundDirName() {
        return "surround";
    }

    @Override
    public int getGroup() {
        return 2;
    }
}

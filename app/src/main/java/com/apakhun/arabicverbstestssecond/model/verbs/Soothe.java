package com.apakhun.arabicverbstestssecond.model.verbs;

import android.os.Parcel;

import com.apakhun.arabicverbstestssecond.App;
import com.apakhun.arabicverbstestssecond.R;
import com.apakhun.arabicverbstestssecond.model.Verb;

public class Soothe extends Verb {

    public Soothe() {
    }

    public Soothe(Parcel parcel) {
        super(parcel);
    }

    @Override
    protected String[] getStringArray() {
        return App.getRes().getStringArray(R.array.soothe);
    }

    @Override
    public int pictureResourceId() {
        return R.mipmap.soothe;
    }

    @Override
    public String getDescription() {
        return getDescription(R.string.description_soothe);
    }

    @Override
    public String soundDirName() {
        return "soothe";
    }

    @Override
    public int getGroup() {
        return 4;
    }
}

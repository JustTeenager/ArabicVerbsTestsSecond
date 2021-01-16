package com.apakhun.arabicverbstestssecond.model.verbs;

import android.os.Parcel;

import com.apakhun.arabicverbstestssecond.App;
import com.apakhun.arabicverbstestssecond.R;
import com.apakhun.arabicverbstestssecond.model.Verb;

public class Pity extends Verb {

    public Pity() {
    }

    public Pity(Parcel parcel) {
        super(parcel);
    }

    @Override
    protected String[] getStringArray() {
        return App.getRes().getStringArray(R.array.pity);
    }

    @Override
    public int pictureResourceId() {
        return R.mipmap.pity;
    }

    @Override
    public String getDescription() {
        return getDescription(R.string.description_pity);
    }

    @Override
    public String soundDirName() {
        return "pity";
    }

    @Override
    public int getGroup() {
        return 3;
    }
}

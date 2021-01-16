package com.apakhun.arabicverbstestssecond.model.verbs;

import android.os.Parcel;

import com.apakhun.arabicverbstestssecond.App;
import com.apakhun.arabicverbstestssecond.R;
import com.apakhun.arabicverbstestssecond.model.Verb;

public class Supply extends Verb {

    public Supply() {
    }

    public Supply(Parcel parcel) {
        super(parcel);
    }

    @Override
    protected String[] getStringArray() {
        return App.getRes().getStringArray(R.array.supply);
    }

    @Override
    public int pictureResourceId() {
        return R.mipmap.supply;
    }

    @Override
    public String getDescription() {
        return getDescription(R.string.description_supply);
    }

    @Override
    public String soundDirName() {
        return "supply";
    }

    @Override
    public int getGroup() {
        return 3;
    }
}

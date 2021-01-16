package com.apakhun.arabicverbstestssecond.model.verbs;

import android.os.Parcel;

import com.apakhun.arabicverbstestssecond.App;
import com.apakhun.arabicverbstestssecond.R;
import com.apakhun.arabicverbstestssecond.model.Verb;

public class Despise extends Verb {

    public Despise() {
    }

    public Despise(Parcel parcel) {
        super(parcel);
    }

    @Override
    protected String[] getStringArray() {
        return App.getRes().getStringArray(R.array.despise);
    }

    @Override
    public int pictureResourceId() {
        return R.mipmap.despise;
    }

    @Override
    public String getDescription() {
        return getDescription(R.string.description_despise);
    }

    @Override
    public String soundDirName() {
        return "despise";
    }

    @Override
    public int getGroup() {
        return 2;
    }
}

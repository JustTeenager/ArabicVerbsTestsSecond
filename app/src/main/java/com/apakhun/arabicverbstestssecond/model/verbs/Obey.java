package com.apakhun.arabicverbstestssecond.model.verbs;

import android.os.Parcel;

import com.apakhun.arabicverbstestssecond.App;
import com.apakhun.arabicverbstestssecond.R;
import com.apakhun.arabicverbstestssecond.model.Verb;

public class Obey extends Verb {

    public Obey() {
    }

    public Obey(Parcel parcel) {
        super(parcel);
    }

    @Override
    protected String[] getStringArray() {
        return App.getRes().getStringArray(R.array.obey);
    }

    @Override
    public int pictureResourceId() {
        return R.mipmap.obey;
    }

    @Override
    public String getDescription() {
        return getDescription(R.string.description_obey);
    }

    @Override
    public String soundDirName() {
        return "obey";
    }

    @Override
    public int getGroup() {
        return 4;
    }
}

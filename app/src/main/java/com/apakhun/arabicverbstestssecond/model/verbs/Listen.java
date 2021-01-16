package com.apakhun.arabicverbstestssecond.model.verbs;

import android.os.Parcel;

import com.apakhun.arabicverbstestssecond.App;
import com.apakhun.arabicverbstestssecond.R;
import com.apakhun.arabicverbstestssecond.model.Verb;

public class Listen extends Verb {

    public Listen() {
    }

    public Listen(Parcel parcel) {
        super(parcel);
    }

    @Override
    protected String[] getStringArray() {
        return App.getRes().getStringArray(R.array.listen);
    }

    @Override
    public int pictureResourceId() {
        return R.mipmap.listen;
    }

    @Override
    public String getDescription() {
        return getDescription(R.string.description_listen);
    }

    @Override
    public String soundDirName() {
        return "listen";
    }

    @Override
    public int getGroup() {
        return 2;
    }
}

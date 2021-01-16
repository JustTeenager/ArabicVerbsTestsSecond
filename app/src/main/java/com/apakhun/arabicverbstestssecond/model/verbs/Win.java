package com.apakhun.arabicverbstestssecond.model.verbs;

import android.os.Parcel;

import com.apakhun.arabicverbstestssecond.App;
import com.apakhun.arabicverbstestssecond.R;
import com.apakhun.arabicverbstestssecond.model.Verb;

public class Win extends Verb {

    public Win() {
    }

    public Win(Parcel parcel) {
        super(parcel);
    }

    @Override
    protected String[] getStringArray() {
        return App.getRes().getStringArray(R.array.win);
    }

    @Override
    public int pictureResourceId() {
        return R.mipmap.win;
    }

    @Override
    public String getDescription() {
        return getDescription(R.string.description_win);
    }

    @Override
    public String soundDirName() {
        return "win";
    }

    @Override
    public int getGroup(){
        return 1;
    }
}

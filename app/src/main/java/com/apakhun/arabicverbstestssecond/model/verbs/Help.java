package com.apakhun.arabicverbstestssecond.model.verbs;

import android.os.Parcel;

import com.apakhun.arabicverbstestssecond.App;
import com.apakhun.arabicverbstestssecond.R;
import com.apakhun.arabicverbstestssecond.model.Verb;

public class Help extends Verb {

    public Help() {
    }

    public Help(Parcel parcel) {
        super(parcel);
    }

    @Override
    protected String[] getStringArray() {
        return App.getRes().getStringArray(R.array.help);
    }

    @Override
    public int pictureResourceId() {
        return R.mipmap.help;
    }

    @Override
    public String getDescription() {
        return getDescription(R.string.description_help);
    }

    @Override
    public String soundDirName() {
        return "help";
    }

    @Override
    public int getGroup() {
        return 4;
    }
}

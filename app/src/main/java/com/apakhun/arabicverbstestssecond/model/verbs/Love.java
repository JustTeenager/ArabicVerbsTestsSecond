package com.apakhun.arabicverbstestssecond.model.verbs;

import android.os.Parcel;

import com.apakhun.arabicverbstestssecond.App;
import com.apakhun.arabicverbstestssecond.R;
import com.apakhun.arabicverbstestssecond.model.Verb;

public class Love extends Verb {

    public Love() {
    }

    public Love(Parcel parcel) {
        super(parcel);
    }

    @Override
    protected String[] getStringArray() {
        return App.getRes().getStringArray(R.array.love);
    }

    @Override
    public int pictureResourceId() {
        return R.mipmap.love;
    }

    @Override
    public String getDescription() {
        return getDescription(R.string.description_love);
    }

    @Override
    public String soundDirName() {
        return "love";
    }

    @Override
    public int getGroup(){
        return 1;
    }
}

package com.apakhun.arabicverbstestssecond.model.verbs.thirdpart;

import android.os.Parcel;

import com.apakhun.arabicverbstestssecond.App;
import com.apakhun.arabicverbstestssecond.R;
import com.apakhun.arabicverbstestssecond.model.Verb;
import com.apakhun.arabicverbstestssecond.model.verbs.time.time.TimeVerb;

public class Clothe extends TimeVerb {
    public Clothe() {
    }

    public Clothe(Parcel parcel) {
        super(parcel);
    }

    @Override
    public int pictureResourceId() {
        return R.mipmap.clothe;
    }

    @Override
    public String getDescription() {
        return getDescription(R.string.description_clothe);
    }

    @Override
    protected String soundUnderFolderDir() {
        return "clothe";
    }

    @Override
    protected int getPastArrayId() {
        return R.array.past_clothe;
    }

    @Override
    protected int getPresentArrayId() {
        return R.array.present_clothe;
    }

    @Override
    protected int getFutureArrayId() {
        return R.array.future_clothe;
    }

    @Override
    public int getGroup(){
        return 4;
    }
}

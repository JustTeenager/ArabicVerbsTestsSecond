package com.apakhun.arabicverbstestssecond.model.verbs.thirdpart;

import android.os.Parcel;

import com.apakhun.arabicverbstestssecond.R;
import com.apakhun.arabicverbstestssecond.model.verbs.time.time.TimeVerb;

public class DryAndWake extends TimeVerb {
    public DryAndWake() {
    }

    public DryAndWake(Parcel parcel) {
        super(parcel);
    }

    @Override
    public int pictureResourceId() {
        return R.mipmap.dry_wake;
    }

    @Override
    public String getDescription() {
        return getDescription(R.string.description_dry_wake);
    }

    @Override
    protected String soundUnderFolderDir() {
        return "dry_wake";
    }

    @Override
    protected int getPastArrayId() {
        return R.array.past_present_dry;
    }

    @Override
    protected int getPresentArrayId() {
        return R.array.past_present_wake;
    }

    @Override
    protected int getFutureArrayId() {
        return R.array.imperative_dry_wake;
    }

    @Override
    public int getGroup(){
        return 1;
    }
}

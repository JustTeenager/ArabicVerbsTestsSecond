package com.apakhun.arabicverbstestssecond.model.verbs.time.time;


import android.os.Parcel;

import com.apakhun.arabicverbstestssecond.R;

public class Hide extends TimeVerb {
    public Hide() {}

    public Hide(Parcel parcel) {
        super(parcel);
    }

    @Override
    public int pictureResourceId() {
        return R.mipmap.hide;
    }

    @Override
    public String getDescription() {
        return getDescription(R.string.description_hide);
    }

    @Override
    protected String soundUnderFolderDir() {
        return "hide";
    }

    @Override
    protected int getPastArrayId() {
        return R.array.past_hide;
    }

    @Override
    protected int getPresentArrayId() {
        return R.array.present_hide;
    }

    @Override
    protected int getFutureArrayId() {
        return R.array.future_hide;
    }

    @Override
    public int getGroup() {
        return 4;
    }
}

package com.apakhun.arabicverbstestssecond.model.verbs.time.time;


import android.os.Parcel;

import com.apakhun.arabicverbstestssecond.R;

public class Ask extends TimeVerb {
    public Ask() {}

    public Ask(Parcel parcel) {
        super(parcel);
    }

    @Override
    public int pictureResourceId() {
        return R.mipmap.ask;
    }

    @Override
    public String getDescription() {
        return getDescription(R.string.description_ask);
    }

    @Override
    protected String soundUnderFolderDir() {
        return "ask";
    }

    @Override
    protected int getPastArrayId() {
        return R.array.past_ask;
    }

    @Override
    protected int getPresentArrayId() {
        return R.array.present_ask;
    }

    @Override
    protected int getFutureArrayId() {
        return R.array.future_ask;
    }

    @Override
    public int getGroup() {
        return 3;
    }
}

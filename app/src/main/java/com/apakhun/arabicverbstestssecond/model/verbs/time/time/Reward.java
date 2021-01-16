package com.apakhun.arabicverbstestssecond.model.verbs.time.time;


import android.os.Parcel;

import com.apakhun.arabicverbstestssecond.R;

public class Reward extends TimeVerb {
    public Reward() {}

    public Reward(Parcel parcel) {
        super(parcel);
    }

    @Override
    public int pictureResourceId() {
        return R.mipmap.reward;
    }

    @Override
    public String getDescription() {
        return getDescription(R.string.description_reward);
    }

    @Override
    protected String soundUnderFolderDir() {
        return "reward";
    }

    @Override
    protected int getPastArrayId() {
        return R.array.past_reward;
    }

    @Override
    protected int getPresentArrayId() {
        return R.array.present_reward;
    }

    @Override
    protected int getFutureArrayId() {
        return R.array.future_reward;
    }

    @Override
    public int getGroup() {
        return 2;
    }
}

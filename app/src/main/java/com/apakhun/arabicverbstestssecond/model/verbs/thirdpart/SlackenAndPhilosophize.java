package com.apakhun.arabicverbstestssecond.model.verbs.thirdpart;

import android.os.Parcel;

import com.apakhun.arabicverbstestssecond.App;
import com.apakhun.arabicverbstestssecond.R;
import com.apakhun.arabicverbstestssecond.model.Verb;
import com.apakhun.arabicverbstestssecond.model.verbs.time.time.TimeVerb;

public class SlackenAndPhilosophize extends TimeVerb {
    public SlackenAndPhilosophize() {
    }

    public SlackenAndPhilosophize(Parcel parcel) {
        super(parcel);
    }

    @Override
    public int pictureResourceId() {
        return R.mipmap.return_image;
    }

    @Override
    public String getDescription() {
        return getDescription(R.string.description_slacken_philosophize);
    }

    @Override
    protected String soundUnderFolderDir() {
        return "slacken_philosophize";
    }

    @Override
    protected int getPastArrayId() {
        return R.array.past_present_slacken;
    }

    @Override
    protected int getPresentArrayId() {
        return R.array.past_present_philosophize;
    }

    @Override
    protected int getFutureArrayId() {
        return R.array.imperative_slacken_philosophize;
    }

    @Override
    public int getGroup(){
        return 4;
    }
}
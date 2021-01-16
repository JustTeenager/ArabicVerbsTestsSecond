package com.apakhun.arabicverbstestssecond.model.verbs.time.time;


import android.os.Parcel;

import com.apakhun.arabicverbstestssecond.R;

public class Return extends TimeVerb {
    public Return() {}

    public Return(Parcel parcel) {
        super(parcel);
    }

    @Override
    public int pictureResourceId() {
        return R.mipmap.return_image;
    }

    @Override
    public String getDescription() {
        return getDescription(R.string.description_return);
    }

    @Override
    protected String soundUnderFolderDir() {
        return "return";
    }

    @Override
    protected int getPastArrayId() {
        return R.array.past_return;
    }

    @Override
    protected int getPresentArrayId() {
        return R.array.present_return;
    }

    @Override
    protected int getFutureArrayId() {
        return R.array.future_return;
    }

    @Override
    public int getGroup(){
        return 1;
    }
}

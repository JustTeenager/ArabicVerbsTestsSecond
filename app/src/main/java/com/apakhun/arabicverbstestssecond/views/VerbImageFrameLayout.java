package com.apakhun.arabicverbstestssecond.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.apakhun.arabicverbstestssecond.App;
import com.apakhun.arabicverbstestssecond.R;

public class VerbImageFrameLayout extends FrameLayout {

    public VerbImageFrameLayout(@NonNull Context context) {
        super(context);
    }

    public VerbImageFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public VerbImageFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setImage(int drawable) {
        //ImageView back = findViewById(R.id.ivPicVerbBack);
        ImageView front = findViewById(R.id.ivPicVerbFront);
        //back.setImageDrawable(App.getRes().getDrawable(drawable));
        Drawable clone = App.getRes().getDrawable(drawable).getConstantState().newDrawable();
        clone.mutate();
        front.setImageDrawable(clone);
        //back.getDrawable().setColorFilter(App.getRes().getColor(R.color.colorDarkBlue), PorterDuff.Mode.SRC_ATOP);
        //front.getDrawable().setColorFilter(App.getRes().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_ATOP);
    }
}

package com.apakhun.arabicverbstestssecond.views.adapters;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.apakhun.arabicverbstestssecond.App;
import com.apakhun.arabicverbstestssecond.R;
import com.apakhun.arabicverbstestssecond.activities.MainActivity;
import com.apakhun.arabicverbstestssecond.controllers.Cache;
import com.apakhun.arabicverbstestssecond.controllers.Sounder;
import com.apakhun.arabicverbstestssecond.fragments.ParentFragment;
import com.apakhun.arabicverbstestssecond.fragments.TestFragment;
import com.apakhun.arabicverbstestssecond.model.Tests;
import com.apakhun.arabicverbstestssecond.model.Verb;
import com.apakhun.arabicverbstestssecond.model.TimeVerb;
import com.apakhun.arabicverbstestssecond.viewmodel.TestViewModel;
import com.apakhun.arabicverbstestssecond.views.ProgressPieChart;
import com.apakhun.arabicverbstestssecond.views.VerbImageFrameLayout;
import com.github.aakira.expandablelayout.ExpandableLayoutListenerAdapter;
import com.github.aakira.expandablelayout.ExpandableLinearLayout;

public class TestsRecyclerViewAdapter extends RecyclerView.Adapter<TestsRecyclerViewAdapter.DefaultViewHolder> {

    private Tests data;
    private Context context;
    public static final int EXPANDABLE_VIEW_TYPE = 0;
    public static final int DOUBLEWORD_VIEW_TYPE = 2;
    public static final int DEFAULT_VIEW_TYPE = 1;
    private Cache cache;
    private boolean isFirstVerbsPassed, isSecondVerbsPassed, isThirdVerbsPassed, isFourthVerbsPassed;
    private SparseBooleanArray expandState = new SparseBooleanArray(Tests.TestsConfig.MAX_COUNT_VERBS);
    private Verb verbTmp;
    private Verb verbSound;

    private MainActivity activity;

    public TestsRecyclerViewAdapter(MainActivity activity) {
        this.activity = activity;
        for (int i = 0; i < Tests.TestsConfig.MAX_COUNT_VERBS; i++) {
            expandState.append(i, false);
        }
    }

    public void setData(Tests data) {
        this.data = data;
        notifyDataSetChanged();
    }

    private final View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    };

    @NonNull
    @Override
    public DefaultViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        this.context = viewGroup.getContext();
        if (viewType==DOUBLEWORD_VIEW_TYPE) return new DoubleWordHolder(LayoutInflater.from(context).inflate(R.layout.item_test_expandable, viewGroup, false));
        else if (viewType == EXPANDABLE_VIEW_TYPE) {
            return new ExpandableViewHolder(LayoutInflater.from(context).inflate(R.layout.item_test_expandable, viewGroup, false));
        }
        return new DefaultViewHolder(LayoutInflater.from(context).inflate(R.layout.item_test, viewGroup, false));
    }


    @Override
    public void onBindViewHolder(@NonNull DefaultViewHolder viewHolder, int position) {
        Verb verb = data.getVerbs().get(position);
        verbTmp = verb;
        Tests.Progress progress = data.getProgress();
        viewHolder.bind(verbTmp,progress,position);
        if (viewHolder.getItemViewType() == EXPANDABLE_VIEW_TYPE) {
        } else if (viewHolder.getItemViewType() == DEFAULT_VIEW_TYPE) {
            /*DefaultViewHolder holder = viewHolder;

            holder.pieChart.setSucceedCount(progress.getSucceed(verb, TimeVerb.Time.COMMON));
            holder.pieChart.setFailedCount(progress.getFailed(verb, TimeVerb.Time.COMMON));
            holder.pieChart.setTotalQuestions(verb.getPhrases().size());



            holder.clTestItem.setOnClickListener((v) -> toTestFragment(verb, TimeVerb.Time.COMMON));*/
        }


        blockSomeTests(position, viewHolder, progress);
    }

    private void blockSomeTests(int position, DefaultViewHolder viewHolder, Tests.Progress progress){
        //TODO Главная функция, которая блокирует/разблокирует различные уровни + в классе Tests есть метод checkForUnlocks(). Он вызывается каждый раз, когда пользователь успешно проходит тест.

        //Ниже комментарии, которые я использовал для тестирования
//        Verb v1 = data.getVerbs().get(0);
//        Verb v2 = data.getVerbs().get(1);
//        Verb v3 = data.getVerbs().get(2);
//        Verb v4 = data.getVerbs().get(3);
//        progress.addPassed(v1);
//        progress.addPassed(v2);
//        progress.addPassed(v3);
//        progress.addPassed(v4);
////        // second wave
//        Verb v5 = data.getVerbs().get(4);
//        Verb v6 = data.getVerbs().get(5);
//        Verb v7 = data.getVerbs().get(6);
//        Verb v8 = data.getVerbs().get(7);
//        progress.addPassed(v5);
//        progress.addPassed(v6);
//        progress.addPassed(v7);
//        progress.addPassed(v8);
////        // thirds wave
//        Verb v9 = data.getVerbs().get(8);
//        Verb v10 = data.getVerbs().get(9);
//        Verb v11 = data.getVerbs().get(10);
//        progress.addPassed(v9);
//        progress.addPassed(v10);
//        progress.addPassed(v11);
//        // foruth wave
//        Verb v12 = data.getVerbs().get(11);
//        Verb v13 = data.getVerbs().get(12);
//        Verb v14 = data.getVerbs().get(13);
//        progress.addPassed(v12);
//        progress.addPassed(v13);
//        progress.addPassed(v14);
//        Verb v15 = data.getVerbs().get(14);
//        progress.addPassed(v15);


            if(position > 3) {
                if (viewHolder.getItemViewType() == DEFAULT_VIEW_TYPE) {
                    viewHolder.clTestItem.setEnabled(false);
                    viewHolder.clTestItem.setBackgroundColor(App.getRes().getColor(R.color.colorTransparentGray));
                    viewHolder.btnLock.setVisibility(View.VISIBLE);
                    viewHolder.btnLock.setEnabled(true);
                    viewHolder.btnSound.setVisibility(View.INVISIBLE);
                    viewHolder.btnSound.setEnabled(false);
//                    viewHolder.btnSound.setImageDrawable(App.getRes().getDrawable(R.drawable.lock_selector));
//                    viewHolder.btnSound.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            Toast.makeText(App.getAppContext(), App.getRes().getString(R.string.lock_pass_available_tests), Toast.LENGTH_SHORT).show();
//                        }
//                    });
                } else if (viewHolder.getItemViewType() == EXPANDABLE_VIEW_TYPE) {
                    ExpandableViewHolder holder = (ExpandableViewHolder) viewHolder;
                    holder.expandableLayout.setEnabled(false);
                    holder.vItemRow.setEnabled(false);
                    holder.vItemRow.setBackgroundColor(App.getRes().getColor(R.color.colorTransparentGray));
                    viewHolder.btnLock.setVisibility(View.VISIBLE);
                    viewHolder.btnLock.setEnabled(true);
                    viewHolder.btnSound.setVisibility(View.INVISIBLE);
                    viewHolder.btnSound.setEnabled(false);
//                    holder.btnSound.setImageDrawable(App.getRes().getDrawable(R.drawable.lock_selector));
//                    viewHolder.btnSound.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            Toast.makeText(App.getAppContext(), App.getRes().getString(R.string.lock_pass_available_tests), Toast.LENGTH_SHORT).show();
//                        }
//                    });
                }
            }

            //TODO здесь лочатся и анлочатся холдеры
            if(progress.isUnlockSecondWave()){
                if((position > 3) && (position < 8)){
                    unlockHolder(viewHolder, position);
                }

                if(progress.isUnlockThirdWave() && position > 7 && position < 11){
                    unlockHolder(viewHolder, position);
                }

                if(progress.isUnlockFourthWave() && position > 10){
                    unlockHolder(viewHolder, position);
                }
        }
    }

    private void unlockHolder(DefaultViewHolder viewHolder, int position){
        verbSound = data.getVerbs().get(position);
        if (viewHolder.getItemViewType() == DEFAULT_VIEW_TYPE) {
            viewHolder.clTestItem.setEnabled(true);
            viewHolder.clTestItem.setBackgroundColor(App.getRes().getColor(R.color.whiteTransparent));
            viewHolder.btnLock.setVisibility(View.INVISIBLE);
            viewHolder.btnLock.setEnabled(false);
            viewHolder.btnSound.setVisibility(View.VISIBLE);
            viewHolder.btnSound.setEnabled(true);
        } else if (viewHolder.getItemViewType() == EXPANDABLE_VIEW_TYPE) {
            ExpandableViewHolder holder = (ExpandableViewHolder) viewHolder;
            holder.expandableLayout.setEnabled(true);
            holder.vItemRow.setEnabled(true);
            holder.vItemRow.setBackgroundColor(App.getRes().getColor(R.color.whiteTransparent));
            holder.btnLock.setVisibility(View.INVISIBLE);
            holder.btnLock.setEnabled(false);
            holder.btnSound.setVisibility(View.VISIBLE);
            holder.btnSound.setEnabled(true);
        }
    }

    @Override
    public int getItemViewType(int position) {
        //if (position + 1 <= Tests.TestsConfig.FIRST_VERBS_WITH_SEPARATE_TIME 3,14)
        if (position == 3 || position ==14) return DOUBLEWORD_VIEW_TYPE;
        else if (position == 0  || position == 4 || position == 9 || position == 12) return EXPANDABLE_VIEW_TYPE;
        else return DEFAULT_VIEW_TYPE;
    }

    @Override
    public int getItemCount() {
        if (data == null)
            return 0;
        return data.getCountVerbs();
    }

    public class DefaultViewHolder extends RecyclerView.ViewHolder {
        public ImageButton btnSound;
        public ImageButton btnLock;
        public ProgressPieChart pieChart;
        public TextView tvVerb;
        public VerbImageFrameLayout frPic;
        public ConstraintLayout clTestItem;
        protected Verb verb;
        protected Tests.Progress progress;

        DefaultViewHolder(@NonNull View itemView) {
            super(itemView);
            btnSound = itemView.findViewById(R.id.btnSound);
            btnLock = itemView.findViewById(R.id.btnLock);
            pieChart = itemView.findViewById(R.id.pieChart);
            tvVerb = itemView.findViewById(R.id.tvVerb);
            frPic = itemView.findViewById(R.id.frPicVerb);
            clTestItem = itemView.findViewById(R.id.clTestItem);

            pieChart.initChart();
        }

        public void bind(Verb verb,Tests.Progress progress,int position){
            this.verb=verb;
            this.progress=progress;
            setupCommonSettings(position);
            tvVerb.setText(verb.getVerbText());
            frPic.setImage(verb.pictureResourceId());

            btnSound.setOnClickListener((v) -> Sounder.sound(verb.soundResourcePath() + "/1.mp3"));
            btnLock.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(App.getAppContext(), App.getRes().getString(R.string.lock_pass_available_tests), Toast.LENGTH_SHORT).show();
                }
            });
        }

        protected void setupCommonSettings(int position){
            pieChart.setSucceedCount(progress.getSucceed(verb, TimeVerb.Time.COMMON));
            pieChart.setFailedCount(progress.getFailed(verb, TimeVerb.Time.COMMON));
            pieChart.setTotalQuestions(verb.getPhrases().size());
            clTestItem.setOnClickListener((v) -> toTestFragment(verb, TimeVerb.Time.COMMON));
        }

        protected void toTestFragment(Verb verb, TimeVerb.Time time) {
            ViewModelProviders.of(activity).get(TestViewModel.class).putSelectedVerb(verb, time, data.getProgress());
            Bundle bundle = new Bundle();
            bundle.putParcelable(Verb.class.getCanonicalName(), verb);
            bundle.putInt(TimeVerb.Time.class.getCanonicalName(), time.ordinal());

            TestFragment testFragment = ParentFragment.getInstance(activity, TestFragment.class, bundle);
            testFragment.open();
        }
    }

    public class ExpandableViewHolder extends DefaultViewHolder {
        public ExpandableLinearLayout expandableLayout;
        public FrameLayout frPastTime;
        public FrameLayout frPresentTime;
        public FrameLayout frFutureTime;
        public View vItemRow;
        public ProgressPieChart piePastChart;
        public ProgressPieChart piePresentChart;
        public ProgressPieChart pieFutureChart;

        private LinearOutSlowInInterpolator interpolator = new LinearOutSlowInInterpolator();

        ExpandableViewHolder(@NonNull View itemView) {
            super(itemView);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);
            frPastTime = itemView.findViewById(R.id.frPastTime);
            frPresentTime = itemView.findViewById(R.id.frPresentTime);
            frFutureTime = itemView.findViewById(R.id.frFutureTime);
            vItemRow = itemView.findViewById(R.id.vItemRow);

            piePastChart = itemView.findViewById(R.id.piePastChart);
            piePresentChart = itemView.findViewById(R.id.piePresentChart);
            pieFutureChart = itemView.findViewById(R.id.pieFutureChart);

            piePastChart.initChart();
            piePresentChart.initChart();
            pieFutureChart.initChart();

//            setIsRecyclable(false);
            expandableLayout.setInRecyclerView(true);
            expandableLayout.setInterpolator(interpolator);
        }

        @Override
        protected void setupCommonSettings(int position) {
            expandableLayout.setExpanded(expandState.get(position));
            expandableLayout.setListener(new ExpandableLayoutListenerAdapter() {
                @Override
                public void onPreOpen() {
                    expandState.put(position, true);
                }

                @Override
                public void onPreClose() {
                    expandState.put(position, false);
                }
            });

            vItemRow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    expandableLayout.toggle();
                }
            });

            frPastTime.setOnClickListener((v)->toTestFragment(verb, TimeVerb.Time.PAST));
            frPresentTime.setOnClickListener((v)->toTestFragment(verb, TimeVerb.Time.PRESENT));
            frFutureTime.setOnClickListener((v)->toTestFragment(verb, TimeVerb.Time.FUTURE));

            int pastAnswered = progress.getSucceed(verb, TimeVerb.Time.PAST);
            int presentAnswered = progress.getSucceed(verb, TimeVerb.Time.PRESENT);
            int futureAnswered = progress.getSucceed(verb, TimeVerb.Time.FUTURE);

            int pastFailed = progress.getFailed(verb, TimeVerb.Time.PAST);
            int presentFailed = progress.getFailed(verb, TimeVerb.Time.PRESENT);
            int futureFailed = progress.getFailed(verb, TimeVerb.Time.FUTURE);

            piePastChart.setSucceedCount(pastAnswered);
            piePresentChart.setSucceedCount(presentAnswered);
            pieFutureChart.setSucceedCount(futureAnswered);

            piePastChart.setFailedCount(pastFailed);
            piePresentChart.setFailedCount(presentFailed);
            pieFutureChart.setFailedCount(futureFailed);

            piePastChart.setTotalQuestions(((TimeVerb)verb).getPastVerb().getPhrases().size());
            piePresentChart.setTotalQuestions(((TimeVerb)verb).getPresentVerb().getPhrases().size());
            pieFutureChart.setTotalQuestions(((TimeVerb)verb).getFutureVerb().getPhrases().size());

            int totalAnswered = pastAnswered + presentAnswered + futureAnswered;
            int totalFailed = pastFailed + presentFailed + futureFailed;
            pieChart.setSucceedCount(totalAnswered);
            pieChart.setFailedCount(totalFailed);
            pieChart.setTotalQuestions(verb.getPhrases().size());
        }
    }

    public class DoubleWordHolder extends ExpandableViewHolder{

        public TextView pastTextView;
        public TextView presentTextView;
        public TextView futureTextView;

        DoubleWordHolder(@NonNull View itemView) {
                super(itemView);
                Log.d("tut_mipmap", String.valueOf(getAdapterPosition()));
                btnSound.setImageResource(R.mipmap.two);
                //TODO тут меняются даблворды
        }
    }

}
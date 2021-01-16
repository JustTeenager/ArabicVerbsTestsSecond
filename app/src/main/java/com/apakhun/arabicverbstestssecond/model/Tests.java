package com.apakhun.arabicverbstestssecond.model;

import com.apakhun.arabicverbstestssecond.model.verbs.Despise;
import com.apakhun.arabicverbstestssecond.model.verbs.Help;
import com.apakhun.arabicverbstestssecond.model.verbs.Listen;
import com.apakhun.arabicverbstestssecond.model.verbs.Love;
import com.apakhun.arabicverbstestssecond.model.verbs.Obey;
import com.apakhun.arabicverbstestssecond.model.verbs.Pity;
import com.apakhun.arabicverbstestssecond.model.verbs.Soothe;
import com.apakhun.arabicverbstestssecond.model.verbs.Supply;
import com.apakhun.arabicverbstestssecond.model.verbs.Surround;
import com.apakhun.arabicverbstestssecond.model.verbs.Touch;
import com.apakhun.arabicverbstestssecond.model.verbs.Win;
import com.apakhun.arabicverbstestssecond.model.verbs.thirdpart.Clothe;
import com.apakhun.arabicverbstestssecond.model.verbs.thirdpart.Decorate;
import com.apakhun.arabicverbstestssecond.model.verbs.thirdpart.Discover;
import com.apakhun.arabicverbstestssecond.model.verbs.thirdpart.Dread;
import com.apakhun.arabicverbstestssecond.model.verbs.thirdpart.DryAndWake;
import com.apakhun.arabicverbstestssecond.model.verbs.thirdpart.Give;
import com.apakhun.arabicverbstestssecond.model.verbs.thirdpart.Heal;
import com.apakhun.arabicverbstestssecond.model.verbs.thirdpart.Invite;
import com.apakhun.arabicverbstestssecond.model.verbs.thirdpart.Leave;
import com.apakhun.arabicverbstestssecond.model.verbs.thirdpart.Meet;
import com.apakhun.arabicverbstestssecond.model.verbs.thirdpart.Protect;
import com.apakhun.arabicverbstestssecond.model.verbs.thirdpart.Select;
import com.apakhun.arabicverbstestssecond.model.verbs.thirdpart.SlackenAndPhilosophize;
import com.apakhun.arabicverbstestssecond.model.verbs.thirdpart.Trust;
import com.apakhun.arabicverbstestssecond.model.verbs.thirdpart.Visit;
import com.apakhun.arabicverbstestssecond.model.verbs.time.time.Ask;
import com.apakhun.arabicverbstestssecond.model.verbs.time.time.Hide;
import com.apakhun.arabicverbstestssecond.model.verbs.time.time.Return;
import com.apakhun.arabicverbstestssecond.model.verbs.time.time.Reward;
import com.apakhun.arabicverbstestssecond.model.verbs.time.time.TimeVerb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Tests {
    public static class TestsConfig {
        public static int FIRST_VERBS_WITH_SEPARATE_TIME = 5;
        public static final int MAX_COUNT_VERBS = 15;
    }

    private ArrayList<Verb> verbs;
    private final Progress progress;

    public Tests(Progress progress) {

        //TODO поменять порядок
        verbs = new ArrayList<>(TestsConfig.MAX_COUNT_VERBS);
        /*verbs.add(new Return());
        verbs.add(new Touch());
        verbs.add(new Win());
        verbs.add(new Love());
        verbs.add(new Reward());
        verbs.add(new Listen());
        verbs.add(new Surround());
        verbs.add(new Despise());
        verbs.add(new Ask());
        verbs.add(new Pity());
        verbs.add(new Supply());
        verbs.add(new Hide());
        verbs.add(new Help());
        verbs.add(new Obey());
        verbs.add(new Soothe());*/
        verbs.add(new Discover());
        verbs.add(new Leave());
        verbs.add(new Trust());
        verbs.add(new DryAndWake());
        verbs.add(new Give());
        verbs.add(new Decorate());
        verbs.add(new Visit());
        verbs.add(new Select());
        verbs.add(new Dread());
        verbs.add(new Protect());
        verbs.add(new Heal());
        verbs.add(new Meet());
        verbs.add(new Clothe());
        verbs.add(new Invite());
        verbs.add(new SlackenAndPhilosophize());


//         test for unlocking tests
        /*progress = new Progress();

        for (int i = 0; i < 5; i++) {
            TimeVerb verb = (TimeVerb) verbs.get(i);
            TimeVerb.Time time = TimeVerb.Time.PAST;
            progress.putSucceed(verb, time, verb.getPastVerb().getPhrases().size());
            progress.putFailed(verb, time, 0);

            time = TimeVerb.Time.PRESENT;
            progress.putSucceed(verb, time, verb.getPresentVerb().getPhrases().size());
            progress.putFailed(verb, time, 0);

            time = TimeVerb.Time.FUTURE;
            progress.putSucceed(verb, time, verb.getFutureVerb().getPhrases().size());
            progress.putFailed(verb, time, 0);
        }
*/
        /*for (int i = 1; i < 5; i++) {
            progress.addPassed((TimeVerb) verbs.get(i));
        }
        progress.putSucceed((TimeVerb) verbs.get(0), TimeVerb.Time.PAST, ((TimeVerb) verbs.get(0)).getPastVerb().getPhrases().size() - 1);*/
        /*for (int i = 5; i < 10; i++) {
            Verb verb = verbs.get(i);
            TimeVerb.Time time = TimeVerb.Time.COMMON;
            progress.putSucceed(verb, time, verb.getPhrases().size());
            progress.putFailed(verb, time, 0);
            progress.addPassed(verb);
        }*/

        this.progress = progress;
    }

    public Progress getProgress() {return progress;}
    public List<Verb> getVerbs() {return verbs;}
    public int getCountVerbs() {return verbs.size();}

    public static class Progress {
        private Map<Integer,Integer> progressPassed = new HashMap<>();
        private Set<Integer> congratulationsShowed = new HashSet<>();
        private Map<Integer, Integer> progressTrue = new HashMap<>();
        private Map<Integer, Integer> progressFalse = new HashMap<>();
        private boolean unlockSecondWave = false;
        private boolean unlockThirdWave = false;
        private boolean unlockFourthWave = false;


        private Integer toKey(Verb verb, TimeVerb.Time time) {
            return verb.getVerbText().hashCode() + time.toString().hashCode();
        }

        public void addPassed(Verb verb) {
            if (verb.getGroup()==1){
                progressPassed.put(toKey(verb, TimeVerb.Time.COMMON),1);
            } else if (verb.getGroup()==2){
                progressPassed.put(toKey(verb, TimeVerb.Time.COMMON),2);
            } else if (verb.getGroup()==3){
                progressPassed.put(toKey(verb, TimeVerb.Time.COMMON),3);
            } else if (verb.getGroup()==4){
                progressPassed.put(toKey(verb, TimeVerb.Time.COMMON),4);
            }
            checkForUnlocks();
        }

        private void checkForUnlocks(  ){
            Tests testTmp = new Tests(this);
            int result = 1;
            int i = 0;

            while ( result!=0 && i < 15) {
                boolean tmpBool = this.isPassed(testTmp.getVerbs().get(i));
                int tmpInt = tmpBool ? 1 : 0;
                result = result * tmpInt;
                if(result == 0){
                    i = 0;
                }
                if(i==3)
                    unlockSecondWave = true;
                if(i==7)
                    unlockThirdWave = true;
                if(i==10)
                    unlockFourthWave = true;
                i++;
            }
        }

        public boolean isUnlockSecondWave() {
            return unlockSecondWave;
        }

        public boolean isUnlockThirdWave() {
            return unlockThirdWave;
        }

        public boolean isUnlockFourthWave() {
            return unlockFourthWave;
        }

        public void addCongrShowed(Integer order) {
            congratulationsShowed.add(order);
        }

        public boolean isCongrShowed(Integer order) {
            return congratulationsShowed.contains(order);
        }

        public boolean isPassed(Verb verb) {
            return progressPassed.containsKey(toKey(verb, TimeVerb.Time.COMMON));
        }

        public String getPassedCount() {
            return progressPassed.values().toString();
        }

        public void putSucceed(Verb verb, TimeVerb.Time time, int answeredCount) {
            progressTrue.put(toKey(verb, time), answeredCount);
        }

        public int getSucceed(Verb verb, TimeVerb.Time time) {
            if (time == TimeVerb.Time.COMMON && verb instanceof TimeVerb) {

                Integer past = progressTrue.get(toKey(verb, TimeVerb.Time.PAST));
                if (past == null)
                    past = 0;
                Integer present = progressTrue.get(toKey(verb, TimeVerb.Time.PRESENT));
                if (present == null)
                    present = 0;
                Integer future = progressTrue.get(toKey(verb, TimeVerb.Time.FUTURE));
                if (future == null)
                    future = 0;
                return past + present + future;
            }

            Integer pr = progressTrue.get(toKey(verb, time));
            if (pr == null)
                return 0;
            return pr;
        }

        public void putFailed(Verb verb, TimeVerb.Time time, int failedCount) {
            progressFalse.put(toKey(verb, time), failedCount);
        }

        public int getFailed(Verb verb, TimeVerb.Time time) {
            Integer pr = progressFalse.get(toKey(verb, time));
            if (pr == null)
                return 0;
            return pr;
        }
    }
}

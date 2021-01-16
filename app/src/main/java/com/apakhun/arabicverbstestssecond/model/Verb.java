package com.apakhun.arabicverbstestssecond.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

import com.apakhun.arabicverbstestssecond.App;
import com.apakhun.arabicverbstestssecond.Utils;
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
import com.apakhun.arabicverbstestssecond.model.verbs.time.time.Ask;
import com.apakhun.arabicverbstestssecond.model.verbs.time.time.Hide;
import com.apakhun.arabicverbstestssecond.model.verbs.time.time.Return;
import com.apakhun.arabicverbstestssecond.model.verbs.time.time.Reward;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;


public abstract class Verb implements Parcelable {

    private List<Phrase> phrases = new LinkedList<>();

    public Verb() {
        phrases.addAll(initPhrases());
    }

    public Verb(Parcel parcel) {
        parcel.readList(this.phrases, Phrase.class.getClassLoader());
    }

    public List<Phrase> getPhrases() {
        return phrases;
    }

    private List<Phrase> initPhrases() {
        String[] stringArray = getStringArray();
        List<Phrase> phrases = new LinkedList<>();
        int soundId = 1;
        for (String string : stringArray) {
            Phrase phrase = new Phrase();
            String[] splitted = Utils.splitPhraseString(string);
            phrase.setEnglish(splitted[0]);
            phrase.setRussian(splitted[1]);
            phrase.setArabic(splitted[2]);
            phrase.setSoundPath(soundResourcePath() + "/" + soundId + ".mp3");
            phrases.add(phrase);
            soundId++;
        }
        return phrases;
    }

    public static final VerbParcelableCreator CREATOR = new VerbParcelableCreator();

    public static class VerbParcelableCreator implements Creator<Verb> {

        public static int flag = -1;

        //TODO поменять глаголы
        @Override
        public Verb createFromParcel(Parcel source) {
            switch (flag) {
                case 0:
                    return new Return(source);
                case 1:
                    return new Touch(source);
                case 2:
                    return new Win(source);
                case 3:
                    return new Love(source);
                case 4:
                    return new Reward(source);
                case 5:
                    return new Listen(source);
                case 6:
                    return new Surround(source);
                case 7:
                    return new Despise(source);
                case 8:
                    return new Ask(source);
                case 9:
                    return new Pity(source);
                case 10:
                    return new Supply(source);
                case 11:
                    return new Hide(source);
                case 12:
                    return new Help(source);
                case 13:
                    return new Obey(source);
                case 14:
                    return new Soothe(source);

                    default: return new Return(source);
            }
        }

        @Override
        public Verb[] newArray(int size) {
            return new Verb[0];
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(phrases);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @NonNull
    @Override
    public String toString() {
        return getVerbText();
    }

    public String getVerbText() {
        if (phrases.isEmpty())
            return Verb.class.getSimpleName();
        return phrases.get(0).getArabic();
    }

    public String soundResourcePath() {
        return "sound/" + soundDirName();
    }

    protected String getDescription(int descriptionId) {
        String descr = App.getRes().getString(descriptionId);

//        String[] ru_en = descr.split("\\r?\\n");
        String[] ru_en = descr.split(System.getProperty("line.separator"));
        return Locale.getDefault().getLanguage().equals("ru") ? ru_en[0] : ru_en[1];
    }

    protected abstract String[] getStringArray();
    public abstract int pictureResourceId();
    public abstract String getDescription();
    public abstract String soundDirName();
    public abstract int getGroup();
}

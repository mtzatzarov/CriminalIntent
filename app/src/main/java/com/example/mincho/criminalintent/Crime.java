package com.example.mincho.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Mincho on 6/21/2015.
 */
public class Crime {
    public UUID mId;
    public String mTitle;
    public Date mDate;
    public boolean mSolved;

    public UUID getmId() {
        return mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public boolean ismSolved() {
        return mSolved;
    }

    public void setmSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public Crime(){

        // Generates Unique identifier
        mId = UUID.randomUUID();
        mDate = new Date();
        mTitle = new String();
        mSolved = false;
    }

    @Override
    public String toString(){
        return mTitle;
    }
}

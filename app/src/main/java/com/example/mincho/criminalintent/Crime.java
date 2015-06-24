package com.example.mincho.criminalintent;

import java.util.UUID;

/**
 * Created by Mincho on 6/21/2015.
 */
public class Crime {
    private UUID mId;
    private String mTitle;

    public UUID getmId() {
        return mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Crime(){

        // Generates Unique identifier
        mId = UUID.randomUUID();
    }
}

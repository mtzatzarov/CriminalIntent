package com.example.mincho.criminalintent;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.UUID;


public class CrimeActivity extends SingleFragmentActivity {

        @Override
        protected Fragment createFragment() {

           // return new CrimeFragment();

            UUID crimeId = (UUID)getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
            return CrimeFragment.newInstance(crimeId);
        }

    }



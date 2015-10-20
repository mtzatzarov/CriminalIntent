package com.example.mincho.criminalintent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by mtzat on 10/14/2015.
 */
public class CrimePagerActivity extends FragmentActivity{

     ViewPager mViewPager;
   // private ArrayList<Crime> mCrimes;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        mViewPager = new ViewPager(this);
        mViewPager.setId(R.id.viewPager);
        setContentView(mViewPager);

       // mCrimes = CrimeLab.get(this).getCrimes();
        final ArrayList<Crime> crimes = CrimeLab.get(this).getCrimes();

        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {

            @Override
            public Fragment getItem(int position) {
                UUID crimeId = crimes.get(position).getmId();
                return CrimeFragment.newInstance(crimeId);
            }

            @Override
            public int getCount() {
                return crimes.size();
            }
        });

        UUID crimeId = (UUID) getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
        for (int i=0; i<crimes.size();i++){
            if (crimes.get(i).getmId().equals(crimeId)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}

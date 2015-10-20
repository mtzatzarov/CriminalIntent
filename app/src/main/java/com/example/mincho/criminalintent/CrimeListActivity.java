package com.example.mincho.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by Mincho on 10/6/2015.
 */
public class CrimeListActivity extends SingleFragmentActivity {

  @Override
    protected Fragment createFragment(){

      return new CrimeFragment();
  }

  /*  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        FragmentManager fm = getFragmentManager();
        // retrieve CrimeFragment
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);

        if (fragment == null) {
            fragment = new CrimeFragment();
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit();
        }
    } */
}

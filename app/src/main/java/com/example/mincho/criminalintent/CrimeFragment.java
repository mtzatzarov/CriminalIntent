package com.example.mincho.criminalintent;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.io.Console;
import java.util.IllegalFormatException;
import java.util.UUID;



public class CrimeFragment extends Fragment {

    public static final String EXTRA_CRIME_ID = "com.example.mincho.criminalintent.crime_id";

    private Crime mCrime = new Crime();
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;

    public static CrimeFragment newInstance(UUID crimeId){
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_CRIME_ID, crimeId);

        CrimeFragment fragment = new CrimeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // mCrime = new Crime();

        // UUID crimeId = (UUID)getActivity().getIntent().getSerializableExtra(EXTRA_CRIME_ID);

             Log.d("ARG", getArguments() == null ? "arg is null": "arg is not null");
            UUID crimeId = (UUID) getArguments().getSerializable(EXTRA_CRIME_ID);

             Log.d("ARG", CrimeLab.get(getActivity()) == null ? "actvity is null" : "activity is not null");
            mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);

        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime, parent, false);

        Log.d("Mincho", mCrime.mTitle == null ? "Title is null" : "Title is not null");
        //Log.d("Mincho", mCrime.mDate == null ? "Date is null" : "Date is not null");
        //Log.d("Mincho", mCrime.mId == null ? "Id is null" : "Id is not null");
        //Log.d("Mincho", mCrime.mSolved == null ? "solved is null" : "solved is not null");
        mTitleField = (EditText) v.findViewById(R.id.crime_title);
        mTitleField.setText(mCrime.getmTitle());
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setmTitle(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        // android.text.format.DateFormat.format("yyy-mm-dd", new java.util.Date());
        mDateButton = (Button) v.findViewById(R.id.crime_date);
        mDateButton.setText(mCrime.getmDate().toString());
        mDateButton.setEnabled(false);

        mSolvedCheckBox = (CheckBox) v.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setChecked(mCrime.ismSolved());
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setmSolved(isChecked);
            }
        });
        return v;
    }



}

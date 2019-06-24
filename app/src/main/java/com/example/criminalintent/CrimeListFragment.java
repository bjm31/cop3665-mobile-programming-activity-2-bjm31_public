package com.example.criminalintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.criminalintent.Models.Crime;
import com.example.criminalintent.Models.CrimeLab;

import java.util.List;

public class CrimeListFragment extends Fragment {
    private Button mCrime1;
    private Button mCrime2;

    private List<Crime> mCrimes;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mCrimes = CrimeLab.get(getActivity()).getCrimes();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime_list, container, false);

        mCrime1 = v.findViewById(R.id.crime1);
        mCrime1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Crime crime = mCrimes.get(0);
                Intent intent = CrimeActivity.newIntent(getActivity(), crime.getId());
                startActivity(intent);
            }
        });

        mCrime2 = v.findViewById(R.id.crime2);
        mCrime2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Crime crime = mCrimes.get(1);
                Intent intent = CrimeActivity.newIntent(getActivity(), crime.getId());
                startActivity(intent);
            }
        });

        return v;
    }
}

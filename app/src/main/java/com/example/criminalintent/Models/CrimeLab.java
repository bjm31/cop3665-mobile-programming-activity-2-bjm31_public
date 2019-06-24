package com.example.criminalintent.Models;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {
    private static CrimeLab sCrimeLab;

    private List<Crime> mCrimes;

    public static CrimeLab get(Context context)
    {
        if(sCrimeLab == null)
        {
            sCrimeLab = new CrimeLab(context);
        }

        return sCrimeLab;
    }

    private CrimeLab(Context context)
    {
        mCrimes = new ArrayList<>();

        Crime crime1 = new Crime();
        crime1.setTitle("Crime 1");
        crime1.setSolved(false);

        Crime crime2 = new Crime();
        crime2.setTitle("Crime 2");
        crime2.setSolved(true);

        mCrimes.add(crime1);
        mCrimes.add(crime2);
    }

    public List<Crime> getCrimes()
    {
        return mCrimes;
    }

    public Crime getCrime(UUID id)
    {
        for (Crime crime: mCrimes)
        {
            if(crime.getId().equals(id))
            {
                return crime;
            }
        }
        return null;
    }
}

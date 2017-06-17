package com.bignerdranch.android.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by KevinVuNguyen on 6/12/17.
 */

public class CrimeLab
{
    private static CrimeLab sCrimeLab;
    public static int index = 0;
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
        for(int i = 0; i < 100; i++)
        {
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i%2==0);
            mCrimes.add(crime);
        }

    }// this ensures that other classes will not be able to create a CrimeLab object

    public List<Crime> getCrimes()
    {
        return mCrimes;
    }

    public Crime getCrime(UUID id)
    {
        int size = mCrimes.size();

        for(int i = 0; i < size; i++)
        {
            if(mCrimes.get(i).getId().equals(id)) {
                index = i;
                return mCrimes.get(i);
            }
        }
        return null;
    }
}

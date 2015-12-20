package com.missasianlasvegas.twu.malv;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by tdw6193 on 12/20/2015.
 */
public class SponsorsFragment extends Fragment {

    private Context context;

    public SponsorsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_sponsors, container, false);

        context = inflater.getContext();

        return v;
    }
}

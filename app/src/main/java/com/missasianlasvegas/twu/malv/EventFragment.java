package com.missasianlasvegas.twu.malv;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by tdw6193 on 12/20/2015.
 */
public class EventFragment extends Fragment {

    private Context context;

    public EventFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_event, container, false);

        context = inflater.getContext();

        return v;
    }
}

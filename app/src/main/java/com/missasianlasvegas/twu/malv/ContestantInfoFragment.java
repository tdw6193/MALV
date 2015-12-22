package com.missasianlasvegas.twu.malv;

import android.support.annotation.AnimRes;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by tdw6193 on 12/21/2015.
 */
public class ContestantInfoFragment extends Fragment {

    private Context context;

    private String cName, cCountry, cDesc;

    private TextView contestant_name, contestant_country, contestant_desc;
    private ImageButton flip_btn;

    public ContestantInfoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_contestant_info, container, false);

        context = inflater.getContext();

        Bundle bundle = this.getArguments();
        if(bundle != null) {
            cName = bundle.getString("NAME", "Problem loading contestant's name");
            cCountry = bundle.getString("COUNTRY", "Problem loading contestant's country");
            cDesc = bundle.getString("DESC", "Problem loading contestant's description");

            contestant_name = (TextView) v.findViewById(R.id.contestant_name);
            contestant_country = (TextView) v.findViewById(R.id.contestant_country);
            contestant_desc = (TextView) v.findViewById(R.id.contestant_desc);

            contestant_name.setText(cName);
            contestant_country.setText(cCountry);
            contestant_desc.setText(cDesc);
        }

        flip_btn = (ImageButton) v.findViewById(R.id.contestant_flip_btn);
        flip_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        //.setCustomAnimations(R.animator.card_flip_right_in, R.animator.card_flip_right_out,
                        //                     R.animator.card_flip_left_in, R.animator.card_flip_left_out)
                        .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                        .replace(R.id.mainContent, new ContestantsFragment())
                        .addToBackStack(null)
                                        .commit();
            }
        });

        return v;
    }
}

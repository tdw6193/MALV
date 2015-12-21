package com.missasianlasvegas.twu.malv;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by tdw6193 on 12/20/2015.
 */
public class ContestantsFragment extends Fragment {

    private Context context;

    private ImageButton arroyoBtn, bajracharyaBtn, bayaniBtn;
    private ImageButton camachoBtn, angelesBtn, johnsonBtn;
    private ImageButton lankfordBtn, liuBtn, shoafBtn;
    private ImageButton techBtn, vibasBtn, zeiglerBtn;

    public ContestantsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_contestants, container, false);

        context = inflater.getContext();

        arroyoBtn = (ImageButton) v.findViewById(R.id.arroyo_img);
        bajracharyaBtn = (ImageButton) v.findViewById(R.id.bajracharya_img);
        bayaniBtn = (ImageButton) v.findViewById(R.id.bayani_img);
        camachoBtn = (ImageButton) v.findViewById(R.id.camacho_img);
        angelesBtn = (ImageButton) v.findViewById(R.id.angeles_img);
        johnsonBtn = (ImageButton) v.findViewById(R.id.johnson_img);
        lankfordBtn = (ImageButton) v.findViewById(R.id.lankford_img);
        liuBtn = (ImageButton) v.findViewById(R.id.liu_img);
        shoafBtn = (ImageButton) v.findViewById(R.id.shoaf_img);
        techBtn = (ImageButton) v.findViewById(R.id.tech_img);
        vibasBtn = (ImageButton) v.findViewById(R.id.vibas_img);
        zeiglerBtn = (ImageButton) v.findViewById(R.id.zeigler_img);

        arroyoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipFragment("Renea Arroyo",
                             "Countries: China and Thailand",
                             "Top 5");
            }
        });
        bajracharyaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipFragment("Esha Bajracharya",
                             "Country: Nepal",
                             "Miss Social Media");
            }
        });
        bayaniBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipFragment("Ami Bayani",
                             "Country: Philippines",
                             "2015 Miss Asian Las Vegas Winner");
            }
        });
        camachoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipFragment("Catalina Camacho",
                             "Country: Philippines",
                             "Miss Congeniality");
            }
        });
        angelesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipFragment("Renee Delos Angeles",
                             "Country: Philippines",
                             "");
            }
        });
        johnsonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipFragment("Shelby Kanani Johnson",
                             "Country: Japan",
                             "2015 Miss Asian Las Vegas, 1st Runner Up");
            }
        });
        lankfordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipFragment("Amabell Lankford",
                             "Country: South Korea",
                             "Miss Talent");
            }
        });
        liuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipFragment("Ashley Liu",
                             "Country: China",
                             "Miss Modern Asian/Entrepreneur\n" +
                             "Miss People’s Choice\n" +
                             "2015 Miss Asian Las Vegas, 2nd Runner Up");
            }
        });
        shoafBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipFragment("Daphnie Shoaf",
                             "Country: Philippines",
                             "Best Costume");
            }
        });
        techBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipFragment("Daphnie Shoaf",
                        "Country: Cambodia",
                        "Top 5");
            }
        });
        vibasBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipFragment("Joanna Vibas",
                             "Country: Philippines",
                             "");
            }
        });
        zeiglerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipFragment("Manee Zeigler",
                             "Country: Thailand",
                             "");
            }
        });

        return v;
    }

    private void flipFragment(String cName, String cCountry, String cDesc) {
        ContestantInfoFragment contestantInfoFragment = new ContestantInfoFragment();
        Bundle bundle = new Bundle();
        bundle.putString("NAME", cName);
        bundle.putString("COUNTRY", cCountry);
        bundle.putString("DESC", cDesc);
        contestantInfoFragment.setArguments(bundle);

        getFragmentManager()
                .beginTransaction()
                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                .replace(R.id.mainContent, contestantInfoFragment)
                .addToBackStack(null)
                .commit();
    }
}

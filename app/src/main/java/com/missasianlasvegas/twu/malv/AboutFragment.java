package com.missasianlasvegas.twu.malv;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by tdw6193 on 12/20/2015.
 */
public class AboutFragment extends Fragment implements View.OnClickListener{

    private Context context;

    private Button about_us_btn, exclusive_producer_btn, press_releases_btn, programbook_archieve_btn, q_and_a_btn, legacy_btn;
    private LinearLayout about_us_section, exclusive_producer_section, press_releases_section, programbook_archieve_section, q_and_a_section;
    private TextView legacy_text;

    private ImageButton pb13, pb14, pb15;

    public AboutFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_about, container, false);

        context = inflater.getContext();

        about_us_section = (LinearLayout) v.findViewById(R.id.about_us_section);
        exclusive_producer_section = (LinearLayout) v.findViewById(R.id.exclusive_producer_section);
        press_releases_section = (LinearLayout) v.findViewById(R.id.press_releases_section);
        programbook_archieve_section = (LinearLayout) v.findViewById(R.id.programbook_archieve_section);
        q_and_a_section = (LinearLayout) v.findViewById(R.id.q_and_a_section);
        legacy_text = (TextView) v.findViewById(R.id.legacy_text);

        about_us_btn = (Button) v.findViewById(R.id.about_us_btn);
        exclusive_producer_btn = (Button) v.findViewById(R.id.exclusive_producer_btn);
        press_releases_btn = (Button) v.findViewById(R.id.press_releases_btn);
        programbook_archieve_btn = (Button) v.findViewById(R.id.programbook_archieve_btn);
        q_and_a_btn = (Button) v.findViewById(R.id.q_and_a_btn);
        legacy_btn = (Button) v.findViewById(R.id.legacy_btn);

        about_us_btn.setOnClickListener(this);
        exclusive_producer_btn.setOnClickListener(this);
        press_releases_btn.setOnClickListener(this);
        programbook_archieve_btn.setOnClickListener(this);
        q_and_a_btn.setOnClickListener(this);
        legacy_btn.setOnClickListener(this);

        pb13 = (ImageButton) v.findViewById(R.id.programbook2013_btn);
        pb14 = (ImageButton) v.findViewById(R.id.programbook2014_btn);
        pb15 = (ImageButton) v.findViewById(R.id.programbook2015_btn);

        pb13.setOnClickListener(this);
        pb14.setOnClickListener(this);
        pb15.setOnClickListener(this);

        switchToAboutUs();

        return v;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.about_us_btn:
                switchToAboutUs();
                break;
            case R.id.exclusive_producer_btn:
                switchToExclusiveProducer();
                break;
            case R.id.press_releases_btn:
                switchToPressReleases();
                break;
            case R.id.programbook_archieve_btn:
                switchToProgramBookArchieve();
                break;
            case R.id.q_and_a_btn:
                switchToQA();
                break;
            case R.id.legacy_btn:
                switchToLegacy();
                break;
            case R.id.programbook2013_btn:
                viewProgramBook(13);
                break;
            case R.id.programbook2014_btn:
                viewProgramBook(14);
                break;
            case R.id.programbook2015_btn:
                viewProgramBook(15);
                break;
            default:
        }
    }

    private void switchToAboutUs () {
        about_us_btn.setTextColor(getResources().getColor(R.color.white));
        exclusive_producer_btn.setTextColor(getResources().getColor(R.color.grey));
        press_releases_btn.setTextColor(getResources().getColor(R.color.grey));
        programbook_archieve_btn.setTextColor(getResources().getColor(R.color.grey));
        q_and_a_btn.setTextColor(getResources().getColor(R.color.grey));
        legacy_btn.setTextColor(getResources().getColor(R.color.grey));

        about_us_section.setVisibility(View.VISIBLE);
        exclusive_producer_section.setVisibility(View.GONE);
        press_releases_section.setVisibility(View.GONE);
        programbook_archieve_section.setVisibility(View.GONE);
        q_and_a_section.setVisibility(View.GONE);
        legacy_text.setVisibility(View.GONE);
    }

    private void switchToExclusiveProducer () {
        about_us_btn.setTextColor(getResources().getColor(R.color.grey));
        exclusive_producer_btn.setTextColor(getResources().getColor(R.color.white));
        press_releases_btn.setTextColor(getResources().getColor(R.color.grey));
        programbook_archieve_btn.setTextColor(getResources().getColor(R.color.grey));
        q_and_a_btn.setTextColor(getResources().getColor(R.color.grey));
        legacy_btn.setTextColor(getResources().getColor(R.color.grey));

        about_us_section.setVisibility(View.GONE);
        exclusive_producer_section.setVisibility(View.VISIBLE);
        press_releases_section.setVisibility(View.GONE);
        programbook_archieve_section.setVisibility(View.GONE);
        q_and_a_section.setVisibility(View.GONE);
        legacy_text.setVisibility(View.GONE);
    }

    private void switchToPressReleases () {
        about_us_btn.setTextColor(getResources().getColor(R.color.grey));
        exclusive_producer_btn.setTextColor(getResources().getColor(R.color.grey));
        press_releases_btn.setTextColor(getResources().getColor(R.color.white));
        programbook_archieve_btn.setTextColor(getResources().getColor(R.color.grey));
        q_and_a_btn.setTextColor(getResources().getColor(R.color.grey));
        legacy_btn.setTextColor(getResources().getColor(R.color.grey));

        about_us_section.setVisibility(View.GONE);
        exclusive_producer_section.setVisibility(View.GONE);
        press_releases_section.setVisibility(View.VISIBLE);
        programbook_archieve_section.setVisibility(View.GONE);
        q_and_a_section.setVisibility(View.GONE);
        legacy_text.setVisibility(View.GONE);
    }

    private void switchToProgramBookArchieve () {
        about_us_btn.setTextColor(getResources().getColor(R.color.grey));
        exclusive_producer_btn.setTextColor(getResources().getColor(R.color.grey));
        press_releases_btn.setTextColor(getResources().getColor(R.color.grey));
        programbook_archieve_btn.setTextColor(getResources().getColor(R.color.white));
        q_and_a_btn.setTextColor(getResources().getColor(R.color.grey));
        legacy_btn.setTextColor(getResources().getColor(R.color.grey));

        about_us_section.setVisibility(View.GONE);
        exclusive_producer_section.setVisibility(View.GONE);
        press_releases_section.setVisibility(View.GONE);
        programbook_archieve_section.setVisibility(View.VISIBLE);
        q_and_a_section.setVisibility(View.GONE);
        legacy_text.setVisibility(View.GONE);
    }

    private void switchToQA () {
        about_us_btn.setTextColor(getResources().getColor(R.color.grey));
        exclusive_producer_btn.setTextColor(getResources().getColor(R.color.grey));
        press_releases_btn.setTextColor(getResources().getColor(R.color.grey));
        programbook_archieve_btn.setTextColor(getResources().getColor(R.color.grey));
        q_and_a_btn.setTextColor(getResources().getColor(R.color.white));
        legacy_btn.setTextColor(getResources().getColor(R.color.grey));

        about_us_section.setVisibility(View.GONE);
        exclusive_producer_section.setVisibility(View.GONE);
        press_releases_section.setVisibility(View.GONE);
        programbook_archieve_section.setVisibility(View.GONE);
        q_and_a_section.setVisibility(View.VISIBLE);
        legacy_text.setVisibility(View.GONE);
    }

    private void switchToLegacy () {
        about_us_btn.setTextColor(getResources().getColor(R.color.grey));
        exclusive_producer_btn.setTextColor(getResources().getColor(R.color.grey));
        press_releases_btn.setTextColor(getResources().getColor(R.color.grey));
        programbook_archieve_btn.setTextColor(getResources().getColor(R.color.grey));
        q_and_a_btn.setTextColor(getResources().getColor(R.color.grey));
        legacy_btn.setTextColor(getResources().getColor(R.color.white));

        about_us_section.setVisibility(View.GONE);
        exclusive_producer_section.setVisibility(View.GONE);
        press_releases_section.setVisibility(View.GONE);
        programbook_archieve_section.setVisibility(View.GONE);
        q_and_a_section.setVisibility(View.GONE);
        legacy_text.setVisibility(View.VISIBLE);
    }

    private void viewProgramBook(int year) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        if(year == 13)
            intent.setData(Uri.parse("http://www.zyistudio.com/missasianlasvegas/programbook.html"));
        else if (year == 14)
            intent.setData(Uri.parse("http://issuu.com/missasianlasvegas/docs/malvprogrambook4"));
        else
            intent.setData(Uri.parse("http://issuu.com/missasianlasvegas/docs/malvprogrambook_2015"));
        startActivity(intent);
    }
}

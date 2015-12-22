package com.missasianlasvegas.twu.malv;

import android.content.Intent;
import android.media.Image;
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

/**
 * Created by tdw6193 on 12/20/2015.
 */
public class SponsorsFragment extends Fragment implements View.OnClickListener {

    private Context context;

    private Button sponsor_request_btn, programbook_sponsor_btn, event_sponsor_btn;
    private Button sponsors_btn, media_partners_btn;
    private LinearLayout sponsors_section, media_partners_section;

    private ImageButton venetian_btn;
    private ImageButton lvwoman_btn, wendoh_btn;
    private ImageButton thainews_btn, asianjornal_btn, v7_btn;
    private ImageButton ch8_btn, examiner_btn, lvsun_btn;
    private ImageButton lvweekly_btn, spyonvegas_btn, vegasnews_btn;
    private ImageButton zimbio_btn, lvcdn_btn;
    private ImageButton ptimes_btn;

    public SponsorsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_sponsors, container, false);

        context = inflater.getContext();

        sponsors_section = (LinearLayout) v.findViewById(R.id.sponsors_section);
        media_partners_section = (LinearLayout) v.findViewById(R.id.media_partners_section);

        sponsor_request_btn = (Button) v.findViewById(R.id.sponsor_request_btn);
        programbook_sponsor_btn = (Button) v.findViewById(R.id.programbook_sponsor_btn);
        event_sponsor_btn = (Button) v.findViewById(R.id.event_sponsor_btn);
        sponsors_btn = (Button) v.findViewById(R.id.sponsors_btn);
        media_partners_btn = (Button) v.findViewById(R.id.media_partners_btn);
        venetian_btn = (ImageButton) v.findViewById(R.id.venetian_logo);

        lvwoman_btn = (ImageButton) v.findViewById(R.id.lvwoman_btn);
        wendoh_btn = (ImageButton) v.findViewById(R.id.wendoh_btn);
        thainews_btn = (ImageButton) v.findViewById(R.id.thainews_btn);
        asianjornal_btn = (ImageButton) v.findViewById(R.id.asianjornal_btn);
        v7_btn = (ImageButton) v.findViewById(R.id.v7_btn);
        ch8_btn = (ImageButton) v.findViewById(R.id.ch8_btn);
        examiner_btn = (ImageButton) v.findViewById(R.id.examiner_btn);
        lvsun_btn = (ImageButton) v.findViewById(R.id.lvsun_btn);
        lvweekly_btn = (ImageButton) v.findViewById(R.id.lvweekly_btn);
        spyonvegas_btn = (ImageButton) v.findViewById(R.id.spyonvegas_btn);
        vegasnews_btn = (ImageButton) v.findViewById(R.id.vegasnews_btn);
        zimbio_btn = (ImageButton) v.findViewById(R.id.zimbio_btn);
        lvcdn_btn = (ImageButton) v.findViewById(R.id.lvcdn_btn);
        ptimes_btn = (ImageButton) v.findViewById(R.id.ptimes_btn);

        sponsor_request_btn.setOnClickListener(this);
        programbook_sponsor_btn.setOnClickListener(this);
        event_sponsor_btn.setOnClickListener(this);
        sponsors_btn.setOnClickListener(this);
        media_partners_btn.setOnClickListener(this);
        venetian_btn.setOnClickListener(this);
        lvwoman_btn.setOnClickListener(this);
        wendoh_btn.setOnClickListener(this);
        thainews_btn.setOnClickListener(this);
        asianjornal_btn.setOnClickListener(this);
        v7_btn.setOnClickListener(this);
        ch8_btn.setOnClickListener(this);
        examiner_btn.setOnClickListener(this);
        lvsun_btn.setOnClickListener(this);
        lvweekly_btn.setOnClickListener(this);
        spyonvegas_btn.setOnClickListener(this);
        vegasnews_btn.setOnClickListener(this);
        zimbio_btn.setOnClickListener(this);
        lvcdn_btn.setOnClickListener(this);
        ptimes_btn.setOnClickListener(this);

        switchToSponsors();

        return v;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.sponsor_request_btn:
                becomeSponsor("SPONSOR");
                break;
            case R.id.programbook_sponsor_btn:
                becomeSponsor("PROGRAMBOOK");
                break;
            case R.id.event_sponsor_btn:
                becomeSponsor("EVENT");
                break;
            case R.id.sponsors_btn:
                switchToSponsors();
                break;
            case R.id.media_partners_btn:
                switchToMediaPartners();
                break;
            case R.id.venetian_logo:
                visitSponsor("http://www.venetian.com/");
                break;
            case R.id.lvwoman_btn:
                visitSponsor("http://lvwomanmagazine.com/");
                break;
            case R.id.wendoh_btn:
                visitSponsor("http://wendohmedia.com/");
                break;
            case R.id.thainews_btn:
                visitSponsor("http://www.giovannimedia.com/");
                break;
            case R.id.asianjornal_btn:
                visitSponsor("http://asianjournal.com/");
                break;
            case R.id.v7_btn:
                visitSponsor("http://vegasseven.com/");
                break;
            case R.id.ch8_btn:
                visitSponsor("http://www.lasvegasnow.com/");
                break;
            case R.id.examiner_btn:
                visitSponsor("http://www.examiner.com/");
                break;
            case R.id.lvsun_btn:
                visitSponsor("http://lasvegassun.com/");
                break;
            case R.id.lvweekly_btn:
                visitSponsor("http://lasvegasweekly.com/");
                break;
            case R.id.spyonvegas_btn:
                visitSponsor("http://spyonvegas.com/");
                break;
            case R.id.vegasnews_btn:
                visitSponsor("http://vegasnews.com/");
                break;
            case R.id.zimbio_btn:
                visitSponsor("http://www.zimbio.com/");
                break;
            case R.id.lvcdn_btn:
                visitSponsor("http://www.lasvegaschinesedailynews.com/en/index.php");
                break;
            case R.id.ptimes_btn:
                visitSponsor("http://philippinetimesofsouthernnevada.com/");
                break;
            default:
        }
    }

    private void visitSponsor(String url) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    private void becomeSponsor(String type) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        switch (type) {
            case "PROGRAMBOOK":
                intent.setData(Uri.parse("http://missasianlasvegas.com/our-sponsors/program-book-advertiser/"));
                break;
            case "EVENT":
                intent.setData(Uri.parse("http://missasianlasvegas.com/our-sponsors/event-sponsor/"));
                break;
            default:
                intent.setData(Uri.parse("http://missasianlasvegas.com/our-sponsors/become-a-sponsor/"));
        }
        startActivity(intent);
    }

    private void switchToSponsors () {
        sponsors_btn.setTextColor(getResources().getColor(R.color.white));
        media_partners_btn.setTextColor(getResources().getColor(R.color.grey));

        sponsors_section.setVisibility(View.VISIBLE);
        media_partners_section.setVisibility(View.GONE);
    }

    private void switchToMediaPartners () {
        sponsors_btn.setTextColor(getResources().getColor(R.color.grey));
        media_partners_btn.setTextColor(getResources().getColor(R.color.white));

        sponsors_section.setVisibility(View.GONE);
        media_partners_section.setVisibility(View.VISIBLE);
    }
}

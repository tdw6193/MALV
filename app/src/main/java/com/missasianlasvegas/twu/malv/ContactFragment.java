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
import android.widget.ImageButton;

/**
 * Created by tdw6193 on 12/20/2015.
 */
public class ContactFragment extends Fragment {

    private Context context;

    private ImageButton contact_us_btn, mailing_list_btn;

    public ContactFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_contact, container, false);

        context = inflater.getContext();

        contact_us_btn = (ImageButton) v.findViewById(R.id.contact_us_btn);
        mailing_list_btn = (ImageButton) v.findViewById(R.id.mailing_list_btn);

        contact_us_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactUs();
            }
        });

        mailing_list_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                joinMailingList();
            }
        });

        return v;
    }

    private void contactUs() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://missasianlasvegas.com/contact-us/"));
        startActivity(intent);
    }

    private void joinMailingList() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://missasianlasvegas.com/contact-us/mailing-list/"));
        startActivity(intent);
    }
}

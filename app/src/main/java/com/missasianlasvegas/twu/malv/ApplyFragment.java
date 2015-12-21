package com.missasianlasvegas.twu.malv;

import android.content.Intent;
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
public class ApplyFragment extends Fragment{

    private Context context;

    private ImageButton apply_btn;

    public ApplyFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_apply, container, false);

        context = inflater.getContext();

        apply_btn = (ImageButton) v.findViewById(R.id.apply_btn);
        apply_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startApplying();
            }
        });

        return v;
    }

    private void startApplying() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://missasianlasvegas.com/how-to-apply/"));
        startActivity(intent);
    }
}

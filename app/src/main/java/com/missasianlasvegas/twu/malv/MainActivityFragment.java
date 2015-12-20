package com.missasianlasvegas.twu.malv;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment  {

    private Context context;

    private Integer[] slideshowImgId = { R.mipmap.img1, R.mipmap.img2, R.mipmap.img3 };
    private int slideshowImgIdx= 0;

    private ImageSwitcher galleryImageSwitcher;
    private ImageButton prevButton, nextButton;

    private ImageButton programbookButton, recapvideoButton;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        context = inflater.getContext();


        galleryImageSwitcher = (ImageSwitcher) v.findViewById(R.id.slideshow_imageswitcher);
        galleryImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView i = new ImageView(context);
                i.setBackgroundColor(0xFF000000);
                i.setScaleType(ImageView.ScaleType.FIT_CENTER);

                return i;
            }
        });
        galleryImageSwitcher.setInAnimation(AnimationUtils.loadAnimation(context, android.R.anim.fade_in));
        galleryImageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(context, android.R.anim.fade_out));

        slideshowImgIdx = 0;
        galleryImageSwitcher.setImageResource(slideshowImgId[slideshowImgIdx]);

        prevButton = (ImageButton) v.findViewById(R.id.slideshow_prev);
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPrevImageInSlideshow();
            }
        });
        nextButton = (ImageButton) v.findViewById(R.id.slideshow_next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNextImageInSlideshow();
            }
        });

        programbookButton = (ImageButton) v.findViewById(R.id.programbook_btn);
        programbookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startProgramBook();
            }
        });

        recapvideoButton = (ImageButton) v.findViewById(R.id.recap_video_btn);
        recapvideoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRecapVideo();
            }
        });

        return v;
    }

    private void setNextImageInSlideshow() {
        if(slideshowImgIdx == slideshowImgId.length-1)
            slideshowImgIdx = 0;
        else
            slideshowImgIdx++;

        galleryImageSwitcher.setImageResource(slideshowImgId[slideshowImgIdx]);
    }

    private void setPrevImageInSlideshow() {
        if(slideshowImgIdx == 0)
            slideshowImgIdx = slideshowImgId.length-1;
        else
            slideshowImgIdx--;

        galleryImageSwitcher.setImageResource(slideshowImgId[slideshowImgIdx]);
    }

    private void startProgramBook() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://issuu.com/missasianlasvegas/docs/malvprogrambook_2015"));
        startActivity(intent);
    }

    private void startRecapVideo() {
        YouTubeFragment YoutubeFragment = new YouTubeFragment();
        FragmentManager manager = getActivity().getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.mainContent, YoutubeFragment)
                .addToBackStack(null)
                .commit();
    }
}

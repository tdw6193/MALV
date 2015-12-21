package com.missasianlasvegas.twu.malv;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import customviews.EventsExpandableListViewAdapter;
import entities.Event;

/**
 * Created by tdw6193 on 12/20/2015.
 */
public class EventFragment extends Fragment {

    private Context context;

    private Button event_info_btn, emcee_btn, performers_btn, judges_btn;

    private ExpandableListView listView;
    private EventsExpandableListViewAdapter adapter;
    private LinearLayout bhoolswan_section, chan_section;
    private TextView performers_text_sction, judges_text_sction;

    public EventFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_event, container, false);

        context = inflater.getContext();

        ArrayList<Event> events = generateDummyData();

        listView = (ExpandableListView) v.findViewById(R.id.events_listview);
        if(!events.isEmpty()) {
            adapter = new EventsExpandableListViewAdapter(context, events);
            listView.setAdapter(adapter);
            for (int i = 0; i < adapter.getGroupCount(); i++)
                listView.expandGroup(i);
        }

        bhoolswan_section = (LinearLayout) v.findViewById(R.id.bhoolswan_section);
        chan_section = (LinearLayout) v.findViewById(R.id.chan_section);
        performers_text_sction = (TextView) v.findViewById(R.id.performers_text_sction);
        judges_text_sction = (TextView) v.findViewById(R.id.judges_text_sction);

        event_info_btn = (Button) v.findViewById(R.id.event_info_btn);
        emcee_btn = (Button) v.findViewById(R.id.emcee_btn);
        performers_btn = (Button) v.findViewById(R.id.performers_btn);
        judges_btn = (Button) v.findViewById(R.id.judges_btn);

        setToEventInfo();

        event_info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setToEventInfo();
            }
        });
        emcee_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setToEMCEE();
            }
        });
        performers_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setToPerformers();
            }
        });
        judges_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setToJudges();
            }
        });

        return v;
    }

    private ArrayList<Event> generateDummyData () {
        ArrayList<Event> eventList = new ArrayList<Event>();

        Event [] events = new Event[9];

        events[0] = new Event();
        events[0].setName("Miss Asian North America Pageant");
        events[0].setMonth("July, 2016");
        events[0].setDate("");
        events[0].setLocation("The Venetian Hotel & Casino");
        eventList.add(events[0]);

        events[1] = new Event();
        events[1].setName("Miss Asian Las Vegas/ Miss Asian North America Pool Party");
        events[1].setMonth("June, 2016");
        events[1].setDate("");
        events[1].setLocation("Location: TBD");
        eventList.add(events[1]);

        events[2] = new Event();
        events[2].setName("Deadline To Apply For Miss Asian Las Vegas/ Miss Asian North America");
        events[2].setMonth("May, 2016");
        events[2].setDate("");
        events[2].setLocation("");
        eventList.add(events[2]);

        events[3] = new Event();
        events[3].setName("Ms./Mrs. Asian Las Vegas Pageant");
        events[3].setMonth("December, 2015");
        events[3].setDate("");
        events[3].setLocation("Location: TBD");
        eventList.add(events[3]);

        events[4] = new Event();
        events[4].setName("Ms./ Mrs. Asian Las Vegas Orientation");
        events[4].setMonth("November, 2015");
        events[4].setDate("Saturday November 7");
        events[4].setLocation("Location: TBD");
        eventList.add(events[4]);

        events[5] = new Event();
        events[5].setName("Miss Asian Las Vegas Azure Pool Party");
        events[5].setMonth("August, 2015");
        events[5].setDate("Saturday August 16 11:00am – 5:00pm");
        events[5].setLocation("Azure Pool Inside The Palazzo Hotel & Casino");
        eventList.add(events[5]);

        events[6] = new Event();
        events[6].setName("Miss Asian Las Vegas Meet & Greet Reception");
        events[6].setMonth("August, 2015");
        events[6].setDate("Thursday August 27");
        events[6].setLocation("TBD – The Venetian Hotel & Casino – 3355 Las Vegas Blvd");
        eventList.add(events[6]);

        events[7] = new Event();
        events[7].setName("Miss Asian Las Vegas Preliminary Pageant");
        events[7].setMonth("August, 2015");
        events[7].setDate("Friday August 28");
        events[7].setLocation("The Venetian Theatre-The Venetian Hotel & Casino – 3355 Las Vegas Blvd");
        eventList.add(events[7]);

        events[8] = new Event();
        events[8].setName("Miss Asian Las Vegas Pageant Finale");
        events[8].setMonth("August, 2015");
        events[8].setDate("Saturday August 29");
        events[8].setLocation("The Venetian Theatre-The Venetian Hotel & Casino – 3355 Las Vegas Blvd");
        eventList.add(events[8]);

        return eventList;
    }

    private void setToEventInfo(){
        event_info_btn.setTextColor(getResources().getColor(R.color.white));
        emcee_btn.setTextColor(getResources().getColor(R.color.grey));
        performers_btn.setTextColor(getResources().getColor(R.color.grey));
        judges_btn.setTextColor(getResources().getColor(R.color.grey));

        listView.setVisibility(View.VISIBLE);
        bhoolswan_section.setVisibility(View.GONE);
        chan_section.setVisibility(View.GONE);
        performers_text_sction.setVisibility(View.GONE);
        judges_text_sction.setVisibility(View.GONE);
    }

    private void setToEMCEE(){
        event_info_btn.setTextColor(getResources().getColor(R.color.grey));
        emcee_btn.setTextColor(getResources().getColor(R.color.white));
        performers_btn.setTextColor(getResources().getColor(R.color.grey));
        judges_btn.setTextColor(getResources().getColor(R.color.grey));

        listView.setVisibility(View.GONE);
        bhoolswan_section.setVisibility(View.VISIBLE);
        chan_section.setVisibility(View.VISIBLE);
        performers_text_sction.setVisibility(View.GONE);
        judges_text_sction.setVisibility(View.GONE);
    }

    private void setToPerformers(){
        event_info_btn.setTextColor(getResources().getColor(R.color.grey));
        emcee_btn.setTextColor(getResources().getColor(R.color.grey));
        performers_btn.setTextColor(getResources().getColor(R.color.white));
        judges_btn.setTextColor(getResources().getColor(R.color.grey));

        listView.setVisibility(View.GONE);
        bhoolswan_section.setVisibility(View.GONE);
        chan_section.setVisibility(View.GONE);
        performers_text_sction.setVisibility(View.VISIBLE);
        judges_text_sction.setVisibility(View.GONE);
    }

    private void setToJudges(){
        event_info_btn.setTextColor(getResources().getColor(R.color.grey));
        emcee_btn.setTextColor(getResources().getColor(R.color.grey));
        performers_btn.setTextColor(getResources().getColor(R.color.grey));
        judges_btn.setTextColor(getResources().getColor(R.color.white));

        listView.setVisibility(View.GONE);
        bhoolswan_section.setVisibility(View.GONE);
        chan_section.setVisibility(View.GONE);
        performers_text_sction.setVisibility(View.GONE);
        judges_text_sction.setVisibility(View.VISIBLE);
    }
}

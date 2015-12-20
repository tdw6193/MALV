package customviews;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.missasianlasvegas.twu.malv.R;

import java.util.ArrayList;
import java.util.HashMap;

import entities.Event;

/**
 * Created by tdw6193 on 12/20/2015.
 */
public class EventsExpandableListViewAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<String> headerList; //For dates
    private HashMap<String, ArrayList<Event>> itemList;

    public EventsExpandableListViewAdapter(Context context, ArrayList<Event> events) {
        this.context = context;
        this.headerList = new ArrayList<String>();
        this.itemList = new HashMap<String, ArrayList<Event>>();

        extractData(events);
    }

    private void extractData(ArrayList<Event> events) {

        for(Event event : events) {
            String groupText = event.getMonth();
            if(!itemList.containsKey(groupText)) {
                headerList.add(groupText);
                itemList.put(groupText, new ArrayList<Event>());
            }
            itemList.get(groupText).add(event);
        }
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.itemList.get(this.headerList.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View view, ViewGroup parent) {

        final Event child = (Event) getChild(groupPosition, childPosition);
        final String eventName = child.getName();
        final String eventLocation = child.getLocation();
        final String eventDate = child.getDate();

        if (view == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = infalInflater.inflate(R.layout.expandable_listview_item_eventinfo, null);
        }

        TextView eventNameTextView = (TextView) view.findViewById(R.id.event_name_text);
        eventNameTextView.setText(eventName);
        TextView eventLocationTextView = (TextView) view.findViewById(R.id.event_location_text);
        eventLocationTextView.setText(eventLocation);
        TextView eventDateTextView = (TextView) view.findViewById(R.id.event_date_text);
        eventDateTextView.setText(eventDate);

        return view;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.itemList.get(this.headerList.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.headerList.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.headerList.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view,
                             ViewGroup parent) {
        String headerDate = (String) getGroup(groupPosition);

        if (view == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = infalInflater.inflate(R.layout.expandable_listview_group_eventinfo, null);
        }

        TextView lblListHeader = (TextView) view.findViewById(R.id.event_date_textview);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerDate);

        return view;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}


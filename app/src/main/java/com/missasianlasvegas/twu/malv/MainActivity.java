package com.missasianlasvegas.twu.malv;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends FragmentActivity implements OnItemClickListener {

    private DrawerLayout drawerLayout;
    private ListView listView;
    private String[] menu;
    private ActionBarDrawerToggle drawerListener;
    private FragmentManager fManager;

    //key pair for restore the instance state
    static final String STATE_SCORE = "mainScore";
    static final String STATE_LEVEL = "mainLevel";
    private int mCurrentScore;
    private int mCurrentLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        menu = getResources().getStringArray(R.array.menu);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current state
        savedInstanceState.putInt(STATE_SCORE, mCurrentScore);
        savedInstanceState.putInt(STATE_LEVEL, mCurrentLevel);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        // Restore state members from saved instance
        mCurrentScore = savedInstanceState.getInt(STATE_SCORE);
        mCurrentLevel = savedInstanceState.getInt(STATE_LEVEL);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)	{
        if(drawerListener.onOptionsItemSelected(menuItem))
        {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    public void onConfigurationChanged(Configuration config)	{
        super.onConfigurationChanged(config);
        drawerListener.onConfigurationChanged(config);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState)	{
        super.onPostCreate(savedInstanceState);
        drawerListener.syncState();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        listView.setItemChecked(position, true);
        Fragment newFragment = null;
        switch (position) {
            case 0:
                newFragment = new MainActivityFragment();
                break;
            default:
                break;
        }
        changeFragment(newFragment, menu[position], false);
        drawerLayout.closeDrawers();
    }

    public void changeFragment(Fragment newFragment, String fragmentName, boolean addToBackStack) {
        setTitle(fragmentName);
        FragmentTransaction fTransaction  = fManager.beginTransaction();
        fTransaction.replace(R.id.mainContent, newFragment);
        if (addToBackStack) {
            fTransaction.addToBackStack(null);
        }
        fTransaction.commit();
    }

}
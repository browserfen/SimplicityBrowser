package com.creativetrends.app.simplicity.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ListView;

import com.creativetrends.app.simplicity.SimplicityApplication;
import com.creativetrends.app.simplicity.utils.StaticUtils;
import com.creativetrends.simplicity.app.R;

/**
 * Created by Creative Trends Apps.
 */

public class AboutFragment extends PreferenceFragment  {
    public boolean mListStyled;
    Context context;
    SharedPreferences preferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = SimplicityApplication.getContextOfApplication();
        addPreferencesFromResource(R.xml.about);
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        Preference version = findPreference("version_simple");
        version.setSummary(getResources().getString(R.string.app_name) + " " + StaticUtils.getAppVersionName(context));


    }

    @Override
    public void onStart() {
        super.onStart();

    }


    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle(R.string.about_app);
        if (!mListStyled) {
            View rootView = getView();
            if (rootView != null) {
                ListView list = rootView.findViewById(android.R.id.list);
                list.setPadding(0, 0, 0, 0);
                list.setDivider(null);
                mListStyled = true;
            }
        }

    }


    @Override
    public void onPause() {
        super.onPause();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}

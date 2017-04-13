package com.ecosd.project.carbonfootprint.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.ecosd.project.carbonfootprint.MainActivity;
import com.ecosd.project.carbonfootprint.Others.PrefManager;
import com.ecosd.project.carbonfootprint.R;

/**
 * Created by this pc on 10-04-17.
 */

public class SettingsFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private View view;
    PrefManager prefManager;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.settings, container, false);
        prefManager=new PrefManager(getActivity());
        Spinner spinner = (Spinner)view.findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
      return view;

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        if(!adapterView.getItemAtPosition(i).toString().equals("Choose your Language"))
        {prefManager.setLanguages(adapterView.getItemAtPosition(i)+"");
        startActivity(new Intent(getActivity(), MainActivity.class));}

        else
        {
            Toast.makeText(getActivity(),"Select your language",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

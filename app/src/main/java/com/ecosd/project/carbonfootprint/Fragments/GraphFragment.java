package com.ecosd.project.carbonfootprint.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ecosd.project.carbonfootprint.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by this pc on 10-04-17.
 */

public class GraphFragment extends Fragment {

    private View view;
    BarChart barChart,barChart2,barChart4;
    ArrayList<String> Dates;
    ArrayList<String> Weeks;
    ArrayList<String> Regions;
    int Days[]={R.string.day1,R.string.day2,R.string.day3,R.string.day4,R.string.day5,R.string.day6,R.string.day7};



    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.graph_fragment, container, false);

        barChart=(BarChart)view.findViewById(R.id.bargraph);
        barChart2=(BarChart)view.findViewById(R.id.bargraph2);
        barChart4=(BarChart)view.findViewById(R.id.bargraph4);

        ArrayList<BarEntry> barEntries=new ArrayList<>();
        barEntries.add(new BarEntry(0,44f));
        barEntries.add(new BarEntry(1,42f));
        barEntries.add(new BarEntry(2,34f));
        barEntries.add(new BarEntry(3,14f));
        barEntries.add(new BarEntry(4,54f));
        barEntries.add(new BarEntry(5,30f));
        barEntries.add(new BarEntry(6,50f));


        BarDataSet barDataSet=new BarDataSet(barEntries,getString(R.string.app_name));
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        ArrayList<IBarDataSet> dataSets=new ArrayList<>();
        dataSets.add((IBarDataSet)barDataSet);
        BarData data=new BarData(dataSets);

        Dates=new ArrayList<>();
        Dates.add(getString(Days[0]));
        Dates.add(getString(Days[1]));
        Dates.add(getString(Days[2]));
        Dates.add(getString(Days[3]));
        Dates.add(getString(Days[4]));
        Dates.add(getString(Days[5]));
        Dates.add(getString(Days[6]));

        IAxisValueFormatter formatter=new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                Log.e("value:",""+value);
                return Dates.get((int)value);
            }


        };


        Weeks=new ArrayList<>();
        Weeks.add("Week 1");
        Weeks.add("Week 2");
        Weeks.add("Week 3");
        Weeks.add("Week 4");
        Weeks.add("Week 5");
        Weeks.add("Week 6");
        Weeks.add("Week 7");



        IAxisValueFormatter formatter2=new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                Log.e("value:",""+value);
                return Weeks.get((int)value);
            }


        };


        Regions=new ArrayList<>();
        Regions.add("Gwalior");
        Regions.add("Agra");
        Regions.add("Morena");
        Regions.add("Lucknow");
        Regions.add("Delhi");
        Regions.add("Jaipur");
        Regions.add("Mumbai");
        Regions.add("Mathura");

        IAxisValueFormatter formatter3=new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                Log.e("value:",""+value);
                return Regions.get((int)value);
            }


        };



        XAxis xAxis=barChart.getXAxis();
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(formatter);

        XAxis xAxis2=barChart2.getXAxis();
        xAxis2.setGranularity(1f);
        xAxis2.setValueFormatter(formatter2);

        XAxis xAxis4=barChart4.getXAxis();
        xAxis4.setGranularity(1f);
        xAxis4.setValueFormatter(formatter3);


        barChart.setData(data);
        barChart.animateXY(2000,2000);

        barChart2.setData(data);
        barChart2.animateXY(2000,2000);

        barChart4.setData(data);
        barChart4.animateXY(2000,2000);

        return view;
    }
}

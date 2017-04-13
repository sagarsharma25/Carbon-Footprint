package com.ecosd.project.carbonfootprint.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.ecosd.project.carbonfootprint.ChallangeActivity;
import com.ecosd.project.carbonfootprint.Others.PrefManager;
import com.ecosd.project.carbonfootprint.R;



/**
 * Created by this pc on 10-04-17.
 */

public class FootprintFragment extends Fragment {

    private View view;
    PrefManager prefManager;
    EditText editText1,editText2,editText3,editText4,editText5,editText6,editText7,editText8,editText9,editText10,editText11,editText12,editText13;
    double answer1,answer2,answer3,answer4,answer5,answer6,answer7,answer8,answer9,answer10,answer11,answer12,answer13,total;
    TextView textView,help;


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.footprint_fragment_new , container, false);
        prefManager=new PrefManager(getActivity());
        help=(TextView)view.findViewById(R.id.help);
        textView=(TextView)view.findViewById(R.id.calculate);
        editText1=(EditText)view.findViewById(R.id.editText1);
        editText2=(EditText)view.findViewById(R.id.editText2);
        editText3=(EditText)view.findViewById(R.id.editText3);
        editText4=(EditText)view.findViewById(R.id.editText4);
        editText5=(EditText)view.findViewById(R.id.editText5);
        editText6=(EditText)view.findViewById(R.id.editText6);
        editText7=(EditText)view.findViewById(R.id.editText7);
        editText8=(EditText)view.findViewById(R.id.editText8);
        editText9=(EditText)view.findViewById(R.id.editText9);
        editText10=(EditText)view.findViewById(R.id.editText10);
        editText11=(EditText)view.findViewById(R.id.editText11);
        editText12=(EditText)view.findViewById(R.id.editText12);
        editText13=(EditText)view.findViewById(R.id.editText13);



        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer1=Double.parseDouble(editText1.getText().toString());
                answer2=Double.parseDouble(editText2.getText().toString());
                answer3=Double.parseDouble(editText3.getText().toString());
                answer4=Double.parseDouble(editText4.getText().toString());
                answer5=Double.parseDouble(editText5.getText().toString());
                answer6=Double.parseDouble(editText6.getText().toString());
                answer7=Double.parseDouble(editText7.getText().toString());
                answer8=Double.parseDouble(editText8.getText().toString());
                answer9=Double.parseDouble(editText9.getText().toString());
                answer10=Double.parseDouble(editText10.getText().toString());
                answer11=Double.parseDouble(editText11.getText().toString());
                answer12=Double.parseDouble(editText12.getText().toString());
                answer13=Double.parseDouble(editText13.getText().toString());
                total=answer1*0.5925+answer2*5.48*0.034095+answer3*0.055+answer4*8.91+answer5*0.44932+answer6*10.15+answer7*0.137+answer8*0.254+answer9*7+answer10*16.8+answer11*0.00548*0.034095+answer12*0.5542+answer13*10.15;
                prefManager.setAnswer(total+"");
                startActivity(new Intent(getActivity(), ChallangeActivity.class));
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.unitconverters.net/"));
                startActivity(browserIntent);
            }
        });



        return view;
    }


}

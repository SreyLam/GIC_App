package com.example.drawnavigation;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SeminarsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SeminarsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public SeminarsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SeminarsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SeminarsFragment newInstance(String param1, String param2) {
        SeminarsFragment fragment = new SeminarsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_seminars, container, false);
        ArrayList<SeminarsList> seminars = new ArrayList<>();

        SeminarsList m1=new SeminarsList("hello every1");
        SeminarsList m2=new SeminarsList("hello every2");
        SeminarsList m3=new SeminarsList("hello every3");
        SeminarsList m4=new SeminarsList("hello every4");
        SeminarsList m5=new SeminarsList("hello every5");
        SeminarsList m6=new SeminarsList("hello every6");
        SeminarsList m7=new SeminarsList("hello every7");
        seminars.add(m1);
        seminars.add(m2);
        seminars.add(m3);
        seminars.add(m4);
        seminars.add(m5);
        seminars.add(m6);
        seminars.add(m7);

        BindDictionary<SeminarsList>dictionary = new BindDictionary<>();
//        dictionary.addProgressBarField(R.id.textname, new StringExtractor<SeminarsList>() {
//            @Override
//            public String getStringValue(SeminarsList seminars1, int position) {
//                return seminars1.getName();
//            }
//        });

        FunDapter dapter= new FunDapter(SeminarsFragment.this.getActivity(),seminars,R.layout.seminars_layout,dictionary);
        ListView listView= (ListView) view.findViewById(R.id.listviewseminars);
        listView.setAdapter(dapter);

        return view;
    }

}

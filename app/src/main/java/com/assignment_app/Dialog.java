package com.assignment_app;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Dialog#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Dialog extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private static final String[] allTasks = {"Age Calculator", "Binary To Hexa", "Color Changer", "Lottery"};


    public Dialog() {
        // Required empty public constructor
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        GridView gridView = (GridView) view.findViewById(R.id.gridView);

        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext().getApplicationContext(), R.layout.list_view, allTasks);
        gridView.setAdapter(arrayAdapter);

//        gridView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch (i) {
                    case 0:
                        intent = new Intent(view.getContext(), Dialog_Agecalculation.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(view.getContext(), Dialog_BinaryToHexaNumber.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(view.getContext(), Dialog_ChangeColour.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(view.getContext(), Dialog_Lottery.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Dialog.
     */
    // TODO: Rename and change types and number of parameters
    public static Dialog newInstance(String param1, String param2) {
        Dialog fragment = new Dialog();
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
        return inflater.inflate(R.layout.fragment_dialog, container, false);
    }
}
package com.ion_popescu.laborator3.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ion_popescu.laborator3.R;
import com.ion_popescu.laborator3.services.ToastService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {
    private TextView service_status;
    private Button stop_service;
    private Button go_back;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SecondFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
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
        View rootView=inflater.inflate(R.layout.fragment_second, container, false);
        go_back=rootView.findViewById(R.id.go_back_button);
        stop_service=rootView.findViewById(R.id.stop_service);
        service_status=rootView.findViewById(R.id.status);
        Intent intent=new Intent(getActivity(),ToastService.class);

        service_status.setText(checkForStatus());
//      On Click Listener for Stop Service Button;
//      Even though it's stopService(intent) as method we need to Override onDestroy();
        stop_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().stopService(intent);
                service_status.setText("Status: Service is stopped!");
            }
        });

        service_status.setText(checkForStatus());

        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentManager.popBackStack();
                fragmentTransaction.replace(R.id.container_for_fragments,new FirstFragment());
                fragmentTransaction.commit();
            }
        });
        return rootView;

    }

    private String checkForStatus() {
        if(!ToastService.isStatus())
            return "Status: Service is stopped!";
        return "Status: Service is running!";
    }

}
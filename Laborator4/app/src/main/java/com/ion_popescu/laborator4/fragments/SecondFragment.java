package com.ion_popescu.laborator4.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ion_popescu.laborator4.R;
import com.ion_popescu.laborator4.api.RetrofitClientApi;
import com.ion_popescu.laborator4.repo.User;
import com.ion_popescu.laborator4.services.DataRetrievalService;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {
    private TextView user,lab_group,motto;
    private Button previousFragmentButton,getTheDataButton;
    private String address_value;

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
        Bundle bundle = getArguments();
        if (bundle != null) {
            address_value = bundle.getString("address");
        }
    }

    private void goToThePreviousFragment(){
        previousFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();

                fragmentManager.popBackStack();
                fragmentTransaction.replace(R.id.fragmentContainerView,new FirstFragment());
                fragmentTransaction.commit();
            }
        });

    }
    private void getTheData(){
        getTheDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit retrofitClient=RetrofitClientApi.addTheAddressOfTheApi(address_value);
                DataRetrievalService dataRetrievalService=retrofitClient.create(DataRetrievalService.class);
                Call<User> repo=dataRetrievalService.getUser("test");

                repo.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful()) {
                            User apiResponse = response.body();
                            if(apiResponse.getStudentName()!=null && apiResponse.getLaboratoryGroup()!=null && apiResponse.getPost()!=null){
                                user.setText(apiResponse.getStudentName());
                                lab_group.setText(apiResponse.getLaboratoryGroup());
                                motto.setText(apiResponse.getPost());
                            }
                        } else {
                            Log.e("API", "onResponse: "+response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        t.printStackTrace();
                    }

                });

            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.fragment_second, container, false);
        previousFragmentButton=rootview.findViewById(R.id.back_button);
        getTheDataButton=rootview.findViewById(R.id.get_data_button);
        user=rootview.findViewById(R.id.user_textview);
        lab_group=rootview.findViewById(R.id.lab_group_textview);
        motto=rootview.findViewById(R.id.motto_textView);

        goToThePreviousFragment();
        getTheData();

        return rootview;
    }
}
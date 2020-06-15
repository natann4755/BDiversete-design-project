package com.example.bdiverse.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bdiverse.Adapter.OpenFragmentAdapter;
import com.example.bdiverse.Obgects.task;
import com.example.bdiverse.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.
 * Use the {@link OpenFrgament#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OpenFrgament extends Fragment {

    private OpenFragmentListener mListener;
    private RecyclerView mRecyclerView;
    private OpenFragmentAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<task> mTasks;
    private TextView taskSise;
    private EditText searchTask;

    public OpenFrgament() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment OpenFrgament.
     */
    // TODO: Rename and change types and number of parameters
    public static OpenFrgament newInstance() {
        OpenFrgament fragment = new OpenFrgament();
//        Bundle args = new Bundle();
//
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) { }
        mTasks = tasks();

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_open, container, false);
        initRecyclerView(view);
        return view;
    }
    private void initRecyclerView(View v) {

        mRecyclerView = v.findViewById(R.id.recycler_open_f_RV);
        taskSise = v.findViewById(R.id.openFrag_size_TV);
        taskSise.setText("("+mTasks.size()+")");


        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new OpenFragmentAdapter(mTasks);
        mRecyclerView.setAdapter(mAdapter);

        initSearch(v);

    }

    private void initSearch(View v) {
        searchTask = v.findViewById(R.id.fOPEN_search_ET);
        searchTask.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.OpenFragmentInteraction();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OpenFragmentListener) {
            mListener = (OpenFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OpenFragmentListener {
        // TODO: Update argument type and name
        void OpenFragmentInteraction();
    }
    public ArrayList<task> tasks (){
        ArrayList<task> arrayTasc = new ArrayList<>();
        arrayTasc.add(new task("Garden cleaning test",false,189,"OCT 06" ,"14:00","15:00",
                "Catering Israel LTD.","Employees feeding, south"));
        arrayTasc.add(new task("Smoke detector test",true,193,"OCT 06" ,"14:00","15:00",
                "Fire detaction Systems Ltd.","Maintenance of Fire detection System, center"));
        arrayTasc.add(new task("Garden cleaning test",false,189,"OCT 06" ,"14:00","15:00",
                "Catering Israel LTD.","Employees feeding, south"));
        arrayTasc.add(new task("Smoke detector test",true,193,"OCT 06" ,"14:00","15:00",
                "Fire detaction Systems Ltd.","Maintenance of Fire detection System, center"));
        arrayTasc.add(new task("Garden cleaning test",false,189,"OCT 06" ,"14:00","15:00",
                "Catering Israel LTD.","Employees feeding, south"));
        arrayTasc.add(new task("Smoke detector test",true,193,"OCT 06" ,"14:00","15:00",
                "Fire detaction Systems Ltd.","Maintenance of Fire detection System, center"));
        arrayTasc.add(new task("Garden cleaning test",false,189,"OCT 06" ,"14:00","15:00",
                "Catering Israel LTD.","Employees feeding, south"));
        arrayTasc.add(new task("Smoke detector test",true,193,"OCT 06" ,"14:00","15:00",
                "Fire detaction Systems Ltd.","Maintenance of Fire detection System, center"));
        return arrayTasc;
    }
}

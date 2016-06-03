package com.homemade.barista.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ScrollView;

import com.homemade.barista.Coffee;
import com.homemade.barista.DbHelper;
import com.homemade.barista.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentRecipe.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentRecipe#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRecipe extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView textView;
    Coffee coffee;

    private OnFragmentInteractionListener mListener;

    public FragmentRecipe() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentRecipe.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentRecipe newInstance(String param1, String param2) {
        FragmentRecipe fragment = new FragmentRecipe();
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

        int number = 1;
        View v = inflater.inflate(R.layout.fragment_recipe, container, false);
        final DbHelper coffeehelper = new DbHelper(getActivity());
        coffee = coffeehelper.getCoffeeById(number);
        textView = (TextView)v.findViewById(R.id.textView1);
        textView.setText(coffee.getDescription());
        number++;
        coffee = coffeehelper.getCoffeeById(number);
        textView = (TextView)v.findViewById(R.id.textView2);
        textView.setText(coffee.getDescription());
        number++;
        coffee = coffeehelper.getCoffeeById(number);
        textView = (TextView)v.findViewById(R.id.textView3);
        textView.setText(coffee.getDescription());
        number++;
        coffee = coffeehelper.getCoffeeById(number);
        textView = (TextView)v.findViewById(R.id.textView4);
        textView.setText(coffee.getDescription());
        number++;
//        coffee = coffeehelper.getCoffeeById(number);
//        textView = (TextView)v.findViewById(R.id.textView5);
//        textView.setText(coffee.getDescription());
//        number++;
//        coffee = coffeehelper.getCoffeeById(number);
//        textView = (TextView)v.findViewById(R.id.textView6);
//        textView.setText(coffee.getDescription());
//        number++;
//        coffee = coffeehelper.getCoffeeById(number);
//        textView = (TextView)v.findViewById(R.id.textView7);
//        textView.setText(coffee.getDescription());
//        number++;
//        coffee = coffeehelper.getCoffeeById(number);
//        textView = (TextView)v.findViewById(R.id.textView8);
//        textView.setText(coffee.getDescription());
//        number++;
//        coffee = coffeehelper.getCoffeeById(number);
//        textView = (TextView)v.findViewById(R.id.textView9);
//        textView.setText(coffee.getDescription());
//        number++;
//        coffee = coffeehelper.getCoffeeById(number);
//        textView = (TextView)v.findViewById(R.id.textView10);
//        textView.setText(coffee.getDescription());
//        number++;
//        coffee = coffeehelper.getCoffeeById(number);
//        textView = (TextView)v.findViewById(R.id.textView11);
//        textView.setText(coffee.getDescription());
//        number++;
//        coffee = coffeehelper.getCoffeeById(number);
//        textView = (TextView)v.findViewById(R.id.textView12);
//        textView.setText(coffee.getDescription());
//        number++;
//        coffee = coffeehelper.getCoffeeById(number);
//        textView = (TextView)v.findViewById(R.id.textView13);
//        textView.setText(coffee.getDescription());
//        number++;
//        coffee = coffeehelper.getCoffeeById(number);
//        textView = (TextView)v.findViewById(R.id.textView14);
//        textView.setText(coffee.getDescription());
//        number++;
//        coffee = coffeehelper.getCoffeeById(number);
//        textView = (TextView)v.findViewById(R.id.textView15);
//        textView.setText(coffee.getDescription());
//        number++;
//        coffee = coffeehelper.getCoffeeById(number);
//        textView = (TextView)v.findViewById(R.id.textView16);
//        textView.setText(coffee.getDescription());
//        number++;
//        coffee = coffeehelper.getCoffeeById(number);
//        textView = (TextView)v.findViewById(R.id.textView17);
//        textView.setText(coffee.getDescription());
//        number++;
//        coffee = coffeehelper.getCoffeeById(number);
//        textView = (TextView)v.findViewById(R.id.textView18);
//        textView.setText(coffee.getDescription());
        // Inflate the layout for this fragment
        return v;
                //inflater.inflate(R.layout.fragment_recipe, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

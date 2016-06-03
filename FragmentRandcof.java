package com.homemade.barista.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.homemade.barista.DbHelper;
import com.homemade.barista.Coffee;
import com.homemade.barista.R;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentRandcof.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentRandcof#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRandcof extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView textView;
    private ImageView imageView;
    private OnFragmentInteractionListener mListener;

    public FragmentRandcof() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentRandcof.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentRandcof newInstance(String param1, String param2) {
        FragmentRandcof fragment = new FragmentRandcof();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public interface onSomeEventLestener {
        public void someEvent(String s);
    }

    onSomeEventLestener someEventLestener;

//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//            try {
//                someEventLestener = (onSomeEventLestener) activity;
//            } catch (ClassCastException e) {
//                throw new ClassCastException(activity.toString() + "most implement onSomeEventListener");
//            }
//    }

    Button button_randcof;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }



    Coffee coffee;

    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_randcof, container, false);
//    }
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_randcof, null);
        final Button button = (Button) v.findViewById(R.id.button_randcof);
        final DbHelper coffeehelper = new DbHelper(getActivity());
        textView = (TextView)v.findViewById(R.id.textView);
        //imageView = (ImageView)v.findViewById(R.id.imageButton);
                button.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Random rand = new Random();
                        int number = rand.nextInt(18)+1;
                        coffee = coffeehelper.getCoffeeById(number);
                        String myString = coffee.getDescription();
                        textView.setText(myString);
                        button.setText(coffee.getTitle());
//                        if (number == 1)
//                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.coffee1));
//                        if (number == 2)
//                            imageView.setImageDrawable(getResources().getDrawable(R.drawable.coffee2));
//                        if (number == 3)
//                            imageView.setImageDrawable(getResources().getDrawable(R.drawable.coffee3));
//                        if (number == 4)
//                            imageView.setImageDrawable(getResources().getDrawable(R.drawable.coffee4));
//                        if (number == 5)
//                            imageView.setImageDrawable(getResources().getDrawable(R.drawable.coffee5));
//                        if (number == 6)
//                            imageView.setImageDrawable(getResources().getDrawable(R.drawable.coffee6));
//                        if (number == 7)
//                            imageView.setImageDrawable(getResources().getDrawable(R.drawable.coffee7));
//                        if (number == 8)
//                            imageView.setImageDrawable(getResources().getDrawable(R.drawable.coffee8));
//                        if (number == 9)
//                            imageView.setImageDrawable(getResources().getDrawable(R.drawable.coffee9));
//                        if (number == 10)
//                            imageView.setImageDrawable(getResources().getDrawable(R.drawable.coffee10));
//                        if (number == 11)
//                            imageView.setImageDrawable(getResources().getDrawable(R.drawable.coffee11));
//                        if (number == 12)
//                            imageView.setImageDrawable(getResources().getDrawable(R.drawable.coffee12));
//                        if (number == 13)
//                            imageView.setImageDrawable(getResources().getDrawable(R.drawable.coffee13));
//                        if (number == 14)
//                            imageView.setImageDrawable(getResources().getDrawable(R.drawable.coffee14));
//                        if (number == 15)
//                            imageView.setImageDrawable(getResources().getDrawable(R.drawable.coffee15));
//                        if (number == 16)
//                            imageView.setImageDrawable(getResources().getDrawable(R.drawable.coffee16));
//                        if (number == 17)
//                            imageView.setImageDrawable(getResources().getDrawable(R.drawable.coffee17));
//                        if (number == 18)
//                            imageView.setImageDrawable(getResources().getDrawable(R.drawable.coffee18));

                    }
       });

        return  v;
    }

    public void generView () {
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

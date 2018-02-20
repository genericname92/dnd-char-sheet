package com.example.simonhsieh.ddcharactersheet;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import butterknife.Unbinder;

/**
 * Created by simonhsieh on 2/19/18.
 */

public class HomeFragment extends Fragment{
    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.button_example, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        return rootView;
    }

    @OnClick(R.id.button)
    public void onButtonClick(View v) {
        Toast.makeText(getActivity(), "hi", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

//    @OnLongClick(R.id.button)
//    public boolean onButtonLongClick(View v) {
//        new AlertDialog.Builder(this)
//                .setView(LayoutInflater.from(this).inflate(R.layout.dialog, null))
//                .setPositiveButton("blah", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this, "hihi", Toast.LENGTH_SHORT).show();
//                    }
//                }).show();
//
//        return true;
//    }
}

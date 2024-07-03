package edu.sfsu.bartender.fragment;

import android.os.Bundle;

import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import edu.sfsu.bartender.R;

public class HomeFragment extends ListFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
               inflater.getContext(),
               android.R.layout.simple_list_item_1,
               getResources().getStringArray(R.array.options));

        setListAdapter(adapter);

        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}
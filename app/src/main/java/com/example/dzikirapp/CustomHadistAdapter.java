package com.example.dzikirapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class CustomHadistAdapter extends ArrayAdapter<String> {
    private final Activity activity;
    private final String[] judul;
    private final String[] ayat;
    private final String[] arti;

    public CustomHadistAdapter(Activity content, String[] judul,String[] ayat,String[] arti) {
        super(content, R.layout.row_hadist, judul);
        this.activity = content;
        this.judul = judul;
        this.ayat = ayat;
        this.arti = arti;

    }

    public View getView (int position, View view, ViewGroup viewGroup){
        LayoutInflater inflater = activity.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.row_hadist, null, true);

        TextView judulH = rowView.findViewById(R.id.judul_hadist);
        TextView ayatH = rowView.findViewById(R.id.ayat);
        TextView artiH = rowView.findViewById(R.id.ARTI);

        judulH.setText(judul[position]);
        ayatH.setText(ayat[position]);
        artiH.setText(arti[position]);

        return rowView;


    }


}

package com.khoai.oto.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.khoai.oto.Chung;
import com.khoai.oto.Detail;
import com.khoai.oto.R;

import java.util.ArrayList;

import static android.R.id.list;

public class BaseFragment extends Fragment {
    String hangxe = null;
    ArrayList<Detail> list = new ArrayList<>();

//    public BaseFragment() {
//        // Required empty public constructor
//    }
//
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            hangxe = getArguments().getString("name");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base, container, false);

        getList();
        for(Detail detail: list){
            //Log.d("Moden===============",detail.getModen().toString());
        }
        return view;
    }
    void getList() {
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (hangxe.equals(getResources().getStringArray(R.array.list_trademark)[0])){
                    String chuoi = dataSnapshot.child("0").getValue(String.class);
                    String[] ds_id_banchay = chuoi.split(",");
                    for (String string : ds_id_banchay){
                        DataSnapshot dataSnapshot_oto = dataSnapshot.child(string);
                        Detail detail = new Detail();
                        detail.setID(dataSnapshot_oto.getKey());
                        String image = dataSnapshot_oto.child(getString(R.string.image)).getValue(String.class);
                        detail.setImage(image);
                        detail.setCostDP(dataSnapshot_oto.child(getString(R.string.giadamphan)).getValue(String.class));
                        detail.setCostNY(dataSnapshot_oto.child(getString(R.string.gianiemyet)).getValue(String.class));
//                        detail.setModen(dataSnapshot_oto.child(Chung.tenxe).getValue(String.class));
                        detail.setRecieve(dataSnapshot_oto.child(getString(R.string.thuonghieu)).getValue(String.class));
                        list.add(detail);
                    }
                } else
                    for (DataSnapshot child: dataSnapshot.getChildren()){
                        if (child.hasChildren()){

                            Detail detail = new Detail();
                            detail.setID(child.getKey());

                            String image = child.child(getString(R.string.image)).getValue(String.class);
                            detail.setImage(image);

                            detail.setCostDP(child.child(getString(R.string.giadamphan)).getValue(String.class));
                            detail.setCostNY(child.child(getString(R.string.gianiemyet)).getValue(String.class));
//                            detail.setEngine(child.child("engine").getValue(String.class));
                            detail.setModen(child.child(Chung.tenxe).getValue(String.class));
                            detail.setRecieve(child.child(getString(R.string.thuonghieu)).getValue(String.class));
//                        detail.setSource(child.child(Chung.nguongoc).getValue(String.class));
//                            detail.setTorque(child.child("torque").getValue(String.class));
//                        detail.setType(child.child(Chung.loaixe).getValue(String.class));
                            if (hangxe.equals(detail.getRecieve()))
                                list.add(detail);
                        }
                    }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
    }

}

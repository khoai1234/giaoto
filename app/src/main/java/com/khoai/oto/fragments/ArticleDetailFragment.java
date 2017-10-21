package com.khoai.oto.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.khoai.oto.Chung;
import com.khoai.oto.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Shows the quote detail page.
 *
 * Created by Andreas Schrade on 14.12.2015.
 */
public class ArticleDetailFragment extends BaseFragment {

    /**
     * The argument represents the dummy item ID of this fragment.
     */
    public static final String ARG_ITEM_ID = "item_id";
    String item_id = null;

    /**
     * The dummy content of this fragment.
     */
//    private DummyContent.DummyItem dummyItem;

//    @Bind(R.id.quote)
//    TextView quote;

    @Bind(R.id.ll_giadamphan)
    LinearLayout ll_giadamphan;

    @Bind(R.id.gianiemyet) TextView gianiemyet;
    @Bind(R.id.giadanphan) TextView giadanphan;
    @Bind(R.id.nguongoc) TextView nguongoc;
    @Bind(R.id.loaixe) TextView loaixe;

    @Bind(R.id.backdrop)
    ImageView backdropImg;

    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            item_id = getArguments().getString(ARG_ITEM_ID);

            // load dummy item by using the passed item ID.
//            dummyItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflateAndBind(inflater, container, R.layout.fragment_article_detail);

        MobileAds.initialize(getActivity(), getString(R.string.banner_ad_unit_id));
        AdView mAdView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

       // if (!((BaseActivity) getActivity()).providesActivityToolbar()) {
            // No Toolbar present. Set include_toolbar:
        //    ((BaseActivity) getActivity()).setToolbar((Toolbar) rootView.findViewById(R.id.toolbar));
        //}
        if (item_id != null) {
            DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();
            final FirebaseStorage storage = FirebaseStorage.getInstance();
            DatabaseReference data_item = myRef.child(item_id);
            data_item.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
//                    System.out.println(dataSnapshot.child(Chung.image).getValue(String.class));
                    new Chung();
                    String image = dataSnapshot.child(Chung.image).getValue(String.class);
                    StorageReference islandRef = storage.getReference().child(image + ".png");
                    setImage(islandRef);

//                    String image;
//                    if (dataSnapshot.hasChild(Chung.image)){
//                        image = dataSnapshot.child(Chung.image).getValue(String.class);
//                    } else {
//                        image = "image_oto";
//                    }
//                    int id_image = getResources().getIdentifier(image, "drawable", getActivity().getPackageName());
//                    loadBackdrop(id_image);
                    collapsingToolbar.setTitle(dataSnapshot.child(Chung.tenxe).getValue(String.class));

//                    ll_giadamphan.setVisibility(View.GONE);

                    gianiemyet.setText(Chung.stand_string(dataSnapshot.child(getString(R.string.gianiemyet) ).getValue(String.class)) + " triệu");
                    giadanphan.setText(Chung.stand_string(dataSnapshot.child(getString(R.string.giadamphan)).getValue(String.class)) + " triệu");
                    nguongoc.setText(dataSnapshot.child(getString(R.string.nguongoc)).getValue(String.class));
                    loaixe.setText(dataSnapshot.child(getString(R.string.loaixe)).getValue(String.class));
//                    quote.setText(dataSnapshot.child(Chung.loaixe).getValue(String.class));


                    setDongcokhungxe(dataSnapshot.child("dongcokhungxe"));
                    setNgoaithat(dataSnapshot.child("ngoaithat"));
                    setNoithat(dataSnapshot.child("noithat"));
                    setTiennghi(dataSnapshot.child("tiennghi"));
                    setAntoan(dataSnapshot.child("antoan"));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
//        if (dummyItem != null) {
//            loadBackdrop();
//            collapsingToolbar.setTitle(dummyItem.title);
//            author.setText(dummyItem.author);
//            quote.setText(dummyItem.content);
//        }

        return rootView;
    }

    private View inflateAndBind(LayoutInflater inflater, ViewGroup container, int fragment_article_detail) {
        return inflateAndBind(inflater,container,fragment_article_detail);
    }

    void setImage(StorageReference storageReference){
        final long ONE_MEGABYTE = 1024 * 1024;
        storageReference.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                backdropImg.setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                backdropImg.setImageResource(R.drawable.ic_car_3d_yellow);
            }
        });
    }

    @Bind(R.id.dairongcao) TextView dairongcao;
    @Bind(R.id.dungtichbinhxang) TextView dungtichbinhxang;
    @Bind(R.id.dongco) TextView dongco;
    @Bind(R.id.congxuat) TextView congxuat;
    @Bind(R.id.moment) TextView moment;
    @Bind(R.id.khoangsanggam) TextView khoangsanggam;
    @Bind(R.id.duongkinhvongquaytoithieu) TextView duongkinhvongquaytoithieu;
    @Bind(R.id.hopso) TextView hopso;
    @Bind(R.id.muctieuthunhienlieu) TextView muctieuthunhienlieu;        @Bind(R.id.ll_muctieuthunhienlieu) LinearLayout ll_muctieuthunhienlieu;
    void setDongcokhungxe(DataSnapshot dataSnapshot){
        dairongcao.setText(dataSnapshot.child(getString(R.string.dairongcao)).getValue(String.class));
        dungtichbinhxang.setText(dataSnapshot.child(getString(R.string.dungtichbinhxang)).getValue(String.class));
        dongco.setText(dataSnapshot.child(getString(R.string.dongco)).getValue(String.class));
        congxuat.setText(dataSnapshot.child(getString(R.string.congxuat)).getValue(String.class));
        moment.setText(dataSnapshot.child(getString(R.string.moment)).getValue(String.class));
        khoangsanggam.setText(dataSnapshot.child(getString(R.string.khoangsanggam)).getValue(String.class));
        duongkinhvongquaytoithieu.setText(dataSnapshot.child(getString(R.string.duongkinhvongquaytoithieu)).getValue(String.class));
        hopso.setText(dataSnapshot.child(getString(R.string.hopso)).getValue(String.class));
        if (dataSnapshot.hasChild(getString(R.string.muctieuthunhienlieu))){
            muctieuthunhienlieu.setText(dataSnapshot.child(getString(R.string.muctieuthunhienlieu)).getValue(String.class));
        } else {
            ll_muctieuthunhienlieu.setVisibility(View.GONE);
        }
//        muctieuthunhienlieu.setText(dataSnapshot.child(getString(R.string.muctieuthunhienlieu)).getValue(String.class));
    }

    @Bind(R.id.ngoaithat) TextView ngoaithat;
    @Bind(R.id.denpha) TextView denpha;     @Bind(R.id.ll_denpha) LinearLayout ll_denpha;
    void setNgoaithat(DataSnapshot dataSnapshot){
        List<String> result = new ArrayList<>();
        for (DataSnapshot snapshot : dataSnapshot.getChildren()){
            if (snapshot.getValue(String.class).equals(getString(R.string.co))){
                String string = snapshot.getKey();
                string = string.replace(" :", "");
                string = "  - " + string;
                result.add(string);
            }
        }
        ngoaithat.setText(TextUtils.join("\n", result));

        if (dataSnapshot.hasChild(getString(R.string.denpha))){
            denpha.setText(dataSnapshot.child(getString(R.string.denpha)).getValue(String.class));
        } else {
            ll_denpha.setVisibility(View.GONE);
        }
    }

    @Bind(R.id.noithat) TextView noithat;
    @Bind(R.id.chatlieunoithat) TextView chatlieunoithat;       @Bind(R.id.ll_chatlieunoithat) LinearLayout ll_chatlieunoithat;
    @Bind(R.id.dieuhoa) TextView dieuhoa;                       @Bind(R.id.ll_dieuhoa) LinearLayout ll_dieuhoa;
    @Bind(R.id.ghelai) TextView ghelai;                         @Bind(R.id.ll_ghelai) LinearLayout ll_ghelai;
    @Bind(R.id.ghemassage) TextView ghemassage;                 @Bind(R.id.ll_ghemassage) LinearLayout ll_ghemassage;
    @Bind(R.id.cuakinhghelai) TextView cuakinhghelai;                 @Bind(R.id.ll_cuakinhghelai) LinearLayout ll_cuakinhghelai;
    @Bind(R.id.hethongloa) TextView hethongloa;                 @Bind(R.id.ll_hethongloa) LinearLayout ll_hethongloa;
    @Bind(R.id.cansangsotrenvolang) TextView cansangsotrenvolang;                 @Bind(R.id.ll_cansangsotrenvolang) LinearLayout ll_cansangsotrenvolang;
    @Bind(R.id.hienthithongtintrenkinhlai) TextView hienthithongtintrenkinhlai;                 @Bind(R.id.ll_hienthithongtintrenkinhlai) LinearLayout ll_hienthithongtintrenkinhlai;
    void setNoithat(DataSnapshot dataSnapshot){
        List<String> result = new ArrayList<>();
        for (DataSnapshot snapshot : dataSnapshot.getChildren()){
            if (snapshot.getValue(String.class).equals(getString(R.string.co))){
                String string = snapshot.getKey();
                string = string.replace(" :", "");
                string = "  - " + string;
                result.add(string);
            }
        }
        noithat.setText(TextUtils.join("\n", result));
        if (dataSnapshot.hasChild(getString(R.string.chatlieunoithat))){
            chatlieunoithat.setText(dataSnapshot.child(getString(R.string.chatlieunoithat)).getValue(String.class));
        } else {
            ll_chatlieunoithat.setVisibility(View.GONE);
        }
        if (dataSnapshot.hasChild(getString(R.string.dieuhoa))){
            dieuhoa.setText(dataSnapshot.child(getString(R.string.dieuhoa)).getValue(String.class));
        } else {
            ll_dieuhoa.setVisibility(View.GONE);
        }
        if (dataSnapshot.hasChild(getString(R.string.ghelai))){
            ghelai.setText(dataSnapshot.child(getString(R.string.ghelai)).getValue(String.class));
        } else {
            ll_ghelai.setVisibility(View.GONE);
        }
        if (dataSnapshot.hasChild(getString(R.string.ghemassage))){
            ghemassage.setText(dataSnapshot.child(getString(R.string.ghemassage)).getValue(String.class));
        } else {
            ll_ghemassage.setVisibility(View.GONE);
        }
        if (dataSnapshot.hasChild(getString(R.string.cuakinhghelai))){
            cuakinhghelai.setText(dataSnapshot.child(getString(R.string.cuakinhghelai)).getValue(String.class));
        } else {
            ll_cuakinhghelai.setVisibility(View.GONE);
        }
        if (dataSnapshot.hasChild(getString(R.string.hethongloa))){
            hethongloa.setText(dataSnapshot.child(getString(R.string.hethongloa)).getValue(String.class));
        } else {
            ll_hethongloa.setVisibility(View.GONE);
        }
        if (dataSnapshot.hasChild(getString(R.string.cansangsotrenvolang))){
            cansangsotrenvolang.setText(dataSnapshot.child(getString(R.string.cansangsotrenvolang)).getValue(String.class));
        } else {
            ll_cansangsotrenvolang.setVisibility(View.GONE);
        }
        if (dataSnapshot.hasChild(getString(R.string.hienthithongtintrenkinhlai))){
            hienthithongtintrenkinhlai.setText(dataSnapshot.child(getString(R.string.hienthithongtintrenkinhlai)).getValue(String.class));
        } else {
            ll_hienthithongtintrenkinhlai.setVisibility(View.GONE);
        }
    }

    @Bind(R.id.tiennghi) TextView tiennghi;
//    @Bind(R.id.denpha) TextView denpha;     @Bind(R.id.ll_denpha) LinearLayout ll_denpha;
    void setTiennghi(DataSnapshot dataSnapshot){
        List<String> result = new ArrayList<>();
        for (DataSnapshot snapshot : dataSnapshot.getChildren()){
            if (snapshot.getValue(String.class).equals(getString(R.string.co))){
                String string = snapshot.getKey();
                string = string.replace(" :", "");
                string = "  - " + string;
                result.add(string);
            }
        }
        tiennghi.setText(TextUtils.join("\n", result));

//        if (dataSnapshot.hasChild(getString(R.string.denpha))){
//            denpha.setText(dataSnapshot.child(getString(R.string.denpha)).getValue(String.class));
//        } else {
//            ll_denpha.setVisibility(View.GONE);
//        }
    }

    @Bind(R.id.antoan) TextView antoan;
    @Bind(R.id.tuikhi) TextView tuikhi;     @Bind(R.id.ll_tuikhi) LinearLayout ll_tuikhi;
    void setAntoan(DataSnapshot dataSnapshot){
        List<String> result = new ArrayList<>();
        for (DataSnapshot snapshot : dataSnapshot.getChildren()){
            if (snapshot.getValue(String.class).equals(getString(R.string.co))){
                String string = snapshot.getKey();
                string = string.replace(" :", "");
                string = "  - " + string;
                result.add(string);
            }
        }
        antoan.setText(TextUtils.join("\n", result));

        if (dataSnapshot.hasChild(getString(R.string.tuikhi))){
            tuikhi.setText(dataSnapshot.child(getString(R.string.tuikhi)).getValue(String.class));
        } else {
            ll_tuikhi.setVisibility(View.GONE);
        }
    }
    private void loadBackdrop(int id_image) {
        Glide.with(this).load(id_image).centerCrop().into(backdropImg);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_drawer, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_settings:
//                // your logic
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    public static ArticleDetailFragment newInstance(String itemID) {
        ArticleDetailFragment fragment = new ArticleDetailFragment();
        Bundle args = new Bundle();
        args.putString(ArticleDetailFragment.ARG_ITEM_ID, itemID);
        fragment.setArguments(args);
        return fragment;
    }

    public ArticleDetailFragment() {}
}

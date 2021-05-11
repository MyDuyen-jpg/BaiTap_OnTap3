package com.myduyen.ontap3;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnClickListener, TextWatcher {
    private RecyclerView rcv_cloth;
     ArrayList<Cloth> mCloths;
    private TextView tvSearch;
    CustomAdapterCloth adt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv_cloth = findViewById(R.id.rcv_cloth);
        tvSearch = findViewById(R.id.tvSearch);
        tvSearch.addTextChangedListener(this);
        mCloths= new ArrayList<>();

        mCloths.add(new Cloth(R.drawable.code,"Android Studio",10,R.drawable.
                android_mobile_app_developer,1,"S"));
        mCloths.add(new Cloth(R.drawable.computer,"Best seller",20
                ,R.drawable.android_software_developer
                ,1,"S"));
        mCloths.add(new Cloth(R.drawable.computer_engineer,"Google 3",30
                ,R.drawable.computer_engineer_mens_sport,1,"S"));
        mCloths.add(new Cloth(R.drawable.computer_o2,"Dev Google Analysis",60
                ,R.drawable.custom_tshirt_1,1,"S"));
        mCloths.add(new Cloth(R.drawable.a_teveloper_tester_can_never_be_friend,"Studio 5",100
                ,R.drawable.dev,1,"S"));
        mCloths.add(new Cloth(R.drawable.google,"Computer 100",50
                ,R.drawable.downloadabc
                ,1,"S"));

        adt = new CustomAdapterCloth(mCloths,this);
        rcv_cloth.setHasFixedSize(true);
        rcv_cloth.setAdapter(adt);
        rcv_cloth.setLayoutManager(new GridLayoutManager(this,2));

    }

    @Override
    public void itemClick(Cloth cloth) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent
                .putExtra("key1",cloth);
        startActivity(intent);

    }

    @Override
    public void onPlus(int position) {

    }

    @Override
    public void onMinus(int position) {

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        filter(s.toString());
    }

    private void filter(String toString) {
        ArrayList<Cloth> cloths = new ArrayList<>();
        for (Cloth c:mCloths){
            if (c.getName().toLowerCase().contains(toString.toLowerCase()) || (c.getPrice()+"").toLowerCase().contains(toString.toLowerCase())){
                cloths.add(c);
            }
        }
        adt.filterList(cloths);
    }
}
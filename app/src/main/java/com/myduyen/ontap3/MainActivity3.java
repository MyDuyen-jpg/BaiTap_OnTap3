package com.myduyen.ontap3;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity3 extends AppCompatActivity implements OnClickListener {
    private RecyclerView rcv_bag;
    private CustomAdapterBaggggg adt;
    TextView tvSub,tvTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        rcv_bag = findViewById(R.id.rcv_bag);

        tvSub = findViewById(R.id.tvSub);
        tvTotal = findViewById(R.id.tvTotal);

        tvSub.setText(MainActivity2.tong+"");
        tvTotal.setText(MainActivity2.tong+"");

        adt = new CustomAdapterBaggggg(MainActivity2.arrCloth,this);
        rcv_bag.setHasFixedSize(true);
        rcv_bag.setAdapter(adt);
        rcv_bag.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }

    @Override
    public void itemClick(Cloth cloth) {

    }

    @Override
    public void onPlus(int position) {
        int soLuong = MainActivity2.arrCloth.get(position).getSoLuong()+1;
        MainActivity2.arrCloth.get(position).setSoLuong(soLuong);

        MainActivity2.tong = 0;
        for(Cloth c: MainActivity2.arrCloth){
           MainActivity2.tong+= c.getPrice()*c.getSoLuong();
        }

        tvSub.setText(MainActivity2.tong+"");
        tvTotal.setText(MainActivity2.tong+"");

        adt = new CustomAdapterBaggggg(MainActivity2.arrCloth,this);
        rcv_bag.setHasFixedSize(true);
        rcv_bag.setAdapter(adt);
        rcv_bag.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));


    }

    @Override
    public void onMinus(int position) {
        int soLuong = MainActivity2.arrCloth.get(position).getSoLuong();
        if (soLuong !=1){
            soLuong--;
            MainActivity2.arrCloth.get(position).setSoLuong(soLuong);

            MainActivity2.tong = 0;
            for(Cloth c: MainActivity2.arrCloth){
                MainActivity2.tong+= c.getPrice()*c.getSoLuong();
            }

            tvSub.setText(MainActivity2.tong+"");
            tvTotal.setText(MainActivity2.tong+"");

            adt = new CustomAdapterBaggggg(MainActivity2.arrCloth,this);
            rcv_bag.setHasFixedSize(true);
            rcv_bag.setAdapter(adt);
            rcv_bag.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        }

    }
}
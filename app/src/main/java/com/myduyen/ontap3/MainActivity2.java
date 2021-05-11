package com.myduyen.ontap3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ImageView imgClothDt;
    TextView tvNameDt,tvPriceDt,tvSoDt;
    ImageButton imgbtn_plusDt,imgbtn_minusDt;
    Button btnS,btnM,btnL,btnX,btn_addtocart;
    Cloth mCloth;
    static ArrayList<Cloth> arrCloth;
    static int tong;
    static{
        tong = 0;
        arrCloth = new ArrayList<>();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn_addtocart=  findViewById(R.id.btn_addtocart);
        imgClothDt=  findViewById(R.id.imgCLothDt);
        tvNameDt=  findViewById(R.id.tvNameDt);
        tvPriceDt=  findViewById(R.id.tvPriceDt);
        tvSoDt=  findViewById(R.id.tvSoDt);
        imgbtn_plusDt=  findViewById(R.id.imgbtn_plusDt);
        imgbtn_minusDt=  findViewById(R.id.imgbtn_minusDt);
        btnS=  findViewById(R.id.btnS);
        btnM=  findViewById(R.id.btnM);
        btnL=  findViewById(R.id.btnL);
        btnX=  findViewById(R.id.btnX);

        btnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCloth.setSize("L");
            }
        });
        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCloth.setSize("S");
            }
        });
        btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCloth.setSize("X");
            }
        });
        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCloth.setSize("M");
            }
        });

        Intent intent = getIntent();
        if (intent!= null){
            mCloth = (Cloth) intent.getSerializableExtra("key1");
            imgClothDt.setImageResource(mCloth.getAnhNguoi());
            tvNameDt.setText(mCloth.getName());
            tvPriceDt.setText(mCloth.getPrice()+"");
        }
        imgbtn_plusDt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSoDt.setText(mCloth.getSoLuong()+1+"");
                mCloth.setSoLuong(mCloth.getSoLuong()+1);
            }
        });
        imgbtn_minusDt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCloth.getSoLuong()!=1){
                    tvSoDt.setText(mCloth.getSoLuong()-1+"");
                    mCloth.setSoLuong(mCloth.getSoLuong()-1);
                }

            }
        });
        btn_addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=  new Intent(MainActivity2.this,MainActivity3.class);
                arrCloth.add(mCloth);
                tong = 0;
                for(Cloth c:arrCloth){
                    tong+= c.getPrice()*c.getSoLuong();
                }
                startActivity(intent1);
            }
        });

    }
}
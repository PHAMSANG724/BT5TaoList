package com.example.bt5taolist_phamsang_1811505310437;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvKR;
    ArrayList<KamenRider> arrayKR;
    KamenRiderAdaper adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        adapter = new KamenRiderAdaper(this, R.layout.dong_kr, arrayKR);
        lvKR.setAdapter(adapter);

        lvKR.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, Detail.class);
                startActivity(intent);
            }
        });

        lvKR.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                XacNhanXoa(i);
                return true;
            }
        });
    }

    private void AnhXa() {
        lvKR = (ListView) findViewById(R.id.listviewKamenRider);
        arrayKR = new ArrayList<>();

        arrayKR.add(new KamenRider("Kamen Rider W", "Kamen Rider W(ダブル) lần đầu xuất hiện năm 2010", R.drawable.krw));
        arrayKR.add(new KamenRider("Kamen Rider Zio", "Kamen Rider Zio(ジオウ) lần đầu xuất hiện năm 2018", R.drawable.zio));
        arrayKR.add(new KamenRider("Kamen Rider Ex-aid", "Kamen Rider Ex-aid(エグゼイド) lần đầu xuất hiện năm 2016", R.drawable.exaid));
        arrayKR.add(new KamenRider("Kamen Rider Build", "Kamen Rider Build(ビルド) lần đầu xuất hiện năm 2017", R.drawable.build));
        arrayKR.add(new KamenRider("Kamen Rider Decade", "Kamen Rider Decade(ディケイド) lần đầu xuất hiện năm 2009", R.drawable.decade));
    }

    public void XacNhanXoa(int position){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Cảnh báo!!");
        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.setMessage("Bạn không thích Kamen Rider này??");

        alertDialog.setPositiveButton("Ừm, đúng vậy!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                arrayKR.remove(position);
                adapter.notifyDataSetChanged();
            }
        });

        alertDialog.setNegativeButton("Nhầm tí thôi!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        alertDialog.show();
    }
}
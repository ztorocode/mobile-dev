package com.example.buahsayur;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailBuahActivity extends ActionBarActivity {
	private ImageView ivBuah, ivBack;
	private TextView tvNamaBuah;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_buah);
		//ambil nama buah yang dikirim dari halaman sebelumnya
		//dengan key "buah"
		String nama = getIntent().getExtras().getString("buah");
		//ambil gambar sesuai dengan namanya
		Drawable image = getImage(nama);
		
		//set Gambar sesuai dengan nama buahnya
		ivBuah = (ImageView) findViewById(R.id.ivBuah);
		ivBuah.setImageDrawable(image);
		
		tvNamaBuah = (TextView) findViewById(R.id.tvNamaBuah);
		//memasukkan nama buah kedalam textview
		tvNamaBuah.setText(nama);
		
		//event saat tombol back diklik
		ivBack = (ImageView) findViewById(R.id.ivBack);
		ivBack.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				//pindah kehalaman listBuah
				Intent i = new Intent(getBaseContext(), 
						ListBuahActivity.class);
				startActivity(i);
				
			}
		});
	}
	
	//fungsi untuk mengambil gambar buah yang ada difolder drawable
	public Drawable getImage(String name) {
	    return getResources().getDrawable(
	            getResources().getIdentifier(name, "drawable",
	                    getPackageName()));
	}

}

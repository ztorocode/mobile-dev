package com.example.buahsayur;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailSayuranActivity extends Activity {

	private ImageView ivSayur, ivBack;
	private TextView tvNamaSayur;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_sayuran);

		String nama = getIntent().getExtras().getString("sayuran");
		Drawable image = getImage(nama);
		
		//set Gambar sesuai dengan nama buahnya
		ivSayur = (ImageView) findViewById(R.id.ivSayuran);
		ivSayur.setImageDrawable(image);
		
		tvNamaSayur = (TextView) findViewById(R.id.tvNamaSayuran);
		tvNamaSayur.setText(nama);
		
		//event saat tombol back diklik
		ivBack = (ImageView) findViewById(R.id.ivBack);
		ivBack.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				Intent i = new Intent(getBaseContext(),
						ListSayuranActivity.class);
				startActivity(i);
				
			}
		});
	}
	
	public Drawable getImage(String name) {
	    return getResources().getDrawable(
	            getResources().getIdentifier(name, "drawable",
	                    getPackageName()));
	}
}


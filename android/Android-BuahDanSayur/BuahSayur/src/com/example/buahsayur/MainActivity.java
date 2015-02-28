package com.example.buahsayur;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;

public class MainActivity extends Activity {
	//untuk effect saat gambar diklik
	private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.3F);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		
	}
	
	public void mainMenu(View v) {
		//aktifkan efek klik dari imageview
		v.startAnimation(buttonClick);
		switch (v.getId()) {
		case R.id.ivMainBuah:
			//untuk berpindah ke halaman listbuah saat menu buah diklik
			startActivity(new Intent(getBaseContext(),
					ListBuahActivity.class));
			break;
		case R.id.ivMainSayuran:
			//untuk berpindah ke halaman listsayuran saat menu sayuran diklik
			startActivity(new Intent(getBaseContext(), 
					ListSayuranActivity.class));
			break;
		
		}

	}
	
}

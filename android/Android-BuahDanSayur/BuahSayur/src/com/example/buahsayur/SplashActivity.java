package com.example.buahsayur;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_splash);

		//untuk menampilkan halaman splas selama 3 detik
		final Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			public void run() {
				// berpindah kemenu utama setelah 3 detik
				startActivity(new Intent(getBaseContext(), MainActivity.class));

			}
		}, 3000L);

	}

	public void onConfigurationChanged(Configuration newConfig) {
		// Manages auto rotation for the Splash Screen Layout
		super.onConfigurationChanged(newConfig);
		setContentView(R.layout.activity_splash);
	}
}
package id.creatorb.simplemurottal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends Activity{
	
	//set durasi loading splash, hold selama 10 detik
	private	 final int DURASI_SPLASH = 10000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		//new handler untuk memulai activity berikutnya
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				//intent untuk berpindah menuju activity selanjutnya
				Intent be = new Intent(Splash.this, MainActivity.class);
				startActivity(be);
				//tutup activity setelah berjalan
				finish();
				
			}
		}, DURASI_SPLASH);
	}
}

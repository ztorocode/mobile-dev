package imagegalerry.creatorb.id.androidimagegallery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class Splash extends Activity {

    //set durasi selama 3 detik
    private final int SPLASH_DURATION = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        //buat handler baru untuk memulai activity selanjutnya
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //pasang intent untuk menuju activity selanjutnya
                Intent next = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(next);
                //akhiri activity splash
                finish();
            }
        }, SPLASH_DURATION);

    }


}

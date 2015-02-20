package id.creatorb.login;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class Splashscreen extends Activity {
	 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
          
// cara pertama 
         
         /****** buat thread untuk sleep selama 5 detik *************/        
        Thread background = new Thread() {
            public void run() {
                 
                try {
                    // parameter sleep timer untuk ke hold selama 3 detik
                    sleep(3*1000);
                     
                    // setelah 3 detik maka buat intent untuk menuju activity selanjutnya
                    Intent creatorb =new Intent(getBaseContext(),MainActivity.class);
                    startActivity(creatorb);
                     
                    //parameter untuk menghapus activity splashscreen
                    finish();
                     
                } catch (Exception e) {
                 
                }
            }
        };
         
        // start thread
        background.start();
         
//cara kedua 
         
        /*
        new Handler().postDelayed(new Runnable() {
              
            // memakai handler dengan postDelayed untuk memanggil method secara runnable
  
            @Override
            public void run() {
                Intent i = new Intent(MainSplashScreen.this, FirstScreen.class);
                startActivity(i);
  
                // akhiri splashscreen activity
                finish();
            }
        }, 5*1000); // hold selama  5 detik
        */
    }
     
    @Override
    protected void onDestroy() {
         
        super.onDestroy();
         
    }
}
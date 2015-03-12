package id.creatorb.simplemurottal;

import java.io.IOException;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button i, f, n;
	private MediaPlayer mp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		//deklarasi
		
		//surat al ikhlas
		i = (Button)findViewById(R.id.i);
		i.setOnClickListener(this);
		//surat al falaq
		f = (Button)findViewById(R.id.f);
		f.setOnClickListener(this);
		//surat An - naas
		n = (Button)findViewById(R.id.n);
		n.setOnClickListener(this);	
	}

	@Override
	public void onClick(View v) {
		// penyesuaian id button dengan mp3 yang akan dijalankan
		if(v.getId()==R.id.i){
			putar("i.mp3");
		}
		else if (v.getId()==R.id.f){
			putar("f.mp3");
		}
		else if(v.getId()==R.id.n){
			putar("n.mp3");
		}
	}

	private void putar(String Murottal) {
		Boolean murottalStatus=false;
		
		//cek murottal status
		try{
			murottalStatus=mp.isPlaying();
		}
		catch (Exception b){
			murottalStatus=false;
		}
		//jika status mp3 murottal dalam keadaan berjalan
		if (murottalStatus==true){
			//maka hentikan mediaplayer
			mp.stop();
			//dan hapus dari memory
			mp.release();
		}
		else {
			try{
				mp = new MediaPlayer();
				AssetFileDescriptor M = getAssets().openFd(Murottal);
				//set source murottal
				
			mp.setDataSource(M.getFileDescriptor(), M.getStartOffset(), M.getLength());
			mp.prepare(); //siapkan untuk playback
			mp.start(); // putar murottal
			M.close(); // file descriptor
			}
			catch(IOException b){
				//cek error debug
				Log.i("Error Murottal: ", b.toString());
			}
		}
		
	}
}

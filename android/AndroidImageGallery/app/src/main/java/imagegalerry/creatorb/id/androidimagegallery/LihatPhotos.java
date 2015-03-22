package imagegalerry.creatorb.id.androidimagegallery;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by creatorbe on 3/22/15.
 */
public class LihatPhotos extends Activity {
    //Deklarasi Variabel
    TextView titles;
    ImageView photos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lihat_photos);

        //menerima data dari MainActivity ketika mengklik item grid
        Intent b = getIntent();

        //get posisi
        int position = b.getExtras().getInt("position");

        //get string array path
        String[] filepath = b.getStringArrayExtra("filepath");

        //get string array name
        String[] filename = b.getStringArrayExtra("filename");

        //locate textview di lihat_photos
        titles = (TextView) findViewById(R.id.full_text);

        //parsing text ke textview sesuai posisi
        titles.setText(filename[position]);

        //locate imageview di lihat_photos
        photos = (ImageView) findViewById(R.id.full_photos);

        //decode bmp sesuai posisi
        Bitmap bmp = BitmapFactory.decodeFile(filepath[position]);

        //set decoded ke imageview
        photos.setImageBitmap(bmp);
    }
}

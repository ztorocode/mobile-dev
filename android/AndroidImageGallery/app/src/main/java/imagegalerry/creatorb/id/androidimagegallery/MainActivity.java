package imagegalerry.creatorb.id.androidimagegallery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.io.File;


public class MainActivity extends Activity {

    // deklarasikan variabel
    private String[] FilePathStrings;
    private  String [] FileNameStrings;
    private  File[] listFile;
    GridView grid;
    GridViewAdapter adapter;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //pertama cek sdcard terlebih dahulu
        if(!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            Toast.makeText(this, "Masukan kartu memori", Toast.LENGTH_LONG)
                    .show();
        }else {
            //set lokasi folder photos di sdcard
            file = new File(Environment.getExternalStorageDirectory() + File.separator + "Pictures");
            //jika folder Pictures tidak ada maka buat folder Pictures
            file.mkdirs();
        }

        if (file.isDirectory()){
            listFile = file.listFiles();
            //buat array string utk path
            FilePathStrings = new String[listFile.length];
            //buat array string utk nama file
            FileNameStrings = new String[listFile.length];

            for (int b = 0; b < listFile.length; b++){
                //get path dari photos
                FilePathStrings[b] = listFile[b].getAbsolutePath();
                //get nama photos
                FileNameStrings[b] = listFile[b].getName();
            }
        }

        //locate gridview
        android.widget.GridView grid = (android.widget.GridView) findViewById(R.id.gridview);
        //masukkan string dalam array pada class GridViewAdapter
        adapter = new GridViewAdapter(this, FilePathStrings, FileNameStrings);
        //set LA ke gridview
        grid.setAdapter(adapter);

        //gridview select/item clicked
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent b = new Intent(MainActivity.this, LihatPhotos.class);

                b.putExtra("filepath",FilePathStrings);
                b.putExtra("filename",FileNameStrings);
                b.putExtra("position", position);
                startActivity(b);
            }
        });

    }
}

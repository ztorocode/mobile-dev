package imagegalerry.creatorb.id.androidimagegallery;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.StaticLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;
import java.util.Vector;

/**
 * Created by creatorbe on 3/22/15.
 */
public class GridViewAdapter extends BaseAdapter{

    //deklarasikan variabel
    private Activity activity;
    private String[] filepath;
    private String[] filename;

    private static LayoutInflater inflater = null;

    public GridViewAdapter(Activity b, String[] fpath, String[] fname){
        activity = b;
        filepath = fpath;
        filename = fname;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount(){
        return filepath.length;
    }

    public Object getItem(int position){
        return position;
    }

    public long getItemId(int position){
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View vi = convertView;
        if (convertView == null)
            vi = inflater.inflate(R.layout.grid_item, null);
        //locate bbrapa palette di layout grid_item
        //tampilkan title
//        TextView titles = (TextView) vi.findViewById(R.id.titles);
        //tampilkan gambar
        ImageView photos = (ImageView) vi.findViewById(R.id.photos);

        //settext by position
//        titles.setText(filename[position]);

        //decode filepath dg bitmapfactory by position
        Bitmap bmp = BitmapFactory.decodeFile(filepath[position]);

        //set result to imageview
        photos.setImageBitmap(bmp);
        return vi;
    }
}

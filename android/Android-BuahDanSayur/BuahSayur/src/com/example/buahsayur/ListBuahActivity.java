package com.example.buahsayur;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListBuahActivity extends Activity {
	private ListView lvBuah;
	//array data buah-buahan
	private String namaBuah[] = { "apel", "anggur", "jeruk", "lemon", 
			"nanas", "pisang", "semangka", "strawbery"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_buah);

		lvBuah = (ListView) findViewById(R.id.lvListBuah);
		
		//buat adapter untuk  listview
		ArrayAdapter adapter = new ArrayAdapter(getBaseContext(), 
				android.R.layout.simple_list_item_1, namaBuah);
		lvBuah.setAdapter(adapter);
		
		//untuk menangkat event saat listview diklik
		lvBuah.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View view, 
					int posisi, long arg3) {
				//ambil nama buah berdasarkan posisi listview yg diklik
				String buah = namaBuah[posisi];
				
				//siapkan intent untuk berpindah halaman
				Intent i = new Intent(getBaseContext(), 
						DetailBuahActivity.class);
				//attach nama buah yg dipilih
				//dengan key "buah"
				i.putExtra("buah", buah);
				startActivity(i);
				
			}
		});
	}

	
}

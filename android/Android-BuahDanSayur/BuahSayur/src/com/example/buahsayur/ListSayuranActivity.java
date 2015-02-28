package com.example.buahsayur;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class ListSayuranActivity extends Activity {

	private ListView lvSayuran;
	private String namaSayuran[] = { "bawang", "brokoli", "kentang", 
			"mentimun", "paprika", "terong", "tomat", "wortel"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_sayuran);

		lvSayuran = (ListView) findViewById(R.id.lvListSayuran);
		
		//buat adapter untuk  listview
		ArrayAdapter adapter = new ArrayAdapter(getBaseContext(), 
				android.R.layout.simple_list_item_1, namaSayuran);
		lvSayuran.setAdapter(adapter);
		
		//untuk menangkat event saat listview diklik
		lvSayuran.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, 
					View view, int posisi, long arg3) {
				String buah = namaSayuran[posisi];
				
				Intent i = new Intent(getBaseContext(), 
						DetailSayuranActivity.class);
				i.putExtra("sayuran", buah);
				startActivity(i);
				
			}
		});
	}

}
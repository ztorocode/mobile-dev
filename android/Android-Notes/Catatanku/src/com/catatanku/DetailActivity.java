package com.catatanku;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends Activity {
	//variabel textview koneksi ke xml
	private TextView tvJudul, tvIsi, tvTanggal;
	private String judul, tanggal, isi;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		
		setupView();
		//ambil data judul, tanggal, dan isi yang dikirim 
		//dari halaman daftar catatan
		judul = getIntent().getExtras().getString("judul", "");
		tanggal = getIntent().getExtras().getString("tanggal", "");
		isi = getIntent().getExtras().getString("isi", "");
		
		//isi masing-masing textview sesuai datanya
		tvJudul.setText(judul);
		tvTanggal.setText(tanggal);
		tvIsi.setText(isi);
	}

	private void setupView() {
		tvJudul = (TextView) findViewById(R.id.tvJudul);
		tvTanggal = (TextView) findViewById(R.id.tvTanggal);
		tvIsi = (TextView) findViewById(R.id.tvIsi);
		
	}

}

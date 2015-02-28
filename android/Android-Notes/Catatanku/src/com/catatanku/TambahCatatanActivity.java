package com.catatanku;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.catatanku.helper.DBAdapter;
import com.catatanku.model.Catatan;

public class TambahCatatanActivity extends Activity {
	private EditText txtJudul, txtCatatan;
	private Button btnSimpan;
	private Spinner spWarna;

	private boolean isEdit = false;
	private int id = 0;
	//array pilihan warna yang tersedia
	private String[] warna = { "kuning", "merah", "biru", 
			"hijau", "Abu-Abu" };
	private int warnaDipilih;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tambah_catatan);
		//cek apakah statenya mengedit atau menambah data
		isEdit = getIntent().getExtras().getBoolean("edit", false);
		setupView();
	
		if (isEdit) {
			//jika edit maka ambil data yang akan diedit dan ditampilkan
			String judul = getIntent().getExtras().getString("judul");
			String isi = getIntent().getExtras().getString("isi");
			id = getIntent().getExtras().getInt("id");
			warnaDipilih = getIntent().getExtras().getInt("warna");

			txtJudul.setText(judul);
			txtCatatan.setText(isi);

			spWarna.setSelection(warnaDipilih);
		}
	}

	private void setupView() {
		txtJudul = (EditText) findViewById(R.id.txtJudul);
		txtCatatan = (EditText) findViewById(R.id.txtCatatan);
		btnSimpan = (Button) findViewById(R.id.btnSimpan);
		//event tombol submit diklik
		btnSimpan.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				simpan();
			}
		});

		spWarna = (Spinner) findViewById(R.id.spWarna);
		//buat adapter untuk spinner warna
		ArrayAdapter adapter = new ArrayAdapter(getBaseContext(),
				android.R.layout.simple_spinner_item, warna);
		adapter.setDropDownViewResource(android.R.layout.
				simple_spinner_dropdown_item);
		//masukkan adapter ke spinner
		spWarna.setAdapter(adapter);
		//event saat spinner dipilih
		spWarna.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int posisi, long arg3) {
				warnaDipilih = posisi;

			}

			public void onNothingSelected(AdapterView<?> arg0) {
				
			}
		});

	}

	protected void simpan() {
		//cek apakah sudah diisi judul catatan
		if (txtJudul.getText().toString().equalsIgnoreCase("")) {
			Toast.makeText(getBaseContext(), "Judul Harus Diisi",
					Toast.LENGTH_LONG).show();
			//cek apakah sudah diisi  catatannya
		} else if (txtCatatan.getText().toString().equalsIgnoreCase("")) {
			Toast.makeText(getBaseContext(), "Catatan Harus Diisi",
					Toast.LENGTH_LONG).show();
		} else {
			//buat object DBAdapter
			DBAdapter db = new DBAdapter(getBaseContext());
			//buka koneksi kedatabase
			db.open();
			//buat objek model data Catatan
			Catatan c = new Catatan();
			c.setTitle(txtJudul.getText().toString());
			c.setIsi(txtCatatan.getText().toString());
			c.setWarna(warnaDipilih);
			boolean hasil = false;
			if (isEdit) {
				//jika statenya edit maka update data
				hasil = db.updateData(c, id);
			} else {
				//sebaliknya jika tambah maka 
				//panggil method insertData
				hasil = db.insertData(c);
			}
			if (hasil) {
				//jika berhasil disimpan, buat notifikasi 
				//dan pindah ke halam list daftar
				Toast.makeText(getBaseContext(), "Catatan Berhasil Disimpan",
						Toast.LENGTH_LONG).show();
				startActivity(new Intent(getBaseContext(),
						DaftarCatatanActivity.class));
			} else {
				Toast.makeText(getBaseContext(),
						"Ooo, error simpan data. silahkan coba lagi.",
						Toast.LENGTH_LONG).show();
			}
			//tutup koneksi database
			db.close();
		}

	}

}

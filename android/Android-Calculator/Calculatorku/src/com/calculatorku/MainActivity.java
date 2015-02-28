package com.calculatorku;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	// variabel operator
	private Button btnTambah, btnKurang, btnKali, btnBagi, btnHitung, btnClear,
			btnPositifNegatif, btnMod;

	// variabel angka
	private Button btnNol, btnSatu, btnDua, btnTiga, btnEmpat, btnLima,
			btnEnam, btnTujuh, btnDelapan, btnSembilan, btnKoma;
	// variabel tampilan textview
	private TextView txtAngka;
	//untuk mengecek apakah yang diklik angka atau bukan
	private Boolean userKlikAngka = false;
	//mebuat objek dar kelas kalkulator
	private Kalkulator mKalkulator;
	//variabel untuk menentukan tombol apa saja yang termasuk angka
	private static final String ANGKA = "0123456789.";
	//variabel untuk kebutuhan format angka
	DecimalFormat formatDesimal = new DecimalFormat("@###########");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//memanggil layout yang akan digunakan yakni activity_main
		setContentView(R.layout.activity_main);
		
		//inisiasi objek kalkulator
		mKalkulator = new Kalkulator();
		//memberi nilai minimu, maksimum pada format angka
		formatDesimal.setMinimumFractionDigits(0);
		formatDesimal.setMinimumIntegerDigits(1);
		formatDesimal.setMaximumIntegerDigits(8);
		
		//panggil method untuk mengkonekkan komponen dengan activity
		setupView();
		
	}

	private void setupView() {
		txtAngka = (TextView) findViewById(R.id.txtAngka);

		btnTambah = (Button) findViewById(R.id.btnTambah);
		btnTambah.setOnClickListener(this);
		btnKurang = (Button) findViewById(R.id.btnKurang);
		btnKurang.setOnClickListener(this);
		btnBagi = (Button) findViewById(R.id.btnBagi);
		btnBagi.setOnClickListener(this);
		btnKali = (Button) findViewById(R.id.btnKali);
		btnKali.setOnClickListener(this);
		btnHitung = (Button) findViewById(R.id.btnHitung);
		btnHitung.setOnClickListener(this);
		btnClear = (Button) findViewById(R.id.btnClear);
		btnClear.setOnClickListener(this);
		btnPositifNegatif = (Button) findViewById(R.id.btnPositifNegatif);
		btnPositifNegatif.setOnClickListener(this);
		btnMod = (Button) findViewById(R.id.btnMod);
		btnMod.setOnClickListener(this);

		// koneksikan btnAngka yg ada di xml
		btnNol = (Button) findViewById(R.id.btnNol);
		btnNol.setOnClickListener(this);
		btnSatu = (Button) findViewById(R.id.btnSatu);
		btnSatu.setOnClickListener(this);
		btnDua = (Button) findViewById(R.id.btnDua);
		btnDua.setOnClickListener(this);
		btnTiga = (Button) findViewById(R.id.btnTiga);
		btnTiga.setOnClickListener(this);
		btnEmpat = (Button) findViewById(R.id.btnEmpat);
		btnEmpat.setOnClickListener(this);
		btnLima = (Button) findViewById(R.id.btnLima);
		btnLima.setOnClickListener(this);
		btnEnam = (Button) findViewById(R.id.btnEnam);
		btnEnam.setOnClickListener(this);
		btnTujuh = (Button) findViewById(R.id.btnTujuh);
		btnTujuh.setOnClickListener(this);
		btnDelapan = (Button) findViewById(R.id.btnDelapan);
		btnDelapan.setOnClickListener(this);
		btnSembilan = (Button) findViewById(R.id.btnSembilan);
		btnSembilan.setOnClickListener(this);
		btnKoma = (Button) findViewById(R.id.btnKoma);
		btnKoma.setOnClickListener(this);

	}

	public void onClick(View v) {
		String tombolKlik = ((Button) v).getText().toString();

		// cek tombol yang diklik apakah angka atau bukan
		if (ANGKA.contains(tombolKlik)) {
			// jika user mengklik angka
			if (userKlikAngka) {
				if (tombolKlik.equals(".")
						&& txtAngka.getText().toString().contains(".")) {
					// mencegah klik koma lebih dari satu kali
				} else {
					txtAngka.append(tombolKlik);
				}

			} else {

				if (tombolKlik.equals(".")) {
					// untuk mencegah koma didepan, ditambahkan angka nol
					txtAngka.setText(0 + tombolKlik);
				} else {
					txtAngka.setText(tombolKlik);
				}

				userKlikAngka = true;
			}

		} else if (tombolKlik.equals("+/-")
				&& !txtAngka.getText().toString().equals("")) {
			mKalkulator.togglePositif(Double.parseDouble(txtAngka.getText()
					.toString()));
			txtAngka.setText(formatDesimal.format(mKalkulator.getResult()));
		} else {
			// operator di klik
			if (userKlikAngka) {
				mKalkulator.setAngka(Double.parseDouble(txtAngka.getText()
						.toString()));
				userKlikAngka = false;
			}

			mKalkulator.operasiKalkulator(tombolKlik);
			txtAngka.setText(formatDesimal.format(mKalkulator.getResult()));

		}

	}

}

package com.catatanku.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.catatanku.model.Catatan;

public class DBAdapter {
	private static final String DB_NAMA = "catatan_db";
	private static final int DB_VER = 1;

	// tabel dan fieldcatatan
	public static final String TABEL_CATATAN = "catatan";
	public static final String IDCATATAN = "id_catatan";
	public static final String TITLE_CATATAN = "title";
	public static final String ISI_CATATAN = "isi";
	public static final String TANGGAL_CATATAN = "tanggal";
	public static final String WARNA_CATATAN = "warna";

	private static final String DB_CREATE_TABLE = "CREATE TABLE "
			+ TABEL_CATATAN + "(" + IDCATATAN + " integer primary key, "
			+ TITLE_CATATAN + " text not null, " + ISI_CATATAN
			+ " text not null, " + TANGGAL_CATATAN
			+ " text not null, " + WARNA_CATATAN
			+ " integer not null);";

	private String kolomCatatan[] = { IDCATATAN, TITLE_CATATAN, ISI_CATATAN,
			TANGGAL_CATATAN, WARNA_CATATAN };

	private SQLiteDatabase db;
	private DatabaseHelper dbHelper;
	private final Context context;

	public DBAdapter(Context context) {
		this.context = context;
	}

	public DBAdapter open() throws SQLException {
		dbHelper = new DatabaseHelper(context, DB_NAMA, DB_VER);
		db = dbHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		dbHelper.close();
	}

	// database operasi tabel catatan
	//untuk insert data
	public boolean insertData(Catatan catatan) {
		ContentValues cv = new ContentValues();
		cv.put(TITLE_CATATAN, catatan.getTitle());
		cv.put(ISI_CATATAN, catatan.getIsi());
		cv.put(TANGGAL_CATATAN, tglSekarang());
		cv.put(WARNA_CATATAN, catatan.getWarna());

		return db.insert(TABEL_CATATAN, null, cv) > 0;
	}
	//untuk delete data
	public boolean deleteData(int id) {
		return db.delete(TABEL_CATATAN, IDCATATAN + "=" + id, null) > 0;
	}
	//untuk mengambil seluruh data
	public Cursor getData() {
		return db.query(TABEL_CATATAN, kolomCatatan, null, null, null, null,
				IDCATATAN + " DESC");
	}
	//untuk mangambil data tertentu berdasarkan id
	public Cursor getDataById(int id) {
		Cursor cursor = db.query(TABEL_CATATAN, kolomCatatan, IDCATATAN + "="
				+ id, null, null, null, null);
		if (cursor != null) {
			cursor.moveToFirst();
		}
		return cursor;
	}
	//untuk update data
	public boolean updateData(Catatan catatan, int id) {
		ContentValues cv = new ContentValues();
		cv.put(TITLE_CATATAN, catatan.getTitle());
		cv.put(ISI_CATATAN, catatan.getIsi());
		cv.put(WARNA_CATATAN, catatan.getWarna());
		
		return db.update(TABEL_CATATAN, cv, IDCATATAN + "=" + id, null) > 0;
	}
	
	private String tglSekarang() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	// ------------------- end tabelcatatan ------------------------
	//inner class untuk membuat database
	private static class DatabaseHelper extends SQLiteOpenHelper {

		public DatabaseHelper(Context context, String name, int version) {
			super(context, DB_NAMA, null, DB_VER);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(DB_CREATE_TABLE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXISTS " + TABEL_CATATAN);
			onCreate(db);
		}

	}

}

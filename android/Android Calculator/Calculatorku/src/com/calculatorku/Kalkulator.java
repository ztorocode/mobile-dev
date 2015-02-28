package com.calculatorku;

public class Kalkulator {

	// 3 + 6 = 9
    // 3 & 6 are called the operand.
    // The + is called the operator.
    // 9 is the result of the operation.
    private double hasil;
    private double tempHasil;
    private String operatorKalkulator;
 
    // operator types
    public static final String TAMBAH = "+";
    public static final String KURANG = "-";
    public static final String KALI = "*";
    public static final String BAGI = "/"; 
    public static final String CLEAR = "C" ;
    public static final String MOD = "%" ;
    public static final String POSITIF = "+/-" ;
    
   
 
    // constructor
    public Kalkulator() {
        // inisiasi variable saat pertama kali class dibuat
        hasil = 0;
        tempHasil = 0;
        operatorKalkulator = "";
    }
 
    public void setAngka(double angka) {
        hasil = angka;
    }
    
    public void togglePositif(double angka){
    	hasil = angka;
    	hasil *= -1;
    }
 
    public double getResult() {
        return hasil;
    }
 
    public String toString() {
        return Double.toString(hasil);
    }
    
   
    protected double operasiKalkulator(String operator) {         
        if (operator.equals(CLEAR)) {
        	//jika yang ditekan tombol clear c maka set semua variabel ke nilai awal 0
            hasil = 0;
            operatorKalkulator = "";
            tempHasil = 0;
        } else {
        	//panggil operasi hitung
            hitung();
            operatorKalkulator = operator;
            tempHasil = hasil;
        } 
        return hasil;
    }
 
    protected void hitung() {
    	//hitung operasi kalkulator sesuai dengan operatornya
    	//hasilnya simpang di variabel hasil
        if (operatorKalkulator.equals(TAMBAH)) {
            hasil = tempHasil + hasil;
        } else if (operatorKalkulator.equals(KURANG)) {
            hasil = tempHasil - hasil;
        } else if (operatorKalkulator.equals(KALI)) {
            hasil = tempHasil * hasil;
        } else if (operatorKalkulator.equals(BAGI)) {
            if (hasil != 0) {
                hasil = tempHasil / hasil;
            }
        }else if(operatorKalkulator.equals(MOD)){
        	hasil = tempHasil % hasil;
        } 
    }

}

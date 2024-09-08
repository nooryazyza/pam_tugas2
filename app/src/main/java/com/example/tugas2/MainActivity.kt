package com.example.tugas2

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi View
        val edtNum1 = findViewById<EditText>(R.id.edt_num1)
        val edtNum2 = findViewById<EditText>(R.id.edt_num2)
        val rgOperasi = findViewById<RadioGroup>(R.id.rg_operasi)
        val btnHitung = findViewById<Button>(R.id.btn_hitung)

        btnHitung.setOnClickListener {
            // Mendapatkan input angka dari EditText
            val num1 = edtNum1.text.toString().toDoubleOrNull()
            val num2 = edtNum2.text.toString().toDoubleOrNull()

            // Validasi input
            if (num1 == null || num2 == null) {
                Toast.makeText(this, "Masukkan kedua angka dengan benar", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Mendapatkan operasi yang dipilih
            val selectedOperasi = when (rgOperasi.checkedRadioButtonId) {
                R.id.rb_tambah -> "+"
                R.id.rb_kurang -> "-"
                R.id.rb_kali -> "*"
                R.id.rb_bagi -> "/"
                else -> null
            }

            if (selectedOperasi == null) {
                Toast.makeText(this, "Pilih operasi perhitungan", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Lakukan perhitungan
            val hasil = when (selectedOperasi) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> if (num2 != 0.0) num1 / num2 else {
                    Toast.makeText(this, "Tidak bisa dibagi dengan nol", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                else -> 0.0
            }

            // Pindah ke activity hasil dan mengirim data
            val intent = Intent(this, HasilActivity::class.java)
            intent.putExtra(HasilActivity.EXTRA_HASIL, hasil.toString())
            intent.putExtra(HasilActivity.EXTRA_NIM, "225150401111026")
            intent.putExtra(HasilActivity.EXTRA_NAMA, "Noory Azyza")
            startActivity(intent)
        }
    }
}

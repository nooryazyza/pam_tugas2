package com.example.tugas2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HasilActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_HASIL = "hasil"
        const val EXTRA_NIM = "nim"
        const val EXTRA_NAMA = "nama"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil)

        val hasil = intent.getStringExtra(EXTRA_HASIL)
        val nim = intent.getStringExtra(EXTRA_NIM)
        val nama = intent.getStringExtra(EXTRA_NAMA)

        val tvHasil: TextView = findViewById(R.id.tv_hasil)
        val tvNim: TextView = findViewById(R.id.tv_nim)
        val tvNama: TextView = findViewById(R.id.tv_nama)

        tvHasil.text = hasil
        tvNim.text = nim
        tvNama.text = nama
    }
}
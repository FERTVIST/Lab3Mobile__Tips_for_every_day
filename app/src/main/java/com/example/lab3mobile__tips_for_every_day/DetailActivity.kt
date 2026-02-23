package com.example.lab3mobile__tips_for_every_day

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val toolbar: MaterialToolbar = findViewById(R.id.toolbarDetail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val dayNumber = intent.getIntExtra("day_number", 0)
        val titleResId = intent.getIntExtra("title_res_id", 0)
        val fullDescResId = intent.getIntExtra("full_desc_res_id", 0)
        val imageResId = intent.getIntExtra("image_res_id", 0)

        val textViewDayNumber: TextView = findViewById(R.id.textViewDetailDayNumber)
        val textViewTitle: TextView = findViewById(R.id.textViewDetailTitle)
        val imageViewDetail: ImageView = findViewById(R.id.imageViewDetail)
        val textViewFullQuote: TextView = findViewById(R.id.textViewDetailFullQuote)

        textViewDayNumber.text = "${getString(R.string.day_prefix)} $dayNumber"
        textViewTitle.setText(titleResId)
        imageViewDetail.setImageResource(imageResId)
        textViewFullQuote.setText(fullDescResId)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
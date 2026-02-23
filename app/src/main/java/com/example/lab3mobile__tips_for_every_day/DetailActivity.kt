package com.example.lab3mobile__tips_for_every_day

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.appbar.MaterialToolbar
import android.view.WindowManager

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(this, R.color.status_bar_color)
        }

        val toolbar: MaterialToolbar = findViewById(R.id.toolbarDetail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        val dayNumber = intent.getIntExtra("day_number", 0)
        val titleResId = intent.getIntExtra("title_res_id", 0)
        val fullDescResId = intent.getIntExtra("full_desc_res_id", 0)
        val imageResId = intent.getIntExtra("image_res_id", 0)

        val textViewDayNumber: TextView = findViewById(R.id.textViewDetailDayNumber)
        val textViewTitle: TextView = findViewById(R.id.textViewDetailTitle)
        val imageViewDetail: ImageView = findViewById(R.id.imageViewDetail)
        val textViewFullQuote: TextView = findViewById(R.id.textViewDetailFullQuote)
        val backContainer: LinearLayout = findViewById(R.id.backContainer)

        textViewDayNumber.text = "${getString(R.string.day_prefix)} $dayNumber"
        textViewTitle.setText(titleResId)
        imageViewDetail.setImageResource(imageResId)
        textViewFullQuote.setText(fullDescResId)

        backContainer.setOnClickListener {
            finish()
        }
    }
}
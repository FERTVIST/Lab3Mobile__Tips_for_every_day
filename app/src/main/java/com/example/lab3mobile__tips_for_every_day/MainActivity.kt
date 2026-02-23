package com.example.lab3mobile__tips_for_every_day

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.WindowManager

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: QuoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(this, R.color.status_bar_color)
        }

        recyclerView = findViewById(R.id.recyclerViewQuotes)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val quotes = generateQuotes()

        adapter = QuoteAdapter(
            quotes = quotes,
            onItemClick = { quote ->
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("day_number", quote.dayNumber)
                intent.putExtra("title_res_id", quote.titleResId)
                intent.putExtra("short_desc_res_id", quote.shortDescriptionResId)
                intent.putExtra("full_desc_res_id", quote.fullDescriptionResId)
                intent.putExtra("image_res_id", quote.imageResId)
                startActivity(intent)
            }
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun generateQuotes(): List<Quote> {
        return listOf(
            Quote(1, R.string.day_1_title, R.string.day_1_short, R.string.day_1_full, R.drawable.img1),
            Quote(2, R.string.day_2_title, R.string.day_2_short, R.string.day_2_full, R.drawable.img2),
            Quote(3, R.string.day_3_title, R.string.day_3_short, R.string.day_3_full, R.drawable.img3),
            Quote(4, R.string.day_4_title, R.string.day_4_short, R.string.day_4_full, R.drawable.img4),
            Quote(5, R.string.day_5_title, R.string.day_5_short, R.string.day_5_full, R.drawable.img5),
            Quote(6, R.string.day_6_title, R.string.day_6_short, R.string.day_6_full, R.drawable.img6),
            Quote(7, R.string.day_7_title, R.string.day_7_short, R.string.day_7_full, R.drawable.img7),
            Quote(8, R.string.day_8_title, R.string.day_8_short, R.string.day_8_full, R.drawable.img8),
            Quote(9, R.string.day_9_title, R.string.day_9_short, R.string.day_9_full, R.drawable.img9),
            Quote(10, R.string.day_10_title, R.string.day_10_short, R.string.day_10_full, R.drawable.img10),
            Quote(11, R.string.day_11_title, R.string.day_11_short, R.string.day_11_full, R.drawable.img11),
            Quote(12, R.string.day_12_title, R.string.day_12_short, R.string.day_12_full, R.drawable.img12),
            Quote(13, R.string.day_13_title, R.string.day_13_short, R.string.day_13_full, R.drawable.img13),
            Quote(14, R.string.day_14_title, R.string.day_14_short, R.string.day_14_full, R.drawable.img14),
            Quote(15, R.string.day_15_title, R.string.day_15_short, R.string.day_15_full, R.drawable.img15),
            Quote(16, R.string.day_16_title, R.string.day_16_short, R.string.day_16_full, R.drawable.img16),
            Quote(17, R.string.day_17_title, R.string.day_17_short, R.string.day_17_full, R.drawable.img17),
            Quote(18, R.string.day_18_title, R.string.day_18_short, R.string.day_18_full, R.drawable.img18),
            Quote(19, R.string.day_19_title, R.string.day_19_short, R.string.day_19_full, R.drawable.img19),
            Quote(20, R.string.day_20_title, R.string.day_20_short, R.string.day_20_full, R.drawable.img20),
            Quote(21, R.string.day_21_title, R.string.day_21_short, R.string.day_21_full, R.drawable.img21),
            Quote(22, R.string.day_22_title, R.string.day_22_short, R.string.day_22_full, R.drawable.img22),
            Quote(23, R.string.day_23_title, R.string.day_23_short, R.string.day_23_full, R.drawable.img23),
            Quote(24, R.string.day_24_title, R.string.day_24_short, R.string.day_24_full, R.drawable.img24),
            Quote(25, R.string.day_25_title, R.string.day_25_short, R.string.day_25_full, R.drawable.img25),
            Quote(26, R.string.day_26_title, R.string.day_26_short, R.string.day_26_full, R.drawable.img26),
            Quote(27, R.string.day_27_title, R.string.day_27_short, R.string.day_27_full, R.drawable.img27),
            Quote(28, R.string.day_28_title, R.string.day_28_short, R.string.day_28_full, R.drawable.img28),
            Quote(29, R.string.day_29_title, R.string.day_29_short, R.string.day_29_full, R.drawable.img29),
            Quote(30, R.string.day_30_title, R.string.day_30_short, R.string.day_30_full, R.drawable.img30)
        )
    }
}
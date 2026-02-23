package com.example.lab3mobile__tips_for_every_day

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class QuoteAdapter(
    private val quotes: List<Quote>,
    private val onItemClick: (Quote) -> Unit
) : RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder>() {

    class QuoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewDayNumber: TextView = itemView.findViewById(R.id.textViewDayNumber)
        private val textViewTitle: TextView = itemView.findViewById(R.id.textViewTitle)
        private val imageViewQuote: ImageView = itemView.findViewById(R.id.imageViewQuote)
        private val textViewShortDescription: TextView = itemView.findViewById(R.id.textViewShortDescription)

        fun bind(quote: Quote, onItemClick: (Quote) -> Unit) {
            textViewDayNumber.text = "${itemView.context.getString(R.string.day_prefix)} ${quote.dayNumber}"
            textViewTitle.setText(quote.titleResId)
            imageViewQuote.setImageResource(quote.imageResId)
            textViewShortDescription.setText(quote.shortDescriptionResId)

            itemView.setOnClickListener {
                onItemClick(quote)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_quote, parent, false)
        return QuoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        holder.bind(quotes[position], onItemClick)
    }

    override fun getItemCount(): Int = quotes.size
}
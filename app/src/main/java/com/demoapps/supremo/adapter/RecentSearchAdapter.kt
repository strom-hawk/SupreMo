package com.demoapps.supremo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demoapps.supremo.R
import com.demoapps.supremo.interfaces.RecentSearchCallBack
import kotlinx.android.synthetic.main.recent_search_layout.view.*

class RecentSearchAdapter(
    private val context: Context,
    private val recentSearchList: List<String>,
    private val recentSearchCallBack: RecentSearchCallBack
) : RecyclerView.Adapter<RecentSearchAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.recent_search_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return recentSearchList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.recentSuperHeroName.text = recentSearchList.get(position)
        holder.itemView.setOnClickListener {
            recentSearchCallBack.onItemClickListener(holder.recentSuperHeroName.text.toString())
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recentSuperHeroName = itemView.recentSuperHeroName
    }
}
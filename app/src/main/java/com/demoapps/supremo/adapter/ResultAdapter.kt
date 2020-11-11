package com.demoapps.supremo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demoapps.supremo.R
import com.demoapps.supremo.interfaces.SuperHerosCallBack
import com.demoapps.supremo.model.SuperHeroData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.result_item_layout.view.*

class ResultAdapter(
    private val context: Context,
    private val superHeroList: List<SuperHeroData>,
    private val superHerosCallBack: SuperHerosCallBack
) : RecyclerView.Adapter<ResultAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.result_item_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return superHeroList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.superHeroName.text = superHeroList.get(position).name
        holder.superHeroDescription.text = superHeroList.get(position).groupAffiliation
        Picasso.get().load(superHeroList.get(position).imageUrl).into(holder.superHeroImage)
        holder.itemView.setOnClickListener {
            superHerosCallBack.onItemClickListener(position)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val superHeroName = itemView.superHeroName
        val superHeroDescription = itemView.superHeroDescription
        val superHeroImage = itemView.superHeroImage
    }
}
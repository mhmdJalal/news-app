package com.mhmdjalal.maaps1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PostAdapter(private var artikels: List<Post>, private val listener: (Post) -> Unit): RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false))
    }

    override fun getItemCount(): Int = artikels.size

    override fun onBindViewHolder(holder: PostAdapter.ViewHolder, position: Int) {
        val artikel = artikels[position]
        holder.bindItem(artikel, listener)
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var iv_banner: ImageView = view.findViewById(R.id.iv_banner)
        var tv_title: TextView = view.findViewById(R.id.tv_title)
        var tv_overview: TextView = view.findViewById(R.id.tv_overview)
        var tv_date: TextView = view.findViewById(R.id.tv_date)

        fun bindItem(post: Post, listener: (Post) -> Unit){
            tv_title.text = post.title
            tv_overview.text = post.overview
            tv_date.text = post.date
            Picasso.get()
                .load(post.imageUrl)
                .placeholder(R.drawable.thumbnail)
                .error(R.drawable.thumbnail)
                .into(iv_banner)

            itemView.setOnClickListener {
                listener(post)
            }
        }
    }

    fun replaceDate(artikels: List<Post>) {
        this.artikels = artikels
        notifyDataSetChanged()
    }

}
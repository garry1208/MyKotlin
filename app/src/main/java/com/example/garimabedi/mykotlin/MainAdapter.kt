package com.example.garimabedi.mykotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.garimabedi.mykotlin.models.Photo

class MainAdapter(var photos: List<Photo>, var clickListener: View.OnClickListener) :
    RecyclerView.Adapter<MainAdapter.PhotoViewHolder>()
{

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: MainAdapter.PhotoViewHolder, position : Int) {
       val photo = photos[position]
        holder?.tags?.text = photo.tags
        holder?.likes?.text = photo.likes.toString()
        holder?.favourites?.text = photo.favourites.toString()


        if(photo.previewURL.isNotEmpty()) {
            Glide.with(holder?.tags.context)
                .load(photo.previewURL)
                .into(holder?.photoItem)

        }
    }

    fun getPhoto(adapterPostion : Int) : Photo {
        return photos[adapterPostion]
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): PhotoViewHolder {
        return PhotoViewHolder(LayoutInflater.from(parent?.context)
            .inflate(R.layout.item_photo, parent, false))
            }

    inner class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tags: TextView
        var likes: TextView
        var favourites: TextView
        var photoItem: ImageView

        init {
            if (clickListener != null) {
                itemView.setOnClickListener(clickListener)
            }

            itemView.tag = this
            tags = itemView.findViewById(R.id.tags) as TextView // type casting to TextView
            likes = itemView.findViewById(R.id.likes) as TextView
            favourites = itemView.findViewById(R.id.favourites) as TextView
            photoItem = itemView.findViewById(R.id.photo_item) as ImageView
        }

    }
}
package com.example.recyclerview

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.recyclerview.model.ApiGitHub
import com.squareup.picasso.Picasso
import java.util.*

class Adapter(internal var context: Context, var users: ArrayList<ApiGitHub>) : RecyclerView.Adapter<Adapter.Viewholder>() {


    class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var imageView: ImageView
        internal var textView: TextView
        internal var layout: LinearLayout

        init {
            imageView = itemView.findViewById(R.id.imageView)
            textView = itemView.findViewById(R.id.textView2)
            layout = itemView.findViewById(R.id.layout_linear)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): Viewholder {
        // khoi tao dong cua recyclerview
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.activity_row, viewGroup, false)
        return Viewholder(view)
    }

    //bind du lieu
    override fun onBindViewHolder(viewholder: Viewholder, i: Int) {

        Picasso.with(context).load(users[i].avatarUrl).into(viewholder.imageView)

        viewholder.textView.text = users[i].login
        viewholder.layout.setOnClickListener {
            Toast.makeText(context, "" + users[i].login, Toast.LENGTH_SHORT).show()
            val intent = Intent(context, DigitalActivity::class.java)
            intent.putExtra("urlavatar", "" + users[i].avatarUrl)
            intent.putExtra("position", i)
            intent.putExtra("namedigital", "" + viewholder.textView.text)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return users.size
    }

}

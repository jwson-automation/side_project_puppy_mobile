package com.example.side_project_puppy_mobile.dto

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.side_project_puppy_mobile.R

val TAG = "RecyclerTrailAdapter"
class RecyclerTrailAdapter(private val items: ArrayList<TrailData>) : RecyclerView.Adapter<RecyclerTrailAdapter.ViewHolder>() {

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerTrailAdapter.ViewHolder, position: Int) {

        val item = items[position]
        val listener = View.OnClickListener { it ->
            Toast.makeText(it.context, "Clicked -> ID : ${item.title}, Name : ${item.city}", Toast.LENGTH_SHORT).show()
        }
        holder.apply {
            bind(listener, item)
            itemView.tag = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)

        return RecyclerTrailAdapter.ViewHolder(inflatedView)
    }

    // 각 항목에 필요한 기능을 구현
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view: View = v
        fun bind(listener: View.OnClickListener, item: TrailData) {
            Log.d(TAG, "bind: ${view}")
            view.findViewById<TextView>(R.id.trail_title).text = item.title
            view.findViewById<TextView>(R.id.trail_city).text = item.city
            view.findViewById<TextView>(R.id.trail_location).text = item.address

            view.setOnClickListener(listener)
        }
    }

}
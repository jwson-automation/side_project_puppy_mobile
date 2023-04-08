package com.example.side_project_puppy_mobile.adapter

import android.content.Context
import android.graphics.PorterDuff
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.side_project_puppy_mobile.R
import com.example.side_project_puppy_mobile.dto.TrailData
import com.loopeer.cardstack.CardStackView
import com.loopeer.cardstack.StackAdapter

class CardStackAdapter(context: Context) : StackAdapter<TrailData>(context) {

    override fun bindView(data: TrailData, position: Int, holder: CardStackView.ViewHolder) {
        if (holder is ColorItemViewHolder) { holder.onBind(data, position) }
    }

    override fun onCreateView(parent: ViewGroup, viewType: Int): CardStackView.ViewHolder {
        val view = getLayoutInflater().inflate(R.layout.list_card_item, parent, false)
        return ColorItemViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.list_card_item
    }

    inner class ColorItemViewHolder(view: View) : CardStackView.ViewHolder(view) {
        private val mLayout: View = view.findViewById(R.id.frame_list_card_item)
        private val mContainerContent: View = view.findViewById(R.id.container_list_content)
        private val mTextTitle: TextView = view.findViewById(R.id.text_list_card_title)

        override fun onItemExpand(b: Boolean) {
            mContainerContent.visibility = if (b) View.VISIBLE else View.GONE
        }

        fun onBind(data: TrailData, position: Int) {
            mTextTitle.text = data.title

        }
    }
}
package com.example.side_project_puppy_mobile.adapter

import android.content.Context
import android.graphics.PorterDuff
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.side_project_puppy_mobile.R
import com.loopeer.cardstack.CardStackView
import com.loopeer.cardstack.StackAdapter

class CardStackAdapter(context: Context) : StackAdapter<Int>(context) {

    override fun bindView(data: Int, position: Int, holder: CardStackView.ViewHolder) {
        when (holder) {
            is ColorItemLargeHeaderViewHolder -> holder.onBind(data, position)
            is ColorItemWithNoHeaderViewHolder -> holder.onBind(data, position)
            is ColorItemViewHolder -> holder.onBind(data, position)
        }
    }

    override fun onCreateView(parent: ViewGroup, viewType: Int): CardStackView.ViewHolder {
        return when (viewType) {
            R.layout.list_card_item_larger_header -> {
                val view = getLayoutInflater().inflate(
                    R.layout.list_card_item_larger_header,
                    parent,
                    false
                )
                ColorItemLargeHeaderViewHolder(view)
            }
            R.layout.list_card_item_with_no_header -> {
                val view = getLayoutInflater().inflate(
                    R.layout.list_card_item_with_no_header,
                    parent,
                    false
                )
                ColorItemWithNoHeaderViewHolder(view)
            }
            else -> {
                val view = getLayoutInflater().inflate(R.layout.list_card_item, parent, false)
                ColorItemViewHolder(view)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            //only else use
            -99 -> R.layout.list_card_item_larger_header
            -999 -> R.layout.list_card_item_with_no_header
            else -> R.layout.list_card_item
        }
    }

    inner class ColorItemViewHolder(view: View) : CardStackView.ViewHolder(view) {
        private val mLayout: View = view.findViewById(R.id.frame_list_card_item)
        private val mContainerContent: View = view.findViewById(R.id.container_list_content)
        private val mTextTitle: TextView = view.findViewById(R.id.text_list_card_title)

        override fun onItemExpand(b: Boolean) {
            mContainerContent.visibility = if (b) View.VISIBLE else View.GONE
        }

        fun onBind(data: Int, position: Int) {
            mLayout.background.setColorFilter(
                ContextCompat.getColor(context, data),
                PorterDuff.Mode.SRC_IN
            )
            mTextTitle.text = position.toString()
        }
    }

    inner class ColorItemWithNoHeaderViewHolder(view: View) : CardStackView.ViewHolder(view) {
        private val mLayout: View = view.findViewById(R.id.frame_list_card_item)
        private val mTextTitle: TextView = view.findViewById(R.id.text_list_card_title)

        override fun onItemExpand(b: Boolean) {}

        fun onBind(data: Int, position: Int) {
            mLayout.background.setColorFilter(
                ContextCompat.getColor(context, data),
                PorterDuff.Mode.SRC_IN
            )
            mTextTitle.text = position.toString()
        }
    }

    inner class ColorItemLargeHeaderViewHolder(view: View) : CardStackView.ViewHolder(view) {
        private val mLayout: View = view.findViewById(R.id.frame_list_card_item)
        private val mContainerContent: View = view.findViewById(R.id.container_list_content)
        private val mTextTitle: TextView = view.findViewById(R.id.text_list_card_title)

        override fun onItemExpand(b: Boolean) {
            mContainerContent.visibility = if (b) View.VISIBLE else View.GONE
        }

        override fun onAnimationStateChange(state: Int, willBeSelect: Boolean) {
            super.onAnimationStateChange(state, willBeSelect)
            if (state == CardStackView.ANIMATION_STATE_START && willBeSelect) {
                onItemExpand(true)
            }
            if (state == CardStackView.ANIMATION_STATE_END && !willBeSelect) {
                onItemExpand(false)
            }
        }

        fun onBind(data: Int, position: Int) {
            mLayout.background.setColorFilter(
                ContextCompat.getColor(context, data),
                PorterDuff.Mode.SRC_IN
            )
            mTextTitle.text = position.toString()

            itemView.findViewById<View>(R.id.text_view).setOnClickListener {
                (itemView.parent as? CardStackView)?.performItemClick(this)
            }
        }
    }
}
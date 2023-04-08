package com.example.side_project_puppy_mobile.Activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.side_project_puppy_mobile.R
import com.example.side_project_puppy_mobile.adapter.CardStackAdapter
import com.example.side_project_puppy_mobile.dto.TrailData
import com.loopeer.cardstack.AllMoveDownAnimatorAdapter
import com.loopeer.cardstack.CardStackView
import com.loopeer.cardstack.UpDownAnimatorAdapter
import com.loopeer.cardstack.UpDownStackAnimatorAdapter
import java.util.*

class CardActivity : AppCompatActivity(), CardStackView.ItemExpendListener {
//    lateinit var binding: ActivityCardBinding

    companion object{
    val TEST_DATAS = arrayOf(
        R.color.color_1,
        R.color.color_2,
        R.color.color_3,
        R.color.color_4,
        R.color.color_5,
        R.color.color_6,
        R.color.color_7,
        R.color.color_8,
        R.color.color_9,
        R.color.color_10,
        R.color.color_11,
        R.color.color_12,
        R.color.color_13,
        R.color.color_14,
        R.color.color_15,
        R.color.color_16,
        R.color.color_17,
        R.color.color_18,
        R.color.color_19,
        R.color.color_20,
        R.color.color_21,
        R.color.color_22,
        R.color.color_23,
        R.color.color_24,
        R.color.color_25,
        R.color.color_26
        )
    }
    private lateinit var mStackView: CardStackView
    private lateinit var mActionButtonContainer: LinearLayout
    private lateinit var mTestStackAdapter: CardStackAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityCardBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_card)

        mStackView = findViewById(R.id.stackview_main) as CardStackView
        mActionButtonContainer = findViewById(R.id.button_container) as LinearLayout
        mStackView.setItemExpendListener(this)
        mTestStackAdapter = CardStackAdapter(this)
        mStackView.setAdapter(mTestStackAdapter)

        val handler = android.os.Handler()
        handler.postDelayed({
            mTestStackAdapter.updateData(Arrays.asList(*TEST_DATAS))
        }, 200)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_actions, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_all_down -> mStackView.setAnimatorAdapter(AllMoveDownAnimatorAdapter(mStackView))
            R.id.menu_up_down -> mStackView.setAnimatorAdapter(UpDownAnimatorAdapter(mStackView))
            R.id.menu_up_down_stack -> mStackView.setAnimatorAdapter(UpDownStackAnimatorAdapter(mStackView))
        }
        return super.onOptionsItemSelected(item)
    }

    fun onPreClick(view: View?) {
        mStackView.pre()
    }

    fun onNextClick(view: View?) {
        mStackView.next()
    }

    override fun onItemExpend(expend: Boolean) {
        mActionButtonContainer.visibility = if (expend) View.VISIBLE else View.GONE
    }
}
package com.example.side_project_puppy_mobile.Activity

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.side_project_puppy_mobile.DB.TmpDB
import com.example.side_project_puppy_mobile.R
import com.example.side_project_puppy_mobile.adapter.CardStackAdapter
import com.example.side_project_puppy_mobile.dto.TrailData
import com.loopeer.cardstack.AllMoveDownAnimatorAdapter
import com.loopeer.cardstack.CardStackView
import com.loopeer.cardstack.UpDownAnimatorAdapter
import com.loopeer.cardstack.UpDownStackAnimatorAdapter
import java.util.*
import kotlin.collections.ArrayList

private const val TAG = "CardActivity"
class CardActivity : AppCompatActivity(), CardStackView.ItemExpendListener {
//    lateinit var binding: ActivityCardBinding


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
            mTestStackAdapter.updateData(TmpDB.TrailList)
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
package com.meme.banglaixe.ui.lamde

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.meme.banglaixe.R
import com.meme.banglaixe.common.Constant
import com.meme.banglaixe.model.StateQuestion
import java.util.*

class StateQuestionAdapter() : RecyclerView.Adapter<ViewHolder>() {

    lateinit var context: Context
    var data = ArrayList<StateQuestion>()
    var width: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return StateViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_state_question, null))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder != null) {
            (holder as StateViewHolder).bindData(data.get(position))
            holder.layoutItem.layoutParams = LinearLayout.LayoutParams(width, width)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class StateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var layoutItem: LinearLayout = itemView!!.findViewById(R.id.layoutItemStateQuestion);
        var tvContent: TextView = itemView!!.findViewById(R.id.tvContent);
        fun bindData(item: StateQuestion) {
            if (item != null && item.state != null) {
                when (item.state) {
                    Constant.STATE_QUESTION_NORMAL -> tvContent.setBackgroundColor(Color.LTGRAY)
                    Constant.STATE_QUESTION_TRUE -> tvContent.setBackgroundColor(Color.GREEN)
                    Constant.STATE_QUESTION_FALSE -> tvContent.setBackgroundColor(Color.RED)
                    Constant.STATE_QUESTION_IN_PROCESS -> tvContent.setBackgroundColor(Color.YELLOW)
                }
            }
        }

    }


    fun clear() {
        data.clear()
        notifyDataSetChanged()
    }


    fun setData(data: List<StateQuestion>) {
        if (data != null) {
            this.data = data as ArrayList<StateQuestion>
            notifyDataSetChanged()
        }
    }

    fun addData(dataNew: List<StateQuestion>) {
        val sizeCurrent = itemCount
        this.data.addAll(dataNew)
        notifyItemRangeInserted(sizeCurrent, itemCount)
    }

    fun swapData(data: List<StateQuestion>) {
        this.data = data as ArrayList<StateQuestion>
        notifyDataSetChanged()
    }

    fun changeState(position: Int, status: String) {
        val questionState: StateQuestion = data.get(position)
        if (!status.equals(questionState.state)) {
            questionState.state = status
            this.data.set(position,questionState)
            notifyItemChanged(position)
        }

    }
}
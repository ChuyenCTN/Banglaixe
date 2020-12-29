package com.demo.banglaixe.ui.main

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.demo.banglaixe.model.MenuModel
import com.meme.banglaixe.R
import com.meme.banglaixe.utils.ViewUtils
import java.util.*

class MenuAdapter(var listener: ItemListener, var widthItem: Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var data = ArrayList<MenuModel>()
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context=parent.context
        return MenuHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_menu, null))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder != null) {
            (holder as MenuHolder).bindData(data.get(position), position,context)
            holder.itemView.layoutParams = ViewGroup.LayoutParams(widthItem, widthItem)
            ViewUtils.clickViewsAnim({ listener.onClickItem(data.get(position)) },holder.layoutItemClick)
        }
    }


    override fun getItemCount(): Int {
        return data.size
    }

    fun clear() {
        data.clear()
        notifyDataSetChanged()
    }

    fun addData(dataNew: List<MenuModel>) {
        val sizeCurrent = itemCount
        this.data.addAll(dataNew)
        notifyItemRangeInserted(sizeCurrent, itemCount)
    }

    fun swapData(data: List<MenuModel>) {
        this.data = data as ArrayList<MenuModel>
        notifyDataSetChanged()
    }

    interface ItemListener {
        fun onClickItem(item: MenuModel)
    }

    class MenuHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView!!.findViewById(R.id.tvTitleItemMenu);
        var image: ImageView = itemView!!.findViewById(R.id.imgLogoMenu);
        var layoutItem: View = itemView!!.findViewById(R.id.layoutItemListMenu)
        var layoutItemClick: View = itemView!!.findViewById(R.id.itemLayoutClick)


        @SuppressLint("ResourceAsColor")
        fun bindData(item: MenuModel, i: Int,context: Context) {
            if (item.title != null) tvTitle.text = item.title
            if (item.image != null) image.setImageResource(item.image)
            when (i) {
                0 -> layoutItem.setBackgroundColor(context.resources.getColor(R.color.color_bg_1))
                1 -> layoutItem.setBackgroundColor(context.resources.getColor(R.color.color_bg_2))
                2 -> layoutItem.setBackgroundColor(context.resources.getColor(R.color.color_bg_3))
                3 -> layoutItem.setBackgroundColor(context.resources.getColor(R.color.color_bg_4))
                4 -> layoutItem.setBackgroundColor(context.resources.getColor(R.color.color_bg_5))
                5 -> layoutItem.setBackgroundColor(context.resources.getColor(R.color.color_bg_6))
                6 -> layoutItem.setBackgroundColor(context.resources.getColor(R.color.color_bg_7))
            }


        }
    }
}

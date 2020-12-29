package com.demo.banglaixe.ui.main

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.DisplayMetrics
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.demo.banglaixe.model.MenuModel
import com.meme.banglaixe.R
import com.meme.banglaixe.common.Constant
import com.meme.banglaixe.ui.lamde.LamDeThiActivity


class MainActivity : AppCompatActivity() {

    lateinit var adapter: MenuAdapter
    lateinit var rcvMenu: RecyclerView
    var dataMenu: MutableList<MenuModel> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rcvMenu = findViewById(R.id.rcvMenu)

        dataMenu.add(MenuModel(Constant.TYPE_MAIN_01, application.resources.getString(R.string.txt_de_ngau_nhien), R.drawable.ic_1))
        dataMenu.add(MenuModel(Constant.TYPE_MAIN_02, application.resources.getString(R.string.txt_thi_theo_bo_de), R.drawable.ic_2))
        dataMenu.add(MenuModel(Constant.TYPE_MAIN_03, application.resources.getString(R.string.txt_top_cau_hoi_sai), R.drawable.ic_3))
        dataMenu.add(MenuModel(Constant.TYPE_MAIN_04, application.resources.getString(R.string.txt_on_tap_cau_hoi), R.drawable.ic_4))
        dataMenu.add(MenuModel(Constant.TYPE_MAIN_05, application.resources.getString(R.string.txt_ca_loai_bien_bao), R.drawable.ic_5))
        dataMenu.add(MenuModel(Constant.TYPE_MAIN_06, application.resources.getString(R.string.txt_meo_ghi_nho), R.drawable.ic_6))
        dataMenu.add(MenuModel(Constant.TYPE_MAIN_07, application.resources.getString(R.string.txt_bai_thi_sa_hinh), R.drawable.ic_7))

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val width = displayMetrics.widthPixels
        rcvMenu.layoutManager = GridLayoutManager(applicationContext, 2)
        adapter = MenuAdapter(object : MenuAdapter.ItemListener {
            override fun onClickItem(item: MenuModel) {
                when (item.id) {
                    Constant.TYPE_MAIN_01 -> {
                        val intent = Intent(applicationContext, LamDeThiActivity::class.java)
                        intent.putExtra(Constant.DATA_TYPE, Constant.DATA_TYPE)
                        startActivity(intent)
                    }
                }
            }

        }, width / 2)
        rcvMenu.adapter = adapter
        adapter.addData(dataMenu)

    }


}
package com.example.module_main.page.adapter

import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.module_main.data.bean.Data
import com.example.module_main.data.bean.NewsBean
import com.example.module_main.databinding.ListitemTabsViewholder1Binding
import com.example.module_main.databinding.ListitemTabsViewholder2Binding
import com.example.module_main.databinding.ListitemTabsViewholder3Binding
import com.example.module_main.databinding.ListitemTabsViewholder4LoadingBinding
import com.example.module_main.event.fragment.RvTapsAdapterListener
import com.example.module_main.page.viewholder.*

class RvTapsAdapter(private val listener: RvTapsAdapterListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val datas: List<Data>
        get() = _datas!!





    override fun getItemViewType(position: Int): Int {
        val data = datas.get(position)
        /*if( !TextUtils.isEmpty(data.thumbnail_pic_s) && TextUtils.isEmpty(data.thumbnail_pic_s02)){
            Log.d("ViewHolder",  "ViewHolder type  - 1")
            return TYPE_VIEWHOLDER_ONE_PICTURE
        }else if(!TextUtils.isEmpty(data.thumbnail_pic_s) && TextUtils.isEmpty(data.thumbnail_pic_s02) == false && TextUtils.isEmpty(data.thumbnail_pic_s03) == true){
            Log.d("ViewHolder",  "ViewHolder type  -- 2")
            return TYPE_VIEWHOLDER_TWO_PICTURE
        }else if(!TextUtils.isEmpty(data.thumbnail_pic_s) && !TextUtils.isEmpty(data.thumbnail_pic_s02) && !TextUtils.isEmpty(data.thumbnail_pic_s03)){
            Log.d("ViewHolder",  "ViewHolder type  --- 3")
            return TYPE_VIEWHOLDER_THREE_PICTURE
        }else{
            Log.d("ViewHolder",  "ViewHolder type  - 1 else")
            return super.getItemViewType(position)
        }*/


       /* if(data.thumbnail_pic_s.isNullOrEmpty() == false && data.thumbnail_pic_s02.isNullOrEmpty() == true && data.thumbnail_pic_s03.isNullOrEmpty() == true){
            Log.d("ViewHolder",  "ViewHolder type  - 1")
            return TYPE_VIEWHOLDER_ONE_PICTURE
        }else if( data.thumbnail_pic_s02.isNullOrEmpty() == false && data.thumbnail_pic_s03.isNullOrEmpty() == true){
            Log.d("ViewHolder",  "ViewHolder type  -- 2")
            return TYPE_VIEWHOLDER_TWO_PICTURE
        }else if(data.thumbnail_pic_s.isNullOrEmpty() == false && data.thumbnail_pic_s02.isNullOrEmpty() == false && data.thumbnail_pic_s03.isNullOrEmpty() == false){
            Log.d("ViewHolder",  "ViewHolder type  --- 3")
            return TYPE_VIEWHOLDER_THREE_PICTURE
        }else{
            Log.d("ViewHolder",  "ViewHolder type  - 1 else")
            return super.getItemViewType(position)
        }*/

        if(data.thumbnail_pic_s != null && data.thumbnail_pic_s02 == null && data.thumbnail_pic_s03 == null){
            return TYPE_VIEWHOLDER_ONE_PICTURE
        }else if(data.thumbnail_pic_s != null && data.thumbnail_pic_s02 != null && data.thumbnail_pic_s03 == null){
            return TYPE_VIEWHOLDER_TWO_PICTURE
        }else if(data.thumbnail_pic_s != null && data.thumbnail_pic_s02 != null && data.thumbnail_pic_s03 != null){
            return TYPE_VIEWHOLDER_THREE_PICTURE
        }else if(data.thumbnail_pic_s == null && data.thumbnail_pic_s02 == null && data.thumbnail_pic_s03 == null){
            return TYPE_VIEWHOLDER_LOADING
        }else{
            return super.getItemViewType(position)
        }
    }


    init{
        val list = ArrayList<Data>()
        list.add(Data(
            "name",
            "category",
            "data",
            "content",
            null,
            null,
            null,
            "",
            "",
            ""
        ))

        setData(list)
    }
    private var _datas: List<Data>? = null

    fun setData(newsDatas: List<Data>) {
        Log.d("TestResponse---", "执行了传参操作")
        Log.d("TestResponse---", "适配器里面传入的数据为:"+newsDatas.toString())
        _datas = newsDatas
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType){
            TYPE_VIEWHOLDER_ONE_PICTURE ->
                return OnePictureVh(ListitemTabsViewholder1Binding.inflate(LayoutInflater.from(parent.context),parent,false))

            TYPE_VIEWHOLDER_TWO_PICTURE ->
                return  TwoPictureVh(ListitemTabsViewholder2Binding.inflate(LayoutInflater.from(parent.context),parent,false))
            TYPE_VIEWHOLDER_THREE_PICTURE ->
                return  ThreePictureVh(ListitemTabsViewholder3Binding.inflate(LayoutInflater.from(parent.context),parent,false))
            TYPE_VIEWHOLDER_LOADING ->
                return  FourLoadingVh(ListitemTabsViewholder4LoadingBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            else ->
                return OnePictureVh(ListitemTabsViewholder1Binding.inflate(LayoutInflater.from(parent.context),parent,false))
        }


    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is OnePictureVh ->
                holder.bind(datas.get(position), listener)
            is TwoPictureVh ->
                holder.bind(datas.get(position), listener)
            is ThreePictureVh ->
                holder.bind(datas.get(position), listener)
        }

    }

    override fun getItemCount(): Int = datas.size

}

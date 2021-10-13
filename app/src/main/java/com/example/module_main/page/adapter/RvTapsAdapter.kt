package com.example.module_main.page.adapter

import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.module_main.data.bean.Data
import com.example.module_main.data.bean.NewsBean
import com.example.module_main.databinding.ListitemTapsViewholder1Binding
import com.example.module_main.databinding.ListitemTapsViewholder2Binding
import com.example.module_main.databinding.ListitemTapsViewholder3Binding
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
            "https://pics5.baidu.com/feed/d53f8794a4c27d1e01cf78c8b3ed4c69dcc43895.jpeg?token=66f090ff0ddccfed80f7093ec6f0d7b1&s=FD81EC1B43A3E4E406ECCDDF030040A3",
            "https://pics5.baidu.com/feed/d53f8794a4c27d1e01cf78c8b3ed4c69dcc43895.jpeg?token=66f090ff0ddccfed80f7093ec6f0d7b1&s=FD81EC1B43A3E4E406ECCDDF030040A3",
            "https://pics5.baidu.com/feed/d53f8794a4c27d1e01cf78c8b3ed4c69dcc43895.jpeg?token=66f090ff0ddccfed80f7093ec6f0d7b1&s=FD81EC1B43A3E4E406ECCDDF030040A3",
            "title",
            "key",
            "ddd"
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
                return OnePictureVh(ListitemTapsViewholder1Binding.inflate(LayoutInflater.from(parent.context),parent,false))

            TYPE_VIEWHOLDER_TWO_PICTURE ->
                return  TwoPictureVh(ListitemTapsViewholder2Binding.inflate(LayoutInflater.from(parent.context),parent,false))
            TYPE_VIEWHOLDER_THREE_PICTURE ->
                return  ThreePictureVh(ListitemTapsViewholder3Binding.inflate(LayoutInflater.from(parent.context),parent,false))

            else ->
                return OnePictureVh(ListitemTapsViewholder1Binding.inflate(LayoutInflater.from(parent.context),parent,false))
        }


    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is OnePictureVh ->
                holder.bind(datas.get(position), listener)
            is TwoPictureVh ->
                holder.bind(datas.get(position))
            is ThreePictureVh ->
                holder.bind(datas.get(position))
        }

    }

    override fun getItemCount(): Int = datas.size

}

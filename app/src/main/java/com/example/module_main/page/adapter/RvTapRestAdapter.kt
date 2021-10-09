package com.example.module_main.page.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.module_main.data.bean.Data
import com.example.module_main.data.bean.NewsBean
import com.example.module_main.databinding.ListitemTapsViewholder1Binding
import com.example.module_main.page.viewholder.OnePictureVh

class RvTapRestAdapter : RecyclerView.Adapter<OnePictureVh>() {
    private val datas: List<Data>
        get() = _datas!!


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


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnePictureVh {
        return OnePictureVh(ListitemTapsViewholder1Binding.inflate(LayoutInflater.from(parent.context),parent,false))

    }

    override fun onBindViewHolder(holder: OnePictureVh, position: Int) {
        holder.bind(datas.get(position))
    }

    override fun getItemCount(): Int = datas.size

}

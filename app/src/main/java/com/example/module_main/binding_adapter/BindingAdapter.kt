package com.example.module_main.binding_adapter

import android.graphics.Bitmap
import android.util.Log
import android.webkit.WebView
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import com.example.module_main.R
import com.example.module_main.data.bean.Data
import com.example.module_main.page.adapter.RvTapsAdapter
import com.makeramen.roundedimageview.RoundedImageView
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

@BindingAdapter("bind_webviewUrl")
fun binWebViewUrl(webView: WebView, webUrl: String?){
    webUrl?.let {
        webView.loadUrl(webUrl)
    }
}

@BindingAdapter("bind_imgUrl")
fun bindImageByUrl(imgView: ImageView, imgUrl: String?){
    val factory = DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()

    imgUrl?.let {

        //加入asBitmap()方法实现glide和roundedimageview同时使用不显示圆角的问题
        Glide.with(imgView.context).asBitmap()
            .load(imgUrl)
            .apply(RequestOptions()
                .placeholder(R.drawable.placeholder_listitem)
                .error(R.drawable.placeholder_listitem_error))
            //.transition( DrawableTransitionOptions.withCrossFade(factory))
            //传入factory对象是为了让动画过渡完后隐藏占位符资源的显示
            .into(imgView)

    }
}

/*@BindingAdapter("bind_imgUrl_round")
fun bindImageByUrl(imgView: RoundedImageView, imgUrl: String?){
    val factory = DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()
    imgUrl?.let {
        Glide.with(imgView.context)
            .load(imgUrl)
            .apply(RequestOptions
                .bitmapTransform(RoundedCornersTransformation(25, 1))
                .placeholder(R.drawable.placeholder_listitem)
                .error(R.drawable.placeholder_listitem_error))
            .transition( DrawableTransitionOptions.withCrossFade(factory))
            //传入factory对象是为了让动画过渡完后隐藏占位符资源的显示
            .into(imgView)
    }
}*/

@BindingAdapter("bind_listData")
fun bindRecyclerViewWithData(rv: RecyclerView, listData: List<Data>?){
    //此适配器的数据圆可以在rv里面通过函数调用Api拿到数据，也可以在viewmodel初始化的时候调用Api拿到数据

    Log.d("TestResponse---", "执行了绑定rv数据的方法")
    val adapter = rv.adapter as RvTapsAdapter
    if(listData != null){

        Log.d("TestResponse---", "绑定适配器中livedata数据为:"+listData.toString())
        adapter.let {
            it.setData(listData)
            it.notifyDataSetChanged()
        }
    }

}

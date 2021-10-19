package com.example.module_main.page.main_page

import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.module_main.R
import com.google.android.material.transition.MaterialElevationScale

/*
* MainAty下的翻译页面
* */
class TranslateFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_translate, container, false)

    }

    override fun onDestroyView() {
        view?.findViewById<WebView>(R.id.wv_login_privacy_detail_content).apply {
            this?.destroy()
        }
        super.onDestroyView()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //整个碎片的进出动画
        exitTransition = MaterialElevationScale(false).apply {
            duration = resources.getInteger(R.integer.reply_motion_duration_large).toLong()
        }
        reenterTransition = MaterialElevationScale(true).apply {
            duration = resources.getInteger(R.integer.reply_motion_duration_large).toLong()
        }

        view.findViewById<WebView>(R.id.wv_login_privacy_detail_content).apply {
            loadUrl("https://fanyi.baidu.com/?aldtype=38319&tpltype=sigma#en/zh/")

            setInitialScale(50)//适应全屏  39适应竖屏    57适应横屏

            settings.run {
                //清除网页访问留下的缓存
                //由于内核缓存是全局的因此这个方法不仅仅针对webview而是针对整个应用程序.
                setCacheMode(WebSettings.LOAD_DEFAULT)

                setSupportZoom(true) //支持缩放，默认为true。是下面那个的前提。

                setBuiltInZoomControls(false) //设置内置的缩放控件。若为false，则该WebView不可缩放

                setDisplayZoomControls(false) //隐藏原生的缩放控件


                //设置自适应屏幕, 下面两者合用
                setUseWideViewPort(true) //将图片调整到适合webview的大小
                setLoadWithOverviewMode(true) //缩放至屏幕大小

                setJavaScriptEnabled(true) //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript

                setDomStorageEnabled(false) // 不开启 DOM storage API 功能

                setJavaScriptCanOpenWindowsAutomatically(false) //不支持通过JS打开新窗口

            }

            webChromeClient = object : WebChromeClient() {
                //作用：获取Web页中的标题
                override fun onReceivedTitle(view: WebView?, title: String?) {
                    super.onReceivedTitle(view, title)
                }

                //作用：获得网页的加载进度并显示
                /*override fun onProgressChanged(view: WebView?, newProgress: Int) {
                    super.onProgressChanged(view, newProgress)
                    if (newProgress < 100) {
                        binding.pbLoginPrivacyDetail.progress = newProgress
                    }
                }*/
            }

            webViewClient = object : WebViewClient() {

                //作用：开始载入页面调用的，我们可以设定一个loading的页面，告诉用户程序在等待网络响应
                /*override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    binding.pbLoginPrivacyDetail.visibility = View.VISIBLE
                    super.onPageStarted(view, url, favicon)
                }*/

                //作用：在页面加载结束时调用。我们可以关闭loading 条，切换程序动作
                /*override fun onPageFinished(view: WebView?, url: String?) {
                    binding.pbLoginPrivacyDetail.visibility = View.GONE
                    super.onPageFinished(view, url)
                }*/
            }
        }


    }

}
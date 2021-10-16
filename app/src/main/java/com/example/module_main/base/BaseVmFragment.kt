package com.example.module_main.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.module_main.state.CompositionListViewModel

//虽然没法注入viewmodel但是可以使写法一眼知道碎片对应的ViewModel是什么
abstract class BaseVmFragment<VM: ViewModel>: Fragment() {
    //这里的VM并没有实际意义，没有使用到,仅仅用于可观性，让人一眼就知道碎片所对应的viewmodel
    lateinit var mActivity: AppCompatActivity



    protected var isNavigationViewInit = false//记录是否已经初始化过一次视图
    protected var lastView: View? = null//记录上次创建的view

    //在Fragment直接只用getActivity（）获得上下文有时会得到空引用,所以需要重写onAttach方法拿到上下文
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = activity as AppCompatActivity
        onFragmentAttach()
    }

    /*
    * 在fragment 贴附时执行的方法，其实就是onAttach()罢了，只不过我们想要原来的onAttach方法获取上下文对象罢了
    * */
    abstract fun onFragmentAttach()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(layoutId(),container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(savedInstanceState)
        isNavigationViewInit = true
    }



    fun init(savedInstanceState: Bundle?){

        initBeforeBinding(savedInstanceState)
        initBinding(savedInstanceState)
        initAfterBinding(savedInstanceState)
    }

    /*
    * 可以初始化自己想要的设置
    * */
    abstract fun initAfterBinding(savedInstanceState: Bundle?)

    /*
    * 可以初始化如容器转换的设置
    * */
    abstract fun initBeforeBinding(savedInstanceState: Bundle?)

    /*
    * 初始化绑定事件
    * */
    abstract fun initBinding(savedInstanceState: Bundle?)


    /*
    * 布局资源如R.layout.fragment_test
    * */
    abstract fun layoutId(): Int
}
package com.example.module_main.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

//创建这个类没有实际作用，主要就是为了看起来好看,暴露所有需要或者重要的方法给使用者看, 老强迫症了
abstract class BaseFragment<VM: ViewModel, DB: ViewDataBinding>: BaseVmDbFragment<VM, DB>(){
    //- - - 注意以下onFragmentDestroy和onFragmentAttach两个方法通常覆盖后不操作!!!   之所以把方法暴露出来是为了防止有特殊需求 ^.^
    //- - - layoutId方法必须覆盖!!!


    /*
    * 这个属性用来是否处理 使用jetpack navigation组件导航后，fragment是否重新执行onCreateView方法，重新执行就要重新初始化，之前初始化的状态丢失
    * 为false表示不处理fragment重新初始化
    * 为true表示处理fragment重新初始化
    * */
    abstract override var isHandleFragmentAgainOnCreateView: Boolean

    /*
    * 在fragment销毁时执行的方法，其实就是onDestroy()罢了，只不过我们想要原来的onDestory()方法执行_binding = null操作而已
    * 在onDestory()方法内执行
    * */
    abstract override fun onFragmentDestroy()

    /*
    * 在fragment 贴附时执行的方法，其实就是onAttach()罢了，只不过我们想要原来的onAttach方法获取上下文对象罢了
    * 在onAttach()方法内执行
    * */
    abstract override fun onFragmentAttach()

    /**
     * 当前Fragment绑定的视图布局
     */
    abstract override fun layoutId(): Int


    /**
     * Fragment执行onViewCreated后触发,可以初始化如容器转换的设置,如果没有容器转换或fragment的进出动画要设置可以不初始化这个方法内容
     * 在initBinding方法前调用
     */
    abstract override fun initBeforeBinding(savedInstanceState: Bundle?)

    /*
    * 初始化绑定事件
    * */
    abstract override fun initBinding(savedInstanceState: Bundle?)

    /*
    * 初始化除了绑定操作外用户想自己定义的内容
    * 在initBinding方法后调用
    * */
    abstract override fun initAfterBinding(savedInstanceState: Bundle?)
}

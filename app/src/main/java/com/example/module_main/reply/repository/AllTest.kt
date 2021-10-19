/*

package com.hzl.newstoragehelper.reply.repository



//todo viewmodel(传入BaseRepository)
class baseRepViewModel @ViewModelInject constructor(
    private val baseRep: BaseRepositoryTest,//基本库BaseRepository
    private val netRep: TestNetRepository,//网络不分页BaseResourceRepository
    private val netPageRep: TestNetworkPagedRepository//网络分页TestNetworkPagedRepository
): ViewModel(){
    //todo 继承自BaseRepository的串起
    fun query(){//调用链
        baseRep.query()
    }
    val obLiveData = baseRep.observerLiveData//返回链

    //todo 继承自BaseNetworkPagedRepository的串起
    fun queryNet(start_time: String?, end_time: String?){//调用链
        netRep.query(start_time, end_time)
    }
    val obNetLiveData = netRep.getResourceLiveData()

    //todo 继承自BaseNetworkPagedRepository的串起
    fun queryNetPage(start_time: String?, end_time: String?){//调用链
        netPageRep.query(TestRequest.getTestRequest(start_time , end_time))
    }
    val listingLivedata: LiveData<Listing<TestResponse>> = netPageRep.pagedListingLiveData
    val rvListLiveData: LiveData<PagedList<TestResponse>> = switchMap(listingLivedata){
        //返回链  rvListLiveData常用来作为rv列表控件的数据源
        it.pagedList
    }
    val rvResourceLivedata: LiveData<Resource<String>> = switchMap(listingLivedata){
        //返回链
        it.resource
    }
    fun refresh(){
        //常用来刷新数据
        listingLivedata.value?.refresh?.invoke()
    }
}

//todo 数据库 BaseRepository 不需要分页
class BaseRepositoryTest @Inject constructor(
    private val dao: DaoTest
): BaseRepository() {
    override fun onCatchException(e: Exception) {

    }
    val l = MutableLiveData<Int>()// T: 可以为任意值包括livedata
    fun query() = catchLaunch{
        //此处可以做比如判断数据库是否为空，若为空则插入一条数据
        l.postValue(1)//l改变, switchMap可以观察到
    }
    val observerLiveData = switchMap(l){
        //返回一个实际需要被观察的livedata
        dao.getAll()
    }
}

//todo 网络 BaseNetworkPagedRepository 分页
class TestNetworkPagedRepository @Inject constructor(
    private val service: ServiceTest
): BaseNetworkPagedRepository<TestResponse, TestRequest>(){
    //TestResponse为返回json实体类   TestRequest为请求数据类
    override suspend fun getResponse(
        r: TestRequest,
        pageNum: Int,
        pageSize: Int
    ): BaseResponse<ArrayResponse<TestResponse>> {
        return service.getJsonArrayResponse(r.toMapWithToken().addPagedInfo(pageNum, pageSize))
    }
}

//todo 网络 BaseResourceRepository  不需要分页
class TestNetRepository @Inject constructor(
    private val service: ServiceTest
):BaseResourceRepository<TestResponse>(){
    fun query(start_time: String?, end_time: String?){
        postLoading()
        val res = service.getJsonObjectResponse(TestRequest.getTestRequest(start_time , end_time)
            .toMapWithToken()).getResource()//这里可以调用getResource()是因为service返回的是BaseResponse类型
        res.onError {
            postError(it)//给BaseResourceRepository持有的livedata赋值
        }
        res.onSuccess {
            if(it != null){
                postSuccess(it)//给BaseResourceRepository持有的livedata赋值
            }
        }
    }
}

//todo 网络service
interface ServiceTest{
    @FormUrlEncoded
    @POST("")//value为yapi对应的地址
    fun getAll(): LiveData<Any>

    @FormUrlEncoded
    @POST("")
    fun getJsonObjectResponse(
        @FieldMap fieldMap: HashMap<String, String>
    ): BaseResponse<TestResponse> //如果返回的是json object对象直接返回这个json object对象对应的数据类

    @FormUrlEncoded
    @POST("")
    fun getJsonArrayResponse(
        @FieldMap fieldMap: HashMap<String, String>
    ): BaseResponse<ArrayResponse<TestResponse>>//如果返回的是json array对象则返回ArrayRespnse对象, 重复的数据类即为泛型
}

//todo 数据库Dao
interface DaoTest{
    @Query("UPDATE sql_tb_table set name = :name WHERE id = 0")
    fun updateTest(name: String)
    @Query("SELECT * FROM reply_screen_entity")
    fun getAll(): LiveData<List<TestEntity>>
}

//todo 数据库对应的实体类
@Entity(tableName = "sql_tb_table")
data class TestEntity(
    @PrimaryKey
    val id: Int = 0,
    val name: String?
)

//todo 网络对应的数据类  根据返回的json格式数据生成对应的返回实体类
data class TestResponse(
    val detail: Detail,
    val header: Header
)
data class Detail(
    val age: String,
    val appointment_interview_date: String,
    val birthdate: String
    //...
)
data class Header(
    val appraise: String,
    val auditor: Any
    //...
)

//todo 网络请求数据类
data class TestRequest(
    //形参为yapi请求参数对应的字段
    val start_time: String?,//当yapi文档中请求参数是否必须为否时候,字段为可空类型
    val end_time: String?
){
    companion object{
        fun getTestRequest(start_time: String?, end_time: String?): TestRequest{
            return TestRequest(start_time, end_time)
        }
    }
}

//todo RecyclerView
class MyAdapter @Inject constructor(): BaseCommonAdapter<ItemReplyListBinding, ReplyEntity, MyVh>(
    mutableListOf()
){
    override fun ItemReplyListBinding.onViewBind(data: ReplyEntity, position: Int) {
        //当view绑定的时候要做的事情，如可以设置控件的监听
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVh {
        TODO("Not yet implemented")
    }
}
class MyVh(binding: ItemReplyListBinding): BaseViewHolder<ItemReplyListBinding, ReplyEntity>(binding){
    override fun bindData(data: ReplyEntity, position: Int) {
        getBinding().apply {
            //绑定数据给视图
        }
    }
}


class adapter2() : BasePagedListingAdapter<ItemReplyListBinding, ReplyEntity,vh>(DIFF){
    companion object {
        object DIFF : DiffUtil.ItemCallback<ReplyEntity>() {
            override fun areItemsTheSame(oldItem: ReplyEntity, newItem: ReplyEntity): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: ReplyEntity, newItem: ReplyEntity): Boolean {
                return oldItem == newItem
            }
        }
    }
    override fun ItemReplyListBinding.onViewBind(data: ReplyEntity, position: Int) {
        TODO("Not yet implemented")
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): vh {
        TODO("Not yet implemented")
    }
}


 */

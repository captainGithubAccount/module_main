package com.example.module_main.moudle_word

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * The [ViewModel] that is attached to the [WordFragment].
 */
class WordViewModel(private val _wordRepository: WordRepository): ViewModel() {
    val allWords:LiveData<List<WordEntity>> by lazy { _wordRepository.allWords }
    val searchWords:LiveData<List<WordEntity>>? = null


    fun getSearchWords(search:String): LiveData<List<WordEntity>>{
        return _wordRepository.getSearchWords(search)
    }

    @WorkerThread
    fun insertWords(vararg wordEntity: WordEntity){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                _wordRepository.insertWords(*wordEntity)
            }
        }
    }

    //推荐写法
    /*@WorkerThread
    fun insertWords(vararg wordEntity: WordEntity){
        viewModelScope.launch {
            _wordRepository.insertWords(*wordEntity)
        }
    }*/

    @WorkerThread
    fun deleteWords(vararg wordEntity: WordEntity){
        viewModelScope.launch {
            withContext(Dispatchers.Default){
                _wordRepository.deleteWords(*wordEntity)
            }
        }
    }

    //    清空数据
    fun deleteAllWords(){
        viewModelScope.launch {
            withContext(Dispatchers.Default){
                _wordRepository.deleteAllWords()
            }
        }
    }

    @WorkerThread
    fun updateWords(vararg wordEntity: WordEntity){
        viewModelScope.launch {
            withContext(Dispatchers.Default){
                _wordRepository.updateWords(*wordEntity)
            }
        }
    }



}
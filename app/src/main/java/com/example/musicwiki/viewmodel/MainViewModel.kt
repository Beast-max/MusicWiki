package com.example.musicwiki.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicwiki.api.albumdetailResponse.AlbumDetailResponse
import com.example.musicwiki.api.albumresponse.AlbumReponse
import com.example.musicwiki.api.genersdetailresponse.GenreDetailResponse
import com.example.musicwiki.api.genresresponse.GenresResponse
import com.example.musicwiki.api.services.BaseResponse
import com.example.musicwiki.api.topartiestresponse.TopArtistResponse
import com.example.musicwiki.api.topartiestresponse.artistInforesponse.ArtistInfoResponse
import com.example.musicwiki.api.topartiestresponse.artisttopalbum.ArtistTopAlbumResponse
import com.example.musicwiki.api.topartiestresponse.toptrackresponse.ArtistTopTrackResponse
import com.example.musicwiki.api.trackresponse.TrackResponse
import com.example.musicwiki.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) :ViewModel() {
     var getGenerLiveData = MutableLiveData<BaseResponse<GenresResponse>>()
     var getGenerInfoLiveData = MutableLiveData<BaseResponse<GenreDetailResponse>>()
     var getTrackLiveData = MutableLiveData<BaseResponse<TrackResponse>>()
     var getArtistLiveData = MutableLiveData<BaseResponse<TopArtistResponse>>()
     var getAlbumLiveData = MutableLiveData<BaseResponse<AlbumReponse>>()
     var getAlbumInfoLiveData = MutableLiveData<BaseResponse<AlbumDetailResponse>>()
     var getArtistInfoLiveData = MutableLiveData<BaseResponse<ArtistInfoResponse>>()
     var getArtistTrackLiveData = MutableLiveData<BaseResponse<ArtistTopTrackResponse>>()
     var getArtistTopAlbumLiveData = MutableLiveData<BaseResponse<ArtistTopAlbumResponse>>()




    fun getGenres() = viewModelScope.launch {
        getGenerLiveData.value = BaseResponse.Loading()
        val response = mainRepository.getGenres()
        try{
            if(response.code()==200){
                Log.d("Get Genres Response", response.body().toString())
                getGenerLiveData.value = BaseResponse.Success(response.body())
            }
            else{
                Log.d("Get Genres Error", response.body().toString())

                getGenerLiveData.value = BaseResponse.Error(response.message())
            }
        }catch (e:Exception){
            Log.d("Get Genres Error", response.body().toString())

            getGenerLiveData.value = BaseResponse.Error(e.message)

        }
    }
    fun getGenresInfo(tag:String) = viewModelScope.launch {
        getGenerInfoLiveData.value = BaseResponse.Loading()
        val response = mainRepository.getGenresInfo(tag)
        try{
            if(response.code()==200){
                Log.d("Get Genresinfo Response", response.body().toString())
                getGenerInfoLiveData.value = BaseResponse.Success(response.body())
            }
            else{
                Log.d("Get Genresinfo Error", response.body().toString())

                getGenerInfoLiveData.value = BaseResponse.Error(response.message())
            }
        }catch (e:Exception){
            Log.d("Get Genresinfo Error", response.body().toString())

            getGenerInfoLiveData.value = BaseResponse.Error(e.message)

        }
    }
    fun getAlbum(tag:String) = viewModelScope.launch {
        getAlbumLiveData.value = BaseResponse.Loading()
        val response = mainRepository.getAlbum(tag)
        try{
            if(response.code()==200){
                Log.d("Get Album Response", response.body().toString())
                getAlbumLiveData.value = BaseResponse.Success(response.body())
            }
            else{
                Log.d("Get Album Error", response.body().toString())

                getAlbumLiveData.value = BaseResponse.Error(response.message())
            }
        }catch (e:Exception){
            Log.d("Get Album Error", response.body().toString())
            getAlbumLiveData.value = BaseResponse.Error(e.message)

        }
    }
    fun getTrack(tag:String) = viewModelScope.launch {
        getTrackLiveData.value = BaseResponse.Loading()
        val response = mainRepository.getTrack(tag)
        try{
            if(response.code()==200){
                Log.d("Get Track Response", response.body().toString())
                getTrackLiveData.value = BaseResponse.Success(response.body())
            }
            else{
                Log.d("Get Track Error", response.body().toString())

                getTrackLiveData.value = BaseResponse.Error(response.message())
            }
        }catch (e:Exception){
            Log.d("Get Track Error", response.body().toString())
            getTrackLiveData.value = BaseResponse.Error(e.message)

        }
    }
    fun getArtist(tag:String) = viewModelScope.launch {
        getArtistLiveData.value = BaseResponse.Loading()
        val response = mainRepository.getArtist(tag)
        try{
            if(response.code()==200){
                Log.d("Get Artist Response", response.body().toString())
                getArtistLiveData.value = BaseResponse.Success(response.body())
            }
            else{
                Log.d("Get Artist Error", response.body().toString())

                getArtistLiveData.value = BaseResponse.Error(response.message())
            }
        }catch (e:Exception){
            Log.d("Get Artist Error", response.body().toString())
            getArtistLiveData.value = BaseResponse.Error(e.message)

        }
    }
    fun getAlbumInfo(tag:String,albumname:String) = viewModelScope.launch {
        getAlbumInfoLiveData.value = BaseResponse.Loading()
        val response = mainRepository.getAlbumInfo(tag,albumname)
        try{
            if(response.code()==200){
                Log.d("Get AlbumInfo Response", response.body().toString())
                getAlbumInfoLiveData.value = BaseResponse.Success(response.body())
            }
            else{
                Log.d("Get AlbumInfo Error", response.body().toString())
                getAlbumInfoLiveData.value = BaseResponse.Error(response.message())
            }
        }catch (e:Exception){
            Log.d("Get AlbumInfo Error", response.body().toString())
            getAlbumInfoLiveData.value = BaseResponse.Error(e.message)

        }
    }
    fun getArtistTopAlbum(tag:String) = viewModelScope.launch {
        getArtistTopAlbumLiveData.value = BaseResponse.Loading()
        val response = mainRepository.getArtistTopAlbum(tag)
        try{
            if(response.code()==200){
                Log.d("Get AlbumInfo Response", response.body().toString())
                getArtistTopAlbumLiveData.value = BaseResponse.Success(response.body())
            }
            else{
                Log.d("Get AlbumInfo Error", response.body().toString())
                getArtistTopAlbumLiveData.value = BaseResponse.Error(response.message())
            }
        }catch (e:Exception){
            Log.d("Get AlbumInfo Error", response.body().toString())
            getArtistTopAlbumLiveData.value = BaseResponse.Error(e.message)

        }
    }
    fun getArtistTrack(tag:String) = viewModelScope.launch {
        getArtistTrackLiveData.value = BaseResponse.Loading()
        val response = mainRepository.getArtistTopTrack(tag)
        try{
            if(response.code()==200){
                Log.d("Get AlbumInfo Response", response.body().toString())
                getArtistTrackLiveData.value = BaseResponse.Success(response.body())
            }
            else{
                Log.d("Get AlbumInfo Error", response.body().toString())
                getArtistTrackLiveData.value = BaseResponse.Error(response.message())
            }
        }catch (e:Exception){
            Log.d("Get AlbumInfo Error", response.body().toString())
            getArtistTrackLiveData.value = BaseResponse.Error(e.message)

        }
    }
    fun getArtistInfo(tag:String) = viewModelScope.launch {
        getArtistInfoLiveData.value = BaseResponse.Loading()
        val response = mainRepository.getArtistinfo(tag)
        try{
            if(response.code()==200){
                Log.d("Get AlbumInfo Response", response.body().toString())
                getArtistInfoLiveData.value = BaseResponse.Success(response.body())
            }
            else{
                Log.d("Get AlbumInfo Error", response.body().toString())
                getArtistInfoLiveData.value = BaseResponse.Error(response.message())
            }
        }catch (e:Exception){
            Log.d("Get AlbumInfo Error", response.body().toString())
            getArtistInfoLiveData.value = BaseResponse.Error(e.message)

        }
    }
}
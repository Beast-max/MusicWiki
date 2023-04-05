package com.example.musicwiki.api.services

import com.example.musicwiki.api.albumdetailResponse.AlbumDetailResponse
import com.example.musicwiki.api.albumresponse.AlbumReponse
import com.example.musicwiki.api.genersdetailresponse.GenreDetailResponse
import com.example.musicwiki.api.genresresponse.GenresResponse
import com.example.musicwiki.api.topartiestresponse.TopArtistResponse
import com.example.musicwiki.api.topartiestresponse.artistInforesponse.ArtistInfoResponse
import com.example.musicwiki.api.topartiestresponse.artisttopalbum.ArtistTopAlbumResponse
import com.example.musicwiki.api.topartiestresponse.toptrackresponse.ArtistTopTrackResponse
import com.example.musicwiki.api.trackresponse.TrackResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query
interface EndPoints {
    @GET("2.0/")
    suspend fun getGenres(@Query("method")method: String="chart.gettoptags",@Query("api_key") api_key: String,@Query("format") format:String="json"): Response<GenresResponse>

     @GET("2.0/")
     suspend   fun getDetailGenres(@Query("method") method:String ="tag.getinfo",@Query("tag") tag:String,@Query("api_key") api_key:String,@Query("format") format:String="json")
     :Response<GenreDetailResponse>

     @GET("2.0/")
     suspend  fun getAlbum(@Query("method") method:String ="tag.gettopalbums",@Query("tag") tag:String,@Query("api_key") api_key:String,@Query("format") format:String="json")
     :Response<AlbumReponse>

    @GET("2.0/")
    suspend  fun getTracks(@Query("method") method:String ="tag.gettoptracks",@Query("tag") tag:String,@Query("api_key") api_key:String,@Query("format") format:String="json")
            :Response<TrackResponse>

    @Headers("Accept: application/json")
    @GET("2.0/")
    suspend  fun getAlbumInfo(@Query("method") method:String ="album.getinfo",@Query("artist") artist:String,@Query("album")album:String,@Query("api_key") api_key:String,@Query("format") format:String="json")
            :Response<AlbumDetailResponse>

    @GET("2.0/")
    suspend  fun getArtist(@Query("method") method:String ="tag.gettopartists",@Query("tag") tag:String,@Query("api_key") api_key:String,@Query("format") format:String="json")
            :Response<TopArtistResponse>


    @GET("2.0/")
    suspend  fun getArtistInfo(@Query("method") method:String ="artist.getinfo",@Query("artist") artist:String,@Query("api_key") api_key:String,@Query("format") format:String="json")
            :Response<ArtistInfoResponse>

    @GET("2.0/")
    suspend  fun getArtistTopTracks(@Query("method") method:String ="artist.gettoptracks",@Query("artist") artist:String,@Query("api_key") api_key:String,@Query("format") format:String="json")
            :Response<ArtistTopTrackResponse>

    @GET("2.0/")
    suspend  fun getArtistAlbum(@Query("method") method:String ="artist.gettopalbums",@Query("artist") artist:String,@Query("api_key") api_key:String,@Query("format") format:String="json")
            :Response<ArtistTopAlbumResponse>



}
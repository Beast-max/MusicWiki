package com.example.musicwiki.repository

import com.example.musicwiki.api.albumdetailResponse.AlbumDetailResponse
import com.example.musicwiki.api.albumresponse.AlbumReponse
import com.example.musicwiki.api.genersdetailresponse.GenreDetailResponse
import com.example.musicwiki.api.genresresponse.GenresResponse
import com.example.musicwiki.api.services.EndPoints
import com.example.musicwiki.api.topartiestresponse.TopArtistResponse
import com.example.musicwiki.api.topartiestresponse.artistInforesponse.ArtistInfoResponse
import com.example.musicwiki.api.topartiestresponse.artisttopalbum.ArtistTopAlbumResponse
import com.example.musicwiki.api.topartiestresponse.toptrackresponse.ArtistTopTrackResponse
import com.example.musicwiki.api.trackresponse.TrackResponse
import com.example.musicwiki.utils.Constant
import retrofit2.Response


class MainRepository(private val service:EndPoints) {
    suspend fun getGenres(): Response<GenresResponse> {
        return service.getGenres(api_key = Constant.api_key)
    }
    suspend  fun getGenresInfo(tag:String):Response<GenreDetailResponse>{
        return service.getDetailGenres(tag = tag, api_key = Constant.api_key)
    }
    suspend   fun getTrack(tag:String):Response<TrackResponse>{
        return service.getTracks(tag = tag, api_key = Constant.api_key)
    }
    suspend  fun getAlbum(tag:String):Response<AlbumReponse>{
        return service.getAlbum(tag =tag, api_key = Constant.api_key)
    }
    suspend   fun getArtist(tag: String):Response<TopArtistResponse>{
        return service.getArtist(tag = tag, api_key = Constant.api_key)
    }
    suspend  fun getAlbumInfo(artist:String,album:String):Response<AlbumDetailResponse>{
        return service.getAlbumInfo(artist = artist, album = album, api_key = Constant.api_key)
    }
    suspend  fun getArtistinfo(artist:String):Response<ArtistInfoResponse>{
        return service.getArtistInfo(artist = artist, api_key = Constant.api_key)
    }
    suspend   fun getArtistTopTrack(artist: String):Response<ArtistTopTrackResponse>{
        return service.getArtistTopTracks(artist = artist, api_key = Constant.api_key)
    }
    suspend fun getArtistTopAlbum(artist: String):Response<ArtistTopAlbumResponse>{
        return service.getArtistAlbum(artist = artist, api_key = Constant.api_key)
    }
}
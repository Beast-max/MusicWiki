package com.example.musicwiki.api.topartiestresponse.artisttopalbum


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ArtistTopAlbumResponse(
    @SerializedName("topalbums")
    @Expose
    var topalbums: Topalbums
)
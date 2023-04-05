package com.example.musicwiki.api.topartiestresponse.artisttopalbum


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Topalbums(
    @SerializedName("album")
    @Expose
    var album: List<Album>,
    @SerializedName("@attr")
    @Expose
    var attr: Attr
)
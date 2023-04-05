package com.example.musicwiki.api.topartiestresponse.artisttopalbum


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Artist(
    @SerializedName("mbid")
    @Expose
    var mbid: String,
    @SerializedName("name")
    @Expose
    var name: String,
    @SerializedName("url")
    @Expose
    var url: String
)
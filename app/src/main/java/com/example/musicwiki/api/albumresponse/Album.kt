package com.example.musicwiki.api.albumresponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Album(
    @SerializedName("artist")
    @Expose
    var artist: Artist,
    @SerializedName("@attr")
    @Expose
    var attr: Attr,
    @SerializedName("image")
    @Expose
    var image: List<Image>,
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
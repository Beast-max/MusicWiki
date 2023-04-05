package com.example.musicwiki.api.topartiestresponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Artist(
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
    @SerializedName("streamable")
    @Expose
    var streamable: String,
    @SerializedName("url")
    @Expose
    var url: String
)
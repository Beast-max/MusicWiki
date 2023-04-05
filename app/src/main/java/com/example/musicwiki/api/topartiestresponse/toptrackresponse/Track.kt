package com.example.musicwiki.api.topartiestresponse.toptrackresponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Track(
    @SerializedName("artist")
    @Expose
    var artist: Artist,
    @SerializedName("@attr")
    @Expose
    var attr: AttrX,
    @SerializedName("image")
    @Expose
    var image: List<Image>,
    @SerializedName("listeners")
    @Expose
    var listeners: String,
    @SerializedName("mbid")
    @Expose
    var mbid: String,
    @SerializedName("name")
    @Expose
    var name: String,
    @SerializedName("playcount")
    @Expose
    var playcount: String,
    @SerializedName("streamable")
    @Expose
    var streamable: String,
    @SerializedName("url")
    @Expose
    var url: String
)
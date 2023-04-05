package com.example.musicwiki.api.trackresponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Track(
    @SerializedName("artist")
    @Expose
    var artist: Artist,
    @SerializedName("@attr")
    @Expose
    var attr: AttrX,
    @SerializedName("duration")
    @Expose
    var duration: String,
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
    var streamable: Streamable,
    @SerializedName("url")
    @Expose
    var url: String
)
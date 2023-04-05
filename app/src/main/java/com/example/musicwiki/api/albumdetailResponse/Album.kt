package com.example.musicwiki.api.albumdetailResponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



data class Album(
    @SerializedName("artist")
    @Expose
    var artist: String?,
    @SerializedName("image")
    @Expose
    var image: List<Image?>?,
    @SerializedName("listeners")
    @Expose
    var listeners: String?,
    @SerializedName("mbid")
    @Expose
    var mbid: String?,
    @SerializedName("name")
    @Expose
    var name: String?,
    @SerializedName("playcount")
    @Expose
    var playcount: String?,
    @SerializedName("tracks")
    @Expose
    var tracks: Tracks?,
    @SerializedName("url")
    @Expose
    var url: String?,
    @SerializedName("wiki")
    @Expose
    var wiki: Wiki?
)
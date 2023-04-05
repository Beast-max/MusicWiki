package com.example.musicwiki.api.albumresponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Albums(
    @SerializedName("album")
    @Expose
    var album: List<Album>,
    @SerializedName("@attr")
    @Expose
    var attr: AttrX
)
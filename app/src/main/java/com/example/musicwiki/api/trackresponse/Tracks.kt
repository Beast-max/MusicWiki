package com.example.musicwiki.api.trackresponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Tracks(
    @SerializedName("@attr")
    @Expose
    var attr: Attr,
    @SerializedName("track")
    @Expose
    var track: List<Track>
)
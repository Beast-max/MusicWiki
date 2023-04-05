package com.example.musicwiki.api.topartiestresponse.toptrackresponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Toptracks(
    @SerializedName("@attr")
    @Expose
    var attr: Attr,
    @SerializedName("track")
    @Expose
    var track: List<Track>
)
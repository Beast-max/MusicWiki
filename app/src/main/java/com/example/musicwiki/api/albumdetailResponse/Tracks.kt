package com.example.musicwiki.api.albumdetailResponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Tracks(
    @SerializedName("track")
    @Expose
    var track: List<Track?>?
)
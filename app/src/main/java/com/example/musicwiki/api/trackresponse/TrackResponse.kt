package com.example.musicwiki.api.trackresponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TrackResponse(
    @SerializedName("tracks")
    @Expose
    var tracks: Tracks
)
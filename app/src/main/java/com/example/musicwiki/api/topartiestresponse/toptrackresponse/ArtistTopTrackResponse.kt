package com.example.musicwiki.api.topartiestresponse.toptrackresponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ArtistTopTrackResponse(
    @SerializedName("toptracks")
    @Expose
    var toptracks: Toptracks
)
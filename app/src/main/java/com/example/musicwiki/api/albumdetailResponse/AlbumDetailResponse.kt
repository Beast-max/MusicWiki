package com.example.musicwiki.api.albumdetailResponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class AlbumDetailResponse(
    @SerializedName("album")
    @Expose
    var album: Album?
)
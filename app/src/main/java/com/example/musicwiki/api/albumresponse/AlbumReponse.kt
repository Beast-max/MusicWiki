package com.example.musicwiki.api.albumresponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AlbumReponse(
    @SerializedName("albums")
    @Expose
    var albums: Albums
)
package com.example.musicwiki.api.topartiestresponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TopArtistResponse(
    @SerializedName("topartists")
    @Expose
    var topartists: Topartists
)
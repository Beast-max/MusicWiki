package com.example.musicwiki.api.topartiestresponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Topartists(
    @SerializedName("artist")
    @Expose
    var artist: List<Artist>,
    @SerializedName("@attr")
    @Expose
    var attr: AttrX
)
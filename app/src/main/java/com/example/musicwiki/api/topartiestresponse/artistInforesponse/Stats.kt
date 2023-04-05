package com.example.musicwiki.api.topartiestresponse.artistInforesponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Stats(
    @SerializedName("listeners")
    @Expose
    var listeners: String,
    @SerializedName("playcount")
    @Expose
    var playcount: String
)
package com.example.musicwiki.api.topartiestresponse.toptrackresponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Image(
    @SerializedName("size")
    @Expose
    var size: String,
    @SerializedName("#text")
    @Expose
    var text: String
)
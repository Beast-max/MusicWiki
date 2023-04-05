package com.example.musicwiki.api.topartiestresponse.artistInforesponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Tag(
    @SerializedName("name")
    @Expose
    var name: String,
    @SerializedName("url")
    @Expose
    var url: String
)
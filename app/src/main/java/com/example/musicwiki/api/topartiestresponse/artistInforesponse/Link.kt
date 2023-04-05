package com.example.musicwiki.api.topartiestresponse.artistInforesponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Link(
    @SerializedName("href")
    @Expose
    var href: String,
    @SerializedName("rel")
    @Expose
    var rel: String,
    @SerializedName("#text")
    @Expose
    var text: String
)
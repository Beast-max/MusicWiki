package com.example.musicwiki.api.trackresponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Streamable(
    @SerializedName("fulltrack")
    @Expose
    var fulltrack: String,
    @SerializedName("#text")
    @Expose
    var text: String
)
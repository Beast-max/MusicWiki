package com.example.musicwiki.api.topartiestresponse.artistInforesponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Bio(
    @SerializedName("content")
    @Expose
    var content: String,
    @SerializedName("links")
    @Expose
    var links: Links,
    @SerializedName("published")
    @Expose
    var published: String,
    @SerializedName("summary")
    @Expose
    var summary: String
)
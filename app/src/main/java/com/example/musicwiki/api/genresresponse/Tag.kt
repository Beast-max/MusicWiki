package com.example.musicwiki.api.genresresponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Tag(
    @SerializedName("name")
    @Expose
    var name: String,
    @SerializedName("reach")
    @Expose
    var reach: String,
    @SerializedName("streamable")
    @Expose
    var streamable: String,
    @SerializedName("taggings")
    @Expose
    var taggings: String,
    @SerializedName("url")
    @Expose
    var url: String,
    @SerializedName("wiki")
    @Expose
    var wiki: Wiki
)
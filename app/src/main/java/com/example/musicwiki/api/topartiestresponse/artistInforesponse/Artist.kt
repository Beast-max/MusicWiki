package com.example.musicwiki.api.topartiestresponse.artistInforesponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Artist(
    @SerializedName("bio")
    @Expose
    var bio: Bio,
    @SerializedName("image")
    @Expose
    var image: List<Image>?,
    @SerializedName("mbid")
    @Expose
    var mbid: String,
    @SerializedName("name")
    @Expose
    var name: String,
    @SerializedName("ontour")
    @Expose
    var ontour: String,
    @SerializedName("similar")
    @Expose
    var similar: Similar,
    @SerializedName("stats")
    @Expose
    var stats: Stats,
    @SerializedName("streamable")
    @Expose
    var streamable: String,
    @SerializedName("tags")
    @Expose
    var tags: Tags,
    @SerializedName("url")
    @Expose
    var url: String
)
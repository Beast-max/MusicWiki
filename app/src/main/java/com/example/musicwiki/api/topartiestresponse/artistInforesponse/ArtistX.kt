package com.example.musicwiki.api.topartiestresponse.artistInforesponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ArtistX(
    @SerializedName("image")
    @Expose
    var image: List<Image>,
    @SerializedName("name")
    @Expose
    var name: String,
    @SerializedName("url")
    @Expose
    var url: String
)
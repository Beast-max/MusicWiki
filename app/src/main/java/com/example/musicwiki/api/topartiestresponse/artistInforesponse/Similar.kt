package com.example.musicwiki.api.topartiestresponse.artistInforesponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Similar(
    @SerializedName("artist")
    @Expose
    var artist: List<ArtistX>
)
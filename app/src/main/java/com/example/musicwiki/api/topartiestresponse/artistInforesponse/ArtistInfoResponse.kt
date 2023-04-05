package com.example.musicwiki.api.topartiestresponse.artistInforesponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ArtistInfoResponse(
    @SerializedName("artist")
    @Expose
    var artist: Artist
)
package com.example.musicwiki.api.albumdetailResponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Track(
    @SerializedName("artist")
    @Expose
    var artist: Artist?,
    @SerializedName("@attr")
    @Expose
    var attr: Attr?,
    @SerializedName("duration")
    @Expose
    var duration: Int?,
    @SerializedName("name")
    @Expose
    var name: String?,
    @SerializedName("streamable")
    @Expose
    var streamable: Streamable?,
    @SerializedName("url")
    @Expose
    var url: String?
)
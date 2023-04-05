package com.example.musicwiki.api.genresresponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Tags(
    @SerializedName("@attr")
    @Expose
    var attr: Attr,
    @SerializedName("tag")
    @Expose
    var tag: List<Tag>
)
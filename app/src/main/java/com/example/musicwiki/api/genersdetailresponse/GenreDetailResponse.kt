package com.example.musicwiki.api.genersdetailresponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GenreDetailResponse(
    @SerializedName("tag")
    @Expose
    var tag: Tag
)
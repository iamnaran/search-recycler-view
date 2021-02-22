package com.template.androidtemplate.data.model
import com.google.gson.annotations.SerializedName



data class Photos(
    @SerializedName("author")
    var author: String, // Matthew Wiebe
    @SerializedName("download_url")
    var downloadUrl: String, // https://picsum.photos/id/1025/4951/3301
    @SerializedName("height")
    var height: Int, // 3301
    @SerializedName("id")
    var id: String, // 1025
    @SerializedName("url")
    var url: String, // https://unsplash.com/photos/U5rMrSI7Pn4
    @SerializedName("width")
    var width: Int // 4951
)
package com.template.androidtemplate.data.model
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("status")
    var status: Boolean, // true
    @SerializedName("user_details")
    var userDetails: UserDetails
){

    data class UserDetails(
        @SerializedName("contact")
        var contact: String, // 9194648464
        @SerializedName("email")
        var email: String, // oleka@gmail.com
        @SerializedName("first_name")
        var firstName: String, // Osan Thanet
        @SerializedName("id")
        var id: Int, // 5019
        @SerializedName("image")
        var image: String, // https://elibrary.smartgov.app/storage/img/user/1596902851name.jpg
        @SerializedName("token")
        var token: String // Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL2VsaWJyYXJ5LnNtYXJ0Z292LmFwcC9hcGkvbG9naW4iLCJpYXQiOjE2MDYyMDQzODcsImV4cCI6NzA0OTQwNDM4NywibmJmIjoxNjA2MjA0Mzg3LCJqdGkiOiJ4MXNLVlpsS2Vhc1FaVFlQIiwic3ViIjo1MDE5LCJwcnYiOiJiOTEyNzk5NzhmMTFhYTdiYzU2NzA0ODdmZmYwMWUyMjgyNTNmZTQ4In0.AxJXK-5Wac3fImbLsvBKQLj8EanITsketgq7FMeXMnA
    )
}

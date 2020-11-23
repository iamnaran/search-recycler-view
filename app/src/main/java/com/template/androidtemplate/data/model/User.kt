package com.template.androidtemplate.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User(
    @SerializedName("response_code")
    var responseCode: String, // success
    @SerializedName("response_data")
    var responseData: ResponseData,
    @SerializedName("response_msg")
    var responseMsg: String // Logged in successfully.
){
    data class ResponseData(
        @SerializedName("activated")
        var activated: String, // 1
        @SerializedName("activation_expiry")
        var activationExpiry: String, // 2020-11-10 10:28:44
        @SerializedName("activation_key")
        var activationKey: String, // 9d85c4c958682ef0f5be7c1b0330804c
        @SerializedName("address")
        var address: Any, // null
        @SerializedName("allergies")
        var allergies: String, // n/a
        @SerializedName("api_login_token")
        var apiLoginToken: String, // 88-QZPXwZ6ObQp99jnD
        @SerializedName("bio")
        var bio: String, // <ol>	<li>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&#39;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</li>	<li>jksf ioo oip</li></ol>
        @SerializedName("card_info")
        var cardInfo: CardInfo,
        @SerializedName("community_url")
        var communityUrl: String, // https://idemo.thecommunitycloud.com
        @SerializedName("company")
        var company: String, // The Innovia Group
        @SerializedName("created_at")
        var createdAt: String, // 2015-04-15 06:17:13
        @SerializedName("default_phone")
        var defaultPhone: String, // home
        @SerializedName("degree")
        var degree: String, // BS
        @SerializedName("deleted_at")
        var deletedAt: Any, // null
        @SerializedName("dob")
        var dob: String, // 2013-05-14
        @SerializedName("email")
        var email: String, // stage@thecommunitycloud.com
        @SerializedName("ethnicity")
        var ethnicity: String, // African American
        @SerializedName("experience")
        var experience: String, // 20
        @SerializedName("feedback_complete")
        var feedbackComplete: Int, // 1
        @SerializedName("firstname")
        var firstname: String, // Robert
        @SerializedName("forgot_password_expiry")
        var forgotPasswordExpiry: String, // 2015-08-11 13:09:29
        @SerializedName("forgot_password_key")
        var forgotPasswordKey: String, // 15d422f5728dae10f0a1f9bcace8faa8
        @SerializedName("fullname")
        var fullname: String, // Robert B
        @SerializedName("gender")
        var gender: String, // Male
        @SerializedName("grade")
        var grade: String, // 0
        @SerializedName("home_phone")
        var homePhone: String, // 1245789631
        @SerializedName("id")
        var id: String, // 84
        @SerializedName("image")
        var image: String, // 159255848054885206511.jpeg
        @SerializedName("image_list")
        var imageList: ImageList,
        @SerializedName("industry_id")
        var industryId: String, // 1
        @SerializedName("is_enterprise")
        var isEnterprise: Boolean, // true
        @SerializedName("is_qb_user")
        var isQbUser: Boolean, // true
        @SerializedName("is_verified")
        var isVerified: Boolean, // true
        @SerializedName("languages")
        var languages: String, // English
        @SerializedName("lastname")
        var lastname: String, // B
        @SerializedName("new_email")
        var newEmail: String,
        @SerializedName("org_user_id")
        var orgUserId: String, // 88
        @SerializedName("organization_id")
        var organizationId: String, // 10
        @SerializedName("parent_user_id")
        var parentUserId: Any, // null
        @SerializedName("phone")
        var phone: String, // 1245789631
        @SerializedName("place_of_birth")
        var placeOfBirth: String, // n/a
        @SerializedName("prefix")
        var prefix: String, // Mr.
        @SerializedName("profile_complete")
        var profileComplete: Int, // 1
        @SerializedName("qbo_customer_id")
        var qboCustomerId: Any, // null
        @SerializedName("race")
        var race: String, // n/a
        @SerializedName("remember_me")
        var rememberMe: String, // 0
        @SerializedName("social_id")
        var socialId: Any, // null
        @SerializedName("suffix")
        var suffix: String,
        @SerializedName("temp_login_token")
        var tempLoginToken: Any, // null
        @SerializedName("title")
        var title: String, // Donor
        @SerializedName("tshirtsize")
        var tshirtsize: String, // n/a
        @SerializedName("university")
        var university: String, // Brooklyn
        @SerializedName("unverified_message")
        var unverifiedMessage: String, // Hello Robert,                    You have completed your registration.                    However, you can not access options until you are verified by the administrator.                    Please follow-up with the community if you have any questions.
        @SerializedName("updated_at")
        var updatedAt: String, // 2020-11-10 10:28:44
        @SerializedName("userType")
        var userType: String, // 0
        @SerializedName("username")
        var username: String, // idemo
        @SerializedName("work_phone")
        var workPhone: String
    ){
        data class CardInfo(
            @SerializedName("auto_update")
            var autoUpdate: Boolean, // false
            @SerializedName("backing_instrument_name")
            var backingInstrumentName: Any, // null
            @SerializedName("bin")
            var bin: String, // 424242
            @SerializedName("card_on_file")
            var cardOnFile: Boolean, // false
            @SerializedName("create_time")
            var createTime: Int, // 1577173733
            @SerializedName("credit_card_id")
            var creditCardId: Int, // 824074791
            @SerializedName("credit_card_name")
            var creditCardName: String, // Visa xxxxxx4242
            @SerializedName("cvv_provided")
            var cvvProvided: Boolean, // true
            @SerializedName("email")
            var email: String, // amritchang@gmail.com
            @SerializedName("expiration_month")
            var expirationMonth: Int, // 10
            @SerializedName("expiration_year")
            var expirationYear: Int, // 2021
            @SerializedName("input_source")
            var inputSource: String, // card_keyed
            @SerializedName("last_four")
            var lastFour: String, // 4242
            @SerializedName("recurring")
            var recurring: Boolean, // false
            @SerializedName("state")
            var state: String, // authorized
            @SerializedName("user_name")
            var userName: String, // Amrit Giri
            @SerializedName("virtual_terminal_mode")
            var virtualTerminalMode: String // none
        )

        data class ImageList(
            @SerializedName("large")
            var large: String, // https://community-cloud.s3.amazonaws.com/uploads/CC/10/media/medialibrary/images/large/159255848054885206511.jpeg
            @SerializedName("small")
            var small: String, // https://community-cloud.s3.amazonaws.com/uploads/CC/10/media/medialibrary/images/small/159255848054885206511.jpeg
            @SerializedName("thumbnail")
            var thumbnail: String // https://community-cloud.s3.amazonaws.com/uploads/CC/10/media/medialibrary/images/thumbnail/159255848054885206511.jpeg
        )
    }
}





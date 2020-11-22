package com.template.androidtemplate.data.model

import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class User(
    @Json(name = "response_code")
    val responseCode: String, // success
    @Json(name = "response_data")
    val responseData: ResponseData,
    @Json(name = "response_msg")
    val responseMsg: String // Logged in successfully.

) : Serializable {
    @JsonClass(generateAdapter = true)
    data class ResponseData(
        @Json(name = "activated")
        val activated: String, // 1
        @Json(name = "activation_expiry")
        val activationExpiry: String, // 2020-11-10 10:28:44
        @Json(name = "activation_key")
        val activationKey: String, // 9d85c4c958682ef0f5be7c1b0330804c
        @Json(name = "address")
        val address: Any, // null
        @Json(name = "allergies")
        val allergies: String, // n/a
        @Json(name = "api_login_token")
        val apiLoginToken: String, // 88-3aF5B1tlMjffzuwG
        @Json(name = "bio")
        val bio: String, // <ol>	<li>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&#39;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</li>	<li>jksf ioo oip</li></ol>
        @Json(name = "card_info")
        val cardInfo: CardInfo,
        @Json(name = "community_url")
        val communityUrl: String, // https://idemo.thecommunitycloud.com
        @Json(name = "company")
        val company: String, // The Innovia Group
        @Json(name = "created_at")
        val createdAt: String, // 2015-04-15 06:17:13
        @Json(name = "default_phone")
        val defaultPhone: String, // home
        @Json(name = "degree")
        val degree: String, // BS
        @Json(name = "deleted_at")
        val deletedAt: Any, // null
        @Json(name = "dob")
        val dob: String, // 2013-05-14
        @Json(name = "email")
        val email: String, // stage@thecommunitycloud.com
        @Json(name = "ethnicity")
        val ethnicity: String, // African American
        @Json(name = "experience")
        val experience: String, // 20
        @Json(name = "feedback_complete")
        val feedbackComplete: Int, // 1
        @Json(name = "firstname")
        val firstname: String, // Robert
        @Json(name = "forgot_password_expiry")
        val forgotPasswordExpiry: String, // 2015-08-11 13:09:29
        @Json(name = "forgot_password_key")
        val forgotPasswordKey: String, // 15d422f5728dae10f0a1f9bcace8faa8
        @Json(name = "fullname")
        val fullname: String, // Robert B
        @Json(name = "gender")
        val gender: String, // Male
        @Json(name = "grade")
        val grade: String, // 0
        @Json(name = "home_phone")
        val homePhone: String, // 1245789631
        @Json(name = "id")
        val id: String, // 84
        @Json(name = "image")
        val image: String, // 159255848054885206511.jpeg
        @Json(name = "image_list")
        val imageList: ImageList,
        @Json(name = "industry_id")
        val industryId: String, // 1
        @Json(name = "is_enterprise")
        val isEnterprise: Boolean, // true
        @Json(name = "is_qb_user")
        val isQbUser: Boolean, // true
        @Json(name = "is_verified")
        val isVerified: Boolean, // true
        @Json(name = "languages")
        val languages: String, // English
        @Json(name = "lastname")
        val lastname: String, // B
        @Json(name = "new_email")
        val newEmail: String,
        @Json(name = "org_user_id")
        val orgUserId: String, // 88
        @Json(name = "organization_id")
        val organizationId: String, // 10
        @Json(name = "parent_user_id")
        val parentUserId: Any, // null
        @Json(name = "phone")
        val phone: String, // 1245789631
        @Json(name = "place_of_birth")
        val placeOfBirth: String, // n/a
        @Json(name = "prefix")
        val prefix: String, // Mr.
        @Json(name = "profile_complete")
        val profileComplete: Int, // 1
        @Json(name = "qbo_customer_id")
        val qboCustomerId: Any, // null
        @Json(name = "race")
        val race: String, // n/a
        @Json(name = "remember_me")
        val rememberMe: String, // 0
        @Json(name = "social_id")
        val socialId: Any, // null
        @Json(name = "suffix")
        val suffix: String,
        @Json(name = "temp_login_token")
        val tempLoginToken: Any, // null
        @Json(name = "title")
        val title: String, // Donor
        @Json(name = "tshirtsize")
        val tshirtsize: String, // n/a
        @Json(name = "university")
        val university: String, // Brooklyn
        @Json(name = "unverified_message")
        val unverifiedMessage: String, // Hello Robert,                    You have completed your registration.                    However, you can not access options until you are verified by the administrator.                    Please follow-up with the community if you have any questions.
        @Json(name = "updated_at")
        val updatedAt: String, // 2020-11-10 10:28:44
        @Json(name = "userType")
        val userType: String, // 0
        @Json(name = "username")
        val username: String, // idemo
        @Json(name = "work_phone")
        val workPhone: String
    ) {
        @JsonClass(generateAdapter = true)
        data class CardInfo(
            @Json(name = "auto_update")
            val autoUpdate: Boolean, // false
            @Json(name = "backing_instrument_name")
            val backingInstrumentName: Any, // null
            @Json(name = "bin")
            val bin: String, // 424242
            @Json(name = "card_on_file")
            val cardOnFile: Boolean, // false
            @Json(name = "create_time")
            val createTime: Int, // 1577173733
            @Json(name = "credit_card_id")
            val creditCardId: Int, // 824074791
            @Json(name = "credit_card_name")
            val creditCardName: String, // Visa xxxxxx4242
            @Json(name = "cvv_provided")
            val cvvProvided: Boolean, // true
            @Json(name = "email")
            val email: String, // amritchang@gmail.com
            @Json(name = "expiration_month")
            val expirationMonth: Int, // 10
            @Json(name = "expiration_year")
            val expirationYear: Int, // 2021
            @Json(name = "input_source")
            val inputSource: String, // card_keyed
            @Json(name = "last_four")
            val lastFour: String, // 4242
            @Json(name = "recurring")
            val recurring: Boolean, // false
            @Json(name = "state")
            val state: String, // authorized
            @Json(name = "user_name")
            val userName: String, // Amrit Giri
            @Json(name = "virtual_terminal_mode")
            val virtualTerminalMode: String // none
        )

        @JsonClass(generateAdapter = true)
        data class ImageList(
            @Json(name = "large")
            val large: String, // https://community-cloud.s3.amazonaws.com/uploads/CC/10/media/medialibrary/images/large/159255848054885206511.jpeg
            @Json(name = "small")
            val small: String, // https://community-cloud.s3.amazonaws.com/uploads/CC/10/media/medialibrary/images/small/159255848054885206511.jpeg
            @Json(name = "thumbnail")
            val thumbnail: String // https://community-cloud.s3.amazonaws.com/uploads/CC/10/media/medialibrary/images/thumbnail/159255848054885206511.jpeg
        )
    }
}






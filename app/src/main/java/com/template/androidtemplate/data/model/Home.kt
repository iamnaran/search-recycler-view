package com.template.androidtemplate.data.model

import com.google.gson.annotations.SerializedName


data class Home(
    @SerializedName("categories_list")
    var categoriesList: List<Categories>,
    @SerializedName("home_list")
    var homeList: List<HomeX>,
    @SerializedName("status")
    var status: Boolean, // true
    @SerializedName("total_book")
    var totalBook: Int, // 77
    @SerializedName("unseen_notice")
    var unseenNotice: Int // 139
) {
    data class Categories(
        @SerializedName("id")
        var id: Int, // 27
        @SerializedName("image")
        var image: String, // https://elibrary.smartgov.app/storage/img/categories/1565609176shutterstock_522019972.jpg
        @SerializedName("name")
        var name: String // Novels
    )

    data class HomeX(
        @SerializedName("booklists")
        var booklists: List<Booklists>,
        @SerializedName("id")
        var id: String, // latest_books
        @SerializedName("title")
        var title: String // Recent Releases
    ) {

        data class Booklists(
            @SerializedName("author_name")
            var authorName: String, // Olivia Summers
            @SerializedName("description")
            var description: String, // <p>Yoga For Men is Taking Over the Fitness World!<br />Have you always believed that yoga was merely for hot girls in tight clothes? Well, sorry guys, but I'm here to shatter that belief!<br /><br /><strong>Despite what you might think, yoga was developed&nbsp;<em>by</em>&nbsp;men,&nbsp;<em>for</em>&nbsp;men.</strong><br /><br />Yes, over 5,000 years ago the first yoga poses were created by men. So why not reinvent your manliness by taking up modern yoga as a total body workout?<br /><br />Regular yoga practice has the ability to empower your mind, strengthen your body and transform your life...<br />As a Certified Yoga Teacher, I'm here to give you the tools you need to reshape your life through yoga in just 10 minutes a day!<br /><br />That's right...you'll be able to invest just a few minutes a day and in a matter of a month you'll have mastered 30 different yoga poses to give you a sexy body, more confidence and a focused mind. That's not enough?<br /><br />Well, Here's What You Can Expect...<br />Learn why yoga is for men Understand the basics of yoga and why you don't need to be flexible How to take back your health with a few simple poses...in just 30 days Why you should always do a warm-up before you practice How to modify your yoga workout to fit your needs and injuries 30 Challenging Poses (with Pictures!) to take your exercise routine to the next level A Guide to developing your own personal yoga workout Why breathing techniques are so important--and how to use them to de-stress Full length core yoga workout to target your abs and get a 6-pack Why practicing yoga will make your sex life better How you can use yoga for recovery from injuries Plus so much more! So if you're ready to transform your mind and body and feel amazing (in and out of the bedroom), then Yoga For Men is the answer you've been looking for!</p>
            @SerializedName("favourite")
            var favourite: Int, // 0
            @SerializedName("featured_image")
            var featuredImage: String, // https://elibrary.smartgov.app/storage/img/zCZRZXcG7jBZckiVjw032WlUOjNdtP94LJfZolA9.jpeg
            @SerializedName("id")
            var id: Int, // 195
            @SerializedName("name")
            var name: String, // Yoga: A Man’s Guide
            @SerializedName("publish_by")
            var publishBy: String, // Upasarga Technology
            @SerializedName("published_date")
            var publishedDate: String, // 2020-11-24 05:51:51
            @SerializedName("rating")
            var rating: Any, // null
            @SerializedName("type")
            var type: String, // File
            @SerializedName("url")
            var url: String // https://elibrary.smartgov.app/storage/img/bhEtJZ1BTUcRTbjlfsuayTBgVEYy1hVMpeWTFmVU.pdf
        )
    }

}





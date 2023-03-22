package com.example.side_project_puppy_mobile.service

import retrofit2.Response
import retrofit2.http.GET

interface TrailService {
    @GET("/api/book")
    suspend fun getTrail(
    //		@Header("AccessToken") accessToken: String,
    //		@Path("bookId") bookId: String,
    //		@Query("author") author: String,
    //		@Body body: BookDto
    ) : Response<Int>
}
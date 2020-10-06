package com.zackmatthews.yelpmvvmkotlin.yelp

/**
 * Serves as the entry point for Yelp fusion API.
 * todo: Clean up with Dagger or Service Locator pattern
 *
 */
class YelpService {
    fun createApi(): YelpApi {
        return YelpApi()
    }
}
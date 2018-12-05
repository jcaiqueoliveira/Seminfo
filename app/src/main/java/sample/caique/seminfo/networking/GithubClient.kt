package sample.caique.seminfo.networking

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import sample.caique.seminfo.response.Issues
import sample.caique.seminfo.response.Repository

/**
 * https://www.infoq.com/br/articles/rest-introduction
 */
interface GithubClient {

    @Headers("Accept: application/vnd.github.mercy-preview+json")
    @GET("search/repositories?q=android%20language:kotlin&sort=stars&order=desc&per_page=10")
    fun retrieveTrends(): Call<Repository>


    @Headers("Accept: application/vnd.github.mercy-preview+json")
    @GET("repos/{user}/{repo}/issues")
    fun retrieveIssues(@Path("user") user: String, @Path("repo") repo: String): Call<ArrayList<Issues>>

}
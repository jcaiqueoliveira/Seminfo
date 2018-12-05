package sample.caique.seminfo.networking

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import sample.caique.seminfo.domain.RepositoryOverview
import sample.caique.seminfo.domain.Result
import sample.caique.seminfo.domain.service.ListService
import sample.caique.seminfo.mapper.ErrorMapper
import sample.caique.seminfo.mapper.RepositoryMapper
import sample.caique.seminfo.response.Repository

class ListRepositoriesInfraStructure(private val retrofit: Retrofit) : ListService {

    private val api by lazy { retrofit.create(GithubClient::class.java) }

    override fun list(result: Result<List<RepositoryOverview>>) {

        api.retrieveTrends().enqueue(object : Callback<Repository> {
            override fun onResponse(call: Call<Repository>, response: Response<Repository>) {
                with(response) {
                    when (isSuccessful) {
                        true -> {
                            body()?.let { result.success(RepositoryMapper(it)) } ?: result.error(ErrorMapper(code()))
                        }
                        false -> result.error(ErrorMapper(response.code()))
                    }
                }
            }

            override fun onFailure(call: Call<Repository>, t: Throwable) {
                result.error(t)
            }
        })
    }
}
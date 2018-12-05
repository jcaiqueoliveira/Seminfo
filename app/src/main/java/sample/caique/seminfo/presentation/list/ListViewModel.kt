package sample.caique.seminfo.presentation.list

import sample.caique.seminfo.domain.RepositoryOverview
import sample.caique.seminfo.domain.Result
import sample.caique.seminfo.domain.service.ListService

class ListViewModel(private val api: ListService) {

    fun listRepositories(result: Result<List<RepositoryOverview>>) {
        api.list(result)
    }
}
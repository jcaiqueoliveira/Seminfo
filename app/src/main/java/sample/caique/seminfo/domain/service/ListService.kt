package sample.caique.seminfo.domain.service

import sample.caique.seminfo.domain.RepositoryOverview
import sample.caique.seminfo.domain.Result

interface ListService {

    fun list(result: Result<List<RepositoryOverview>>)
}
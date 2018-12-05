package sample.caique.seminfo.mapper

import sample.caique.seminfo.domain.RepositoryOverview
import sample.caique.seminfo.response.Repository

internal object RepositoryMapper {

    operator fun invoke(repo: Repository): List<RepositoryOverview> {
        return repo.items.map {
            RepositoryOverview(
                id = it.id,
                name = it.name,
                url = it.htmlUrl,
                apiUrl = it.url,
                description = it.description,
                starCount = it.stars,
                watcherCount = it.watcher,
                forkCount = it.forks,
                imgUrl = it.owner.imgUrl
            )
        }
    }
}
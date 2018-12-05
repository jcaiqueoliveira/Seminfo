package sample.caique.seminfo.instances

import sample.caique.seminfo.networking.ListRepositoriesInfraStructure
import sample.caique.seminfo.networking.RetrofitBuilder
import sample.caique.seminfo.presentation.list.ListViewModel

object Instances {

    fun getListViewModel(url: String): ListViewModel {

        val retrofit = RetrofitBuilder(url)
        val infra = ListRepositoriesInfraStructure(retrofit)

        return ListViewModel(infra)
    }
}
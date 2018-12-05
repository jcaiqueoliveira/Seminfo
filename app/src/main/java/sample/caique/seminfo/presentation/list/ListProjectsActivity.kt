package sample.caique.seminfo.presentation.list

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list_projects.*
import sample.caique.seminfo.R
import sample.caique.seminfo.SeminfoApplication
import sample.caique.seminfo.domain.RepositoryOverview
import sample.caique.seminfo.domain.Result
import sample.caique.seminfo.instances.Instances

class ListProjectsActivity : AppCompatActivity() {

    private val application by lazy { applicationContext as SeminfoApplication }
    private val viewModel by lazy { Instances.getListViewModel(application.url) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_projects)

        setUpList()

        start()
        requestListRepositories()
    }

    private fun start() {
        skeleton.visibility = View.VISIBLE
    }

    private fun requestListRepositories() {
        viewModel.listRepositories(manageScreen())
    }

    private fun setUpList() {
        with(listTrends) {
            layoutManager = LinearLayoutManager(this@ListProjectsActivity)
        }
    }

    private fun populateList(list: List<RepositoryOverview>) {
        val adapter = RepositoriesAdapter(list)
        listTrends.adapter = adapter

        skeleton.visibility = View.GONE
    }


    private fun manageScreen(): Result<List<RepositoryOverview>> = object : Result<List<RepositoryOverview>> {
        override fun success(info: List<RepositoryOverview>) {
            populateList(info)
        }

        override fun error(error: Throwable) {

            skeleton.visibility = View.GONE

            error.printStackTrace()
            Toast.makeText(this@ListProjectsActivity, "Não foi possível listar os repositórios", Toast.LENGTH_LONG)
                .show()
        }
    }
}

package sample.caique.seminfo.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_repository.view.*
import sample.caique.seminfo.R
import sample.caique.seminfo.domain.RepositoryOverview

/**
 * https://medium.com/collabcode/criando-lista-com-recyclerview-no-android-com-kotlin-85cb76f3775d
 */

class RepositoriesAdapter(private val list: List<RepositoryOverview>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = list[position]

        with(holder.itemView) {

            name.text = item.name
            description.text = item.description

            stars.text = "${item.starCount}"
            forks.text = "${item.forkCount}"
            watchers.text = "${item.watcherCount}"
        }
    }

}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
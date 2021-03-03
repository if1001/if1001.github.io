package br.ufpe.cin.android.datamanagement

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import br.ufpe.cin.android.datamanagement.databinding.PessoaBinding

class ProfessorAdapter(
    private val inflater: LayoutInflater) :
    ListAdapter<Professor,ProfessorViewHolder>(ProfessorDiffer)
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfessorViewHolder {
        val binding = PessoaBinding.inflate(inflater, parent, false)
        return ProfessorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProfessorViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    private object ProfessorDiffer : DiffUtil.ItemCallback<Professor>() {
        override fun areItemsTheSame(oldItem: Professor, newItem: Professor): Boolean {
            return oldItem.login == newItem.login
        }

        override fun areContentsTheSame(oldItem: Professor, newItem: Professor): Boolean {
            return oldItem == newItem
        }

    }
}
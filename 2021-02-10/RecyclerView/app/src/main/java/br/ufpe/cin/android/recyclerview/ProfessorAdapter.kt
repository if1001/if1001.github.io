package br.ufpe.cin.android.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.ufpe.cin.android.recyclerview.databinding.LinhaBinding

class ProfessorAdapter(
    private val professores:Array<Professor>,
    private val inflater: LayoutInflater) :
    RecyclerView.Adapter<ProfessorViewHolder>()
{
    override fun getItemCount(): Int = professores.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfessorViewHolder {
        val binding = LinhaBinding.inflate(inflater, parent, false)
        return ProfessorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProfessorViewHolder, position: Int) {
        holder.bindTo(professores[position])
    }
}
package com.codebear.simpletakenotes.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codebear.simpletakenotes.databinding.ItemNoteBinding
import com.codebear.simpletakenotes.domain.models.NoteModel

class NotesAdapter(
    val items: List<NoteModel>
) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        p1: Int
    ): NotesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemNoteBinding = ItemNoteBinding.inflate(layoutInflater, parent, false)
        return NotesViewHolder(itemNoteBinding)
    }

    override fun onBindViewHolder(
        viewHolder: NotesViewHolder,
        index: Int
    ) {
        Log.e("TAG", "onBindViewHolder: $viewHolder")
        val note = items[index]
        viewHolder.itemNoteBinding.tvTitle.text = note.title
        viewHolder.itemNoteBinding.tvContent.text = note.content
    }


    inner class NotesViewHolder(val itemNoteBinding: ItemNoteBinding) :
        RecyclerView.ViewHolder(itemNoteBinding.root)
}
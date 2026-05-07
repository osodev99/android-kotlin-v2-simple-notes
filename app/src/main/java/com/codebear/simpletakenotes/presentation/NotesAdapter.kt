package com.codebear.simpletakenotes.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codebear.simpletakenotes.databinding.ItemNoteBinding
import com.codebear.simpletakenotes.domain.models.NoteModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class NotesAdapter(
    val items: MutableList<NoteModel>,
    val onTap: (note: NoteModel) -> Unit
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
        viewHolder.itemNoteBinding.tvDate.text = toStringDate(note.createdAt)
        viewHolder.itemNoteBinding.root.setOnClickListener { onTap(note) }
    }

    private fun toStringDate(value: Long): String {
        val date = Date(value)
        return SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault()).format(date)
    }


    inner class NotesViewHolder(val itemNoteBinding: ItemNoteBinding) :
        RecyclerView.ViewHolder(itemNoteBinding.root)
}
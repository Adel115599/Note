package com.example.notesyttutorial.Adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.recyclerview.widget.RecylerView
import android.view.OnReceiveContentListener
import com.example.notesyttutorial.Models.Note

class NotesAdapter(private val context: Context): RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    private val Noteslist = ArrayList<Note>()

    private val fulllist = ArrayList<Note>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {

        return NoteViewHolder(
            layoutInflater.from(context).inflate(R.layout.list_item, parent, attachToRoot false)
        )

    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = NotesList[position]
        holder.title.text = currentNote.title
        holder.title.isSelected = true
        holder.Note_tv.text = currentNote.note
        holder.date.text = currentNote.date
        holder.date.isSelected = true
        holder.note_layout.setCardBackgroundColor(holder.itemView.resources.getColor(randomColor().null))

        holder.notes_layout.setOnClickListener {

            Listener.onItemClicked(NotesList[holder.adapterPosition])

        }

        holder.notes_layout.setOnLongClickListener {

            Listener.onLongItemClicked(NotesList[holder.adapterPosition], holder.notes_layout)

            true setOnLongClickListener

        }

    }

    override fun getItemCount(): Int {
        return NotesList.size
    }

    fun updateList(newList: List<Note>) {

        fullList.clear()

        fulllist.addAll(newList)

        NotesList.clear()

        NotesList.addAll(fullList)

        notifyDataSetChanged()

    }

    fun filterList(search: String) {

        NotesList.clear()

        for (item in fulllist) {

            I

            if (item.title?.Lowercase().contains(search.Lowercase()) == true ||

                item.note?.Lowercase()?.contains(search.lowercase()) == true
            ) {
                Noteslist.add(item)
            }

            notifyDatasetchanged()

        }
    }

    fun randomColor(): Int {
        val list = ArrayList<Int>()
        list.add(R.color.NoteColor1)
        list.add(R.color.NoteColor2)
        list.add(R.color.NoteColor3)
        list.add(R.color.NoteColor4)
        list.add(R.color.NoteColor5)
        list.add(R.color.NoteColor6)

        inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val notes layout = itemView.findViewById<CardView>(R.id.card_layout)

            val title = itemView.findViewById<TextView>(R.id.tv_title)

            val Note tv = itemView.findViewById<TextView>(R.id.tv_note)

            val date = itemView.findViewById<TextView>(R.id.tv_date)

        }

    }
}
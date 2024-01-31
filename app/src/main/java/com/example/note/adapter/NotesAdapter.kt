package com.example.note.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.note.R
import com.example.note.models.Note

class NotesAdapter(private val context: Context): RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {


    private val Noteslist = ArrayList<Note>()

    private val fulllist = ArrayList<Note>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent,  false)
        return NoteViewHolder(
            view
        )

    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = Noteslist[position]
        holder.title.text = currentNote.title
        holder.title.isSelected = true
        holder.Notetv.text = currentNote.note
        holder.date.text = currentNote.date
        holder.date.isSelected = true
        holder.notes.setCardBackgroundColor(holder.itemView.resources.getColor(randomColor()))

        holder.notes.setOnClickListener {

           // Listener.onItemClicked(NotesList[holder.adapterPosition])
            Toast.makeText(context,"LongPress",Toast.LENGTH_LONG).show()


        }

    }

    override fun getItemCount(): Int {
        return Noteslist.size
    }

    fun updateList(newList: List<Note>) {
        Noteslist.clear()

        Noteslist.addAll(newList)

        notifyDataSetChanged()

    }



    fun randomColor() : Int {
        val list = ArrayList<Int>()
        list.add(R.color.confirm)
        return list[0]
    }
    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val notes  = itemView.findViewById<CardView>(R.id.card_layout)

        val title = itemView.findViewById<TextView>(R.id.tv_title)

        val Notetv  = itemView.findViewById<TextView>(R.id.tv_note)

        val date = itemView.findViewById<TextView>(R.id.tv_date)

    }

}
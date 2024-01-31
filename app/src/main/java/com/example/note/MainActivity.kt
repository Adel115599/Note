package com.example.note

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.note.databinding.ActivityMainBinding
import com.example.note.models.Note
import com.example.note.models.NoteViewModel
import com.example.note.adapter.NotesAdapter


class MainActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener{

private lateinit var binding: ActivityMainBinding
lateinit var vienmodel: NoteViewModel
lateinit var adapterNote: NotesAdapter
lateinit var selectedNote: Note




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()

        vienmodel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)

        vienmodel.allnotes.observe(this) { list ->

            list?.let {
                adapterNote.updateList(list)
            }
        }
    }

    private fun initUI() {

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)
        adapterNote = NotesAdapter(this)
        binding.recyclerView.adapter = adapterNote



        binding.fbAddNote.setOnClickListener {

            val intent: Intent = Intent(this@MainActivity, AddNote::class.java)
            startActivity(intent)

        }


        /*binding.searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(pe: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    adapter.filterList(newText)
                }
                return true
            }
        })*/
    }



     private fun popUpDisplay(cardview: CardView) {
/*
         val popup = PopupMenu(this, R.layout.activity_main)
         popup.setOnMenuItemClickListener(this@MainActivity)
         popup.inflate(R.menu.pop_up_menu)
         popup.show()*/
     }

      override fun onMenuItemClick(item: MenuItem?): Boolean {
/*
          if (item?.itemId == R.id.delete_note) {

              vienmodel.deleteNote(selectedNote)
              return true
          }*/
              return false
      }
}
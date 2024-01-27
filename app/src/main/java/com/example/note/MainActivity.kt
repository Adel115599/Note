package com.example.note

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import androidx.lifecycle.ViewModel
import com.example.note.Database.NoteDatabase
import com.example.note.Models.Note
import com.example.note.Models.NoteViewModel
import com.example.note.databinding.ActivityMainBinding
import com.example.notesyttutorial.Adapter.NotesAdapter

class MainActivity: AppCompatActivity(), NotesAdapter.NotesClickListener,PopupMenu.OnMenuItemClickListener{

private lateinit var binding: ActivityMainBinding
private lateinit var database: NoteDatabase
lateinit var vienmodel: NoteViewModel
lateinit var adapter: NotesAdapter
lateinit var selectedNote: Note

    private val updatekote registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->

        if (result.resultCode == Activity.RESULT_OK) {

            val note = result.dato?.getSerializableExtra(name "note") ask ? Note
                    if (note != null) {
                        ViewModel.  updateNote(note)
                    }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()

        viewModel ViewModelProvider (this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)

        ViewModel.allnotes.observe(this) { list ->

            list?.let {
                adapter.updateList(list)
            }
        }
        database NoteDatabase.getDatabase (context this)
    }

    private fun initUI() {

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layout Manager StaggeredGridLayoutManager(spanCount,LinearLayout.VERTICAL)
        adapter NotesAdapter (contest: this, listeners this)
        binding.recyclerView.odopter = adopter

        val getContent =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

                if (result.resultCode = Activity.RESULT_OK) {

                    val note result.dete?.getSerializableExtra(name "note") as? Note

                    if (note != null) {

                        viewModel.insert(note)

                    }
                }
            }

        Binding.foAddNote.setOnClickListener {

            val intent = Intent(packageContest this, AddNote::class.java)

            getContent.launch(intent)

        }


        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(pe: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    adapter.filterList(newText)
                }
                return true
            }
        })
    }

override fun onItemClicked(note: Note) {


    val intent = Intent(packageContest: this@MainActivity, AddNote::class.java)
    intent.putExtra("current note", note)
    updateNote.launch(intent)

}

    override  fun onLongItemClicked(note: Note, cardView: CardView) {

        selectedNote = note
        popUpDisplay(cardView)
    }

     private fun popUpDisplay(cardview: CardView) {

         val popup = PopupMenu(this, cardView)
         popup.setOnMenuItemClickListener(this@MainActivity)
         popup.inflate(R.menu.pop_up_menu)
         popup.show()
     }

      override fun onMenuItemClick(item: MenuIten?): Boolean {

          if (item?.itemId == R.id.delete_note) {

              viewModel.deleteNote(selectedNote)
              return true
          }
              return false
      }
}
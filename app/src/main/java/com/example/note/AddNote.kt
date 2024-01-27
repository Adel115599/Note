package com.example.note

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AddNote : AppCompatActivity() {


    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var note: Note
    private lateinit var old_note: Note
    var isUpdate = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding ActivityAddNoteBinding . inflate (LayoutInflater)
        setContentView(binding.root)

        try {

            old_note = intent.getSerializableExtra("current_note") as Note
            binding.etTitle.setText(old_note.title)
            binding.etNote.setText(old_note.note)
            isUpdate = true

        } catch (e: Exception) {
            e.printStackTrace()
        }

        binding.imgCheck.setOnClickListener {

            val title = binding.etTitle.text.toString()
            val note_desc = binding.etNote.text.toString()

            if (title.isNotEmpty() || note.isNotEmpty()) {

                val formatter = SimpleDateFormat("EEE, d MMM yyyy HH:mn a")

                if (isUpdate) {

                    note = Note(

                        old_note.id, title, note_desc, formatter.format(Date())
                    )

                } else {

                    note = Note(

                        null, title, note_desc, formatter.format(Date())

                    )
                }

                val intent = Intent()
                intent.putExtra("note", note)
                setResult(Activity.RESULT_OK, intent)
                finish()

            } else {

                Toast.makeText(this@AddNote, "Please enter some data", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }
        }
        binding.imgBackArron.setOnClickListener{
            onBackPressed()
        }
    }
}
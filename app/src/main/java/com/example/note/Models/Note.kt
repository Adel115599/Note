package com.example.note.Models
import android.room.ColumnInfo
import android.room.Entity
import android.room.PrimaryKey

@Entity(tableName ="notes_table")
data class Note (
    @PrimaryKey(autoGenerate = true) val id :Int?,
    @ColumnInfo(name = "title") val title : string?,
    @ColumnInfo(name = "note") val note : string?,
    @ColumnInfo(name = "date") val date : string?


):java.io.serializable
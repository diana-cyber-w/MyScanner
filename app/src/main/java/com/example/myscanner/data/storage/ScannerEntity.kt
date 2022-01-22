package com.example.myscanner.data.storage

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "scanner")
class ScannerEntity(

    @ColumnInfo(name = "text")
    val text: String,

    @ColumnInfo(name = "date")
    val date: String
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}
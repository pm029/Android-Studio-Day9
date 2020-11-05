package com.example.firstapplication

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.firstapplication.data.joinedList
import com.example.firstapplication.data.listbase

class MainActivity : AppCompatActivity() {
    var TAG = "Debug Message"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textEdit = findViewById<TextView>(R.id.textView)

        val firstbtn = findViewById<Button>(R.id.button)

        firstbtn.setOnClickListener {
            textEdit.text = listbase()
            Log.d(TAG, "${joinedList}")
            Toast.makeText(this, "Updating textview", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        //       menu?.getItem(1)?.isEnabled = false
        //       menu?.getItem(1)?.isVisible = false
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_add -> {
                var taskEditText = EditText(this)
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Title of dialog")
                builder.setView(taskEditText)
                //   builder.setMessage("Enter information")
                builder.setPositiveButton("Create") { _, _ ->
                    val name = taskEditText.text.toString().trim()
                    if (joinedList.contains(name)) {
                        Toast.makeText(applicationContext, "$name already in list", Toast.LENGTH_SHORT).show()
                    } else {
                        joinedList.add(name)
                        Toast.makeText(applicationContext, "Added to list", Toast.LENGTH_SHORT).show()
                        Log.d(TAG, "$joinedList")
                    }
                }
                builder.setNegativeButton("Cancel", null)
                builder.show()
                true

            }
            R.id.menu_remove -> {
                var taskEditText=EditText(this)
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Title of dialog")
                builder.setMessage("Enter some stuff..")
                builder.setView(taskEditText)
                builder.setPositiveButton("Create") { _, _ ->
                    val name = taskEditText.text.toString().trim()
                    if (joinedList.contains(name)) {
                        joinedList.remove(name)
                        Toast.makeText(applicationContext, "Success", Toast.LENGTH_SHORT).show()

                    } else {
                        Toast.makeText(applicationContext, "Failed to delete", Toast.LENGTH_SHORT).show()
                    }
                }
                    builder.setNegativeButton("Cancel",null)
                    builder.show()
                    true
            }
            else -> return super.onOptionsItemSelected(item)
        }

    }
}

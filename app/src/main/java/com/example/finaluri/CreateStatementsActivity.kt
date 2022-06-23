package com.example.finaluri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener



class CreateStatementsActivity : AppCompatActivity() {

    private lateinit var imageViewUserInput: ImageView
    private lateinit var editTextUserTitle: EditText
    private lateinit var editTextUserDescription: EditText
    private lateinit var editTextUserImageUrl: EditText
    private lateinit var buttonAddStatement: Button
    private lateinit var buttonAddImage: Button

    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseDatabase.getInstance().getReference("UserInfo")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_statements)


        init()

        registerListeners()

        db.child(auth.currentUser?.uid!!).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                val userInfo: UserInfo = snapshot.getValue(UserInfo::class.java) ?: return

                Glide.with(this@CreateStatementsActivity)
                    .load(userInfo.url)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(imageViewUserInput)

            }

            override fun onCancelled(error: DatabaseError) {
            }

        })

    }

    private fun init() {

        imageViewUserInput = findViewById(R.id.imageViewUserInput)
        editTextUserTitle = findViewById(R.id.editTextUserTitle)
        editTextUserDescription = findViewById(R.id.editTextUserDescription)
        editTextUserImageUrl = findViewById(R.id.editTextUserImageUrl)
        buttonAddStatement = findViewById(R.id.buttonAddStatement)
        buttonAddImage = findViewById(R.id.buttonAddImage)

    }

    private fun registerListeners() {

        buttonAddImage.setOnClickListener {

            val title = editTextUserTitle.text.toString()
            val description = editTextUserDescription.text.toString()
            val url = editTextUserImageUrl.text.toString()

            val userInfo = UserInfo(title, description, url)

            db.child(auth.currentUser?.uid!!).setValue(userInfo).addOnCompleteListener {
                Toast.makeText(this, "ფოტო ატვირთულია.", Toast.LENGTH_SHORT).show()
            }
        }
        buttonAddStatement.setOnClickListener {
            Toast.makeText(this, "განცხადება წარმატებით დაემატა!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
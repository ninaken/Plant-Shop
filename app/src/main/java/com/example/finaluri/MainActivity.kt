package com.example.finaluri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_reset.view.*
import kotlinx.android.synthetic.main.register_dialog.view.*

@Suppress("LABEL_NAME_CLASH")
class MainActivity : AppCompatActivity() {

    private lateinit var buttonLogin: Button
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonGuest: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        registerListeners()

        buttonResetPassword.setOnClickListener {
            val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_reset, null)
            val dialogBuilder = AlertDialog.Builder(this)
                .setView(dialogView)
                .setTitle("პაროლის აღდგენა")
            val alertDialog = dialogBuilder.show()

            dialogView.buttonSendEmail.setOnClickListener {
                val email = dialogView.editTextEmail.text.toString()

                if (email.isEmpty()) {
                    Toast.makeText(this, "ცარიელია.", Toast.LENGTH_SHORT).show()
                    alertDialog.dismiss()
                    return@setOnClickListener
                }
                FirebaseAuth.getInstance()
                    .sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "შეამოწმეთ თქვენი მეილი", Toast.LENGTH_SHORT).show()
                            alertDialog.dismiss()
                        } else {
                            Toast.makeText(this, "სისტემაში მოხდა შეცდომა", Toast.LENGTH_SHORT).show()
                            alertDialog.dismiss()
                        }
                    }
            }

        }

        buttonRegister.setOnClickListener {
            val dialogView = LayoutInflater.from(this).inflate(R.layout.register_dialog, null)
            val dialogBuilder = AlertDialog.Builder(this)
                .setView(dialogView)
                .setTitle("რეგისტრაცია")
            val alertDialog = dialogBuilder.show()

            dialogView.buttonRegisterRegister.setOnClickListener {
                val email = dialogView.editTextRegisterEmail.text.toString()
                val password = dialogView.editTextRegisterPassword.text.toString()

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(this, "ცარიელია.", Toast.LENGTH_SHORT).show()
                    alertDialog.dismiss()
                    return@setOnClickListener
                }
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "თქვენ წარმატებით დარეგისტრირდით.", Toast.LENGTH_SHORT).show()
                            alertDialog.dismiss()
                        } else {
                            Toast.makeText(this, "სისტემაში მოხდა შეცდომა.", Toast.LENGTH_SHORT).show()
                            alertDialog.dismiss()
                        }
                    }

            }
            dialogView.buttonCancel.setOnClickListener {
                alertDialog.dismiss()
                return@setOnClickListener
            }
        }
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.fragment)

        bottomNavigationView.setupWithNavController(navController)
    }

    private fun init() {

        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
        buttonGuest = findViewById(R.id.buttonGuest)

    }
    private fun registerListeners(){
        buttonLogin.setOnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(this,  "ცარიელია.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        startActivity(Intent(this, LoginActivity::class.java))
                    } else {
                        Toast.makeText(this, "სისტემაში მოხდა შეცდომა.", Toast.LENGTH_SHORT).show()
                    }
                }
        }
        buttonGuest.setOnClickListener {
            startActivity(Intent(this, StatementsActivity::class.java))
        }
    }
}
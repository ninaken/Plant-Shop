package com.example.finaluri

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.dialog_change_password.view.*


class LoginActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var buttonLogout: Button
    private lateinit var buttonAddStatements: Button
    private lateinit var buttonStatements: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()

        registerListeners()

        textView.text = "გამარჯობა, " + FirebaseAuth.getInstance().currentUser?.email + "!"

        buttonChangePasswordLogin.setOnClickListener {
            val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_change_password, null)
            val dialogBuilder = AlertDialog.Builder(this)
                .setView(dialogView)
                .setTitle("პაროლის შეცვლა")
            val alertDialog = dialogBuilder.show()

            dialogView.buttonChangePassword.setOnClickListener {
                val password = dialogView.editTextChangePassword.text.toString()
                val password2 = dialogView.editTextRepeatChangePassword.text.toString()


                if(password.isEmpty() || password2.isEmpty()){
                    Toast.makeText(this, "ცარიელია.", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                if (password != password2){
                    Toast.makeText(this, "პაროლები არ ემთხვევა!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                FirebaseAuth.getInstance().currentUser?.updatePassword(password)
                    ?.addOnCompleteListener { task ->
                        if(task.isSuccessful){
                            Toast.makeText(this, "პაროლი წარმატებით შეიცვალა!", Toast.LENGTH_SHORT).show()
                            alertDialog.dismiss()
                        }else{
                            Toast.makeText(this, "სისტემაში მოხდა შეცდომა.", Toast.LENGTH_SHORT).show()
                            alertDialog.dismiss()
                        }
                    }


            }
            dialogView.buttonCancelChangePassword.setOnClickListener {
                alertDialog.dismiss()
            }
        }



    }

    private fun init() {
        textView = findViewById(R.id.textView)
        buttonLogout = findViewById(R.id.buttonLogout)
        buttonAddStatements = findViewById(R.id.buttonAddStatements)
        buttonStatements = findViewById(R.id.buttonStatements)
    }

    private fun registerListeners() {
        buttonAddStatements.setOnClickListener {
            startActivity(Intent(this, CreateStatementsActivity::class.java))
        }
        buttonStatements.setOnClickListener {
            startActivity(Intent(this, StatementsActivity::class.java))
        }
        buttonLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

}
package edu.farmingdale.angal.navrams

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class NRLogInActivity : AppCompatActivity() {
    lateinit var fauth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nrlog_in)

        fauth = Firebase.auth
    }


    fun onLOgInTap(v: View) {
        var inpUsernameEmail: EditText?= findViewById(R.id.editTextUsername)
        var inpPassword: EditText?= findViewById(R.id.editTextTextPassword)

        fauth.signInWithEmailAndPassword(inpUsernameEmail?.text.toString(), inpPassword?.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(applicationContext,"SIGNED IN!",Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(applicationContext,"SOMETHING WENT WRONG!",Toast.LENGTH_LONG).show()
                }
            }
    }
}
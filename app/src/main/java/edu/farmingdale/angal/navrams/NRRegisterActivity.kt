package edu.farmingdale.angal.navrams

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class NRRegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nrregister)
    }


    fun onRegisterTap(v: View) {
        // grab all input fields
        var inputFieldFirstName: EditText? = findViewById(R.id.editTextTextPersonName2) // FIRST
        var inputFieldLastName: EditText? = findViewById(R.id.editTextTextPersonName3) // LAST
        var inputFieldUserName: EditText? = findViewById(R.id.editTextTextPersonName4) // USERNAME
        var inputFieldRamId: EditText? = findViewById(R.id.editTextTextPersonName5) // RAM ID
        var inputFieldPassword: EditText? = findViewById(R.id.editTextTextPassword2) // PASSWORD
        var inputFieldPasswordConf: EditText? =
            findViewById(R.id.editTextTextPassword3) // CON PASSWORD

        // check if all fields are good
        if (inputFieldFirstName != null && inputFieldLastName != null && inputFieldUserName != null && inputFieldRamId != null &&
            inputFieldPassword != null && inputFieldPasswordConf != null
        ) {

            // check now if  there is (are) empty fields
            if (inputFieldFirstName.text.toString().isEmpty() || inputFieldLastName.text.toString()
                    .isEmpty() || inputFieldUserName.text.toString().isEmpty() ||
                inputFieldRamId.text.toString().isEmpty() || inputFieldPassword.text.toString()
                    .isEmpty() ||
                inputFieldPasswordConf.text.toString().isEmpty()
            ) {
                Toast.makeText(
                    applicationContext,
                    "PLEASE FILL OUT EMPTY FIELD(S) ",
                    Toast.LENGTH_LONG
                ).show()
            } else {

                // check if password is equals to the confirmed password field
                if (inputFieldPassword.text.toString()
                        .equals(inputFieldPasswordConf.text.toString())
                ) {


                    val database = Firebase.database
                    val myRef = database.getReference("studentsInfo")
//                    val s:StudentInformation = StudentInformation(inputFieldFirstName.text.toString(),inputFieldLastName.text.toString(),inputFieldRamId.text.toString(),inputFieldUserName.text.toString(),inputFieldPassword.text.toString())
//                    myRef.child("users").child(inputFieldRamId.text.toString()).setValue(s)
//                    Toast.makeText(applicationContext,"GOOD",Toast.LENGTH_LONG).show()

                    myRef.child("users").child("651svc").get().addOnCompleteListener(
                        OnCompleteListener {
                            val d: StudentInformation = it.getResult() as StudentInformation
                            Toast.makeText(applicationContext,"SUCCESS!\nPlease Log In!",Toast.LENGTH_LONG).show()
                        })

                }
            }

        }
    }

}
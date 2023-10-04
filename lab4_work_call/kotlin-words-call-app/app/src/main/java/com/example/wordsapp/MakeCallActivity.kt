package com.example.wordsapp
// Replace with your actual package name
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MakeCallActivity : AppCompatActivity() {
    private lateinit var phoneNo: EditText
    private lateinit var callbtn: FloatingActionButton
    private val PERMISSION_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make_call)

        phoneNo = findViewById(R.id.editTextPhone)
        callbtn = findViewById(R.id.callbtn)

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
            != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CALL_PHONE),
                PERMISSION_CODE
            )
        }

        callbtn.setOnClickListener {
            val phoneNumber = phoneNo.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNumber")
            startActivity(callIntent)
        }
    }
}
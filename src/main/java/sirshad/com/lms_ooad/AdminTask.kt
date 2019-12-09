package sirshad.com.lms_ooad

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.adminmainscreen.*
import kotlinx.android.synthetic.main.content_adminmain.*


class AdminTask  : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.adminmainscreen)
       // val userlogin = intent.extras.get("my-user")

        createuser.setOnClickListener { view ->
            val intent = Intent(this, addUser::class.java)
            // start your next activity
            startActivity(intent)
        }

        addbookbutton.setOnClickListener { view ->
            val intent = Intent(this, addbook::class.java)
            // start your next activity
            startActivity(intent)
        }

        logout.setOnClickListener { view ->
            val intent = Intent(this, MainActivity::class.java)
            // start your next activity
            startActivity(intent)
        }




    }

    @Override
    override fun onBackPressed() {
        //your code when back button pressed
    }

}
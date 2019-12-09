package sirshad.com.lms_ooad

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_usermain.*


class usermain : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.usermainscreen)

        val userlogin = intent.extras.get("my-user") as person

        searchbook.setOnClickListener { view ->
            val intent = Intent(this, sirshad.com.lms_ooad.searchbook::class.java)
            // start your next activity
            intent.putExtra("my-user", userlogin);
            startActivity(intent)
        }

        returnbook.setOnClickListener { view ->
            val intent = Intent(this, sirshad.com.lms_ooad.returnbook::class.java)
            // start your next activity

            intent.putExtra("my-user", userlogin);
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
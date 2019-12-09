package sirshad.com.lms_ooad

import android.app.ProgressDialog
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.content.Intent
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        /*fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()


       }*/



        loginbutton.setOnClickListener {view ->


            var username = un.text.toString();
            var password = pw.text.toString();


            if (!username.isBlank() && !password.isBlank()){

                // Instantiate the RequestQueue.
                val queue = Volley.newRequestQueue(this)
                val url = "https://09h69rjill.execute-api.us-west-1.amazonaws.com/default/userLogin?userId=" + username + "&password=" + password;

                // Request a string response from the provided URL.
                val stringRequest = StringRequest(
                    Request.Method.GET, url,
                    Response.Listener<String> { response ->
                        // Display the first 500 characters of the response string.
                        if (response.contains("admin")){
                            val parts = response.split(" ")
                            val userlogin = admin(parts[0], parts[4], parts[3].toInt(), parts[1], parts[2])
                           // val loginuser = person();
                            val intent = Intent(this, AdminTask::class.java)
                            intent.putExtra("my-user", userlogin);
                            // start your next activity
                            startActivity(intent)
                        } else if (response.contains("regular")){

                            val parts = response.split(" ")
                            val userlogin = user(parts[0], parts[4], parts[3].toInt(), parts[1], parts[2])

                            val intent = Intent(this, usermain::class.java)
                            intent.putExtra("my-user", userlogin);
                            startActivity(intent)
                        } else {
                            Toast.makeText(this@MainActivity, "User Not Found!!!", Toast.LENGTH_LONG).show()
                        }

                    },
                    Response.ErrorListener { ""})

                // Add the request to the RequestQueue.
                queue.add(stringRequest);


            }

           // Snackbar.make(view, username + password, Snackbar.LENGTH_LONG)
             //   .setAction("Action", null).show()

        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    @Override
    override fun onBackPressed() {
        //your code when back button pressed
    }
}

package sirshad.com.lms_ooad

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley


import kotlinx.android.synthetic.main.adduser.*
import kotlinx.android.synthetic.main.content_adduser.*


class addUser : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.adduser)


        createuser.setOnClickListener { view ->
            var name = name.text.toString()
            var email = email.text.toString()
            var pw = pw.text.toString()
            var age = age.text.toString()
            var phone = phone.text.toString()

            if (!name.isBlank() && !email.isBlank() && !pw.isBlank() && !age.isBlank() && !phone.isBlank()){
                val newuser = user(email, email, age.toInt(), pw, name)
                // Instantiate the RequestQueue.
                val queue = Volley.newRequestQueue(this)
                val url = "https://h2n5j1ziq9.execute-api.us-west-1.amazonaws.com/default/createUser?userId=" + newuser.email + "&password=" + newuser.password +
                "&name=" + newuser.name + "&age=" + newuser.age + "&email=" + newuser.email + "&role=regular";

                // Request a string response from the provided URL.
                val stringRequest = StringRequest(
                    Request.Method.GET, url,
                    Response.Listener<String> { response ->

                        Toast.makeText(this@addUser, "User Created Successfuly", Toast.LENGTH_LONG).show()

                        Handler().postDelayed({
                            val intent = Intent(this, AdminTask::class.java)
                            // start your next activity
                            startActivity(intent)
                        }, 2000)

                    },
                    Response.ErrorListener { ""})

                // Add the request to the RequestQueue.
                queue.add(stringRequest);
            }

        }



    }


}
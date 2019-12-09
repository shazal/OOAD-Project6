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
import kotlinx.android.synthetic.main.content_returnbook.*


class returnbook : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.returnbook)
        val userlogin = intent.extras.get("my-user") as person

        returnbookbutton.setOnClickListener { view ->

            var bookid = bookid.text.toString();

            if (!bookid.isBlank()){

                // Instantiate the RequestQueue.
                val queue = Volley.newRequestQueue(this)
                val url = "https://f0ww3zopwf.execute-api.us-west-1.amazonaws.com/default/returnBook?userId=" + userlogin.id + "&bookId=" + bookid;

                // Request a string response from the provided URL.
                val stringRequest = StringRequest(
                    Request.Method.GET, url,
                    Response.Listener<String> { response ->
                        if (response.contains("no",true)){
                            Toast.makeText(this@returnbook, "No Such Transaction, Try Again!!!", Toast.LENGTH_LONG).show()

                        } else{
                            Toast.makeText(this@returnbook, "Book Returned Successfuly", Toast.LENGTH_LONG).show()

                            Handler().postDelayed({
                                val intent = Intent(this, usermain::class.java)
                                // start your next activity
                                intent.putExtra("my-user", userlogin);
                                startActivity(intent)
                            }, 2000)
                        }


                    },
                    Response.ErrorListener { ""})

                // Add the request to the RequestQueue.
                queue.add(stringRequest);
            }

        }




    }

}
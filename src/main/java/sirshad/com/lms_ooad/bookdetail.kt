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
import kotlinx.android.synthetic.main.content_bookdetail.*


class bookdetail : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.bookdetail)

            val userlogin = intent.extras.get("my-user") as person
            var selectedbook = intent.extras.get("selectedbook") as book

            if (selectedbook.number > 0) {
                issuewait.setText("Issue Book")
            } else {
                issuewait.setText("Waitlist Book")
            }

            bookid.setText("Book ID:  " + selectedbook.id)
            booktitle.setText("Title:  " + selectedbook.title)
            bookauthor.setText("Author:  " + selectedbook.author)
            language.setText("Language:  " + selectedbook.language)
            discipline.setText("Discipline:  " + selectedbook.discipline)


            issuewait.setOnClickListener { view ->

                if (selectedbook.number > 0) {

                    // Instantiate the RequestQueue.
                    val queue = Volley.newRequestQueue(this)
                    val url = "https://415bojzqwg.execute-api.us-west-1.amazonaws.com/default/issueBook?bookId=" + selectedbook.id + "&userId=" + userlogin.id +
                            "&date=NA";

                    // Request a string response from the provided URL.
                    val stringRequest = StringRequest(
                        Request.Method.GET, url,
                        Response.Listener<String> { response ->

                            Toast.makeText(this@bookdetail, "Book Issued Successfuly", Toast.LENGTH_LONG).show()

                            Handler().postDelayed({
                                val intent = Intent(this, usermain::class.java)
                                intent.putExtra("my-user", userlogin)
                                // start your next activity
                                startActivity(intent)
                            }, 2000)

                        },
                        Response.ErrorListener { ""})

                    // Add the request to the RequestQueue.
                    queue.add(stringRequest);
                } else {
                    issuewait.setText("Waitlist Book")

                    // Instantiate the RequestQueue.
                    val queue = Volley.newRequestQueue(this)
                    val url = "https://7i0b80uw45.execute-api.us-west-1.amazonaws.com/default/waitList?bookId=" + selectedbook.id + "&userId=" + userlogin.id;

                    // Request a string response from the provided URL.
                    val stringRequest = StringRequest(
                        Request.Method.GET, url,
                        Response.Listener<String> { response ->

                            Toast.makeText(this@bookdetail, "Book Waitlisted Successfuly", Toast.LENGTH_LONG).show()

                            Handler().postDelayed({
                                val intent = Intent(this, usermain::class.java)
                                intent.putExtra("my-user", userlogin)
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

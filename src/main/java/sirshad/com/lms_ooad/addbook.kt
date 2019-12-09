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
import kotlinx.android.synthetic.main.content_addbook.*


class addbook : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addbook)

        addbookbutton.setOnClickListener { view ->
            var bookid = bookid.text.toString()
            var title = booktitle.text.toString()
            var author = bookauthor.text.toString()
            var discipline = discipline.getSelectedItem().toString()
            var language = language.getSelectedItem().toString();

            if (!bookid.isBlank() && !title.isBlank() && !author.isBlank() && !discipline.isBlank() && !language.isBlank()){
                val newbook = book(bookid, title, author, language,  discipline, 1)
                // Instantiate the RequestQueue.
                val queue = Volley.newRequestQueue(this)
                val url = "https://gzo2wjjom6.execute-api.us-west-1.amazonaws.com/default/addBook?bookId=" + newbook.id + "&name=" + newbook.title +
                        "&author=" + newbook.author + "&language=" + newbook.language + "&discipline=" + newbook.discipline;

                // Request a string response from the provided URL.
                val stringRequest = StringRequest(
                    Request.Method.GET, url,
                    Response.Listener<String> { response ->

                        Toast.makeText(this@addbook, "Book Created Successfuly", Toast.LENGTH_LONG).show()

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
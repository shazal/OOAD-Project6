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
import kotlinx.android.synthetic.main.content_searchbook.*


class searchbook : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.searchbook)

        val userlogin = intent.extras.get("my-user") as person
        searchbookbutton.setOnClickListener { view ->
            var title = booktitle.text.toString()
            var author = bookauthor.text.toString()
            var discipline = discipline.getSelectedItem().toString()
            var language = language.getSelectedItem().toString();

            val newbook = book("", title, author, language,  discipline, 0)
            // Instantiate the RequestQueue.
            val queue = Volley.newRequestQueue(this)

            var url = ""
            if (!title.isBlank()){
                 url = "https://22qqcyibsf.execute-api.us-west-1.amazonaws.com/default/searchBook?searchBy=name&name=" + newbook.title;
            } else if (!author.isBlank()){
                 url = "https://22qqcyibsf.execute-api.us-west-1.amazonaws.com/default/searchBook?searchBy=author&author=" + newbook.author;

            } else if (!language.equals("Language", true)) {
                 url = "https://22qqcyibsf.execute-api.us-west-1.amazonaws.com/default/searchBook?searchBy=language&language=" + newbook.language;

            }else if (!discipline.equals("Discipline",true)){
                url = "https://22qqcyibsf.execute-api.us-west-1.amazonaws.com/default/searchBook?searchBy=discipline&discipline=" + newbook.discipline;

            } else {

            }

            if (!url.isBlank()){
                val stringRequest = StringRequest(
                    Request.Method.GET, url,
                    Response.Listener<String> { response ->

                        if (!response.equals("[]",true)){

                            val intent = Intent(this, sirshad.com.lms_ooad.listbooks::class.java)
                            // start your next activity
                            intent.putExtra("my-user", userlogin)
                            intent.putExtra("listbooks",response)
                            startActivity(intent)

                        } else {
                            Toast.makeText(this@searchbook, "No Record Found!!!", Toast.LENGTH_LONG).show()
                        }

                    },
                    Response.ErrorListener { ""})

                // Add the request to the RequestQueue.
                queue.add(stringRequest);
            }


        }




    }


}
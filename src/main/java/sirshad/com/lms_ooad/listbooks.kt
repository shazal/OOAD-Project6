package sirshad.com.lms_ooad

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class listbooks : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.booklist)

        val userlogin = intent.extras.get("my-user") as person
        var response = intent.extras.getString("listbooks") as String

        var listView = findViewById<ListView>(R.id.listbooks)


        val parts = response.split(", ")

        var size = parts.size

        val Books: MutableList<book> = ArrayList()

        val listItems = arrayOfNulls<String>(size)


        for (i in 0..size-1){
            var b = parts[i].split(" ")

            var id = ""

            if (i == 0){
               id = b[0].subSequence(2,b[0].length).toString()
            } else{
                id = b[0].subSequence(1,b[0].length).toString()
            }

            var title = b[1]
            var author = b[2]
            var discipline = b[3]
            var language = b[4]
            var number = ""
            if (i == size-1){
                number = b[5].subSequence(0,b[5].length-2).toString()
            } else {
                number = b[5].subSequence(0,b[5].length-1).toString()
            }


            var nb = book(id, title, author, language, discipline, number.toInt())

            Books.add(nb)

            listItems[i] = title

        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        listView.adapter = adapter


        listView.setOnItemClickListener { _, _, position, _ ->

            val selectedBook = Books[position]

            val intent = Intent(this, bookdetail::class.java)
            // start your next activity
            intent.putExtra("my-user", userlogin)
            intent.putExtra("selectedbook",selectedBook)
            startActivity(intent)
        }


    }




}
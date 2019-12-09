package sirshad.com.lms_ooad;

import android.content.Context;
import android.os.Parcel;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class admin extends person  {


    public admin(String id, String email, int age, String password, String name) {
        super(id, email, age, password, name);
    }



    void createUser(String id, String email, String name, int age, String pw, Context mcontext) {
    }

    void addBook(){

    }
}

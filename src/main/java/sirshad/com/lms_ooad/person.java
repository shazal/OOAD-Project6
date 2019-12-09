package sirshad.com.lms_ooad;

import android.os.Parcel;
import android.os.Parcelable;

public class person implements Parcelable {
    private String id;
    private String email;
    private int age;
    private String password;
    private String name;

    public person(String id, String email, int age, String password, String name) {
        this.id = id;
        this.email = email;
        this.age = age;
        this.password = password;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Creator<person> getCREATOR() {
        return CREATOR;
    }

    protected person(Parcel in) {
        id = in.readString();
        email = in.readString();
        age = in.readInt();
        password = in.readString();
    }

    public static final Creator<person> CREATOR = new Creator<person>() {
        @Override
        public person createFromParcel(Parcel in) {
            return new person(in);
        }

        @Override
        public person[] newArray(int size) {
            return new person[size];
        }
    };

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(email);
        parcel.writeInt(age);
        parcel.writeString(password);
    }
}

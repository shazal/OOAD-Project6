package sirshad.com.lms_ooad;

import android.os.Parcel;
import android.os.Parcelable;

public class book implements Parcelable {
    private String id;
    private String Title;
    private String Author;
    private String Language;
    private String Discipline;
    private int number;

    public book(String id, String title, String author, String language, String discipline, int number) {
        this.id = id;
        Title = title;
        Author = author;
        Language = language;
        Discipline = discipline;
        this.number = number;
    }

    protected book(Parcel in) {
        id = in.readString();
        Title = in.readString();
        Author = in.readString();
        Language = in.readString();
        Discipline = in.readString();
        number = in.readInt();
    }

    public static final Creator<book> CREATOR = new Creator<book>() {
        @Override
        public book createFromParcel(Parcel in) {
            return new book(in);
        }

        @Override
        public book[] newArray(int size) {
            return new book[size];
        }
    };

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getDiscipline() {
        return Discipline;
    }

    public void setDiscipline(String discipline) {
        Discipline = discipline;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(Title);
        parcel.writeString(Author);
        parcel.writeString(Language);
        parcel.writeString(Discipline);
        parcel.writeInt(number);
    }
}

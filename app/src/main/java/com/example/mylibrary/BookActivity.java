package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    public static final String BOOK_ID_KEY = "bookID";

private TextView textSubject, textofAuthor, textofPages, textLongDesc;
private Button btnCuRe, btnWaToRe, btnAlRe, btnAddToFa;
private ImageView imgOfBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();

//        Get the data from recycler view in here
        Intent intent = getIntent();
        if (null != intent){
            int bookId = intent.getIntExtra(BOOK_ID_KEY, -1);
            if (bookId != -1) {
            Book incomingBook = Utils.getInstance(this).getBookById(bookId);
            if (null != incomingBook){
                setData(incomingBook);
                handleAlreadyRead(incomingBook);
                handleWantToReadBooks(incomingBook);
                handleCurrentlyReadingBooks(incomingBook);
                handleFavoriteBooks(incomingBook);

            }
            }
        }


    }

    /**
     * Enable and Disable button,
     * Add the book to Already Read Book ArrayList
     * @param book
     */

    private void handleCurrentlyReadingBooks(final Book book){

        ArrayList<Book> currentlyReadingBooks = Utils.getInstance(this).getCurrentlyReadingBooks();

        boolean existInCurrentlyBooks = false;
        for (Book b : currentlyReadingBooks) {
            if (b.getId() == book.getId()) {
                existInCurrentlyBooks = true;
            }
        }
        if (existInCurrentlyBooks){
            btnCuRe.setEnabled(false);
            btnWaToRe.setEnabled(false);
        }
        else {
            btnCuRe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance(BookActivity.this).addToCurrentlyReadingBooks(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, CurrentlyReadActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(BookActivity.this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    private void handleFavoriteBooks(final Book book) {

        ArrayList<Book> favoriteBooks = Utils.getInstance(this).getFavoriteBooks();

        boolean existInFavoriteBooks = false;
        for (Book b : favoriteBooks) {
            if (b.getId() == book.getId()) {
                existInFavoriteBooks = true;
            }
        }
        if (existInFavoriteBooks){
            btnAddToFa.setEnabled(false);
        }
        else {
            btnAddToFa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance(BookActivity.this).addToFavoriteBooks(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, FavoriteActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(BookActivity.this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

private void    handleWantToReadBooks(final Book book) {
    ArrayList<Book> wantToReadBooks = Utils.getInstance(this).getWantToReadBooks();

    boolean existInWantToReadBooks = false;
    for (Book b : wantToReadBooks) {
        if (b.getId() == book.getId()) {
            existInWantToReadBooks = true;
        }
    }
    if (existInWantToReadBooks){
        btnWaToRe.setEnabled(false);
    }
    else {
        btnWaToRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Utils.getInstance(BookActivity.this).addToWantToRead(book)){
                    Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(BookActivity.this, WantToReadActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(BookActivity.this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

    private void handleAlreadyRead(Book book) {
        ArrayList<Book> alreadyReadBooks = Utils.getInstance(this).getAlreadyReadBooks();

        boolean existInAlreadyReadBooks = false;
        for (Book b : alreadyReadBooks) {
            if (b.getId() == book.getId()) {
                existInAlreadyReadBooks = true;
            }
        }
        if (existInAlreadyReadBooks){
            btnAlRe.setEnabled(false);
            btnCuRe.setEnabled(false);
            btnWaToRe.setEnabled(false);
        }
        else {
            btnAlRe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance(BookActivity.this).addToAlreadyRead(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, AlreadyReadBookActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(BookActivity.this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
   private void setData(Book book) {
        textSubject.setText(book.getName());
        textofAuthor.setText(book.getAuthor());
        textofPages.setText(String.valueOf(book.getPages()));
        textLongDesc.setText(book.getLongDesc());

       Glide.with(this)
               .asBitmap().load(book.getImageUrl())
               .into(imgOfBook);

   }

    private void initViews(){

        textSubject = findViewById(R.id.textSubject);
        textofAuthor = findViewById(R.id.textofAuthor);
        textofPages = findViewById(R.id.textofPages);
        textLongDesc = findViewById(R.id.textLongDes);

        btnCuRe = findViewById(R.id.btnCuRe);
        btnWaToRe = findViewById(R.id.btnWaToRe);
        btnAlRe = findViewById(R.id.btnAlRe);
        btnAddToFa = findViewById(R.id.btnAddToFa);

        imgOfBook = findViewById(R.id.imgOfBook);

    }


}
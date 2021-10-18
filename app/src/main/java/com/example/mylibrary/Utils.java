package com.example.mylibrary;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Utils {

    private static final String ALL_BOOKS_KEY = "all_books";
    private static final String ALREADY_READ_BOOKS = "already_read_books";
    private static final String WANT_TO_READ_BOOKS = "want_to_read_books";
    private static final String CURRENTLY_READING_BOOKS = "currently_reading_books";
    private static final String FAVORITE_BOOKS = "favorite_books";

    private static Utils instance;
    private SharedPreferences sharedPreferences;

//    private static ArrayList<Book> allBooks;
//    private static ArrayList<Book> alreadyReadBooks;
//    private static ArrayList<Book> wantToReadBooks;
//    private static ArrayList<Book> currentlyReadingBooks;
//    private static ArrayList<Book> favoriteBooks;

    private Utils(Context context) {

        sharedPreferences= context.getSharedPreferences("alternate_db" , Context.MODE_PRIVATE);

        if (null == getAllBooks()){
            initData();
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();

        if (null == getAlreadyReadBooks()){
            editor.putString(ALREADY_READ_BOOKS, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if (null == getWantToReadBooks()){
            editor.putString(WANT_TO_READ_BOOKS, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if (null == getCurrentlyReadingBooks()){
            editor.putString(CURRENTLY_READING_BOOKS, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if (null == getFavoriteBooks()){
            editor.putString(FAVORITE_BOOKS, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
    }

    private void initData() {
       // TODO init
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1,"1Q84", "Haruki Murakami",1350,"http://publishingperspectives.com/wp-content/uploads/2014/09/cover-1Q84-202x300.jpg","A work of maddening brilliance","Long Description"));
        books.add(new Book(2,"The Myth of Sisyphus","Albert Camus",250,"https://upload.wikimedia.org/wikipedia/en/7/75/Le_Mythe_de_Sisyphe.jpg","According to the Greek myth, Sisyphus is condemned to roll a rock up to the top of a mountain, only to have the rock roll back down to the bottom every time he reaches the top. The gods were wise, Camus suggests, in perceiving that an eternity of futile labor is a hideous punishment.",
                "Long Description"));
        books.add(new Book(3,"In Search of Lost Time","Marcel Proust",800,"https://kbimages1-a.akamaihd.net/011c5826-8da6-49be-9602-866760464c63/353/569/90/False/in-search-of-lost-time-vol-1-7.jpg","The narrator recalls his childhood, aided by the famous madeleine; and describes M. Swann's passion for Odette.",
                "Long Description"));
        books.add(new Book(4,"Game of Thrones","George R.R. Martin",2500,"https://prodimage.images-bn.com/pimages/9780345535528_p0_v2_s550x406.jpg","The books of the century, with the greatest TV Show of all time behind that, story about dragons, white walkers and a lot of misteries",
                "Long Description"));
        books.add(new Book(5,"The Da Vinci Code","Dan Brown",550,"https://images-na.ssl-images-amazon.com/images/I/91Q5dCjc2KL.jpg","The Da Vinci Code follows symbologist Robert Langdon and cryptologist Sophie Neveu after a murder in the Louvre Museum in Paris causes them to become involved in a battle between the Priory of Sion and Opus Dei over the possibility of Jesus Christ and Mary Magdalene having had a child together.",
                "Long Description"));
        books.add(new Book(6,"The Lord of the rings","J.R.R.Tolkien",1200,"https://images-na.ssl-images-amazon.com/images/I/51EstVXM1UL._SX331_BO1,204,203,200_.jpg","he Fellowship of the Ring embark on a journey to destroy the One Ring and end Sauron's reign over Middle-earth. A young Hobbit known as Frodo has been thrown on an amazing adventure, when he is appointed the job of destroying the One Ring, which was created by the Dark Lord Sauron.",
                "Long Description"));
        books.add(new Book(7,"Harry Potter","J.K.Rowling",2800,"https://hpmedia.bloomsbury.com/rep/files/harry-potter-and-the-philosophers-333.png","The central character in the series is Harry Potter, a boy who lives in the fictional town of Little Whinging, Surrey with his aunt, uncle, and cousin – the Dursleys – and discovers at the age of eleven that he is a wizard, though he lives in the ordinary world of non-magical people known as Muggles.",
                "Long Description"));
        books.add(new Book(8,"Angels and Demons","Dan Brown",620,"https://images-na.ssl-images-amazon.com/images/I/61d1QJ0tPhL.jpg","When world-renowned Harvard symbologist Robert Langdon is summoned to a Swiss research facility to analyze a mysterious symbol — seared into the chest of a murdered physicist — he discovers evidence of the unimaginable: the resurgence of an ancient secret brotherhood known as the Illuminati… the most powerful ...",
                "Long Description"));
        books.add(new Book(9,"The Iliad","Homer",560,"https://images-na.ssl-images-amazon.com/images/I/518e2tbm8cL._SX323_BO1,204,203,200_.jpg","The Iliad is an epic poem written by the Greek poet Homer. It tells the story of the last year of the Trojan War fought between the city of Troy and the Greeks. Achilles - Achilles is the main character and the greatest warrior in the world. ... She is taken by the Trojans and is the cause for the Trojan War.",
                "Long Description"));
        books.add(new Book(10,"Alice's Adventures in Wonderland","Lewis Carroll",200,"https://images-na.ssl-images-amazon.com/images/I/91iBGTuBKCL.jpg","The story centres on Alice, a young girl who falls asleep in a meadow and dreams that she follows the White Rabbit down a rabbit hole. ... Later, at the Queen's behest, the Gryphon takes Alice to meet the sobbing Mock Turtle, who describes his education in such subjects as Ambition, Distraction, Uglification, and Derision.",
                "Long Description"));
        books.add(new Book(11,"Anna Karenina","Leo Tolstoy",864,"https://images-na.ssl-images-amazon.com/images/I/91ao4sYrtzL.jpg","Anna Karenina (Keira Knightley), the wife of a Russian imperial minister (Jude Law), creates a high-society scandal by an affair with Count Vronsky (Aaron Taylor-Johnson), a dashing cavalry officer in 19th-century St. Petersburg. Anna's husband, Alexei, offers her a difficult choice: Go into exile with Vronsky but never see her young son again, or remain with her family and abide by the rules of discretion. Meanwhile, a farmer named Levin pines for Princess Kitty, who only has eyes for Vronsky.",
                "Long Description"));
        books.add(new Book(12,"The Adventures of Huckleberry Finn","Mark Twain",366,"http://4.bp.blogspot.com/-B-5t78sCCOw/UNz9VJr7cJI/AAAAAAAASjQ/ZoVG6-J4a1s/s1600/The+Adventures+of+Huckleberry+Finn+Summary.jpg","The novel tells the story of Huckleberry Finn's escape from his alcoholic and abusive father and Huck's adventurous journey down the Mississippi River together with the runaway slave Jim.",
                "Long Description"));
        books.add(new Book(13,"Wuthering Heights","Emily Bronte",384,"https://prodimage.images-bn.com/pimages/9781435171503_p0_v1_s550x406.jpg","It follows the life of Heathcliff, a mysterious gypsy-like person, from childhood (about seven years old) to his death in his late thirties. Heathcliff rises in his adopted family and then is reduced to the status of a servant, running away when the young woman he loves decides to marry another.",
                "Long Description"));
        books.add(new Book(14,"Crime and Punishment","Fyodor Dostoyevsky",576,"https://i.pinimg.com/originals/0e/a3/95/0ea395f32b1bf31f0fa38ee1d012c896.jpg","Crime and Punishment focuses on the mental anguish and moral dilemmas of Rodion Raskolnikov, an impoverished ex-student in Saint Petersburg who formulates a plan to kill an unscrupulous pawnbroker for her money.",
                "Long Description"));
        books.add(new Book(15,"Lolita","Vladimir Nabokov",336,"https://i.ytimg.com/vi/y7SrAMtT5lo/maxresdefault.jpg","Lolita, of the Confession of a White Widowed Male by Vladimir Nabokov is a story about Humbert Humbert, a literature professor in his late thirties, obsessed with a twelve-year-old Dolores Haze. ... Invented by Nabokov editor believes that Lolita should serve as a warning and a moral lesson for generations to come",
                "Long Description"));
        books.add(new Book(16,"The Divine Comedy","Dante Alighieri",712,"https://www.woloafric.com/wp-content/uploads/2018/12/divine-comedy-1.jpg","Dante's Divine Comedy is a complex work of art. It takes the reader through the nine circles of Hell, the seven terraces of Purgatory and the nine spheres of Paradise. Each of the parts of the journey are full of dead souls who suffer trying to rid themselves of their sins, or simply survive in the afterlife.",
                "Long Description"));
        books.add(new Book(17,"The Odyssey","Homer",332,"https://images.booksense.com/images/662/642/9780763642662.jpg","The Odyssey is an epic poem in 24 books traditionally attributed to the ancient Greek poet Homer. The poem is the story of Odysseus, king of Ithaca, who wanders for 10 years (although the action of the poem covers only the final six weeks) trying to get home after the Trojan War.",
                "Long Description"));
        books.add(new Book(18,"The Brothers Karamazov","Fyodor Dostoyevsky",840,"https://d28hgpri8am2if.cloudfront.net/book_images/onix/cvr9781625583826/brothers-karamazov-9781625583826_hr.jpg","Based on Fyodor Dostoevsky's novel, Fyodor Karamazov (Lee J. Cobb) is a wealthy and controlling father who must choose an heir among his four sons. Dmitri (Yul Brynner), the oldest son, is engaged to Katya (Claire Bloom) but starts seeing his father's mistress, Grushenka (Maria Schell). The other brothers, Ivan (Richard Basehart), Alexey (William Shatner) and half-brother Smerdyakov (Albert Salmi), all have designs on the inheritance, ultimately leading to betrayal and murder.",
                "Long Description"));
        books.add(new Book(19,"Hamlet","William Shakespeare",104,"https://images-na.ssl-images-amazon.com/images/I/51ZaFL6B7lL._SX326_BO1,204,203,200_.jpg","The ghost of the King of Denmark tells his son Hamlet to avenge his murder by killing the new king, Hamlet's uncle. Hamlet feigns madness, contemplates life and death, and seeks revenge. ... The play ends with a duel, during which the King, Queen, Hamlet's opponent and Hamlet himself are all killed.",
                "Long Description"));
        books.add(new Book(20,"War and Peace","Leo Tolstoy",1225,"https://m.media-amazon.com/images/I/51kB9qY9GYL.jpg","War and Peace broadly focuses on Napoleon's invasion of Russia in 1812 and follows three of the most well-known characters in literature: Pierre Bezukhov, the illegitimate son of a count who is fighting for his inheritance and yearning for spiritual fulfillment; Prince Andrei Bolkonsky, who leaves his family behind to ...",
                "Long Description"));
        books.add(new Book(21,"Moby Dick","Herman Melville",378,"https://i.pinimg.com/736x/0c/72/e3/0c72e3baac4b6807c025c45b47c2c0b4.jpg","Moby-Dick; or, The Whale is an 1851 novel by American writer Herman Melville. The book is the sailor Ishmael's narrative of the obsessive quest of Ahab, captain of the whaling ship Pequod, for revenge on Moby Dick, the giant white sperm whale that on the ship's previous voyage bit off Ahab's leg at the knee.",
                "Long Description"));
        books.add(new Book(22,"Ulysses","James Joyce",730,"http://1.bp.blogspot.com/-g68M_hn-0CQ/Tn4QevY8cCI/AAAAAAAAEVk/PA0xta9Lcv4/s1600/sothebys10.jpg","Ulysses is the Latinised name of Odysseus, the hero of Homer's epic poem the Odyssey, and the novel establishes a series of parallels between the poem and the novel, with structural correspondences between the characters and experiences of Bloom and Odysseus, Molly Bloom and Penelope, and Stephen Dedalus and Telemachus ...",
                "Long Description"));
        books.add(new Book(23,"The Great Gatsby","F.Scott Fitzgerald",218,"https://upload.wikimedia.org/wikipedia/commons/7/7a/The_Great_Gatsby_Cover_1925_Retouched.jpg","Set in Jazz Age New York, the novel tells the tragic story of Jay Gatsby, a self-made millionaire, and his pursuit of Daisy Buchanan, a wealthy young woman whom he loved in his youth.",
                "Long Description"));
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String text = gson.toJson(books);
        editor.putString(ALL_BOOKS_KEY,gson.toJson(books));
        editor.commit();
    }

    public static Utils getInstance(Context context) {
        if (null != instance){
            return instance;
        }
        else {
            instance = new Utils(context);
            return instance;
        }

    }

    public ArrayList<Book> getAllBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALL_BOOKS_KEY,null),type);

        return books;
    }

    public ArrayList<Book> getAlreadyReadBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALREADY_READ_BOOKS,null),type);

        return books;
    }

    public ArrayList<Book> getWantToReadBooks() {

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(WANT_TO_READ_BOOKS,null),type);

        return books;
    }

    public ArrayList<Book> getCurrentlyReadingBooks() {

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(CURRENTLY_READING_BOOKS,null),type);

        return books;
    }

    public ArrayList<Book> getFavoriteBooks() {

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(FAVORITE_BOOKS,null),type);

        return books;

    }
    public Book getBookById (int id){

        ArrayList<Book> books = getAllBooks();
        if (null != books) {
            for (Book b: books)
            {
                if (b.getId() == id) {
                    return b;
                }
            }
        }


        return null;
    }

    public boolean addToAlreadyRead(Book book){
        ArrayList<Book> books = getAlreadyReadBooks();
        if (null != books){
            if (books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(ALREADY_READ_BOOKS);
                editor.putString(ALREADY_READ_BOOKS, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }
    public boolean addToWantToRead(Book book){
        ArrayList<Book> books = getWantToReadBooks();
        if (null != books){
            if (books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(WANT_TO_READ_BOOKS);
                editor.putString(WANT_TO_READ_BOOKS, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }
    public boolean addToFavoriteBooks(Book book){
        ArrayList<Book> books = getFavoriteBooks();
        if (null != books){
            if (books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(FAVORITE_BOOKS);
                editor.putString(FAVORITE_BOOKS, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }
    public boolean addToCurrentlyReadingBooks(Book book){
        ArrayList<Book> books = getCurrentlyReadingBooks();
        if (null != books){
            if (books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(CURRENTLY_READING_BOOKS);
                editor.putString(CURRENTLY_READING_BOOKS, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }
    public boolean removeFromAlreadyRead(Book book){

        ArrayList<Book> books = getAlreadyReadBooks();
        if (null != books){
           for (Book b: books){
           if (b.getId() == book.getId()){
              if (books.remove(b)){
                  Gson gson = new Gson();
                  SharedPreferences.Editor editor = sharedPreferences.edit();
                  editor.remove(ALREADY_READ_BOOKS);
                  editor.putString(ALREADY_READ_BOOKS, gson.toJson(books));
                  editor.commit();
                  return  true;
              }
           }
           }
        }
            return false;
    }
    public boolean removeFromWantToRead(Book book){
        ArrayList<Book> books = getWantToReadBooks();
        if (null != books){
            for (Book b: books){
                if (b.getId() == book.getId()){
                    if (books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(WANT_TO_READ_BOOKS);
                        editor.putString(WANT_TO_READ_BOOKS, gson.toJson(books));
                        editor.commit();
                        return  true;
                    }
                }
            }
        }
        return false;
    }
    public boolean removeFromCurrentlyReading(Book book){
        ArrayList<Book> books = getCurrentlyReadingBooks();
        if (null != books){
            for (Book b: books){
                if (b.getId() == book.getId()){
                    if (books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(CURRENTLY_READING_BOOKS);
                        editor.putString(CURRENTLY_READING_BOOKS, gson.toJson(books));
                        editor.commit();
                        return  true;
                    }
                }
            }
        }
        return false;
    }
    public boolean removeFromFavorites(Book book){
        ArrayList<Book> books = getFavoriteBooks();
        if (null != books){
            for (Book b: books){
                if (b.getId() == book.getId()){
                    if (books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(FAVORITE_BOOKS);
                        editor.putString(FAVORITE_BOOKS, gson.toJson(books));
                        editor.commit();
                        return  true;
                    }
                }
            }
        }
        return false;
    }
}

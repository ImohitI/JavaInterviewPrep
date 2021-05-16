package javamemorymanagement.escapingreference.bookcollectionexample;

import java.util.ArrayList;
import java.util.List;

public class BookCollection {

    private List<Book> books;

    public BookCollection(){
        books = new ArrayList<Book>();
        books.add(new Book(1,"A", "A...",3.99));
        books.add(new Book(2,"B", "B...",4.45));
        books.add(new Book(3,"C", "C...",2.55));
    }

    public BookReadOnly findBookByName(String title){
        for(BookReadOnly bookReadOnly : books){
            if(bookReadOnly.getTitle().equals(title)){
                return bookReadOnly;
            }
        }
        return null;
    }

    public void printAllBooks(){
        for(Book book : books){
            System.out.println(book.getTitle()+": "+ book.getPrice());
        }
    }

}

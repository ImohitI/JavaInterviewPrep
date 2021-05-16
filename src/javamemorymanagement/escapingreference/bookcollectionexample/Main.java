package javamemorymanagement.escapingreference.bookcollectionexample;

public class Main {
    public static void main(String[] args) {
        BookCollection bc = new BookCollection();
        bc.printAllBooks();

        System.out.println(bc.findBookByName("A").getPrice().convert("EUR"));

        bc.printAllBooks();
    }
}

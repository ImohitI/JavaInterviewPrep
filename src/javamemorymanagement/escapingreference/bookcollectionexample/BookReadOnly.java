package javamemorymanagement.escapingreference.bookcollectionexample;

public interface BookReadOnly {
    int getId();

    String getTitle();

    String getAuthor();

    String toString();

    Price getPrice();
}

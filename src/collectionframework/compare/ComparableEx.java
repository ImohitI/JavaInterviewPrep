package collectionframework.compare;

import java.util.ArrayList;
import java.util.Collections;

public class ComparableEx {
    public static void main(String[] args) {
        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Avengers Age of Ultron", 8.2, 2015));
        movieList.add(new Movie("Avengers End game", 8.9, 2019));
        movieList.add(new Movie("Captain America", 8.1 , 2013));

        Collections.sort(movieList);
        for(Movie movie : movieList){
            System.out.println(movie.getName()+" "+movie.getRating()+" "+movie.getYear());
        }

        System.out.println(Collections.min(movieList).getName());
    }
}
class Movie implements Comparable<Movie>{
    private double rating;
    private String name;
    private int year;

    public int compareTo(Movie m){
        return this.year - m.year;
    }

    public Movie(String nm , double rt , int yr){
        this.name = nm;
        this.rating = rt;
        this.year = yr;
    }

    public double getRating(){
        return rating;
    }
    public String getName(){
        return name;
    }
    public int getYear(){
        return year;
    }
}

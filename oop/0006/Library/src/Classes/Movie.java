package Classes;

import Interface.Classifiable;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Movie extends LibraryItem implements Classifiable {
    private String movieName;
    private String director;
    private String releaseYear;
    private String movieGenre;
    private int movieCopies;
    private LocalDate lendingDate;
    private LocalDate returnDate;

    public Movie() {
    }

    public Movie(String movieName, String director, String releaseYear, String movieGenre, int movieCopies) {
        this.movieName = movieName;
        this.director = director;
        this.releaseYear = releaseYear;
        this.movieGenre = movieGenre;
        this.movieCopies = movieCopies;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public int getMovieCopies() {
        return movieCopies;
    }

    public void setMovieCopies(int movieCopies) {
        this.movieCopies = movieCopies;
    }

    public LocalDate getLendingDate() {
        return lendingDate;
    }

    public void setLendingDate(LocalDate lendingDate) {
        this.lendingDate = lendingDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String lendItem() {
        if (movieCopies == 0) {
            return "We cannot lend you the movie, there are no more copies.";
        } else {
            movieCopies--;
            this.lendingDate = LocalDate.now();
            return "Here, you have it. There are: " + movieCopies + " copies left.";
        }
    }


    @Override
    public String returnItem() {
        movieCopies++;
        this.returnDate = LocalDate.now();
        return "Thank you for returning " + movieName + ". Now there are: " + movieCopies + " copies in stock.";
    }

    @Override
    public String fineCalculation() {

        if (lendingDate == null || returnDate == null) {
            return "We can't calculate the fine. We are missing either the lent date or the return date";
        }

        long deltaDays = ChronoUnit.DAYS.between(lendingDate, returnDate);

        if (deltaDays <= 7) {
            return "You are within the return date range, so, no fine for you.";
        } else {
            long daysLate = deltaDays - 7;
            double fine = daysLate * 3.0; // $3 per day late
            return String.format("The fine for being late: $%.2f (%d late days)", fine, daysLate);
        }
    }

    @Override
    public String getInformation() {
        return "Movie{" +
                "movieCopies=" + movieCopies +
                ", movieGenre='" + movieGenre + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                ", director='" + director + '\'' +
                ", movieName='" + movieName + '\'' +
                '}';
    }

}

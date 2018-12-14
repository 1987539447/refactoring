
package com.github.siemen.bad;

/**
 * <b>描述：租赁类</b> <br/>
 *
 * <b>时间：</b>2018-06-19<br/>
 *
 */
public class Rental {

    private Movie _movie;
    private int _daysRented;

    public Rental(Movie _movie, int _daysRented) {
        this._movie = _movie;
        this._daysRented = _daysRented;
    }

    public Movie get_movie() {
        return _movie;
    }

    public int get_daysRented() {
        return _daysRented;
    }

    // move method to class Movie
    public double getCharge() {
        return _movie.getCharge(_daysRented);
    }

    //move method to class Movie
    public int getFrequentRenterPoints() {
        return _movie.getFrequentRenterPoints(_daysRented);
    }
}
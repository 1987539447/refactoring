
package com.github.siemen.bad;

/**
 * <b>描述：电影类</b> <br/>
 *
 * <b>时间：</b>2018-06-19<br/>
 *
 */
public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private int _priceCode;

    public Movie(String _title, int _priceCode) {
        this._title = _title;
        this._priceCode = _priceCode;
    }

    public int get_priceCode() {
        return _priceCode;
    }

    public void set_priceCode(int _priceCode) {
        this._priceCode = _priceCode;
    }

    public String get_title() {
        return _title;
    }

    public double getCharge(int daysRented) {
        double result = 0;
        switch (_priceCode) {
        case Movie.REGULAR:
            result += 2;
            if (daysRented > 2) {
                result += (daysRented - 2) * 1.5;
        }
            break;
        case Movie.NEW_RELEASE:
            result += daysRented * 3;
            break;
        case Movie.CHILDRENS:
            result += 1.5;
            if (daysRented > 3) {
                result += (daysRented - 3) * 1.5;
            }
            break;

        }
        return result;
    }

    public int getFrequentRenterPoints(int daysRented) {
        int frequentRenterPoints = 1;
        if (get_priceCode() == Movie.NEW_RELEASE && daysRented > 1) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }
}
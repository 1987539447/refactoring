
package com.github.siemen.start;

import com.github.siemen.bad.Movie;
import com.github.siemen.bad.Rental;
import java.util.Enumeration;
import java.util.Vector;

/**
 * <b>描述：顾客类</b> <br/>
 *
 * <b>时间：</b>2018-06-19<br/>
 *
 */
public class Customer {
    private String _name;
    private Vector<Rental> _rentals = new Vector<>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental rental) {
        this._rentals.add(rental);
    }

    /*
    * refactoring
    * extract method
    * rename parameter
    * move method - replace method
    * replace temp whit query
    * */
    public String statement() {
        //double totalAmount  = 0;
        //int frequentRenterPoints = 0;
        Enumeration<Rental> elements = _rentals.elements();
        String result = "Rental Record for " + this._name + "\n";
        //determine amounts for each rental
        while (elements.hasMoreElements()) {
            Rental each = elements.nextElement();
            //thisAmount = each.getCharge();
            //frequentRenterPoints += each.getFrequentRenterPoints();

            //show figures for this rental
            result += "\t" + each.get_movie().get_title() + "\t" + each.getCharge() + "\n";
            //totalAmount += each.getCharge();
        }
        //add footer line
        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";
        return result;
    }

    // loop to sum
    private int getTotalFrequentRenterPoints() {
        int result = 0;
        for (Rental rental : _rentals) {
            result += rental.getFrequentRenterPoints();
        }
        return result;
    }

    // loop to sum
    private double getTotalCharge() {
        double result = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental rental = rentals.nextElement();
            result += rental.getCharge();
        }
        return result;
    }


    private int getFrequentRenterPoints(Rental each) {
        int frequentRenterPoints = 0;
        //add frequent renter points
        frequentRenterPoints++;
        //add bonus for a two day new release rental
        if (each.get_movie().get_priceCode() == Movie.NEW_RELEASE && each.get_daysRented() > 1) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }

    private double amountFor(Rental aRental) {
        return aRental.getCharge();
    }

    public String get_name() {
        return _name;
    }
}
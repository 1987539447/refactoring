/*
 * Copyright (c) 2015-2018 www.jd.com All rights reserved.
 * 本软件源代码版权归京东智能集团所有,未经许可不得任意复制与传播.
 */
package com.github.siemen.bad;

import java.util.Enumeration;
import java.util.Vector;

/**
 * <b>描述：顾客类</b> <br/>
 * @author <b>作者：</b> cdzhansihu@jd.com<br/>
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

    /*  .........this really bad code......*/
    public String statement() {
        double totalAmount  = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> elements = _rentals.elements();
        String result = "Rental Record for " + this._name + "\n";
        //determine amounts for each rental
        while (elements.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = elements.nextElement();
            switch (each.get_movie().get_priceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (each.get_daysRented() > 2) {
                    thisAmount += (each.get_daysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                thisAmount += each.get_daysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (each.get_daysRented() > 3) {
                    thisAmount += (each.get_daysRented() - 3) * 1.5;
                }
                break;

            }
            //add frequent renter points
            frequentRenterPoints++;
            //add bonus for a two day new release rental
            if (each.get_movie().get_priceCode() == Movie.NEW_RELEASE && each.get_daysRented() > 1) {
                frequentRenterPoints++;
            }
            //show figures for this rental
            result += "\t" + each.get_movie().get_title() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }
        //add footer line
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + "frequent renter points";
        return result;
    }

    public String get_name() {
        return _name;
    }
}
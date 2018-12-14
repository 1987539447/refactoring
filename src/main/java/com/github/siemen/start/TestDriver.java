
package com.github.siemen.start;

import com.github.siemen.bad.Movie;
import com.github.siemen.bad.Rental;

/**
 * <b>描述：测试驱动</b> <br/>
 *
 * <b>时间：</b>2018-06-20<br/>
 *
 */
public class TestDriver {
    //6.0 - 3.5 - 1.5 - 11.0 - 4
    public static void main(String[] args) {
        Customer customer = initData();
        System.out.println(customer.statement());
}

    private static Customer initData() {
        Movie new_aaa = new Movie("New AAA", Movie.NEW_RELEASE);
        Movie regular_bbb = new Movie("Regular BBB", Movie.REGULAR);
        Movie children_ccc = new Movie("CHILDREN CCC", Movie.CHILDRENS);
        Rental rental_aaa = new Rental(new_aaa, 2);
        Rental rental_bbb = new Rental(regular_bbb, 3);
        Rental rental_ccc = new Rental(children_ccc, 2);
        Customer customer = new Customer("Jack");
        customer.addRental(rental_aaa);
        customer.addRental(rental_bbb);
        customer.addRental(rental_ccc);
        return customer;
    }
}
package vn.tdtin.java.practice;

import java.util.Optional;

public class OrElseVsOrElseGet {

    public static String doSomeStuff() {
        System.out.println("-> Optional is not present, return other object");
        return "Here you go !";
    }

    public static void main(final String[] args) {
        String foo = "None null Object";

        System.out.println("Use orElse with Object not null");
        Optional.ofNullable(foo).orElse(doSomeStuff());

        System.out.println("Use orElse with Object null");
        Optional.ofNullable(null).orElse(doSomeStuff());

        System.out.println("Use orElseGet with Object not null");
        Optional.ofNullable(foo).orElseGet(OrElseVsOrElseGet::doSomeStuff);

        System.out.println("Use orElseGet with Object null");
        Optional.ofNullable(null).orElseGet(OrElseVsOrElseGet::doSomeStuff);

    }
}
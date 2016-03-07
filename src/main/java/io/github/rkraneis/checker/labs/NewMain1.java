/*
 * Copyright 2016 René Kraneis
 */
package io.github.rkraneis.checker.labs;

import org.checkerframework.checker.tainting.qual.Untainted;

/**
 *
 * @author René Kraneis
 */
public class NewMain1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = args[0];
        foo(s); // should fail
        foo2(s);
        int i = Integer.parseInt(s);
        foo3(i); // should fail
        int j = Integer.getInteger("possibly tainted property");
        foo3(j); // should fail

        String regex = "abc(\\d+)def";
        System.out.println("abc123def".matches(regex));

        String regex2 = "abc(\\d+def";
//        System.out.println("abc123def".matches(regex2)); // always fails
    }

    private static void foo(@Untainted String s) {}
    private static void foo2(String s) {}
    private static void foo3(@Untainted int i) {}
}

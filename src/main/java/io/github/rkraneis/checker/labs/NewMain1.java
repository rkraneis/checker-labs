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
    }

    private static void foo(@Untainted String s) {}
    private static void foo2(String s) {}
}

/*
 * Copyright 2016 René Kraneis
 */
package io.github.rkraneis.checker.labs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 *
 * @author René Kraneis
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<@NonNull String> list = new ArrayList<>(0);
        consumeList(list);

        Stream<@NonNull String> stream = list.stream();
        consumeStream(stream);

        List<@NonNull String> list2 = stream.collect(Collectors.<@NonNull String>toList());
        consumeList(list2);

        List<@Nullable String> list3 = new ArrayList<>(0);
        Stream<@Nullable String> stream2 = list3.stream();

        //List<@NonNull String> list4 = stream2.collect(Collectors.<@NonNull String>toList());
        //consumeList(list2);
        Optional<String> ofNullable = Optional.ofNullable((@NonNull String) null);
        String orElse = ofNullable.orElse("");
        consumeString(orElse);

        Optional<String> of = Optional.ofNullable("s");
//        ClassLoader parent = String.class.getClass().getClassLoader().getParent();

//        Optional.ofNullable(String.class.getClass())
//                .map(Class::getClassLoader)
//                .map(ClassLoader::getParent)
//                .map(ClassLoader::toString)
//                .orElse("none");
    }

    private static void consumeList(List<String> strings) {
    }

    private static void consumeStream(Stream<String> strings) {
    }

    private static void consumeString(String s) {
    }
}

package com.makebono.javaplayland.streamrelated;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/** 
 * @ClassName: StreamDemo 
 * @Description: Demo of {@code Stream} related features. Has few Lambda expression stuffs. 
 * @author makebono
 * @date 2018年1月23日 上午9:04:18 
 *  
 */
@SuppressWarnings(value = { "rawtypes", "unchecked" })
public class StreamDemo {
    public static void show() {
        System.out.print("Direct parameterized input to stream:\n    ");
        Stream stream = Stream.of("a ", "b ", "c ", "d ", "e ", "f ");
        // stream.forEach(x -> System.out.print(x));
        // Same as below, use (Function<? super T, ? extends R> mapper) as input for forEach() seems to be functionally
        // insufficient. Maybe I don't get it clear, but whatsoever use lambda expression here is easier to comprehend.
        stream.forEach(System.out::print);

        System.out.print("\nArray input to stream:\n    ");
        // Notice int[] would return hash code. Not the values.
        stream = Stream.of(new Integer[] { 1, 2, 3, 4, 5, 6 });
        // Generate array
        final Object[] intArr = stream.toArray();
        System.out.println(Arrays.toString(intArr));

        System.out.print("\nGenerate stream by Collection.Stream():\n    ");
        List l = new LinkedList();
        final Random rng = new Random();

        for (int i = 0; i < 6; i++) {
            l.add(rng.nextInt(100));
        }

        stream = l.stream();
        stream.forEach(x -> System.out.print(x + " "));

        // Beware, re-initialze the stream is mandatory. Remember its use-and-discard nature.
        stream = l.stream();
        System.out.print(
                "\nDeploy a filter (x % 2 == 0) to the stream, and .collect(C) method could generate a Collection:\n    ");
        l = ((Stream<Integer>) stream).filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println(l);

        System.out
                .print("\nUse Stream.generate(Supplier s) to generate infinite sequential unordered stream. Can be limited "
                        + "by .limit(long maxSize)\n    ");
        stream = Stream.generate(() -> {
            return new Date();
        }).limit(6);
        stream.forEach(x -> System.out.print(x + "\n    "));

        System.out.print("\nUse Stream.iterate(T seed, UnaryOperator<T> f) to generate infinite sequential "
                + "unordered stream. Similar to .generate(), could also be limited by .limit(long maxSize)\n    ");
        // x++ does not work.
        stream = Stream.iterate(6, x -> x + 1).limit(6);
        stream.forEach(x -> System.out.print(x + " "));

        System.out.print("\nDealing with String.split(String regex, int limit)\n    ");
        // limit = 0 means no limit. Apply that match as much as there are.
        stream = Stream.of("M!A!K!E!B!O!N!O!".split("\\!", 0));
        stream.forEach(x -> System.out.print(x + " "));

        System.out.print("\nDealing with String.chars()\n    ");
        // Need a IntStream here.
        final IntStream intStream = "MAKEBONO".chars();
        intStream.forEach(x -> System.out.print((char) x + " "));

        System.out.println();

        // .map(Function f) method, very powerful.
        System.out.print("\n.map(Function f) applies function on each element of a stream\n    ");
        final Map hiraganaToKanji = new HashMap();
        hiraganaToKanji.put("あけぼの", "曙");
        hiraganaToKanji.put("いかずち", "雷");
        hiraganaToKanji.put("うしお", "潮");
        hiraganaToKanji.put("あさかぜ", "朝風");
        hiraganaToKanji.put("あらし", "嵐");
        hiraganaToKanji.put("てるずき", "照月");
        hiraganaToKanji.put("きさらぎ", "如月");
        hiraganaToKanji.put("あらしお", "荒潮");
        hiraganaToKanji.put("さつき", "皐月");
        hiraganaToKanji.put("あさしお", "朝潮");

        l.clear();
        l.addAll(hiraganaToKanji.keySet());

        // See how map uses method. It applies String.toCharArray to each element.
        stream = ((List<String>) l).stream().filter(x -> x.startsWith("あ")).map(x -> {
            final String str = "駆逐艦" + hiraganaToKanji.get(x);
            return str;
        });
        final Object[] destroyerFleet = stream.toArray();

        for (final Object cursor : destroyerFleet) {
            System.out.print(cursor + "\n    ");
        }
        /* To use pre-defined method, just like in the first part of this demo for the forEach(System.out::print) : 
         * ....map(String::toUpperCase)
         */

        // .sorted() method. Customized comparator could be utilized here.
        System.out.print("\n.sorted() to sort the stream, Comparator could be used here\n    ");
        stream = l.stream().sorted();
        System.out.print("[");
        stream.forEach(x -> System.out.print(x + ", "));
        System.out.print("]\n");

        // There are 3 xxxMatch() method in Stream class. See below
        System.out.print("\nxxxMatch(Predicate predicate) boolean returning methods\nUsing same list above.\n    ");
        final boolean anyMatched = ((List<String>) l).stream().anyMatch(x -> x.length() == 4);
        final boolean allMatched = ((List<String>) l).stream().allMatch(x -> x.startsWith("あ"));
        final boolean noneMatched = ((List<String>) l).stream().noneMatch(x -> x.length() >= 10);

        System.out.print("Is there any element hasing length = 4?: " + anyMatched + "\n    ");
        System.out.print("Do all elements start with 'あ'?: " + allMatched + "\n    ");
        System.out.println("Is it none element hasing length longer than 10?: " + noneMatched);

        System.out.print(
                "\n.count() method could be use to count the number of validate candidates to some conditions.\nUsing same list above.\n    ");
        final long numberOfValidateCandidates = ((List<String>) l).stream().filter(x -> x.startsWith("あ")).count();
        System.out.println("Number of elements start with 'あ': " + numberOfValidateCandidates);

        System.out.print("\n.findFirst() to return the first matched element\n    ");
        stream = ((List<String>) l).stream();
        final Optional<String> firstMatching = ((Stream<String>) stream).filter(x -> x.startsWith("い")).findFirst();
        System.out.println(firstMatching.get());
        // Notice even findFirst will also exhaust the stream. After invoking findFirst(), line below will trigger
        // IllegalStateException
        // stream.forEach(System.out::println);

        System.out.print(
                "\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.print(
                "\n.reduce() method has 3 overrides, it provides different manipulations on binary operations (2 variable inputs).\n");
        stream = Stream.of(1, 2, 3, 4, 5, 6);
        System.out.print("Stream(1, 2, 3, 4, 5, 6)\n\n");

        // Initially, x is the first element and y is the second. Then they change value until hit the end.
        System.out
                .print("First override, it offers 2 cursors per iteration until traversed through the whole stream:\nNotice this method returns an "
                        + "Optional type.\n    ");
        final Optional reduceResult = ((Stream<Integer>) stream).reduce((x, y) -> {
            System.out.print("x = " + x + "\n    ");
            System.out.print("y = " + y + "\n    ");
            x += y;
            System.out.print("x + y = " + x + "\n\n    ");
            return x;
        });
        System.out.println("Final value of reduceResult = " + reduceResult.get());

        System.out
                .print("\nSecond override, it also offers 2 cursors per iteration. And it accepts a initial value for the first cursor, as well "
                        + "as each element in stream for the second cursor.\nNotice this method returns same type as the stream holding.\n    ");
        stream = Stream.of(1, 2, 3, 4, 5, 6);
        final int result = ((Stream<Integer>) stream).reduce((0), (x, y) -> {
            System.out.print("x = " + x + "\n    ");
            System.out.print("y = " + y + "\n    ");
            x += y;
            System.out.print("x + y = " + x + "\n\n    ");
            return x;
        });
        System.out.println("Final value of reduceResult = " + result);

        System.out
                .print("\nThird override, similar to the second one but provide a concurrency handling solution at the third parameter. Means the "
                        + "third parameter is a BinaryOperator combines\nresult from different threads together. (parallelStream reduce would lead to concurrent"
                        + " problems). The third parameter won't do anything in single thread circumstance.\nAll 3 parameters would either be or return the same "
                        + "type. For here, the third parameter combines result from each thread.\n");
        stream = l.parallelStream();

        System.out.print("List input:\n" + l + "\n\n    ");
        final LinkedList result2 = ((Stream<String>) stream).reduce(new LinkedList(), (x, y) -> {
            final LinkedList temp = new LinkedList();

            temp.add(y);
            synchronized (System.out) {
                System.out.print("Single thread manipulation.\n    ");
                // System.out.print("x = " + x + "\n ");
                // System.out.print("y = " + y + "\n ");
                System.out.print("result: " + temp + "\n\n    ");
            }
            return temp;
        },
                // Combining binary operator, x and y here are the result from previously returned two threads.
                (x, y) -> {
                    final LinkedList temp = new LinkedList();
                    temp.addAll(x);
                    temp.addAll(y);
                    synchronized (System.out) {
                        System.out.print("Multi thread manipulation.\n    ");
                        System.out.print("x = " + x + "\n    ");
                        System.out.print("y = " + y + "\n    ");
                        System.out.print("result: " + temp + "\n\n    ");
                        return temp;
                    }
                });

        System.out.println("Final value of reduceResult = " + result2);
        System.out.print(
                "------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

    }
}

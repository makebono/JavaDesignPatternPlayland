package com.makebono.javaplayland.optionalnullchecker;

import java.util.NoSuchElementException;
import java.util.Optional;

import com.makebono.javaplayland.tools.entities.Destroyer;

/** 
 * @ClassName: OptionalDemo 
 * @Description: Explore the hell out of Optional class. Should consider to use it as returning value for erasing NullPointerException.
 * @author makebono
 * @date 2018年1月24日 上午9:00:21 
 *  
 */
@SuppressWarnings(value = { "rawtypes", "unchecked" })
public class OptionalDemo {
    public static void show() {
        Optional checker = Optional.empty();
        System.out.print("Use .empty() to create an empty Optional. Use .isPresent() to check if it is empty.\n    ");
        System.out.println(checker.isPresent() ? checker.get() : null);

        System.out.print("\n.get() an empty option will throw NoSuchElementException.\n    ");
        try {
            System.out.println(checker.get());
        }
        catch (final NoSuchElementException nsee) {
            nsee.printStackTrace(System.out);
        }

        System.out.print("\n.Use .of(T value) for assignment to an Optional.\n    ");
        checker = Optional.of("Hello there.");
        System.out.println(checker.get());

        System.out.print("\nIt is important to know that .of(null) will instantly throw NullPointerException:\n    ");
        try {
            checker = Optional.of(null);
        }
        catch (final NullPointerException npe) {
            npe.printStackTrace(System.out);
        }

        System.out.print(
                "\nUsing .ofNullable(null) permits null assignment to Optional. But even with doing this, .get() will still throw NoSuchElementException\n    ");
        checker = Optional.ofNullable(null);
        try {
            System.out.println(checker.get());
        }
        catch (final NoSuchElementException nsee) {
            nsee.printStackTrace(System.out);
        }
        System.out.println(
                "\n    Need to handle the null value manually:\n    i.e. (checker.isPresent() ? checker.get() : null) returns: "
                        + (checker.isPresent() ? checker.get() : null));

        System.out.print("\nSet default handling for encounting empty Optional by .orElse(return value).\n    ");

        final Destroyer empty = null;
        final Destroyer u_chan = new Destroyer(4, "Uzuki", "Mutsuki class");
        final Destroyer mocchi = new Destroyer(11, "Mochizuki", "Mutsuki class");
        System.out.print("Empty value: 'Destroyer empty' = null\n    ");
        System.out.print("Non-empty value: 'Destroyer nonEmpty' = Uzuki\n    ");
        System.out.print("Default value = Mochizuki\n");
        System.out.print("\n        Handling empty: " + defaultValueAssignment(empty, mocchi));
        System.out.println("\n        Handling nonEmpty: " + defaultValueAssignment(u_chan, mocchi));

        System.out.print(
                "\n.filter(Predicate predicate) and .map(Function mapper) does similar work as in Stream.\n    ");
        final Destroyer kisaragi_san = new Destroyer(2, "Kisaragi", "Mutsuki class");
        System.out.print("Before handled by .filter() and .map(): " + kisaragi_san);
        System.out.print("\n    After handling: " + translateFilterHandler(kisaragi_san, "Kisaragi", "如月", "睦月型"));

        System.out
                .print("\n\nOptional class has a global private static EMPTY value, could only be accessed by 'Optional.empty().'\n    Empty value: "
                        + Optional.empty());

    }

    public static Destroyer defaultValueAssignment(final Destroyer input, final Destroyer defaultValue) {
        final Optional checker = Optional.ofNullable(input);
        return (Destroyer) checker.orElse(defaultValue);
    }

    public static Destroyer translateFilterHandler(final Destroyer input, final String name,
            final String translatedName, final String translatedClazz) {
        final Optional checker = Optional.ofNullable(input);

        return (Destroyer) ((Optional<Destroyer>) checker).filter(x -> x.getName().equals(name)).map(x -> {
            x.setClazz(translatedClazz);
            x.setName(translatedName);
            x.translate();
            return x;
        }).get();
    }
}

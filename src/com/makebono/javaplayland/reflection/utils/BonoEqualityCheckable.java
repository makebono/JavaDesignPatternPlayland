/**Note:
 * It only takes care about matching of the field name and value, so different class names and methods don't bother. Which
 * in a word, if two objects have same number on fields and same value for each field, they are considered to be same here.
 * 
 */
package com.makebono.javaplayland.reflection.utils;

import java.lang.reflect.Field;
import java.util.Arrays;

/** 
 * @ClassName: BonoEqualityCheckable 
 * @Description: Abstract class for equality checking. Extends this for a deep to field .equals() method. 
 * @author makebono
 * @date 2018年1月11日 上午8:52:02 
 *  
 */
public abstract class BonoEqualityCheckable {
    @Override
    public boolean equals(final Object b) {
        // If you think class of each candidate should be same, toggle this on.
        /*if (!b.getClass() == this.getClass()) {
            System.out.println("Class names don't match.");
            return false;
        }
        */

        // An old, trivial but effective performance boosting gimmick. Any equality comparison could have this step.
        if (this == b) {
            // System.out.println("Candidates sharing the same reference.");
            return true;
        }

        Field[] thisFields;
        Field[] bFields;

        try {
            thisFields = this.getClass().getDeclaredFields();
            bFields = b.getClass().getDeclaredFields();
            final int tfSize = thisFields.length;
            final int bfSize = bFields.length;

            if (tfSize != bfSize) {
                // System.out.println("Number of fields don't match.");
                return false;
            }

            // Sort the fields array by field name for each object before going into comparison. Field names have to be
            // matched, or the value held by field may mean totally different thing even if they(values) are the same.
            // For example Age = 20 is definitely different from ID = 20.
            // And in the case of comparing 2 fields with same meaning but syntactically different, it's duty of a
            // mapper to map the field names correctly first.
            final FieldComparator sideKick = new FieldComparator();
            Arrays.sort(thisFields, sideKick);
            Arrays.sort(bFields, sideKick);

            for (int i = 0; i < tfSize; i++) {
                if (!thisFields[i].getName().equals(bFields[i].getName())) {
                    // System.out.println("Field names don't match.");
                    return false;
                }
                thisFields[i].setAccessible(true);
                bFields[i].setAccessible(true);
                if (thisFields[i].get(this).equals(bFields[i].get(b))) {
                    thisFields[i].setAccessible(false);
                    bFields[i].setAccessible(false);
                } else {
                    // System.out.println("Field values don't match.");
                    thisFields[i].setAccessible(false);
                    bFields[i].setAccessible(false);
                    return false;
                }
            }
            return true;
        }
        catch (final Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

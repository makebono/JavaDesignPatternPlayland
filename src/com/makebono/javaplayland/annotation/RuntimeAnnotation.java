/**Note:
 * Use
 *     if (m.isAnnotationPresent(RuntimeAnnotation.class)){...}
 * to handle annotation types. Force annotating... etc.
 * 
 */
package com.makebono.javaplayland.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
 * @ClassName: RuntimeAnnotation 
 * @Description: A runtime annotation
 * @author makebono
 * @date 2017年12月25日 上午10:45:38 
 *  
 */

// If not be set as .RUNTIME, it cannot be decided during runtime
@Retention(RetentionPolicy.RUNTIME)
// Decide where it can be annotated.
@Target(ElementType.METHOD)
public @interface RuntimeAnnotation {
    String bono() default "bobo";

    String bono2();

    int[] arr() default { 1, 2, 3, 4 };

}

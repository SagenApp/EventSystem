package app.sagen.event;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation put with a method symbolises that this method is a listener.
 * You can give it an EventPriority to tell the EventDispatcher how to prioritize the calls.
 * <br>
 * The events will be called in this order based on the priority<br>
 * 1 - LOWEST<br>
 * 2 - LOW<br>
 * 3 - NORMAL<br>
 * 4 - HIGH<br>
 * 5 - HIGHEST<br>
 * 6 - MONITOR<br>
 *
 * @author Sagen
 */
@Documented // Creates JavaDoc for this class
@Retention(value = RetentionPolicy.RUNTIME) // When this annotation should be read
@Target(ElementType.METHOD) // What element this annotation should be with
public @interface EventHandler {

    /**
     * The priority of the listener
     *
     * @return The priority
     */
    EventPriority priority() default EventPriority.NORMAL;

    /**
     * Whether or not this listener should ignore cancelled events.
     *
     * @return True if you want to ignore cancelled events, false if not.
     */
    boolean ignoreCancelled() default false;

}

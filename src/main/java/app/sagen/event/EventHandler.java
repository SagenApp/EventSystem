/*
  Copyright (c) 2018 Sagen.app

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in all
  copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
  SOFTWARE.
 */
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

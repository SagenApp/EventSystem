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

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * This class is responsible for keeping track of listeners and dispatch events to every listener
 *
 * @author Sagen
 */
public class EventDispatcher {

    /*
     * The map of every Event type registered and a list of Listeners registered for that event
     */
    private Map<Class<? extends Event>, Collection<EventWrapper>> eventHandlers = new HashMap<>();

    /**
     * This function will call every listener registered for this event with the given event.
     *
     * @param event The event to pass in
     * @param <T>   The type
     * @return The event passed in
     */
    public <T extends Event> T fire(T event) {
        Collection<EventWrapper> wrappers = eventHandlers.get(event.getClass());

        // if no listeners for that event, ignore
        if (wrappers == null) {
            return event;
        }

        // sort the list, then fire event in order
        wrappers.stream().sorted().forEach(w -> w.fire(event));

        return event;
    }

    /**
     * Register a new listener
     *
     * @param listener The listener to register
     */
    public void registerListener(Listener listener) {
        // return if listener is already registered.
        for (Collection<EventWrapper> v : eventHandlers.values()) {
            if (v.contains(listener)) return;
        }

        // Loop through every method that has the annotation EventHandler
        Arrays.stream(listener.getClass().getDeclaredMethods())
                .filter(method -> method.getAnnotation(EventHandler.class) != null)
                .forEachOrdered(method -> {

                    // get the parameter list,
                    // check that it has exactly one parameter,
                    // that it returns void and that the only parameter implements Event
                    Class<?>[] parameters = method.getParameterTypes();
                    if (parameters.length != 1 || !method.getReturnType().equals(void.class) || !Event.class.isAssignableFrom(parameters[0])) {
                        System.out.println("Invalid listener " + method.getName() + ". Ignoring...");
                        return;
                    }

                    // add the method to the map
                    if (!eventHandlers.containsKey(parameters[0]))
                        eventHandlers.put((Class<? extends Event>) parameters[0], new HashSet<>());
                    this.eventHandlers.get(parameters[0]).add(new EventWrapper(listener, method,
                            method.getAnnotation(EventHandler.class).priority(),
                            method.getAnnotation(EventHandler.class).ignoreCancelled()));
                });
    }
}

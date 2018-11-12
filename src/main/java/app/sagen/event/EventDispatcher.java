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

package app.sagen.event;

/**
 * This interface should be implemented by every class that you want to register to the EventDispatcher as an Listener.
 * <p>
 * The listener must be registered the the EventDispatcher before working.
 * <p>
 * To listen for an event the following conditions must be met
 * - The listener method must have the @EventHandler annotation with an optional EventPriority as parameter.
 * - The listener method must return void.
 * - The listener method must only have one parameter, and that should be the type of event to listen for.
 * <p>
 * Example
 * <code>
 * \@EventHandler(priority = EventPriority.LOW)
 * public void onEntityShoot(EntityShootEvent e) {
 * // handle event here
 * }
 * </code>
 *
 * @author Sagen
 */
public interface Listener {
}

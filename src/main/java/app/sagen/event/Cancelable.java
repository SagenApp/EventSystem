package app.sagen.event;

/**
 * Interface for cancelable events.
 *
 * @author Sagen
 */
public interface Cancelable {

    /**
     * Set if this event should be cancelled or not
     *
     * @param cancelled If cancelled or not
     */
    void setCancelled(boolean cancelled);

    /**
     * Gets if this event has been cancelled
     *
     * @return True if cancelled, false if not
     */
    boolean isCancelled();

}

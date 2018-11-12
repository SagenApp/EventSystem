package app.sagen.event;

/**
 * This enum contains every EventPriority supported by the event system. The lowest priority will be called first, then
 * the higher priorities.
 * Monitor should only be used for listening and should not change the event.
 * Middle is the default priority.
 * <p>
 * The events will be called in this order based on the priority
 * 1 - LOWEST
 * 2 - LOW
 * 3 - NORMAL
 * 4 - HIGH
 * 5 - HIGHEST
 * 6 - MONITOR
 *
 * @author Sagen
 */
public enum EventPriority {

    LOWEST(-2), LOW(-1), NORMAL(0), HIGH(1), HIGHEST(2), MONITOR(3);

    /*
     * The number representation of the priority
     */
    private int number;

    /**
     * Creates a new instance
     *
     * @param number The number representation
     */
    EventPriority(int number) {
        this.number = number;
    }

    /**
     * Gets the number representation of this EventPriority
     * <p>
     * LOWEST  - -2
     * LOW     - -1
     * NORMAL  - 0
     * HIGH    - 1
     * HIGHEST - 2
     * MONITOR - 3
     *
     * @return the number representation
     */
    public int getValue() {
        return number;
    }

}

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

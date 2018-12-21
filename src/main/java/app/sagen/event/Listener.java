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

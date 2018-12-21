# General purpose event system
### Simple system supporting multiple listeners per class

## Usage
**Creating an event**
```java
import app.sagen.event.*;

public class MyFancyEvent implements Event, Cancelable {
    private static boolean cancelled = false;
    private static MyClass someVariable;
    
    public MyFancyEvent(MyClass someVariable) {
        this.someVariable = someVariable;
    }
    
    public MyClass getSomeObject() {
        return someObject;
    }
    
    public void changeSomeObject(MyClass someNewVariable) {
        this.someVariable = someNewVariable;
    }
    
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
    
    public boolean isCancelled() {
        return cancelled;
    }
}
```

**Creating a listener**
```java
import app.sagen.event.*;

public class MyListener implements Listener {
    
    @EventHandler(priorty = EventPriority.NORMAL, ignoreCancelled = true)
    public void onMyFancyEvent(MyFancyEvent event) {
        // handle the event
    }
    
}
```

**Registering the listener and fire an event**
```java
EventDispatcher dispatcher = new EventDispatcher();

// register a listener to the dispatcher
dispatcher.registerListener(new MyListener());

// fire an event
MyFancyEvent event = new MyFancyEvent(myVariable);
dispatcher.fire(event);
```

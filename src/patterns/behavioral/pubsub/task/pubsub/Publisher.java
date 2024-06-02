package patterns.behavioral.pubsub.task.pubsub;

public interface Publisher<T> {
    void registerSubscriber(Listener<T> listener);

    void unregisterSubscriber(Listener<T> listener);

    void notifySubscribers(Event<T> event);
}

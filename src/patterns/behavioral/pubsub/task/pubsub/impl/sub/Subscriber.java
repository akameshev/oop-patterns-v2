package patterns.behavioral.pubsub.task.pubsub.impl.sub;

import patterns.behavioral.pubsub.task.pubsub.Event;
import patterns.behavioral.pubsub.task.pubsub.Listener;
import patterns.behavioral.pubsub.task.pubsub.Publisher;
import patterns.behavioral.pubsub.task.pubsub.impl.event.Video;

import java.util.ArrayList;
import java.util.List;

/**
  Video channel's subscriber.
 */
public class Subscriber implements Listener<Video>, Publisher<Boolean> {
    private final String nickname;
    private boolean isLikeVideo;
    private final List channelAdministrators;

    public Subscriber(String nickname) {
        this.nickname = nickname;
        this.isLikeVideo = false;
        this.channelAdministrators = new ArrayList<>();
    }

    public String getNickname() {
        return nickname;
    }

    public boolean isLikeVideo() {
        return isLikeVideo;
    }

    public void setLikeVideo(boolean likeVideo) {
        isLikeVideo = likeVideo;
    }

    @Override
    public void process(Event<Video> event) {

    }

    @Override
    public void registerSubscriber(Listener<Boolean> listener) {

    }

    @Override
    public void unregisterSubscriber(Listener<Boolean> listener) {

    }

    @Override
    public void notifySubscribers(Event<Boolean> event) {

    }
}

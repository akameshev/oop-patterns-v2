package patterns.behavioral.pubsub.task.pubsub.impl.sub;

import patterns.behavioral.pubsub.task.pubsub.ChannelAdmin;
import patterns.behavioral.pubsub.task.pubsub.Event;
import patterns.behavioral.pubsub.task.pubsub.Listener;
import patterns.behavioral.pubsub.task.pubsub.Publisher;
import patterns.behavioral.pubsub.task.pubsub.impl.event.Video;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Video channel's subscriber.
 */
public class Subscriber implements Listener<Video>, Publisher<Boolean> {
    private final String nickname;
    private boolean isLikeVideo;
    private final List<Listener<Boolean>> channelAdministrators;

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
        Video video = event.appear();
        Random random = new Random();
        if (video.getDuration() > random.nextInt(100)) {
            System.err.printf("%s This is very long! i dont like it %n", nickname);
            setLikeVideo(false);
            notifySubscribers(() -> isLikeVideo);
        } else
            System.out.printf("%s I like it! %n", nickname);
        setLikeVideo(true);
        notifySubscribers(() -> isLikeVideo);
    }

    @Override
    public void registerSubscriber(Listener<Boolean> listener) {
        this.channelAdministrators.add(listener);
    }

    @Override
    public void unregisterSubscriber(Listener<Boolean> listener) {
        this.channelAdministrators.remove(listener);
    }

    @Override
    public void notifySubscribers(Event<Boolean> event) {
        for (Listener<Boolean> admin:channelAdministrators){
            admin.process(event);
        }
    }
}

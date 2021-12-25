package pubsub;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class ContentServer {

    private final Map<Topic, Set<Subscriber>> subscribersMap = new HashMap<>();
    private final Map<Topic, Queue<Message>> messagesQueueMap = new HashMap<>();

    public void subscribe(Topic topic, Subscriber sub) {
        synchronized (this) {
            final Set<Subscriber> existentTopic = this.subscribersMap.get(topic);
            if (existentTopic == null) {
                this.subscribersMap.put(topic, this.createSubscribersSet(sub));
            } else {
                existentTopic.add(sub);
            }
            System.out.println("\n>>> " + sub + " subscribed on topic " + topic);
        }
    }

    public boolean publish(Topic topic, Message message) {
        synchronized (this) {
            final Set<Subscriber> topicSubscribers = this.subscribersMap.get(topic);
            if (topicSubscribers == null || topicSubscribers.isEmpty()) {
                System.out.println("\n>>> " + topic + " missed");
                return false;
            }
            this.addMessageToTopic(topic, message);
            this.notify(topic);
            return true;
        }
    }

    private Set<Subscriber> createSubscribersSet(Subscriber sub) {
        final HashSet<Subscriber> subscribers = new HashSet<>();
        subscribers.add(sub);
        return subscribers;
    }

    private void addMessageToTopic(Topic topic, Message message) {
        final Queue<Message> existentQueue = this.messagesQueueMap.get(topic);
        if (existentQueue == null) {
            this.messagesQueueMap.put(topic, this.createQueue(message));
        } else {
            existentQueue.add(message);
        }
        System.out.println("\n>>> " + message + " added to topic " + topic);
    }

    private LinkedBlockingQueue<Message> createQueue(Message message) {
        final LinkedBlockingQueue<Message> newQueue = new LinkedBlockingQueue<>();
        newQueue.add(message);
        return newQueue;
    }

    private void notify(Topic topic) {
        final Queue<Message> topicQueue = this.messagesQueueMap.get(topic);
        final Set<Subscriber> topicSubscribers = this.subscribersMap.get(topic);
        if (topicQueue != null && topicSubscribers != null) {
            while (!topicQueue.isEmpty()) {
                final Message message = topicQueue.remove();
                topicSubscribers.forEach(sub -> {
                    System.out.println("\n>>> sending message: " + message + " from topic " + topic + " to " + sub);
                    sub.handleMessage(topic, message);
                });
            }
        }
    }
}

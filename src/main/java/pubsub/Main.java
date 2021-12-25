package pubsub;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.floor;
import static java.lang.Math.random;

public class Main {

    public static void main(String[] args) {
        final ContentServer contentServer = new ContentServer();
        final Topic[] topics = {
                new Topic("Topic ABC"),
                new Topic("Topic XPTO"),
                new Topic("Topic QWERTY"),
                new Topic("Topic XYZ")};

        createSubscribers().forEach(sub -> contentServer.subscribe(getRandomTopic(topics), sub));
        sleep();
        createSenders(contentServer, topics).forEach(Sender::run);
    }

    private static ArrayList<Subscriber> createSubscribers() {
        return IntStream.range(0, 10)
                .mapToObj(Subscriber::new)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static ArrayList<Sender> createSenders(ContentServer contentServer, Topic[] topics) {
        return IntStream.range(0, 10)
                .mapToObj(i -> new Sender(i, contentServer, topics))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static Topic getRandomTopic(Topic[] topics) {
        final double topicIndex = floor(random() * topics.length);
        return topics[(int) topicIndex];
    }

    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

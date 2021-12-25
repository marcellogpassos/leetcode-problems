package pubsub;

import static java.lang.Math.floor;
import static java.lang.Math.random;

public class Sender implements Runnable {

    private final int i;
    private final ContentServer contentServer;
    private final Topic[] topics;

    public Sender(int i, ContentServer contentServer, Topic[] topics) {
        System.out.println("Sender " + i + " created.");
        this.i = i;
        this.contentServer = contentServer;
        this.topics = topics;
    }

    @Override
    public void run() {
        System.out.println("Sender " + i + " running.");
        int turn = 0;
        while (true) {
            this.contentServer.publish(getRandomTopic(this.topics), new Message("Message: " + turn++));
            sleep();
        }
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

package pubsub;

import java.time.LocalDateTime;

public class Subscriber {

    private final int id;

    public Subscriber(int id) {
        this.id = id;
    }

    public void handleMessage(Topic topic, Message message) {
        final StringBuilder builder = new StringBuilder()
                .append("\n***** ")
                .append(this)
                .append(" *****")
                .append("\nNew message received from topic: ")
                .append(topic)
                .append(" at: ")
                .append(LocalDateTime.now())
                .append("\n" + message)
                .append("\n*****\n");
        System.out.println(builder);
    }

    public String toString() {
        return "Subscriber #" + this.id;
    }
}

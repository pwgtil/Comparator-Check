package messages;

import java.util.Comparator;

public class MessageLenghtComparator implements Comparator<Message> {

    @Override
    public int compare(Message firstMessage, Message secondMessage) {
        int firstMessageLength = firstMessage.getContent().length();
        int secondMessageLength = secondMessage.getContent().length();
        return Integer.compare(firstMessageLength, secondMessageLength);
    }
}


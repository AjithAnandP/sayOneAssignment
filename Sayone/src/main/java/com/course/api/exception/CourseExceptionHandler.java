package com.course.api.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CourseExceptionHandler extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = 2909566653236171691L;
    /**
     * Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(CourseExceptionHandler.class);
    /**
     * Message list
     */
    private final List<String> messages;

    /**
     * Create a validation exception with a single message. The message will
     * automatically be logged.
     *
     * @param message the message to indicate why an item was invalid.
     */
    public CourseExceptionHandler(String message) {
        super(message);
        this.messages = new ArrayList<>();
        this.messages.add(message);
        logMessage();
    }

    /**
     * Create a validation exception for a list of messages. The messages will
     * automatically be logged.
     *
     * @param messages the messages indicating the reason for invalidity
     */
    public CourseExceptionHandler(List<String> messages) {
        super(buildMessage("\n", messages));
        this.messages = messages;
        logMessage();
    }

    /**
     * Create a validation exception with no messages. A single message "no
     * specifics given" will be added to the message list. The messages will
     * automatically be logged.
     *
     * @param cause The reason for the exception
     */
    public CourseExceptionHandler(Throwable cause) {
        super(cause);
        this.messages = new ArrayList<>();
        messages.add("no specifics given");
        logMessage();
    }

    /**
     * Create a validation exception with messages and a cause. This indicates
     * that an exception that was not expected.
     *
     * @param messages any available information on invalidity if there is any
     * @param cause    the exception that caused the validation to fail.
     */
    public CourseExceptionHandler(List<String> messages, Throwable cause) {
        super(buildMessage("\n", messages), cause);
        this.messages = messages;
        logMessage();
    }

    /**
     * Log the message. This will build a message with the delimeter ";" between
     * messages in the message list and log a single line.
     */
    private void logMessage() {
        logger.error(buildMessage(";", messages), this);
    }

    /**
     * Build a single String message from the message list, delimiting the
     * elements in the list by the given delimiter.
     *
     * @param delimiter a string to use for separating individual messages
     * @param messages  the list of messages to build the single message from
     * @return A string to represent the message list.
     */
    private static String buildMessage(String delimiter, List<String> messages) {

        StringBuilder builder = new StringBuilder();
        int msgCount = messages.size();
        for (String s : messages) {
            builder.append(s);
            if (--msgCount > 0) {
                builder.append(delimiter);
            }
        }
        return builder.toString();

    }
}

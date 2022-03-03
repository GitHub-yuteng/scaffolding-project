package com.scaffolding.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author whh-yt
 */
public class EmailEvent extends ApplicationEvent {

    private static final long serialVersionUID = -8250118347691397363L;

    private String address;
    private String text;

    public EmailEvent(Object source, String address, String text) {
        super(source);
        this.address = address;
        this.text = text;
    }

    public EmailEvent(Object source) {
        super(source);
    }
}
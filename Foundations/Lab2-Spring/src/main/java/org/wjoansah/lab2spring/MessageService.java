package org.wjoansah.lab2spring;

import org.springframework.stereotype.Service;

@Service
public class MessageService implements IMessageService {
    @Override
    public String getMessage() {
        return "Message from MessageService!";
    }
}

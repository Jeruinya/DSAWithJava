package com.scaler.designPattern;

import com.scaler.design.impl.EmailNotification;
import com.scaler.design.impl.Notification;
import com.scaler.design.impl.PushNotification;
import com.scaler.design.impl.SMSNotification;

public class NotificationFactory {
    public Notification createNotification(String channel)
    {
        if (channel == null || channel.isEmpty())
            return null;
        switch (channel) {
        case "SMS":
            return new SMSNotification();
        case "EMAIL":
            return new EmailNotification();
        case "PUSH":
            return new PushNotification();
        default:
            throw new IllegalArgumentException("Unknown channel "+channel);
        }
    }
}
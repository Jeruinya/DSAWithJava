package com.scaler.designPattern;

import com.scaler.design.impl.Notification;

public class FactoryDesignPattern {

	public static void main(String[] args) {
		NotificationFactory notificationFactory = new NotificationFactory();
		Notification notification = notificationFactory.createNotification("SMS");
		notification.notifyUser();
	}
}
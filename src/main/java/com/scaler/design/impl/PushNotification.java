package com.scaler.design.impl;

public class PushNotification implements Notification {

	@Override
	public void notifyUser() {
		System.out.println("Sending a push notification");
	}
}
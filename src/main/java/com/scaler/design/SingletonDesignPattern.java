package com.scaler.design;

//Classical Java implementation of singleton
//Not thread safe and there could be chance of creating two objects if two threads executed simultaneously.
class SingletonDesignPattern1 {
	private static SingletonDesignPattern1 obj;

	private SingletonDesignPattern1() {
	}

	public static SingletonDesignPattern1 getInstance() {
		if (obj == null)
			obj = new SingletonDesignPattern1();
		return obj;
	}
}

//Thread Synchronized Java implementation of
class SingletonDesignPattern2 {
	private static SingletonDesignPattern2 obj;

	private SingletonDesignPattern2() {
	}

	// Only one thread can execute this at a time
	public static synchronized SingletonDesignPattern2 getInstance() {
		if (obj == null)
			obj = new SingletonDesignPattern2();
		return obj;
	}
}

//Static initializer based Java implementation of
class SingletonDesignPattern3 {
	private static SingletonDesignPattern3 obj = new SingletonDesignPattern3();

	private SingletonDesignPattern3() {
	}

	public static SingletonDesignPattern3 getInstance() {
		return obj;
	}
}

class SingletonDesignPattern4 {

	private static volatile SingletonDesignPattern4 obj = null;

	private SingletonDesignPattern4() {
	}

	public static SingletonDesignPattern4 getInstance() {
		if (obj == null) {
			synchronized (SingletonDesignPattern4.class) {
				// check again as multiple threads can reach above step
				if (obj == null)
					obj = new SingletonDesignPattern4();
			}
		}
		return obj;
	}
}
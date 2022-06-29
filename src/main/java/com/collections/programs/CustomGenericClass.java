package com.collections.programs;

class Test<T> {
	// An object of type T is declared
	T obj;

// constructor
	Test(T obj) {
		this.obj = obj;
	}

	public T getObject() {
		return this.obj;
	}
}

class Test1<T, U> {
	T obj1;
	U obj2;

	// constructor
	Test1(T obj1, U obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}

	// To print objects of T and U
	public void print() {
		System.out.println(obj1);
		System.out.println(obj2);
	}
}

// Driver class to test above
class CustomGenericClass {
	public static void main(String[] args) {
		// instance of Integer type
		Test<Integer> iObj = new Test<Integer>(15);
		System.out.println(iObj.getObject());

		// instance of String type
		Test<String> sObj = new Test<String>("GeeksForGeeks");
		System.out.println(sObj.getObject());

		Test1<String, Integer> obj = new Test1<String, Integer>("GfG", 15);

		obj.print();
	}

}

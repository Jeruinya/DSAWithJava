import java.util.ArrayList;

public class Test {
	public static void main(String[] args) 
	{
		ArrayList al=new ArrayList();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		al.add(5);
		al.add(6);
		al.add(7);
		al.add(8);
		al.add(9);
		al.add(10);
		System.out.println(al.size());
		System.out.println(al);
		for(int i=0;i<al.size();i++)
			al.remove(i);
		System.out.println(al);
	}
}
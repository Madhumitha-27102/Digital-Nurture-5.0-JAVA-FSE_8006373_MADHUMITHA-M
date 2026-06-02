package Practice;
import java.util.*;
public class hashmap {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		HashMap<Integer,String>map=new HashMap<>();
		int N=sc.nextInt();
		for(int i=0;i<N;i++)
		{
		int Student_id=sc.nextInt();
		String name=sc.next();
		map.put(Student_id, name);
		}
		System.out.println("Details"+map);
	
		System.out.println("Enter the ID to search");
		int key=sc.nextInt();
		if(map.containsKey(key))
		{
			System.out.println("Name:"+map.get(key));
		}
		else
		{
			System.out.println("ID not found in the details");
		}
		
	}
}

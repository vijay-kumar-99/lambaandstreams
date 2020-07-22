package vijay.lambda;

/**
 * Hello world!
 *
 */
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.IntStream;
@FunctionalInterface
interface Palin{
	void ListOfPalindrome(List<String> list);
}

public class App implements Palin
{
	static final Scanner sc=new Scanner(System.in);
	static boolean palin(String s)
	{
		return IntStream.range(0, s.length() / 2).noneMatch(i -> s.charAt(i) != s.charAt(s.length() - i - 1));
	}
	public void ListOfPalindrome(List<String> list)
	{
		Predicate<String> p = (s)->palin(s);
		for (String st:list) 
		{
            if (p.test(st)) 
                System.out.println(st); 
        } 
	}
    public static void main( String[] args )
    {	
    	boolean flag=false;
    	while(true) {
    		System.out.println("Press 1 to find Average of n numbers");
    		System.out.println("Press 2 to Manipulate the string");
    		System.out.println("Press 3 to Check Palindromes from the given list");
    		System.out.println("Enter 0 to exit");
    		int n=sc.nextInt();
    		int siz;
    		switch(n) {
    			case 1:
    			{
    				System.out.printf("Enter list size to get average of given numbers: ");
    		    	siz=sc.nextInt();
    		    	List<Integer> list=new ArrayList<Integer>();
    		    	for(int i=0;i<siz;i++)
    		    	{
    		    		System.out.printf("\nEnter %dth number: ",i+1);
    		    		list.add(sc.nextInt());
    		    	}
    		        Average avg=new Average();
    		        System.out.printf("\nThe average of given %d numbers is : %f\n",siz,avg.avg(list));
    		        System.out.println("****************************************************************************************************************");
    		        break;
    			}
    			case 2:{
    				System.out.println("Enter the number of string: ");
    				siz=sc.nextInt();
    				sc.nextLine();
    				List<String> list=new ArrayList<String>();
    				for(int i=0;i<siz;i++)
    		    	{
    		    		System.out.printf("\nEnter %dth string: ",i+1);
    		    		list.add(sc.nextLine());
    		    	}
    				StringChange man=new StringChange();
    				list=man.stringManipulate(list);
    				System.out.println("The String with required Conditions are:");
    				for(int i=0;i<list.size();i++)
    				{
    					System.out.println(list.get(i));
    				}
    				System.out.println("****************************************************************************************************************");
    				break;
    			}
    			case 3:{
    				System.out.println("Enter the number of string: ");
    				siz=sc.nextInt();
    				sc.nextLine();
    				List<String> list=new ArrayList<>();
    				for(int i=0;i<siz;i++)
    		    	{
    		    		System.out.printf("\nEnter %dth string: ",i+1);
    		    		list.add(sc.nextLine());
    		    	}
    				App p=new App();
    		        p.ListOfPalindrome(list);
    		        System.out.println("****************************************************************************************************************");
    				break;
    			}
    			default:
    				flag=true;
    				break;
    		}
    		if(flag) return;
    	}
    }
}
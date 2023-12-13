import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class values{
	int profit;
	int weight;
	double ratio;
	public values(int p,int w,double r) {
		this.profit = p;
		this.weight = w;
		this.ratio = r;
	}
	public String toString() 
    {//for easy and readable printing
		return this.profit + " " + this.weight + " "+ this.ratio; 
    }
}

class Sortbyratio implements Comparator<values>{
	public int compare(values a, values b) {
		{
			return Double.compare(a.ratio,b.ratio);
		}

}
}
public class Knapsack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 3;//no of inputs 
		int sack = sc.nextInt();//sack 
		ArrayList <values> arr = new ArrayList<values>();
		//adding the profit and weight in the arraylist
		for(int i=0;i<n;i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			double c = (double)a/(double)b;
			arr.add(new values(a,b,c));
		}
		
		 
		Collections.sort(arr, Collections.reverseOrder(new Sortbyratio())); 
		
//		for (int i = 0; i < arr.size(); i++) 
//            System.out.println(arr.get(i)); 
		double maxprofit = 0;
		for(values i : arr) {
			if(sack - (int)i.weight >= 0) {
				
				sack -= i.weight;
				maxprofit += i.profit; 
			}
			else {
				maxprofit += sack*i.ratio;
				sack -= (int)(sack*i.ratio); 
				break;
			}
		}
		
		System.out.println(maxprofit);
	}

	
}

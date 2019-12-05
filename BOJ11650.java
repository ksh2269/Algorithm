package assignment1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class BOJ11650 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        xy[] arr = new xy[n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new xy(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        
        Arrays.sort(arr);
        
        for(int i=0; i<n; i++) {
            System.out.println(arr[i].x + " " + arr[i].y);
        }
    }
 
}
 
class xy implements Comparable<xy>  {
    int x;
    int y;
    
    public xy(int x,int y) {
        this.x = x;
        this.y = y;
    }
 
    public int compareTo(xy arg0) {
        if(this.x == arg0.x) {
            return this.y - arg0.y;
        } else {
            return this.x - arg0.x;
        }
    }
}
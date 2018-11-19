package addTwoNumber2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while((line = in.readLine())!= null){
			ListNode l1 = stringToListNode(line);
			line = in.readLine();
			ListNode l2 = stringToListNode(line);
			
			ListNode ret = new Solution().addTwoNumber(l1,l2);
			
			String out = listNodeToString(ret);
			
			System.out.print(out);
		}
		
	}

	private static String listNodeToString(ListNode ret) {
		if(ret == null){
			return "[]";
		}
		String result = "";
		while(ret!=null){
			result += Integer.toString(ret.val) + ", ";
			ret = ret.next;
		}
		return "["+result.substring(0,result.length() - 2) + "]";
	}

	private static ListNode stringToListNode(String line) {
		int[] nodeValues = stringToIntegerArray(line);
		
		ListNode dummyRoot = new ListNode(0);
		ListNode ptr = dummyRoot;
		for(int item:nodeValues){
			ptr.next = new ListNode(item);
			ptr = ptr.next;
		}
		return dummyRoot.next;
	}

	private static int[] stringToIntegerArray(String input) {
		input = input.trim();
		input = input.substring(1,input.length() - 1);
		if(input.length() == 0){
			return new int[0];
		}
		String[] parts = input.split(",");
		int[] output = new int[parts.length];
		for(int index = 0; index < parts.length;index++){
			String part = parts[index].trim();
			output[index] = Integer.parseInt(part);
		}
		return output;
	}

}
class ListNode {
     int val;
     ListNode next;
   ListNode(int x) { val = x; }
}
class Solution{
	public ListNode addTwoNumber(ListNode l1,ListNode l2){
		ListNode dummyHead =new ListNode(0);
		ListNode p = l1,q = l2,sub = dummyHead;
		int carry = 0;
		while(p!=null||q!=null){
			int x = (p!=null)?p.val:0;
			int y = (q!=null)?q.val:0;
			int sum = carry + x + y;
			carry = sum/10;
			sub =new ListNode(sum%10);
			sub = sub.next;
			if(p!=null) p = p.next;
			if(q!=null) q = q.next;
		}
		if(carry > 0){
			sub.next = new ListNode(carry);
		}
		
		return dummyHead.next;
	}
}

























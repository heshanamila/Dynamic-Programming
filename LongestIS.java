import java.util.Random;
import java.util.Scanner;

class LongestIS {

	public static void main (String args[]) {
		int invitations=0;

		// Get user input about no. of invitations
		Scanner scanner = new Scanner(System.in);

		do{
			System.out.println("How many invitees are there? ");
			invitations = scanner.nextInt();

			if(invitations < 1 || invitations > 1000){
				System.out.println("Error : Check your input");
			}
			
		}while(invitations < 1 || invitations > 1000);

		int array[] = new int[invitations];	

		Random random = new Random();

		System.out.print("Random numbers : ");
		for(int i=0; i<array.length; i++){
			array[i] = random.nextInt(invitations);
			System.out.print(array[i] + " ");
		}

		LongestIS lis = new LongestIS();
		lis.calcLIS(array);
		
	}
	
	public void calcLIS (int array[]) {
		int lSubLength[] = new int[array.length];
		int indexList[] = new int[array.length];
		int maxLength = 1;
		int maxLengthIndex = 0;
		String output = "";
		
		for (int i=0; i<array.length; i++) {
			lSubLength[i] = 1;
			indexList[i] = -1;
			
			for (int j=0; j<i; j++) {
				if (array[j] < array[i] && lSubLength[i] < lSubLength[j] + 1) {
					lSubLength[i] = lSubLength[j] + 1;
					indexList[i] = j;
					if (maxLength <= lSubLength[i]) {
						maxLength = lSubLength[i];
						maxLengthIndex = i;
					}
				}
			}
		}
		
		for (int i=maxLengthIndex; i>-1;) {
			output = array[i] + " " + output;
			i = indexList[i];
		}
		
		System.out.println("\nLongest Increasing Subsequence Length : " + maxLength);
		System.out.println("Longest Increasing Subsequence        : " + output);
	}
}

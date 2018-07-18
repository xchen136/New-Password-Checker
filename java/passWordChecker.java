import java.util.Arrays;

public class passWordChecker {
	private int[] charCount = new int[5];
	
	passWordChecker(){
		Arrays.fill(charCount,  0);
	}
	
	public void displayRules(){
		System.out.println("");
		System.out.println("Password Rules: ");
		System.out.println("1) The password length: 8-16 characters");
		System.out.println("2) At least one numerical, i.e., 0, 1, 2,..");
		System.out.println("3) At least one upper case letter, i.e., A, B, C, ...");
		System.out.println("4) At least one lower case letter, i.e., a, b, c, ...");
		System.out.println("5) At least one of the special characters, but it must be within the set:{ $ ^ & #  ( ) } at total of six (6). No other special characters is allowed.");
		System.out.print("Please create a new password: ");
	}
	
	public void displaySuccess(){
		System.out.println("Your password will be updated in 2 minutes.");
	}
	
	public int checkChar(char ch ){	//identifies the character and return the corresponding index from 0-4
		if( (int)ch == 36 || (int)ch == 94 || (int)ch == 38 || (int)ch == 35 || (int)ch == 40 || (int)ch == 41){	//legal special characters
			return 4;
		}
		else if( (int)ch >= 48 && (int)ch <= 57){	//numeric values
			return 1;
		}
		else if( (int)ch >= 97 && (int)ch <= 122){	//lowercases
			return 2;
		}
		else if( (int)ch >= 65 && (int)ch <= 90){	//uppercases
			return 3;
		}
		else{										//illegal special characters
		 	return 0;										
		}	
	}
	
	public boolean checker(){		//checks numeric validity of password using the array
		if(charCount[0] == 0 && charCount[1] > 0 && charCount[2] > 0 && charCount[3] > 0 && charCount[4] > 0 ){
			return true;
		}
		else{
			return false;
		}	
	}
	
	public boolean matching(String s1, String s2){		//checks if first and second password matches
		if(s1.equals(s2))
			return true;
		else{
			System.out.println("ERROR: The two passwords do not match.");
			return false;
		}
	}
	
	public void setCount(int i){
		++charCount[i];
	}
	
	public boolean checkLength(String str){
		if(str.length() < 8 || str.length() > 16){		//display the rules again if password length is out of range
			return false;
		} 
		else
			return true;
	}
}

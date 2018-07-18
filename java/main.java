//Cs323 - Project 2 - Xiaomin Chen

import java.util.Scanner;

public class main {
	public static void main(String args[]){
		String password = new String("");
		String secondPassword = new String("");
		passWordChecker chk = new passWordChecker();
		Scanner input = new Scanner(System.in);
		
		do{
			do{
				password = newPassword();												//simply gets a new password
			}while(pChk(password) == false);											//asks for password again if password is not valid																				
		
			//New password is valid, continues 
			
			System.out.print("Please retype your password for verification: ");			//verify the password is typed correctly
			secondPassword = input.next();
			
		}while(chk.matching(password, secondPassword) == false);

		chk.displaySuccess();
		input.close();
	}
	
	public static String newPassword(){		//asks for new password
		Scanner newI = new Scanner(System.in);
		String in;
		passWordChecker newP = new passWordChecker();
		newP.displayRules();
		in = newI.next();
		return in;
	}
	
	public static boolean pChk(String passW){		//returns true only if the password is valid
		int index;
		passWordChecker p = new passWordChecker();
		
		if(p.checkLength(passW) == false){												//returns false if length is not valid
			System.out.println("ERROR: Password length must be between 8-16 characters. Try again.");
			return false;
		}
		
		for(int i=0; i<passW.length(); i++){											//identify each character of the string
				index = p.checkChar(passW.charAt(i));									
				p.setCount(index);														//updates the countChar array
		}
		
		if(p.checker() == false){														//returns false if password did not follow the rules
			System.out.println("ERROR: Password requirement is not met. Try again.");
			return false;
		}
		else{
			return true;
		}
			
	}
}



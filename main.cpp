//Cs323 - Project#2 - Xiaomin Chen 

#include<iostream>
#include<string>
using namespace std;

class passWordChecker{
	private:
		int charCount[5] = {0};
		
	public:
		passWordChecker(){	
		}
		
		void displayRules(){
			cout<<"\n\nPassoword Rules:\n";
			cout<<"1) The password length: 8-16 characters\n";
			cout<<"2) At least one numerical, i.e., 0, 1, 2,..\n";
			cout<<"3) At least one upper case letter, i.e., A, B, C, ...\n";
			cout<<"4) At least one lower case letter, i.e., a, b, c, ...\n";
			cout<<"5) At least one of the special characters, but it must be within the set:{ $ ^ & #  ( ) } at total of six (6). No other special characters is allowed.\n";	
			cout<<"Please create a new password: ";		
		}
		
		void displaySuccess(){
			cout<<"Your password will be updated in 2 minutes.\n";
		}
		
		int checkChar(char ch ){	//identifies the character and return the corresponding index from 0-4
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
		
		bool checker(){		//checks numeric validity of password using the array
			if(charCount[0] == 0 && charCount[1] > 0 && charCount[2] > 0 && charCount[3] > 0 && charCount[4] > 0 ){
				return true;
			}
			else{
				return false;
			}	
		}
		
		bool matching(string s1, string s2){	//checks if first and second password matches
			if(s1 == s2)
				return true;
			else{
				cout<<"ERROR: The two passwords do not match.";
				return false;
			}
		}
		void setCount(int i){
			++charCount[i];
		}
		bool checkLength(string str){
			if(str.length() < 8 || str.length() > 16){		//display the rules again if password length is out of range
				return false;
			} 
			else
				return true;
		}
		
};

string newPassword(){	//asks for new password
	string in;
	passWordChecker *newP = new passWordChecker();
	newP->displayRules();
	cin >> in;
	return in;
	delete newP;
}

bool pChk(string passW){	//returns true only if the password is valid
	int index;
	passWordChecker *p = new passWordChecker();
	
	if(p->checkLength(passW) == false){												//returns false if length is not valid
		cout<<"ERROR: Password length must be between 8-16 characters. Try again.";
		delete p;
		return false;
	}
	
	for(int i=0; i<passW.length(); i++){											//identify each character of the string
			index = p->checkChar(passW[i]);									
			p->setCount(index);														//updates the countChar array
	}
	
	if(p->checker() == false){														//returns false if password did not follow the rules
		cout<<"ERROR: Password requirement is not met. Try again.";
		delete p;
		return false;
	}
	else{
		delete p;
		return true;
	}
		
}

int main(){
	string password = "";
	string secondPassword = "";
	passWordChecker *chk = new passWordChecker();
	
	do{
		do{
			password = newPassword();												//simply gets a new password
		}while(pChk(password) == false);											//asks for password again if password is not valid																				
	
		//New password is valid, continues 
		cout<<"Please retype your password for verification: ";						//verify the password is typed correctly
		cin >> secondPassword;	
		
	}while(chk->matching(password, secondPassword) == false);

	chk->displaySuccess();
	delete chk;
	return 0;
}

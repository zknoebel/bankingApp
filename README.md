# Banking App

### Programming assignment 1

##### ICS355 University of Hawaii at Manoa

    Task: Produce a financial program that tracks the balances of multiple users and supports multiple currencies. This will be done in stages.
    Detail: Produce a command-line driven financial calculator that supports multiple currencies. The program should be capable of adding and subtracting values from a user’s account. The program should handle conversion of the currencies prior to the arithmetic operation. The program should include commands:
    MAINT – Allow currency conversion data to be entered (or read in)
    ##### Create regular expressions to validate all input to include commands, usernames, currency types, and currency values. For currency values, validation should be consistent with the standards used to write numbers in the currency being used. (e.g. $3,150.02, £10.52, etc.). Be sure to document your assumptions for formats in your report. 
    Accepting ambiguous currency values is acceptable as long as you handle the ambiguity reasonably
    You must accept at least three unique currencies (e.g. USD, UK Pound, Euro). You must include functions that allow conversion values to be input for the currencies that you will support.
    You must gracefully reject any attempts to provide invalid data.
    The database of currencies should persist between executions of the program.
    Permissible languages: C/C++, Java, Python, or Other with permission of instructor. No Shell Scripts
    Output:
        Program
        1 page summary including how to install any dependencies, how to run the application, and example runs.

    Due: Oct 15th @ 11:55pm
    
The Banking App is an application that allows a user to create, modify and store bank accounts. It supports three forms of currency, US Dollars, Euros and Japanese Yen.

#### Installation

To get this program, you can download the BankingApp.jar file from https://github.com/zknoebel/bankingApp

You can also clone the repository and compile the app yourself using Git and Maven.

Ubuntu users can use these commands.
    $ sudo apt install git
    $ sudo apt install maven
    $ git clone https://github.com/zknoebel/bankingApp.git
    $ cd bankingApp
    $ mvn clean compile assembly:single
    
#### Running the program

To run this program you need to have Java installed.

Ubuntu users can use this command 
    $ sudo apt install openjdk-8-jdk
    
Then you run the program using Java
    $ java -jar BankingApp.jar

Once the program is started, different options can be selected.

##### Select an option by typing the word and then pressing enter. 

Each option is a single word consisting only of letters from the english alphabet and is not case sensitive. 

        
        ADD - Add money to an account.
        ACCOUNT - Modify account information.
        CONVERSIONS - show current currency conversion ratios
        CREATE - Create a new bank account.
        DELETE - Remove account from database. (CANNOT BE UNDONE)
        EXIT - Close program.
        HELP - Display options.
        MAINT - Allow currency conversion data to be entered (or read in).
        LIST - Print a list of all current accounts.
        TRANSFER - Move funds from one account to another.
        WITHDRAW - Remove money from an account.
        
The first time the program is started, there will be no accounts in the database. Use the CREATE option to add new accounts. The currency conversion ratios start at 1:1:1 and they can be changed with the MAINT option.

##### ADD
    First choose the account number for an existing account (to make a new account use CREATE).
    Next choose the amount of money to add and the currency type.
    This can be done one of two ways. Enter both at once like this <currency type character> <amount> example $43.22 or type the amount and then press enter. This will show you the list of acceptable currency types and also allow you to type the word out instead of just using the character. This will be helpful in case you don't have the Euro or Yen symbol on your keyboard.
    
##### ACCOUNT
    First choose the account number for an existing account (to make a new account use CREATE).
    Next choose the attribute to change. At the moment the only attribute that there is to change is the username. At some point there might be other attributes added such as first name, last name, address and phone number.
    Usernames are only allowed to have letters from the english alphabet and they are not case sensitive.
    
##### CONVERSIONS
    This will show the ratios of value for the availaible currency types. 
    They will start out as 1:1:1 and can be changed with the MAINT option.
    
##### CREATE
    This will allow you to create a new bank account.
    Start by choosing an unused account number.
    Then add the balance for the account to start out at.
    Next choose the amount of money to add and the currency type.
    This can be done one of two ways. Enter both at once like this <currency type character> <amount> example $43.22 or type the amount and then press enter. This will show you the list of acceptable currency types and also allow you to type the word out instead of just using the character. This will be helpful in case you don't have the Euro or Yen symbol on your keyboard.
    Then choose the username.
    Usernames are only allowed to have letters from the english alphabet and they are not case sensitive.

##### DELETE
    Enter the account number of the account you wish to delete.
    To get a list of accounts, you can use the LIST option.
    
##### EXIT
    This will save the database and close the program.
    
##### HELP
    This will display a list of the available options.
    
##### MAINT
    This will allow you to change the ratios of value for the available currency types.
    The number for each ratio must greater than zero.
    If you want to see the current ratios, before choosing MAINT you can display them with CONVERSIONS.
    
##### LIST
    This will show a list of the current accounts and their associated information.
    
##### TRANSFER
    This can be used to move money from one account to another.
    Choose the account to take the money from and the account to move the money to.
    Then choose the amount of money to move.
    This can be done one of two ways. Enter both at once like this <currency type character> <amount> example $43.22 or type the amount and then press enter. This will show you the list of acceptable currency types and also allow you to type the word out instead of just using the character. This will be helpful in case you don't have the Euro or Yen symbol on your keyboard.
    
##### WITHDRAW
    First choose the account number for an existing account (to make a new account use CREATE).
    Next choose the amount of money to withdraw and the currency type.
    This can be done one of two ways. Enter both at once like this <currency type character> <amount> example $43.22 or type the amount and then press enter. This will show you the list of acceptable currency types and also allow you to type the word out instead of just using the character. This will be helpful in case you don't have the Euro or Yen symbol on your keyboard.

#### Example Run
This is just the contents of the testRun.txt file. (The random underscores and parentheses are ascii art that shows up better in the testRun.txt file)

Script started on 2017-10-15 21:50:52-1000
]0;zac@zac-pc:~/workspace/school/ICS355/bankingApp[01;32m[zac@zac-pc[01;37m bankingApp[01;32m]$[00m java -jar BankingApp.jar 
 ______   _______  _        _       _________ _        _______        _______  _______  _______
(  ___ \ (  ___  )( (    /|| \    /\\__   __/( (    /|(  ____ \      (  ___  )(  ____ )(  ____ )
| (   ) )| (   ) ||  \  ( ||  \  / /   ) (   |  \  ( || (    \/      | (   ) || (    )|| (    )|
| (__/ / | (___) ||   \ | ||  (_/ /    | |   |   \ | || |            | (___) || (____)|| (____)|
|  __ (  |  ___  || (\ \) ||   _ (     | |   | (\ \) || | ____       |  ___  ||  _____)|  _____)
| (  \ \ | (   ) || | \   ||  ( \ \    | |   | | \   || | \_  )      | (   ) || (      | (
| )___) )| )   ( || )  \  ||  /  \ \___) (___| )  \  || (___) |      | )   ( || )      | )      
(______/ |/     \||/    )_)|_/    \/\_______/|/    )_)(_______)      |/     \||/       |/       

Enter HELP for a list of options.

Enter an option: help
 _______  _______ __________________ _______  _        _______ 
(  ___  )(  ____ )\__   __/\__   __/(  ___  )( (    /|(  ____ \
| (   ) || (    )|   ) (      ) (   | (   ) ||  \  ( || (    \/
| |   | || (____)|   | |      | |   | |   | ||   \ | || (_____ 
| |   | ||  _____)   | |      | |   | |   | || (\ \) |(_____  )
| |   | || (         | |      | |   | |   | || | \   |      ) |
| (___) || )         | |   ___) (___| (___) || )  \  |/\____) |
(_______)|/          )_(   \_______/(_______)|/    )_)\_______)

ADD - Add money to an account.
ACCOUNT - Modify account information.
CONVERSIONS - show current currency conversion ratios
CREATE - Create a new bank account.
DELETE - Remove account from database. (CANNOT BE UNDONE)
EXIT - Close program.
HELP - Display options.
MAINT - Allow currency conversion data to be entered (or read in).
LIST - Print a list of all current accounts.
TRANSFER - Move funds from one account to another.
WITHDRAW - Remove money from an account.

Enter an option: list
No accounts have been saved yet.

Enter an option: create

Please enter an account number: 1234

Please enter an amount to add: 
$500

Please enter the username for this account.
Username: 
sam

Enter an option: llist

Invalid input...
Enter one of the options and then press enter.
Input should be one word and only contain letters from the English alphabet.
For a list of options type HELP and press enter.

Enter an option: list

{
	Username: SAM
	Account Number: 1234
	Account Balance: 500.00
	Account Currency Type: DOLLAR
}

Enter an option: add

Please enter an account number: 1234

Please enter an amount to add: 
40

Supported currencies...
	DOLLAR or $
	EURO or Є
	YEN ¥

Please enter a currency type: yen

Enter an option: list

{
	Username: SAM
	Account Number: 1234
	Account Balance: 540.00
	Account Currency Type: DOLLAR
}

Enter an option: withdraw

Please enter an account number: 1234

Please enter an amount to withdraw: 
¥ 40

Enter an option: list

{
	Username: SAM
	Account Number: 1234
	Account Balance: 500.00
	Account Currency Type: DOLLAR
}

Enter an option: conversions

{
	Dollar weight: 1.0
	Euro weight: 1.0
	Yen weight: 1.0
}


Enter an option: maint

{
	Dollar weight: 1.0
	Euro weight: 1.0
	Yen weight: 1.0
}


Enter the ratio value of how much a Dollar will be worth.

This value needs to be a number greater than zero.
Enter value here: 4

Enter the ratio value of how much a Euro will be worth.

This value needs to be a number greater than zero.
Enter value here: 2

Enter the ratio value of how much a Yen will be worth.

This value needs to be a number greater than zero.
Enter value here: 1

Enter an option: conversions

{
	Dollar weight: 4.0
	Euro weight: 2.0
	Yen weight: 1.0
}


Enter an option: create

Please enter an account number: 1233

Please enter an amount to add: 
400

Supported currencies...
	DOLLAR or $
	EURO or Є
	YEN ¥

Please enter a currency type: dollar

Please enter the username for this account.
Username: 
dave

Enter an option: list

{
	Username: DAVE
	Account Number: 1233
	Account Balance: 400.00
	Account Currency Type: DOLLAR
}

{
	Username: SAM
	Account Number: 1234
	Account Balance: 500.00
	Account Currency Type: DOLLAR
}

Enter an option: transfer
P
lease enter the account number for the account you with to transfer money from.

Please enter an account number: sam

Invalid account number...
Enter an account number and press enter.
Input should be one number and only contain digits from the Arabic numeral system.

Please enter an account number: 1234

Please enter the account number for the account you with to transfer money to.

Please enter an account number: 1233

Please enter the amount of money you wish to transfer.
Amount: 
50

Supported currencies...
	DOLLAR or $
	EURO or Є
	YEN ¥

Please enter a currency type: euro

Enter an option: list

{
	Username: DAVE
	Account Number: 1233
	Account Balance: 425.00
	Account Currency Type: DOLLAR
}

{
	Username: SAM
	Account Number: 1234
	Account Balance: 475.00
	Account Currency Type: DOLLAR
}

Enter an option: conversions

{
	Dollar weight: 4.0
	Euro weight: 2.0
	Yen weight: 1.0
}


Enter an option: help
 _______  _______ __________________ _______  _        _______ 
(  ___  )(  ____ )\__   __/\__   __/(  ___  )( (    /|(  ____ \
| (   ) || (    )|   ) (      ) (   | (   ) ||  \  ( || (    \/
| |   | || (____)|   | |      | |   | |   | ||   \ | || (_____ 
| |   | ||  _____)   | |      | |   | |   | || (\ \) |(_____  )
| |   | || (         | |      | |   | |   | || | \   |      ) |
| (___) || )         | |   ___) (___| (___) || )  \  |/\____) |
(_______)|/          )_(   \_______/(_______)|/    )_)\_______)

ADD - Add money to an account.
ACCOUNT - Modify account information.
CONVERSIONS - show current currency conversion ratios
CREATE - Create a new bank account.
DELETE - Remove account from database. (CANNOT BE UNDONE)
EXIT - Close program.
HELP - Display options.
MAINT - Allow currency conversion data to be entered (or read in).
LIST - Print a list of all current accounts.
TRANSFER - Move funds from one account to another.
WITHDRAW - Remove money from an account.

Enter an option: dlee   elete

Please enter an account number: 1233

Enter an option: list

{
	Username: SAM
	Account Number: 1234
	Account Balance: 475.00
	Account Currency Type: DOLLAR
}

Enter an option: exit
]0;zac@zac-pc:~/workspace/school/ICS355/bankingApp[01;32m[zac@zac-pc[01;37m bankingApp[01;32m]$[00m exit
exit

Script done on 2017-10-15 21:56:05-1000

# Banking App

##### ICS355 University of Hawaii at Manoa

### Programming assignment 1

    Task: Produce a financial program that tracks the balances of multiple users and supports multiple currencies. This will be done in stages.
    Detail: Produce a command-line driven financial calculator that supports multiple currencies. The program should be capable of adding and subtracting values from a normalUser’s account. The program should handle conversion of the currencies prior to the arithmetic operation. The program should include commands:
    MAINT – Allow currency conversion data to be entered (or read in)
    Create regular expressions to validate all input to include commands, usernames, currency types, and currency values. For currency values, validation should be consistent with the standards used to write numbers in the currency being used. (e.g. $3,150.02, £10.52, etc.). Be sure to document your assumptions for formats in your report. 
    Accepting ambiguous currency values is acceptable as long as you handle the ambiguity reasonably
    You must accept at least three unique currencies (e.g. USD, UK Pound, Euro). You must include functions that allow conversion values to be input for the currencies that you will support.
    You must gracefully reject any attempts to provide invalid data.
    The database of currencies should persist between executions of the program.
    Permissible languages: C/C++, Java, Python, or Other with permission of instructor. No Shell Scripts
    Output:
        Program
        1 page summary including how to install any dependencies, how to run the application, and example runs.

    Due: Oct 15th @ 11:55pm
    
The Banking App is an application that allows a normalUser to create, modify and store bank accounts. It supports three forms of currency, US Dollars, Euros and Japanese Yen.

### Programming assignment 2


    Task:
    Produce a financial program that tracks the balances of multiple users and supports multiple currencies. This will be done in stages.
 
    Details:
    Create the Multiuser portion of your application.
    Users now have to login to your application
    You should have a management account and it is the only one that is able to add and remove users.
    It should attempt to validate the normalUser and handle incorrect authentication properly
    It should also support the transfer of money from one normalUser’s account to another. Validate that the normalUser’s have accounts and the source account has the funds necessary for the transfer to occur.

    Functions:
    ADDUSER - Add username to the database. Set normalUser’s preferred currency to CurrencyType. Also set the normalUser’s password and save the hashed version to a file. Leverage a salt to ensure duplicate passwords area always unique. Your normalUser database should look something like this:
    USERNAME,SALT,Hashed_Password
    DELUSER - Remove normalUser from the database • [ADD|SUB] - Add or remove amount from normalUser’s account. Currency Value can be from any of the supported currency types.
    Login – Your application should support a login phase where passwords are checked based on your database.
    Transfer – Ability to transfer money from one account to the next.

    You must gracefully reject any attempts to provide invalid data.
    The database of currencies and users should persist between executions of the program.
    Permissible languages: C/C++, Java, Python, or Other with permission of instructor. No Shell Scripts
    
    Output:
    Program
    1 page summary including how to install any dependencies, how to run the application, and example runs.
    Github Only (or equivalent)!


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

    $ java -jar target/BankingApp.jar

Once the program is started, different options can be selected.

To get started, first you need to add an administrator user account.

    type ADDUSER and press enter
    give your administrator a username (example: "ADMIN")
        type ADMIN and press enter
    give your administrator a password (example: "ADMINPASS")
        type ADMINPASS and press enter
        type ADMINPASS and press enter again to verify the password
    let the app know that the user will be an administrator
        type TRUE and press enter
        
Next, make sure that the account was added.
    
    type LIST and press enter
    
It should show you that the account is an administrator then show the username:salt:hashedPassword .
Don't forget your password, you will need it to login from now on.

    type LOGIN and press enter
    type ADMIN and press enter
    type ADMINPASS and press enter
    
You should now be logged in as ADMIN.
From here you can start adding normal users and giving these users bank accounts.

For an example, we will create a user called JEFF and give him two bank accounts
Then we will create a user called JOHNNY and make sure that only JEFF can see JEFF's bank accounts

    create user, type ADDUSER and press enter
    for the username, type JEFF and press enter
    for the password, type JEFF and press enter
    confirm the password, type JEFF and press enter
    JEFF will not be an amdinistrator, type FALSE and press enter
    JEFF prefers to use Dollars, type DOLLAR and press enter
    check that JEFF was added, type LIST and press enter
    
    create bank account, type CREATE and press enter
    select an account number, type 1111 and press enter
    give him $400, type $400 and press enter
    this account will be for JEFF, type JEFF and press enter
    check that the bank account was added, type LIST and press enter
    
    create a second account, type CREATE and press enter
    select an account number, type 2222 and press enter
    give him 1000 Yen, type 1000 and press enter, type YEN and press enter
    this account will be for JEFF, type JEFF and press enter
    check that the bank account was added, type LIST and press enter
    
    create user named JOHNNY, type ADDUSER and press enter
    for the username, type JOHNNY and press enter
    for the password, type JOHNNY and press enter
    confirm the password, type JOHNNY and press enter
    JOHNNY will not be an amdinistrator, type FALSE and press enter
    JOHNNY prefers to use Euros, type EURO and press enter
    check that JOHNNY was added, type LIST and press enter
    
    logout of the ADMIN account, type LOGOUT
    
    login with JEFF and see his accounts, type LOGIN and press enter
    for the username, type JEFF and press enter
    for the password, type JEFF and press enter
    look at JEFF's accounts, type list and press enter
    
    logout of JEFF's account, type LOGOUT
    
    login with JOHNNY to make sure we cannot see JEFF's bank accounts, type LOGIN and press enter
    for the username, type JOHNNY and press enter
    for the password, type JOHNNY and press enter
    look at JOHNNY's accounts, type list and press enter
    
    Notice that JEFF's accounts do not show up.
    
    Type EXIT and press enter to exit the program. The next time you start the application, the users and accounts will still be there.

##### Select an option by typing the word and then pressing enter. 

Each option is a single word consisting only of letters from the english alphabet and is not case sensitive. 
A user must login before using any other functions, besides EXIT.
Administrators will be able to use all options. Normal users can only effect their own account, with the exception of transferring money to other accounts.

        
        ADD         - Add money to an account.
        ADDUSER     - Add a new user account. (Aministrator only)
        ACCOUNT     - Modify account information.
        CONVERSIONS - show current currency conversion ratios. (Aministrator only)
        CREATE      - Create a new bank account. (Aministrator only)
        DELETE      - Remove a bank account from database. (CANNOT BE UNDONE) (Aministrator only)
        DELUSER     - Remove a user account from the database. (CANNOT BE UNDONE) (Aministrator only)
        EXIT        - Close program.
        HELP        - Display adminOptions.
        LIST        - Print a list of all current accounts.
        MAINT       - Allow currency conversion data to be entered. (Aministrator only)
        SUBTRACT    - Remove money from an account.
        TRANSFER    - Move funds from one account to another.
        WITHDRAW    - Same function as SUBTRACT.
        
The first time the program is started, there will be no accounts in the database. Use the CREATE option to add new accounts. The currency conversion ratios start at 1:1:1 and they can be changed with the MAINT option.

##### ADD
    First choose the account number for an existing account (to make a new account use CREATE).
    Next choose the amount of money to add and the currency type.
    This can be done one of two ways. Enter both at once like this <currency type character> <amount> example $43.22 or type the amount and then press enter. This will show you the list of acceptable currency types and also allow you to type the word out instead of just using the character. This will be helpful in case you don't have the Euro or Yen symbol on your keyboard.
    
##### ADDUSER
    First choose a username that is not already in use.
    Next choose a password.
    Then choose if the user will be an administrator or a normal user.
    If the user will be a normal user, choose a preffered currency type.
    
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
    
##### DELUSER
    Enter the username of the user that you wish to delte.
    To get a list of users, you can use the LIST option.
    
##### EXIT
    This will save the database and close the program.
    
##### HELP
    This will display a list of the available options.
    
##### LIST
    This will show a list of the current accounts and their associated information.
    
##### MAINT
    This will allow you to change the ratios of value for the available currency types.
    The number for each ratio must greater than zero.
    If you want to see the current ratios, before choosing MAINT you can display them with CONVERSIONS.
    
##### SUBTRACT (same as WITHDRAW)
    First choose the account number for an existing account (to make a new account use CREATE).
    Next choose the amount of money to withdraw and the currency type.
    This can be done one of two ways. Enter both at once like this <currency type character> <amount> example $43.22 or type the amount and then press enter. This will show you the list of acceptable currency types and also allow you to type the word out instead of just using the character. This will be helpful in case you don't have the Euro or Yen symbol on your keyboard.
    
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

Script started on 2017-11-19 20:36:26-1000
]0;zac@zac-pc:~/workspace/school/ICS355/bankingApp[01;32m[zac@zac-pc[01;37m bankingApp[01;32m]$[00m mvn clean compile assembly:single
[[1;34mINFO[m] Scanning for projects...
[[1;34mINFO[m] 
[[1;34mINFO[m] [1m------------------------------------------------------------------------[m
[[1;34mINFO[m] [1mBuilding banking 1.0[m
[[1;34mINFO[m] [1m------------------------------------------------------------------------[m
[[1;34mINFO[m] 
[[1;34mINFO[m] [1m--- [0;32mmaven-clean-plugin:2.5:clean[m [1m(default-clean)[m @ [36mbankingApp[0;1m ---[m
[[1;34mINFO[m] Deleting /home/zac/workspace/school/ICS355/bankingApp/target
[[1;34mINFO[m] 
[[1;34mINFO[m] [1m--- [0;32mmaven-resources-plugin:2.6:resources[m [1m(default-resources)[m @ [36mbankingApp[0;1m ---[m
[[1;34mINFO[m] Using 'UTF-8' encoding to copy filtered resources.
[[1;34mINFO[m] skip non existing resourceDirectory /home/zac/workspace/school/ICS355/bankingApp/src/main/resources
[[1;34mINFO[m] 
[[1;34mINFO[m] [1m--- [0;32mmaven-compiler-plugin:3.1:compile[m [1m(default-compile)[m @ [36mbankingApp[0;1m ---[m
[[1;34mINFO[m] Changes detected - recompiling the module!
[[1;34mINFO[m] Compiling 10 source files to /home/zac/workspace/school/ICS355/bankingApp/target/classes
[[1;34mINFO[m] 
[[1;34mINFO[m] [1m--- [0;32mmaven-assembly-plugin:2.2-beta-5:single[m [1m(default-cli)[m @ [36mbankingApp[0;1m ---[m
[[1;34mINFO[m] META-INF/MANIFEST.MF already added, skipping
[[1;34mINFO[m] META-INF/ already added, skipping
[[1;34mINFO[m] META-INF/MANIFEST.MF already added, skipping
[[1;34mINFO[m] javax/ already added, skipping
[[1;34mINFO[m] META-INF/ already added, skipping
[[1;34mINFO[m] META-INF/MANIFEST.MF already added, skipping
[[1;34mINFO[m] org/ already added, skipping
[[1;34mINFO[m] META-INF/ already added, skipping
[[1;34mINFO[m] META-INF/MANIFEST.MF already added, skipping
[[1;34mINFO[m] org/ already added, skipping
[[1;34mINFO[m] Building jar: /home/zac/workspace/school/ICS355/bankingApp/target/BankingApp.jar
[[1;34mINFO[m] META-INF/MANIFEST.MF already added, skipping
[[1;34mINFO[m] META-INF/ already added, skipping
[[1;34mINFO[m] META-INF/MANIFEST.MF already added, skipping
[[1;34mINFO[m] javax/ already added, skipping
[[1;34mINFO[m] META-INF/ already added, skipping
[[1;34mINFO[m] META-INF/MANIFEST.MF already added, skipping
[[1;34mINFO[m] org/ already added, skipping
[[1;34mINFO[m] META-INF/ already added, skipping
[[1;34mINFO[m] META-INF/MANIFEST.MF already added, skipping
[[1;34mINFO[m] org/ already added, skipping
[[1;33mWARNING[m] Configuration options: 'appendAssemblyId' is set to false, and 'classifier' is missing.
Instead of attaching the assembly file: /home/zac/workspace/school/ICS355/bankingApp/target/BankingApp.jar, it will become the file for main project artifact.
NOTE: If multiple descriptors or descriptor-formats are provided for this project, the value of this file will be non-deterministic!
[[1;33mWARNING[m] Replacing pre-existing project main-artifact file: /home/zac/workspace/school/ICS355/bankingApp/target/classes
with assembly file: /home/zac/workspace/school/ICS355/bankingApp/target/BankingApp.jar
[[1;34mINFO[m] [1m------------------------------------------------------------------------[m
[[1;34mINFO[m] [1;32mBUILD SUCCESS[m
[[1;34mINFO[m] [1m------------------------------------------------------------------------[m
[[1;34mINFO[m] Total time: 2.991 s
[[1;34mINFO[m] Finished at: 2017-11-19T20:36:56-10:00
[[1;34mINFO[m] Final Memory: 17M/243M
[[1;34mINFO[m] [1m------------------------------------------------------------------------[m
]0;zac@zac-pc:~/workspace/school/ICS355/bankingApp[01;32m[zac@zac-pc[01;37m bankingApp[01;32m]$[00m ls
Banking.iml  [0m[01;34mdb[0m  [01;34mlog[0m  pom.xml  README.md  [01;34msrc[0m  [01;34mtarget[0m  [00;32mtestRun.txt[0m
]0;zac@zac-pc:~/workspace/school/ICS355/bankingApp[01;32m[zac@zac-pc[01;37m bankingApp[01;32m]$[00m ls target/
[0m[01;34marchive-tmp[0m  [01;31mBankingApp.jar[0m  [01;34mclasses[0m  [01;34mgenerated-sources[0m  [01;34mmaven-status[0m
]0;zac@zac-pc:~/workspace/school/ICS355/bankingApp[01;32m[zac@zac-pc[01;37m bankingApp[01;32m]$[00m java -jar B[KtestRun.txt [K[K[K[K[K[K[K[K[K[K[K[Ktarget/BankingApp.jar 
No users have been saved yet.
 ______   _______  _        _       _________ _        _______        _______  _______  _______
(  ___ \ (  ___  )( (    /|| \    /\\__   __/( (    /|(  ____ \      (  ___  )(  ____ )(  ____ )
| (   ) )| (   ) ||  \  ( ||  \  / /   ) (   |  \  ( || (    \/      | (   ) || (    )|| (    )|
| (__/ / | (___) ||   \ | ||  (_/ /    | |   |   \ | || |            | (___) || (____)|| (____)|
|  __ (  |  ___  || (\ \) ||   _ (     | |   | (\ \) || | ____       |  ___  ||  _____)|  _____)
| (  \ \ | (   ) || | \   ||  ( \ \    | |   | | \   || | \_  )      | (   ) || (      | (
| )___) )| )   ( || )  \  ||  /  \ \___) (___| )  \  || (___) |      | )   ( || )      | )      
(______/ |/     \||/    )_)|_/    \/\_______/|/    )_)(_______)      |/     \||/       |/       

Enter HELP for a list of adminOptions.

Enter an option: list
No users have been saved yet.
No accounts have been saved yet.

Enter an option: adduser

Please enter the username for this account.
Username: 
admin

Please enter the password for this account.
Password : 
adminpass

Please confirm the password for this account.
Password : 
adminpass

Will this user be an administrator?

Enter either TRUE or FALSE.
true

Enter an option: list
Administrator - ADMIN:21468:47660861af8e9b0a91769142121954d08c78978f4e295e89b3ed1e0a60cbe7a0

No accounts have been saved yet.

Enter an option: login

Please enter the username for this account.
Username: 
admin

Please enter the password for this account.
Password : 
adminpass

Enter an option: list
Administrator - ADMIN:21468:47660861af8e9b0a91769142121954d08c78978f4e295e89b3ed1e0a60cbe7a0

No accounts have been saved yet.

Enter an option: help
 _______  _______ __________________ _______  _        _______ 
(  ___  )(  ____ )\__   __/\__   __/(  ___  )( (    /|(  ____ \
| (   ) || (    )|   ) (      ) (   | (   ) ||  \  ( || (    \/
| |   | || (____)|   | |      | |   | |   | ||   \ | || (_____ 
| |   | ||  _____)   | |      | |   | |   | || (\ \) |(_____  )
| |   | || (         | |      | |   | |   | || | \   |      ) |
| (___) || )         | |   ___) (___| (___) || )  \  |/\____) |
(_______)|/          )_(   \_______/(_______)|/    )_)\_______)

ADD         - Add money to an account.
ADDUSER     - Add a new user account.
ACCOUNT     - Modify account information.
CONVERSIONS - show current currency conversion ratios
CREATE      - Create a new bank account.
DELETE      - Remove a bank account from database. (CANNOT BE UNDONE)
DELUSER     - Remove a user account from the database. (CANNOT BE UNDONE)
EXIT        - Close program.
HELP        - Display adminOptions.
LIST        - Print a list of all current accounts.
MAINT       - Allow currency conversion data to be entered.
SUBTRACT    - Remove money from an account.
TRANSFER    - Move funds from one account to another.
WITHDRAW    - Same function as SUBTRACT

Enter an option: adduser

Please enter the username for this account.
Username: 
jeff

Please enter the password for this account.
Password : 
jeff

Please confirm the password for this account.
Password : 
jeff

Will this user be an administrator?

Enter either TRUE or FALSE.
false

Supported currencies...
	DOLLAR or $
	EURO or Є
	YEN ¥

Please enter a currency type: dollar

Enter an option: list
Normal User   - JEFF:2757:15700795a1bddec6e4f12506c74f191a58be49177a36a9de2255fe1e74494b83
Administrator - ADMIN:21468:47660861af8e9b0a91769142121954d08c78978f4e295e89b3ed1e0a60cbe7a0

No accounts have been saved yet.

Enter an option: adduser

Please enter the username for this account.
Username: 
johnny

Please enter the password for this account.
Password : 
johnny

Please confirm the password for this account.
Password : 
johm nny

Will this user be an administrator?

Enter either TRUE or FALSE.
false

Supported currencies...
	DOLLAR or $
	EURO or Є
	YEN ¥

Please enter a currency type: yen

Enter an option: list
Normal User   - JEFF:2757:15700795a1bddec6e4f12506c74f191a58be49177a36a9de2255fe1e74494b83
Normal User   - JOHNNY:9633:d139a2a731d140725c30a2d71dbf6ee82f600fe2a8ead3066f23d0b8eedd6e8e
Administrator - ADMIN:21468:47660861af8e9b0a91769142121954d08c78978f4e295e89b3ed1e0a60cbe7a0

No accounts have been saved yet.

Enter an option: help
 _______  _______ __________________ _______  _        _______ 
(  ___  )(  ____ )\__   __/\__   __/(  ___  )( (    /|(  ____ \
| (   ) || (    )|   ) (      ) (   | (   ) ||  \  ( || (    \/
| |   | || (____)|   | |      | |   | |   | ||   \ | || (_____ 
| |   | ||  _____)   | |      | |   | |   | || (\ \) |(_____  )
| |   | || (         | |      | |   | |   | || | \   |      ) |
| (___) || )         | |   ___) (___| (___) || )  \  |/\____) |
(_______)|/          )_(   \_______/(_______)|/    )_)\_______)

ADD         - Add money to an account.
ADDUSER     - Add a new user account.
ACCOUNT     - Modify account information.
CONVERSIONS - show current currency conversion ratios
CREATE      - Create a new bank account.
DELETE      - Remove a bank account from database. (CANNOT BE UNDONE)
DELUSER     - Remove a user account from the database. (CANNOT BE UNDONE)
EXIT        - Close program.
HELP        - Display adminOptions.
LIST        - Print a list of all current accounts.
MAINT       - Allow currency conversion data to be entered.
SUBTRACT    - Remove money from an account.
TRANSFER    - Move funds from one account to another.
WITHDRAW    - Same function as SUBTRACT

Enter an option: create

Please enter an account number: 1111

Please enter an amount to add: 
5 $500

Please enter the username for this account.
Username: 
jeff

Enter an option: list
Normal User   - JEFF:2757:15700795a1bddec6e4f12506c74f191a58be49177a36a9de2255fe1e74494b83
Normal User   - JOHNNY:9633:d139a2a731d140725c30a2d71dbf6ee82f600fe2a8ead3066f23d0b8eedd6e8e
Administrator - ADMIN:21468:47660861af8e9b0a91769142121954d08c78978f4e295e89b3ed1e0a60cbe7a0


{
	Username: JEFF
	Account Number: 1111
	Account Balance: 500.00
	Account Currency Type: DOLLAR
}

Enter an option: create

Please enter an account number: 2222

Please enter an amount to add: 
6000

Supported currencies...
	DOLLAR or $
	EURO or Є
	YEN ¥

Please enter a currency type: yen

Please enter the username for this account.
Username: 
jeff

Enter an option: list
Normal User   - JEFF:2757:15700795a1bddec6e4f12506c74f191a58be49177a36a9de2255fe1e74494b83
Normal User   - JOHNNY:9633:d139a2a731d140725c30a2d71dbf6ee82f600fe2a8ead3066f23d0b8eedd6e8e
Administrator - ADMIN:21468:47660861af8e9b0a91769142121954d08c78978f4e295e89b3ed1e0a60cbe7a0


{
	Username: JEFF
	Account Number: 1111
	Account Balance: 500.00
	Account Currency Type: DOLLAR
}

{
	Username: JEFF
	Account Number: 2222
	Account Balance: 6000.00
	Account Currency Type: YEN
}

Enter an option: logout

You have been logged out.

Type EXIT to close the program or sign in to continue.


Enter an option: login

Please enter the username for this account.
Username: 
jeff

Please enter the password for this account.
Password : 
jeff

Enter an option: list

{
	Username: JEFF
	Account Number: 1111
	Account Balance: 500.00
	Account Currency Type: DOLLAR
}

{
	Username: JEFF
	Account Number: 2222
	Account Balance: 6000.00
	Account Currency Type: YEN
}

Enter an option: logout

You have been logged out.

Type EXIT to close the program or sign in to continue.


Enter an option: login

Please enter the username for this account.
Username: 
admin

Please enter the password for this account.
Password : 
amdinpass

Incorrect username or password.
Please try again.

Enter an option: list

You must log in to use this function!
To log in, type LOGIN and press enter.
Once logged in, you can type HELP and press enter to display a list of commands.

You are not an administrator.

Enter an option: login

Please enter the username for this account.
Username: 
admin

Please enter the password for this account.
Password : 
adminpass

Enter an option: list
Normal User   - JEFF:2757:15700795a1bddec6e4f12506c74f191a58be49177a36a9de2255fe1e74494b83
Normal User   - JOHNNY:9633:d139a2a731d140725c30a2d71dbf6ee82f600fe2a8ead3066f23d0b8eedd6e8e
Administrator - ADMIN:21468:47660861af8e9b0a91769142121954d08c78978f4e295e89b3ed1e0a60cbe7a0


{
	Username: JEFF
	Account Number: 1111
	Account Balance: 500.00
	Account Currency Type: DOLLAR
}

{
	Username: JEFF
	Account Number: 2222
	Account Balance: 6000.00
	Account Currency Type: YEN
}

Enter an option: create

Please enter an account number: 3333

Please enter an amount to add: 
500

Supported currencies...
	DOLLAR or $
	EURO or Є
	YEN ¥

Please enter a currency type: euro

Please enter the username for this account.
Username: 
johnny

Enter an option: list
Normal User   - JEFF:2757:15700795a1bddec6e4f12506c74f191a58be49177a36a9de2255fe1e74494b83
Normal User   - JOHNNY:9633:d139a2a731d140725c30a2d71dbf6ee82f600fe2a8ead3066f23d0b8eedd6e8e
Administrator - ADMIN:21468:47660861af8e9b0a91769142121954d08c78978f4e295e89b3ed1e0a60cbe7a0


{
	Username: JEFF
	Account Number: 1111
	Account Balance: 500.00
	Account Currency Type: DOLLAR
}

{
	Username: JEFF
	Account Number: 2222
	Account Balance: 6000.00
	Account Currency Type: YEN
}

{
	Username: JOHNNY
	Account Number: 3333
	Account Balance: 500.00
	Account Currency Type: EURO
}

Enter an option: logi 0ut   out

You have been logged out.

Type EXIT to close the program or sign in to continue.


Enter an option: login

Please enter the username for this account.
Username: 
jeff

Please enter the password for this account.
Password : 
jeff

Enter an option: list

{
	Username: JEFF
	Account Number: 1111
	Account Balance: 500.00
	Account Currency Type: DOLLAR
}

{
	Username: JEFF
	Account Number: 2222
	Account Balance: 6000.00
	Account Currency Type: YEN
}

Enter an option: logout

You have been logged out.

Type EXIT to close the program or sign in to continue.


Enter an option: login

Please enter the username for this account.
Username: 
johnny

Please enter the password for this account.
Password : 
johnny

Enter an option: list

{
	Username: JOHNNY
	Account Number: 3333
	Account Balance: 500.00
	Account Currency Type: EURO
}

Enter an option: logout

You have been logged out.

Type EXIT to close the program or sign in to continue.


Enter an option: login

Please enter the username for this account.
Username: 
admin

Please enter the password for this account.
Password : 
admi  minpass

Enter an option: list
Normal User   - JEFF:2757:15700795a1bddec6e4f12506c74f191a58be49177a36a9de2255fe1e74494b83
Normal User   - JOHNNY:9633:d139a2a731d140725c30a2d71dbf6ee82f600fe2a8ead3066f23d0b8eedd6e8e
Administrator - ADMIN:21468:47660861af8e9b0a91769142121954d08c78978f4e295e89b3ed1e0a60cbe7a0


{
	Username: JEFF
	Account Number: 1111
	Account Balance: 500.00
	Account Currency Type: DOLLAR
}

{
	Username: JEFF
	Account Number: 2222
	Account Balance: 6000.00
	Account Currency Type: YEN
}

{
	Username: JOHNNY
	Account Number: 3333
	Account Balance: 500.00
	Account Currency Type: EURO
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

ADD         - Add money to an account.
ADDUSER     - Add a new user account.
ACCOUNT     - Modify account information.
CONVERSIONS - show current currency conversion ratios
CREATE      - Create a new bank account.
DELETE      - Remove a bank account from database. (CANNOT BE UNDONE)
DELUSER     - Remove a user account from the database. (CANNOT BE UNDONE)
EXIT        - Close program.
HELP        - Display adminOptions.
LIST        - Print a list of all current accounts.
MAINT       - Allow currency conversion data to be entered.
SUBTRACT    - Remove money from an account.
TRANSFER    - Move funds from one account to another.
WITHDRAW    - Same function as SUBTRACT

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


Enter an option: logout

You have been logged out.

Type EXIT to close the program or sign in to continue.


Enter an option: login

Please enter the username for this account.
Username: 
jeff

Please enter the password for this account.
Password : 
feff

Incorrect username or password.
Please try again.

Enter an option: lo  jeff

Invalid input...
Enter one of the adminOptions and then press enter.
Input should be one word and only contain letters from the English alphabet.
For a list of adminOptions type HELP and press enter.

Enter an option: list

You must log in to use this function!
To log in, type LOGIN and press enter.
Once logged in, you can type HELP and press enter to display a list of commands.

You are not an administrator.

Enter an option: login

Please enter the username for this account.
Username: 
jeff

Please enter the password for this account.
Password : 
jeff

Enter an option: list

{
	Username: JEFF
	Account Number: 1111
	Account Balance: 500.00
	Account Currency Type: DOLLAR
}

{
	Username: JEFF
	Account Number: 2222
	Account Balance: 6000.00
	Account Currency Type: YEN
}

Enter an option: add

Please enter an account number: 1111

Please enter an amount to add: 
50

Supported currencies...
	DOLLAR or $
	EURO or Є
	YEN ¥

Please enter a currency type: euro

Enter an option: list

{
	Username: JEFF
	Account Number: 1111
	Account Balance: 525.00
	Account Currency Type: DOLLAR
}

{
	Username: JEFF
	Account Number: 2222
	Account Balance: 6000.00
	Account Currency Type: YEN
}

Enter an option: subtract

Please enter an account number: 2222

Please enter an amount to withdraw: 
50

Supported currencies...
	DOLLAR or $
	EURO or Є
	YEN ¥

Please enter a currency type: euro

Enter an option: list

{
	Username: JEFF
	Account Number: 1111
	Account Balance: 525.00
	Account Currency Type: DOLLAR
}

{
	Username: JEFF
	Account Number: 2222
	Account Balance: 5900.00
	Account Currency Type: YEN
}

Enter an option: transfer

Please enter the account number for the account you wish to transfer money from.

Please enter an account number: 1111

Please enter the account number for the account you wish to transfer money to.

Please enter an account number: 2222

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
	Username: JEFF
	Account Number: 1111
	Account Balance: 500.00
	Account Currency Type: DOLLAR
}

{
	Username: JEFF
	Account Number: 2222
	Account Balance: 6000.00
	Account Currency Type: YEN
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

ADD      - Add money to an account.
EXIT     - Close program.
HELP     - Display options.
LIST     - Print a list of all current accounts.
SUBTRACT - Remove money from an account.
TRANSFER - Move funds from one account to another.
WITHDRAW - Remove money from an account.(Same function as SUBTRACT)

Enter an option: logout

You have been logged out.

Type EXIT to close the program or sign in to continue.


Enter an option: login

Please enter the username for this account.
Username: 
admin

Please enter the password for this account.
Password : 
adminpass

Enter an option: list
Normal User   - JEFF:2757:15700795a1bddec6e4f12506c74f191a58be49177a36a9de2255fe1e74494b83
Normal User   - JOHNNY:9633:d139a2a731d140725c30a2d71dbf6ee82f600fe2a8ead3066f23d0b8eedd6e8e
Administrator - ADMIN:21468:47660861af8e9b0a91769142121954d08c78978f4e295e89b3ed1e0a60cbe7a0


{
	Username: JEFF
	Account Number: 1111
	Account Balance: 500.00
	Account Currency Type: DOLLAR
}

{
	Username: JEFF
	Account Number: 2222
	Account Balance: 6000.00
	Account Currency Type: YEN
}

{
	Username: JOHNNY
	Account Number: 3333
	Account Balance: 500.00
	Account Currency Type: EURO
}

Enter an option: transfer

Please enter the account number for the account you wish to transfer money from.

Please enter an account number: 3333

Please enter the account number for the account you wish to transfer money to.

Please enter an account number: 1111

Please enter the amount of money you wish to transfer.
Amount: 
1

Supported currencies...
	DOLLAR or $
	EURO or Є
	YEN ¥

Please enter a currency type: yen

Enter an option: list
Normal User   - JEFF:2757:15700795a1bddec6e4f12506c74f191a58be49177a36a9de2255fe1e74494b83
Normal User   - JOHNNY:9633:d139a2a731d140725c30a2d71dbf6ee82f600fe2a8ead3066f23d0b8eedd6e8e
Administrator - ADMIN:21468:47660861af8e9b0a91769142121954d08c78978f4e295e89b3ed1e0a60cbe7a0


{
	Username: JEFF
	Account Number: 1111
	Account Balance: 500.25
	Account Currency Type: DOLLAR
}

{
	Username: JEFF
	Account Number: 2222
	Account Balance: 6000.00
	Account Currency Type: YEN
}

{
	Username: JOHNNY
	Account Number: 3333
	Account Balance: 499.50
	Account Currency Type: EURO
}

Enter an option: logout

You have been logged out.

Type EXIT to close the program or sign in to continue.


Enter an option: login

Please enter the username for this account.
Username: 
johnny

Please enter the password for this account.
Password : 
johnny

Enter an option: list

{
	Username: JOHNNY
	Account Number: 3333
	Account Balance: 499.50
	Account Currency Type: EURO
}

Enter an option: transfer

Please enter the account number for the account you wish to transfer money from.

Please enter an account number: 3333

Please enter the account number for the account you wish to transfer money to.

Please enter an account number: 1111

Please enter the amount of money you wish to transfer.
Amount: 
1

Supported currencies...
	DOLLAR or $
	EURO or Є
	YEN ¥

Please enter a currency type: euro

Enter an option: list

{
	Username: JOHNNY
	Account Number: 3333
	Account Balance: 498.50
	Account Currency Type: EURO
}

Enter an option: transfer

Please enter the account number for the account you wish to transfer money from.

Please enter an account number: 1111

Invalid account number...
Enter an account number and press enter.
Input should be one number and only contain digits from the Arabic numeral system.

Enter an option: list

{
	Username: JOHNNY
	Account Number: 3333
	Account Balance: 498.50
	Account Currency Type: EURO
}

Enter an option: e logout

You have been logged out.

Type EXIT to close the program or sign in to continue.


Enter an option: help

You must log in to use this function!
To log in, type LOGIN and press enter.
Once logged in, you can type HELP and press enter to display a list of commands.

Enter an option: login

Please enter the username for this account.
Username: 
admin

Please enter the password for this account.
Password : 
am dminpass

Enter an option: list
Normal User   - JEFF:2757:15700795a1bddec6e4f12506c74f191a58be49177a36a9de2255fe1e74494b83
Normal User   - JOHNNY:9633:d139a2a731d140725c30a2d71dbf6ee82f600fe2a8ead3066f23d0b8eedd6e8e
Administrator - ADMIN:21468:47660861af8e9b0a91769142121954d08c78978f4e295e89b3ed1e0a60cbe7a0


{
	Username: JEFF
	Account Number: 1111
	Account Balance: 500.75
	Account Currency Type: DOLLAR
}

{
	Username: JEFF
	Account Number: 2222
	Account Balance: 6000.00
	Account Currency Type: YEN
}

{
	Username: JOHNNY
	Account Number: 3333
	Account Balance: 498.50
	Account Currency Type: EURO
}

Enter an option: hlep

Invalid input...
Enter one of the adminOptions and then press enter.
Input should be one word and only contain letters from the English alphabet.
For a list of adminOptions type HELP and press enter.

Enter an option: help
 _______  _______ __________________ _______  _        _______ 
(  ___  )(  ____ )\__   __/\__   __/(  ___  )( (    /|(  ____ \
| (   ) || (    )|   ) (      ) (   | (   ) ||  \  ( || (    \/
| |   | || (____)|   | |      | |   | |   | ||   \ | || (_____ 
| |   | ||  _____)   | |      | |   | |   | || (\ \) |(_____  )
| |   | || (         | |      | |   | |   | || | \   |      ) |
| (___) || )         | |   ___) (___| (___) || )  \  |/\____) |
(_______)|/          )_(   \_______/(_______)|/    )_)\_______)

ADD         - Add money to an account.
ADDUSER     - Add a new user account.
ACCOUNT     - Modify account information.
CONVERSIONS - show current currency conversion ratios
CREATE      - Create a new bank account.
DELETE      - Remove a bank account from database. (CANNOT BE UNDONE)
DELUSER     - Remove a user account from the database. (CANNOT BE UNDONE)
EXIT        - Close program.
HELP        - Display adminOptions.
LIST        - Print a list of all current accounts.
MAINT       - Allow currency conversion data to be entered.
SUBTRACT    - Remove money from an account.
TRANSFER    - Move funds from one account to another.
WITHDRAW    - Same function as SUBTRACT

Enter an option: delete

Please enter an account number: 1111

Enter an option: delete

Please enter an account number: 2222

Enter an option: delete

Please enter an account number: 3333

Enter an option: liswt

Invalid input...
Enter one of the adminOptions and then press enter.
Input should be one word and only contain letters from the English alphabet.
For a list of adminOptions type HELP and press enter.

Enter an option: list
Normal User   - JEFF:2757:15700795a1bddec6e4f12506c74f191a58be49177a36a9de2255fe1e74494b83
Normal User   - JOHNNY:9633:d139a2a731d140725c30a2d71dbf6ee82f600fe2a8ead3066f23d0b8eedd6e8e
Administrator - ADMIN:21468:47660861af8e9b0a91769142121954d08c78978f4e295e89b3ed1e0a60cbe7a0


Enter an option: deluser

Please enter the username for this account.
Username: 
jeff

Enter an option: deluser

Please enter the username for this account.
Username: 
johnny

Enter an option: list
Administrator - ADMIN:21468:47660861af8e9b0a91769142121954d08c78978f4e295e89b3ed1e0a60cbe7a0


Enter an option: deluser

Please enter the username for this account.
Username: 
admin

Enter an option: list


Enter an option: logout

You have been logged out.

Type EXIT to close the program or sign in to continue.


Enter an option: list

You must log in to use this function!
To log in, type LOGIN and press enter.
Once logged in, you can type HELP and press enter to display a list of commands.

You are not an administrator.

Enter an option: lg ogin

Please enter the username for this account.
Username: 
admi

Please enter the password for this account.
Password : 
aasdf

Incorrect username or password.
Please try again.

Enter an option: login

Please enter the username for this account.
Username: 
admin

Please enter the password for this account.
Password : 
adminpass

Incorrect username or password.
Please try again.

Enter an option: exit
]0;zac@zac-pc:~/workspace/school/ICS355/bankingApp[01;32m[zac@zac-pc[01;37m bankingApp[01;32m]$[00m exit
exit

Script done on 2017-11-19 21:12:07-1000


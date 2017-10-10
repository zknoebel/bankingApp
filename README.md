# Banking App

### Programming assignment 1

##### ICS355 University of Hawaii at Manoa

    Task: Produce a financial program that tracks the balances of multiple users and supports multiple currencies. This will be done in stages.
    Detail: Produce a command-line driven financial calculator that supports multiple currencies. The program should be capable of adding and subtracting values from a user’s account. The program should handle conversion of the currencies prior to the arithmetic operation. The program should include commands:
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
    
The Banking App is an application that allows a user to create, modify and store bank accounts. It supports three forms of currency, US Dollars, Euros and Japanese Yen.

Start the program with ./bankingApp

Once the program is started, different options can be selected.

##### Select an option by typing the word and then pressing enter. 

Each option is a single word consisting only of letters from the english alphabet and is not case sensitive. 


        ADD - Add money to an account.
        ACCOUNT - Modify account information.
        CREATE - Create a new bank account.
        DELETE - Remove account from database. (CANNOT BE UNDONE)
        EXIT - Close program.
        HELP - Display options.
        MAINT - Allow currency conversion data to be entered (or read in).
        LIST - Print a list of all current accounts.
        TRANSFER - Move funds from one account to another.
        WITHDRAW - Remove money from an account.
        
        
The first time the program is started, there will be no accounts in the database. Use the CREATE option to add new accounts. The currency conversion ratios start at 1:1:1 and they can be changed with the MAINT option.

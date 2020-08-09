# CSX42: Assignment 1
## Name: Shrijeet Rupnar
## B-00808280

-------------------------------------------------------------------------

Due Date:  June 10, 2020 
Submitted date : June 08, 2020 
Author(s): Shrijeet Rupnar 
e-mail(s): srupnar1@binghamton.edu

PERCENT COMPLETE: I believe I have completed 100% of this project.

BUGS: No bugs.

Following are the commands and the instructions to run ANT on your project.

Note: build.xml is present in wordPlay/src folder.

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in wordPlay/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile wordPlay/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile wordPlay/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile wordPlay/src/build.xml run -Dinput="input.txt" -Doutput="output.txt" -Dmetrics="metrics.txt"

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description:
Java program to reverse the words from given input file based on there index. also caluculate the metrics as per the given  constraint.
---------------------------------------------------------------------------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in term of Big O complexity (time and/or space):

ArrayList can hold duplicate String as input file may contains duplicate.
ArrayList has dynamic size.
ArrayList maintain insertion order and thats why I decided to go with ArrayList.

Big O(n) Time complexity:

As I am reading words from Input file one at a time : complexity O(n) ..(assuming n words are there)
Looping each word only once to rotate : Complexity O(n) ...(assuming n words are there)
-------------------------------------------------------------------------------------------------------------------------------

### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: [06/08/2020]
------------------------------------------------------------------------
Citations:
------------------------------------------------------------------------
I have referred below mentioned web site.
https://stackoverflow.com/questions/53021750/count-words-in-case-read-wont-read-the-file
https://stackoverflow.com/questions/1653425/a-za-z-a-za-z0-9-regular-expression

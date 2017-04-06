changelog in existing classes: 

 * added performance code in Staff, which I had forgotten
 * changed some private static variables to public constants (UGRAD_RATE, GRAD_RATE, BONUS in staff, etc)
 * made staff salary double instead of int
 * renamed TestDriver to Driver

 
 
Documentation:

Person      -> Parent of all employee/student classes

FullFac     -> Full-time faculty, child of Person

PartFac     -> Part-time faculty, child of Person

Student     -> Student, child of Person

Staff       -> Staff, child of Person

^^^ All of the above handle their own formatting of parameters (so making sure everything is entered correctly)
To make a new instance of them, either feed them a string in this format: (id, fname, lname, city, (etc))
or, to get user input, use Student.askForStudent(); (or whichever object you want)

FileManager ->  Class for managing writing to files and reading from files.

    readLine(String file, int line): returns the line asked. indexing starts at 0 (so first like is 0, second line 1, etc.)

    readAll(String file, int line): returns all lines in the file in a String[] array


MyLinkedList->  Generic class for linked list. The data type isn't verified, so you have to make sure all nodes
are fed the same type of data on your own. since it's generic, the type has to be an object. (java automatically
wraps ints and other numbers in an object if fed to a parameter demanding an object)

Note: Each linked list is of a single type, so you cannot store one student in a node, and a staff in the next node.
Use the parent class Person if you need to store instances of different classes.

    MyLinkedList(): default constructor, makes an empty linked list.

    removeAt(int index): removes at index. Index starts at 0, ends at (size - 1).
    
    addAt(T data, int index): adds at index. Index starts at 0, ends at (size - 1)
    

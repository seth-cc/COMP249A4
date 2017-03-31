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


TODO: MyLinkedList


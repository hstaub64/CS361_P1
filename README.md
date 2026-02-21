****************
* Project 1
* Class CS361 002
* Date 2/20/26
* Haylee Staub
****************
- OVERVIEW:
    This program represents a DFA using various methods to create states, add 
    transitions, and represent different parts of the DFA's 5-tuple.

- INCLUDED FILES:
    * DFA.java - source file
    * DFAState.java - source file
    * README - this file

COMPILING AND RUNNING:
    To compile the project and run the tests, first navigate to the directory 
    containing the source files. Then, run the following commands:
        $ javac -cp .:/usr/share/java/junit.jar ./test/dfa/DFATest.java
        $ java -cp .:/usr/share/java/junit.jar:/usr/share/java/hamcrest/hamcrest.jar 
        org.junit.runner.JUnitCore test.dfa.DFATest
    
    Console output will give the results after the program finishes.

PROGRAM DESIGN AND IMPORTANT CONCEPTS:
    The DFA class is responsible for managing most of the elements
    in the DFA, including the alphabet, the list of states,
    the start state, and the final state. It is also responsible
    for assigning interactions between these elements, such as
    adding new states or transitions between other elements,
    swapping transitions in the DFA, and checking acceptance of 
    a given string. DFAState is the class representing a state in
    the DFA and it is responsible for managing the transitions between
    states. I chose to store transitions in the DFAState class directly
    to make it easier to understand how the mapping for transitions work.
    It made more sense to me that a given state has a key (a character) that 
    corresponds to another state than to try to create a map of maps for state
    transitions. 

TESTING:
    The current code passes all of the given tests. Most of the methods
    have a fall-back to return output to signal that something has
    gone wrong, though ideally there would be some sort of try-catch
    to prevent bad input from sending out null values. Currently, 
    there are no bugs (that I know of) in the code.

DISCUSSION:
    The biggest hurdle for me was just figuring out how to make each of the 
    pieces fit together. Ultimately, the most helpful method for that was
    to draw it out. I sketched out how the states and transitions connect,
    how I could store them, and also how methods should function. I also
    found it helpful to write out some comments, line by line, for each
    step of the method I was working on. When I had issues near the end, 
    I remembered I could use the debugger for the tests to watch what output 
    was being saved to the test's DFA and that help me fix any remaining issues 
    with the tests.


SOURCES:
    * Talked to Amy over discord about copying transitions for the swap method
    and LinkedHashSets
    * Referenced for iterating for deep copy: https://www.geeksforgeeks.org/java/deep-copy-in-java/
--------------------------------------------------------------------------

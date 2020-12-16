# RPN Calculator

Some of the best calculators in the world have an _RPN_ (reverse polish notation) mode.
This is a a command-line implementation of a RPN calculator. 

## Requirements
- The calculator has a stack that can contain real numbers.
- The calculator waits for user input and expects to receive strings containing whitespace separated lists of numbers and operators.
- Numbers are pushed on to the stack. Operators operate on numbers that are on the stack.
- Available operators are **+, -, \*, /, sqrt, undo, clear**.
- Operators pop their parameters off the stack, and push their results back onto the stack.
- The **‘clear’** operator removes all items from the stack.
- The **‘undo’** operator undoes the previous operation. **“undo undo”** will undo the previous two operations.
- **sqrt** performs a square root on the top item from the stack.
- The **‘+’, ‘-’, ‘\*’, ‘/’** operators perform addition, subtraction, multiplication and division respectively on the top two items from the stack.
- After processing an input string, the calculator displays the current contents of the stack as a space-separated list.
- Numbers should be stored on the stack to at least 15 decimal places of precision, but displayed to 10 decimal places (or less if it causes no loss of precision).
- All numbers should be formatted as plain decimal strings (ie. no engineering formatting).
- If an operator cannot find a sufficient number of parameters on the stack, a warning is displayed: _operator \<operator> (position: \<pos>): insufficient parameters_
- After displaying the warning, all further processing of the string terminates and the current state of the stack is displayed.

## Examples
### Example 1
```
5 2
stack: 5 2
```
### Example 2
```
2 sqrt
stack: 1.4142135623

clear 9 sqrt
stack: 3
```
### Example 3
```
5 2 -
stack: 3

3 -
stack: 0

clear
stack:
```
### Example 4
```
5 4 3 2
stack: 5 4 3 2

undo undo *
stack: 20

5 *
stack: 100

undo
stack: 20 5
```
### Example 5
```
7 12 2 /
stack: 7 6

*
stack: 42

4 /
stack: 10.5
```
### Example 6
```
1 2 3 4 5
stack: 1 2 3 4 5

*
stack: 1 2 3 20

clear 3 4 -
stack: - 1
```
### Example 7
```
1 2 3 4 5
stack: 1 2 3 4 5

* * * *
stack: 120
```
### Example 8
```
1 2 3 * 5 + * * 6 5
operator * (position: 15): insucient parameters
stack: 11
(the 6 and 5 were not pushed on to the stack due to the previous error)
```
## Prerequisites

Java JDK 8 and Maven are required to run the project.

## Compiling

As in any Maven project, it may be required to run:

```bash
mvn clean install
```

## Running

To run the command-line application:

```bash
java -jar target\rpn-calculator-1.0-SNAPSHOT.jar
```

To see the history in the calculator output besides the stack, add program argument `-h`

```bash
java -jar target\rpn-calculator-1.0-SNAPSHOT.jar -h
```

## Shutdown

Use the keyword `exit` to stop the application

## Author

* **Sebastian D'Agostino**
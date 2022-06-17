# JavaScript

### JavaScript can "display" data in different ways:
Writing into an HTML element, using innerHTML.
```
<script>
document.getElementById("demo").innerHTML = 5 + 6;
</script>
```
Writing into the HTML output using document.write().
```
<button type="button" onclick="document.write(5 + 6)">Try it</button>
<script>
document.write(5 + 6);
</script>
```

Writing into an alert box, using window.alert().
```
<script>
window.alert(5 + 6);
</script>
```
```
<script>
alert(5 + 6);
</script>
```
Writing into the browser console, using console.log().
```
<script>
console.log(5 + 6);
</script>
```
window.print() method in the browser to print the content of the currwindow.
```
<button onclick="window.print()">Print this page</button>
```
---
### JavaScript Values
---
The JavaScript syntax defines two types of values:

   - Fixed values
   - Variable values
---
### JavaScript Variables
---
In a programming language, variables are used to store data values.

JavaScript uses the keywords var, let and const to declare variables.

An equal sign is used to assign values to variables.

In this example, x is defined as a variable. Then, x is assigned (given) the value 6:

let x;
x = 6; 

Fixed values are called *Literals.*

Variable values are called *Variables.*

How to create variables:
```
var x;
let y;
```
How to use variables:
```
x = 5;
y = 6;
let z = x + y;
```
---
### JavaScript Comments
---
Not all JavaScript statements are "executed".

Code after double slashes // or between /* and */ is treated as a comment.
---
### Block Scope
---
Before ES6 (2015), JavaScript had only Global Scope and Function Scope.

ES6 introduced two important new JavaScript keywords: let and const.

These two keywords provide Block Scope in JavaScript.

Variables declared inside a { } block cannot be accessed from outside the block:

```
Example
{
  let x = 2;
}
// x can NOT be used here
```

Variables declared with the var keyword can NOT have block scope.

Variables declared inside a { } block can be accessed from outside the block.

```
Example
{
  var x = 2;
}
// x CAN be used here
```
```
Operator            Description         Example           Same as              Result      Decimal
&                       AND               5 & 1         0101 & 0001             0001         1
|                       OR                5 | 1         0101 | 0001             0101         5
~                       NOT               ~ 5           ~0101                   1010         10
^                       XOR               5 ^ 1         0101 ^ 0001             0100         4
<<                  left shift            5 << 1        0101 << 1               1010         10
/>>                 right shift           5 >> 1        0101 >> 1               0010         2
/>>>            unsigned right shift      5 >>> 1       0101 >>> 1              0010         2
```

JavaScript variables can hold different data types: numbers, strings, objects and more:
```
let length = 16;                               // Number
let lastName = "Johnson";                      // String
let x = {firstName:"John", lastName:"Doe"};    // Object
```
---
## JavaScript Functions
---
A JavaScript function is a block of code designed to perform a particular task.

A JavaScript function is executed when "something" invokes it (calls it).
```
Example :

function myFunction(p1, p2) 
{
  return p1 * p2;   // The function returns the product of p1 and p2
}
```
### JavaScript Function Syntax

A JavaScript function is defined with the function keyword, followed by a name, followed by parentheses ().

Function names can contain letters, digits, underscores, and dollar signs (same rules as variables).

The parentheses may include parameter names separated by commas:
(parameter1, parameter2, ...)

The code to be executed, by the function, is placed inside curly brackets: {}
```
function name(parameter1, parameter2, parameter3) 
{
  // code to be executed
}
```
### Function Return

When JavaScript reaches a return statement, the function will stop executing.

If the function was invoked from a statement, JavaScript will "return" to execute the code after the invoking statement.

Functions often compute a return value. The return value is "returned" back to the "caller":
```
Example:

Calculate the product of two numbers, and return the result:
let x = myFunction(4, 3);   // Function is called, return value will end up in x

function myFunction(a, b) {
  return a * b;             // Function returns the product of a and b
}

The result in x will be:
12
```

### Why Functions?

You can reuse code: Define the code once, and use it many times.

You can use the same code many times with different arguments, to produce different results.
```
Example:

Convert Fahrenheit to Celsius:
function toCelsius(fahrenheit) {
  return (5/9) * (fahrenheit-32);
}
document.getElementById("demo").innerHTML = toCelsius(77); 
```


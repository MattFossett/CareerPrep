# Developing and Testing

This directory contains the collections and tests directories. 
Both are Java packages. 

### [/collections](collections)
This package contains my implementation for common Data Structures. Many of these classes use other custom classes to fully implement, 
such as Stack implemented with List. 

### [/tests](tests)
Contains the test driver files to ensure that data structures are working to specification. 
Test output is stored in text files in [/tests/output](/tests/output). 

Compiling tests:
From [/DataStructures]() compile with the following example: <br>
```
javac tests/list_test_driver.java 
```

Run this file with the following example: <br>

```
java tests/list_test_driver
```
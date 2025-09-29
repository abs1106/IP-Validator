The IPValidator is a Java program that validates IPv4 addresses, determines their class, 
and identifies their network and host portions. When the user enters an IP address, 
the program splits it into octets and checks that there are exactly four parts, each 
containing only numbers and falling within the valid range of 0–255. If the address is
valid, the program reports whether it belongs to Class A, B, C, D, or E. For Classes A 
through C, it also displays the corresponding network part and host part of the address. 
For Classes D and E, it explains that these ranges are reserved and do not have network 
or host parts. The program uses helper methods to parse and validate each octet, check if 
a string is numeric, and extract the correct portions of the address. It runs in the console
and uses the Scanner class for user input. To execute the program, compile IPValidator.java
and run it from the command line or an IDE, then enter an IPv4 address such as 192.168.1.10 
to view the validation result, class, and breakdown of network and host parts. This project 
demonstrates input validation, string handling, and modular programming techniques in Java.

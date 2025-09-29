package project2;


import java.util.Scanner;

public class IPValidator {

    // see if the IP address is in correct format
    public static boolean isValidIP(String ipAddress) {
        String[] octets = ipAddress.split("\\.");
        
        // Check if there is 4 octets
        if (octets.length != 4) { //not equal 
            System.out.println(ipAddress + " is not a valid IP address. There are only " + octets.length + " octets.");
            return false;
        }

        // Validate each octet 
        int octet1 = parseOctet(octets[0], ipAddress);
        int octet2 = parseOctet(octets[1], ipAddress);
        int octet3 = parseOctet(octets[2], ipAddress);
        int octet4 = parseOctet(octets[3], ipAddress);

        // If any octet is not valid, return false
        if (octet1 == -1 || octet2 == -1 || octet3 == -1 || octet4 == -1) {
            return false;
        }

        return true;
    }

    // Method parse and validate a octet
    public static int parseOctet(String octet, String ipAddress) {
       
    	// Check if the octet is valid between 0 and 255
        if (isNumber(octet)) {
            int value = Integer.parseInt(octet);
            if (value >= 0 && value <= 255) {
                return value;
            } else {
                System.out.println(ipAddress + " is not a valid IP address. " );
                System.out.println( octet + " is not a valid octet.");
                return -1;
            }
        } else {
            System.out.println(ipAddress + " is not a valid IP address. " );
            System.out.println( octet + " is not a valid octet.");
            return -1;
        }
    }

    // Method to check if a string is a number
    public static boolean isNumber(String str) {
        // Check if each character is a digit
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // Check if character is not between '0' and '9'
            if (ch < '0' || ch > '9') {
                return false;
            }
        }
        return true;
    }


    // determining the class of the IP address
    public static String getIPClass(String ipAddress) {
        int firstOctet = Integer.parseInt(ipAddress.split("\\.")[0]);

        if (firstOctet >= 1 && firstOctet <= 126) {
            return "A";
        } else if (firstOctet >= 128 && firstOctet <= 191) {
            return "B";
        } else if (firstOctet >= 192 && firstOctet <= 223) {
            return "C";
        } else if (firstOctet >= 224 && firstOctet <= 239) {
            return "D";
        } else {
            return "E";
        }
    }

    // getting the network part /*FIX ME */
 
    public static String getNetworkPart(String ipAddress, String ipClass) {
        // get the positions of the dots
        int firstDot = ipAddress.indexOf('.');
        int secondDot = ipAddress.indexOf('.', firstDot + 1);
        int thirdDot = ipAddress.indexOf('.', secondDot + 1);

        if (ipClass.equals("A")) {
            return ipAddress.substring(0, firstDot + 1) + "0.0";
        } else if (ipClass.equals("B")) {
            return ipAddress.substring(0, secondDot + 1) + "0";
        } else if (ipClass.equals("C")) {
            return ipAddress.substring(0, thirdDot + 1) + "0";
        } else {
            return "No network part for Class " + ipClass;
        }
    }

    // getting the host part 
   
    public static String getHostPart(String ipAddress, String ipClass) {
        // positions of the dots
        int firstDot = ipAddress.indexOf('.');
        int secondDot = ipAddress.indexOf('.', firstDot + 1);
        int thirdDot = ipAddress.indexOf('.', secondDot + 1);

        if (ipClass.equals("A")) {
            return ipAddress.substring(firstDot + 1);
        } else if (ipClass.equals("B")) {
            return ipAddress.substring(secondDot + 1);
        } else if (ipClass.equals("C")) {
            return ipAddress.substring(thirdDot + 1);
        } else {
            return "No host part for Class " + ipClass;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user to input an IPv4 address
        System.out.print("Please enter an IPv4 address: ");
        String ipAddress = scanner.nextLine();

        // let the user know they did something 
        System.out.println("You entered: " + ipAddress);

        // is it right ??? let user know 
        if (isValidIP(ipAddress)) {
            // Determine the class of the IP address
            String ipClass = getIPClass(ipAddress);
            System.out.println(ipAddress + " is a valid Class " + ipClass + " address.");

            // Handling Class D and E addresses
            if (ipClass.equals("D") || ipClass.equals("E")) {
                System.out.println("Class " + ipClass + " addresses are reserved and do not have network or host parts.");
            } else {
                // Display the network and host parts for Class A, B, and C addresses
                String networkPart = getNetworkPart(ipAddress, ipClass);
                String hostPart = getHostPart(ipAddress, ipClass);
                System.out.println("The network part is " + networkPart + ".");
                System.out.println("The host part is " + hostPart + ".");
            }
        }

        // Close the scanner DONT FORGET
        scanner.close();
    }
}





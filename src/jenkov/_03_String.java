package jenkov;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class _03_String {
    public static void main(String[] args) {
        intro();
    }
    public static void intro(){
        /**
         * Java String data type can contain a sequence (string) of characters
         * Java String before java 9 internallu represented in java jvm  using bytes
         * encoded as UTF-16 . UTF-16 uses 2 bytes to represent a single character
         * Thus characters of java string are represented using a char array
         *
         * UTF is a character encoding that can represent characters from a lot of
         * different languages (alphabets). So its necessary to use 2 bytes per character
         *
         * After java 9 , JVM can optimize strings using new feature called compact strings
         * It lets detect if a string only contains ISO-8859-1/Latin-1 characters
         * If so String will only use 1 byte per character internally.
         * Characters of a compact java string can thus be represented by a byte array
         * instead of a char array.
         * This detection happens when the string is created.
         * Since string is immutable once created - so its safe to do this.
         */
        // Java String literals
        String myString = "Hello World";
        System.out.println(myString);
        //Escape characters
        // \\ translated into a single \
        // \t tab
        // \r a single carriage return in the string
        // \n a new line character in the string

        String text = "\tThis text is one tab in.\r\n";
        System.out.println(text);
        // String Literals as Constants or Singletons
        /**
         * JVM only creates a single String instance in memory. It then defacto becomes constant or singleton
         * Diff variables initialized to the same constant string will point to same string instance in memory
         * If you want two separate string objects then use new.
         *
         * Text block java 13
         */
        String textblock = """
                            This is a text inside a
                            text block.
                            You can use "quotes" in here
                            without escaping them
                           """;
        //indentation : based on last 3 delimiter quote characters of the text block to determine
        // the indentation
        String textblock1 = """
                   This is a Java text block
                   """;

        String textblock2 = """
                   This is a Java text block
                 """;

        String textblock3 = """
                   This is a Java text block
               """;

        System.out.println(textblock1);
        System.out.println(textblock2);
        System.out.println(textblock3);

        //best way to concatenate
        String[] strings = new String[]{"one", "two", "three"};

        StringBuilder temp = new StringBuilder();
        for (String s : strings){
            temp.append(s);
        }
        String result = temp.toString();
        // this avoids creating string builder and string objects in the loop
        result.length();
        //substring
        String string1 = "Hello World";

        String substring = string1.substring(0,5);
        System.out.println(substring);

        //indexOf
        int index = string1.indexOf("World");
        System.out.println(index);
        // if not found , returns -1

        //matching a string against regular expression
        String text1 = "one two three two one";

        boolean matches = text1.matches(".*two.*");

        //compare string
        //equals, equalIgnoreCase, startsWith, endsWith, compareTo

        //equals : check if two strings are exactly equal

        //compareTo : returns int , if less -ve , equal 0 , more +ve

        System.out.println("a".compareTo("z"));
        System.out.println("z".compareTo("a"));
        System.out.println("Z".compareTo("Z"));

        //Convert number to string
        String intStr = String.valueOf(10);
        System.out.println("instr "+ intStr);

        //Convert object to string
        Integer integer = new Integer(123);
        String intStr1 = integer.toString();
        System.out.println(intStr1);
        System.out.println(intStr1.charAt(0));

        String theString = "This is a good day to code";

        byte[] bytes1 = theString.getBytes();
        byte[] bytes2 = theString.getBytes(Charset.forName("UTF-8"));

        System.out.println(bytes1);
        System.out.println(bytes2);

        //String formatting java 13
        String input = "Hello %s";

        String output1 = input.formatted("World");
        System.out.println(output1);

        String output2 = input.formatted("Jakob");
        System.out.println(output2);

        //translate escape codes

        String input1 = "Hey, \\n This is not normally a line break.";
        System.out.println(input1);

        String output = input1.translateEscapes();
        System.out.println(output);

        //switch statements
        // works like if except it can choose between more than two blocks of code to execute

        int amount = 9;
        switch(amount) {
            case 0:
                System.out.println("amount is 0"); break;
            case 5:
                System.out.println("amount is 5"); break;
            case 10:
                System.out.println("amount is 10"); break;
            default:
                System.out.println("default");
        }
        // default runs if no case satisfy also if the case satisfied does not have a break

        //switch on parameter
        // byte , short , char , int , string , enum
        switch("a") {

            case "d"  : { System.out.println("size is small");   break; }
            case "e"  : { System.out.println("size is medium");  break; }
            case "f"  : { System.out.println("size is large");   break; }
            case "g"  : { System.out.println("size is X-large"); break; }

            default : { System.out.println("size is not S,M,L or XL: " + "a"); }
        }

        Size size = Size.valueOf("LARGE");
        switch(size) {

            case SMALL   : { System.out.println("size is small");   break; }
            case MEDIUM  : { System.out.println("size is medium");  break; }
            case LARGE   : { System.out.println("size is large");   break; }
            case X_LARGE : { System.out.println("size is X-large"); break; }

            default : {
                { System.out.println("size is not S,M,L or XL: " + size); }
            }
        }

        //Java switch expression
        // think of -> as  a return statement
        int  digitInDecimal = 12;
        char digitInHex     =
                switch(digitInDecimal){
                    case  0 -> '0';
                    case  1 -> '1';
                    case  2 -> '2';
                    case  3 -> '3';
                    case  4 -> '4';
                    case  5 -> '5';
                    case  6 -> '6';
                    case  7 -> '7';
                    case  8 -> '8';
                    case  9 -> '9';
                    case 10 -> 'A';
                    case 11 -> 'B';
                    case 12 -> 'C';
                    case 13 -> 'D';
                    case 14 -> 'E';
                    case 15 -> 'F';

                    default -> '?';
                };

        System.out.println(digitInHex);


        String token = "123";

        int tokenType = switch(token) {
            case "123" -> 0;
            case "abc" -> 1;
            default -> -1;
        };

        System.out.println(tokenType);
        // java switch yield in java 13
        //yield instead of arrow ->
        String token1 = "123";

        int tokenType1 = switch(token1) {
            case "123" : yield 0;
            case "abc" : yield 1;
            default : yield -1;
        };
        System.out.println(tokenType1);


        // Java instanceOf
        // Check if the given object is an instance of a given class, superclass or interface

        Map<Object, Object> map = new HashMap();

        boolean mapIsObject = map instanceof Object;
        // It will evaluate to true if map variable references an object that is an instance of class object.
        // or any subclass of the class object.
        System.out.println(mapIsObject);

        Map<Object, Object> map1 = new HashMap();

        boolean mapIsObject1 = map1 instanceof HashMap;
        //Map is not a subclass of HashMap. a Map is not guaranteed to be an instance of a HashMap
        //But since the actual object is HashMap so this also returns true
        System.out.println(mapIsObject1);

        //instanceOf with Interface

        //instanceOf with null
        //This is because it is not the reference type that is compared against the target class or interface
        //But the actual type of the referenced object.
        Map<Object, Object> map2 = null;


        boolean mapIsObject2 = map2 instanceof Map;
        System.out.println(mapIsObject2);

        //Sometimes compiler can detect at compile time that instanceOf expression will always be false
        //you get an error
        String myString4 = "Hey";

//        if(myString4 instanceof Integer) {
//
//        }

        //InstanceOf to Downcast
        //used to downcast an object of supertype to a subtype
        Map<Object, Object> map5 = new TreeMap;
        if(map5 instanceof SortedMap) {
            SortedMap sortedMap = (SortedMap) map5;
        }

        //for loop
        //  loop initializer optional , can have multiple initializer statement
        //  condition
        //  post iteration operation

        //        MyLoop loop = new MyLoop(10);
        //
        //        for( ; loop.loopAgain() ; loop.iterationDone()) {
        //        }

        //continue : skip current loop and jump to next iteration

        //break : breaks out of the for loop

        // do while : at least execute once before condition is tested

        

    }
    private static enum Size {
        SMALL, MEDIUM, LARGE, X_LARGE
    }
}

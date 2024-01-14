package jenkov;

public class _01_Intro {
    public static void main(String[] args) {
        introJava();
    }
    public static void introJava() {
        /**
         * Java variable type
         *  ** Non static field : Variable belongs to an object. It is also called Instance variables.
         *                        Objects keep internal state in non-static fields.
         *  ** Static fields : Variable belongs to a class. It has the same value for all objects that access it. Also called Class variables.
         *  ** Local variables : Variable declared inside a method. Only available inside the method it is declared.
         *  ** Parameters : Variable that is passed to a method when the method is called. Also accessible inside the method.
         *
         *  Java variable naming convention
         *  ** case sensitive
         *  ** name must start with a letter , or $ or _ character . After first character later can be numbers as well
         *  ** not be same as reserve keywords
         *   $myVar, _myVar, myVar_1
         *
         *   Java Local-Variable Type Inference
         *   From Java 10 it is possible to infer type only for a local variable
         *   ** old **
         */
        String myVar = "Ssss";
        // from java 10 type inference possible in local variables
        var variable = "Ssss";

        System.out.println((variable instanceof String));
        System.out.println(myVar instanceof String);
        /**
         * Primitive Data type
         *  ** boolean : true or false
         *  ** byte : 8 bit signed value , -128 to 127
         *  ** short : 16 bit signed value, -32.768 to 32767
         *  ** char : 16 bit unicode character
         *  ** int : 32 bit signed value, -2.147.483.648 to 2.147.483.647
         *  ** long : 64 bit floating signed value -9.223.372.036.854.775.808 to 9.223.372.036.854.775.808
         *  ** float : 32 bit floating point value
         *  ** double : 64 bit floating point value
         *
         *  Object Data type
         *  Boolean , Byte, Short, Character, Integer, Long, Float, Double, String
         */

        /**
         * AutoBoxing
         * ** Java can automatically box a primitive variable in an object version if that is required
         * ** or unbox an object version of the primitive data type if required.
         */
        Integer myInteger = new Integer(45);
        int myInt = myInteger;

        int yourInt = 56;
        Integer yourInteger = yourInt;

        try {
            // one case can cause null poiner
            Integer someInteger = null;
            int someInt = someInteger;
        }catch (Exception e) {
            System.out.println(e);
            System.out.println("if object null then assignment to a  primitive can cause null exception");
        }

        /**
         * Math operator imp*
         * Remainder or Modulo
         * int remainder  = 100 % 9;
         *
         * java.lang.Math
         *
         */
        //abs
        int abs1 = Math.abs(-67); // 67
        //ceil -- rounds up to nearest integer value
        double ceil = Math.ceil(7.343);  // ceil = 8.0
        //floor -- rounds down to nearest integer value
        double floor = Math.floor(7.343);  // floor = 7.0
        //floorDiv -- divides one integer/long to another and rounds the result down to nearest integer value
        double result3 = Math.floorDiv(-100,9); // actual value -11 then round down to -12
        System.out.println("result3: " + result3);
        double result4 = -100 / 9;
        System.out.println("result4: " + result4); // -11
        //min max
        //round
        double roundedDown = Math.round(23.445); // 23
        double roundedUp   = Math.round(23.545); //24
        System.out.println(roundedDown +"  "+ roundedUp);
        //Math.random() returns random value between 0 and 1
        double random = Math.random();
        System.out.println(random);
         random = Math.random() * 100D;
        System.out.println(random);

        // Math.exp() function returns e (Euler's number) raised to the power of the value provided as paramete
        double exp1 = Math.exp(1);
        System.out.println("exp1 = " + exp1);

        double exp2 = Math.exp(2);
        System.out.println("exp2 = " + exp2);

        //Math.log10
        double log10_1   = Math.log10(1);
        System.out.println("log10_1 = " + log10_1);

        double log10_100 = Math.log10(100);
        System.out.println("log10_100 = " + log10_100);

        //Math.pow()
        double pow2 = Math.pow(2,2);
        System.out.println("pow2 = " + pow2);

        double pow8 = Math.pow(2,8);
        System.out.println("pow8 = " + pow8);
        //Math.sqrt
        double sqrt4 = Math.sqrt(4);
        System.out.println("sqrt4 = " + sqrt4);
        //Math.sin
        double sin = Math.sin(Math.PI);
        System.out.println("sin = " + sin);
        //Math.asin()
        double asin = Math.asin(1.0);
        System.out.println("asin = " + asin);
        //Math.toDegrees()
        double degrees = Math.toDegrees(Math.PI);
        System.out.println("degrees = " + degrees);
        //Math.toRadians
        double radians = Math.toRadians(180);
        System.out.println("radians = " + radians);
    }
}

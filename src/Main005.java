public class Main005 {
    /*
    *
    * ThreadSafe
    * LocalVariables are in each threads own stack and never shared. All local primitive variavles are thread safe.
    *
    * Thread Control escape rule
    * If a resource is created , used and disposed within the control of the same thread, and never escapes the control
    * of this thread, the use of that resources is thread safe.
    */
    volatile int volatileInt ;
    int nonVolatileInt;
    public static void main(String[] args) {
        /*
         * Java Volatile Visibility guarantee
         * Java Volatile write visibility guarantee
         * Both the variables get will be synchronized to main memory
         */
            Main005 m = new Main005();
            m.nonVolatileInt = 3;
            m.volatileInt = 4;

            /*
            * Volatile variables are read directly from memory.
            * All Variables visible to the thread reading variable will also have their values refreshed from main memory.
            *
             */

        /*
        *
        * Java Happens Before Guarantee
        * Happens Before Guarantee for Writes to volatile variables
        * A write to a non-volatile or volatile variable that happens before a write to volatile variable is guaranteed to happen
        * before the write to that volatile variable.
        *
        * Happens Before Guarantee for Reads of volatile variables
        * A read of a volatile variable will happen before any subsequent reads of volatile and non-volatile variables.
         */

        int d = m.volatileInt;
        int e = m.nonVolatileInt;

        /*
        *
        * Java Synchronized Visibility Guarantee
        * When a thread enters a synchronized block , all variables to the thread are refreshed from main memory.
        * When a thread exits a synchronized block , all variables to the thread are written back to main memory.
        *
        * Java Synchronized Happens Before Guarantee
        * When a thread enters a synchronized block all variables visible to the thread will be read from main memory.
        *
        * The end of a synchronized block provides the visibility guarantee that all changed variables will be written back to
        * main memory when the thread exits the synchronized block.
        *
        *
        *
         */

        
    }

}

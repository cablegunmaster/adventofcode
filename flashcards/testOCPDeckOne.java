package flashcards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testOCPDeckOne {

    public testOCPDeckOne() {
    }

    //
    @Test
    public void testExplicitCast(){
        //5 Float to int.
        assertEquals(5.99, 5.99f);
    }

    //
    @Test
    public void testExplicitVsImplicitCasts(){

        //Which of the following requires an explicit cast to SHORT (2 bytes)

        //int
        //byte
        //float
        //bit

        //explicit cast.
        int test = 5;
        short vOut = (short) test;

        float testFloat = 5F;
        short testShort = (short) testFloat;
    }

    //How many unimplemented methods in functional interface
    // Only 1

    //Fill in the blank: A _______ class is the first nonabstract class that extends an abstract class
    // and is required to implement all inherited abstract methods.
    //A: concrete.

    //Name the data types supported by a switch statement.
    //A:
    // int and Integer,
    // byte and Byte,
    // short and Short,
    // char and Character,
    // String,
    // enum,
    // and var (if the type of the var resolves to one of the other types)

    //What module is automatically made available to all other modules?
    // java.base

    //True or false? The logical complement operator, -,
    // flips the value of a boolean expression.

    //True or false? At runtime,
    // it is possible to change the type of a var after it is declared.
    //A:False. A var is initialized with a specific type.
    // Due to polymorphism, other subtypes may be assigned, but the underlying type cannot be changed.

    //Which characters in this statement are optional? (a) -> { return true; }
    //A: The parentheses, braces, return statement, and semicolon. It could have been a->true.

    //What is the name of the file that must be in the root directory of your module?
    //module-info.java

    //What access modifiers can be applied to a member inner class?
    //Guess: public, protected, default (package-private) private.

    //Besides letters and numbers, what symbols are permitted to be used in identifiers?
    //$ and _

    //What is 12 % 5 - 1?
    //A: 1 (left to right, first Modulo, then -1)


    /**
     * True or false? An instance method is allowed to reference a static variable.
     *
     * True, static variables you can always approach.
     */

    /**
     * What is the syntax for creating an instance initializer?
     * A: {} with zero or more statements inside the block
     */

    /**
     * What symbols can be used to change the order of operation in Java?
     * A: Parentheses, ()
     */

    /**
     * What is the data type of z? short x = 20; short y = 30; var z = x + y;
     * A: int, as all addition operations involving integer values are automatically promoted to int
     */

    /**
     * Define the handle or declare rule and how it is implemented.
     * A: The handle or declare rule applies to checked exceptions and requires the developer
     * to either wrap the exception in a try/catch block (handle)
     * or throw the exception to the caller (declare) using the throws keyword in the method declaration.
     */

    /**
     * Are curly brackets, { }, required in if-then statements?
     * A: No, they are optional if there is only one statement in the branch of the if statement.
     */

    /**
     * What program comes with the JDK for listing the modules a jar depends on?
     * jdeps
     */

    /**
     * Rank these operators from highest operator precedence to lowest: + (addition) * ! == ++ ||
     * ++ ! * + == ||
     */



    /**
     * Name the eight Java primitive types and indicate which are integer types, which are floating-point types, and which are neither, in increasing order of size.
     *
     * byte,short,char,int  and long are integer types.
     * float and double are (floating-point types)
     * boolean is neither integer or floating type.
     */

    /**
     * What characters can a variable name begin with?
     * A letter, dollar sign ($), or underscore (_)
     */

    /**
     * True or false? The this() statement can be used to call other constructors
     * within the class but can be used only on the first line of a constructor.
     *
     * A:True.
     */

    /**
     * What functional interface does Java provide returns void?
     * A: Consumer
     */

    /**
     * An instance of a class is called a(n) _________________.
     * A: Object
     */

    /**
     * What are the default values for these instance variables:
     * String s;
     * int num;
     * boolean b;
     * double d?
     *
     * A:
     * s = null; num = 0; b = false; d = 0.0
     */

    /**
     * Write a static import to import the static LENGTH variable of a.b.C
     * A: import static a.b.C.LENGTH; or import static a.b.C.*;
     */

    /**
     * List all the access modifiers in Java.
     * protected
     * private
     * public
     * default, package private (no name)
     */

    /**
     * Why is not recommended to modify a loop variable in the body of the loop?
     * A: It could produce side effects or unexpected results if the loop counter or condition is modified directly.
     */

    /**
     * Which looping statement guarantees the body is executed at least once?
     * A: do {} while()
     */

    /**
     * True or false? Overloaded methods have the same method signatures.
     * False. The parameter lists must be different.
     *
     * Keyword: " Overloaded" same function but different parameters.
     */

    /**
     * Which are immutable: String, StringBuilder, StringBuffer, arrays, or ArrayList?
     * A: String is the only immutable class in the list.
     */

    /**
     * What keyword would be used for a class that extends an interface?
     * A: Trick question! A class cannot extend an interface.
     */

    /**
     * What is the command line used to compile the Java class Wolf.java, and what file does it generate?
     * A: Run: javac Wolf.java (and it generates Wolf.class)
     */

    /**
     * What is the command line to run the program contained in Wolf.class?
     * A: java Wolf
     */

    /**
     * True or false?
     * The first line of every constructor is a call to the parent constructor via the super() command.
     *
     * A: False. A method may instead call this() as the first line of the constructor instead of super(),
     * although it will eventually resolve to a constructor that calls super() as its first line.
     */

    /**
     * What does a short-circuit operator do, and which ones are available in Java?
     *
     * A: A short-circuit operator skips evaluating the right-hand side
     * of an expression if the value can be determined by the left-hand side. Java includes support for || and &&.
     */

    /**
     * What functional interface does Java provide that declares a single method that returns a boolean?
     * A:Predicate
     */

    /**
     * True or false? If a module doesn’t contain a module-info file, one is automatically generated.
     * A:False
     */

    /**
     * Describe the ternary operator, its syntax, and how it can be used for an assignment.
     * A: The ternary operator tests a Boolean condition and returns one of two results.
     * It is of the form booleanExpression ? expression1 : expression2.
     * It can be used as a shorthand version of an if-then-else statement to assign a value to a variable in a single line.
     */

    /**
     * True or false? Every compiled class has a constructor.
     * A: True. The compiler will insert a default no-argument constructor
     * if none is explicitly written by the developer.
     */

    /**
     * True or false? A class can implement two interfaces that have the same method signature.
     * A: True, provided the methods are compatible using the rules for overridden methods
     */

    /**
     * Name the four rules an overridden method must follow.
     * A: An overridden method must have the same signature,
     * the same or a more accessible access modifier,
     * and a covariant return type. It also must not throw a new or broader checked exception.
     */

    /**
     * What functional interface does Java provide that doesn’t take any parameters?
     * A: Supplier
     */

    /**
     * What modifiers are implicitly applied to all interface methods without a body?
     * A: public and abstract
     */

    /**
     * List the six parts of a method declaration in order (not including the exception clause).
     * A:
     * Access modifiers,
     * optional specifiers,
     * return type,
     * method name,
     * parameter list,
     * method body
     */

    /**
     * What do JDK and JVM stand for?
     * A: Java development kit, and Java virtual machine.
     */

    /**
     * Which method modifiers cannot be used with abstract?
     * A: static, private, final
     */

    /**
     * Write a line of code to print both the first and last index of this array: boolean[] b = {true, false};
     * System.out.println(b[0] + " " + b[b.length - 1]); or
     * System.out.println(b[0] + " " + b[1]);
     */

    /**
     * Which instance fields in a class must be initialized exactly once?
     * Name the three places they can be initialized.
     *
     * A: final fields.
     * 1.They can be initialized in the line in which they are declared,
     * 2. in an instance initializer,
     * 3. or in a constructor.
     */

    /**
     * What exception class should never be handled or declared in a program?
     * A: Error and Throwable
     */

    /**
     * True or false? A try block can have at most one associated catch block.
     *  A:False. A try block can have zero or more catch blocks,
     *  provided the exception types of each subsequent
     *  catch block is not a subtype of the exceptions in a previous catch block.
     */

    /**
     * Which characters in this statement are optional? () -> { System.out.println(); return true; }
     * A: None. The parentheses are required when there aren’t any parameters.
     * The braces are required because there are multiple statements.
     */

    /**
     * What are the short and long forms of the java command used for the module path?
     * A:  -p and --module-path
     */

    /**
     * True or false? A static method is allowed to reference an instance variable.
     * A: False (except through a reference to a class instance)
     */

    /**
     * What does the following output? int[] x = { 7, 8, 9}; int[] y = { 7, 7, 7};
     * System.out.println(Arrays.compare(x, y) + " " + Arrays.mismatch(x, y));
     * A: 1 1
     */

    /**
     * What’s the syntax for writing a no-args constructor?
     * A: <AccessModifier> <ClassName> () { ... }
     */

    /**
     * What term describes the scenario where a local variable would be final
     * if it would compile by adding final modifier?
     * A: Effectively final
     */

    /**
     * What functional interface does Java provide that doesn’t take any parameters?
     * A: Supplier
     */

    /**
     * When is a return statement not required in a method?
     * A: When the return type is void
     */

    /**
     * How do you negate a boolean value?
     * A: You cannot negate a boolean value, at least not numerically using the minus operator, -.
     * You can invert the boolean value using the logical complement operator.
     */

    /**
     * What goes in the module-info to specify that modules requiring your module can access specific other modules?
     * requires transitive
     */

    /**
     * Which statement can be used to stop the current loop execution
     * and immediately evaluate the loop condition?
     * A: continue
     */

    /**
     * True or false? A case statement can use effectively final variables.
     * A: False. The variables must be compile-time constants. Unlike effectively final variables,
     * a compile-time constant must be explicitly marked final and be initialized in the line it is declared.
     */

    /**
     * What does this code print? String s = "hmm"; s.substring(1); System.out.println(s);
     * A: hmm The result of substring() is not stored anywhere, and strings are immutable, so s itself is not saved.
     */

    /**
     * True or false? Instance initializer blocks run before any constructors are initialized.
     * A: True. Fields and instance initializer blocks are run first,
     * in the order they appear, followed by any constructor calls.
     */

    /**
     * A method with a generic return type may be overridden provided
     * the return type and generic parameter meet what criteria?
     * A: The return type is covariant, and the generic parameter is the same.
     */

    /**
     * True or false? A class can implement two interfaces that have the same method signature.
     * A: True, provided the methods are compatible using the rules for overridden methods
     */

    /**
     * Name the four rules an overridden method must follow.
     * A:
     * An overridden method must have the same signature,
     * the same or a more accessible access modifier,
     * and a covariant return type.
     * It also must not throw a new or broader checked exception.
     */

    /**
     * What is in the StringBuilder created by
     * System.out.println(new StringBuilder("surprise").insert(3, "!!").replace(1, 3, "-"));?
     * A: s-!!prise
     */

    /**
     * Which of the following StringBuilder methods can be chained?
     * append(), delete(), insert(), reverse(), substring(), toString()
     * A: append(), delete(), insert() and reverse() can be chained because they return a StringBuilder.
     * The other two return a String.
     */

    /**
     * When running a Java modular program, what character separates the module name and fully qualified class name?
     * A: /
     */

    /**
     * What keyword in the module-info is used to specify that calling code can use a package?
     * A: exports
     */

    /**
     * Which of the following can sort() be called on? List/Map/Set
     * A: List
     */

    /**
     * How many objects are created in String[] s = new String[5];?
     * A: Just one. The references are all set to null by default.
     */

    /**
     * What is the purpose of a label statement?
     * A: It allows the program to break or continue for a specific loop within a group of nested loops.
     */

    /**
     * What characters may a variable name end with?
     * A: A letter, number, dollar sign ($), or underscore (_)
     */

    /**
     * Which order does Java use when looking for matches in overloaded methods of autoboxing,
     * exact match, widening primitives, and varargs?
     * A:
     * 1. Exact match,
     * 2. widening primitives,
     * 3. autoboxing,
     * 4. varargs
     */

    /**
     * Which operator decrements a value and returns the new value?
     * A: The pre-decrement operator: --variable
     */

    /**
     * What are the instructions run by the JVM called?
     * A: Bytecode
     */

    /**
     * Name three differences between an abstract class and interface.
     * A: Any of the following are valid differences:
     * abstract classes can contain regular instance methods and variables,
     * abstract classes have constructors,
     * abstract classes can contain instance and static initializers,
     * interfaces include implicit method and type modifiers,
     * a class can extend only one class but an interface can extend multiple interfaces,
     * a class can implement multiple interfaces, interfaces can include default methods,
     * interfaces have special rules around access modifiers and methods,
     * interfaces can only contain public static final variables.
     */

    /**
     * True or false? An interface can extend multiple interfaces.
     * A: True
     */

    /**
     * What is a stack trace and how is it useful in exception handling?
     * A: A stack trace shows all of the methods on the stack when an exception is thrown.
     * It can be printed at runtime and used to trace the cause of an exception.
     */

    /**
     * What is the most common signature of a main() method?
     * A: public static void main(String[] args)
     */

    /**
     * What are acceptable data types in the right side of a for-each loop?
     * A built-in Java array or class that implements java.lang.Iterable
     */

    /**
     * Fill in the blanks with redeclared, overridden, or hidden:
     * A protected instance method can be _________ by a subclass,
     * a static method can be _________ by a subclass,
     * a variable can be _________ by a subclass,
     * and a private method can be _________ in a subclass.
     *
     * A:
     * A protected instance method can be overridden by a subclass,
     * a static method can be hidden by a subclass,
     * a variable can be hidden by a subclass,
     * a private method can be redeclared in a subclass.
     */

    /**
     * What modifiers are implicitly applied to all interface variables?
     * A: public, static, and final
     */

    /**
     * What method would you use on ArrayList
     * if you wanted to pass a lambda and print each value on its own line?
     * A: forEach()
     */

    /**
     * What keyword can be used to access a member of parent class?
     * A: super
     */

    /**
     * What modifiers are implicitly applied to all interface methods without a body?
     * A: public and abstract
     */

    /**
     * _____ is used to reliably check if two String values are the same.
     * A: equals()
     */

    /**
     * How would you create a new list and add the value true to it?
     * A: List<Boolean> list = new ArrayList<>(); list.add(true);
     */

    /**
     * What is the parent class for all exception and error types in Java?
     * A: Throwable
     */

    /**
     * Which of the following can removeIf() be called on? List/Map/Set
     * A: List
     */

    /**
     * What are the short and long forms of the java command used for the module path?
     * -p and --module-path
     */

    /**
     * What does the following output?
     * int[] x = { 7, 8, 9};
     * int[] y = { 7, 7, 7};
     * System.out.println(Arrays.compare(x, y) + " " + Arrays.mismatch(x, y));
     * A: 1 1
     */

    /**
     * True or false? If a module doesn’t contain a module-info file, one is automatically generated.
     * A:False
     */

    /**
     * var can be used as the type for which of the following:
     * instance variable, static variable, local variable, constructor parameter, method parameter?
     * A: var can be used only as a local variable. It can also be used as an identifier in variable and package names.
     */

    /**
     * Define the handle or declare rule and how it is implemented.
     *
     * A:
     * The handle or declare rule applies to checked exceptions and requires the developer to either wrap
     * the exception in a try/catch block (handle) or throw the exception to the caller (declare)
     * using the throws keyword in the method declaration.
     */

    /**
     * In which situations does the compiler refrain from or report an error trying to insert a default no-argument constructor?
     * A: If the class has at least one constructor declared, the compiler will not insert one.
     * It will also throw an error trying to insert one if the parent class does not define a no-argument constructor for the implicit super() call.
     */

    /**
     * True or false? A class can implement two interfaces that have the same method signature.
     * A: True, provided the methods are compatible using the rules for overridden methods
     */

    /**
     * How many unimplemented methods can a functional interface have?
     * A: One
     */

    /**
     * What exception class should never be handled or declared in a program?
     * A: Error and Throwable
     */

    /**
     * Which of the following variables can null be assigned to? String s; Object o; int num; boolean b
     * A: String s and Object o can be assigned null because they are objects. int and boolean are primitives and so cannot be assigned null.
     */

    /**
     * What does this code print? String s = "hmm"; s.substring(1); System.out.println(s);
     * A: hmm The result of substring() is not stored anywhere, and strings are immutable, so s itself is not saved.
     */

    /**
     * Name the four rules an overridden method must follow.
     * A:
     * 1. An overridden method must have the same signature,
     * 2. the same or a more accessible access modifier,
     * 3. and a covariant return type.
     * 4. It also must not throw a new or broader checked exception.
     */

    /**
     * What order do the class declarations,
     * import statements,
     * and package declaration go within a file?
     * A: The package declaration comes first, followed by imports, followed by the class declaration.
     */

    /**
     * Given the following five exception classes, indicate which are checked exceptions and which are unchecked exceptions:
     * ArrayIndexOutOfBoundsException, U
     * ExceptionInInitializerError, U
     * FileNotFoundException,  C
     * ClassCastException, U
     * NumberFormatException U
     *
     * A: All of them are unchecked exceptions, except FileNotFoundException, which is a checked exception.
     */

    /**
     * What’s the syntax for writing a no-args constructor?
     * A: <AccessModifier> <ClassName> () { ... }
     */

    /**
     * Write a static import to import the static LENGTH variable of a.b.C
     * A: import static a.b.C.LENGTH; or import static a.b.C.*;
     */

    /**
     * Name the data types supported by a switch statement.
     * int and Integer, byte and Byte, short and Short, char and Character, String, enum,
     * and var (if the type of the var resolves to one of the other types)
     */

}

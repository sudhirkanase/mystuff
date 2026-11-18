 Java 8 Objective
 
 1) To simplify programming (Declarative programming) earlier it was Imperative programming
 2) enable function programming
 3) enable parallel programming
 
 Features
 1) lambda expression
 2) Functional interfaces
 3) Default methods in interfaces
 4) Static methods in interfaces
 5) Function BiFuncation
 6) Predicates (boolean evaluation)
 7) Consumers
 8) Method reference ::
 9) Stream
 8) Date and time API
 10) Suppliers
 11) Nashrom Js engine
 
 lambda expression -->
   Enable functional programming
   more readable clean and concise code
   To enable parallel processing
 
 Lambda is anonymous function (not having name, modifiers or return types)
 
 Type inferer
 
 Functional Interface
 Interface if contains only single abstract method is called as Functional Interface
 It can have many default and static methods but should have only one abstract method
 
 Runnable
 Callable
 ActionListener
 Comparable
 
 Why Functional interfaces have only one abstract method?
 --> Compiler will confuse to which method implementation it is if we have more than one abstract methods
 
 
 Default Methods:-
 	we can have default implementation through interfaces
 	This capability is added for backward compatibility 
 	so that old interfaces can be also leverage the lambda expression capability
 	
 	e.g. List or collection interface do not have foreach method declaration in java 7 
 	thus adding such will break collection framework in old implementation
 	hence they come up with default methods and classes implementating the same need not to changes
 
 Difference Between Default methods in interface vs abstract class
 1) instance varible declaration possible in abstract vs not in interface
 2) no constructors for interface
 3) interfaces never talks about state of object
 4) functional interface can refer lambda exp vs abstract class not
 
static methods
 purpose to write general utility methods inside the interfaces
 
Predefined functional interfaces
1) Predicates :- test() check the condition.. boolean value function
		Predicate<Integer> p1 = (p) -> { return p>100; };
		p1.test(500);
		p1.negate();
		p1.and(t -> t>100);
		p1.or(t -> t>100);

		Predicate<String> s=  Predicate.isEqual("test");
		s.test("test");
2) Function :- apply() It takes one argument and return specified values Function<T, R> T - input and R - return type
3) Consumer:- accept() return nothing.. always going to consume something 
4) Supplier :-get ()  always return something wont consume anything eg. produce random number or password

Method reference by double colon (::)
 --- static method reference
 --- constructor reference
 
 Stream API
   to process objects from collection we can use streams
 
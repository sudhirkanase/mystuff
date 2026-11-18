 Java 8 Objective
 
 1) To simplify programming (Declarative programming) earlier it was Imparative programming
 2) enable function programming
 3) enable parallel programming
 
 Features
 1) lambda expression
 2) Funcationl interfaces
 3) Default methods in interfaces
 4) Static methods in interfaces
 5) Function
 6) Predicates
 7) Consumers
 8) Method reference ::
 9) Stream
 10) Date and time API
 11) compact profiles
 12) Metaspace
 13) Java script engine support Nashron
 
 From Java 8:- 
 The interned strings and static variables are moved into the heap itself. ealier it was a part of permgen space

 
 https://code.sololearn.com/#java
 
 lambda expression -->
   Enable functional programming
   more readable clean and concise code
   To enable parallel processing
 
 Lambda is anonymous function (not having name, modifiers or return types)
 
 Type inference
 
 Functional Interface
 Interface if contains only single abstract method is called as Functional Interface
 It can have many default and static methods but should have only one abstract method
 
 java.util.function has all pre defined fucntional interfaces
 
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
5) Operator :- apply() Input and output of same type eg UnaryOperator, BinaryOperator

Method reference by double colon (::)
 --- static method reference
 --- constructor reference
 
 Stream API
   to process objects from collection we can use streams
   
  
 Diff bet Collection.foreach() vs Collection.stream().foreach()
 Collection.forEach() uses the collection's iterator so processing order is defined
 the processing order of Collection.stream().forEach() is undefined.
 
 Modification of collection between foreach (fail-fast)
 Collection.forEach() :- throw concurrentModification exception immediatly after removal in next iternation
 Collection.stream()forEach() :- throw concurrentModification at the end. it performs all the operation and then will throw the exception
 
 Collection.stream()forEach() can enble parallel programming
 
 
 Compact profiles are introduced in java 8
 compact1
 compact2
 compact3
 Full 
 
 jdeps command shows you package or class level dependencies
 
 
 Date and Time
 
 Java 8 introduced new api for date and time to adress shortcoming of older java.util.calender and java.util.Date apis
 
 New classes
 LocalDate
 LocalTime
 New features:-
 Thread Safety 
 APIs Design and Ease of Understanding 
 ZonedDate and time
 
 Java Script engine --> Nashorn engine
 
# optional-interface
Optional allows an object to wrap nullable values.

Optional<ReferenceTypeObject> opt = ... 

--> There are three ways creation of optional interface;

1-) empty Optional object

    Optional<String> opt =  Optional.empty();

2-) Optional with a non-null value : if we want to create Optional objects with values

    Optional<String> sc = Optional.of("Hello");

3-) Optional object that may hold a null value and if object were null, optional object would created as empty

if the value passed in the parameter is null it will throw a NullPointerException. 

So if the value can be null we have to use the ofNullable(T value) method.

Optional<String> opt = Optional.ofNullable(null);

System.out.println(opt); // Optional.empty

opt = Optional.ofNullable("Hello world"); // Optional[Hello world]

System.out.println(opt);


--> Checking Value

1-) Now that you have an Optional object, you can access the methods available to explicitly deal with the presence or absence of values. 

Instead of having to remember to do a null check, as follows:

Optional<String> opt = Optional.ofNullable(null);

System.out.println(opt.isPresent()); //False

opt = Optional.ofNullable("Hello World");

System.out.println(opt.isPresent()); // True

2-) After java 11 there is a reverse way of isPresent : isEmpty

Optional<String> opt = Optional.ofNullable(null);

System.out.println(opt.isEmpty()); //True

opt = Optional.ofNullable("Hello World");

System.out.println(opt.isEmpty()); // False

--> Conditional Action

1-) It is possible to check some conditions and perform some operations on the Optional object with the ifPresent() method. 

but this is possible only if the Optional object has a value, otherwise, it will do nothing.

Optional<String> opt = Optional.ofNullable("Hello world");

opt.ifPresent(c -> System.out.println(c.length()));

2-) In Java 9, a method called ifPersentOrElse() has been added to further manipulate conditions 

if Optional has no value with Runnable action.

Optional<String> opt = Optional.empty();

opt.ifPresentOrElse(c -> System.out.println(c.length()), () -> System.out.println("Other"));

-- > Return Value

1-) there's a get() method that returns the value contained in the Optional object, if it is present. 

Otherwise, it throws a NoSuchElementException.

if(soundcard.isPresent()){

    System.out.println(soundcard.get());

}

2-) Or we could do another thing than just return it by using the orElseGet() method.

        Optional<String> opt = Optional.ofNullable(null);

        System.out.println(opt.orElseGet(() -> "Hello World"));

--> Returning Default value 

1-) In Java 9, The or() method has been added to perform and return an Optional value for an optional that returns the original value.
    
For Optional without a value, it will return as the value in the or() statement.

        Optional<String> opt = Optional.ofNullable("Hello World");

        Optional<String> defaultOpt = Optional.of("Default");

        System.out.println(opt.or(() -> defaultOpt));

2-) Using an Optional object, you can rewrite this code by using the orElse() method, which provides a default value if Optional is empty

    Soundcard soundcard = maybeSoundcard.orElse(new Soundcard("defaut"));


-- > Exception

1-) If we don’t want to return or do anything after checking that the value is null we can throw an Exception as well.

    Optional<String> opt = Optional.ofNullable(null);

    opt.orElseThrow(IllegalArgumentException::new);

--> Conditional Return

1-) We can verify the returned value of Optional objects with a method filter() to extract the values 

we want and remove the unwanted values with a condition.

        boolean present;

        Optional<String> opt = Optional.ofNullable("Hello World");

        present = opt.filter(c -> c == "Hello World").isPresent();

        System.out.println(present); //true

        present = opt.filter(c -> c == "Other").isPresent();

        System.out.println(present); //false

--> Manipulate Value

1-) You can change the value in the Optional object that contains the value with the map() method.

        Optional<String> opt = Optional.ofNullable("Hello World");

        System.out.println(opt.map(String::toUpperCase).get());


--> Nested values with flatmap

    //Old way
    String version = "UNKNOWN";
    if(computer != null){
        Soundcard soundcard = computer.getSoundcard();
        if(soundcard != null){
        USB usb = soundcard.getUSB();
            if(usb != null){
            version = usb.getVersion();
            }
        }
    }
    //new way
    String version = computer.map(Computer::getSoundcard)

    .map(Soundcard::getUSB)

    .map(USB::getVersion)

    .orElse("UNKNOWN")

--> Optional conversion to Stream

        Optional<String> opt = Optional.ofNullable("Hello World");

        System.out.println(opt.stream().map(String::toUpperCase).collect(Collectors.toList()));
        
        
        
https://www.oracle.com/technical-resources/articles/java/java8-optional.html

https://medium.com/swlh/playing-with-java-optional-70ffecb9da33

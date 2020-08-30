String hello = "Hello";

Optional<String> nullable = Optional.ofNullable(hello);

System.out.println(nullable.get());

Optional<String> nullable = Optional.ofNullable(null);

try {
    System.out.println(nullable.get());
} catch (NoSuchElementException e) {
    System.out.println("例外 java.util.NoSuchElementException");
}
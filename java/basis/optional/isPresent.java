String str = "hello";

Optional<String> nullable = Optional.ofNullable(str);

if (nullable.isPresent()) {
    System.out.println("TRUE");
} else {
    System.out.println("FALSE");
}
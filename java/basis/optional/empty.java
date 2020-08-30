Optional<String> empty = Optional.empty();

System.out.println(empty.isPresent());

empty.ifPresent(System.out::println);

System.out.println(empty.orElse("empty"));

try {
    System.out.println(empty.get());
} catch (NoSuchElementException e) {
    System.out.println("例外 java.util.NoSuchElementException");
}
String str = "nonnull";

Optional<String> nonnull = Optional.of(str);

System.out.println(nonnull.isPresent());

nonnull.ifPresent(System.out::println);

System.out.println(nonnull.get());

try {
    Optional.of(null);
} catch (NullPointerException e) {
    System.out.println("例外java.lang.NullPointerException");
}
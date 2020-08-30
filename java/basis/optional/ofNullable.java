String str = null;

Optional<String> nullable = Optional.ofNullable(str);

System.out.println(nullable.isPresent());

nullable.ifPresent(System.out::println);

System.out.println(nullable.orElse("NULL"));
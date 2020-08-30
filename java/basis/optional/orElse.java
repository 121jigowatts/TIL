String str = "nonnull";

Optional<String> nullable = Optional.ofNullable(str);

System.out.println(nullable.orElse("NULL"));


Optional<String> nullable = Optional.ofNullable(null);

System.out.println(nullable.orElse("NULL"));

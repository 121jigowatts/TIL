String str = "nonnull";

Optional<String> nullable = Optional.ofNullable(str);

String value = nullable.orElseGet(Supplier::heavyProcessing);
System.out.println(value);

Optional<String> nullable = Optional.ofNullable(null);

String nullValue = nullable.orElseGet(Supplier::heavyProcessing);
System.out.println(nullValue);


class Supplier {
    static String heavyProcessing() {
        System.out.println("heavy...");
        return "DONE";
    }
}
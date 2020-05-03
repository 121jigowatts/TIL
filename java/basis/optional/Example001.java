import java.util.Optional;

String getName() {
    return null;
}

Optional<String> optName = Optional.ofNullable(getName());
optName.ifPresent(n -> System.out.println(n));

String name = optName.orElse("default value");
System.out.println(name);

class Hoge {
    private String id;
    public Hoge(String id) {
        this.id = id;
    }
    public String getId() {
        return this.id;
    }
}

Optional<Hoge> getHoge() {
    Hoge hoge = null;
    return Optional.ofNullable(hoge);
}

Optional<Hoge> optHoge = getHoge();
optHoge.ifPresentOrElse(h -> System.out.println(h.getId()),() -> System.out.println("null value"));

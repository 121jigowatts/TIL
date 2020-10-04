class Person {
  private Name name;
  public Person(Name name) {
    this.name = name;
  }
  public Name getName() {
    return this.name;
  }
}

class Name {
  private String name;
  public Name(String name) {
    this.name = name;
  }
  public String getName() {
    return this.name;
  }
}

Person person = new Person(new Name("Alice"));
System.out.println(person.getName().getName());

Optional<Person> nonnullPerson = Optional.ofNullable(person);
System.out.println(nonnullPerson.map(n -> n.getName()).map(n2 -> n2.getName()).orElse("default"));

Person nullPerson = null;
Optional<Person> np = Optional.ofNullable(nullPerson);

System.out.println(np.map(n -> n.getName()).map(n2 -> n2.getName()).orElse("default person"));

Person nullName = new Person(null);
Optional<Person> nn = Optional.ofNullable(nullName);

System.out.println(nn.map(n -> n.getName()).map(n2 -> n2.getName()).orElse("default name"));
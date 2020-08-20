class Person {
    int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
}


var arr = Arrays.asList(new Person(1,"Alice"), new Person(2,"Bob"));

System.out.println(arr.stream().collect(Collectors.toMap(Person::getId, Person::getName)));

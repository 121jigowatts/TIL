class Person {
    int id;
    String name;
    String job;

    public Person(int id, String name, String job) {
        this.id = id;
        this.name = name;
        this.job = job;
    }

    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getJob() {
        return this.job;
    }
}


var arr = Arrays.asList(new Person(1,"Alice","PG"), new Person(2,"Bob","MG"), new Person(3,"Cindy","PG"));

System.out.println(arr.stream().collect(Collectors.groupingBy(Person::getJob)));

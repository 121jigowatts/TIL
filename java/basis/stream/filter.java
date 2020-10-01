var arr = Arrays.asList(1, 2, 3);

System.out.println(arr.stream().filter(x -> x % 2 != 0).collect(Collectors.toList()));


class Pet {
  private String name;
  Pet(String name) {
    this.name = name;
  }
  String getName() {
    return this.name;
  }
}

var names = Arrays.asList("hoge", "fuga", "bar");

var pets = Arrays.asList(new Pet("ken"), new Pet("piyo"), new Pet("bar"));
var mypet = pets.stream().filter(p -> names.contains(p.getName())).findFirst();

mypet.ifPresent(p -> System.out.println("my pet is " + p.getName()));

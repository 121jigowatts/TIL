var arr = Arrays.asList(2, -7, 3, 0, -1, -8, 5, 9, -6, 4);

System.out.println(arr.stream().sorted().collect(Collectors.toList()));
System.out.println(arr.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()));
System.out.println(arr.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

class Product {
  private int id;
  private String name;
  private int value;

  public Product(int id,String name,int value) {
    this.id = id;
    this.name = name;
    this.value = value;
  }
  int getId() {
    return this.id;
  }
  String getName() {
    return this.name;
  }
  int getValue(){
    return this.value;
  }
}

var products = Arrays.asList(new Product(1,"Apple",100),new Product(2,"Orange",300),new Product(2,"Banana",200));

// Comparator作成
Comparator<Product> comparator = Comparator.comparing(Product::getId).thenComparing(Product::getValue);

// ソート処理
products.stream().sorted(comparator).forEach(a -> System.out.println(a.getName()));

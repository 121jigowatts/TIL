/**
 * Stream API
 */

// 文字列
List<String> strings = Arrays.asList("a","b","c");
// forEach
strings.stream().forEach(x -> System.out.println(x));

// 数値配列
List<Integer> integers = Arrays.asList(1,2,3,4,5,6);
// sum
int sum = integers.stream().mapToInt(x -> x).sum();
System.out.println(sum);
// filter
int filtered = integers.stream().mapToInt(x -> x).filter(x -> x % 2 == 0).sum();
System.out.println(filtered);

class Product {
    private String category;
    private String name;
    private int price;

    Product(String category, String name, int price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    String getCategory() {
        return this.category;
    }

    String getName() {
        return this.name;
    }

    int getPrice() {
        return this.price;
    }
}

// Object
List<Product> products = Arrays.asList(new Product("A","apple",100),new Product("B","hammer",900),new Product("A","grape",150));
// forEach
products.stream().forEach(x -> System.out.println(x.getName()));
// sum
int sumObject = products.stream().mapToInt(x -> x.getPrice()).sum();
System.out.println(sumObject);
// filter
int filteredObject = products.stream().filter(x -> x.getCategory() == "A").mapToInt(x -> x.getPrice()).sum();
System.out.println(filteredObject);
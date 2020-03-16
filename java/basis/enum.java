/**
 * Enum
 */
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

List<Product> products = Arrays.asList(
    new Product("A","apple",100),
    new Product("B","hammer",900),
    new Product("A","grape",150),
    new Product("C","TV",30000)
    );
    
// Enumを使わない場合
for (Product product : products) {
    if (product.getCategory() == "A") {
        System.out.println("フルーツ");
    } else if (product.getCategory() == "B") {
        System.out.println("工具");
    } else {
        System.out.println("その他");
    }
}

// Enumを使った場合
enum CategoryType {
    Fruits("A", "フルーツ"), 
    Tool("B", "工具"),
    ;

    private String categoryCode;
    private String categoryName;

    private CategoryType(String categoryCode, String categoryName) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
    }

    public String getCategoryCode() {
        return this.categoryCode;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public static String getCategoryNameByCode(String code) {
        for (CategoryType type : CategoryType.values()) {
            if (type.getCategoryCode().equals(code)) {
                return type.getCategoryName();
            }
        }
        return "その他";
    }
}

System.out.println("---");

for (Product product : products) {
    String value = CategoryType.getCategoryNameByCode(product.getCategory());
    System.out.println(value);
}

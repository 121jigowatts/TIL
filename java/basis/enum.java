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

System.out.println("---");


interface Status {
    String getColor();
}

class Todo implements Status {
    public String getColor() {
        return "RED";
    }
}

class Doing implements Status {
    public String getColor() {
        return "BLUE";
    }
}

class Done implements Status {
    public String getColor() {
        return "GREEN";
    }
}

class Close implements Status {
    public String getColor() {
        return "YELLOW";
    }
}

public enum StateType {
    TODO(new Todo()),
    DOING(new Doing()),
    DONE(new Done()),
    CLOSE(new Close())
    ;

    private Status status;

    private StateType(Status status) {
        this.status = status;
    }

    public String getStatusColor() {
        return this.status.getColor();
    }
}

class Item {
    private String title;
    private StateType state;
    private StateType previousState;
    private boolean closed;

    public Item(String title, StateType state) {
        this.title = title;
        this.state = state;
        this.closed = false;
    }

    public String getStatus() {
        String text = this.state.name();
        String color = this.state.getStatusColor();
        return String.format("[STATUS:%s]<%s>", text, color);
    }

    public StateType move(StateType state) {
        this.changeStatus(state);
        return this.state;
    }

    public StateType close() {
        this.closed = true;
        this.changeStatus(StateType.CLOSE);
        return this.state;
    }
    
    public boolean isClosed() {
        return this.closed;
    }
    
    public void restore() {
        if (isClosed()) {
            this.closed = false;
            this.state = this.previousState;
        }
    }
    
    private void changeStatus(StateType state) {
        this.previousState = this.state;
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.title, this.getStatus());
    }
}

StateType state = StateType.TODO;
Item task01 = new Item("Unit Test", state);
System.out.println(task01.toString());
task01.close();
task01.restore();
System.out.println(task01.toString());

task01.move(StateType.DOING);
System.out.println(task01.toString());

task01.move(StateType.DONE);
System.out.println(task01.toString());

task01.close();
if (task01.isClosed()) {
    System.out.println(task01.toString());

    task01.restore();
    System.out.println(task01.toString());

    task01.restore();
    System.out.println(task01.toString());
}
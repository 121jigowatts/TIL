class MyFunction implements Function<String, Item> {
    @Override
    public Item apply(String s) {
        if (s == "a") { return new AItem();}
        if (s == "b") { return new BItem();}
        if (s == "c") { return new CItem();}
        return new Item();
    }
}

class Item {

}
class AItem extends Item {
    public AItem() {
        System.out.println("AItem");
    }
}
class BItem extends Item {
    public BItem() {
        System.out.println("BItem");
    }
}
class CItem extends Item {
    public CItem() {
        System.out.println("CItem");
    }
}
List<String> strings = Arrays.asList("a","b","c");

var m = strings.stream().map(new MyFunction()).collect(Collectors.toList());

m.stream().forEach(System.out::println);
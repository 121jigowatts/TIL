public enum MyTypes {
    TypeA("01","タイプA"),
    TypeB("02","タイプB"),
    TypeC("03","タイプC");

    private String categoryCode;
    private String categoryName;

    private MyTypes(String categoryCode, String categoryName) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
    }

    public String getCategoryCode() {
        return this.categoryCode;
    }

    public String getCategoryName() {
        return this.categoryName;
    }
}

System.out.println(MyTypes.TypeA.getCategoryCode());
System.out.println(MyTypes.TypeA.getCategoryName());
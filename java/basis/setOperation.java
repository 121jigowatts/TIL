Set<String> collection1 = Set.of("001","002","003","004");
Set<String> collection2 = Set.of("002","003","004","005");

void display(String prefix, Set<String> collection) {
    var joinStr = String.join(",", collection);
    System.out.println(String.format("%s: %s",prefix, joinStr));
}

display("集合1", collection1);
display("集合2", collection2);


// 和集合
Set<String> union(Set<String> collection1, Set<String> collection2) {
    Set<String> copyCollection1 = new HashSet<>(collection1);
    Set<String> copyCollection2 = new HashSet<>(collection2);

    copyCollection1.addAll(copyCollection2);

    return copyCollection1;
}

// 差集合
Set<String> setDifference(Set<String> collection1, Set<String> collection2) {
    Set<String> copyCollection1 = new HashSet<>(collection1);
    Set<String> copyCollection2 = new HashSet<>(collection2);

    copyCollection1.removeAll(copyCollection2);

    return copyCollection1;
}

// 積集合
Set<String> intersect(Set<String> collection1, Set<String> collection2) {
    Set<String> copyCollection1 = new HashSet<>(collection1);
    Set<String> copyCollection2 = new HashSet<>(collection2);

    copyCollection1.retainAll(copyCollection2);

    return copyCollection1;
}

// 排他的論理和集合
Set<String> symmetricDifference(Set<String> collection1, Set<String> collection2) {
    Set<String> copyCollection1 = new HashSet<>(collection1);
    Set<String> copyCollection2 = new HashSet<>(collection2);

    // 和集合を作成
    var union = union(copyCollection1, copyCollection2);

    // 積集合を作成
    var intersect = intersect(copyCollection1, copyCollection2);

    // 和集合から積集合を引く
    var setDifference = setDifference(union, intersect);

    return setDifference;
}

// 和集合
System.out.println("<Union>");
var union = union(collection1, collection2);
display("集合1と集合2の和", union);

// 差集合
System.out.println("<Set difference>");
var setDifference = setDifference(collection1, collection2);
display("集合1から集合2を引いた差", setDifference);

// 積集合
System.out.println("<Intersect>");
var intersect = intersect(collection1, collection2);
display("集合1と集合2どちらにも含まれる", intersect);

// 排他的論理和集合
System.out.println("<Symmetric difference>");
var symmetricDifference = symmetricDifference(collection1, collection2);
display("集合1もしくは集合2にのみ存在する", symmetricDifference);

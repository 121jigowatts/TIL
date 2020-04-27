// 固定サイズのリスト
var arraysAsList = Arrays.asList("a","b","c");

// 要素の変更は可能
arraysAsList.set(0,"x");

// 要素の追加不可
// 例外java.lang.UnsupportedOperationException
// arraysAsList.add("d");

System.out.println(arraysAsList);


// 変更不可のリスト
var listOf = List.of("a","b","c");
// 例外java.lang.UnsupportedOperationException
// listOf.set(0,"x");
// listOf.add("d");
System.out.println(listOf);


// インスタンス化時に初期値
var listInit = new ArrayList<String>(){
    {
        add("a");
        add("b");
        add("c");
    }
};
listInit.add("d");
listInit.set(0,"x");
System.out.println(listInit);

// コンストラクタにリストを渡して初期化
var listConstructor = new ArrayList<>(Arrays.asList("a", "b", "c"));
listConstructor.add("e");
listConstructor.set(1,"y");
System.out.println(listConstructor);
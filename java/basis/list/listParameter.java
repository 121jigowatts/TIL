void display(String message, int hashCode, String value) {
  System.out.println(String.format("[%s] (%s): %s", message, hashCode, value));
}

void addList(List<String> arg) {
  // 参照の値を退避
  var tmp = arg;  
  display("called", System.identityHashCode(arg), arg.toString());
  
  arg.add("first");
  display("first", System.identityHashCode(arg), arg.toString());
  // この時点までは呼び出し元のリストに値がセットされる

  // 変数argを初期化したArrayListで書き換え空のリストに（別オブジェクト）
  arg = new ArrayList<>();
  display("new", System.identityHashCode(arg), arg.toString());

  // 1要素目として追加される
  arg.add("second");
  display("second", System.identityHashCode(arg), arg.toString());

  // 呼び出し元のリストの参照に戻す
  arg = tmp;
  // 呼び出し元のリストに要素が追加される
  arg.add("third");
  display("third", System.identityHashCode(arg), arg.toString());
}


var list = new ArrayList<String>();
// リストに1要素目を追加
list.add("init");
display("start", System.identityHashCode(list), list.toString());
// メソッドの引数としてリストを指定
addList(list);
// リストの中身が追加される
display("end", System.identityHashCode(list), list.toString());

// addList(list);
// display("more", System.identityHashCode(list), list.toString());

var arr = Arrays.asList("banana", "apple", "mango", "kiwi", "peach", "cherry", "lemon");

System.out.println(arr.stream().collect(Collectors.joining()));
System.out.println(arr.stream().collect(Collectors.joining("-")));
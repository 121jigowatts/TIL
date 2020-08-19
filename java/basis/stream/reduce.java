var arr = Arrays.asList("a","b", "c");

var result = arr.stream().reduce((tmp, value) -> {
        System.out.println("tmp=" + tmp + ", value=" + value);
        return tmp + ":" + value;
    });

System.out.println(result.get());
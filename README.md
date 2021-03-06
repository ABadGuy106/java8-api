# Java8 新特性

## Lambda表达式

Lambda是一个匿名函数，我们可以把Lambda表达式理解为是一段可以传递的代码（将代码像数据一样进行传递）。可以写出更简洁、更灵活的代码。作为一种更紧凑的代码风格，是Java的语言表达能力得到提升。

## Java内置四大核心函数式接口

| 函数式接口                | 参数类型 | 返回类型 | 用途                                                         |
| ------------------------- | -------- | -------- | ------------------------------------------------------------ |
| Consumer<T>消费型接口     | T        | void     | 对类型为T的对象应用操作，包含方法: void accept(T t)          |
| Supplier<T> 供给型接口    | 无       | T        | 返回类型为T的对象，包含方法：t get()                         |
| Function<T，R> 函数型接口 | T        | R        | 对类型为T的对象应用操作，并返回结果。结果包含R类型的对象。包含方法 R apply(T t) |
| Predicate<T> 断定型接口   | T        | boolean  | 确定类型为T的对象是否满足某约束，并返回boolean值。包含方法 boolean test(T t); |

## Stream

Stream是Java8对集合数据进行操作，就类似与使用SQL执行的数据库查询。也可以使用Stream API来并行执行操作。简而言之，Stream API提供了一种高效且易于使用的处理数据的方式。

流(Stream)到底是什么？

是数据渠道，用于操作数据源(集合、数组等)所生成的元素序列

“集合讲的是数据，流讲的是计算”

注意：

- Stream 自己不会存储元素
- Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream
- Stream 操作是延迟执行的。这意味这他们会等到需要结果的时候才执行。

### Stream的操作三个步骤

1. 创建 Stream

   一个数据源(如：集合、数组)，获取一个流

2. 中间操作

   一个中间操作链，对数据源的数据进行处理

3. 终止操作(终端操作)

   一个终止操作，执行中间操作链，并产生结果

![](img\java8-01.PNG)
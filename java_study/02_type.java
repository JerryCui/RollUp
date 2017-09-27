/*
 * 1. 强类型：
 *   值传递必须在相同的类型变量之间进行，而且此处的类型一致性是严格的，也就是说不能将浮点数值赋值给一个整数型。
 *	 强制的类型检查会在编译阶段进行，有不一致就无法编译通过。
 */	

/*
 * 2.数据类型：
 *
 * 1）整数类型	    
 *   byte（字节型），short（短整型），int（整型），long（长整型）皆为有符号，java不支持仅仅是正的无符号整数，也就是说没有代表整数符号的符号位，通过无符号运算符来管理高位。
 *  a):byte
 *		长度8位，范围-128~127，主要用于网络数据交互和二进制相关的苏数据处理
 *	b):short
 *		长度16位，范围-32768~32767，big-endian,比较少用。
 *	c):int
 *		长度32位，范围-2147483648~2147483647，
 *	d):long
 *		长度64位，范围相当大，
 * 2）浮点型数
 *	float（浮点型），double（双精度）代表有小数精度要求的数字。
 *	java实现了IEEE-754的浮点型和运算符集
 *	a):float
 *		单精度浮点型，长度32位，范围3.4E-038~3.4E+038,比双精度的运算速度要快，而且只占用双精度一半的空间，值很大或很小时不精确。
 *	b):double
 *		双精度浮点型，长度64位，多数用于复杂的数学计算。
 * 3）字符型
 *	char
 *	长度16位，采用unicode编码，ascii码的范围仍是0~127，扩展的8位字符集仍是0~255.可以进行整型的运算。
 *		
 * 4）布尔型
 *	boolean
 *	就是true和false
 */

/*
 * 3. 字面量
 *	1) 整数字面量：
 *		数字的值就是一个整数的字面量
 *		使用字面类型赋值时只要不超出类型的可表达范围就不会报类型错误的error，但是指定一个整数字面的时候就需要告诉编译器，如：0,0x，L等。
 *	2） 浮点字面量：
 *		标准计数法和科学计数法都支持。
 *	
 *	3) 布尔型字面量:
 *		真不是1，假不是0
 *	4）字符字面量
 *		字符+单引号来表示字符字面量
 *	5）字符串字面量
 *		字符串+双引号
 *		字符串不是数组和指针而是一个对象，不能像数组那样使用
 */

/*
 * 4. 变量
 *	与C语言的定义使用无异。可以在程序块中的任何位置被定义，但是内部作用域与外部作用域中不能有重命名的定义。
 *	变量的作用域与C语言无异，只是全局变量例外。
 */	

/*
 * 5. 类型转换和强转
 *	如果类型兼容，java自动进行隐式转换。
 *	不兼容的类型转换就需要使用强制类型转换完成显示类型转换。
 *	1）自动类型转换
 *		满足条件：
 *			a):两种类型是兼容
 *			b):目的类型的范围要比来源类型的范围广。
 *		非兼容的类型有：double和byte，数字类型和char，数字类型和boolean，char和boolean。
 *
 *	2） 强制类型转换
 *		也称为缩小转换。
 *		如果来源类型数值超出目标类型的范围，将会对来源类型数值对目标类型数取模,即%=运算
 *
 *	3） 类型的自动提升
 *
 *		--- 分析表达式时，java自动提升各个byte型或者short型的操作数到int型。
 *
 *		a): 类型提升规则
 *			1> byte和short自动提升为int
 *			2> 如果一个表达式中有long或float或double整个表达式将自动提升到long或float或double。
 *
 *	4） 数组
 *		一维数组：
 *		与C和C++的数组的工作原理不同。
 *		获取数组的两个步骤：先定义变量，然后使用new来分配内存，并链接给数组变量。数组是可以在声明的时候被初始化的，获得数组也不必非要两个步骤了。数组是动态分配的，即动态数组。数组下标是从0开始的。
 *		多维数组：
 *			数组的数组，允许锯齿形的数组存在（即C中的指针数组）
 *		另一种声明方法：
 *			type[] var-name;
 *			
 *		java.util.Arrays 类的static方法
 *		equals()-- 判断两个数组是否相等，包括个数和相同位置的元素。
 *		fill()--填充数组
 *		asList()--将数组转换为list容器
 *		sort()-- 对数组进行升序排序
 *			
 *	5) 字符串String
 *		与C不同的是 String 是一种对象类型，也可以用String来定义字符串数组
 *		操作：
 *			1> 拷贝-- 使用trim()进行拷贝操作。
 *			
 *	6) 指针
 *		java不支持指针。
 */		

/*
 * 6. 泛型 -- generics (通用）, 泛型只在编译时刻有效；编译时刻编译器会把T替换成Object
 *  1) 泛型类 -- 为解决装入不同类型元素的问题，出现的动机是为了创建容器类
 */

    public class Box {
        private String object; // 非泛型类就只能装入String 类型的元素，若想装入其他类型的（int）元素，只能重新写一个类；
        public void set(String object) { this.object = object; }
        public String get() { return object; }
    } 

    public class Box<T> {
        // T stands for "Type"
        // 把类需要装入的元素类型泛化，通用化，这样可以简单的复用类中的处理逻辑
        private T t;
        public void set(T t) { this.t = t; }
        public T get() { return t; }
    }

    Box<Integer> integerBox = new Box<Integer>();
    Box<Double> doubleBox = new Box<Double>();
    Box<String> stringBox = new Box<String>();

/* 
 * 3) 泛型接口 -- 
 */
    public interface Generator<T> {
        public T next();
    }

    public class FruitGenerator implements Generator<String> {

        private String[] fruits = new String[]{"Apple", "Banana", "Pear"};

        @Override
        public String next() {
            Random rand = new Random();
            return fruits[rand.nextInt(3)];
        }
    }

    public class Main {

        public static void main(String[] args) {
            FruitGenerator generator = new FruitGenerator();
            System.out.println(generator.next());
            System.out.println(generator.next());
            System.out.println(generator.next());
            System.out.println(generator.next());
        }
    }

//另一个例子
    public interface Comparable<T> {
        public int compareTo(T o);
    }

    // 边界：
    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
            if (e.compareTo(elem) > 0)
                ++count;
        return count;
    }

	
/*
 * 4) 泛型方法 -- 声明方法时只需要在方法返回的类型前面加入需要泛化的类型即可<K, V>
 *                尽量使用泛型方法
 */
    public class Util {
        public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
            return p1.getKey().equals(p2.getKey()) &&
                   p1.getValue().equals(p2.getValue());
        }
    }
    public class Pair<K, V> {
        private K key;
        private V value;
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public void setKey(K key) { this.key = key; }
        public void setValue(V value) { this.value = value; }
        public K getKey()   { return key; }
        public V getValue() { return value; }
    }
//调用如下：
    Pair<Integer, String> p1 = new Pair<>(1, "apple");
    Pair<Integer, String> p2 = new Pair<>(2, "pear");
    boolean same = Util.compare(p1, p2);

//另一个例子：
    public class Main {

        public static <T> void out(T... args) {
            for (T t : args) {
                System.out.println(t);
            }
        }

        public static void main(String[] args) {
            out("findingsea", 123, 11.11, true);
        }
    }


/*
 * 5) 通配符 -- 能够提供更好的API; 为了替换继承关系的类型
 * <? extends T> -- 只能get
 * <? super T> -- 只能add
 * PECS 原则: producer extends, consumer super //其中的producer 和 consumer 应该理解为对象的produce和consume
 */
    static class CovariantReader<T> {
        T readCovariant(List<? extends T> list) {
            return list.get(0);
        }
    }		
			
/* 
 * 6) 类型擦除 -- 指的是编译时刻对泛型的替换；类似于C语言中的宏定义
 *                  其中所有泛型如不特别bound都会被替换成Object
 *                  使用泛型时需要重视编译器提示的"unchecked warning"
 *                  泛型代码不能使用instanceof关键字, 因为instanceof 是运行时计算的, 而泛型在编译时已经进行了类型擦除
 */
    //使用Comparable<T>来避免类型擦除后被替换成Object类型无法使用原类型
    public class Node<T extends Comparable<T>> {
        private T data;
        private Node<T> next;
        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
        public T getData() { return data; }
        // ...
    }

    // 编译后为 
    // TODO:  ?? 这里的Comparable 具体该如何实现，如何使用?
    public class Node {
        private Comparable data;
        private Node next;
        public Node(Comparable data, Node next) {
            this.data = data;
            this.next = next;
        }
        public Comparable getData() { return data; }
        // ...
    }


//不允许创建泛型数组, 以下定义编译器会报错
    List<Integer>[] arrayOfLists = new List<Integer>[2]; 
//但使用通配符则是合法的
    List<Integer>[] arrayOfLists = new List<?>[2]; 
//泛型类不能够直接new对象, 可以使用以下方式:
    public static <E> void append(List<E> list, Class<E> cls) throws Exception {
        E elem = cls.newInstance();?? // OK
        list.add(elem);
    }




/** 
 * 1. 空白分隔符 whitespace
 *	不需要遵循任何缩进规范。但是必须在已经被运算符或分隔符描述的标记之间至少留出一个空白分隔符。
 */

/**
 * 2. 标识符 identifiers
 *	class\function\varible 的名字，可以是大写、小写、数字、下划线、美元符号$的任意组合，但是不能以一个数字开始。
 */	

/**
 * 3. 常量 literal
 *	与C语言无异
 */	

/** 
 * 4. 注释 comments
 *	//和/* '*'/均可
 */

/** 
 * 5. 分隔符 separators
 *	(),{},[],;,,. 基本与C语言一致。
 */

/**
 * 6. 关键字
 *	const和goto     -- 属于关键字，但从不使用；
 *	import          --
 *	extends         -- 继承
 *	synchronized    -- 
 *	final           -- 保留关键字, 被声明为final的引用将不能被修改(重写)
 */

 //final变量将不能被重新初始化, 其初始化必须在声明的时候或构造器中进行或调用this()方法进行初始化; interface中所有声明的变量是final的；
 //final变量一般认为是静态，命名通常需要大写
    public static final String METHOD = "method";
    METHOD = new String("method"); //invalid compilation error 
//final方法是不能被子类修改的, 一般认为不需要子类进行重载和修改的方法; 比非final方法要快, 因为在编译的时候静态绑定, 不需要再运行时动态绑定;
//
//final类是不能被继承的类, 如:String Interger; final 和 abstract 的相反的
/* ----- final变量可以被jvm缓存和优化, 提高性能; final引用可以在多线程下共享访问时不需要额外的同步开销;

/*
 *  方法的关键字         this-class   this-package   sub-class   other-package  
 *       public              yes         yes             yes         yes 
 *       protected           yes         yes             yes         no
 *       friendly            yes         yes             no          no 
 *       private             yes         no              no          no 
 */	
	
	

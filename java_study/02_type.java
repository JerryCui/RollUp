/*
 * 1. ǿ���ͣ�
 *   ֵ���ݱ�������ͬ�����ͱ���֮����У����Ҵ˴�������һ�������ϸ�ģ�Ҳ����˵���ܽ�������ֵ��ֵ��һ�������͡�
 *	 ǿ�Ƶ����ͼ����ڱ���׶ν��У��в�һ�¾��޷�����ͨ����
 */	

/*
 * 2.�������ͣ�
 *
 * 1����������	    
 *   byte���ֽ��ͣ���short�������ͣ���int�����ͣ���long�������ͣ���Ϊ�з��ţ�java��֧�ֽ����������޷���������Ҳ����˵û�д����������ŵķ���λ��ͨ���޷���������������λ��
 *  a):byte
 *		����8λ����Χ-128~127����Ҫ�����������ݽ����Ͷ�������ص������ݴ���
 *	b):short
 *		����16λ����Χ-32768~32767��big-endian,�Ƚ����á�
 *	c):int
 *		����32λ����Χ-2147483648~2147483647��
 *	d):long
 *		����64λ����Χ�൱��
 * 2����������
 *	float�������ͣ���double��˫���ȣ�������С������Ҫ������֡�
 *	javaʵ����IEEE-754�ĸ����ͺ��������
 *	a):float
 *		�����ȸ����ͣ�����32λ����Χ3.4E-038~3.4E+038,��˫���ȵ������ٶ�Ҫ�죬����ֻռ��˫����һ��Ŀռ䣬ֵ�ܴ���Сʱ����ȷ��
 *	b):double
 *		˫���ȸ����ͣ�����64λ���������ڸ��ӵ���ѧ���㡣
 * 3���ַ���
 *	char
 *	����16λ������unicode���룬ascii��ķ�Χ����0~127����չ��8λ�ַ�������0~255.���Խ������͵����㡣
 *		
 * 4��������
 *	boolean
 *	����true��false
 */

/*
 * 3. ������
 *	1) ������������
 *		���ֵ�ֵ����һ��������������
 *		ʹ���������͸�ֵʱֻҪ���������͵Ŀɱ�ﷶΧ�Ͳ��ᱨ���ʹ����error������ָ��һ�����������ʱ�����Ҫ���߱��������磺0,0x��L�ȡ�
 *	2�� ������������
 *		��׼�������Ϳ�ѧ��������֧�֡�
 *	
 *	3) ������������:
 *		�治��1���ٲ���0
 *	4���ַ�������
 *		�ַ�+����������ʾ�ַ�������
 *	5���ַ���������
 *		�ַ���+˫����
 *		�ַ������������ָ�����һ�����󣬲�������������ʹ��
 */

/*
 * 4. ����
 *	��C���ԵĶ���ʹ�����졣�����ڳ�����е��κ�λ�ñ����壬�����ڲ����������ⲿ�������в������������Ķ��塣
 *	��������������C�������죬ֻ��ȫ�ֱ������⡣
 */	

/*
 * 5. ����ת����ǿת
 *	������ͼ��ݣ�java�Զ�������ʽת����
 *	�����ݵ�����ת������Ҫʹ��ǿ������ת�������ʾ����ת����
 *	1���Զ�����ת��
 *		����������
 *			a):���������Ǽ���
 *			b):Ŀ�����͵ķ�ΧҪ����Դ���͵ķ�Χ�㡣
 *		�Ǽ��ݵ������У�double��byte���������ͺ�char���������ͺ�boolean��char��boolean��
 *
 *	2�� ǿ������ת��
 *		Ҳ��Ϊ��Сת����
 *		�����Դ������ֵ����Ŀ�����͵ķ�Χ���������Դ������ֵ��Ŀ��������ȡģ,��%=����
 *
 *	3�� ���͵��Զ�����
 *
 *		--- �������ʽʱ��java�Զ���������byte�ͻ���short�͵Ĳ�������int�͡�
 *
 *		a): ������������
 *			1> byte��short�Զ�����Ϊint
 *			2> ���һ�����ʽ����long��float��double�������ʽ���Զ�������long��float��double��
 *
 *	4�� ����
 *		һά���飺
 *		��C��C++������Ĺ���ԭ��ͬ��
 *		��ȡ������������裺�ȶ��������Ȼ��ʹ��new�������ڴ棬�����Ӹ���������������ǿ�����������ʱ�򱻳�ʼ���ģ��������Ҳ���ط�Ҫ���������ˡ������Ƕ�̬����ģ�����̬���顣�����±��Ǵ�0��ʼ�ġ�
 *		��ά���飺
 *			��������飬�������ε�������ڣ���C�е�ָ�����飩
 *		��һ������������
 *			type[] var-name;
 *			
 *		java.util.Arrays ���static����
 *		equals()-- �ж����������Ƿ���ȣ�������������ͬλ�õ�Ԫ�ء�
 *		fill()--�������
 *		asList()--������ת��Ϊlist����
 *		sort()-- �����������������
 *			
 *	5) �ַ���String
 *		��C��ͬ���� String ��һ�ֶ������ͣ�Ҳ������String�������ַ�������
 *		������
 *			1> ����-- ʹ��trim()���п���������
 *			
 *	6) ָ��
 *		java��֧��ָ�롣
 */		

/*
 * 6. ���� -- generics (ͨ�ã�, ����ֻ�ڱ���ʱ����Ч������ʱ�̱��������T�滻��Object
 *  1) ������ -- Ϊ���װ�벻ͬ����Ԫ�ص����⣬���ֵĶ�����Ϊ�˴���������
 */

    public class Box {
        private String object; // �Ƿ������ֻ��װ��String ���͵�Ԫ�أ�����װ���������͵ģ�int��Ԫ�أ�ֻ������дһ���ࣻ
        public void set(String object) { this.object = object; }
        public String get() { return object; }
    } 

    public class Box<T> {
        // T stands for "Type"
        // ������Ҫװ���Ԫ�����ͷ�����ͨ�û����������Լ򵥵ĸ������еĴ����߼�
        private T t;
        public void set(T t) { this.t = t; }
        public T get() { return t; }
    }

    Box<Integer> integerBox = new Box<Integer>();
    Box<Double> doubleBox = new Box<Double>();
    Box<String> stringBox = new Box<String>();

/* 
 * 3) ���ͽӿ� -- 
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

//��һ������
    public interface Comparable<T> {
        public int compareTo(T o);
    }

    // �߽磺
    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
            if (e.compareTo(elem) > 0)
                ++count;
        return count;
    }

	
/*
 * 4) ���ͷ��� -- ��������ʱֻ��Ҫ�ڷ������ص�����ǰ�������Ҫ���������ͼ���<K, V>
 *                ����ʹ�÷��ͷ���
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
//�������£�
    Pair<Integer, String> p1 = new Pair<>(1, "apple");
    Pair<Integer, String> p2 = new Pair<>(2, "pear");
    boolean same = Util.compare(p1, p2);

//��һ�����ӣ�
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
 * 5) ͨ��� -- �ܹ��ṩ���õ�API; Ϊ���滻�̳й�ϵ������
 * <? extends T> -- ֻ��get
 * <? super T> -- ֻ��add
 * PECS ԭ��: producer extends, consumer super //���е�producer �� consumer Ӧ�����Ϊ�����produce��consume
 */
    static class CovariantReader<T> {
        T readCovariant(List<? extends T> list) {
            return list.get(0);
        }
    }		
			
/* 
 * 6) ���Ͳ��� -- ָ���Ǳ���ʱ�̶Է��͵��滻��������C�����еĺ궨��
 *                  �������з����粻�ر�bound���ᱻ�滻��Object
 *                  ʹ�÷���ʱ��Ҫ���ӱ�������ʾ��"unchecked warning"
 *                  ���ʹ��벻��ʹ��instanceof�ؼ���, ��Ϊinstanceof ������ʱ�����, �������ڱ���ʱ�Ѿ����������Ͳ���
 */
    //ʹ��Comparable<T>���������Ͳ������滻��Object�����޷�ʹ��ԭ����
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

    // �����Ϊ 
    // TODO:  ?? �����Comparable ��������ʵ�֣����ʹ��?
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


//����������������, ���¶���������ᱨ��
    List<Integer>[] arrayOfLists = new List<Integer>[2]; 
//��ʹ��ͨ������ǺϷ���
    List<Integer>[] arrayOfLists = new List<?>[2]; 
//�����಻�ܹ�ֱ��new����, ����ʹ�����·�ʽ:
    public static <E> void append(List<E> list, Class<E> cls) throws Exception {
        E elem = cls.newInstance();?? // OK
        list.add(elem);
    }




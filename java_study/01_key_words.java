/** 
 * 1. �հ׷ָ��� whitespace
 *	����Ҫ��ѭ�κ������淶�����Ǳ������Ѿ����������ָ��������ı��֮����������һ���հ׷ָ�����
 */

/**
 * 2. ��ʶ�� identifiers
 *	class\function\varible �����֣������Ǵ�д��Сд�����֡��»��ߡ���Ԫ����$��������ϣ����ǲ�����һ�����ֿ�ʼ��
 */	

/**
 * 3. ���� literal
 *	��C��������
 */	

/** 
 * 4. ע�� comments
 *	//��/* '*'/����
 */

/** 
 * 5. �ָ��� separators
 *	(),{},[],;,,. ������C����һ�¡�
 */

/**
 * 6. �ؼ���
 *	const��goto     -- ���ڹؼ��֣����Ӳ�ʹ�ã�
 *	import          --
 *	extends         -- �̳�
 *	synchronized    -- 
 *	final           -- �����ؼ���, ������Ϊfinal�����ý����ܱ��޸�(��д)
 */

 //final���������ܱ����³�ʼ��, ���ʼ��������������ʱ��������н��л����this()�������г�ʼ��; interface�����������ı�����final�ģ�
 //final����һ����Ϊ�Ǿ�̬������ͨ����Ҫ��д
    public static final String METHOD = "method";
    METHOD = new String("method"); //invalid compilation error 
//final�����ǲ��ܱ������޸ĵ�, һ����Ϊ����Ҫ����������غ��޸ĵķ���; �ȷ�final����Ҫ��, ��Ϊ�ڱ����ʱ��̬��, ����Ҫ������ʱ��̬��;
//
//final���ǲ��ܱ��̳е���, ��:String Interger; final �� abstract ���෴��
/* ----- final�������Ա�jvm������Ż�, �������; final���ÿ����ڶ��߳��¹������ʱ����Ҫ�����ͬ������;

/*
 *  �����Ĺؼ���         this-class   this-package   sub-class   other-package  
 *       public              yes         yes             yes         yes 
 *       protected           yes         yes             yes         no
 *       friendly            yes         yes             no          no 
 *       private             yes         no              no          no 
 */	
	
	

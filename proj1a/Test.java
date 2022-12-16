public class ArrayDeque<Type> {
    private Type[] items;   //用于存储对象
    private int nextFirst;  //数组开始前的标志位 类似于sentinel的prev
    private int nextLast;   //数组最后的的标志位 类似于sentinel的next
    private int size;       //数组的长度缓存

    /**
     * 无参初始化
     */
    public ArrayDeque() {
        items = (Type[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    /**
     * 深度拷贝  拷贝时重排
     * 拷贝之后改变了数组结构 将其进行了重排 不知道这样是不是符合要求
     * @param other
     */
    public ArrayDeque(ArrayDeque<Type> other) {
        items = other.items;
        resize(other.items.length,other);

    }

    /**
     * 深度拷贝  拷贝时不重
     *
     * @param other
     */

    public ArrayDeque2(ArrayDeque<Type> other) {

        items = (Type[]) new Object[other.items.length];


        int index = plusOne(other.nextFirst);
        while (index !=other.nextLast){
            items[index] = other.items[index];
            index = plusOne(index);
        }

        size = other.size;
        nextFirst = other.nextFirst;
        nextLast = other.nextLast;

    }


    /**
     * 数组根据输入的长度 和指定的Array队列 进行重建
     * src参数主要用于 拷贝其他数组进行使用
     * 重建的过程中 还进行了数组重排序
     * 将原来从索引  plusOne(nextFirst) 到  minusOne(nextLast) 区间内的值
     * 重新排序到新数组中 从索引 0 到size-1的值
     */
    private void resize(int capacity , ArrayDeque<Type> src) {
        Type[] target = (Type[]) new Object[capacity];
        int oldIndex = plusOne(src.nextFirst);

        for (int i = 0; i < src.size; i++) {
            target[i] = src.items[oldIndex];
            oldIndex = plusOne(oldIndex);
        }

        items = target;
        nextFirst = capacity - 1;
        nextLast = src.size;
        size = src.size;
    }

    /**
     * 数组扩容
     */
    private void upSize() {
        resize(size * 2);
    }

    /**
     * 数组降容
     */
    private void downSize() {
        resize(size / 2);
    }

    /**
     * 数组根据输入的长度进行重建
     * 主要针对自己的Array队列进行扩容和降容操作
     * 函数内容是调用了重载方法 并使用了this作为默认值
     * @param capacity
     */
    private void resize(int capacity) {
        resize(capacity,this);
    }

    /**
     * 数组是否扩容判定
     *
     * @return
     */
    private boolean isFull() {
        return size == items.length;
    }

    /**
     * 数组是否降容判定
     * 主要依据为数组的存储效率
     * 当数组容量大于16 且数组中存放item的数目size 小于整个数组空间的25%
     * 会将数组降容 以节省空间
     *
     * @return
     */
    private boolean isSparse() {
        return items.length >= 16 && size < (items.length / 4);
    }

    /**
     * 在双端队列中 是由循环关系的
     * 因此 nextFirst nextLast 不能只考虑 自增和自减
     * 要把循环考虑进去
     *
     * @param index
     * @return
     */
    private int plusOne(int index) {
        return (index + 1) % items.length;
    }

    private int minusOne(int index) {
        return (index - 1 + items.length) % items.length;
    }

    /**
     * 首位添加
     *
     * @param item
     */
    public void addFirst(Type item) {
        if (isFull()) upSize();
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size++;

    }

    /**
     * 末位添加
     *
     * @param item
     */
    public void addLast(Type item) {
        if (isFull()) upSize();
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size++;

    }

    /**
     * 空集判定
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 长度输出
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 打印数组
     */
    public void printDeque() {

        int itemIndex = plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            System.out.print(items[itemIndex] + "     ");
            itemIndex = plusOne(itemIndex);
        }

        System.out.println();

    }

    /**
     * 移除首项
     * 同时判断数组的存储效率
     * 存储效率过低会考虑降容
     *
     * @return
     */
    public Type removeFirst() {
        nextFirst = plusOne(nextFirst);

        Type returnItem = items[nextFirst];
        items[nextFirst] = null;
        size--;

        if (isSparse()) downSize();
        return returnItem;
    }

    /**
     * 移除尾项
     * 同时判断数组的存储效率
     * 存储效率过低会考虑降容
     *
     * @return
     */
    public Type removeLast() {

        nextLast = minusOne(nextLast);
        Type returnItem = items[nextLast];

        items[nextLast] = null;
        size--;

        if (isSparse()) downSize();

        return returnItem;

    }

    /**
     * 获取指定索引的item
     * Array队列的优势就在于不需要迭代 直接通过索引即可查找得到
     *
     * @param index
     * @return
     */
    public Type get(int index) {
        if (index >= size) {
            return null;
        }
        int start = plusOne(nextFirst);
        return items[(start + index) % items.length];

    }


    public static void main(String[] args) {

        ArrayDeque<Integer> L = new ArrayDeque<>();
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(15);
        L.addLast(20);
        L.addLast(30);
        L.addLast(40);
        L.addLast(50);
        L.addLast(60);
        L.addLast(70);
        L.addLast(80);

        ArrayDeque<Integer> L1 = new ArrayDeque<>(L);

        System.out.println(L1.isEmpty());

        L.printDeque();
        L1.printDeque();
        System.out.println(L1.removeFirst());
        L.printDeque();
        L1.printDeque();
        System.out.println(L1.removeLast());
        L.printDeque();
        L1.printDeque();
        System.out.println(L1.get(1));
    }
}

import java.util.Arrays;

/**
 * 自定义最大堆 ;优先级高的(数值大的)在上面
 */
public class MaxHeap<T extends Comparable<T>> {
    // 数组作为底层数据结构
    private T[] data;
    private int size;

    public MaxHeap() {
        this.size = 0;
        this.data = (T[]) new Comparable[100];
    }

    public MaxHeap(T[] array) {
        if (array == null || array.length == 0) return;
        // 复制一份数组
        this.data = Arrays.copyOf(array, array.length);
        this.size = array.length;
        // 这里调用数组转换堆的方法
        heapifyArray(this.data);
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getSize() {
        return this.size;
    }

    public int getParentIndex(int index) {
        // 需排除根结点索引
        if (index == 0) {
            return -1;
        }
        if (index < 0) {
            throw new RuntimeException("Index out of bounds");
        }
        return (index - 1) / 2;
    }

    public int getLeftIndex(int index) {
        if (index < 0) {
            throw new RuntimeException("Index out of bounds");
        }
        return (2 * index) + 1;
    }

    public int getRightIndex(int index) {
        if (index < 0) {
            throw new RuntimeException("Index out of bounds");
        }
        return (2 * index) + 2;
    }

    // 获取优先级最高节点
    public T getFrontNode() {
        return isEmpty() ? null : this.data[0];
    }

    /**
     * 添加节点:按照最大堆的规定,优先级高的在上面
     */

    /**
     * 添加节点
     * 方法1 -- 交换式
     * @param ele 添加的元素
     */
    public void addEleMethod1(T ele) {
        // 先把元素挂接到树上
        data[size] = ele;
        size += 1;
        //调用元素上浮方法1;
        floatUp1();
    }

    /**
     * 元素上浮方法1
     */
    private void floatUp1() {
        int currentIndex = size - 1;   // 刚添加的元素索引
        int parentIndex = getParentIndex(currentIndex);

        // 若当前节点的值比父节点还大,就一直交换
        while (currentIndex > 0 && data[currentIndex].compareTo(data[parentIndex]) > 0) {
            swapEle(data, currentIndex, parentIndex);
            // 更新
            currentIndex = parentIndex;
            parentIndex = getParentIndex(currentIndex);
        }
    }

    /**
     * 数组内交换元素
     *
     * @param array 数组
     * @param pre   要交换的节点索引
     * @param res   被交换的节点索引
     */
    private void swapEle(T[] array, int pre, int res) {
        T tmp = array[res];
        array[res] = array[pre];
        array[pre] = tmp;
    }

    /**
     * 添加节点
     * 方法2 -- 覆盖式
     * @param ele 添加的元素
     */
    public void addEleMethod2(T ele) {
        // 先把元素挂到树上
        data[size] = ele;
        size++;
        //调用 元素上浮方法2 这里需传参
        floatUp2(ele);
    }

    /**
     * 元素上浮方法2
     * 在这个方法内不是进行元素交换,而是要进行覆盖
     *
     * @param ele 指定要添加的元素
     */
    private void floatUp2(T ele) {
        // 刚添加的元素位置（要操作的节点索引）
        int currentIndex = size - 1;
        int parentIndex = getParentIndex(currentIndex);

        while (currentIndex > 0 && ele.compareTo(data[parentIndex]) > 0) {
            // 让父节点的值覆盖操作的节点
            data[currentIndex] = data[parentIndex];
            // 更新操作的节点
            currentIndex = parentIndex;
            // 父节点索引更新
            parentIndex = getParentIndex(currentIndex);
        }
        // 切记,这里需把添加的索引放到最后一次更新的操作节点索引位置
        data[currentIndex] = ele;
    }

    /**
     * 取出优先级最高的节点
     * 方法1 -- 交换式
     */
    public T pollMaxPriorityMethod1() {
        if (isEmpty()) {
            throw new RuntimeException("This heap is empty");
        }
        T temp = this.data[0];
        // 将最后一个元素放到根结点的位置
        this.data[0] = data[size - 1];
        size -= 1;
        moveDown1();
        return temp;
    }

    /**
     * 元素下移方法 1
     */
    private void moveDown1() {
        if (isEmpty()) {
            return;
        }
        int currentIndex = 0;
        int leftIndex = getLeftIndex(currentIndex);
        int rightIndex = getRightIndex(currentIndex);

        // 左右子节点高优先级节点索引 首先默认为左
        int maxPriorityLeftRight = leftIndex;

        // 找合适位置,直到遇到 优先级比它小的 或 到达叶子节点
        while (leftIndex < size) {
            if (rightIndex < size && data[leftIndex].compareTo(data[rightIndex]) < 0) {
                maxPriorityLeftRight = rightIndex;
            }

            // 遇到优先级比它小的 直接结束
            if (data[currentIndex].compareTo(data[maxPriorityLeftRight]) > 0) {
                return;
            }
            // 交换
            swapEle(data, currentIndex, maxPriorityLeftRight);
            //更新
            currentIndex = maxPriorityLeftRight;
            leftIndex = getLeftIndex(currentIndex);
            rightIndex = getRightIndex(currentIndex);
            maxPriorityLeftRight = leftIndex;
        }
    }

    /**
     * 取出优先级最高的节点
     * 方法 2 -- 覆盖式
     */
    public T pollMaxPriorityMethod2() {
        if (isEmpty()) {
            throw new RuntimeException("This heap is empty");
        }
        T temp = this.data[0];
        this.data[0] = data[size - 1];
        size--;
        moveDown2();
        return temp;
    }

    /**
     * 用新节点替换root
     *
     * @param ele 新节点
     */
    public void replace(T ele) {
        // 直接覆盖掉root
        this.data[0] = ele;
        moveDown2();
    }

    /**
     * 元素下移方法 2 (覆盖式
     */
    private void moveDown2() {
        if (isEmpty()) {
            return;
        }
        int currentIndex = 0;
        int leftIndex = getLeftIndex(currentIndex);
        int rightIndex = getRightIndex(currentIndex);
        int maxPriorityLeftRight = leftIndex;
        T root = this.data[0];

        while (leftIndex < this.size) {
            if (rightIndex < this.size && data[leftIndex].compareTo(data[rightIndex]) < 0) {
                maxPriorityLeftRight = rightIndex;
            }

            // 结束点(当遇到优先级比这个根结点优先级还小)
            if (root.compareTo(data[maxPriorityLeftRight]) > 0) {
                break;       // 注意这里直接结束这层循环,并不是终止代码
            }

            // 覆盖当前操作节点
            data[currentIndex] = data[maxPriorityLeftRight];
            // 更新
            currentIndex = maxPriorityLeftRight;
            leftIndex = getLeftIndex(currentIndex);
            rightIndex = getRightIndex(currentIndex);
            maxPriorityLeftRight = leftIndex;
        }
        // 切记结束前还要把之前的那个最小值放入最后一次更新的操作节点位置
        data[currentIndex] = root;
    }

    /**
     * 将数组转换为堆结构
     *
     * @param array 要转的数组
     */
    private void heapifyArray(T[] array) {
        int lastIndex = array.length - 1;    // 最后一位节点
        int parentIndex = getParentIndex(lastIndex);

        for (int currentIndex = parentIndex; currentIndex >= 0; currentIndex--) {
            // 有一点改动 重写个搭配的下移方法3
            moveDown3(array, currentIndex);
        }
    }

    /**
     * 元素下移
     * 方法 3
     *
     * @param array             操作数组
     * @param startcurrentIndex 当前要进行下移操作的节点索引
     */
    private void moveDown3(T[] array, int startcurrentIndex) {
        int currentIndex = startcurrentIndex;
        int leftIndex = getLeftIndex(currentIndex);
        int rightIndex = getRightIndex(currentIndex);
        int maxPriorityIndex = leftIndex;

        while (leftIndex < array.length) {
            if (rightIndex < array.length && data[leftIndex].compareTo(data[rightIndex]) < 0) {
                maxPriorityIndex = rightIndex;
            }

            if (data[currentIndex].compareTo(data[maxPriorityIndex]) > 0) {
                return;
            }
            swapEle(array, currentIndex, maxPriorityIndex);
            currentIndex = maxPriorityIndex;
            leftIndex = getLeftIndex(currentIndex);
            rightIndex = getRightIndex(currentIndex);
            maxPriorityIndex = leftIndex;
        }
    }

    /**
     * 完成堆排
     * @param array 要进行堆排序的数组
     */
    public T[] heapSortArray1(T[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("Invalid array");
        }
        // 构造堆 调用 -(添加节点--方法1
        Arrays.stream(array).forEach(this::addEleMethod2);
        int i = 0;
        // 依次取出堆的优先级最高的节点放入数组
        while (!isEmpty()) {
            // 调用 -(取出根结点--方法1
            array[i++] = this.pollMaxPriorityMethod1();
        }
        return array;
    }

    /**
     * 输出堆元素
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]);
            if (i != size - 1) {
                stringBuilder.append("->");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

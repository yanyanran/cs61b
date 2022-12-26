package synthesizer;

// 使用ArrayRingBuffer<Double>实现 Karplus-Strong 算法 来合成吉他弦音
public class GuitarString {
    private static final int SR = 44100;      // 采样率
    private static final double DECAY = .996; // 能量衰减因子
    private BoundedQueue<Double> buffer;  // 用于存储声音数据的缓冲区

    /**
     * 创建给定频率的吉他弦
     * */
    public GuitarString(double frequency) {
        // TODO: 创建容量 = SR / 频率的缓冲区。你需要将此除法运算的结果转换为 int。为了更好的
        //       准确性，在转换前使用 Math.round() 函数。
        //       你的缓冲区最初应该用零填充。
        int capacity = (int) Math.round(SR / frequency);
        buffer = new ArrayRingBuffer<>(capacity);

        for(int i = 0; i < buffer.capacity(); i++) {
            buffer.enqueue(0.0);
        }
    }

    /**
     * 通过用白噪声替换缓冲器来拨动吉他弦
     * */
    public void pluck() {
        // TODO: 将缓冲区中的所有内容出队，并用随机数替换它在 -0.5 和 0.5 之间。
        //       您可以使用以下方法获得这样的数字：
        //       double r = Math.random() - 0.5;
        //
        //       确保随机数彼此不同
        for(int i = 0; i < buffer.capacity(); i++) {
            double r = Math.random() - 0.5;
            buffer.dequeue();
            buffer.enqueue(r);
        }
    }

    /**
     * 通过执行一次迭代将仿真推进一个时间步长(Karplus-Strong 算法
     */
    public void tic() {
        // TODO: 将前面的样本出队并入队一个新的样本
        //       两者的平均值乘以 DECAY 因子。
        //       不要调用 StdAudio.play()。.
        double before = buffer.dequeue();
        double newSample = ((before + buffer.peek()) / 2) * DECAY;
        buffer.enqueue(newSample);
    }

    /**
     *  返回缓冲区前面的双精度值
     *  */
    public double sample() {
        return buffer.peek();
    }
}
# Berkeley CS61B Spring2019 Code

## overview

Course link: https://sp19.datastructur.es/

| Projects   | Name                                         | Description                                                  |
| ---------- | -------------------------------------------- | ------------------------------------------------------------ |
| Project 0  | NBody                                        | 填充类以绘制一个可视化宇宙                                   |
| Project 1a | Data Structures                              | 使用列表LinkedList和数组Array构建双端队列                    |
| Project 1b | Applying and Testing Data Structures version | 使用Project 1a中的一个双端队列来解决现实世界中的问题         |
| Project 2a | Extrinsic MinPQ                              | 构建ArrayHeapMinPQ这个抽象数据结构（堆和优先队列）。其优先级与对象无关，不是依赖某种比较函数来决定哪个项目小于另一个，而是使用`add`/`changePriority`函数分配一个优先级值。 `changePriority`功能允许我们在添加项目后设置项目的外部优先级。 |

| Homework | Name            | Description                                                  |
| -------- | --------------- | ------------------------------------------------------------ |
| hw 1     | Sound Synthesis | 创建一个用于生成合成乐器的包。使用双端队列联合缓冲区模型实现一个吉他类GuitarString，运行GuitarHeroLite类将提供一个界面，允许用户使用es.datastructur.synthesizer包的GuitarString类交互式地播放声音 |
| hw 2     | Percolation     | 使用快速带权联合WeightedQuickUnion算法对渗透系统建模以及估计渗透阈值 |
| hw 3     | Hashing         | 重写hashcode和equals方法以改进HashMap中的Object分布          |

| Labs   | Name                               | Description                                                  |
| ------ | ---------------------------------- | ------------------------------------------------------------ |
| lab 2  | Setting Up IntelliJ                | 设置                                                         |
| lab 3  | Unit Testing with JUnit, Debugging | 单元测试、JUnit、61B 样式检查器                              |
| lab 6  | Disjoint Sets                      | 不相交集。创建UnionFind用于解决动态连接问题，实现WQU加权快速联合类，其中核心编码为union和采用路径压缩允许快速搜索时间find |
| lab 7  | TreeMap                            | 创建BSTMap。它是 Map61B 接口的基于 BST 的实现，表示基于树的地图。完成实现后，性能与基于列表的 Map 实现`ULLMap`以及内置 Java`TreeMap`类（也使用 BST）进行比较。 |
| lab 8  | HashMap                            | 创建MyHashMap，它是 Map61B 接口的一个实现，代表一个哈希映射。完成实现后，性能与基于列表的 Map 实现`ULLMap`以及内置 Java`TreeMap`类（也使用 BST）进行比较。 |
| lab 9  | Tries                              | 实现TrieSet。Trie 是 Sets 和 Maps 的特定实现，专门用于字符串，此类改进之处在于通过对每个字符串的最后一个字符做标记来解决树中查找子串问题。使用HashMap v.s DataIndexedCharMap提高空间复杂性。 |
| lab 11 | Merge Sort and Quick Sort          | 实现归并排序和快速排序算法                                   |

| Challenge Labs | Name             | Description                                                  |
| -------------- | ---------------- | ------------------------------------------------------------ |
| clab 6         | Falling Bubbles  | 使用Union Find DS解决气泡网格问题                            |
| clab 8         | Heaps and Hashes | Part 1: 构建Flight类，使用HashMap和PQ解决最大乘客问题        |
|                |                  | Part 2: 实现RabinKarp字符串搜索算法，该算法“使用哈希来查找文本中一组模式字符串中的任何一个”。哈希性能是恒定的时间，一个实际应用是检测剽窃。 |



## Record

正式开始时间：2022.12.2   
计划完成用时：1 months - 1.5 months 

完成日：2023.1.9

实际完成用时：1.3 months


### 保持执行力 
### 说干就干，不要偷懒，不要松懈 

#### *2022.12.5*

proj0            **Submitted**

#### *2022.12.8*

Lab Setup    **Submitted**

Lab2             **Submitted**

#### *2022.12.16*

proj1a          **Testing and Fix Bug**

#### *2022.12.17*

proj1a          **Submitted**

#### *2022.12.18*

proj1b          **Submitted**

#### *2022.12.21*

Lab3             **Submitted**

#### *2022.12.23*

Lab4             **Jump over**

proj1gold             **Jump over**

#### *2022.12.24*

Lab5             **Jump over**

Lab6			**Submitted**

#### *2022.12.25*

cLab6     	**Understand**（hard to understand..）

#### *2022.12.26*

cLab6     	**Submitted**

HW1			**Submitted**

#### *2022.12.31*

2022最后一天了捏 回家耽搁了四天lab无进度 今天开始重整旗鼓

#### *2023.1.4*

HW2       	**Submitted**

#### *2023.1.5*

Lab7	   	**Submitted**

#### *2023.1.7*

HW3           **Submitted**

Lab8           **Submitted**

#### *2023.1.8*

cLab8         **Submitted**

#### *2023.1.9*

Lab9         **Submitted**

cLab 9（Graphs）    **Jump over**

Lab11        **Submitted**

proj2a       **Submitted**

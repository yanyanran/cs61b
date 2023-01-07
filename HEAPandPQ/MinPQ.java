/**
 * （最小）优先级队列：允许跟踪和删除优先级队列中的最小项目
 *
 * 只能与该包中最小的物品进行交互
 * */
public interface MinPQ<Item> {
    public void add(Item x);
    public Item getSmallest();
    public Item removeSmallest();
    public int size();
}
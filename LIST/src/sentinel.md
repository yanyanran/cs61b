#sentinel哨兵节点
始终存在的特殊节点--哨兵节点作为第一个节点，它的***数据域任定***。有了哨兵节点，第一个节点就是sentinel.next

如果创建一个空列表（SLList L = new SLList()）那么只存在哨兵节点：

![](https://joshhug.gitbooks.io/hug61b/content/chap2/fig22/empty_sentinelized_SLList.png)

加入元素后：

![](https://joshhug.gitbooks.io/hug61b/content/chap2/fig22/three_item_sentenlized_SLList.png)

整体是这样的：

![](https://github.com/yanyanran/pictures/blob/main/sentinel.png?raw=true)
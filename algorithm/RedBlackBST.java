/**
 * 红黑树的插入操作
 */
public class RedBlackBST {

    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    // 判断指向该结点的链接是否是红链接
    private boolean isRed(Node x) {
        if (x == null)
            return false;
        return x.color == RED;
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.n;
    }

    // 左旋，结点h的右链接是红链接，进行左旋，返回一个左链接是红链接的根结点
    private Node rotateLeft(Node h) {
        // 先找到未来的根结点
        Node x = h.right;
        // 将x的左孩子转变成h的右孩子
        h.right = x.left;
        // h变成x的左孩子
        x.left = h;
        // 指向x的链接颜色
        x.color = h.color;
        // 指向h的链接颜色
        h.color = RED;
        // 总的个数是不变的
        x.n = h.n;
        // 以h为根的子树，孩子多了一个
        h.n = 1 + size(h.left) + size(h.right);
        return x;
    }

    // 右旋
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.n = h.n;
        h.n = 1 + size(h.left) + size(h.right);
        return x;
    }

    // 颜色转换，结点h的左右链接都是红链接，因此将结点h的左右链接变成黑色，指向结点h的链接变成红色
    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public void put(String key, String value) {
        root = put(root, key, value);
        // 每次插入后，都会将根结点设为黑色
        root.color = BLACK;
    }

    private Node put(Node h, String key, String value) {
        if (h == null) {
            // 这里之所以使用红色，是为了统一插入操作，因为插入操作时，新结点和父结点使用红色相连
            return new Node(key, value, RED, 1);
        }
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, value);
        } else if (cmp > 0) {
            h.right = put(h.right, key, value);
        } else {
            h.value = value;
        }

        // 保证红黑树，以下三个判断顺序不能改变的
        // 如果结点h右链接为红色，左链接为黑，直接左旋
        if (isRed(h.right) && !isRed(h.left)) {
            // 左旋
            h = rotateLeft(h);
        }
        // 如果结点h的左链接是红色，左孩子的左链接也为红色，即结点h的左孩子同时与两个红链接相连
        if (isRed(h.left) && isRed(h.left.left)) {
            // 右旋
            h = rotateRight(h);
        }
        // 上一步，右旋，将结点h的左孩子变成了根结点，左右链接都是红色的，因此，需要进行颜色转换
        if (isRed(h.left) && isRed(h.right)) {
            // 颜色转换
            flipColors(h);
        }
        h.n = 1 + size(h.left) + size(h.right);
        return h;
    }
}

// 定义结点

class Node {
    // 键
    String key;
    // 值
    String value;
    // 左右子树
    Node left, right;
    // 这颗子树中的结点个数
    int n;
    // 指向该结点的链接的颜色
    boolean color;

    Node(String key, String value, boolean color, int n) {
        this.key = key;
        this.value = value;
        this.color = color;
        this.n = n;
    }
}


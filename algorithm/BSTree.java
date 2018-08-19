import java.util.Stack;

/**
 * 二叉树的基本操作 1.遍历 2.查找，插入，删除
 * 
 * @author geyan
 *
 */
public class BSTree<T extends Comparable<T>> {
	// 定义根节点
	private BSTNode<T> root;

	// 构造空二叉树
	public BSTree() {
		root = null;
	}

	/**
	 * 该二叉树的节点个数
	 */
	private int size(BSTNode<T> x) {
		if (x == null)
			return 0;
		else
			return x.n;
	}

	public int size() {
		return size(root);
	}

	/**
	 * (递归实现)前序遍历
	 * 
	 * @param node
	 */
	private void preOrder(BSTNode<T> node) {
		if (node != null) {
			visit(node);
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	public void preOrder() {
		preOrder(root);
	}

	/**
	 * (非递归实现) 先序遍历 具体实现过程： 1.首先申请一个新的栈，记为stack。 2.然后将头节点head压入stack中。
	 * 3.每次从stack中弹出栈顶节点，记为cur，然后打印cur节点的值。如果cur的右孩子不为空的话，将cur的右孩子先压入stack中，
	 * 最后如果cur的左孩子不为空的话，将cur的左孩子压入stack中。 4.不断重复步骤3，直到stack为空。
	 */
	private void iterativePreOrder(BSTNode<T> node) {
		if (node == null)
			return;
		// 用来暂存节点的栈
		Stack<BSTNode<T>> stack = new Stack<>();
		stack.push(node);
		while (!stack.empty()) {
			BSTNode<T> cur = stack.pop();
			// 打印cur节点
			visit(cur);
			if (cur.right != null)
				stack.push(cur.right);
			if (cur.left != null)
				stack.push(cur.left);
		}

	}

	public void iterativePreOrder() {
		iterativePreOrder(root);
	}

	/**
	 * (递归实现)中序遍历
	 */
	private void inOrder(BSTNode<T> node) {
		if (node != null) {
			inOrder(node.left);
			visit(node);
			inOrder(node.right);
		}
	}

	public void inOrder() {
		inOrder(root);
	}

	/**
	 * (非递归实现)中序遍历 
	 * 具体实现过程： 
	 * 1.申请一个新的栈，记为stack，申请一个变量cur，初始时令cur等于头节点。
	 * 2.先把cur节点压入栈中，对以cur节点为头的整棵子树来说，一次把整棵树的左边界压入栈中，即不断令cur = cur.left，然后重复步骤2。
	 * 3.不断重复步骤2，直到发现cur为空，此时从stack中弹出一个节点，记为node，打印node的值，并让cur = node.right，然后继续重复步骤2。 
	 * 4.当stack为空并且cur为空时，整个过程结束。
	 */
	private void iterativeInOrder(BSTNode<T> node) {
		if (node == null)
			return;
		Stack<BSTNode<T>> stack = new Stack<>();
		BSTNode<T> cur = node;
		while (!stack.empty() || cur != null) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				visit(cur);
				cur = cur.right;
			}
		}
	}

	public void iterativeInOrder() {
		iterativeInOrder(root);
	}

	/**
	 * (递归实现)后续遍历
	 * 
	 * @param node
	 */
	private void postOrder(BSTNode<T> node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			visit(node);
		}
	}

	public void postOrder() {
		postOrder(root);
	}

	/**
	 * (非递归实现)后序遍历 
	 * 方法一：两个栈 具体实现过程： 
	 * 1.申请一个栈，记为s1，然后将头节点压入s1中。
	 * 2.从s1中弹出的节点记为cur，然后先把cur的左孩子压入s1中，然后把cur的右孩子压入s1中。
	 * 3.在整个过程中，每一个从s1中弹出的节点都放进第二个栈s2中。 
	 * 4.不断重复步骤2和步骤3，直到s1为空，过程结束。
	 * 5.从s2中依次弹出节点并打印，打印的顺序就是后序遍历的顺序。
	 * 
	 * 
	 */
	private void iterativePostOrder_1(BSTNode<T> node) {
		if (node == null)
			return;
		Stack<BSTNode<T>> s1 = new Stack<>();
		Stack<BSTNode<T>> s2 = new Stack<>();

		BSTNode<T> cur = node;
		s1.push(cur);
		while (!s1.empty()) {
			cur = s1.pop();
			if(cur.left != null)
				s1.push(cur.left);
			if(cur.right != null)
				s1.push(cur.right);
			s2.push(cur);
		}
		while(!s2.empty()){
			visit(s2.pop());
		}
	}
	
	/**
	 * (非递归实现)后序遍历
	 * 方法二：一个栈
	 * 具体实现过程：
	 * 1.申请一个栈，记为stack，将头节点压入stack，同时设置两个变量h和c。在整个流程中，h代表最近一次弹出并打印的节点，c代表当前stack的栈顶节点，初始时令h为头节点，c为null。
	 * 2.每次令c等于当前stack的栈顶节点，但是不从stack中弹出节点，此时分以下3种情况：
	 * (1)如果c的左孩子不为空，并且h不等于c的左孩子，也不等于c的右孩子，则把c的左孩子压入stack中。
	 * (2)如果情况1不成立，并且c的右孩子不为空，并且h不等于c的右孩子，则把c的右孩子压入stack中。
	 * (3)如果情况1和情况2都不成立，那么从stack中弹出c并打印，然后令h等于c。
	 * 3.一直重复步骤2，直到stack为空，过程停止。
	 * @param node
	 */
	private void iterativePostOrder_2(BSTNode<T> node) {
		if (node == null)
			return;
		
	}

	public void iterativePostOrder() {
		iterativePostOrder_1(root);
	}

	/**
	 * (递归实现)查找二叉树x中值为val的节点
	 */
	private BSTNode<T> get(BSTNode<T> x, T val) {
		if (x == null)
			return x;
		int cmp = val.compareTo(x.val);
		if (cmp < 0)
			return get(x.left, val);
		else if (cmp > 0)
			return get(x.right, val);
		else
			return x;
	}

	public BSTNode<T> get(T val) {
		return get(root, val);
	}

	/**
	 * (非递归实现)查找二叉树x中值为val的节点
	 */
	private BSTNode<T> iterativeGet(BSTNode<T> x, T val) {
		while (x != null) {
			int cmp = val.compareTo(x.val);
			if (cmp < 0)
				x = x.left;
			else if (cmp > 0)
				x = x.right;
			else
				return x;
		}
		return x;
	}

	public BSTNode<T> iterativeGet(T val) {
		return iterativeGet(root, val);
	}

	/**
	 * (递归实现)往二叉树x中插入值为val的节点
	 */
	private BSTNode<T> put(BSTNode<T> x, T val) {
		if (x == null)
			// 以x为根的二叉树为空，新建节点插入
			return new BSTNode<T>(val, 1);
		int cmp = val.compareTo(x.val);
		if (cmp < 0)
			x.left = put(x.left, val);
		else if (cmp > 0)
			x.right = put(x.right, val);
		else
			x.val = val;
		// 更新二叉树节点个数
		x.n = size(x.left) + size(x.right) + 1;
		return x;
	}

	public void put(T val) {
		root = put(root, val);
	}

	/**
	 * (非递归)往二叉树中中插入值为val的节点
	 */
	public void iterativePut(T val) {
		BSTNode<T> node = new BSTNode<>(val);
		if (root == null) {
			root = node;
			return;
		}
		BSTNode<T> parent = null, x = root;
		while (x != null) {
			// 先记录下父节点，便于新节点的插入
			parent = x;
			int cmp = val.compareTo(x.val);
			if (cmp < 0)
				x = x.left;
			else if (cmp > 0)
				x = x.right;
			else {
				x.val = val;
				return;
			}
		}

		// parent为叶子节点
		int cmp = val.compareTo(parent.val);
		if (cmp < 0)
			parent.left = node;
		else
			parent.right = node;
	}

	/**
	 * 删除节点，删除有3种情况 1.删除叶子节点 2.删除仅有左或右子树的节点 3.删除左右子树都有的节点 在二叉树x中删除值为val的节点
	 */
	private BSTNode<T> delete(BSTNode<T> x, T val) {
		if (x == null)
			return x;

		// 先查找到该节点
		int cmp = val.compareTo(x.val);
		if (cmp < 0)
			x.left = delete(x.left, val);
		else if (cmp > 0)
			x.right = delete(x.right, val);
		else {
			// 已找到该节点，分3种情况
			if (x.left == null)
				return x.right;
			if (x.right == null)
				return x.left;
			// 删除左右子树都存在的节点，找到该节点的直接后继(也可以使用直接前驱)
			// 1.将指向即将被删除的节点的链接保存为t
			BSTNode<T> t = x;
			// 2.将x指向它的后继节点
			x = min(t.right);
			// 3.将x的右链接指向deleteMin(t.right)，deleteMin(x)表示删除以x为根的二叉树的最小值节点，返回根节点
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.n = size(x.left) + size(x.right) + 1;
		return x;
	}

	public void delete(T val) {
		root = delete(root, val);
	}

	/**
	 * 在以x为根的二叉树中，找到最小值的节点
	 */
	private BSTNode<T> min(BSTNode<T> x) {
		// 最下面的左子树
		if (x.left == null)
			return x;
		return min(x.left);
	}

	/**
	 * 删除以x为根的二叉树中的最小值的节点，并返回根节点
	 * 在该方法中，不断深入根节点的左子树中直至遇见一个空连接，然后将指向该节点的链接指向该节点的右子树(返回其右链接)
	 * 此时已经没有任何链接指向要被删除的节点，因此会被GC回收掉。
	 */
	private BSTNode<T> deleteMin(BSTNode<T> x) {
		if (x.left == null)
			return x.right;
		x.left = deleteMin(x.left);
		x.n = size(x.left) + size(x.right) + 1;
		return x;
	}

	public void visit(BSTNode<T> node) {
		System.out.print(node.val + " ");
	}
}

/**
 * 定义二叉树节点类
 */
class BSTNode<T extends Comparable<T>> {
	T val;
	int n;
	BSTNode<T> left;
	BSTNode<T> right;
	BSTNode<T> parent;

	public BSTNode(T val) {
		this.val = val;
	}

	public BSTNode(T val, int n) {
		this.val = val;
		this.n = n;
	}

	public T getVal() {
		return val;
	}

	public String toString() {
		return "val:" + val;
	}
}

import java.util.Stack;

/**
 * �������Ļ������� 1.���� 2.���ң����룬ɾ��
 * 
 * @author geyan
 *
 */
public class BSTree<T extends Comparable<T>> {
	// ������ڵ�
	private BSTNode<T> root;

	// ����ն�����
	public BSTree() {
		root = null;
	}

	/**
	 * �ö������Ľڵ����
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
	 * (�ݹ�ʵ��)ǰ�����
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
	 * (�ǵݹ�ʵ��) ������� ����ʵ�ֹ��̣� 1.��������һ���µ�ջ����Ϊstack�� 2.Ȼ��ͷ�ڵ�headѹ��stack�С�
	 * 3.ÿ�δ�stack�е���ջ���ڵ㣬��Ϊcur��Ȼ���ӡcur�ڵ��ֵ�����cur���Һ��Ӳ�Ϊ�յĻ�����cur���Һ�����ѹ��stack�У�
	 * ������cur�����Ӳ�Ϊ�յĻ�����cur������ѹ��stack�С� 4.�����ظ�����3��ֱ��stackΪ�ա�
	 */
	private void iterativePreOrder(BSTNode<T> node) {
		if (node == null)
			return;
		// �����ݴ�ڵ��ջ
		Stack<BSTNode<T>> stack = new Stack<>();
		stack.push(node);
		while (!stack.empty()) {
			BSTNode<T> cur = stack.pop();
			// ��ӡcur�ڵ�
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
	 * (�ݹ�ʵ��)�������
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
	 * (�ǵݹ�ʵ��)������� 
	 * ����ʵ�ֹ��̣� 
	 * 1.����һ���µ�ջ����Ϊstack������һ������cur����ʼʱ��cur����ͷ�ڵ㡣
	 * 2.�Ȱ�cur�ڵ�ѹ��ջ�У�����cur�ڵ�Ϊͷ������������˵��һ�ΰ�����������߽�ѹ��ջ�У���������cur = cur.left��Ȼ���ظ�����2��
	 * 3.�����ظ�����2��ֱ������curΪ�գ���ʱ��stack�е���һ���ڵ㣬��Ϊnode����ӡnode��ֵ������cur = node.right��Ȼ������ظ�����2�� 
	 * 4.��stackΪ�ղ���curΪ��ʱ���������̽�����
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
	 * (�ݹ�ʵ��)��������
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
	 * (�ǵݹ�ʵ��)������� 
	 * ����һ������ջ ����ʵ�ֹ��̣� 
	 * 1.����һ��ջ����Ϊs1��Ȼ��ͷ�ڵ�ѹ��s1�С�
	 * 2.��s1�е����Ľڵ��Ϊcur��Ȼ���Ȱ�cur������ѹ��s1�У�Ȼ���cur���Һ���ѹ��s1�С�
	 * 3.�����������У�ÿһ����s1�е����Ľڵ㶼�Ž��ڶ���ջs2�С� 
	 * 4.�����ظ�����2�Ͳ���3��ֱ��s1Ϊ�գ����̽�����
	 * 5.��s2�����ε����ڵ㲢��ӡ����ӡ��˳����Ǻ��������˳��
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
	 * (�ǵݹ�ʵ��)�������
	 * ��������һ��ջ
	 * ����ʵ�ֹ��̣�
	 * 1.����һ��ջ����Ϊstack����ͷ�ڵ�ѹ��stack��ͬʱ������������h��c�������������У�h�������һ�ε�������ӡ�Ľڵ㣬c����ǰstack��ջ���ڵ㣬��ʼʱ��hΪͷ�ڵ㣬cΪnull��
	 * 2.ÿ����c���ڵ�ǰstack��ջ���ڵ㣬���ǲ���stack�е����ڵ㣬��ʱ������3�������
	 * (1)���c�����Ӳ�Ϊ�գ�����h������c�����ӣ�Ҳ������c���Һ��ӣ����c������ѹ��stack�С�
	 * (2)������1������������c���Һ��Ӳ�Ϊ�գ�����h������c���Һ��ӣ����c���Һ���ѹ��stack�С�
	 * (3)������1�����2������������ô��stack�е���c����ӡ��Ȼ����h����c��
	 * 3.һֱ�ظ�����2��ֱ��stackΪ�գ�����ֹͣ��
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
	 * (�ݹ�ʵ��)���Ҷ�����x��ֵΪval�Ľڵ�
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
	 * (�ǵݹ�ʵ��)���Ҷ�����x��ֵΪval�Ľڵ�
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
	 * (�ݹ�ʵ��)��������x�в���ֵΪval�Ľڵ�
	 */
	private BSTNode<T> put(BSTNode<T> x, T val) {
		if (x == null)
			// ��xΪ���Ķ�����Ϊ�գ��½��ڵ����
			return new BSTNode<T>(val, 1);
		int cmp = val.compareTo(x.val);
		if (cmp < 0)
			x.left = put(x.left, val);
		else if (cmp > 0)
			x.right = put(x.right, val);
		else
			x.val = val;
		// ���¶������ڵ����
		x.n = size(x.left) + size(x.right) + 1;
		return x;
	}

	public void put(T val) {
		root = put(root, val);
	}

	/**
	 * (�ǵݹ�)�����������в���ֵΪval�Ľڵ�
	 */
	public void iterativePut(T val) {
		BSTNode<T> node = new BSTNode<>(val);
		if (root == null) {
			root = node;
			return;
		}
		BSTNode<T> parent = null, x = root;
		while (x != null) {
			// �ȼ�¼�¸��ڵ㣬�����½ڵ�Ĳ���
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

		// parentΪҶ�ӽڵ�
		int cmp = val.compareTo(parent.val);
		if (cmp < 0)
			parent.left = node;
		else
			parent.right = node;
	}

	/**
	 * ɾ���ڵ㣬ɾ����3����� 1.ɾ��Ҷ�ӽڵ� 2.ɾ����������������Ľڵ� 3.ɾ�������������еĽڵ� �ڶ�����x��ɾ��ֵΪval�Ľڵ�
	 */
	private BSTNode<T> delete(BSTNode<T> x, T val) {
		if (x == null)
			return x;

		// �Ȳ��ҵ��ýڵ�
		int cmp = val.compareTo(x.val);
		if (cmp < 0)
			x.left = delete(x.left, val);
		else if (cmp > 0)
			x.right = delete(x.right, val);
		else {
			// ���ҵ��ýڵ㣬��3�����
			if (x.left == null)
				return x.right;
			if (x.right == null)
				return x.left;
			// ɾ���������������ڵĽڵ㣬�ҵ��ýڵ��ֱ�Ӻ��(Ҳ����ʹ��ֱ��ǰ��)
			// 1.��ָ�򼴽���ɾ���Ľڵ�����ӱ���Ϊt
			BSTNode<T> t = x;
			// 2.��xָ�����ĺ�̽ڵ�
			x = min(t.right);
			// 3.��x��������ָ��deleteMin(t.right)��deleteMin(x)��ʾɾ����xΪ���Ķ���������Сֵ�ڵ㣬���ظ��ڵ�
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
	 * ����xΪ���Ķ������У��ҵ���Сֵ�Ľڵ�
	 */
	private BSTNode<T> min(BSTNode<T> x) {
		// �������������
		if (x.left == null)
			return x;
		return min(x.left);
	}

	/**
	 * ɾ����xΪ���Ķ������е���Сֵ�Ľڵ㣬�����ظ��ڵ�
	 * �ڸ÷����У�����������ڵ����������ֱ������һ�������ӣ�Ȼ��ָ��ýڵ������ָ��ýڵ��������(������������)
	 * ��ʱ�Ѿ�û���κ�����ָ��Ҫ��ɾ���Ľڵ㣬��˻ᱻGC���յ���
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
 * ����������ڵ���
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

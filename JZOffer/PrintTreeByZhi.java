import java.util.ArrayList;
import java.util.Stack;

/**
 * ��Ŀ����֮����˳���ӡ������
 * ��Ŀ��������ʵ��һ����������֮���δ�ӡ������������һ�а��մ����ҵ�˳���ӡ���ڶ��㰴�մ��������˳���ӡ�������а��մ����ҵ�˳���ӡ���������������ơ�
 * 
 * ������ 
 * ��֮����˳���ӡ��������Ҫ����ջ�������ڴ�ӡĳһ�нڵ�ʱ������һ����ӽڵ㱣�浽��Ӧ��ջ�
 * �����ǰ��ӡ���������㣬���ȱ������ӽڵ��ٱ������ӽڵ㵽һ��ջ� 
 * �����ǰ��ӡ����ż���㣬���ȱ������ӽڵ��ٱ������ӽڵ㵽�ڶ���ջ�
 * 
 * @author geyan
 *
 */
public class PrintTreeByZhi {

	public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
		// s1��������ڵ�
		Stack<TreeNode> s1 = new Stack<>();
		// s2��ż����ڵ�
		Stack<TreeNode> s2 = new Stack<>();
		if (pRoot == null) {
			return arrayList;
		}
		int layer = 1;
		s1.push(pRoot);
		while (!s1.empty() || !s2.empty()) {
			// ������
			if (layer % 2 != 0) {
				ArrayList<Integer> temp = new ArrayList<>();
				while(!s1.empty()){
					TreeNode node = s1.pop();
					if(node != null){
						temp.add(node.val);
						// �ȴ����ӽڵ㣬�ٴ����ӽڵ�
						s2.push(node.left);
						s2.push(node.right);
					}
				}
				if(!temp.isEmpty()){
					arrayList.add(temp);
					layer++;
				}
			}
			// ż����
			else {
				ArrayList<Integer>  temp = new ArrayList<>();
				while(!s2.empty()){
					TreeNode node = s2.pop();
					if(node != null){
						temp.add(node.val);
						s1.push(node.right);
						s1.push(node.left);
					}
				}
				if(!temp.isEmpty()){
					arrayList.add(temp);
					layer++;
				}
			}
		}
		return arrayList;
	}
}

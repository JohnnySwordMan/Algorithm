import java.util.ArrayList;

/**
 * ������25���������к�Ϊĳһֵ��·��
 * ��Ŀ����������һ�ö�������һ����������ӡ���������нڵ�ֵ�ĺ�Ϊ��������������·����·������Ϊ�����ĸ��ڵ㿪ʼ����һֱ��Ҳ�ڵ�������Ľڵ��γɵ�һ��·��
 * 
 * ������ ������������ķ�ʽ���ʵ�ĳһ�ڵ�ʱ�����ǰѸýڵ���ӵ�·���ϣ����ۼӸýڵ��ֵ��
 * ����ýڵ�ΪҶ�ڵ㲢��·���нڵ�ֵ�ĺ͸ոպõ����������������ǰ��·������Ҫ�����ǰ�����ӡ������
 * �����ǰ�ڵ㲻��Ҷ�ڵ㣬��������������ӽڵ㡣��ǰ�ڵ���ʽ����󣬵ݹ麯�����Զ��ص����ĸ��ڵ㡣
 * ��ˣ������ں����˳�֮ǰҪ��·����ɾ����ǰ�ڵ㲢��ȥ��ǰ�ڵ��ֵ����ȷ�����ظ��ڵ�ʱ·���պ��ǴӸ��ڵ㵽���ڵ��·����
 * 
 * @author geyan
 *
 */
public class FindPath {

	public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {

		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> al = new ArrayList<>();
		return findPath(root, 0, target, arrayList, al);
	}

	public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int curSum, int target,
			ArrayList<ArrayList<Integer>> arrayList, ArrayList<Integer> al) {
		if (root == null)
			return arrayList;
		al.add(root.val);
		curSum += root.val;
		if (curSum < target) {
			// ������·��
			findPath(root.left, curSum, target, arrayList, al);
			// ������·��
			findPath(root.right, curSum, target, arrayList, al);
		} else if (curSum == target) {
			// �жϴ�ʱroot�Ƿ�ΪҶ�ڵ�
			if (root.left == null && root.right == null)
				// �Ѿ��ҵ�һ��·��
				arrayList.add(new ArrayList<Integer>(al));
		} /*else {		
			al.remove(al.size() - 1);
		}*/
		// �Ƴ���ǰ�ڵ㣬���ܽ�������else�У���Ϊ�����ʱ�Ѿ��ҵ�һ��·������ôcurSum==target����������Ϊ��������һ��·����Ҳ��Ҫɾ�����һ���ڵ�
		al.remove(al.size()-1);
		return arrayList;
	}
}

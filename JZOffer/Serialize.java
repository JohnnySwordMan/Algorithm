/**
 * ��Ŀ�����л������� 
 * ��Ŀ��������ʵ�������������ֱ��������л��ͷ����л�������
 * 
 * @author geyan
 *
 */
public class Serialize {

	int index = -1;

	public String serialize(TreeNode root) {
		if (root == null) {
			return "#!";
		}
		String result = root.val + "!";
		result += serialize(root.left);
		result += serialize(root.right);
		return result;
	}

	public TreeNode deserialize(String str) {
		if (str == null)
			return null;
		index = -1;
		String[] strs = str.split("!");
		return deserialize(strs);
	}

	public TreeNode deserialize(String[] str) {
		index++;
		TreeNode node = null;
		if (!str[index].equals("#")) {
			node = new TreeNode(Integer.valueOf(str[index]));
			node.left = deserialize(str);
			node.right = deserialize(str);
		}
		return node;
	}
}

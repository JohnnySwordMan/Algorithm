/**
 * ��Ŀ���ո��滻
 * ���дһ�����������ַ����еĿո�ȫ���滻��"%20"���ٶ����ַ������㹻�Ŀռ����������ַ�������֪���ַ�������ʵ����(С�ڵ���1000)��
 * ͬʱ��֤�ַ����ɴ�Сд��Ӣ����ĸ��ɡ� 
 * ���������� "Mr John Smith",13 ���أ� "Mr%20John%20Smith"
 * 
 * ���������ȱ���str���ҵ��ո��������õ��滻֮��������С��Ȼ��Ӻ���ǰ����
 * 
 * @author geyan
 *
 */
public class Replacement {

	// ��Ҫ�½�����
	public String replaceSpace(String str, int n) {
		int spaceNum = 0;
		char[] c = str.toCharArray();
		for (int i = 0; i < n; i++) {
			if (c[i] == ' ') {
				spaceNum++;
			}
		}

		// �½�����
		char[] newC = new char[n + (3 - 1) * spaceNum];
		int k = 0;
		for (int i = 0; i < n; i++) {
			if (c[i] == ' ') {
				newC[k] = '%';
				newC[k + 1] = '2';
				newC[k + 2] = '0';
				k += 3;
			} else {
				newC[k++] = c[i];
			}
		}
		return new String(newC);
	}

	/**
	 * ��Ҫ�ж�String�����û�пո����û�еĻ���split������Ļ����ǲ����ں����"%20"
	 * ���String������ɿո�ģ���ô��Ҫע������м����ո����Ҫ�Ӽ���
	 * "qw"��˵�������ҵķ�������"qw%20"�������д��󣬵����п��ڿ���
	 * @param str
	 * @param n
	 * @return
	 */
	public String replaceSpace_1(String str, int n) {
		String[] splitStr = str.split(" ");
		int leftSpace = n - splitStr.length;
		StringBuilder sb = new StringBuilder();
		/*
		 * for(int i=0;i<splitStr.length;i++){
		 * sb.append(splitStr[i]).append("%20"); }
		 */
		for (int i = 0; i < splitStr.length - 1; i++) {
			sb.append(splitStr[i]).append("%20");
		}
		sb.append(splitStr[splitStr.length - 1]);
		while (leftSpace > 0) {
			sb.append("%20");
			leftSpace--;
		}
		return sb.toString();
	}
}

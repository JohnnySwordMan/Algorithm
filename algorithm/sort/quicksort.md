## 快速排序  

### 快排  

1. **核心思想：** 当两个子数组都有序时，整个数组也自然有序了。

2. 一次遍历之后，可以确定一个元素的最终位置。
3. 可以利用快排思想，解决一个无序数组中，第K个大小的元素。
4. **切分元素：**先取arr[left]作为切分元素，从数组的左侧开始遍历，直到找到**大于等于**切分元素的元素，再从数组的右侧开始遍历直到找到**小于等于**切分元素的元素，交换彼此位置，当两指针相遇，将arr[left]切分元素与arr[j]（左子数组最右侧元素）交换，并返回j。


### 性能  

1. 时间复杂度是O(n*logn)
2. 空间复杂度为O(1)
3. 不稳定，因为在遍历的时候，会交换元素


### 代码  

```java
public static void quickSort(int[] arr, int n) {
	if(arr == null || n <= 1) {
		return;
	}
	sort(arr, 0, n-1);
}

public static void sort(int[] arr, int left, int right) {
	if(left < right) {
		int j = partition(arr, left, right);  // 找出切分元素
		sort(arr, left, j-1);
		sort(arr, j+1, right);
	}
}

// 返回切分元素，顺便排序，在切分元素左侧的都是小于等于切分元素；在切分元素右侧的都是大于等于切分元素
public static int partition(int[] arr, int left, int right) {
        int i = left, j = right + 1;
        int pivot = arr[left];
        while (true) {
            while (arr[++i] < pivot) {
                if (i == right) {
                    break;
                }
            }
            while (arr[--j] > pivot) {
            		// 没有必要，因为arr[left]就是切分元素，如果j等于left，那么arr[j]=pivot
//                if (j == left) {
//                    break;
//                }
            }
            if (i >= j)
                break;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        int temp = arr[left];
        arr[left] = arr[j];
        arr[j] = temp;
        return j;
    }

```   

### 算法改进  

##### 切换到插入排序

基于以下两点：

1. 对于小数组，快速排序比插入排序慢
2. 因为递归，快速排序的`sort()`方法在小数组中也会调用自己


所以在排序小数组时，应该使用插入排序。`M`的最佳值与系统相关，一般在5-15之间  

```java
public static void sort(int[] arr, int left, int right) {
        if (right <= left + M) {
            // TODO("插入排序")
            return;
        }
        int j = partition(arr, left, right);
        sort(arr, left, j - 1);
        sort(arr, j + 1, right);
}
```  

##### 三取样切分（荷兰国旗问题）

在现实中待排序的关键字可能有很多的重复值，比如说对学生年龄排序、性别排序等，理论上，这些重复的值只需要处理一次即可。  

```java
public void sort_3way(int[] arr, int left, int right) {
        if (right - left <= M) {
            InsertSort(arr);
            return;
        }
        int lt = left, i = left + 1, gt = right;
        int pivot = arr[left];
        while (i <= right) {
            if (arr[i] < pivot) {
                int temp = arr[i];
                arr[i] = arr[lt];
                arr[lt] = temp;
                i++;
                lt++;
            } else if (arr[i] > pivot) {
                int temp = arr[i];
                arr[i] = arr[gt];
                arr[gt] = temp;
                gt--;
            } else {
                i++;
            }
        }
        // 循环结束，arr[left...lt-1] < pivot = arr[lt...gt] < arr[gt+1...right]
        sort_3way(arr, left, lt - 1);
        sort_3way(arr, gt + 1, right);
    }
```

### 思考  

1. 左侧扫描最好是在大于等于切分元素值得元素时停下，同样的，右侧扫描最好是小于等于切分元素值得元素时停下。尽管这样可能会不必要地将一些等值元素交换，但是在某些典型应用中，可以避免算法的运行时间变为平方级别。(重点)
2. 快速排序的**最好情况**每次都正好能将数组对半分。
3. 快排潜在缺点：如果切分不平衡时，会导致数组切分很多次，比如说切分元素每次都是最小的那个。
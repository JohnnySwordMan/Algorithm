### TopK问题   
问题描述：从数组arr中，找出最大的k个数。
举例：数组arr={5，3，7，1，8，2，9，4，7，2，6，6}，n为12，找出最大的5个数。  
#### 排序（全局）  
将整个数组arr进行从大到小排序，取排序后的前k个即可。这里使用堆排序，时间复杂度为O(N*logN)  
```
public static void sort_dec(int[] arr, int n) {
        // 建堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            minHeapDown(arr, i, n - 1);
        }
        // 最小堆堆顶元素与数组最后元素交换
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            minHeapDown(arr, 0, i - 1);
        }

    }

    // 从大到小排序，建立最小堆
    public static void minHeapDown(int[] arr, int start, int end) {
        int c = start, l = 2 * c + 1;
        int temp = arr[start];
        for (; l <= end; c = l, l = 2 * l + 1) {
            if (l < end && arr[l] > arr[l + 1]) {
                l++;
            }
            if (temp <= arr[l]) {
                return;
            }
            arr[c] = arr[l];
            arr[l] = temp;
        }
    }
```    
#### 冒泡排序(局部)  
利用冒泡排序，冒k个泡，只需要找出最大的k个即可，其他的不关注，时间复杂度为O(N*K) 
```
private void sort(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j - 1] < arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
```  
#### 堆排序  
定义容量为k的数组temp，遍历数组arr，如果temp数组未满，则将数组arr元素添加到temp数组中；如果temp数组已满，则找出temp数组中最小值min，将最小值min与当前遍历到的arr元素对比，如果min>arr[cur]，则arr[cur]必定不是最大的k个元素之一；如果min<arr[cur]，则min必定不是最大的k个元素之一，因此将arr[cur]替换掉min，即temp[0]。相较于局部冒泡排序，堆排序没有将最大的k个元素排序，因此缩短了时间。时间复杂度为O(N*logK)。
```
public ArrayList<Integer> getTopKFromArr(int[] input, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        if (input == null || input.length <= 0 || input.length < k || k == 0) {
            return al;
        }
        int[] arr = new int[k];
        int index = 0;
        for (int i = 0; i < input.length; i++) {
            if (index < k) {
                arr[index] = input[i];
                index++;
            } else {
                // 找出arr数组中的最小值
                minHeadDown(arr);
                // 如果arr中的最小值比当前元素小，那么该最小值必定不是最大的k个元素之一
                if (arr[0] < input[i]) {
                    arr[0] = input[i];
                }
            }
        }
        for (int i : arr) {
            al.add(i);
        }
        return al;
    }

    /**
     * 最小堆实现
     */
    public void minHeadDown(int[] arr) {
        int c = 0, l = 2 * c + 1;
        int temp = arr[0];
        for (; l <= arr.length - 1; c = l, l = 2 * l + 1) {
            // 左右孩子中较小的那个孩子
            if (l < arr.length - 1 && arr[l] > arr[l + 1]) {
                l++;
            }
            if (temp > arr[l]) {
                return;
            } else {
                arr[c] = arr[l];
                arr[l] = temp;
            }
        }
    }
```   
#### 随机选择  
1. 分治法：把一个大问题转化为若干小问题，当每个小问题都解决了，大问题也随之解决。快排
2. 减治法：把一个大问题转化为若干小问题，这些小问题中只需要解决一个，大问题也随之解决。寻找第k个大小的元素、二分法

利用快排思想，通过随机选择，找到数组arr中第k个大小的元素（左侧比切分元素大，右侧比切分元素小），然后再进行一次partition，取partition后左半区的k个数，即可得到TopK的结果。时间复杂度为O(N)。  
#### bitmap法  
bitmap，是典型的空间换时间，用若干个bit来表示集合的数据结构。  
假设TopK的n个元素都是int，且元素之间没有重复，那么只需要申请2^32个bit，即4G的内存，就可以表示这n个数。扫描所有n个元素，生产bitmap，生成后，取最高的k个bit即可，时间复杂度为O(N)。  
缺陷：如果集合元素有重复，那么相同元素会被去重，导致TopK的结果不准确。  
优化：每个元素的1个bit变成1个计数。   
[TopK](https://mp.weixin.qq.com/s/FFsvWXiaZK96PtUg-mmtEw)    
[TopK-bitmap计数](https://mp.weixin.qq.com/s/sDjCBFXoWajqvgBFdDoSrA)

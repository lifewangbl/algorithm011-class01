## 学习笔记
### LRU 
    代码模板
        public class LRUCache {
        	private Map<Integer, Integer> map; 
        	public LRUCache(int capacity) {
        		map = new LinkedCappedHashMap<>(capacity);
        	}
        	public int get(int key) {
        		if(!map.containsKey(key)) return -1;
                return map.get(key);   
        	}
        	public void put(int key, int value) {
        		map.put(key,value);
        	}
            private static class LinkedCappedHashMap<K,V> extends LinkedHashMap<K,V> {
        		int maximumCapacity;
        		LinkedCappedHashMap(int maximumCapacity) {
        			super(16, 0.75f, true);
                    this.maximumCapacity = maximumCapacity; 
        		}
        		protected boolean removeEldestEntry(Map.Entry eldest) {
        			return size() > maximumCapacity;
        		}
        	} 
        } 

### 排序算法
    冒泡排序：
        public void bubbleSort(int[] nums) {
        	for(int i=0;i<nums.length;i++){
        		for(int j=0;j<nums.length-i-1;j++){
        			if(nums[j]>nums[j+1]){
        				int temp = nums[j];
        				nums[j]=nums[j+1];
        				nums[j+1]=temp;
        			}
        		}
        	}
        }
    
    快速排序：
        public static void sort(int a[], int low, int hight) {
               int i, j, index;
            if (low > hight)return;
        	i = low;
        	j = hight;
        	index = a[i]; // 用子表的第一个记录做基准
        	while (i < j) { // 从表的两端交替向中间扫描
        	    while (i < j && a[j] >= index)  j--;
        	    if (i < j)  a[i++] = a[j];// 用比基准小的记录替换低位记录
        	    while (i < j && a[i] < index)  i++;
        	    if (i < j) // 用比基准大的记录替换高位记录
        	         a[j--] = a[i];
        	}
        	a[i] = index;// 将基准数值替换回 a[i]
        	sort(a, low, i - 1); // 对低子表进行递归排序
        	sort(a, i + 1, hight); // 对高子表进行递归排序
        }
        public static void quickSort(int a[]) {
        	sort(a, 0, a.length - 1);
        }
        
    插入排序：
        public static void insertionSort(int[] nums) {
            int length = nums.length;
            if (length <= 1) {
                return;
            }
            for (int i = 1; i < length; i++) {
                int value = nums[i];
                int j = i - 1;
                // 查找插入的位置
                while (j >= 0) {
                    if (nums[j] > value) {
                        nums[j + 1] = nums[j];  // 数据移动
                        j--;
                    } else {
                        break;
                    }
                }
                nums[j + 1] = value; // 插入数据
            }
        }
        
    选择排序:
        public static void selectionSort(int[] nums) {
            int length = nums.length;
            if (length <= 1) {
                return;
            }
            for (int i = 0; i < length; i++) {
                int minIdx = i;
                for (int j = i; j < length; j++) {
                    if (nums[minIdx] > nums[j]) {
                        minIdx = j;
                    }
                }
                int tmp = nums[i];
                nums[i] = nums[minIdx];
                nums[minIdx] = tmp;
            }
        }
    复杂度：
    | **排序算法** | **平均时间复杂度** | **最坏时间复杂度** | **最好时间复杂度** | **空间复杂度** | **稳定性** |
    | :----------: | :----------------: | :----------------: | :----------------: | :------------: | :--------: |
    | **冒泡排序** |       O(n²)        |       O(n²)        |        O(n)        |      O(1)      |    稳定    |
    | **选择排序** |       O(n²)        |       O(n²)        |       O(n²)        |      O(1)      |   不稳定   |
    | **插入排序** |       O(n²)        |       O(n²)        |        O(n)        |      O(1)      |    稳定    |
    | **快速排序** |      O(nlogn)      |       O(n²)        |      O(nlogn)      |    O(nlogn)    |   不稳定   |
    |  **堆排序**  |      O(nlogn)      |      O(nlogn)      |      O(nlogn)      |      O(1)      |   不稳定   |
    | **希尔排序** |      O(n^1.3)      |       O(n²)        |        O(n)        |      O(1)      |   不稳定   |
    | **归并排序** |      O(nlogn)      |      O(nlogn)      |      O(nlogn)      |      O(n)      |    稳定    |
    | **计数排序** |       O(n+k)       |       O(n+k)       |       O(n+k)       |     O(n+k)     |    稳定    |
    | **基数排序** |       O(n*k)       |       O(n*k)       |       O(n*k)       |     O(n+k)     |    稳定    |
        

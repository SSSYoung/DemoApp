#include<stdlib.h>
#include<stdio.h>



main() {
//	//动态数组的创建
//	int length;
//	printf("请输入你要创建数组的长度：\n");
//	scanf("%d", &length);
//	printf("数组的长度为：%d\n", length);
//
//	int arrays[length];
//	for (int i = 0; i < length; i++) {
//		//TODO
//		printf("请输入第%d个数字\n", i);
//		scanf("%d", &arrays[i]);
//	}
//
//	for (int i = 0; i < length; i++) {
//		printf("请输入第%d个数字 ==== %d\n", i, arrays[i]);
//	}
//	
//	system("pause");

		//动态数组的创建
		int length;
		printf("请输入你要创建数组的长度：\n");
		scanf("%d", &length);
		printf("数组的长度为：%d\n", length);
		
		//动态分配一组内存
		int* iarrays = malloc(sizeof(int)*length);
		
		for (int i = 0; i < length; i++) {
			//TODO
			printf("请输入第%d个数字\n", i);
			//指针就是地址，第i个
			scanf("%d", iarrays + i);
		}
		
		//重新分配
		//iarrays = realloc()
	
		for (int i = 0; i < length; i++) {
			//一块连续的内存
			printf("请输入第%d个数字 ==== %d\n", i, *(iarrays + i));
		}
		
		system("pause");
}

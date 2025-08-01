#include<stdlib.h>
#include<stdio.h>



main() {

	//输入数组的长度

	int length;
	printf("请输入数组的长度\n");
	scanf("%d", &length);
	int arrays[length];
	for (int i = 0; i < length; i++) {
		//TODO
		printf("请输入第%d个数字\n", i);
		scanf("%d", &arrays[i]);
	}
	for (int i = 0; i < length; i++) {
		//TODO
		printf("第%d个数字=====%d\n", i, *(arrays + i));
	}
	system("pause");
}


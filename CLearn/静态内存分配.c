#include<stdlib.h>
#include<stdio.h>

void func(int** address) {
	int i = 100;
	//静态内存分配
	*address = &i;
	//动态内存分配
//	int* tmp = malloc(sizeof(int));
//	*tmp = i;
//	*address = tmp;
	printf("num=====%d\n", **address);
}

main() {
	//int num = 10;
	int* point;
	//point = &num;
	func(&point);
	printf("*point====%d\n", *point);
	printf("*point====%d\n", *point);
	printf("*point====%d\n", *point);
}

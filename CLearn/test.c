#include<stdlib.h>
#include<stdio.h>

void increase(int* p) {
	*p = *p + 1;
}

int add(int x, int y) {
	return x + y;
}

void func(int** p) {
	int* p1 = malloc(sizeof(int));
	*p1 = 10;
	*p = p1;
	free(p1);
}


main() {
	/**
	 * printf函数
	 **/
//	char *name = "yangshuang";
//	printf("My name is %s\n",name);
//	printf("hello world\n");
//	char s[10];
//	strcpy(s,"acv");
//	char* str = "hello world";
//	printf("str is: %c",*str);
//
//	system("pause");
//	int a = 5;
//	int* p = &a;
//	increase(p);
//	printf("*p =======%d\n",*p);
//	system("pause");

	/**
	 * 函数指针
	 **/
// 	int (*cal)(int,int) = add;
// 	int rst = cal(cal(5,6),6);
// 	printf("rst =======%d\n",rst);

	/**
	  * 数组
	  **/

//	int a[] = {22, 37, 3490, 18, 95};
//	printf("a ========= %d\n",a);
//	printf("a ========= %d\n",*a);
//	printf("a ========= %d\n",*(a + 2));
//	printf("byte size ========= %d\n",sizeof(a)); //返回整个数组的字节长度  4*5 = 20
//	printf("array size ========= %d\n",sizeof(a)/sizeof(int)); //返回整个数组的长度  4 = 20

	/**
	 * 字符串
	 **/
//	char a[] = "hello world";
//	const char *b = "aello world";
//	printf("%s\n",a);
//	printf("%s\n",b);

	/**
	 * 内存管理
	 **/
//	int x = 10;
//	void* p= &x;// 整数指针转为 void 指针
//	int* q = p;
//	printf("q========%d\n",*q);


	/**
	 * 静态内存分配，因为a的地址是在函数内部，函数执行完后这些存储单元会被释放。
	 **/
	int* p;
	func(&p);
	printf("p=========%d\n", *p); //第一次输出10
	printf("p=========%d\n", *p); //第二次输出-2
	printf("p=========%d\n", *p); //第三次输出-2
	//动态内存分配
//	int* p = malloc(sizeof(int) * 5);
//
//	if(p == NULL){
//		//TODO
//		printf("内存分配失败");
//	}
//
//	for(int i=0;i<5;i++){
//		//TODO
//		*(p + i) = i+4;
//	}
//
//	for(int i=0;i<5;i++){
//		printf("p[%d] ===== %d\n",i,*(p + i));
//	}


//	int length = 10;
//	int* p = malloc(sizeof(int) * length);
//
//	for(int i=0;i<length;i++){
//		//TODO
//		*(p + i) = i + 100;
//	}
//
//	for(int i=0;i<length;i++){
//		printf("p[%d] ===== %d\n",i,*(p + i));
//	}

//	printf("%s\n",p);
//	free(p);
//	printf("%s\n",p);
//	printf("%d\n",sizeof(p));
}


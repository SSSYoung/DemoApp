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
	 * printf����
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
	 * ����ָ��
	 **/
// 	int (*cal)(int,int) = add;
// 	int rst = cal(cal(5,6),6);
// 	printf("rst =======%d\n",rst);

	/**
	  * ����
	  **/

//	int a[] = {22, 37, 3490, 18, 95};
//	printf("a ========= %d\n",a);
//	printf("a ========= %d\n",*a);
//	printf("a ========= %d\n",*(a + 2));
//	printf("byte size ========= %d\n",sizeof(a)); //��������������ֽڳ���  4*5 = 20
//	printf("array size ========= %d\n",sizeof(a)/sizeof(int)); //������������ĳ���  4 = 20

	/**
	 * �ַ���
	 **/
//	char a[] = "hello world";
//	const char *b = "aello world";
//	printf("%s\n",a);
//	printf("%s\n",b);

	/**
	 * �ڴ����
	 **/
//	int x = 10;
//	void* p= &x;// ����ָ��תΪ void ָ��
//	int* q = p;
//	printf("q========%d\n",*q);


	/**
	 * ��̬�ڴ���䣬��Ϊa�ĵ�ַ���ں����ڲ�������ִ�������Щ�洢��Ԫ�ᱻ�ͷš�
	 **/
	int* p;
	func(&p);
	printf("p=========%d\n", *p); //��һ�����10
	printf("p=========%d\n", *p); //�ڶ������-2
	printf("p=========%d\n", *p); //���������-2
	//��̬�ڴ����
//	int* p = malloc(sizeof(int) * 5);
//
//	if(p == NULL){
//		//TODO
//		printf("�ڴ����ʧ��");
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


#include<stdlib.h>
#include<stdio.h>



main() {

	//��������ĳ���

	int length;
	printf("����������ĳ���\n");
	scanf("%d", &length);
	int arrays[length];
	for (int i = 0; i < length; i++) {
		//TODO
		printf("�������%d������\n", i);
		scanf("%d", &arrays[i]);
	}
	for (int i = 0; i < length; i++) {
		//TODO
		printf("��%d������=====%d\n", i, *(arrays + i));
	}
	system("pause");
}


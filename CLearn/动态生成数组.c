#include<stdlib.h>
#include<stdio.h>



main() {
//	//��̬����Ĵ���
//	int length;
//	printf("��������Ҫ��������ĳ��ȣ�\n");
//	scanf("%d", &length);
//	printf("����ĳ���Ϊ��%d\n", length);
//
//	int arrays[length];
//	for (int i = 0; i < length; i++) {
//		//TODO
//		printf("�������%d������\n", i);
//		scanf("%d", &arrays[i]);
//	}
//
//	for (int i = 0; i < length; i++) {
//		printf("�������%d������ ==== %d\n", i, arrays[i]);
//	}
//	
//	system("pause");

		//��̬����Ĵ���
		int length;
		printf("��������Ҫ��������ĳ��ȣ�\n");
		scanf("%d", &length);
		printf("����ĳ���Ϊ��%d\n", length);
		
		//��̬����һ���ڴ�
		int* iarrays = malloc(sizeof(int)*length);
		
		for (int i = 0; i < length; i++) {
			//TODO
			printf("�������%d������\n", i);
			//ָ����ǵ�ַ����i��
			scanf("%d", iarrays + i);
		}
		
		//���·���
		//iarrays = realloc()
	
		for (int i = 0; i < length; i++) {
			//һ���������ڴ�
			printf("�������%d������ ==== %d\n", i, *(iarrays + i));
		}
		
		system("pause");
}

#include<stdlib.h>
#include<stdio.h>

//º¯ÊıÖ¸Õë

int add(int x, int y) {
	return x + y;
}

main() {
//	int a = 3;
//	int b = 4;
	int (*addExt)(int x,int y);
	addExt = add;
	int result = addExt(3,4);
	printf("result == %d\n", result);
	system("pause");
}

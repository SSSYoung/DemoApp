#include<stdlib.h>
#include<stdio.h>

typedef float i;

struct student {
	int age;
	int male;
	float score;
};

main() {
	struct student yang = {30, 1, 65.5f};
	printf("age = %d, male = %d, score ==== %f\n", yang.age, yang.male, yang.score);
	

	struct student* yangshuang = &yang;
	printf("yangshuang age = %d, male = %d, score ==== %f\n", (*yangshuang).age, (*yangshuang).male, (*yangshuang).score);
	yangshuang->age = 31;
	printf("yangshuang age = %d, male = %d, score ==== %f\n", yangshuang->age, yangshuang->male, yangshuang->score);
	
	system("pause");
}

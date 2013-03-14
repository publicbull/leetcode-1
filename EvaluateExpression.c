#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"ylutil.h"


double readNumber2(const char * str) {
  double num;
  sscanf(str, "%lf", &num);

  for (++str; isdigit(*str) || *str == '.'; ++str)
    ;

  printf("%f\n", num);

  return num;
}
double readNumber(const char * *str) {
  double num;
  sscanf(*str, "%lf", &num);

  for (++*str; isdigit(**str) || **str == '.'; ++*str)
    ;

  printf("%f\n", num);

  return num;
}

double calculate(const char * str) {
  if (*str == '\0')  return 0.0;

  printf("str=%s\n", str);

  double result = 1.0;
  char op = '*';
  while (op == '*' || op == '/') {
    if (op == '*')
      result *= readNumber(&str);
    else
      result /= readNumber(&str);

    op = *str++;
    printf("%c\n", op);
  }

  return result + calculate(--str);
}


int main(int argc, char* argv[]) {
  char* s= "1000-5*6/3*2+1";
  //char* s= "-3-4.3+5.05*2/4-4.10/5+3";
  printf("%f\n",calculate(s));
  return 1;
}

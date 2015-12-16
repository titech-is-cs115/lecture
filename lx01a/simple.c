#include <stdio.h>

int simple(int a, int n) {
  for (int i = 1; i <= n; i++) {
    a = a + i;
  }
  return a;
}

int main() {
  printf("1 + 2 + ... + 10 = %d\n", simple(0, 10));
}

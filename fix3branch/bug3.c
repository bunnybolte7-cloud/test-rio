#include <stdio.h>
#include <stdlib.h>

void print_array() {
    int *arr = malloc(5 * sizeof(int));
    
    // Bug 1: Loop goes up to <= 5, causing an out-of-bounds write/read (Buffer Overflow)
    for (int i = 0; i <= 5; i++) {
        arr[i] = i * 10;
    }

    for (int i = 0; i < 5; i++) {
        printf("Element %d: %d\n", i, arr[i]);
    }

    // Bug 2: Memory leak - 'arr' is never freed using free(arr);
}

int main() {
    printf("Starting buggy C program...\n");
    print_array();
    return 0;
}

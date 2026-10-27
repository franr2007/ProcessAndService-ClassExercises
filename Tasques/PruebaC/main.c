#include <stdio.h>
#include <string.h>
#include <unistd.h>

int main()

{   // COMENTARIO
    char buffer[100]; //
    sprintf(buffer, "Hola, mundo!\n");
    write(1, buffer, strlen(buffer));

    int sizeBuffer = strlen(buffer);

    sprintf(buffer,"El tamaño es %d\n", sizeBuffer);
    write(1, buffer, strlen(buffer));


    return 0;
}
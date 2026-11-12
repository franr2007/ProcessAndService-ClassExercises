#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

void ejecutarUsuario(char *username) {
    execlp("ps", "ps", "-u", username, (char *)NULL);

    // Esta línea solo se ejecuta si execlp falla.
    perror("Ha fallado la mutación a ps");
    exit(1);
}

int main(int argc, char *argv[]) {

    if (argc != 2) {
        printf("Uso: ./myPS <username>\n");
        exit(1);
    }

    //creacion proceso hijo
    pid_t pid = fork();

    //si da error
    if (pid == -1) {
        perror("Error en el fork");
        exit(1);
    }

    //si pid 0, estamos en el proceso hijo
    if (pid ==  0) {
        printf("Proceso hijo: Mi PID es %d. Nombre usuario: %s\n",
                getpid(), argv[1]);
        
        fflush(stdout);

        ejecutarUsuario(argv[1]);
    }
    //Si no proceso padre
    else {
        printf("Proceso padre: Mi PID es %d\n", getpid());

        fflush(stdout);
    }

    while (true){
    }
    

    return 0;
}
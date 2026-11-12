#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

void muta_a_PS(char *username)
{
    execlp("ps", "ps", "-u", username, (char *)NULL);

    // Esta línea solo se ejecuta si execlp falla.
    perror("Ha fallado la mutación a ps");
    exit(1);
}

int main(int argc, char *argv[])
{

    if (argc < 2)
    {
        printf("Uso: ./myPS2 <username1> <username2> ...\n");
        exit(1);
    }

    printf("Proceso padre: Mi PID es %d\n", getpid());

    for (int i = 1; i < argc; i++)
    {

        pid_t pid = fork();

        if (pid == -1)
        {
            perror("Error en fork");
            exit(1);
        }

        if (pid == 0)
        {
            printf("Proceso hijo: Mi PID es %d. Nombre usuario: %s\n",
                   getpid(), argv[i]);

            fflush(stdout);

            muta_a_PS(argv[i]);
        }

        //hace que el padre espere a que termine cada hijo antes de crear otro
        waitpid(pid, NULL, 0);
    }

    while (1)
    {
    }

    return 0;
}
#include "Endereco.h"
#include "leituraArquivo.h"
#include <stdio.h>
#include <stdlib.h>

struct Endereco {
  char cep[10];
  char estado[3];
  char cidade[30];
  char endereco[100];
} typedef Endereco;

int main() {
  int op;
  int tamVetorEndereco = tamanhoVetorEndereco();
  char cepBusca[9];
  Endereco *end;
  Endereco *busca;
  end = leArquivo(tamVetorEndereco);
  quicksort(end, 0, tamVetorEndereco - 1);
  do {
    printf("\nMenu:\n");
    printf("[1]: Imprimir Vetor Completo Ordenado (Demora alguns minutos)\n");
    printf("[2]: Busca Binaria\n");
    printf("[3]: Sair\n");
    printf("OP: ");
    scanf(" %d", &op);
    switch (op) {
    case 1:
      imprimeVetorEndereco(end, tamVetorEndereco);
      break;
    case 2:
      printf("Digite um CEP para a procura: ");
      scanf("%s", cepBusca);
      busca = busca_binaria(end, tamVetorEndereco, cepBusca);
      if(busca != NULL) 
      printf("\nEstado: %s\nCidade: %s\nEndereco: %s\n\n", busca->estado, busca->cidade, busca->endereco);
      else printf("Endereco nao encontrado\n\n");
      break;
    }
  } while (op != 3);
  return 0;
}
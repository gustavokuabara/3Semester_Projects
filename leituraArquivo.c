#include "leituraArquivo.h"
#include "Endereco.h"
#include <stdio.h>
#include <stdlib.h>

struct Endereco {
  char cep[10];
  char estado[3];
  char cidade[30];
  char endereco[100];
} typedef Endereco;

Endereco *leArquivo(int tamanho) {
  Endereco *end;
  FILE *arquivo;
  arquivo = fopen("CEP.txt", "r");

  // Erro ao abrir arquivo
  if (arquivo == NULL) {
    printf("Erro ao abrir o arquivo");
    return NULL;
  }
  char auxLinha[1000]; // Auxiliar que recebe cada linha do arquivo
  char cep[10], estado[3];
  int qtdPessoas = tamanho;
  int i = 0, j;

  // Cria vetor com endereços
  end = (Endereco *)malloc(qtdPessoas * sizeof(Endereco));
  if (end == NULL) {
    printf("Erro de memoria");
  }

  // Laço que salva as informações
  qtdPessoas = 0;
  while (fgets(auxLinha, sizeof(auxLinha), arquivo) != NULL) {
    // Laço que recebe o CEP
    for (i = 0; i < 10; i++) {
      end[qtdPessoas].cep[i] = auxLinha[i];
    }
    end[qtdPessoas].cep[i - 1] = '\0';
        // Laço para salvar estado
        j = 0;
    while (i < 13) {
      end[qtdPessoas].estado[j] = auxLinha[i];
      i++, j++;
    }
    end[qtdPessoas].estado[j - 1] = '\0';

    // Laço para salvar a cidade
    j = 0;
    while (auxLinha[i] != ';') {
      end[qtdPessoas].cidade[j] = auxLinha[i];
      i++, j++;
    }
    end[qtdPessoas].cidade[j] = '\0';

    // Laço para salvar o endereco
    j = 0, i++;
    while (auxLinha[i] != '\0' && auxLinha[i] != '\n') {
      end[qtdPessoas].endereco[j] = auxLinha[i];
      i++, j++;
    }
    end[qtdPessoas].endereco[j] = '\0';
    qtdPessoas++;
  }

  fclose(arquivo);
  return end;
}

Endereco *criaVetorEndereco(int tamanho) {
  Endereco *end;
  end = (Endereco *)malloc(tamanho * sizeof(Endereco));
  if (end == NULL) {
    printf("Erro de memoria");
  }
  return end;
}

void liberaVetorEndereco(Endereco *end) { free(end); }

void imprimeVetorEndereco(Endereco *end, int tamanho) {
  for (int i = 0; i < tamanho; i++) {
    printf("\n[%d]:\n", i);
    printf("Cep: %s\n", end[i].cep);
    printf("Estado: %s\n", end[i].estado);
    printf("Cidade: %s\n", end[i].cidade);
    printf("Endereco: %s\n", end[i].endereco);
  }
}

int tamanhoVetorEndereco() {
  FILE *arquivo;
  arquivo = fopen("CEP.txt", "r");
  char auxLinha[1000];
  int qtdPessoas = 0;
  // Erro ao abrir arquivo
  if (arquivo == NULL) {
    printf("Erro ao abrir o arquivo");
    return -1;
  }
  // Laço que conta quantas pessoas existem
  while (fgets(auxLinha, sizeof(auxLinha), arquivo) != NULL) {
    qtdPessoas++;
  }
  fclose(arquivo);
  return qtdPessoas;
}
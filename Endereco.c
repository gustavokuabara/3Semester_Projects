#include "Endereco.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Endereco {
  char cep[10];
  char estado[3];
  char cidade[30];
  char endereco[100];
} typedef Endereco;

Endereco *busca_binaria(Endereco *ende, int n, char chave_busca[]) {
  int inf = 0, sup = n - 1, meio, auxcomp;
  while (inf <= sup) {
    meio = inf + (sup - inf) / 2;
    auxcomp = strcmp(ende[meio].cep, chave_busca);
    if (auxcomp == 0)
      return &ende[meio];
    else if (auxcomp == 1)
      sup = meio - 1;
    else
      inf = meio + 1;
  }
  return NULL;
}

void quicksort(Endereco *end, int esq, int dir) {
  int i;
  if (esq >= dir)
    return;
  i = particao(end, esq, dir);
  quicksort(end, esq, i - 1);
  quicksort(end, i + 1, dir);
}

int particao(Endereco *end, int esq, int dir) {
  char pivo_cep[10];
  strcpy(pivo_cep, end[esq].cep);
  int i = esq;
  int j = dir + 1;

  while (1) {
    do {
      i++;
    } while (strcmp(end[i].cep, pivo_cep) < 0 && i <= dir);
    do {
      j--;
    } while (strcmp(end[j].cep, pivo_cep) > 0);
    if (i >= j) {
      break;
    }
    troca(end, i, j);
  }
  troca(end, esq, j);
  return j;
}

void troca(Endereco *end, int b, int a) {
  char aux[100];
  // Muda Cep
  strcpy(aux, end[a].cep);
  strcpy(end[a].cep, end[b].cep);
  strcpy(end[b].cep, aux);
  // Muda Estado
  strcpy(aux, end[a].estado);
  strcpy(end[a].estado, end[b].estado);
  strcpy(end[b].estado, aux);
  // Muda cidade
  strcpy(aux, end[a].cidade);
  strcpy(end[a].cidade, end[b].cidade);
  strcpy(end[b].cidade, aux);
  // Muda endereco
  strcpy(aux, end[a].endereco);
  strcpy(end[a].endereco, end[b].endereco);
  strcpy(end[b].endereco, aux);
}
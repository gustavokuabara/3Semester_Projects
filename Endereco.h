
typedef struct Endereco Endereco;

Endereco *busca_binaria(Endereco *ende, int n, char chave_busca[]);
void troca(Endereco *end, int b, int a);
void quicksort(Endereco *end, int esq, int dir);
int particao(Endereco *end,int esq,int dir);
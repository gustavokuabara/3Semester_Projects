package ClassesAuxiliares;

public class Data {
    private int dia, mes, ano;

    //Construtores
    public Data(int dia, int mes, int ano) {
        int diaMax;

        if (ano < 1) {
            //**Exception "Ano inválido"
        }
        else this.ano = ano;

        if (mes < 1 || mes > 12) {
            //**Exception "Mês inválido"
        }
        else this.mes = mes;
    
        //Define o número de dias do mês
        if (mes==1||mes==3||mes==5||mes==7||mes==8||mes==10||mes==12) diaMax = 31;
        else if (mes==4||mes==6||mes==9||mes==11) diaMax = 30;
        else {
            if (ano % 4 == 0) {
                if (ano % 100 == 0) {
                    if (ano % 400 == 0) diaMax = 29;
                    else diaMax = 28;
                }
                else diaMax = 29;
            }
            else diaMax = 28;
        }

        if (dia < 0 || dia > diaMax) {
            //**Exception "Dia invállido"  
        }
        else this.dia = dia;
    }

    public Data(Data data) {
        this.dia = data.getDia();
        this.mes = data.getMes();
        this.ano = data.getAno();
    }

    //Métodos GET
    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    //Métodos SET
    public void setData(int dia, int mes, int ano) {
        int diaMax;

        if (ano < 1) {
            //**Exception "Ano inválido"
        }
        else this.ano = ano;

        if (mes < 1 || mes > 12) {
            //**Exception "Mês inválido"
        }
        else this.mes = mes;
    
        //Define o número de dias do mês
        if (mes==1||mes==3||mes==5||mes==7||mes==8||mes==10||mes==12) diaMax = 31;
        else if (mes==4||mes==6||mes==9||mes==11) diaMax = 30;
        else {
            if (ano % 4 == 0) {
                if (ano % 100 == 0) {
                    if (ano % 400 == 0) diaMax = 29;
                    else diaMax = 28;
                }
                else diaMax = 29;
            }
            else diaMax = 28;
        }

        if (dia < 0 || dia > diaMax) {
            //**Exception "Dia invállido"  
        }
        else this.dia = dia;
    }

    //**Colocar exceptions
}

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Data {
    int dia;
    int mes;
    int ano;
    Calendar cal = GregorianCalendar.getInstance();

    public Data() {
        this.ano = cal.get(Calendar.YEAR);
        this.mes = cal.get(Calendar.MONTH) + 1;
        this.dia = cal.get(Calendar.DATE);
    }

    public Data (int dia, int mes, int ano) {
        if (ano > cal.get(Calendar.YEAR)) {
            this.ano = ano;
            this.mes = mes;
            this.dia = dia;
        } else if (ano == cal.get(Calendar.YEAR)) {
            if (mes == (cal.get(Calendar.MONTH) + 1)) {
                if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                    if (dia >= cal.get(Calendar.DATE) && dia <= 31) {
                        this.ano = ano;
                        this.mes = mes;
                        this.dia = dia;
                    } else {
                        throw new Error();
                    }
                } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                    if (dia >= cal.get(Calendar.DATE) && dia <= 30) {
                        this.ano = ano;
                        this.mes = mes;
                        this.dia = dia;
                    } else {
                        throw new Error();
                    }
                } else {
                    if (dia >= cal.get(Calendar.DATE) && dia <= 29) {
                        this.ano = ano;
                        this.mes = mes;
                        this.dia = dia;
                    } else {
                        throw new Error();
                    }
                }
            } else if (mes > (cal.get(Calendar.MONTH) + 1) && mes <= 12) {
                this.ano = ano;
                this.mes = mes;
                this.dia = dia;
            } else {
                throw new Error();
            }
        } else {
            throw new Error();
        }
    }

    public boolean hoje(Data data2) {
        return this.ano == data2.ano && this.mes == data2.mes && this.dia == data2.dia;
    }

    public boolean compare(Data data2) {
        if (this.ano > data2.ano) {
            return true;
        } else if (this.ano == data2.ano) {
            if (this.mes > data2.mes) {
                return true;
            } else if (this.mes == data2.mes) {
                return this.dia >= data2.dia;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    public String toString() {
        return this.dia + "/" + this.mes + "/" + this.ano;
    }
}
import java.util.Date;

public class Movimento {
    private int idMovimento;
    private Posto posto;
    private Date data;
    private char tipoMovimento;
    private char tipoVacina;
    private int quantidade;
    private double valorRepasse;

    public Movimento(int idMovimento, Posto posto, Date data, char tipoMovimento,char tipoVacina, int quantidade){
        this.idMovimento = idMovimento;
        this.posto = posto;
        this.data = data;
        this.tipoMovimento = tipoMovimento;
        this.tipoVacina = tipoVacina;
        this.quantidade = quantidade;
    }

    public int getIdMovimento() {
        return this.idMovimento;
    }


    public Posto getPosto() {
        return this.posto;
    }


    public Date getData() {
        return this.data;
    }


    public char getTipoMovimento() {
        return this.tipoMovimento;
    }


    public char getTipoVacina() {
        return this.tipoVacina;
    }


    public int getQuantidade() {
        return this.quantidade;
    }


    public double getValorRepasse() {
        return this.valorRepasse;
    }

    public double setValorRepasse(double valorRepasse) {
        return this.valorRepasse = valorRepasse;
    }

    public double calcularRepasse(){
        
        if(tipoMovimento == 'A'){
            if(tipoVacina == 'A'){
                if(quantidade>100){
                    this.valorRepasse +=30;
                }
                
            }
            if(tipoVacina == 'C'){
                if(quantidade>100){
                    this.valorRepasse +=40;
                }
                
            }
            
        }
        return this.valorRepasse;
    }

}

public class Posto {
    private int idPosto;
    private String nome;
    private int estoqueAstrazeneca;
    private int estoqueCoronavac;

    public Posto(int idPosto, String nome){
        this.nome = nome;
        this.estoqueAstrazeneca = 0;
        this.estoqueCoronavac = 0;
    }



    public int getIdPosto() {
        return this.idPosto;
    }

    public void setIdPosto(int idPosto) {
        this.idPosto = idPosto;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEstoqueAstrazeneca() {
        return this.estoqueAstrazeneca;
    }


    public int getEstoqueCoronavac() {
        return this.estoqueCoronavac;
    }

    public void registrarEntrada(int qtde, char tipoVacina){
        if(tipoVacina == 'A'){
            this.estoqueAstrazeneca += qtde;
        }
        if(tipoVacina == 'B'){
            this.estoqueCoronavac += qtde;
        }
        
    }
    public void registrarAplicacao(int qtde, char tipoVacina){
        if(tipoVacina == 'A'){
            this.estoqueAstrazeneca -= qtde;
        }
        if(tipoVacina == 'B'){
            this.estoqueCoronavac -= qtde;
        }
    }




}

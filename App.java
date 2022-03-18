import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class App {
    static SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
	static Scanner input = new Scanner(System.in);
    static List<Movimento> listaDeMovimento = new ArrayList<Movimento>();
    static List<Posto> listaDePostos = new ArrayList<Posto>();
    static int id=0;
    private String nome;
    static Posto[] ListaPosto = new Posto[2];
    static int contPostos = 0;
    public static void main(String[] args) throws ParseException {
        

        Posto posto = new Posto(1, "UPA UR:02");
		listaDePostos.add(posto);
		Posto posto2 = new Posto(2, "UPA UR:06");
		listaDePostos.add(posto2);

        //ListaPosto[1] = new Posto(1,"UPA UR:02");
        //ListaPosto[2] = new Posto(2,"UPA UR:06");

        int opcao = 0;
	     do{ 
	    	 System.out.printf("1 - Registrar movimento \n");
			 System.out.printf("2 - Repasse \n") ;
	         System.out.printf("0 - Finalizar Programa \n");
	         System.out.printf("Digite a opção desejada: ");
	             opcao = input.nextInt();
	         switch (opcao) {
	             case 1:
	                registrarMovimento();
	                 break;
	             case 2:
	                Repasse();
	                 break;	
	             case 0:
	            	 System.out.println("\nPrograma Finalizado!");
	            	 System.exit(0);
	             default:
	             	System.out.println("\nOpção incorreta");
	             	             
	         }
	         }while(opcao!=0);
		
    }

    public static Posto pesquisarPostoPorId(int id){
        for ( Posto posto: listaDePostos ) {
			if (posto.getIdPosto() == id) {
				return posto;
			}
		}
        return null;
    }
    public static Movimento pesquisarMovimentoPorId(int id){
        for ( Movimento movimento: listaDeMovimento ) {
			if (movimento.getIdMovimento() == id) {
				return movimento;
			}
		}
        return null;
    }
    public static void registrarMovimento() throws ParseException {
        id++;
        int idPosto;
        int idMovimento = id;
        Posto postoEncontrado;
        System.out.println("Id da movimentação: "+idMovimento);
        do{
            System.out.printf("\nDigite o ID do posto:\n");
            idPosto = input.nextInt();
            
            postoEncontrado = pesquisarPostoPorId(idPosto);
            if(postoEncontrado == null){
                System.out.printf("\nPosto não encontrado\n");
				continue;
            }
            break;
        }while(true);
        System.out.printf("\nData:\n");
		String entradaData = input.nextLine();
		Date data = formatoData.parse(entradaData);
        char tipoDeMovimento;
        do{
            System.out.printf("\nTipo de movimento");
            System.out.printf("\n(A)Aplicação");
            System.out.printf("\n(E)Entrada");
            System.out.printf("\nTipo de movimento:\n");
            tipoDeMovimento = input.next().charAt(0);
            if(tipoDeMovimento!='A' || tipoDeMovimento!='E'){
                System.out.printf("\nTipo de movimento não encontrada\n");
				continue;
            }
            break;
        }while(true);
        char tipoVacina;
        do{
            System.out.printf("\nTipo da Vacina");
            System.out.printf("\n(A)Astrazeneca");
            System.out.printf("\n(C)Coronavac");
            System.out.printf("\nTipo da Vacina:\n");
            tipoVacina = input.next().charAt(0);
            if(tipoVacina!='A' || tipoVacina!='C'){
                System.out.printf("\nTipo de Vacina não encontrada\n");
				continue;
            }
            break;
        }while(true);
        
        System.out.printf("\nDigite a quantidade:\n");
        int quantidade = input.nextInt();

        Movimento movimento = new Movimento(idMovimento, postoEncontrado, data, tipoDeMovimento, tipoVacina, quantidade);
        listaDeMovimento.add(movimento);

        Posto posto = null;
        if(tipoDeMovimento == 'A'){
            posto.registrarAplicacao(quantidade, tipoVacina);
        }else if(tipoDeMovimento == 'E'){
            posto.registrarEntrada(quantidade, tipoVacina);
        }
        
        System.out.printf("\nMovimentação guardada com sucesso!");
        Movimento calcularMovimentoRepasse = null;
        calcularMovimentoRepasse.calcularRepasse();

    }


    public static void Repasse(){
        int idPosto;
        Posto posto;
        int idMovimento;
        
        
        do{
            System.out.printf("\nDigite o ID do posto:\n");
            idPosto = input.nextInt();
            Posto postoEncontrado;
            postoEncontrado = pesquisarPostoPorId(idPosto);
            if(postoEncontrado == null){
                System.out.printf("\nPosto não encontrado\n");
				continue;
            }
                    System.out.printf("\nId Posto: %d", postoEncontrado.getIdPosto());
					System.out.printf("\nNome do Posto: %s", postoEncontrado.getNome());
					System.out.printf("\nEstoque de vacina Astrazeneca: %d", postoEncontrado.getEstoqueAstrazeneca());
					System.out.printf("\nEstoque de vacina Coronavac: %d", postoEncontrado.getEstoqueCoronavac());


            break;
        }while(true);
        do{
            System.out.printf("\nDigite o ID do movimento:\n");
            idMovimento = input.nextInt();
            Movimento movimentoEncontrado;
            movimentoEncontrado = pesquisarMovimentoPorId(idMovimento);
            if(movimentoEncontrado == null){
                System.out.printf("\nMovimento Encontrado\n");
				continue;
            }else{
                System.out.println("Id do movimento: " + movimentoEncontrado.getIdMovimento());
                System.out.println("Data do movimento: " + movimentoEncontrado.getData());
                System.out.println("Quantidade de doses: " + movimentoEncontrado.getQuantidade());
                System.out.println("Valor do repasse R$ " + movimentoEncontrado.getValorRepasse());
            }
            break;
        }while(true);


    }




}
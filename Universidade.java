package Aluno;

public class Aluno {
    // atributos da classe Aluno
    private String nome;  
    private String ra;    
    private double[] notas; //  para armazenar as notas
    private int quantidadeAvaliacoes; 
    private boolean presencaEAD; 

    // construtor que inicializa o aluno
    public Aluno(String nome, String ra, boolean presencaEAD) {
        this.nome = nome;
        this.ra = ra;
        this.presencaEAD = presencaEAD;
        this.notas = new double[4]; 
        this.quantidadeAvaliacoes = 0; 
    }

    // metodo que adiciona uma nota
    public void adicionarNota(double nota) {
        if (quantidadeAvaliacoes < 4) { 
            notas[quantidadeAvaliacoes] = nota;
            quantidadeAvaliacoes++;
        } else {
            System.out.println("Número máximo de avaliações atingido.");
        }
    }

    // metodo para calcular a nota final
    public double calcularNotaFinal() {
        double notaFinal = 0.0;
        
        // calcula a nota final de acordo com a quantidade de avaliações
        switch (quantidadeAvaliacoes) {
            case 1:
                notaFinal = notas[0]; 
                break;
            case 2:
                // media aritmética
                notaFinal = (notas[0] + notas[1]) / 2;
                break;
            case 3:
                // media ponderada 
                notaFinal = (notas[0] * 1 + notas[1] * 2 + notas[2] * 2) / 5;
                break;
            case 4:
                // calculo da nota final com os valores ja dados
                notaFinal = (notas[0] * 0.15) + (notas[1] * 0.30) + (notas[2] * 0.10) + (notas[3] * 0.45);
                break;
            default:
                System.out.println("Nenhuma nota cadastrada.");
                break;
        }
        
        return notaFinal; 
    }

    // metodo para imprimir 
    public void imprimirSituacao() {
        double notaFinal = calcularNotaFinal(); 
        String situacao = "Reprovado"; 

        // verifica se o aluno foi aprovado
        if (notaFinal >= 5.0 && (presencaEAD || verificarPresenca())) {
            situacao = "Aprovado";
        }

        // imprime as informações do aluno
        System.out.printf("Nome: %s\nRA: %s\nNota Final: %.2f\nSituação: %s\n",
                nome, ra, notaFinal, situacao);
    }

    // metodo para simular verificação de presença 
    private boolean verificarPresenca() {
       
        return true; 
    }
}


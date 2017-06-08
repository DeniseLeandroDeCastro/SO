/*
Instituto Federal de Educação Ciência e Tecnologia do Rio Grande do Norte - I.F.R.N
Aluna: Denise Maria Leandro de Castro
 */
package so;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JRadioButton;

/**
 *
 * @author Denise
 */
public class FCFS_FIFO {
    public static void main(String[] args) {
        
        //Declaração de variáveis:
        Scanner scanner = new Scanner(System.in);
        int N; //Número de processos que serão armazenados
        int entrada;
        int tempoAtual;
        double tempoDeExecucao;
        double tempoDeEspera;
        double turnaround;//Quantidade de tempo para executar um determinado processo
        
        ArrayList processos, tempoDoProcesso, burst, tempoInicial, tempoFinal;
        
        int Teste = 0;
        String formato, saida;
        
        DecimalFormat decimal = new DecimalFormat("0.00");
        
        System.out.print("Informe a quantidade de processos que deseja armazenar: ");
        N = scanner.nextInt ();
        
        //Enquanto a quantidade de processos for diferente de zero...
        while (N!=0) {
            Teste++;
            processos = new ArrayList();
            tempoDoProcesso = new ArrayList();
            burst = new ArrayList();//tempo em que a CPU será utilizada
            tempoInicial = new ArrayList();
            tempoFinal = new ArrayList();
            tempoDeEspera = 0;
            tempoDeExecucao = 0;
            turnaround = 0;
            
            for(int i =1; i<=N; i++){
                System.out.print("Tempo do processo p" + i);  
                entrada = scanner.nextInt();
                tempoDoProcesso.add(entrada);
                
                System.out.print("Burst do processo p" + i);
                entrada = scanner.nextInt();
                burst.add(entrada);
                processos.add(i);
                
            }
            tempoAtual = (int)tempoDoProcesso.get(0);
            
            for(int i = 0; i<N; i++){
                if((int)tempoDoProcesso.get(i)>tempoAtual){
                    tempoAtual = (int) tempoDoProcesso.get(i);   
                }
                tempoInicial.add(tempoAtual);
                tempoAtual += (int)burst.get(i);
                tempoFinal.add(tempoAtual);
            }
            
            for(int i=0; i<N; i++){
                tempoDeExecucao += (int)tempoFinal.get(i)-(int)tempoDoProcesso.get(i);
                tempoDeEspera += (int)tempoInicial.get(i)-(int)tempoDoProcesso.get(i);    
            }
            System.out.print("Processamento - PART" + Teste);
            System.out.print("Escalonamento FCFS");
            
            for(int i = 0; i<N; i++){
                turnaround = (int)tempoFinal.get(i) - (int)tempoDoProcesso.get(i);
                formato = decimal.format(turnaround);
                saida = "Turnaround p" + i + ":" + formato + "ms";
                saida = saida.replace(".", ",");
                System.out.println(saida);
             }
            tempoDeExecucao = tempoDeExecucao/N;
            tempoDeEspera = tempoDeEspera/N;
            
            formato = decimal.format(tempoDeEspera);
            saida = "Tempo Médio de Espera: " + formato + "ms";
            saida = saida.replace(".", ",");
            
            for(int i=0; i<N; i++){
                System.out.print("p" + processos.get(i) + " ");
            }
            System.out.println("");
            
            N = scanner.nextInt();
        }    
    }   

    public static JRadioButton getText() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

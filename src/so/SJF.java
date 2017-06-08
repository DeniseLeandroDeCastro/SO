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
public class SJF {//Shortest Job First - Processo mais curto primeiro
    /*
    Algoritmo de escalonamento que executa, dentre processos igualmente
    importantes, o mais curto primeiro
    */
    public static void main(String[] args) {
        
        
        //Declaração de variáveis:
        Scanner scanner = new Scanner(System.in);
        int N; //Número de processos que serão armazenados
        int entrada;
        ArrayList processos, chegada, cpChegada = new ArrayList (), burst;
        int[]temposFinais = new int[1], temposIniciais = new int[1];
        int idProcessoAtual;
        String ordemDeExecucao = " ", formato, saida;
        double tempoDeEspera, tempoDeExecucao, turnaround;
        int contTeste = 0;
        DecimalFormat decimal = new DecimalFormat("0.00");
        
        System.out.print("Informe quantos processos deseja armazenar: ");
        N = scanner.nextInt();
        
        while (N!=0){
            contTeste++;
            
            ordemDeExecucao = " ";
            processos = new ArrayList();
            chegada = new ArrayList();
            burst = new ArrayList();
            temposIniciais = new int[N];
            temposFinais = new int[N];
            
            for(int i =0; i<N; i++){
                System.out.print("Tempo do p" + (i + 1));
                entrada = scanner.nextInt();
                chegada.add(entrada);
                System.out.print("Tempo do burst do p" + (i + 1));
                entrada = scanner.nextInt();
                burst.add(entrada);
            }
            cpChegada = (ArrayList) burst.clone();
            //A clonagem cria uma nova instância, mantendo os mesmos elementos.
            //Isso significa, que existem 2 listas diferentes, mas com mesmos conteúdos.
            int execucao;
            int qtdeProcessos = N;
            int tempoAtual = (int)chegada.get(0);
            
            while(qtdeProcessos>0){
                processos = new ArrayList();
                for(int i = 0; i<N; i++){
                    if((int)chegada.get(i) != -1 && (int)chegada.get(i)<= tempoAtual){
                        processos.add(i);
                        
                    }
                    
                }
                if(processos.isEmpty()){
                    tempoAtual++;
                }else{
                    execucao = (int)processos.get(0);
                    for(int i=0; i < processos.size(); i++){
                        idProcessoAtual = (int)processos.get(i);
                        if((int)burst.get(idProcessoAtual)<(int)burst.get(execucao)){
                            execucao = (int)processos.get(i);
                            
                        }
                    }
                    temposIniciais[execucao] = tempoAtual;
                    tempoAtual += (int) burst.get(execucao);
                    temposFinais[execucao] = tempoAtual;
                    chegada.set(execucao, -1);
                    ordemDeExecucao += "p" + (execucao + 1) + " ";
                    qtdeProcessos--;
                    
                    }
                
                }
                tempoDeExecucao = 0;
                tempoDeEspera = 0;
                for(int i = 0; i<N; i++){
                    tempoDeExecucao += temposFinais[i]-(int)cpChegada.get(i);
                    tempoDeEspera += temposIniciais[i]-(int)cpChegada.get(i);
                    
                }
                System.out.println("Processamento - PARTE" + contTeste);
                for(int i = 0; i<N; i++){
                    turnaround = (int)temposFinais[i]-(int)cpChegada.get(i);
                    formato = decimal.format(turnaround);
                    saida = "Turnaround p " + i + ": " + formato + "ms";
                    saida = saida.replace(".", ",");
                    System.out.println(saida);
                }
                tempoDeExecucao = tempoDeExecucao /N;
                tempoDeEspera = tempoDeEspera /N;
                
                formato = decimal.format(tempoDeExecucao);
                saida = "Tempo Médio de Execução: " + formato + "s";
                saida = saida.replace(".", ",");
                System.out.println(saida);
                
                System.out.print(ordemDeExecucao);
                System.out.println( );
                
                N = scanner.nextInt();
                }
            }

    public static void add(SJF obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void setDefaultCloseOperation(int EXIT_ON_CLOSE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static JRadioButton getText() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        }
        
    


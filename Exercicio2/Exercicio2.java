import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Exercicio2 {
	
	public static void main(String[] args) {
		boolean saida = true;
		Scanner scan = new Scanner(System.in);
		Random generator = new Random();
		List<Integer> primos = new ArrayList<Integer>();
		List<Integer> pares = new ArrayList<Integer>();
		List<Integer> impares = new ArrayList<Integer>();
		
		while(saida) {
			System.out.println("digite a quantidade de numeros randomicos:");
			int quantidade = scan.nextInt();
			int maior = 0;
			int menor = 5000 ;
			int soma = 0;
			int aux;
			int mediam;
			int mediana;
			int numeros[] = new int [quantidade];
			int var = 0;
			
			if (quantidade > 0){
				for(int x = 0; x < quantidade;x++){
					int valor = 5000; 
					int randon = generator.nextInt(valor);
					numeros[x] = randon;
					
					
					 //verificaçoes
		
					soma = soma + randon;//soma
					
					if (randon % 2 == 0) {
						pares.add(randon);
					}else {
						impares.add(randon);
					}//pares e impares 
						
					if (randon < menor) {
						menor = randon;
					}//menor numero
					
					if (randon > maior) {
						maior = randon; 
					}//maior numero
					
					int divisores = 0;
					for (int d = 1; d <= randon;d++) {
						if (randon % d == 0 ) {						
							divisores++;
						}	
					}
					if (divisores==2) {
						primos.add(randon);
					}//numeros primos
					
					
				}
				
				//media
				int media = soma/quantidade;
				
				
				// mediana 
				for (int a = 0; a < quantidade;a++) {
					for (int b = a+1; b < quantidade; b++){
						if(numeros[a] > numeros[b]) {
							aux = numeros[a];
							numeros[a] = numeros[b];
							numeros[b] = aux;								
						}							
					}
				}
				
				if(quantidade % 2 == 0) {
					mediam = quantidade/2;
					mediana = (numeros[mediam-1]+ numeros[mediam])/2;
				}else {
					mediam = quantidade/2;
					mediana = numeros[mediam];
				}
				
				//moda 
				int contm = 0, nm = 0;
				
				for (int l = 0; l < quantidade; l++) {
					int cont = 0;
					for(int k =0; k < quantidade; k++) {
						if (numeros[l] == numeros[k]) {
							cont++;
						}
					}
					if(cont > contm) {
						contm = cont;
						nm = numeros[l];
					}
				}
					
				//variancia
				for (int i = 0; i < quantidade; i++ ) {
					var = var + (numeros[i]-media)*(numeros[i]-media);
				}
				double variancia = var/(quantidade - 1);
				
				System.out.println("\n");
				for (int i = 0 ; i < numeros.length; i++ ) {
					System.out.print(" "+numeros[i]);
				}
				
				//desvio padrao
				int dp = (int) Math.sqrt(variancia);
				
				
				System.out.println("\n");
				System.out.println("numero maior: "+maior);
				System.out.println("numero menor: "+menor);
				System.out.println("numeros pares: "+pares);
				System.out.println("numeros impares"+impares);
				System.out.println("numeros primos: "+primos);
				System.out.println("soma dos numeros: "+soma);
				System.out.println("media dos numeros: "+media);
				System.out.println("mediana: "+mediana);
				System.out.println("variancia: "+variancia);
				System.out.println("desvio padra: "+dp);
				
				if (contm == 1) {
					System.out.println("moda: Amodal");
				}else {
					System.out.println("moda: "+nm);
				}
					
				
				
				System.out.println("\n deseja gerar novamente? \n1- sim \n2- nao");
				int gerar = scan.nextInt();
				if (gerar == 2) {
					saida = false;
				}
					
			}else {
				System.out.println("numero invalido, digite um numero inteiro positivo");
			}
			
		}
		
		
	

	}

}

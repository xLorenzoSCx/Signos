package signos2;

import java.util.Calendar;
import java.util.Scanner;

public class Signos2 {

    public static void main(String[] args) {
        String nome;
        int anoNasci, sexo, idade, caracter, mesNasci, diaNasci = 0;
        anoNasci = 0;
        //entradas
        Scanner teclado = new Scanner(System.in);
        System.out.println("Insira seu nome completo");
        nome = teclado.nextLine();
//cálculo de quantos caracteres possui o nome que a pessoa inseriu, caso seja inferior a 8 seria considerado inválido.
        caracter = nome.length();
        if (caracter >= 8) {
            //sexo
            System.out.println("Insira seu sexo utilizando 2 para masculino ou 1 para feminino");
            sexo = teclado.nextInt();
            String genero, formal;
            if (sexo == 1) {
                genero = "Sr.";
                formal = "nascido";
            } else if (sexo == 2) {
                genero = "Sra.";
                formal = "nascida";
            } else {
                System.out.println("Número inserido é inválido");
                return;
            }

            System.out.println("Insira o numero do seu mês de nascimento");
            mesNasci = teclado.nextInt();
            System.out.println("Insira o seu dia de nascimento");
            diaNasci = teclado.nextInt();
            System.out.println("Insira seu ano de nascimento");
            anoNasci = teclado.nextInt();

            //cálculos da idade. Usando a data do computador da pessoa, será possível calcular sua idade automaticamente.
            Calendar hoje = Calendar.getInstance();
            int diaAtual = hoje.get(Calendar.DAY_OF_MONTH);
            int mesAtual = hoje.get(Calendar.MONTH) + 1;
            int anoAtual = hoje.get(Calendar.YEAR);
            idade = anoAtual - anoNasci;

            if (mesAtual < mesNasci || (mesAtual == mesNasci && diaAtual < diaNasci)) {
                idade--;
            }

            //a variável boolean começará como falsa para que possa ser atualizada no "if" abaixo, caso o if não seja verdadeiro o valor do boolean permanecerá false,
            boolean dataValida = false;

            if (((mesNasci == 1 || mesNasci == 3 || mesNasci == 5 || mesNasci == 7 || mesNasci == 8 || mesNasci == 10 || mesNasci == 12) && diaNasci > 0 && diaNasci <= 31 && anoNasci >= 1900 && anoNasci <= 2024)) {
                dataValida = true;
            } else if ((mesNasci == 4 || mesNasci == 6 || mesNasci == 9 || mesNasci == 11) && diaNasci > 0 && diaNasci <= 30) {
                dataValida = true;
            } else if (mesNasci == 2) {
                if (((anoNasci % 4 == 0) && (anoNasci % 100 != 0 || anoNasci % 400 == 0) && diaNasci > 0 && diaNasci <= 29) || (diaNasci > 0 && diaNasci <= 28)) {
                    dataValida = true;
                }
            }
            if (!dataValida) {
                System.out.println("Data inserida inválida xiru");
                return;
            }

            String signo = "";
//conta dos signos
            if ((diaNasci >= 21 && diaNasci <= 31 && mesNasci == 3) || (diaNasci >= 1 && diaNasci <= 20 && mesNasci == 4)) {
                signo = "Áries";
            } else if (diaNasci >= 21 && diaNasci <= 31 && mesNasci == 5 || (diaNasci >= 1 && diaNasci <= 20 && mesNasci == 6)) {
                signo = "Gêmeos";
            } else if (diaNasci >= 22 && diaNasci <= 31 && mesNasci == 7 || (diaNasci >= 1 && diaNasci <= 22 && mesNasci == 8)) {
                signo = "Leão";
            } else if (diaNasci >= 23 && diaNasci <= 30 && mesNasci == 9 || (diaNasci >= 1 && diaNasci <= 22 && mesNasci == 10)) {
                signo = "libras";
            } else if (diaNasci >= 22 && diaNasci <= 30 && mesNasci == 11 || (diaNasci >= 1 && diaNasci <= 21 && mesNasci == 12)) {
                signo = "Sagitário";
            } else if (diaNasci >= 21 && diaNasci <= 31 && mesNasci == 1 || (diaNasci >= 1 && diaNasci <= 21 && mesNasci == 2)) {
                signo = "Aquário";
            } else if (diaNasci >= 21 && diaNasci <= 30 && mesNasci == 4 || (diaNasci >= 1 && diaNasci <= 20 && mesNasci == 5)) {
                signo = "Touro";
            } else if (diaNasci >= 21 && diaNasci <= 30 && mesNasci == 6 || (diaNasci >= 1 && diaNasci <= 21 && mesNasci == 7)) {
                signo = "Câncer";
            } else if (diaNasci >= 23 && diaNasci <= 31 && mesNasci == 8 || (diaNasci >= 1 && diaNasci <= 22 && mesNasci == 9)) {
                signo = "Virgem";
            } else if (diaNasci >= 23 && diaNasci <= 31 && mesNasci == 10 || (diaNasci >= 1 && diaNasci <= 21 && mesNasci == 11)) {
                signo = "Escorpião";
            } else if (diaNasci >= 22 && diaNasci <= 31 && mesNasci == 12 || (diaNasci >= 1 && diaNasci <= 20 && mesNasci == 1)) {
                signo = "Capricórnio";
            } else if (diaNasci >= 20 && diaNasci <= 28 && mesNasci >= 2 || (diaNasci >= 1 && diaNasci <= 20 && mesNasci <= 3)) {
                signo = "Peixes";
            } else {
            }

            //número da sorte. A fórmula abaixo será usada para calcular um número entre 1 e 99.
            int numeroSorte = 1 + (int) (Math.random() * 99);

            //cor da sorte. Com o cálculo abaixo, será possível gerar um número aleatório de 1 a 5, após isso será verificado em qual dos ifs o número se enxaixa, assim gerando uma das cores.
            int corSorte = 1 + (int) (Math.random() * 5);
            String cor = "";
            if (corSorte == 1) {
                cor = "Azul";
            } else if (corSorte == 2) {
                cor = "Vermelho";
            } else if (corSorte == 3) {
                cor = "Verde";
            } else if (corSorte == 4) {
                cor = "Amarelo";
            } else {
                cor = "Branco";
            }

            System.out.println(genero + nome + "" + formal + " " + diaNasci + "/" + mesNasci + "/" + anoNasci + ", tendo a idade de " + idade + ". Seu signo é " + signo + ", seu número da sorte é " + numeroSorte + ", sua cor da sorte é " + cor);

        } else {
            System.out.println("Número de caracteres inválido");
        }

    }
}

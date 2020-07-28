package application;

import model.entities.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {

        //Exercício: Reserva e atualização de Reserva de um quarto de hotel.

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Quarto número: ");
        int numero = sc.nextInt();
        System.out.print("Date de check-in (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Date de check-out (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if(!checkOut.after(checkIn)){
            System.out.print("Erro na reserva: A data de check-out deve ser posterior a data de check-in");
        }
        else {
            Reserva reserva = new Reserva(numero, checkIn, checkOut);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Entre com a data da atualização da reserva (dd/MM/yyyy): ");
            System.out.print("Date de check-in (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Date de check-out (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            /* Solução Muito ruim para validação da data :

            Date now = new Date();
            if(checkIn.before(now) ||checkOut.before(now)){
                System.out.println("Erro na Reserva: As Datas para atualização devem ser posterior a data atual.");
            }
            else if(!checkOut.after(checkIn)) {
                System.out.print("Erro na reserva: A data de check-out deve ser posterior a data de check-in");
            }
            else{
                reserva.atualizarDatas(checkIn, checkOut);
                System.out.println("Reserva: " + reserva);
            }
            */
            String error = reserva.atualizarDatas(checkIn, checkOut);
            if (error != null) {
                System.out.println("Erro na reserva! " + error);
            }
            else{
                System.out.println("Reserva: " + reserva);
            }
        }

        sc.close();
    }


}

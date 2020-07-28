package application;

import model.entities.Reserva;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Exercício: Reserva e atualização de Reserva de um quarto de hotel.

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Quarto número: ");
            int numero = sc.nextInt();
            System.out.print("Date de check-in (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Date de check-out (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());


            Reserva reserva = new Reserva(numero, checkIn, checkOut);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Entre com a data da atualização da reserva (dd/MM/yyyy): ");
            System.out.print("Date de check-in (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Date de check-out (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reserva.atualizarDatas(checkIn, checkOut);
            System.out.println("Reserva: " + reserva);
        }
        catch (ParseException e) {
            System.out.println("Formato Inválido para Data!");
        }
        catch (DomainException e){
            System.out.println("Erro na Reserva: " + e.getMessage());
        }
        catch(RuntimeException e){
            System.out.println("Erro Inesperado !!");
        }
        /*catch (IllegalArgumentException e){
            System.out.println("Erro na Reserva: " + e.getMessage());
        }*/

        sc.close();
    }


}

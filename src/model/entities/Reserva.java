package model.entities;

import model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

    private Integer quartoNumero;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva(Integer quartoNumero, Date checkIn, Date checkOut){
        if(!checkOut.after(checkIn)) {
            throw new DomainException("A data de check-out deve ser posterior a data de check-in.");
        }
        this.quartoNumero = quartoNumero;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getQuartoNumero() {
        return quartoNumero;
    }

    public void setQuartoNumero(Integer quartoNumero) {
        this.quartoNumero = quartoNumero;
    }

    public Date getCheckIn() {
        return checkIn;
    }

        public Date getCheckOut() {
        return checkOut;
    }

    public long duracao(){
        long diferenca = checkIn.getTime() - checkOut.getTime(); // Capturando a diferençao das datas em Millisegundos.
        return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS); // TimeUnit.Days - Convertendo de Millisegundos para dias
    }


    public void atualizarDatas(Date checkIn, Date checkOut){
        Date now = new Date();
        if(checkIn.before(now) || checkOut.before(now)){
            throw new DomainException("As Datas para atualização devem ser posterior a data atual.");
            //throw new IllegalArgumentException("As Datas para atualização devem ser posterior a data atual.");
        }
        if(!checkOut.after(checkIn)) {
            throw new DomainException("A data de check-out deve ser posterior a data de check-in.");
            //throw new IllegalArgumentException("A data de check-out deve ser posterior a data de check-in.");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString (){
        return "Quarto: "
                + quartoNumero
                + " , Check-in: "
                + sdf.format(checkIn)
                + ", Check-out: "
                + sdf.format(checkOut)
                + " , "
                +duracao()
                + " noite(s)";
    }


}

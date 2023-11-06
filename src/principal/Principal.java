import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Principal {
    public static void main(String[] args) {
        LocalDateTime fechaHoraActualMadrid = LocalDateTime.now(ZoneId.of("Europe/Madrid"));
        ZoneId zonaHorariaCaracas = ZoneId.of("America/Caracas");
        
        DateTimeFormatter formatoFechaEspaña = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("1. La fecha actual local es: " + fechaHoraActualMadrid.format(formatoFechaEspaña));

        ZonedDateTime fechaHoraActualCaracas = fechaHoraActualMadrid.atZone(zonaHorariaCaracas);
        System.out.println("2. La fecha actual en Caracas es: " + fechaHoraActualCaracas.format(formatoFechaEspaña));

        long añosTranscurridos = ChronoUnit.YEARS.between(LocalDate.of(1492, 1, 1), LocalDate.now());
        System.out.println("3. Los años transcurridos desde el descubrimiento de América son: " + añosTranscurridos);

        DateTimeFormatter formatoHoraEspaña = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("4. La hora actual local es: " + fechaHoraActualMadrid.format(formatoHoraEspaña));

        DateTimeFormatter formatoHoraCaracas = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("5. La hora actual en Caracas es: " + fechaHoraActualCaracas.format(formatoHoraCaracas));

        ZoneOffset offsetMadrid = fechaHoraActualMadrid.atZone(ZoneId.of("Europe/Madrid")).getOffset();
        ZoneOffset offsetCaracas = fechaHoraActualMadrid.atZone(ZoneId.of("America/Caracas")).getOffset();
        int horasDiferencia = (offsetMadrid.getTotalSeconds() - offsetCaracas.getTotalSeconds()) / 3600;
        System.out.println("6. Las horas de diferencia entre Madrid y Caracas son: " + horasDiferencia);

        LocalDateTime neilarmstrongluna = LocalDateTime.of(1969, 7, 21, 3, 56);
        ZoneId zonaHorariaMadrid = ZoneId.of("Europe/Madrid");
        ZonedDateTime neilarmstronglunamadrid = neilarmstrongluna.atZone(zonaHorariaMadrid);
        DateTimeFormatter formatoFechaHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println("7. La fecha y hora de cuando Neil Armstrong pisó la luna es: " + neilarmstronglunamadrid.format(formatoFechaHora));
    }
}

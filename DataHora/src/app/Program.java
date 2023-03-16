package app;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Program {

	public static void main(String[] args) {		
		// Instanciação de Data-hora
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Indica como deve ser a ordem da formatação
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		LocalDate d01 = LocalDate.now(); // Informa a data
		LocalDateTime d02 = LocalDateTime.now(); // Informa a data e hora
		Instant d03 = Instant.now(); // Informa a data e hora (Reino Unido)
		LocalDate d04 = LocalDate.parse("2022-07-20");
		LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");
		
		// Para formatar um Instant é necessário falar o fuso horário
		Instant d06 = Instant.parse("2022-07-20T01:30:26Z");
		Instant d07 = Instant.parse("2022-07-20T01:30:26-03:00");  // GMT de SP	
		
		LocalDate d08 = LocalDate.parse("20/07/2022", fmt1);
		LocalDateTime d09 = LocalDateTime.parse("20/07/2022 01:30", fmt2);
		
		/*
		É possível colocar a expressão dentro do argumento. 
		 
		LocalDate d08 = LocalDate.parse("20/07/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDateTime d09 = LocalDateTime.parse("20/07/2022 1:30", DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm"));
		*/
		
		LocalDate d10 = LocalDate.of(2022, 7, 20);
		LocalDateTime d11 = LocalDateTime.of(2022, 7, 20, 1, 30);
		
		System.out.println("d01 = " + d01.toString());
		System.out.println("d02 = " + d02.toString());
		System.out.println("d03 = " + d03.toString());
		System.out.println("d04 = " + d04.toString());
		System.out.println("d05 = " + d05.toString());
		System.out.println("d06 = " + d06.toString());
		System.out.println("d07 = " + d07.toString());
		System.out.println("d08 = " + d08.toString());
		System.out.println("d09 = " + d09.toString());
		System.out.println("d10 = " + d10.toString());
		System.out.println("d11 = " + d11.toString());
		
		System.out.println();
		
		LocalDate d12 = LocalDate.parse("2022-07-20");
		LocalDateTime d13 = LocalDateTime.parse("2022-07-20T01:30:26");
		Instant d14 = Instant.parse("2022-07-20T01:30:26Z");
		
		DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// Duas formas de chamar a mesma coisa
		System.out.println("d12 = " + d12.format(fmt3));
		System.out.println("d12 = " + fmt3.format(d12));
		
		// A diferença de fazer assim é instanciar o objeto na hora de rodar, ele instancia, formata, 
		// mostra na tela e a coleta de lixo deleta depois
		System.out.println("d12 = " + d12.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
		DateTimeFormatter fmt4 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		System.out.println("d13 = " + d13.format(fmt4));
		System.out.println("d13 = " + d13.format(fmt3));
		
		
		DateTimeFormatter fmt5 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
		System.out.println("d14 = " + fmt5.format(d14));
		
		
		DateTimeFormatter fmt6 = DateTimeFormatter.ISO_DATE_TIME;
		System.out.println("d13 = " + fmt6.format(d13));
		
		DateTimeFormatter fmt7 = DateTimeFormatter.ISO_INSTANT;
		System.out.println("d14 = " + fmt7.format(d14));
		System.out.println("d14 = " + d14.toString());  // formato ISO
		
		System.out.println();
		
		/*
		Imprime nomes para especificar um fuso horário
		
		for (String s : ZoneId.getAvailableZoneIds()) {
			System.out.println(s);
		}
		
		*/
		
		// Conversão de data global para local
		Instant d20 = Instant.parse("2022-07-20T01:30:26Z");
		LocalDate r1 = LocalDate.ofInstant(d20, ZoneId.systemDefault());
		LocalDate r2 = LocalDate.ofInstant(d20, ZoneId.of("Portugal"));
		LocalDateTime r3 = LocalDateTime.ofInstant(d20, ZoneId.systemDefault());
		LocalDateTime r4 = LocalDateTime.ofInstant(d20, ZoneId.of("Portugal"));
		System.out.println("r1 = " + r1	);  // O dia fica 19 pois foi ajustado ao horário de Londes
		System.out.println("r2 = " + r2	);
		System.out.println("r3 = " + r3	);
		System.out.println("r4 = " + r4	);
		
		LocalDate d21 = LocalDate.parse("2022-07-20");
		LocalDateTime d22 = LocalDateTime.parse("2022-07-20T01:30:26");
		
		System.out.println("d21 dia = " + d21.getDayOfMonth());
		System.out.println("d21 mês = " + d21.getMonthValue());
		System.out.println("d21 ano = " + d21.getYear());
		
		System.out.println("d22 hora = " + d22.getHour());
		System.out.println("d22 minutos	= " + d22.getMinute());
		
		System.out.println();
		
		// Operação com data-hora
		// Data-hora em java são objetos imutáveis, caso precise de uma data hora de um dia anterior, criar um novo objeto alterado
		
		LocalDate d30 = LocalDate.parse("2022-07-20");
		LocalDateTime d31 = LocalDateTime.parse("2022-07-20T01:30:26");
		Instant d32 = Instant.parse("2022-07-20T01:30:26Z");
		
		LocalDate pastWeekLocalDate = d30.minusDays(7);
		LocalDate nextWeekLocalDate = d30.plusDays(7);
		
		System.out.println("pastWeekLocalDate = " + pastWeekLocalDate);
		System.out.println("nextWeekLocalDate = " + nextWeekLocalDate);
		
		LocalDateTime pastWeekLocalDateTime = d31.minusDays(7);
		LocalDateTime nextWeekLocalDateTime = d31.plusDays(7);
		
		System.out.println("pastWeekLocalDateTime = " + pastWeekLocalDateTime);
		System.out.println("nextWeekLocalDateTime = " + nextWeekLocalDateTime);
		
		Instant pastWeekLocalInstant = d32.minus(7, ChronoUnit.DAYS);
		Instant nextWeekLocalInstant= d32.plus(7, ChronoUnit.DAYS);
		
		System.out.println("pastWeekLocalInstant = " + pastWeekLocalInstant);
		System.out.println("nextWeekLocalInstant = " + nextWeekLocalInstant);
		
		Duration t1 = Duration.between(pastWeekLocalDate.atStartOfDay(), d30.atTime(0, 0)); // Ambos fazem a conversão
		Duration t2 = Duration.between(pastWeekLocalDateTime, d31);
		Duration t3 = Duration.between(pastWeekLocalInstant, d32);
		Duration t4 = Duration.between(d32, pastWeekLocalInstant);
		System.out.println("t1 dias = " + t1.toDays());
		System.out.println("t2 dias = " + t2.toDays());
		System.out.println("t3 dias = " + t3.toDays());
		System.out.println("t4 dias = " + t4.toDays());
	}

}

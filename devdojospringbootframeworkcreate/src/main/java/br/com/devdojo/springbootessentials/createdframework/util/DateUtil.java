package br.com.devdojo.springbootessentials.createdframework.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Damiao Ferreira
 * @since 14/03/2020
 */

@Component
public class DateUtil {

	public String formatLocalDateTimeToDatebaseStyle(LocalDateTime localDateTime) {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
	}
}

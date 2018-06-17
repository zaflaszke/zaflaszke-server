package pl.kk.zaflaszke.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Mares
 */
@Component
public class LocalDateConverter {

  @Value("${date.format.pattern}")
  private String pattern;

  public String format(LocalDate date) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
    return date.format(formatter);
  }

  public LocalDate format(String date) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
    return LocalDate.parse(date, formatter);
  }

}

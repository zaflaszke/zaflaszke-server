package pl.kk.zaflaszke.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Marek Kort
 */
@Component
public class LocalDateTimeConverter {

  @Value("${datetime.format.pattern}")
  private String pattern;

  public String format(LocalDateTime date) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
    return date.format(formatter);
  }

  public LocalDateTime format(String date) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
    return LocalDateTime.parse(date, formatter);
  }
}

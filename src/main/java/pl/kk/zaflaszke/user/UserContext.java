package pl.kk.zaflaszke.user;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

/**
 * @author Mares
 */
@Component
@SessionScope
public class UserContext {

  public Long getUserId() {
    return 1L;
  }
}

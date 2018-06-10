package pl.kk.zaflaszke.utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.util.CollectionUtils;

/**
 * Abstract converter, defines which methods should converter must have.
 * 
 * @author Mares
 *
 * @param <T> - object converted from
 * @param <D> - object converted to
 */
public abstract class AbstractConverter<T, D> {

  public abstract D convert(T from);

  public D convertNullSafe(T from) {
    if (from == null) {
      return null;
    }
    return convert(from);
  }

  public List<D> convertAll(List<T> from) {
    if (CollectionUtils.isEmpty(from)) {
      return Collections.emptyList();
    }
    return from.stream().map(this::convert).collect(Collectors.toList());
  }
}

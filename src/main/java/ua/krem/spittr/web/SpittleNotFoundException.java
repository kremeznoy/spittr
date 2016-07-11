package ua.krem.spittr.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Description:
 * <p/>
 * -----------------------------------------------------
 * Created by kremezniy on 4/18/2016.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Spittle not Found")
public class SpittleNotFoundException extends RuntimeException {
}

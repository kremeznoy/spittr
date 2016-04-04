package ua.krem.spittr.data;

/**
 * Description:
 * ====================================
 *
 * @author Sergiy
 * @since 4/4/2016
 */
public interface SpitterRepository {
    Spitter save(Spitter spitter);
    Spitter findByUsername(String username);
}

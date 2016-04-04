package ua.krem.spittr.data;

import org.springframework.stereotype.Component;

/**
 * Description:
 * ====================================
 *
 * @author Sergiy
 * @since 4/4/2016
 */
@Component("spitterrepositoryimpl")
public class SpitterRepositoryImpl implements SpitterRepository {
    @Override
    public Spitter save(Spitter spitter) {
        return spitter;
    }

    @Override
    public Spitter findByUsername(String username) {
        Spitter spitterForReturn = new Spitter(666L, "krem", "xxx", "Se from Impl", "Kre form Impl");
        return spitterForReturn;
    }
}

package ua.krem.spittr.data;

import java.util.List;

/**
 * Description:
 * ====================================
 *
 * @author Sergiy
 * @since 3/31/2016
 */
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
    Spittle findOne(long id);
}

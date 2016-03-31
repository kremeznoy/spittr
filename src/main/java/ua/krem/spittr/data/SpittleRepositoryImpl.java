package ua.krem.spittr.data;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description:
 * ====================================
 *
 * @author Sergiy
 * @since 3/31/2016
 */
@Component("spittlerepositoryimpl")
public class SpittleRepositoryImpl implements SpittleRepository {

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> spittleList = new ArrayList<>();
        for (int i=0; i<count; i++) {
            spittleList.add(new Spittle("Spittle (from IMPL) ID#" + i, new Date()));
        }
        return spittleList;
    }
}

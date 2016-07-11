package ua.krem.spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.krem.spittr.data.Spittle;
import ua.krem.spittr.data.SpittleRepository;

import java.util.List;

/**
 * Description:
 * ====================================
 *
 * @author Sergiy
 * @since 3/31/2016
 */
@Controller
@ComponentScan("ua.krem.spittr.data")
//@RequestMapping(value = "/spittles")
public class SpittleController {
    // Should be 9223372036854775807
    private static final String MAX_LONG_AS_STRING = Long.toString(Long.MAX_VALUE);
    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(value = "/spittles", method = RequestMethod.GET)
    //@RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model) {
        model.addAttribute("spittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 3));
        return "spittles";
    }

    /*@RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam(value = "max", defaultValue = "1000000") long max,
            @RequestParam(value = "count", defaultValue = "3") int count) {

        return spittleRepository.findSpittles(max, count);
    }*/

    @RequestMapping(value = "/spittles/{spittleId}", method = RequestMethod.GET)
    public String spittle(@PathVariable("spittleId") long spittleId, Model model) {
        Spittle spittle = spittleRepository.findOne(spittleId);
        if(spittle == null) {
            throw new SpittleNotFoundException();
        }
        model.addAttribute(spittle);
        return "spittle";
    }
}

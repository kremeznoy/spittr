package ua.krem.spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.krem.spittr.data.SpittleRepository;

/**
 * Description:
 * ====================================
 *
 * @author Sergiy
 * @since 3/31/2016
 */
@Controller
@ComponentScan("ua.krem.spittr.data")
public class SpittleController {
    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(value = "/spittles", method = RequestMethod.GET)
    public String spittles(Model model) {
        model.addAttribute("spittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 3));
        return "spittles";
    }
}

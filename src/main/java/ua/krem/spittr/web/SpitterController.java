package ua.krem.spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.krem.spittr.data.Spitter;
import ua.krem.spittr.data.SpitterRepository;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

/**
 * Description:
 * ====================================
 *
 * @author Sergiy
 * @since 4/4/2016
 */
@Controller
@ComponentScan("ua.krem.spittr")
@RequestMapping("/spitter")
public class SpitterController {
    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new Spitter());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(@RequestPart("profilePicture") MultipartFile profilePicture,
            @ModelAttribute("spitter") @Valid Spitter spitter, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registerForm";
        }
        spitterRepository.save(spitter);
        try {
            profilePicture.transferTo(new File(profilePicture.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finally in file copying to /data/spittr/");
        }
        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model) {
        Spitter spitter = spitterRepository.findByUsername(username);
        model.addAttribute(spitter);
        return "profile";
    }
}

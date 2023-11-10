package by.ahmed.TestProject.util;

import by.ahmed.TestProject.dto.UserDto;
import lombok.experimental.UtilityClass;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@UtilityClass
public class ModelHelper {

    public static void redirectAttributes(RedirectAttributes redirectAttributes, UserDto user) {
        if (user.getUsername() != null) redirectAttributes.addFlashAttribute("username",
                user.getUsername());
    }
}

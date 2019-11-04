package maratische.kotlin.sdktest1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckController {

    @PostMapping("/check")
    public String check(@RequestParam("roomId") Integer roomId,
                        @RequestParam("entrance") Boolean entrance,
                        @RequestParam("keyId") Integer keyId) {
        return "Hello Gradle!";
    }

    @GetMapping("/validate/prime-number")
    public String isNumberPrime(@RequestParam("number") String number) {
        return Integer.parseInt(number) % 2 == 0 ? "Even" : "Odd";
    }

}

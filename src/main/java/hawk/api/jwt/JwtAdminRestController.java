
package hawk.api.jwt;

import hawk.entity.Item;
import hawk.entity.User;
import hawk.form.Search;
import hawk.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

@RestController
public class JwtAdminRestController {

    @Autowired
    ItemRepo itemRepo;

    @GetMapping( value="/api/jwt/admin/freeHosen", produces = "application/json")
    public String dangerHosen() {
        return "{ \"status\": \"umm, are you sure you want to do that? then PUT\" }";
    }

    @PutMapping( value="/api/jwt/admin/freeHosen", produces = "application/json")
    public String freeDasHosen() {
        for (Item item : itemRepo.findAll()) {
            item.setPrice(BigDecimal.valueOf(0));
            itemRepo.save(item);
        }

        return "{ \"status\": \"OK\" }";
    }
}
